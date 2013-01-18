package org.fornax.cartridges.sculptor.smartclient.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.fornax.cartridges.sculptor.framework.annotation.GuiHints;
import org.fornax.cartridges.sculptor.framework.annotation.IfRole;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.DetailBehavior;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.VisibleOn;
import org.fornax.cartridges.sculptor.framework.domain.PagedResult;
import org.fornax.cartridges.sculptor.framework.domain.PagingParameter;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.smartclient.serviceimpl.PropertySupportFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;

public class ServiceDescription {
	private static final Logger log=LoggerFactory.getLogger(ServiceDescription.class.getName());

	public ServiceDescription(String beanName, Object bean, PropertySupportFacade propSupport) throws SecurityException, NoSuchMethodException {
		name=beanName;
		instance=bean;
		otherMethods=new HashMap<String, MethodDescription>();

		bean.getClass().getMethod("findById", ServiceContext.class, Long.class);

		log.trace("Investigating service {}", beanName);
		Method[] methods = bean.getClass().getMethods();
		Class<?> originClass = AopUtils.getTargetClass(bean);
		Method[] originMethods = originClass.getMethods();
		for (Method m : methods) {
			if (!m.getDeclaringClass().equals(Object.class)) {
				String methodName=m.getName();
				Class<?>[] methodParams = m.getParameterTypes();
				if (methodName.equals("findAll") 
						&& methodParams.length == 1
						&& methodParams[0].equals(ServiceContext.class)
						&& List.class.isAssignableFrom(m.getReturnType())) {
					findAll=m;
				} else if (methodName.equals("findAll") 
						&& methodParams.length == 2
						&& methodParams[0].equals(ServiceContext.class)
						&& methodParams[1].equals(PagingParameter.class)
						&& m.getReturnType().equals(PagedResult.class)) {
					findAll=m;
				} else if (methodName.equals("findById")
						&& methodParams.length == 2
						&& methodParams[0].equals(ServiceContext.class)
						&& methodParams[1].equals(Long.class)
						&& !m.getReturnType().equals(void.class)) {
					findById=m;
				} else if (methodName.equals("equals") || methodName.equals("hashCode") || methodName.equals("toString")) {
				} else {
					MethodDescription methodDescr=new MethodDescription();
					methodDescr.method=m;
					methodDescr.title=beanName + "." + m.getName();
					methodDescr.name=m.getName();

					Method originM=null;
					for (Method originMethod : originMethods) {
						if (originMethod.getName().equals(methodName)) {
							originM=originMethod;
							break;
						}
					}
					if (originM == null) {
						continue;
					}

					GuiHints guiHints = originM.getAnnotation(GuiHints.class);
					if (guiHints != null && guiHints.visibleOn().equals(VisibleOn.HIDDEN)) {
						continue;
					}

					String [] paramNames=extractNameAnnotation(originM);
					if (paramNames == null || paramNames.length != m.getParameterTypes().length) {
						log.warn("Method {} doesn''t have @Name annotation on all parameters", methodDescr.name);
						log.warn("If you want get rid of this warning sign method explicitly with @GuiHints(visibleOn=VisibleOn.HIDDEN)");
						continue;
					}
					methodDescr.parameterNames=paramNames;

					// IfStatus GUI hint
					if (guiHints != null && guiHints.ifStatus().length() > 0) {
						methodDescr.ifStatus=guiHints.ifStatus().split("[ ,;:]");
					}
					methodDescr.ifStatus=readAnnotFromProperty("ifStatus", originM, methodDescr.ifStatus, propSupport);

					// VisibleForRoles GUI hint
					if (guiHints != null && guiHints.ifRole().length() > 0) {
						methodDescr.ifRole=guiHints.ifRole().split("[ ,;:]");
					}
					methodDescr.ifRole=readAnnotFromProperty("ifRole", originM, methodDescr.ifRole, propSupport);

					// VisibleForRoles GUI hint
					if (guiHints != null && guiHints.requireConfirmation()) {
						methodDescr.requireConfirmation=true;
					}

					// doAction property
					String doActionKey=originM.getDeclaringClass().getName()+"."+originM.getName()+"@doAction";
					methodDescr.doAction=propSupport.getProperty(doActionKey);

					// VisibleOn GUI hint
					String[] visibleOn=readAnnotFromProperty("visibleOn", originM, null, propSupport);
					if (guiHints != null) {
						methodDescr.visibleOn = guiHints.visibleOn();
					} else if (visibleOn != null && visibleOn.length > 0) {
						methodDescr.visibleOn = VisibleOn.valueOf(visibleOn[0]);
					} else if (methodName.startsWith("find")) {
						methodDescr.visibleOn = VisibleOn.HIDDEN;
					} else if (
							paramNames.length == 0
							|| (paramNames.length == 1 && originM.getParameterTypes()[0].equals(ServiceContext.class))
							|| (paramNames.length == 1 && paramNames[0].equalsIgnoreCase("id") && originM.getParameterTypes()[0].equals(Long.class))
							|| (paramNames.length == 2 && originM.getParameterTypes()[0].equals(ServiceContext.class)
								&& paramNames[1].equalsIgnoreCase("id") && originM.getParameterTypes()[1].equals(Long.class))
							|| (paramNames.length == 2 && originM.getParameterTypes()[0].equals(ServiceContext.class)
									&& paramNames[1].equalsIgnoreCase("ids") && originM.getParameterTypes()[1].equals(List.class)) ) {
						methodDescr.visibleOn = VisibleOn.ON_LIST;
					} else {
						methodDescr.visibleOn = VisibleOn.ON_DETAIL;
					}

					// DetailBehavior GUI hint
					String[] detailBehavior=readAnnotFromProperty("detailBehavior", originM, null, propSupport);
					if (guiHints != null) {
						methodDescr.detailBehavior = guiHints.detailBehavior();
					} else if (detailBehavior != null && detailBehavior.length > 0) {
						methodDescr.detailBehavior = DetailBehavior.valueOf(detailBehavior[0]);
					} else if (methodName.equals("save")) {
						methodDescr.detailBehavior=DetailBehavior.ON_EDIT_NEW;
					} else {
						methodDescr.detailBehavior = DetailBehavior.ON_VIEW;
					}

					// jsonPostfix
					String propName = beanName+"."+originM.getName()+".jsonPostfix";
					methodDescr.jsonPostfix = propSupport.getProperty(propName);
					if (methodDescr.jsonPostfix == null || methodDescr.jsonPostfix.length() == 0) {
						propName = originM.getName()+".jsonPostfix";
						methodDescr.jsonPostfix = propSupport.getProperty(propName);
					}

					otherMethods.put(methodName, methodDescr);
					log.trace("Found method {}", methodDescr);
				}
			}
		}
		if (findById == null) {
			throw new NoSuchMethodException("Method 'Entity findById(ServiceContext, Long)' not available in bean '"+beanName+"'");
		}
		if (findAll == null) {
			throw new NoSuchMethodException("Method 'List<Entity> findAll(ServiceContext[, PagingParameter])' not available in bean '"+beanName+"'");
		}

		IfRole visibleFor = (IfRole) originClass.getAnnotation(IfRole.class);
		if (visibleFor != null && visibleFor.value() != null) {
			visibleForRoles=visibleFor.value().split("[,;: ]");
		}
		visibleForRoles=readAnnotFromProperty("ifRole", originClass, visibleForRoles, propSupport);

		expectedClass=findById.getReturnType();

		String beanPackage = expectedClass.getName();
		int dotOffset=beanPackage.lastIndexOf(".");
		String cat;
		if (dotOffset == -1) {
			cat="unknown";
		} else {
			cat=beanPackage.substring(0, dotOffset);
		}
		category = propSupport.getProperty(name+".tab", cat);
	}

