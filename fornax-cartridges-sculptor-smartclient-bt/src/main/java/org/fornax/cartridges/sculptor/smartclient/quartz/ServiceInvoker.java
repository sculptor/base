package org.fornax.cartridges.sculptor.smartclient.quartz;

import java.util.HashMap;

public interface ServiceInvoker {
	public Object invokeService(String serviceName, String methodName, Object[] params) throws Exception;
	public Object invokeService(String serviceName, String methodName, HashMap<String, String> params, boolean parseParams) throws Exception;
}
