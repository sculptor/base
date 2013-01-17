/*
 * (C) Copyright Factory4Solutions a.s. 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.smartclient.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.fileupload.FileItem;
import org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteria;
import org.fornax.cartridges.sculptor.framework.annotation.Name;
import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PagedResult;
import org.fornax.cartridges.sculptor.framework.domain.PagingParameter;
import org.fornax.cartridges.sculptor.framework.errorhandling.ApplicationException;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;
import org.fornax.cartridges.sculptor.framework.errorhandling.ValidationException;
import org.fornax.cartridges.sculptor.smartclient.client.Main;
import org.fornax.cartridges.sculptor.smartclient.domain.FileUpload;
import org.fornax.cartridges.sculptor.smartclient.domain.GuiDataSource;
import org.fornax.cartridges.sculptor.smartclient.domain.ListSettings;
import org.fornax.cartridges.sculptor.smartclient.framework.MethodDescription;
import org.fornax.cartridges.sculptor.smartclient.framework.ServiceDescription;
import org.fornax.cartridges.sculptor.smartclient.framework.Translatable;
import org.fornax.cartridges.sculptor.smartclient.quartz.ServiceInvoker;
import org.fornax.cartridges.sculptor.smartclient.server.jsparser.JavaScriptDataParser;
import org.fornax.cartridges.sculptor.smartclient.server.util.Config;
import org.fornax.cartridges.sculptor.smartclient.server.util.UnifiedFormatter;
import org.fornax.cartridges.sculptor.smartclient.serviceapi.FileUploadService;
import org.fornax.cartridges.sculptor.smartclient.serviceapi.GuiDataSourceService;
import org.fornax.cartridges.sculptor.smartclient.serviceapi.ListSettingsService;
import org.fornax.cartridges.sculptor.smartclient.serviceapi.ServiceRegistryService;
import org.fornax.cartridges.sculptor.smartclient.serviceimpl.PropertySupportFacade;
import org.hibernate.validator.InvalidValue;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;

/**
 * Primary server side request handler. Spring servlet.
 * 
 * @author Ing. Pavel Tavoda
 */
@SuppressWarnings("unchecked")
public class ScServlet implements HttpRequestHandler, ServiceInvoker {
	private static final String GET_TRANSLATE = "getTranslate";
	private static final int GET_TRANSLATE_LENGTH = GET_TRANSLATE.length();
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(ScServlet.class.getName());

	private static final int DEF_DEPTH=3;
	private static final int LOOK_AHEAD=30;
	private static final String LIST_SETTINGS_SERVICE="listSettingsService";
	// private static final SimpleDateFormat dateTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	private static final String SET_PREFIX="set";
	private static final String GET_PREFIX="get";
	private static final String READ_ONLY=" (READ-ONLY)";
	private ThreadLocal<String> sessionId=new ThreadLocal<String>();
	private HashMap<String, String> ds2Ref=new HashMap<String, String>();

	@Autowired
	private UploadServlet uploadServlet;

	@Autowired
	private FileUploadService fileUploadService;

