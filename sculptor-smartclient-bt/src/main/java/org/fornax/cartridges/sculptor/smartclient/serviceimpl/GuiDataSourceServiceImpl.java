package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;
import org.fornax.cartridges.sculptor.smartclient.domain.FileUpload;
import org.fornax.cartridges.sculptor.smartclient.domain.GuiAlignment;
import org.fornax.cartridges.sculptor.smartclient.domain.GuiDataSource;
import org.fornax.cartridges.sculptor.smartclient.domain.GuiEditorType;
import org.fornax.cartridges.sculptor.smartclient.domain.GuiField;
import org.fornax.cartridges.sculptor.smartclient.domain.GuiFieldType;
import org.fornax.cartridges.sculptor.smartclient.domain.Property;
import org.fornax.cartridges.sculptor.smartclient.exception.PropertyAccessDenied;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.type.BooleanType;
import org.hibernate.type.CollectionType;
import org.hibernate.type.ComponentType;
import org.hibernate.type.CustomType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ManyToOneType;
import org.hibernate.type.OneToOneType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Service;

/**
 * Implementation of GuiDataSourceService.
 */
@Service("guiDataSourceService")
public class GuiDataSourceServiceImpl extends GuiDataSourceServiceImplBase
		implements ApplicationContextAware {
	private static final Logger log=LoggerFactory.getLogger(GuiDataSourceServiceImpl.class);

	private static final String FORCE_START = ":s";
	private static final String GET_PREFIX = "get";
	private static final String SET_PREFIX = "set";
	private static final String TEXT_REF_FIELD = "textRef";
	private static final String Q="\"";
	private static final String JAVASCRIPT_PREFIX="javascript:";
	private static final String TRANSLATE="translate";

	private static final String RELATION_COLUMN_SPAN_LENGTH = "default.relationColumnSpan";
	private static final String TEXTAREA_COLUMN_SPAN_LENGTH = "default.textAreaColumnSpan";

	private List<GuiDataSource> table=new ArrayList<GuiDataSource>();
	private Map<String, String> classToServiceName=null;

	@Autowired
	private PropertySupportFacade propertyFacade;

	private SessionFactory sessionFactory[];
	// private EntityManager entityManager[];

	public GuiDataSource findById(@Name("ctx") ServiceContext ctx, @Name("id") Long id) {
		return table.get(0);
	}

	public List<GuiDataSource> findAll(@Name("ctx") ServiceContext ctx) {
		if (classToServiceName==null) {
			throw new java.lang.IllegalArgumentException("classToServiceTranslation is null");
		}

		table.clear();
		HashMap<String, Class<?>> componentTypes=new HashMap<String, Class<?>>();
		HashMap<String, String> classHash=new HashMap<String, String>();

		for (SessionFactory sessFactory : getSessionFactories()) {
			Map<?, ?> allClassMetadata = sessFactory.getAllClassMetadata();
			for (Object key : allClassMetadata.keySet()) {
				ClassMetadata classMapping=(ClassMetadata) allClassMetadata.get(key);
				if (classHash.containsKey(classMapping.getEntityName())) {
					continue;
				}
				classHash.put(classMapping.getEntityName(), "Y");

				String serviceName = classToServiceName.get(classMapping.getEntityName());
				boolean clientOnly=serviceName == null;
				serviceName = serviceName == null ? classMapping.getEntityName().replaceAll("\\.", "_") : serviceName;
				GuiDataSource guiDataSource = new GuiDataSource(serviceName);
				guiDataSource.setBaseClass(classMapping.getEntityName());
				String[] optionListFields = getTextRefFields(ctx, classMapping.getEntityName(), serviceName);
				guiDataSource.setTitleField(optionListFields[0]);
				try {
					mapClassToDS(ctx, classMapping.getEntityName(), guiDataSource, componentTypes, classToServiceName);
					guiDataSource.setDataFormat("json");
					guiDataSource.setClientOnly(clientOnly);

					table.add(guiDataSource);
				} catch (ClassNotFoundException e) {
					log.warn("Mapping class error: {}", e.getMessage());
				}
			}
		}

		for (String componentKey : componentTypes.keySet()) {
			Class<?> component=componentTypes.get(componentKey);
			log.info("Mapping java class {}", component.getName());
			String entName = component.getName().replaceAll("\\.", "_");
			GuiDataSource guiDataSource = new GuiDataSource(entName);
			guiDataSource.setDataFormat("json");
			guiDataSource.setClientOnly(true);
			guiDataSource.setBaseClass(component.getName());
			table.add(guiDataSource);

			for (Method m : component.getMethods()) {
				if (m.getName().startsWith(GET_PREFIX) && m.getParameterTypes().length == 0) {
					Class<?> returnType=m.getReturnType();
					GuiFieldType guiType;
					if (Class.class.equals(returnType)) {
						guiType=null;
					} else if (Integer.class.equals(returnType) || Long.class.equals(returnType)) {
						guiType=GuiFieldType.IntegerType;
					} else if (Float.class.equals(returnType) || Double.class.equals(returnType) || BigDecimal.class.equals(returnType)) {
						guiType=GuiFieldType.FloatType;
					} else if (Boolean.class.equals(returnType)) {
						guiType=GuiFieldType.BooleanType;
					} else if (String.class.equals(returnType)) {
						guiType=GuiFieldType.TextType;
					} else {
						log.warn("Wrong data type in composite entity {} {}.{}()", new Object[] {returnType.getName(), component.getName(), m.getName()});
						guiType=null;
					}

					if (guiType != null) {
						String attrName = m.getName().substring(GET_PREFIX.length());
						attrName=attrName.substring(0, 1).toLowerCase()+attrName.substring(1);

						GuiField guiField=new GuiField();
						guiField.setName(attrName);
						guiField.setTitle(propertyFacade.translate(attrName));
						guiField.setType(guiType);
						guiDataSource.addField(guiField);
					}
				}
			}
		}

		return table;
	}

	private String getProperty(String path, String propKey, String defaultValue) {
		return propertyFacade.getProperty(path, propKey, defaultValue);
	}

	private Property setProperty(ServiceContext ctx, String propKey, String propValue) throws PropertyAccessDenied {
		Property prop=new Property();
		prop.setPropName(propKey);
		prop.setPropValue(propValue);
		return getPropertyService().save(ctx, prop);
	}

	public void save(@Name("ctx") ServiceContext ctx, @Name("entity") GuiDataSource entity) throws PropertyAccessDenied {
		if (entity.getJsonPostfix() != null && entity.getJsonPostfix().length() > 0) {
			setProperty(ctx, entity.getXxxID()+".jsonPostfix", entity.getJsonPostfix());
		}

		List<GuiField> fields = entity.getFields();
		for (GuiField guiField : fields) {
			if (guiField.getJsonPostfix() != null) {
				setProperty(ctx, entity.getXxxID()+"."+guiField.getName(), guiField.getJsonPostfix());
			}
		}
	}

	/* ###########################################################################
	 * # Read information from Hibernate mapping
	 * ########################################################################### */
	private void mapClassToDS(
			ServiceContext ctx,
			final String persistentClassName,
			GuiDataSource guiDataSource,
			Map<String, Class<?>> componentTypes,
			Map<String, String> serviceMapping) throws ClassNotFoundException {
		List<GuiField> fieldList=new ArrayList<GuiField>();

		GuiField idField=new GuiField();
		idField.setName("id");
		idField.setTitle(propertyFacade.translate("id"));
		idField.setPrimaryKey(true);
		idField.setDetail(true);
		idField.setCanEdit(false);
		idField.setType(GuiFieldType.IntegerType);
		fieldList.add(idField);

		boolean isTree=false;
		int relColSpan=propertyFacade.getPropertyAsInt(RELATION_COLUMN_SPAN_LENGTH, 4);
		int textColSpan=propertyFacade.getPropertyAsInt(TEXTAREA_COLUMN_SPAN_LENGTH, 4);
		String persistentClass = persistentClassName;
		AbstractEntityPersister classMetaData = (AbstractEntityPersister) getClassMetaData(persistentClass);
		log.info("Mapping persistent class {}", persistentClass);
		String[] propNames = classMetaData.getPropertyNames();
		boolean[] isOptional = classMetaData.getPropertyNullability();
		Class<?> realClass = Class.forName(classMetaData.getName());
		while (realClass != null) {
			Field[] declaredFields = realClass.getDeclaredFields();
			for (int i = 0; i < declaredFields.length; i++) {
				String propertyName=declaredFields[i].getName();
				Type type = null;
				int ind=0;
				for (; ind < propNames.length; ind++) {
					if (propNames[ind].equals(propertyName)) {
						type=classMetaData.getPropertyType(propertyName);
						break;
					}
				}
				if (type == null) {
					continue;
				}

				GuiField field=new GuiField();

				String fldName;
				if (propertyName.startsWith(TRANSLATE)) {
					fldName=propertyName.substring(TRANSLATE.length(), TRANSLATE.length() + 1).toLowerCase()+propertyName.substring(TRANSLATE.length()+1);
				} else if (propertyName.startsWith("xxx")) {
					fldName=propertyName.substring(3);
				} else {
					fldName=propertyName;
				}
				field.setName(fldName);
				field.setTitle(propertyFacade.translate(fldName));

				// Make Hint and Hover
				String propPath=getPropertyService().makeLangProperty(ctx, realClass.getSimpleName());
				field.setXxxhint(getPropertyService().getPropertyValue(ctx, propPath, fldName+"Hint", null));
				field.setPrompt(getPropertyService().getPropertyValue(ctx, propPath, fldName+"Hover", null));

				// Primary key
				if (classMetaData.getIdentifierPropertyName().equals(propertyName)) {
					field.setPrimaryKey(true);
				}

				if (isHiddenField(persistentClassName, propertyName)) {
					field.setHidden(true);
				} else if (isReadOnlyField(realClass, persistentClassName, propertyName)
						|| !checkFieldRoleEditable(ctx, guiDataSource, propertyName)) {
					field.setCanEdit(false);
				} else {
					if (i > 25) {
						field.setDetail(true);
					}
					if (!isOptional[ind]) {
						field.setXxxrequired(true);
					}
				}

				int colLength=-1;
				try {
					javax.persistence.Column column = declaredFields[i].getAnnotation(javax.persistence.Column.class);
					colLength=column != null ? column.length() : -1;
				} catch (Exception e1) {
				}

				// Width
				field.setWidth(calculateWidthOfColumn(colLength));

				if (type instanceof IntegerType || type instanceof LongType) {
					field.setType(GuiFieldType.IntegerType);
					field.setTextAlign(field.getCanEdit() != null && field.getCanEdit().equals(false) ? GuiAlignment.left : GuiAlignment.right);
					field.setWidth("100");
					// field.setEditorType(GuiEditorType.SpinnerItem);
				} else if (type instanceof FloatType || type instanceof DoubleType) {
					field.setType(GuiFieldType.FloatType);
					field.setTextAlign(field.getCanEdit() != null && field.getCanEdit().equals(false) ? GuiAlignment.left : GuiAlignment.right);
					field.setWidth("100");
					// field.setEditorType(GuiEditorType.SpinnerItem);
				} else if (type instanceof BooleanType) {
					field.setType(GuiFieldType.BooleanType);
				} else if (type instanceof CollectionType) {
					String assocEntity=null;
					for (SessionFactory sesFact : getSessionFactories()) {
						assocEntity = ((CollectionType) type).getAssociatedEntityName((SessionFactoryImplementor) sesFact);
						if (assocEntity != null) {
							break;
						}
					}
					String assocServiceName=serviceMapping.get(assocEntity);
					if ("org.fornax.cartridges.sculptor.smartclient.domain.FileUpload".equals(assocEntity)) {
						field.setType(GuiFieldType.FileUpload);
						field.setEditorType(GuiEditorType.MultiFileItem);
						guiDataSource.setIsFileUpload(true);
					} else if (assocServiceName != null) {
						field.setType(GuiFieldType.AssociationToMany);
						field.setHidden(true);
						// field.setPropertiesOnly(true);
						field.setMultiple(true);
						field.setEditorType(GuiEditorType.ComboBoxItem);
						field.setOptionDataSource(assocServiceName);
						field.setWidth("*");
						field.setPickListWidth(550);
						field.setValueField("id");
						String[] optionListFields = getTextRefFields(ctx, assocEntity, assocServiceName);
						// field.setDisplayField(TEXT_REF_FIELD);
						field.setDisplayField(optionListFields[0]);
						field.setPickListFields(JAVASCRIPT_PREFIX+"$wnd.Array.create(["+makeOptionList(optionListFields)+"])");
						field.setForeignKey(assocServiceName+".id");
					} else if (assocEntity != null) {
						field.setType(GuiFieldType.AggregationToMany);
						field.setMultiple(true);
						field.setPropertiesOnly(true);
						field.setHidden(true);
						field.setForeignDS(assocEntity.replaceAll("\\.", "_"));
					} else {
						log.warn("Wrong collection type {}", type.getClass().getName());
					}
				} else if (type instanceof ManyToOneType) {
					ManyToOneType manyToOne=(ManyToOneType) type;
					String assocEntity = manyToOne.getAssociatedEntityName();
					String assocServiceName=serviceMapping.get(assocEntity);
					if (declaredFields[i].getType().equals(FileUpload.class)) {
						field.setType(GuiFieldType.FileUpload);
						guiDataSource.setIsFileUpload(true);
					} else if (assocServiceName != null) {
						GuiField valField=new GuiField();
						valField.setName(field.getName()+"_VAL");
						valField.setHidden(true);
						valField.setType(GuiFieldType.TextType);
						fieldList.add(valField);

						field.setType(GuiFieldType.IntegerType);
						field.setEditorType(GuiEditorType.ComboBoxItem);
						field.setDetailOptionDS(assocServiceName);
						field.setWidth("250");
						field.setIcon("link.png");
						field.setAlign("left");
						field.setFormatCellValue("function (value) { if (value) { return '<u>'+value+'</u>'; } }");
						field.setPickListWidth(550);
						field.setValueField("id");
						// field.setStartRow(true);
						// field.setEndRow(true);
						field.setColSpan(relColSpan);
						String[] optionListFields = getTextRefFields(ctx, assocEntity, assocServiceName);
						field.setFilterEditorProperties(JAVASCRIPT_PREFIX+"{optionDataSource: '"+assocServiceName+"', displayField: null, getDisplayFieldName: function() {return '"+optionListFields[0]+"'}}");
						field.setDisplayField(field.getName()+"_VAL");
						field.setPickListFields(JAVASCRIPT_PREFIX+"$wnd.Array.create(["+makeOptionList(optionListFields)+"])");
						// field.setForeignKey(service.serviceName+".id");
						if (!isTree && persistentClassName.equals(assocEntity) && "parent".equals(fldName)) {
							field.setForeignKey("id");
							field.setDetail(true);
							isTree=true;
							guiDataSource.setIsTree(true);
						}
						// field.setXxxhint("(PRAZDNY)");
						// field.setChanged("item.setHint(item.getSelectedRecord() != null ? item.getSelectedRecord()['"+TEXT_REF_FIELD+"'].replaceAll(' ','&nbsp;') : '(PRAZDNY)')");
					} else {
						field.setType(GuiFieldType.AggregationToOne);
						field.setHidden(true);
						field.setPropertiesOnly(true);
						field.setXxxrequired(false);
						field.setForeignDS(assocEntity.replaceAll("\\.", "_"));
					}
				} else if (type instanceof OneToOneType) {
					OneToOneType oneToOne=(OneToOneType) type;
					String assocEntity = oneToOne.getAssociatedEntityName();
					String assocServiceName=serviceMapping.get(assocEntity);
					if (declaredFields[i].getType().equals(FileUpload.class)) {
						field.setType(GuiFieldType.FileUpload);
						guiDataSource.setIsFileUpload(true);
					} else if (assocServiceName != null) {
						GuiField valField=new GuiField();
						valField.setName(field.getName()+"_VAL");
						valField.setHidden(true);
						valField.setType(GuiFieldType.TextType);
						fieldList.add(valField);

						field.setType(GuiFieldType.IntegerType);
						field.setPropertiesOnly(false);
						field.setEditorType(GuiEditorType.ComboBoxItem);
						field.setDetailOptionDS(assocServiceName);
						field.setWidth("250");
						field.setIcon("link.png");
						field.setAlign("left");
						field.setFormatCellValue("function (value) { if (value) { return '<u>'+value+'</u>'; } }");
						field.setPickListWidth(550);
						field.setValueField("id");
						// field.setStartRow(true);
						// field.setEndRow(true);
						field.setColSpan(relColSpan);
						// field.setDisplayField(TEXT_REF_FIELD);
						// field.setDisplayField(optionListFields[0]);
						String[] optionListFields = getTextRefFields(ctx, assocEntity, assocServiceName);
						field.setFilterEditorProperties("{optionDataSource: '"+assocServiceName+"', displayField: null, getDisplayFieldName: function() {return '"+optionListFields[0]+"'}}");
						field.setDisplayField(field.getName()+"_VAL");
						field.setPickListFields(JAVASCRIPT_PREFIX+"$wnd.Array.create(["+makeOptionList(optionListFields)+"])");
						field.setForeignKey(assocServiceName+".id");
						// field.setXxxhint("(PRAZDNY)");
						// field.setChanged("item.setHint(item.getSelectedRecord() != null ? item.getSelectedRecord()['"+TEXT_REF_FIELD+"'].replaceAll(' ','&nbsp;') : '(PRAZDNY)')");
					} else {
						field.setType(GuiFieldType.AggregationToOne);
						field.setHidden(true);
						field.setPropertiesOnly(true);
						field.setForeignDS(assocEntity.replaceAll("\\.", "_"));
					}
				} else if (type instanceof DateType) {
					field.setType(GuiFieldType.DateType);
				} else if (type instanceof TimestampType) {
					field.setType(GuiFieldType.DateTimeType);
				} else if (type instanceof CustomType) {
					field.setType(GuiFieldType.TextType);
					CustomType custType=(CustomType) type;
					if (custType.getReturnedClass().isEnum()) {
						Object[] enumConstants = custType.getReturnedClass().getEnumConstants();
						String dlm="";
						StringBuilder valueMap=new StringBuilder();
						for (Object enumConst : enumConstants) {
							Enum<?> enm=(Enum<?>) enumConst;
							String tsPath=getPropertyService().makeLangProperty(ctx, custType.getReturnedClass().getSimpleName());
							String trName=getPropertyService().getPropertyValue(ctx, tsPath, enm.name(), null);
							trName = trName == null ? getPropertyService().translate(ctx, enm.name()) : trName;
							valueMap.append(dlm).append(enm.name()).append(": ").append(Q).append(trName).append(Q);
							dlm=", ";
						}
						field.setValueMap(JAVASCRIPT_PREFIX+"{"+valueMap.toString()+"}");
						field.setWidth("212");
						//field.setEditorType(GuiEditorType.RadioGroupItem);
					}
				} else if (type instanceof ComponentType) {
					componentTypes.put(type.getReturnedClass().getName(), type.getReturnedClass());
					field.setType(GuiFieldType.AggregationToOne);
					field.setDetail(true);
					field.setPropertiesOnly(true);
					field.setHidden(true);
					field.setForeignDS(type.getReturnedClass().getName().replaceAll("\\.", "_"));
				} else {
					field.setType(GuiFieldType.TextType);
					if (colLength > 100) {
						field.setDetail(true);
						field.setWidth("*");
						field.setXxxlength(colLength);
						field.setEditorType(GuiEditorType.TextAreaItem);
						field.setStartRow(true);
						field.setEndRow(true);
						field.setColSpan(textColSpan);
					} else if (colLength > 0) {
						field.setXxxlength(colLength);
					} else {
						field.setXxxlength(30);
					}
				}
				fieldList.add(field);
			}
			realClass=realClass.getSuperclass();
			realClass=realClass.equals(Object.class) ? null : realClass;
		}

		String[] textRefFields = getTextRefFields(ctx, persistentClassName, guiDataSource.getXxxID());
		StringBuilder assocGetVal=new StringBuilder();
		if (textRefFields.length == 1) {
			assocGetVal.append("record.").append(textRefFields[0]);
		} else if (textRefFields.length == 2) {
			assocGetVal.append("record.").append(textRefFields[1]);
		} else {
			String delC="'";
			for (int k = 1; k < textRefFields.length; k++) {
				if (!isHiddenOrReadOnlyField(realClass, persistentClassName, textRefFields[k])) {
					assocGetVal.append(delC).append(makeFieldName(ctx, textRefFields[k])).append(": '").append("+record.").append(textRefFields[k]);
					delC="+', ";
				}
			}
		}

		if (assocGetVal.length() > 0) {
			GuiField textRefField=new GuiField();
			textRefField.setName(TEXT_REF_FIELD);
			textRefField.setType(GuiFieldType.TextType);
			textRefField.setCanEdit(false);
			textRefField.setHidden(true);
			// textRefField.setPropertiesOnly(true);
			textRefField.setGetFieldValue(JAVASCRIPT_PREFIX+" function(record, value, field, fieldName) { return "+assocGetVal+";}");
			fieldList.add(textRefField);
		}

		// Order fields
		String fieldOrder = getProperty(guiDataSource.getXxxID(), "fieldOrder", null);
		if (fieldOrder != null) {
			List<GuiField> realFields = guiDataSource.getFields();
			String[] orderFields=fieldOrder.split("[, ]");
			boolean hasId = false;
			for (String orderField : orderFields) {
				if (!checkFieldRole(ctx, guiDataSource, orderField) || orderField.length() == 0) {
					continue;
				}
				if (orderField.equalsIgnoreCase("id")) {
					hasId = true;
				}
				boolean forceStart=false;
				if (orderField.endsWith(FORCE_START)) {
					orderField=orderField.substring(0, orderField.length() - FORCE_START.length());
					forceStart=true;
				}
				boolean fieldExist=false;
				for (GuiField guiField : fieldList) {
					if (guiField.getName().equalsIgnoreCase(orderField)) {
						guiField.setDetail(false);
						realFields.add(guiField);
						fieldExist=true;
						if (forceStart) {
							guiField.setStartRow(true);
						}
						break;
					}
				}
				if (!fieldExist) {
					// TODO review (aby sa mohli pridavat do formularov nove typy itemov - BlurbItem, HeaderItem, SpacerItem)
					String fldKey=orderField+".jsonPostfix";
					String fldPostfix = getProperty(guiDataSource.getXxxID(), fldKey, null);
					if (fldPostfix != null) {
						GuiField ext = new GuiField();
						ext.setName(orderField);
						ext.setDetail(true);
						ext.setHidden(true);  // must be enabled and override trough jsonPostfix
						realFields.add(ext);
					} else {
						log.warn("Field '{}' doesn't exist in '{}'", orderField, guiDataSource.getXxxID());
					}
				}
			}
			if (!hasId) {
				for (GuiField guiField : fieldList) {
					if (guiField.getName().equalsIgnoreCase("id")) {
						realFields.add(guiField);
						break;
					}
				}
			}
		} else {
			GuiField[] guiArray=fieldList.toArray(new GuiField[fieldList.size()]);
			Arrays.sort(guiArray, new Comparator<GuiField>() {
				public int compare(GuiField f1, GuiField f2) {
					// Narrow values
					boolean f1val=true;
					boolean f2val=true;
					if (f1.getCanEdit() != null) {
						f1val=f1.getCanEdit();
					}
					if (f2.getCanEdit() != null) {
						f2val=f2.getCanEdit();
					}

					int retVal;
					if (f1val == f2val) {
						retVal=0;
					} else if (f1val) {
						retVal=-1;
					} else {
						retVal=1;
					}

					return retVal;
				}
			});

			List<GuiField> realFields = guiDataSource.getFields();
			boolean wasBreak=false;
			for (GuiField fld : guiArray) {
				if (!wasBreak && fld.getCanEdit() != null && fld.getCanEdit() == false) {
					fld.setStartRow(true);
					wasBreak=true;
				}
				if (checkFieldRole(ctx, guiDataSource, fld.getName())) {
					realFields.add(fld);
				}
			}
		}

		// Mixin jsonPostfix
		String dsPostfix = getProperty(guiDataSource.getXxxID(), "jsonPostfix", null);
		if (dsPostfix != null) {
			guiDataSource.setJsonPostfix(dsPostfix);
		}
		List<GuiField> realFields = guiDataSource.getFields();
		for (GuiField fld : realFields) {
			String fldKey=fld.getName()+".jsonPostfix";
			String fldPostfix = getProperty(guiDataSource.getXxxID(), fldKey, null);
			if (fldPostfix != null) {
				fld.setJsonPostfix(fldPostfix);
			}
		}
	}

	private boolean checkFieldRole(ServiceContext ctx, GuiDataSource guiDataSource, String field) {
		boolean retval = true;
		String fldKey=field+".ifRole";
		String visibleForRoles = getProperty(guiDataSource.getXxxID(), fldKey, null);
		if (visibleForRoles != null) {
			retval = isUserInAnyRole(visibleForRoles.split(","));
		}
		return retval;
	}

	private boolean checkFieldRoleEditable(ServiceContext ctx, GuiDataSource guiDataSource, String field) {
		boolean retval = true;
		String roKey=field+".editable";
		String roForRoles = getProperty(guiDataSource.getXxxID(), roKey, null);
		if (roForRoles != null) {
			retval = isUserInAnyRole(roForRoles.split(","));
		}
		return retval;
	}

	public boolean isUserInAnyRole(String ... anyRoles) {
		ServiceContext ctx = ServiceContextStore.get();
		for (String assRole : anyRoles) {
			if (ctx.isUserInRole(assRole)) {
				return true;
			}
		}
		return false;
	}

	/* ###########################################################################
	 * # Supporting methods
	 * ########################################################################### */
	private boolean isHiddenOrReadOnlyField(Class<?> realClass, String owningClass, String fieldName) {
		return isReadOnlyField(realClass, owningClass, fieldName) || isHiddenField(owningClass, fieldName);
	}

	private String[] roFields={"createdDate", "createdBy", "lastUpdated", "lastUpdatedBy", "version", "id", "status"};
	private boolean isReadOnlyField(Class<?> realClass, String owningClass, String fieldName) {
		String fullName=owningClass+"."+fieldName;
		for (String readOnlyField : roFields) {
			if (readOnlyField.equals(fieldName) || readOnlyField.equals(fullName) ) {
				return true;
			}
		}
//	TODO support for ValueObject
//		try {
//			if (realClass != null) {
//				String getterName=GET_PREFIX+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
//				String setterName=SET_PREFIX+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
//				Class<?> returnType = realClass.getMethod(getterName, (Class<?> []) null).getReturnType();
//				if (realClass.getMethod(setterName, new Class<?>[] {returnType}) != null) {
//					return false;
//				}
//			}
//		} catch (Exception e) {
//			return true;
//		}
		return false;
	}

	private String[] hiddenFields={"uuid", "key"};
	private boolean isHiddenField(String owningClass, String fieldName) {
		String fullName=owningClass+"."+fieldName;
		for (String hiddenField : hiddenFields) {
			if (hiddenField.equals(fieldName) || hiddenField.equals(fullName)) {
				return true;
			}
		}
		return false;
	}

	private ClassMetadata getClassMetaData(String entityName) {
		ClassMetadata classMetaData=null;
		for (SessionFactory localSession : getSessionFactories()) {
			classMetaData = localSession.getClassMetadata(entityName);
			if (classMetaData != null) {
				break;
			}
		}
		return classMetaData;
	}

	private SessionFactory[] getSessionFactories() {
		if (sessionFactory == null) {
			synchronized (GuiDataSourceServiceImpl.class) {
				if (sessionFactory == null) {
					ApplicationContext appContext = getApplicationContext();
					String[] entityFactoryNames = appContext.getBeanNamesForType(EntityManagerFactory.class);
					sessionFactory=new SessionFactory[entityFactoryNames.length];
					int i=0;
					for (String entityFactoryName : entityFactoryNames) {
						Object bean = appContext.getBean(entityFactoryName);
						EntityManagerFactoryInfo em=(EntityManagerFactoryInfo) bean;
						EntityManagerFactoryImpl mFact=(EntityManagerFactoryImpl) em.getNativeEntityManagerFactory();
						sessionFactory[i++] = mFact.getSessionFactory();
					}
				}
			}
		}

		return sessionFactory;
	}

	private String calculateWidthOfColumn(int length) {
		String width=null;

		if (length <= 5) {
			width="50";
		} else if (length <=10) {
			width="100";
		} else if (length <=15) {
			width="150";
		} else if (length <=30) {
			width="200";
		} else if (length <=50) {
			width="280";
		} else if (length <=100) {
			width="350";
		} else if (length == 255) {
			width=null;
		} else if (length > 100) {
			width="*";
		}
		return width;
	}

	public String makeOptionList(String [] fields) {
		StringBuilder pickList=new StringBuilder();
		String delim="";
		for (String field : fields) {
			pickList.append(delim).append("{name: \"").append(field).append("\"}");
			delim=", ";
		}

		return pickList.toString();
	}

	private String[] getTextRefFields(ServiceContext ctx, String entityName, String serviceName) {
		String textRef = getProperty(null, serviceName+".textRef", null);

		if (textRef == null) {
			StringBuilder strB=new StringBuilder();
			List<String> meaningfulFields = getMeaningfulFields(entityName);
			String delim="";
			for (int i=0; i < 5 && i < meaningfulFields.size(); i++) {
				strB.append(delim).append(meaningfulFields.get(i));
				delim=",";
			}
			textRef = getProperty(null, serviceName+".textRef", strB.toString());
		}

		String[] fields = textRef.split("[, ]");
		ArrayList<String> result = new ArrayList<String>();
		for (String f : fields) {
			if (f.length() != 0) {
				result.add(f);
			}
		}
		if (result.size() == 0) {
			result.add("id");
		}

		return result.toArray(new String[result.size()]);
	}

	private List<String> getMeaningfulFields(String entityName) {
		LinkedList<String> fldList=new LinkedList<String>();
		ClassMetadata assocClass=getClassMetaData(entityName);
		int priority=6;
		int lastPriority=priority;
		while (assocClass != null) {
			String[] propNames = assocClass.getPropertyNames();
			for (int i = 0; i < propNames.length; i++) {
				Type propType = assocClass.getPropertyType(propNames[i]);
				if (!isHiddenOrReadOnlyField(null, assocClass.getEntityName(), propNames[i])
						&& (propType instanceof StringType
							|| propType instanceof StringType
							|| propType instanceof IntegerType
							|| propType instanceof FloatType
							|| propType instanceof DoubleType
							|| propType instanceof DateType
							|| propType instanceof TimestampType
							)) {
					if (propNames[i].equalsIgnoreCase("name")) {
						priority=1;
					} else if (priority > 2 && propNames[i].equalsIgnoreCase("title")) {
						priority=2;
					} else if (priority > 3 && propNames[i].toUpperCase().indexOf("NAME") != -1) {
						priority=3;
					} else if (priority > 4 && propType instanceof StringType) {
						priority=4;
					} else if (priority > 5) {
						priority=5;
					}
					if (lastPriority != priority) {
						fldList.addFirst(propNames[i]);
						lastPriority=priority;
					} else {
						fldList.addLast(propNames[i]);
					}
				}
			}
			// assocClass=assocClass.getSuperclass();
			assocClass=null;
		}

		return fldList;
	}

	private String makeFieldName(ServiceContext ctx, String propName) {
		if (propName.startsWith(GET_PREFIX) || propName.startsWith(SET_PREFIX)) {
			propName=propName.substring(SET_PREFIX.length());
		}
		String retVal=getProperty(null, propName, null);
		if (retVal == null) {
			retVal=propName.substring(0, 1).toUpperCase() + propName.substring(1).replaceAll("(\\p{Upper})", " $1");
		}

		return retVal;
	}

	public void setServiceMapping(ServiceContext ctx, Map<String, String> serviceMapping) {
		this.classToServiceName=serviceMapping;
	}

	/* ###########################################################################
	 * # Methods for IoC
	 * ########################################################################### */
	ApplicationContext applicationContext=null;
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext=applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
