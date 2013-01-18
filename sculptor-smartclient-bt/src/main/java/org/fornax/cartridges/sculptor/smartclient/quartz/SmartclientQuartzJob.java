package org.fornax.cartridges.sculptor.smartclient.quartz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SmartclientQuartzJob extends QuartzJobBean {
	public static final String SERVICE_NAME="#serviceName";
	public static final String METHOD_NAME="#methodName";

	ServiceInvoker serviceInvoker;
	public void setServiceInvoker(ServiceInvoker serviceInvoker) {
		this.serviceInvoker=serviceInvoker;
	}

	protected void executeInternal(JobExecutionContext jobContext) {
		try {
			if (serviceInvoker==null) {
				throw new JobExecutionException("ServiceInvoker is null. Wrong scheduler initialization.");
			} else {
				JobDataMap jobDataMap = jobContext.getMergedJobDataMap();
				HashMap<String,String> params=new HashMap<String, String>();
				String serviceName=null;
				String methodName=null;
				for (Object key : jobDataMap.keySet()) {
					String strKey=key.toString();
					if (SERVICE_NAME.equals(strKey)) {
						serviceName=jobDataMap.getString(strKey);
					} else if (METHOD_NAME.equals(strKey)) {
						methodName=jobDataMap.getString(strKey);
					} else if (jobDataMap.get(key) instanceof String) {
						params.put(strKey, jobDataMap.getString(strKey));
					}
				}
				try {
					if (SecurityContextHolder.getContext().getAuthentication() == null) {
						Authentication auth=new UsernamePasswordAuthenticationToken("scheduler", "fumcakbob");
						SecurityContextHolder.getContext().setAuthentication(auth);
					}
					if (ServiceContextStore.get() == null) {
						ServiceContextStore.set(new ServiceContext("scheduler", "0", "Smartclient", new HashSet<String>(Arrays.asList("ROLE_SCHEDULER"))));
					}
					serviceInvoker.invokeService(serviceName, methodName, params, true);
				} catch (Exception e) {
					throw new JobExecutionException(e);
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}