	{
		try {
			LogManager.getLogManager().readConfiguration(ScServlet.class.getResourceAsStream("log-"+Config.getEnvironment()+".properties"));
		} catch (Exception e) {
			System.err.println("Can not initialize logging system");
			e.printStackTrace();
		}

		UnifiedFormatter formatter=new UnifiedFormatter();

		// Set formatter
		String property = LogManager.getLogManager().getProperty("unifiedFormatter.loggers");
		property = property == null ? "" : property;
		String[] loggers=property.split("[,:;]");
		for (int i = 0; i < loggers.length; i++) {
			Logger rootLogger = Logger.getLogger(loggers[i]);
			Handler[] handlers = rootLogger.getHandlers();
			System.out.println("Installing unified formmater for "+rootLogger.getName()+" ["+handlers.length+"]");
			for (int j=0; j < handlers.length; j++) {
				handlers[j].setFormatter(formatter);
			}
		}
	}

	
	public ScServlet() throws ServletException {
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			printRequest(request);

			sessionId.set(request.getSession().getId());
			String dataSource = request.getParameter("_dataSource");

			// List grid export
			if ("export".equals(request.getParameter("_operationType"))) {
				exportData(dataSource, response);
				return;
			}

			response.setContentType("text/plain;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Expires", "-1");

			if ("getMenu".equals(dataSource)) {
				response.getWriter().write(listServices());
			} else if ("userInfo".equals(dataSource)) {
				ServiceContext ctx = ServiceContextStore.get();
				PrintWriter out = response.getWriter();
				out.print(ctx.getUserId());
				for(String role : ctx.getRoles()) {
					out.print(",");
					out.print(role);
				}
				out.flush();
			} else if ("createDataSource".equals(dataSource)) {
				HashMap<String, String> classToServiceName=new HashMap<String, String>();
				for (ServiceDescription serviceDesc : getServiceDescription()) {
					log.log(Level.INFO, "Service translation from {0} to {1}", new Object[] {serviceDesc.getExpectedClass().getName(), serviceDesc.getName()});
					classToServiceName.put(serviceDesc.getExpectedClass().getName(), serviceDesc.getName());
				}
				GuiDataSourceService dataSourceService = getGuiDataSourceService();
				dataSourceService.setServiceMapping(ServiceContextStore.get(), classToServiceName);

				StringBuilder output=new StringBuilder();
				output.append("dataSources###");
				List<GuiDataSource> allDataSources = dataSourceService.findAll(ServiceContextStore.get());
				for (GuiDataSource dataSourceDef : allDataSources) {
					ds2Ref.put(dataSourceDef.getBaseClass(), dataSourceDef.getTitleField());
					dataSourceDef.setBaseClass(null);
					log.log(Level.INFO, "Entity def for {0}", dataSourceDef.getXxxID());
					dataSourceDef.setDataURL(getServiceUrl(request));

					output.append("$wnd.isc.RestDataSource.create(")
						.append(mapObjToOutput(dataSourceDef, 6, new Stack<Object>(), true, false))
						.append(");\n");
				}

				ListSettingsService listInstance = (ListSettingsService) findService(LIST_SETTINGS_SERVICE).getInstance();
				List<ListSettings> guiList=listInstance.findUserSettings(ServiceContextStore.get());
				for (ListSettings listSettings : guiList) {
					output.append("\n###").append(listSettings.getListID()).append("###").append(listSettings.getSettings());
				}

				log.log(Level.INFO,"Create datasource {0}", output.toString());
				response.getWriter().append(output);

			} else if (findService(dataSource) != null) {
				ServiceDescription serviceDesc = findService(dataSource);
				String operationType = request.getParameter("_operationType");
				String methodName=request.getParameter("_operationId");

				if (methodName != null && !methodName.endsWith("_fetch")) {
					log.log(Level.FINER, "Executing method '"+dataSource+"."+methodName+"'");
					MethodDescription methodDescription = serviceDesc.getOtherMethods().get(methodName);
					if (methodDescription != null) {
						Object valObj=null;
						HashMap<String,Object> jsData=unifyRequest(request);
						Object[] params=prepareMethodParam(jsData, true, methodDescription.parameterNames, methodDescription.method.getParameterTypes());
						// Resolve "ids" for iterations
						int iterate=-1;
						if (jsData.get("ids") != null) {
							Class<?>[] paramTypes = methodDescription.method.getParameterTypes();
							for (int i=0; i < paramTypes.length; i++) {
								if (Long.class.equals(paramTypes[i]) || paramTypes[i].equals(Long.TYPE)
										&& methodDescription.parameterNames[i].equals("id")
										&& params[i] == null) {
									iterate=i;
									break;
								} else if (Collection.class.isAssignableFrom(paramTypes[i])
										&& methodDescription.parameterNames[i].equals("ids")
										&& params[i] == null) {
									List<Long> longList=new ArrayList<Long>();
									String ids = (String) jsData.get("ids");
									String[] idSplit = ids.split(",");
									for (int k=0; k < idSplit.length; k++) {
										if (idSplit[i].length() > 0) {
											longList.add(Long.parseLong(idSplit[i]));
										}
									}
									params[i]=longList;
									break;
								}
							}
						}

						if (iterate != -1) {
							if (log.isLoggable(Level.FINER)) {
								for (int j = 0; j < params.length; j++) {
									log.log(Level.FINER, "     Parameter[{0}]={1}", new Object[] {j, params[j]});
								}
							}
							String ids = (String) jsData.get("ids");
							String[] idSplit = ids.split(",");
							ArrayList<Object> listResult=new ArrayList<Object>();
							valObj=listResult;
							for (int i=0; i < idSplit.length; i++) {
								if (idSplit[i].length() > 0) {
									params[iterate]=Long.parseLong(idSplit[i]);
									Object subValObj = methodDescription.method.invoke(serviceDesc.getInstance(), params);
									if (subValObj != null && subValObj instanceof Collection) {
										listResult.addAll((Collection) subValObj);
									} else if (subValObj != null) {
										listResult.add(subValObj);
									}
								}
							}
							log.info("Return value: "+valObj);
						} else if (params != null) {
							if (log.isLoggable(Level.FINER)) {
								for (int j = 0; j < params.length; j++) {
									log.log(Level.FINER, "     Parameter[{0}]={1}", new Object[] {j, params[j]});
								}
							}
							valObj = methodDescription.method.invoke(serviceDesc.getInstance(), params);
							log.info("Return value: "+valObj);
						}
						Collection<Object> collResult;
						PagedResult<?> pagedResult=null;
						if (valObj == null) {
							collResult=new ArrayList<Object>();
							for (int i = 0; i < params.length; i++) {
								if (params[i] != null && params[i].getClass().equals(serviceDesc.getExpectedClass())) {
									collResult.add(params[i]);
									break;
								}
							}
						} else if (valObj instanceof Collection) {
							collResult=(Collection) valObj;
						} else if (valObj instanceof PagedResult) {
							collResult=null;
							pagedResult=(PagedResult) valObj;
						} else {
							ArrayList<Object> serviceResultArray=new ArrayList<Object>();
							serviceResultArray.add(valObj);
							collResult=serviceResultArray;
						}
						if (collResult != null) {
							sendResponse(response.getWriter(), 0, collResult.size(), collResult);
						} else if (pagedResult != null) {
							sendResponse(response.getWriter(), pagedResult);
						}
					} else {
						throw new IllegalArgumentException("No "+methodName+" operation available on "+dataSource);
					}
				} else if (operationType == null) {
					throw makeApplicationException("Unsupported operation", "ERR9001", "NULL");
				} else if (operationType.equals("fetch") && request.getParameter("id") != null) {
					Long idVal=Long.parseLong(request.getParameter("id"));
					if (serviceDesc.getFindById() != null) {
						Object serviceResult=serviceDesc.getFindById().invoke(serviceDesc.getInstance(), ServiceContextStore.get(), idVal);
						ArrayList<Object> serviceResultArray=new ArrayList<Object>();
						serviceResultArray.add(serviceResult);

						sendResponse(response.getWriter(), 0, 1, serviceResultArray);
					} else {
						throw new IllegalArgumentException("No fetch operation available");
					}
				} else if (operationType.equals("fetch")) {
					List<?> serviceResult;
					PagedResult<?> pagedServiceResult=null;

					String sRow=request.getParameter("_startRow");
					int startRow=sRow == null ? 0 : Integer.parseInt(sRow);
					String eRow=request.getParameter("_endRow");
					int endRow=eRow == null ? 0 : Integer.parseInt(eRow);

					ArrayList<String> queryParams=new ArrayList();
					Enumeration pNames = request.getParameterNames();
					while (pNames.hasMoreElements()) {
						String paramName = (String) pNames.nextElement();
						if (! paramName.startsWith("_")) {
							queryParams.add(paramName);
						} else if ("_sortBy".equals(paramName)) {
							queryParams.add("sortBy");
						}
					}

					if (queryParams.size() > 0) {
						Collection<MethodDescription> methods = serviceDesc.getOtherMethods().values();
						MethodDescription matchedMethod=null;
						int matchLength=1000;
						for (MethodDescription method : methods) {
							String[] methodParamNames = method.parameterNames;
							if (methodParamNames != null && methodParamNames.length >= queryParams.size()
									&& (List.class.isAssignableFrom(method.method.getReturnType())
										|| PagedResult.class.isAssignableFrom(method.method.getReturnType()))
									) {
								boolean matchParam=false;
								for (String queryParam : queryParams) {
									matchParam=false;
									for (String methodParamName : methodParamNames) {
										if (queryParam.equals(methodParamName)) {
											matchParam=true;
											break;
										}
									}
									if (!matchParam) {
										break;
									}
								}
								if (matchParam && method.parameterNames.length < matchLength) {
									matchedMethod=method;
									matchLength=method.parameterNames.length;
								}
							}
						}

						Object[] params=null;
						if (matchedMethod != null) {
							HashMap<String,Object> jsData=unifyRequest(request);
							params=prepareMethodParam(jsData, true, matchedMethod.parameterNames, matchedMethod.method.getParameterTypes());
						} else {
							List<ConditionalCriteria> conditions=new ArrayList();
							for (MethodDescription method : methods) {
								if (method.getMethodName().equals("findByCondition")) {
									Class<?>[] parameterTypes = method.method.getParameterTypes();
									if (List.class.isAssignableFrom(parameterTypes[0])) {
										params=new Object[] {conditions};
										matchedMethod=method;
										break;
									} else if (parameterTypes.length == 3 
											&& ServiceContext.class.isAssignableFrom(parameterTypes[0]) 
											&& List.class.isAssignableFrom(parameterTypes[1])
											&& PagingParameter.class.isAssignableFrom(parameterTypes[2])) {
										endRow=endRow < startRow + LOOK_AHEAD ? startRow + LOOK_AHEAD : endRow;
										PagingParameter pagingParam=PagingParameter.rowAccess(startRow, endRow, LOOK_AHEAD);
										params=new Object[] {ServiceContextStore.get(), conditions, pagingParam};
										matchedMethod=method;
										break;
									} else if (parameterTypes.length == 2 
											&&ServiceContext.class.isAssignableFrom(parameterTypes[0]) 
											&& List.class.isAssignableFrom(parameterTypes[1])) {
										params=new Object[] {ServiceContextStore.get(), conditions};
										matchedMethod=method;
										break;
									}
								}
							}
							if (matchedMethod != null) {
								for (String queryParam : queryParams) {
									LeafProperty<?> queryProp=new LeafProperty(queryParam, ScServlet.class);
									String matchStyle = request.getParameter("_textMatchStyle");
									String queryValue = request.getParameter(queryParam);
									if (queryParam.equals("sortBy")) {
										queryValue = normalizeAssoc(serviceDesc, request.getParameter("_sortBy"));
										if (queryValue.startsWith("+")) {
											LeafProperty<?> sortProp=new LeafProperty(queryValue.substring(1), ScServlet.class);
											conditions.add(ConditionalCriteria.orderAsc(sortProp));
										} else if (queryValue.startsWith("-")) {
											LeafProperty<?> sortProp=new LeafProperty(queryValue.substring(1), ScServlet.class);
											conditions.add(ConditionalCriteria.orderDesc(sortProp));
										} else {
											LeafProperty<?> sortProp=new LeafProperty(queryValue, ScServlet.class);
											conditions.add(ConditionalCriteria.orderAsc(sortProp));
										}
									} else if (queryValue.indexOf('%') != -1) {
										conditions.add(ConditionalCriteria.ignoreCaseLike(queryProp, request.getParameter(queryParam)+"%"));
									} else {
										String[] queryParamSplit = queryParam.split("\\.");
										Class watchClass=serviceDesc.getExpectedClass();
										Object otherEqVal=null;
										boolean isString=false;
										for (String queryParamPart : queryParamSplit) {
											try {
												Method method = watchClass.getMethod(makeGetMethodName(queryParamPart), (Class[]) null);
												watchClass=method.getReturnType();
												if (Collection.class.isAssignableFrom(watchClass)) {
													// TODO look deeper into class of collection
													break;
												} else if (Enum.class.isAssignableFrom(watchClass)) {
													otherEqVal = Enum.valueOf(watchClass, queryValue);
													break;
												} else if (String.class.equals(watchClass)) {
													isString=true;
													break;
												} else if (Long.class.equals(watchClass)) {
													isString=true;
													otherEqVal=Long.parseLong(queryValue);
													break;
												} else if (Integer.class.equals(watchClass)) {
													isString=true;
													otherEqVal=Integer.parseInt(queryValue);
													break;
												} else if (Double.class.equals(watchClass)) {
													isString=true;
													otherEqVal=Double.parseDouble(queryValue);
													break;
												} else if (Date.class.equals(watchClass)) {
													otherEqVal=dateFormat.parse(queryValue);
													break;
												} else if (findServiceByClassName(watchClass.getName()) != null && "null".equals(queryValue)) {
													otherEqVal="null";
													break;
												} else if (findServiceByClassName(watchClass.getName()) != null
														&& findServiceByClassName(watchClass.getName()).getFindById() != null) {
													ServiceDescription srvc = findServiceByClassName(watchClass.getName());
													otherEqVal = srvc.getFindById().invoke(srvc.getInstance(), ServiceContextStore.get(), Long.parseLong(queryValue));
												}
											} catch (NoSuchMethodException nsme) {
												// Ignore error, isString will stay false
												break;
											}
										}
										boolean isLike="substring".equals(matchStyle) || "startsWith".equals(matchStyle);
										if ("null".equals(otherEqVal)) {
											conditions.add(ConditionalCriteria.isNull(queryProp));
										} else if (otherEqVal instanceof Date) {
											DateMidnight start=(new DateTime(otherEqVal)).toDateMidnight();
											DateMidnight stop = start.plusDays(1);
											conditions.add(ConditionalCriteria.between(queryProp, start.toDate(), stop.toDate()));
										} else if (isString && otherEqVal != null && isLike) {
											conditions.add(ConditionalCriteria.like(queryProp, otherEqVal));
										} else if (isString && "substring".equals(matchStyle)) {
											conditions.add(ConditionalCriteria.ignoreCaseLike(queryProp, "%"+request.getParameter(queryParam)+"%"));
										} else if (isString && "startsWith".equals(matchStyle)) {
											conditions.add(ConditionalCriteria.ignoreCaseLike(queryProp, request.getParameter(queryParam)+"%"));
										} else if (otherEqVal != null) {
											conditions.add(ConditionalCriteria.equal(queryProp, otherEqVal));
										} else {
											conditions.add(ConditionalCriteria.equal(queryProp, queryValue));
										}
									}
								}
							}
						}

						if (matchedMethod != null && params != null) {
							for (int j = 0; j < params.length; j++) {
								log.log(Level.FINER, "     Parameter[{0}]={1}", new Object[] {j, params[j]});
							}
							if (matchedMethod.method.getReturnType().equals(PagedResult.class)) {
								serviceResult=null;
								pagedServiceResult=(PagedResult) matchedMethod.method.invoke(serviceDesc.getInstance(), params);
							} else {
								serviceResult=(List<?>) matchedMethod.method.invoke(serviceDesc.getInstance(), params);
							}
						} else {
							throw makeApplicationException("You can''t filter with such condition.", "ERR9015", (Serializable[]) null);
						}
					} else if (queryParams.size() == 0 && serviceDesc.getFindAll() != null) {
						Class<?>[] paramTypes = serviceDesc.getFindAll().getParameterTypes();
						if (paramTypes.length == 2
								&& paramTypes[0].equals(ServiceContext.class)
								&& paramTypes[1].equals(PagingParameter.class)
								&& serviceDesc.getFindAll().getReturnType().equals(PagedResult.class)) {
							endRow=endRow < startRow + LOOK_AHEAD ? startRow + LOOK_AHEAD : endRow;
							PagingParameter pagingParam=PagingParameter.rowAccess(startRow, endRow, LOOK_AHEAD);
							pagedServiceResult=(PagedResult<?>) serviceDesc.getFindAll().invoke(serviceDesc.getInstance()
									, ServiceContextStore.get(), pagingParam);
							serviceResult=null;
						} else if (paramTypes.length == 1 && paramTypes[0].equals(ServiceContext.class)) {
							serviceResult=(List<? extends Object>) serviceDesc.getFindAll().invoke(serviceDesc.getInstance()
									, ServiceContextStore.get());
						} else {
							serviceResult=null;
						}
					} else {
						throw new ApplicationException("", "No fetch operation available");
					}

					if (pagedServiceResult != null) {
						sendResponse(response.getWriter(), pagedServiceResult);
					} else {
						int resultSize=serviceResult == null ? 0 : serviceResult.size();
						endRow=(endRow == 0 ? resultSize : endRow);
						sendResponse(response.getWriter(), startRow, endRow < resultSize ? endRow : resultSize, serviceResult);
					}
				} else if (operationType.equals("update") && request.getParameter("id") != null) {
					Object val=serviceDesc.getFindById().invoke(serviceDesc.getInstance(), ServiceContextStore.get(), Long.parseLong(request.getParameter("id")));
					HashMap<String,Object> reqData=unifyRequest(request);
					mapRequestToObj(reqData, serviceDesc.getExpectedClass(), val);
					serviceDesc.getOtherMethods().get("save").method.invoke(serviceDesc.getInstance(), ServiceContextStore.get(), val);
					ArrayList<Object> list=new ArrayList<Object>();
					list.add(val);
					sendResponse(response.getWriter(), 0, 1, list);
				} else if ((operationType.equals("add") || operationType.equals("update")) && request.getParameter("id") == null) {
					HashMap<String,Object> reqData=unifyRequest(request);
					Object val=makeNewInstance(serviceDesc.getExpectedClass(), reqData);
					if (val != null) {
						mapRequestToObj(reqData, serviceDesc.getExpectedClass(), val);
						serviceDesc.getOtherMethods().get("save").method.invoke(serviceDesc.getInstance(), ServiceContextStore.get(), val);
						ArrayList<Object> list=new ArrayList<Object>();
						list.add(val);
						sendResponse(response.getWriter(), 0, 1, list);
					} else {
						throw makeApplicationException("Can't create new instance", "ERR9003", serviceDesc.getExpectedClass().getName());
					}
				} else {
					throw makeApplicationException("Unsupported operation", "ERR9001", operationType);
				}
			} else {
				throw makeApplicationException("Wrong datasource name", "ERR9002", dataSource);
			}
		} catch (Throwable ex) {
			// Find most relevant exception in embedded exceptions
			ApplicationException appException=null;
			Throwable relevantException=ex;
			while (ex != null) {
				relevantException=ex;
				if (ex instanceof ApplicationException) {
					appException=(ApplicationException) ex;
					break;
				}
				if (ex instanceof ValidationException) {
					break;
				}

				ex=ex.getCause();
			}

			// Prepare message
			String msg=null;
			if (appException != null) {
				msg = translate(appException.getMessage());
				Serializable[] msgParams = appException.getMessageParameters();
				if (msgParams != null) {
					Object[] params=new Object[msgParams.length];
					for (int i=0; i < msgParams.length; i++) {
						if (msgParams[i] instanceof Translatable) {
							params[i]=translate(((Translatable) msgParams[i]).getContent());
						} else {
							params[i]=msgParams[i];
						}
					}
					msg = MessageFormat.format(msg, params);
				}
			} else if (relevantException instanceof ValidationException) {
				StringBuilder b = new StringBuilder();				
				for (InvalidValue iv : ((ValidationException)relevantException).getInvalidValues()) {
					b.append("<b>").append(translate(iv.getPropertyName())+":</b> "+iv.getMessage())
					.append("<br/>");
				}
				msg = b.toString();
			} else {
				msg = translate("ERR9000");
				msg = MessageFormat.format(msg, new Object[] {relevantException.getClass().getName(), relevantException.getMessage()});
			}

			// Print stack trace
			log.log(Level.WARNING, "Relevant exception", relevantException);

			if (msg!=null) {
				log.log(Level.WARNING, "SENDING BACK ERROR '"+msg+"'");
				response.getWriter().write("{response:{ status:-1, data:\""+msg.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"")+"\", startRow:0, endRow:0, totalRows:0}}");
			}
			response.flushBuffer();
			// response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			throw new ServletException(msg);
		}
		response.flushBuffer();
	}

	private static final String VAL_SUFFIX="_VAL";
	private String normalizeAssoc(ServiceDescription serviceDesc, String assocName) {
		String retVal=assocName;
		if (assocName.endsWith(VAL_SUFFIX)) {
			String prefix="";
			String realAssocName=assocName.substring(0, assocName.length()-VAL_SUFFIX.length());
			if (assocName.startsWith("+") || assocName.startsWith("-")) {
				prefix=realAssocName.substring(0, 1);
				realAssocName=realAssocName.substring(1);
			}
			try {
				Method method = serviceDesc.getExpectedClass().getMethod(makeGetMethodName(realAssocName), (Class[]) null);
				Class watchClass=method.getReturnType();
				String refField = ds2Ref.get(watchClass.getName());
				retVal=prefix+realAssocName+"."+refField;
			} catch (NoSuchMethodException nsme) {
				// Ignore error, isString will stay false
			}
		}
		return retVal;
	}

	private String makeGetMethodName(String attributeName) {
		return GET_PREFIX+attributeName.substring(0, 1).toUpperCase()+attributeName.substring(1);
	}

	private void exportData(String dataSource, HttpServletResponse response) throws Exception {
		ServiceDescription serviceDesc = findService(dataSource);
		List<? extends Object> serviceResult=null;
		if (serviceDesc.getFindAll() != null) {
			Class<?>[] parameterTypes = serviceDesc.getFindAll().getParameterTypes();
			Object[] realParameters=new Object[parameterTypes.length];
			for (int i=0; i < parameterTypes.length; i++) {
				if (parameterTypes[i].equals(ServiceContext.class)) {
					realParameters[i]=ServiceContextStore.get();
				} else if (parameterTypes[i].equals(PagingParameter.class)) {
					realParameters[i]=PagingParameter.rowAccess(0, 1000);
				} else {
					throw new IllegalArgumentException("findAll parameter #"+i+" for '"+dataSource
							+"' has unknown type '"+parameterTypes[i].getName()+"'");
				}
			}
			if (serviceDesc.getFindAll().getReturnType().equals(PagedResult.class)) {
				PagedResult pagedServiceResult=(PagedResult) serviceDesc.getFindAll().invoke(serviceDesc.getInstance(), realParameters);
				serviceResult=pagedServiceResult.getValues();
			} else {
				serviceResult=(List<? extends Object>) serviceDesc.getFindAll().invoke(serviceDesc.getInstance(), realParameters);
			}
		} else {
			throw new IllegalArgumentException("No fetch (findAll) operation available");
		}

		// application/vnd.oasis.opendocument.spreadsheet
		// application/vnd.ms-excel
		response.setContentType("application/vnd.oasis.opendocument.spreadsheet;charset=UTF-8");
		response.setHeader("Content-Disposition", "filename="+dataSource+".csv");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "-1");

		boolean first=true;
		List<Method> methods=new ArrayList<Method>();
		for (Object dataRow : serviceResult) {
			// prepare header
			if (first) {
				first=false;
				StringBuilder header=new StringBuilder();

				// Resolve getId method
				Method idMethod;
				try {
					idMethod=dataRow.getClass().getMethod("getId", (Class<?> []) null);
				} catch (Throwable th) {
					idMethod=null;
				}
				if (idMethod != null) {
					methods.add(idMethod);
					header.append("Id "+READ_ONLY+",");
				}

				// Iterate through methods
				for (Class curClass = dataRow.getClass(); curClass != Object.class; curClass = curClass.getSuperclass()) {
					Method[] declaredMethods = curClass.getDeclaredMethods();
					for (Method m : declaredMethods) {
						if (m.getName().startsWith(GET_PREFIX)
								&& Modifier.isPublic(m.getModifiers())
								&& !Modifier.isStatic(m.getModifiers())
								&& m.getParameterTypes().length == 0
								&& !"getKey".equals(m.getName())
								&& !"getCreatedDate".equals(m.getName())
								&& !"getCreatedBy".equals(m.getName())
								&& !"getLastUpdated".equals(m.getName())
								&& !"getLastUpdatedBy".equals(m.getName())
								&& !"getVersion".equals(m.getName())
								&& !"getUuid".equals(m.getName())
								&& !"getId".equals(m.getName())) {
							Method setMethod;
							try {
								setMethod=curClass.getMethod(SET_PREFIX+m.getName().substring(GET_PREFIX.length()), new Class[] {m.getReturnType()});
							} catch (Throwable ex) {
								setMethod=null;
							}
							String readOnly="";
							if (setMethod == null) {
								readOnly=READ_ONLY;
							}
							header.append(m.getName().substring(GET_PREFIX.length())).append(readOnly).append(",");
							methods.add(m);
						}
					}
				}
				response.getWriter().println(header.length() > 0 ? header.substring(0, header.length() - 1) : "");
			}

			// Export data
			StringBuilder csvRow=new StringBuilder();
			for (Method m : methods) {
				Object value = m.invoke(dataRow, (Object[]) null);
				if (value == null) {
					csvRow.append("null,");
				} else if (value instanceof Map) {
					csvRow.append("HUH-MAPA");
					csvRow.append(",");
				} else if (value instanceof Collection) {
					csvRow.append("HUH-COLLECTION");
					csvRow.append(",");
				} else if (value instanceof List) {
					csvRow.append("HUH-LIST");
					csvRow.append(",");
				} else if (value instanceof Object[]) {
					csvRow.append("HUH-ARRAY");
					csvRow.append(",");
				} else if (value instanceof Date) {
					csvRow.append(dateFormat.format((Date) value));
					csvRow.append(",");
				} else if (value instanceof Boolean) {
					csvRow.append(((Boolean) value) ? "TRUE" : "FALSE");
					csvRow.append(",");
				} else if (value instanceof Number) {
					csvRow.append(value);
					csvRow.append(",");
				} else if (value instanceof CharSequence) {
					csvRow.append(Q).append( ((CharSequence) value).toString().replaceAll(Q, Q+Q) ).append(Q);
					csvRow.append(",");
				} else if (value instanceof Enum) {
					String enumName=((Enum)value).name();
					csvRow.append(Q+enumName+Q);
					csvRow.append(",");
				} else {
					csvRow.append("SOMETHING ELSE "+value.getClass());
					csvRow.append(",");
				}
			}
			response.getWriter().println(csvRow.length() > 0 ? csvRow.substring(0, csvRow.length()-1) : "");
		}
		return;
	}

	/* ###########################################################################
	 * # Map request back to object
	 * ########################################################################### */
	private void mapRequestToObj(HashMap<String,Object> data, Class expectedClass, Object obj) throws Exception {
		if (obj == null) {
			throw new ApplicationException("mapRequestToObj called on NULL obj", "ERR9001");
		}

		try {
			Method versionMethod = expectedClass.getMethod("getVersion", (Class<?> []) null);
			Long objVersion = (Long) versionMethod.invoke(obj, (Object []) null);
			String clientVersion = (String) data.get("version");
			if (objVersion != null && clientVersion != null) {
				try {
					long clientVersionLong = Long.parseLong(clientVersion);
					if (! objVersion.equals(clientVersionLong)) {
						throw makeApplicationException("Can't save object", "ERR9016", (Serializable[]) null);
					}
				} catch (NumberFormatException nfe) {
					// Version from client isn't number - ignore
				}
			}
		} catch (NoSuchMethodException nme) {
			// No version control
		}

		Method[] methods = expectedClass.getMethods();
		for (Method m : methods) {
			Class<?>[] paramTypes = m.getParameterTypes();

			Class persistentClass=null;
			if (paramTypes.length == 1) {
				if (paramTypes[0].getAnnotation(Entity.class) != null) {
					persistentClass=paramTypes[0];
				} else if (paramTypes[0].getAnnotation(Embeddable.class) != null) {
					persistentClass=paramTypes[0];
				}
			}
			ServiceDescription srvParam = paramTypes.length == 1 ? findServiceByClassName(paramTypes[0].getName()) : null;
			if ( (m.getName().startsWith(SET_PREFIX) && paramTypes.length == 1 && (
						paramTypes[0].isAssignableFrom(String.class)
						|| paramTypes[0].equals(Integer.class)
						|| paramTypes[0].equals(Integer.TYPE)
						|| paramTypes[0].equals(Long.class)
						|| paramTypes[0].equals(Long.TYPE)
						|| paramTypes[0].equals(Float.class)
						|| paramTypes[0].equals(Float.TYPE)
						|| paramTypes[0].equals(Boolean.class)
						|| paramTypes[0].equals(Boolean.TYPE)
						|| paramTypes[0].equals(Double.class)
						|| paramTypes[0].equals(Double.TYPE)
						|| paramTypes[0].equals(Date.class)
						|| Enum.class.isAssignableFrom(paramTypes[0])
						|| (srvParam != null && srvParam.getFindById() != null)
						|| persistentClass != null)
					)
					|| (m.getName().startsWith(GET_PREFIX) && paramTypes.length == 0
						&& (Set.class.isAssignableFrom(m.getReturnType()) 
								|| List.class.isAssignableFrom(m.getReturnType()))
					)
					) {
				String fldName;
				if (m.getName().startsWith(GET_TRANSLATE)) {
					fldName=m.getName().substring(GET_TRANSLATE_LENGTH, GET_TRANSLATE_LENGTH+1).toLowerCase()+m.getName().substring(GET_TRANSLATE_LENGTH + 1);
				} else {
					fldName=m.getName().substring(3, 4).toLowerCase()+m.getName().substring(4);
				}
				Object value = data.get(fldName);
				if (value == null) {
					fldName=m.getName().substring(3);
					value = data.get(fldName);
				}
				if (value != null) {
					Object typedVal;
					String val=null;
					if (value instanceof String) {
						val=(String) value;
					}
					log.log(Level.FINER, "        value = "+value);
					if (m.getName().startsWith(GET_PREFIX)
							&& paramTypes.length == 0
							&& ( Set.class.isAssignableFrom(m.getReturnType()) || List.class.isAssignableFrom(m.getReturnType())) ) {
						log.log(Level.FINER, "GET");

						String attrName=m.getName().substring(3,4).toLowerCase()+m.getName().substring(4);
						Type[] actualTypeArguments=null;
						Class iterClass=expectedClass;
						while (iterClass != null) {
							try {
								Field field = iterClass.getDeclaredField(attrName);
								ParameterizedType genericType = (ParameterizedType) field.getGenericType();
								actualTypeArguments = genericType.getActualTypeArguments();
								break;
							} catch (NoSuchFieldException nsfe) {
								// do nothing iterate again
							}
							iterClass=iterClass.getSuperclass();
							iterClass=iterClass.equals(Object.class) ? null : iterClass;
						}

						if (actualTypeArguments != null
								&& actualTypeArguments.length == 1
								&& actualTypeArguments[0] instanceof Class) {
							Class assocClass=(Class) actualTypeArguments[0];
							ServiceDescription assocService=findServiceByClassName(assocClass.getName());
							Collection dbValueSet=(Collection) m.invoke(obj, (Object[]) null);
							if (value == null || !(value instanceof HashMap)) {
								log.log(Level.FINE, "No data for db property {0}", attrName);
							} else if (assocService != null) {
								HashMap<String, Object> guiValueMap=(HashMap<String, Object>) value;

								ArrayList<Object> removeIt=new ArrayList<Object>();
								Iterator dbIterator = dbValueSet.iterator();
								while (dbIterator.hasNext()) {
									Object dbVal = dbIterator.next();
									String dbValId = getIdFromObj(dbVal);

									if (dbValId != null) {
										boolean wasMatchingGuiVal=false;
										ArrayList<String> removeKeys=new ArrayList<String>();
										for (String key : guiValueMap.keySet()) {
											Object object = guiValueMap.get(key);
											if (object instanceof HashMap) {
												Object guiValue = ((HashMap<String, Object>) object).get("id");
												if (guiValue.equals(dbValId)) {
													removeKeys.add(key);
													wasMatchingGuiVal=true;
													mapRequestToObj((HashMap<String, Object>) guiValue, assocClass, dbVal);
													break;
												}
											} else if (object instanceof String) {
												// Association
												if (dbValId.equals(object)) {
													removeKeys.add(key);
													wasMatchingGuiVal=true;
												}
											} else {
												log.log(Level.WARNING, "Wrong object type from GUI under key {0}", key);
											}
										}
										// Remove processed elements
										// Direct remove is firing concurrent modification exception
										for (String removeKey : removeKeys) {
											guiValueMap.remove(removeKey);
										}

										if (!wasMatchingGuiVal) {
											// Is not in list comming from GUI - delete
											removeIt.add(dbVal);
										}
									} else {
										log.log(Level.WARNING, "No ID in object {0}", dbVal);
									}
								}
								dbValueSet.removeAll(removeIt);

								// Rest are new records
								for (String key : guiValueMap.keySet()) {
									Object object = guiValueMap.get(key);
									if (object instanceof HashMap) {
										Object subObj=makeNewInstance(assocClass, (HashMap<String, Object>) object);
										mapRequestToObj((HashMap<String, Object>) object, assocClass, subObj);
										dbValueSet.add(subObj);
									} else if (object instanceof String) {
										// Association
										try {
											Long id=new Long((String) object);
											Object assocObj = assocService.getFindById().invoke(assocService.getInstance(), ServiceContextStore.get(), id);
											if (assocObj != null) {
												dbValueSet.add(assocObj);
											} else {
												log.log(Level.WARNING, "Object with ID {0} not availabla via service {1}", new Object[] {id, assocService.getName()});
											}
										} catch (Exception ex) {
											log.log(Level.WARNING, "No ID parsable from value {0} under key {1}", new Object[] {object, key});
										}
									} else {
										log.log(Level.WARNING, "Wrong sub type {0}", attrName);
									}
								}
							} else if (assocClass != null) {
								HashMap<String, Object> guiValueMap=(HashMap<String, Object>) value;

								ArrayList<Object> removeIt=new ArrayList<Object>();
								Iterator dbIterator = dbValueSet.iterator();
								while (dbIterator.hasNext()) {
									Object dbVal = dbIterator.next();
									String dbValId = getIdFromObj(dbVal);

									if (dbValId != null) {
										Object matchingGuiVal=null;
										for (String key : guiValueMap.keySet()) {
											Object object = guiValueMap.get(key);
											if (object instanceof HashMap) {
												HashMap<String, Object> guiVal=(HashMap<String, Object>) object;
												if (dbValId.equals(guiVal.get("id"))) {
													guiValueMap.remove(key);
													matchingGuiVal=guiVal;
													break;
												}
											} else {
												log.log(Level.WARNING, "Wrong object type from GUI under key {0}", key);
											}
										}
										if (matchingGuiVal != null) {
											// Coming from GUI - update
											mapRequestToObj((HashMap<String, Object>) matchingGuiVal, assocClass, dbVal);
										} else {
											// Not in GUI - delete
											removeIt.add(dbVal);
										}
									} else {
										log.log(Level.WARNING, "No ID in object {0}", dbVal);
									}
								}
								dbValueSet.removeAll(removeIt);

								// Rest are new records
								for (String key : guiValueMap.keySet()) {
									Object object = guiValueMap.get(key);
									if (object instanceof HashMap) {
										Object subObj=makeNewInstance(assocClass, (HashMap<String, Object>) object);
										mapRequestToObj((HashMap<String, Object>) object, assocClass, subObj);
										dbValueSet.add(subObj);
									} else {
										log.log(Level.WARNING, "Wrong sub type {0}", attrName);
									}
								}
							}
						} else {
							log.log(Level.WARNING, "No DB mapping or not of collection type: {0}", attrName);
						}
						typedVal=null;
					} else if (paramTypes[0].isAssignableFrom(String.class)) {
						typedVal=val;
					} else if (paramTypes[0].equals(Integer.class) || paramTypes[0].equals(Integer.TYPE)) {
						typedVal=Integer.parseInt(val);
					} else if (paramTypes[0].equals(Long.class) || paramTypes[0].equals(Long.TYPE)) {
						typedVal=Long.parseLong(val);
					} else if (paramTypes[0].equals(Double.class) || paramTypes[0].equals(Double.TYPE)) {
						typedVal=Double.parseDouble(val);
					} else if (paramTypes[0].equals(Float.class) || paramTypes[0].equals(Float.TYPE)) {
						typedVal=Float.parseFloat(val);
					} else if (paramTypes[0].equals(Boolean.class) || paramTypes[0].equals(Boolean.TYPE)) {
						typedVal="true".equalsIgnoreCase(val) || "t".equalsIgnoreCase(val) || "y".equalsIgnoreCase(val);
					} else if (paramTypes[0].isAssignableFrom(Date.class)) {
						typedVal=dateFormat.parse(val);
					} else if (Enum.class.isAssignableFrom(paramTypes[0])) {
						try {
							Method fromValueMethod=paramTypes[0].getMethod("fromValue", String.class);
							typedVal=fromValueMethod.invoke(null, val);
						} catch (Exception ex) {
							typedVal=null;
						}

						try {
							if (typedVal == null) {
								Method valueOfMethod=paramTypes[0].getMethod("valueOf", String.class);
								typedVal=valueOfMethod.invoke(null, val);
							}
						} catch (Exception ex) {
							typedVal=null;
						}
					} else if (persistentClass != null && persistentClass.equals(FileUpload.class)) {
						FileItem fileItem = uploadServlet.getFileItem(sessionId.get(), fldName, val);
						if (fileItem != null) {
							typedVal=fileUploadService.uploadFile(ServiceContextStore.get(), fileItem.getName()
									, fileItem.getContentType(), fileItem.getInputStream());
						} else {
							typedVal=null;
						}
					} else if (srvParam!=null && srvParam.getFindById() != null) {
						if (value instanceof HashMap) {
							HashMap<String,Object> embeddedObj=(HashMap<String,Object>) value;
							typedVal=srvParam.getFindById().invoke(srvParam.getInstance(), ServiceContextStore.get(), new Long((String) embeddedObj.get("id")));
							mapRequestToObj(embeddedObj, srvParam.getExpectedClass(), typedVal);
						} else {
							try {
								Long parsedId=new Long(val);
								typedVal=srvParam.getFindById().invoke(srvParam.getInstance(), ServiceContextStore.get(), parsedId);
							} catch (NumberFormatException nfe) {
								// wrong value
								typedVal=null;
							}
						}
					} else if (persistentClass != null) {
						String getMethodName="g"+m.getName().substring(1);
						try {
							Method getMethod = obj.getClass().getMethod(getMethodName, (Class[]) null);
							typedVal=getMethod.invoke(obj, (Object[]) null);
						} catch (NoSuchMethodException nsme) {
							typedVal=null;
						}
						if (typedVal==null) {
							typedVal=makeNewInstance(persistentClass, (HashMap<String,Object>) value);
						}
						mapRequestToObj((HashMap<String,Object>) value, typedVal.getClass(), typedVal);
					} else {
						log.log(Level.WARNING, "Can't convert value for: {0}.{1} ({2})", new Object[] {expectedClass.getName(), m.getName(), (paramTypes.length == 1 ? paramTypes[0].getName() : paramTypes.toString())});
						typedVal=null;
					}
					if (typedVal != null) {
						m.invoke(obj, typedVal);
					}
				}
			} else if (m.getName().startsWith(SET_PREFIX)) {
				log.log(Level.WARNING, "Unusable setter method: {0}.{1} ({2})", new Object[] {expectedClass.getName(), m.getName(), (paramTypes.length == 1 ? paramTypes[0].getName() : paramTypes.toString())});
			}
		}
	}

	private HashMap<String, Object> unifyRequest(HttpServletRequest request) {
		HashMap<String, Object> hashData=new HashMap<String, Object>();

		Enumeration parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName=(String) parameterNames.nextElement();
			if ("_oldValues".equals(paramName)) {
				continue;
			}

			String reqVal=request.getParameter(paramName);
			if ("_sortBy".equals(paramName)) {
				hashData.put("sortBy", reqVal);
			} else {
				hashData.put(paramName, parseJson(reqVal));
			}
		}
		return hashData;
	}

	private Object parseJson(String value) {
		Object result=value;
		if (value.startsWith("{") || value.startsWith("[")) {
			try {
				CommonTree tree = JavaScriptDataParser.parseString(value);
				result=mapJsDataToHash(tree);
			} catch (Exception e) {
				log.log(Level.WARNING, "Can not parse value to object "+value);
				result=value;
			}
		} else if ("null".equals(value)) {
			result=null;
		}
		return result;
	}

	private HashMap<String, Object> mapJsDataToHash(CommonTree from) throws Exception {
		HashMap<String, Object> retVal=new HashMap<String, Object>();
		if (from==null || from.getChildCount() == 0) {
			// Do nothing
		} else if (from.getType() == JavaScriptDataParser.OBJECT) {
			for (int i=0; i < from.getChildCount(); i++) {
				Object tokenName=from.getChild(i);
				CommonTree token=(CommonTree) tokenName;
				if (token.getType() == JavaScriptDataParser.ELEMENT) {
					CommonTree nameToken = (CommonTree) token.getFirstChildWithType(JavaScriptDataParser.Name);  // e.g. name:"vendelin"
					String name;
					if (nameToken == null) {
						// try to find token in case that the attribute is wrapped with double quote e.g. "name":"vendelin"
						nameToken = (CommonTree) token.getFirstChildWithType(JavaScriptDataParser.String);
						name = nameToken.getText();						
						name = name.substring(1,name.length()-1);
					} else {
						name = nameToken.getText();
					}
					CommonTree value = (CommonTree) token.getChild(1);
					retVal.put(name, mapElementValToObject(value));
				} else {
					throw new Exception("Wrong AST type "+JavaScriptDataParser.tokenNames[token.getType()]+" I need ELEMENT");
				}
			}
		} else {
			throw new Exception("Wrong AST type "+JavaScriptDataParser.tokenNames[from.getType()]+" send to mapper");
		}

		return retVal;
	}

	private Object mapElementValToObject(CommonTree value) throws Exception {
		Object retVal;
		if (value.getType() == JavaScriptDataParser.STRING) {
			String result=value.getChild(0).getText();
			retVal=result.substring(1, result.length()-1);
		} else if (value.getType() == JavaScriptDataParser.INTEGER
				|| value.getType() == JavaScriptDataParser.DOUBLE
				|| value.getType() == JavaScriptDataParser.BOOLEAN) {
			retVal=value.getChild(0).getText();
		} else if (value.getType() == JavaScriptDataParser.DATE) {
			// in format 'new Date(132132123123)'
			String jsDateString = value.getChild(0).getText();
			int leftBracket = jsDateString.indexOf("(");
			int rightBracket = jsDateString.indexOf(")");
			if (leftBracket != -1 && rightBracket != -1 && leftBracket < rightBracket) {
				try {
					long time=Long.parseLong(jsDateString.substring(leftBracket + 1, rightBracket));
					retVal=new Date(time);
				} catch (NumberFormatException nfe) {
					retVal=null;
				}
			} else {
				retVal=null;
			}
		} else if (value.getType() == JavaScriptDataParser.NULL) {
			retVal=null;
		} else if (value.getType() == JavaScriptDataParser.ARRAY) {
			ArrayList<Object> arrayVal=new ArrayList();
			for (int i=0; i < value.getChildCount(); i++) {
				Object arrayElem=value.getChild(i);
				arrayVal.add(mapElementValToObject((CommonTree) ((CommonTree) arrayElem).getChild(0)));
			}
			retVal=arrayVal;
		} else if (value.getType() == JavaScriptDataParser.OBJECT) {
			if (value.getChildCount() != 0) {
				retVal=mapJsDataToHash(value);
			} else {
				retVal=null;
			}
		} else {
			throw new Exception("Wrong AST type "+JavaScriptDataParser.tokenNames[value.getType()]+" can't map");
		}
		return retVal;
	}

	/* ###########################################################################
	 * # Send response
	 * ########################################################################### */
	private void sendResponse(PrintWriter output, PagedResult<?> pResult) throws IllegalArgumentException {
		List<?> inputData=pResult.getValues() == null ? new ArrayList<Object>() : pResult.getValues();
		int showEndRow=pResult.getEndRow() < 1 ? 0 : pResult.getEndRow();

		int totalRows;
		if (pResult.isTotalCounted()) {
			totalRows=pResult.getTotalRows();
		} else if (pResult.isAddionalResultCounted()) {
			totalRows=pResult.getEndRow() + pResult.getAdditionalResultRows();
		} else {
			totalRows=pResult.getStartRow() + pResult.getValues().size() + 1;
		}

		log.log(Level.FINE, "Sending JSON response from {0} to {1} of size {2}"
				, new Object[] {pResult.getStartRow(), showEndRow, inputData.size()});
		output.write("{response: { status:0, startRow:" + pResult.getStartRow()
				+ ", endRow:" + showEndRow + ", totalRows:" + totalRows + ", data:[");

		String delim="";
		for (Object obj : inputData) {
			output.write(delim);

			// Prepare string representation and write to out
			String objString=mapObjToOutput(obj, DEF_DEPTH, new Stack(), false, false);
			log.log(Level.FINER, "    >>>>>>>>>>> {0}", objString);
			output.write(objString);
			delim=", ";
		}
		output.write(" ] } }");
	}

	private void sendResponse(PrintWriter output, int startRow, int endRow, Collection<? extends Object> inputData) throws IllegalArgumentException {
		inputData=inputData == null ? new ArrayList<Object>() : inputData;
		int showEndRow=endRow < 1 ? 0 : endRow -1;
		log.log(Level.FINE, "Sending JSON response from {0} to {1} of size {2}", new Object[] {startRow, showEndRow, inputData.size()});
		output.write("{response: { status:0, startRow:" + startRow + ", endRow:" + showEndRow + ", totalRows:" + inputData.size() + ", data:[");

		// If inputData is Set convert to array
		Object[] setData=null;
		if (inputData instanceof Set) {
			setData=inputData.toArray();
		} else if (! (inputData instanceof List)) {
			throw new IllegalArgumentException("Datatype "+inputData.getClass().getName()+" is not supported (only implementations of java.util.Set and java.util.List)");
		}
		for (int i = startRow; i < endRow; i++) {
			// Get object from collection
			Object obj;
			if (inputData instanceof Set) {
				obj=setData[i];
			} else {
				obj = ((List<? extends Object>) inputData).get(i);
			}

			// Write out separator except first
			if (i!=startRow) {
				output.write(", ");
			}

			// Prepare string representation and write out
			String objString=mapObjToOutput(obj, DEF_DEPTH, new Stack(), false, false);
			log.log(Level.FINER, "    >>>>>>>>>>> {0}", objString);
			output.write(objString);
		}
		output.write(" ] } }");
	}

	private static final String Q="\"";

	private String mapObjToOutput(Object obj, int maxDepth, Stack<Object> serStack, boolean useGwtArray, boolean translateValue) {
		if (serStack.size() == 0) {
			log.log(Level.FINER, "Serializing START {0}", obj);
		}

		// Avoid recursion
		if ( serStack.size() == maxDepth && !(obj instanceof Date || obj instanceof Number || obj instanceof Boolean
				|| obj instanceof CharSequence || obj instanceof Enum) ) {
			String objId = getIdFromObj(obj);
			return objId==null ? Q+Q : objId;
		}
		if (serStack.contains(obj)) {
			return getIdFromObj(obj);
			// return Q+"ref: "+obj.getClass().getName()+"@"+obj.hashCode()+Q;
		}
		serStack.push(obj);

		String startArray=useGwtArray ? "$wnd.Array.create([" : "[";
		String endArray=useGwtArray ? "])" : "]";

		StringBuilder recordData = new StringBuilder();
		if (obj == null) {
			recordData.append("null");
		} else if (obj instanceof Map) {
			recordData.append("{");
			Map objMap=(Map) obj;
			String delim="";
			for (Object objKey : objMap.keySet()) {
				recordData.append(delim).append(objKey).append(":").append(mapObjToOutput(objMap.get(objKey), maxDepth, serStack, useGwtArray, false));
				delim=" , ";
			}
			recordData.append("}");
		} else if (obj instanceof Collection) {
			recordData.append(startArray);
			Collection objSet=(Collection) obj;
			String delim="";
			for (Object objVal : objSet) {
				recordData.append(delim).append(mapObjToOutput(objVal, maxDepth, serStack, useGwtArray, false));
				delim=" , ";
			}
			recordData.append(endArray);
		} else if (obj instanceof List) {
			recordData.append(startArray);
			List objList=(List) obj;
			String delim="";
			for (Object objVal : objList) {
				recordData.append(delim).append(mapObjToOutput(objVal, maxDepth, serStack, useGwtArray, false));
				delim=" , ";
			}
			recordData.append(endArray);
		} else if (obj instanceof Object[]) {
			recordData.append(startArray);
			Object[] objArr=(Object[]) obj;
			String delim="";
			for (Object objVal : objArr) {
				recordData.append(delim).append(mapObjToOutput(objVal, maxDepth, serStack, useGwtArray, false));
				delim=" , ";
			}
			recordData.append(endArray);
		} else if (obj instanceof Date) {
			Date objDate=(Date) obj;
			// recordData.append(Q+dateTimeFormat.format(objDate)+Q);
			recordData.append("new Date("+objDate.getTime()+")");
		} else if (obj instanceof Boolean) {
			recordData.append(obj);
		} else if (obj instanceof Number) {
			recordData.append(obj);
		} else if (obj instanceof CharSequence) {
			String strObj=obj.toString();
			if ( strObj.startsWith(Main.JAVASCRIPT_PREFIX) && useGwtArray) {
				recordData.append(" ").append(strObj.substring(Main.JAVASCRIPT_PREFIX.length()));
			} else if ( strObj.startsWith("function") && useGwtArray) {
				recordData.append(" ").append(strObj);
			} else {
				strObj=translateValue ? translate(strObj) : strObj;
				String escapeString=strObj.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"")
					.replaceAll("\\r", "\\\\r").replaceAll("\\n", "\\\\n");
				recordData.append(Q+escapeString+Q);
			}
		} else if (obj instanceof Enum) {
			String val=((Enum)obj).name();
			if (useGwtArray) {
				try {
					Method getValMethod=obj.getClass().getMethod("getValue", (Class[]) null);
					val = (String) getValMethod.invoke(obj, (Object[]) null);
				} catch (Exception e) {
					// no method getValue
				}
			}
			recordData.append(Q+val+Q);
		} else {
			String className=obj.getClass().getName();
			ServiceDescription serviceForClass = findServiceByClassName(className);
			log.log(Level.FINER, "Serializing class {0}", className);
			if (serStack.size() > 2 && serviceForClass != null) {
				recordData.append(getIdFromObj(obj));
			} else {
				// Use reflection
				recordData.append("{");
				String delim="";
				String jsonPostfix=null;
				Method[] methods = obj.getClass().getMethods();
				for (Method m : methods) {
					boolean translateThisValue=false;
					String mName;
					if (m.getName().startsWith(GET_TRANSLATE)) {
						translateThisValue=true;
						mName=m.getName().substring(GET_TRANSLATE_LENGTH);
					} else if (m.getName().startsWith("is")) {
						mName=m.getName().substring(2);
					} else {
						mName=m.getName().substring(3);
					}

					if (mName.length() > 1 && Character.isLowerCase(mName.charAt(1))) {
						mName=mName.substring(0,1).toLowerCase()+mName.substring(1);
					}

					if (m.getName().startsWith("getJsonPostfix")
							&& m.getParameterTypes().length == 0
							&& String.class.equals(m.getReturnType())) {
						try {
							jsonPostfix=(String) m.invoke(obj, new Object[] {});
						} catch (Throwable e) {
							log.log(Level.FINE, "Mapping error", e);
						}
					} else if (!m.getDeclaringClass().getName().startsWith("org.hibernate")
							&& m.getDeclaringClass() != Object.class
							&& m.getDeclaringClass() != Class.class
							&& (m.getName().startsWith("get") || m.getName().startsWith("is"))
							&& m.getParameterTypes().length == 0
							&& m.getReturnType() != null
							&& !isHiddenField(m.getDeclaringClass().getName(), mName)) {
						log.log(Level.FINEST, "Reflection invoking name={0} declaringClass={1} on {2}[{3}]", new Object[] {m.getName(), m.getDeclaringClass(), obj, obj.getClass()});
						try {
							Object result=m.invoke(obj, new Object[] {});
							if (result != null) {
								mName=mName.startsWith("xxx") ? mName.substring(3) : mName;
								String resultClassName=AopUtils.getTargetClass(result).getName();
								String idVal=getIdFromObj(result);
								String valStr;
								if (findServiceByClassName(resultClassName) != null && idVal != null) {
									recordData.append(delim).append(mName).append(":").append(idVal);
									String refField = ds2Ref.get(resultClassName);
									if (refField != null) {
										Object realVal = getValFromObj(refField, result);
										valStr=realVal == null ? Q+Q : Q+realVal+Q;
									} else {
										valStr=Q+"UNKNOWN"+Q;
									}
									mName=mName+"_VAL";
									delim=", ";
								} else {
									valStr=mapObjToOutput(result, maxDepth, serStack, useGwtArray, translateThisValue);
								}
								recordData.append(delim).append(mName).append(":").append(valStr);
								delim=", ";
							}
						} catch (Throwable e) {
							log.log(Level.FINE, "Mapping error", e);
						}
					}
				}

				if (jsonPostfix != null) {
					recordData.append(delim).append(jsonPostfix).append("}");
				} else {
					recordData.append("}");
				}
			}
		}
		serStack.pop();
		return recordData.toString();
	}

	private String getIdFromObj(Object obj) {
		String retVal=null;

		Method getIdMethod=null;
		try {
			getIdMethod=obj.getClass().getMethod("getId", new Class<?>[] {});
		} catch (Exception e) {
			// Ignore, use reflection
		}
		
		if (getIdMethod != null) {
			try {
				retVal=""+getIdMethod.invoke(obj, new Object[] {});
			} catch (Exception e) {
				log.log(Level.FINE, "Getting ID error", e);
			}
		}
		return retVal;
	}

	private Object getValFromObj(String propertyName, Object obj) {
		Object retVal=null;

		String methodName=GET_PREFIX+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
		Method getValMethod=null;
		try {
			getValMethod=obj.getClass().getMethod(methodName, new Class<?>[] {});
		} catch (Exception e) {
			// Ignore, use reflection
		}

		if (getValMethod != null) {
			try {
				retVal = getValMethod.invoke(obj, new Object[] {});
			} catch (Exception e) {
				log.log(Level.FINE, "Getting VAL error", e);
			}
		}
		return retVal;
	}

	private String translate(String name) {
		String key=getLanguage()+"."+name;
		String tran;
		try {					
			tran = propertyService.getProperty(key);
	
			if (tran == null && name != null) {
				String propName=name;
				propName=propName.replaceAll("(\\p{Upper}+)", " $1");
				if (propName.startsWith(" ")) {
					propName=propName.substring(1);
				}
				tran=propName.substring(0, 1).toUpperCase()+propName.substring(1);
				propertyService.getProperty(key, tran);
			}
		} catch (Exception e) {
			tran = key;
			log.log(Level.WARNING, "Can not transalate message "+name, e);
		}

		return tran;
	}

	public String listServices() {
		StringBuilder result=new StringBuilder("(");
		boolean wasService=false;

		HashMap<String, List<ServiceDescription>> categories=new HashMap<String, List<ServiceDescription>>();
		for (ServiceDescription serviceDesc : getServiceDescription()) {
			String category = serviceDesc.getCategory();
			List<ServiceDescription> categoryList = categories.get(category);
			if (categoryList == null) {
				categoryList=new ArrayList<ServiceDescription>();
				categories.put(category, categoryList);
			}
			categoryList.add(serviceDesc);
		}

		Set<String> categorySet = categories.keySet();
		for (String category : categorySet) {
			List<ServiceDescription> serviceCategoryList = categories.get(category);
			String delim=(wasService ? "], " : "[")+"[ "+Q+translate(category)+Q+", ";
			for (ServiceDescription serviceDesc : serviceCategoryList) {
				String beanName=serviceDesc.getName();
				String[] accRoles=serviceDesc.getVisibleForRoles();
				boolean accessDenied=true;
				if (accRoles != null && accRoles.length > 0) {
					for (String accRole : accRoles) {
						if (ServiceContextStore.get().isUserInRole(accRole)) {
							accessDenied=false;
							break;
						}
					}
				} else {
					accessDenied=false;
				}
	
				if (!accessDenied) {
					log.log(Level.INFO, "Service {0} accesible", beanName);
					
					// Bean name
					wasService=true;
					result.append(delim);
					result.append(Q).append(beanName).append(Q);
					delim=", ";
	
					// Service description
					result.append(delim);
					if (serviceDesc.getOtherMethods().size() > 0) {
						result.append("(").append(mapObjToOutput(filterMethods(serviceDesc.getOtherMethods().values(), ServiceContextStore.get()), 4, new Stack<Object>(), false, false)).append(")");
					} else {
						result.append("([])");
					}
	
					// Bean translated name
					result.append(delim);
					result.append(Q).append(translate(beanName.endsWith("Service") ? beanName.substring(0, beanName.length() - 7) : beanName)).append(Q);
				} else {
					log.log(Level.INFO, "Service {0} access denied", beanName);
				}
			}
		}

		result.append("] ] )");
		log.log(Level.FINE, "Menu: {0}", result);
		return result.toString();
	}

	private List<MethodDescription> filterMethods(Collection<MethodDescription> methods,
				ServiceContext serviceContext) {
		ArrayList<MethodDescription> result=new ArrayList<MethodDescription>();
		for (MethodDescription m : methods) {
			boolean isOK=true;
			if (m.getIfRole() != null && m.getIfRole().length > 0) {
				isOK=false;
				for (String role : m.getIfRole()) {
					if (serviceContext.isUserInRole(role)) {
						isOK=true;
						break;
					}
				}
			}

			if (isOK) {
				result.add(m);
			}
		}
		return result;
	}

	long serviceTimestamp=0;
	long serviceTimeout=1000*60; // 60 sec

	private List<ServiceDescription> getServiceDescription() {
		return serviceRegistry.getServices(ServiceContextStore.get()); // caching is on service side
	}

	public ServiceDescription findService(String serviceName) {
		ServiceDescription service=null;
		for (ServiceDescription serviceDescription : getServiceDescription()) {
			if (serviceDescription.getName().equals(serviceName)) {
				service=serviceDescription;
				break;
			}
		}
		return service;
	}

	public ServiceDescription findServiceByClassName(String className) {
		ServiceDescription retVal=null;
		for (ServiceDescription serviceDesc : getServiceDescription()) {
			if (className.equals(serviceDesc.getExpectedClass().getName())) {
				retVal=serviceDesc;
				break;
			}
		}
		return retVal;
	}

	/* ###########################################################################
	 * # Print request helper
	 * ########################################################################### */
	private void printRequest(HttpServletRequest request) throws IOException {
		Enumeration<String> paramList = request.getParameterNames();
		StringBuilder out=new StringBuilder();
		out.append("<<<<<<<<<<<< Request ");
		while (paramList.hasMoreElements()) {
			String param = paramList.nextElement();
			out.append(" :: " + param + "=" + request.getParameter(param));
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		char[] dataBuff=new char[1024];
		int readBytes=bufferedReader.read(dataBuff);
		while (readBytes != -1) {
			out.append("\nData: "+new String(dataBuff, 0, readBytes));
			readBytes=bufferedReader.read(dataBuff);
		}
		log.log(Level.INFO, "{0}", out);
	}

	private Object makeNewInstance(Class expectedClass, HashMap<String,Object> jsData) throws ApplicationException {
		Object val=null;
		try {
			Constructor[] constructors = expectedClass.getConstructors();
			for (int k = 0; k < constructors.length; k++) {
				Constructor constructor = constructors[k];
				Annotation[][] constrAnnot = constructor.getParameterAnnotations();
				String [] paramNames=new String[constrAnnot.length];
				int annotCount=0;
				for (int i = 0; i < constrAnnot.length; i++) {
					Annotation[] annotations = constrAnnot[i];
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
				if (annotCount != constrAnnot.length) {
					continue;
				}
				Object[] params=prepareMethodParam(jsData, false, paramNames, constructor.getParameterTypes());
				if (params != null) {
					val=constructor.newInstance(params);
					break;
				}
			}

			if (val==null) {
				throw new Exception("Can't create instance of class "+expectedClass.getName());
			}
		} catch (Exception ex) {
			throw new ApplicationException(ex.getMessage(), "ERR9001", ex);
		}

		return val;
	}

	public Object[] prepareMethodParam(HashMap<String,? extends Object> jsData, boolean applyNull, String[] paramNames
			, Class[] parameterTypes) throws ApplicationException {
		boolean hasMapping=false;
		Object[] realParams=new Object[paramNames.length];
		try {
			hasMapping=true;
			for (int i = 0; i < parameterTypes.length; i++) {
				Class<?> paramType = parameterTypes[i];
				//Object paramObject=jsData.get(paramNames[i]) == null ? jsData : jsData.get(paramNames[i]);
				Object paramObject=jsData.get(paramNames[i]);

				if (paramType.equals(ServiceContext.class)) {
					realParams[i]=ServiceContextStore.get();
				} else if (paramType.equals(PagingParameter.class)) {
					String sRow=(String) jsData.get("_startRow");
					int startRow=sRow == null ? 0 : Integer.parseInt(sRow);
					String eRow=(String) jsData.get("_endRow");
					int endRow=eRow == null ? 0 : Integer.parseInt(eRow);

					realParams[i]=PagingParameter.rowAccess(startRow, endRow, LOOK_AHEAD);
				} else if (paramType.equals(String.class)) {
					realParams[i]=(String) paramObject;
				} else if (paramType.equals(Integer.class) || paramType.equals(Integer.TYPE)) {
					realParams[i]=paramObject == null ? null : Integer.parseInt(((String) paramObject).replaceAll("\"", ""));
				} else if (paramType.equals(Long.class) || paramType.equals(Long.TYPE)) {
					realParams[i]=paramObject == null ? null : Long.parseLong(((String) paramObject).replaceAll("\"", ""));
				} else if (paramType.equals(Double.class) || paramType.equals(Double.TYPE)) {
					realParams[i]=paramObject == null ? null : Double.parseDouble(((String) paramObject).replaceAll("\"", ""));
				} else if (paramType.equals(Date.class)) {
					realParams[i]=paramObject == null ? null : dateFormat.parse((String) paramObject);
				} else if (paramType.equals(Boolean.class) || paramType.equals(Boolean.TYPE)) {
					realParams[i]=("true".equals(paramObject));
				} else if (paramObject instanceof HashMap || (paramObject == null && jsData instanceof HashMap)) {
					HashMap<String, Object> objData=(HashMap<String, Object>) (paramObject == null ? jsData : paramObject);
					ServiceDescription service = findServiceByClassName(paramType.getName());
					if (objData.get("id") != null && service != null) {
						Long id=Long.parseLong((String) objData.get("id"));
						realParams[i]=service.getFindById().invoke(service.getInstance(), ServiceContextStore.get(), id);
					} else {
						realParams[i]=makeNewInstance(paramType, objData);
					}
					mapRequestToObj(objData, paramType, realParams[i]);
				} else if (findServiceByClassName(paramType.getName()) != null) {
					ServiceDescription service = findServiceByClassName(paramType.getName());
					Long recId=Long.parseLong((String) paramObject);
					realParams[i]=service.getFindById().invoke(service.getInstance(), ServiceContextStore.get(), recId);
				} else if (Enum.class.isAssignableFrom(paramType)) {
					try {
						Method fromValueMethod=paramType.getMethod("fromValue", String.class);
						realParams[i]=fromValueMethod.invoke(null, paramObject);
					} catch (Exception ex) {
					}

					try {
						if (realParams[i] == null) {
							Method valueOfMethod=paramType.getMethod("valueOf", String.class);
							realParams[i]=valueOfMethod.invoke(null, paramObject);
						}
					} catch (Exception ex) {
					}

					if (realParams[i] == null) {
						hasMapping=false;
						break;
					}
				} else if (applyNull) {
					realParams[i]=null;
				} else {
					hasMapping=false;
					break;
				}
			}
		} catch (ApplicationException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new ApplicationException(ex.getMessage(), "ERR9001", ex);
		}

		return hasMapping ? realParams : null;
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

	private String getLanguage() {
		String lang = (String) ServiceContextStore.get().getProperty("lang");
		if (lang==null) {
			lang="en";
		}
		return lang;
	}

	private ApplicationException makeApplicationException(String errorCode, String message, Serializable... parameters) {
		ApplicationException ex=new ApplicationException(errorCode, message);
		ex.setMessageParameters(parameters);

		return ex;
	}

	static String serviceUrl=null;
	private String getServiceUrl(HttpServletRequest request) {
		if (serviceUrl==null) {
			serviceUrl=request.getContextPath()+"/service";			
		}
		return serviceUrl;
	}

	/* ###########################################################################
	 * # Methods for IoC
	 * ########################################################################### */
	ServiceRegistryService serviceRegistry=null;

	public ServiceRegistryService getServiceRegistry() {
		return serviceRegistry;
	}

	public void setServiceRegistry(ServiceRegistryService serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

	GuiDataSourceService guiDataSourceService=null;

	public GuiDataSourceService getGuiDataSourceService() {
		return guiDataSourceService;
	}

	public void setGuiDataSourceService(GuiDataSourceService guiDataSourceService) {
		this.guiDataSourceService = guiDataSourceService;
	}
	
	private PropertySupportFacade propertyService;
	
	public void setPropertySupport(PropertySupportFacade propertySupport) {
		this.propertyService = propertySupport;
	}

	public PropertySupportFacade getPropertySupport() {
		return propertyService;
	}

	@Autowired
	public void setScheduler(Scheduler scheduler) {
		try {
			scheduler.getContext().put("serviceInvoker", this);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public Object invokeService(String serviceName, String methodName, Object[] params) throws Exception {
		Object valObj=null;
		ServiceDescription serviceDesc=findService(serviceName);
		if (serviceDesc != null) {
			MethodDescription methodDescription = serviceDesc.getOtherMethods().get(methodName);
			if (methodDescription != null) {
				valObj = methodDescription.method.invoke(serviceDesc.getInstance(), params);
			}
		}

		return valObj;
	}

	public Object invokeService(String serviceName, String methodName,
			HashMap<String, String> params, boolean parseParams) throws Exception {
		Object valObj=null;
		ServiceDescription serviceDesc=findService(serviceName);
		if (serviceDesc != null) {
			MethodDescription methodDescription = serviceDesc.getOtherMethods().get(methodName);
			HashMap<String, ? super String> jsData;
			if (parseParams) {
				HashMap<String, Object> newJsData=new HashMap<String, Object>();
				for (String key : params.keySet()) {
					newJsData.put(key, parseJson(params.get(key)));
				}
				jsData=newJsData;
			} else {
				jsData=params;
			}
			Object[] methodParam = prepareMethodParam(jsData, true, methodDescription.parameterNames, methodDescription.method.getParameterTypes());
			valObj=methodDescription.method.invoke(serviceDesc.getInstance(), methodParam);
		}
		return valObj;
	}
}