	private String[] extractNameAnnotation(Method originMethod) {
		for (Class<?> mainClass=originMethod.getDeclaringClass(); mainClass != null; mainClass=mainClass.getSuperclass() == Object.class ? null : mainClass.getSuperclass()) {
			for (Class<?> iface : mainClass.getInterfaces()) {
				try {
					Method ifaceMethod = iface.getDeclaredMethod(originMethod.getName(), originMethod.getParameterTypes());
					int annotCount=0;
					String[] paramNames=new String[ifaceMethod.getParameterTypes().length];
					Annotation[][] paramAnnot = ifaceMethod.getParameterAnnotations();
					for (int i=0; i < paramAnnot.length; i++) {
						Annotation[] annotations = paramAnnot[i];
						for (int j = 0; j < annotations.length; j++) {
							Annotation annotation = annotations[j];
							if (annotation instanceof Name) {
								paramNames[i]=((Name) annotation).value();
								paramNames[i]=paramNames[i].startsWith("xxx") ? paramNames[i].substring(3) : paramNames[i];
								annotCount++;
								break;
							}
						}
					}
					if (annotCount == paramNames.length) {
						return paramNames;
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// Method isn't in this interface, try next one
				}
			}
		}
		return null;
	}

	public Method getFindAll() {
		return findAll;
	}

	public Method getFindById() {
		return findById;
	}

	public Class<?> getExpectedClass() {
		return expectedClass;
	}

	public Object getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String serviceName) {
		this.name=serviceName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category=category;
	}

	public String[] getVisibleForRoles() {
		return visibleForRoles;
	}

	public void setVisibleForRoles(String[] visibleForRoles) {
		this.visibleForRoles=visibleForRoles;
	}

	public HashMap<String, MethodDescription> getOtherMethods() {
		return otherMethods;
	}

	private static String[] readAnnotFromProperty(String annotationType, Class<?> clazz, String[] existingAnnot, PropertySupportFacade propSupport) {
		String[] classAnot = readAnnotFromProperty(clazz.getName()+"@"+annotationType, existingAnnot, propSupport);
		return readAnnotFromProperty(clazz.getPackage().getName()+"@"+annotationType, classAnot, propSupport);
	}

	private static String[] readAnnotFromProperty(String annotationType, Method method, String[] existingAnnot, PropertySupportFacade propSupport) {
		String propName=method.getDeclaringClass().getName()+"."+method.getName()+"@"+annotationType;
		String[] methodAnnot = readAnnotFromProperty(propName, existingAnnot, propSupport);

		propName=method.getDeclaringClass().getPackage().getName()+"."+method.getName()+"@"+annotationType;
		return readAnnotFromProperty(propName, methodAnnot, propSupport);
	}

	private static String[] readAnnotFromProperty(String key, String[] existingAnnot, PropertySupportFacade propSupport) {
		String newAnnotProp = propSupport.getProperty(key);
		String[] newAnnot=newAnnotProp != null ? newAnnotProp.split("[ ,;:]") : null;

		if (existingAnnot == null || existingAnnot.length == 0) {
			return newAnnot;
		} else if (newAnnot == null || newAnnot.length == 0) {
			return existingAnnot;
		} else {
			String[] mergedAnnot = new String[existingAnnot.length + newAnnot.length];
			System.arraycopy(existingAnnot, 0, mergedAnnot, 0, existingAnnot.length);
			System.arraycopy(newAnnot, 0, mergedAnnot, existingAnnot.length, newAnnot.length);
			return mergedAnnot;
		}
	}

	private Method findAll;
	private Method findById;
	private Class<?> expectedClass;
	private Object instance;
	private String name;
	private String category;
	private String[] visibleForRoles;
	private HashMap<String, MethodDescription> otherMethods;
}
