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
package org.fornax.cartridges.sculptor.smartclient.client;

import java.util.Date;
import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

/**
 * Client side COMET callback
 * 
 * @author Ing. Pavel Tavoda
 */
class Comet implements DSCallback {
	Main scmain;
	DSRequest cometRequest;
	long startTime;
	private static final long MAX_INACTIVE_COMET=5 * 60 * 1000; // 5 min

	public Comet(Main smartclientMain) {
		this.scmain=smartclientMain;

		HashMap<String, String> params=new HashMap<String, String>();
		params.put("_dataSource", "clientCommandService");
		params.put("_operationType", "fetch");
		params.put("_operationId", "getCommands");

		cometRequest=new DSRequest();
		cometRequest.setShowPrompt(false);
		cometRequest.setActionURL(Main.serviceUrl);
		cometRequest.setParams(params);
		cometRequest.setEvalResult(false);
		cometRequest.setWillHandleError(true);
	}

	public void execute(DSResponse response, Object rawData, DSRequest request) {
		String strResult=(String) rawData;
		int commandSize=0;

		GWT.log("WAITING "+(getCurrentTime()-startTime)+" :: "+response.getHttpResponseCode()+" :: "+response.getStatus()+" :: "+strResult, null);
		try {
			if (strResult != null && strResult.startsWith("{")) {
				JavaScriptObject result = GuiUtil.getStringAsJavaScriptObject("("+strResult+")");
				JavaScriptObject dataResp= result != null ? JSOHelper.getAttributeAsJavaScriptObject(result, "response") : null;
				JavaScriptObject[] dataArr= dataResp != null ? JSOHelper.getAttributeAsJavaScriptObjectArray(dataResp, "data") : null;
				if (dataArr != null) {
					commandSize=dataArr.length;
					for (int i=0; i < dataArr.length; i++) {
						String command=JSOHelper.getAttribute(dataArr[i], "commandType");
						if (command == null) {
						} else if (command.startsWith("SHOW_MESSAGE")) {
							SC.say(JSOHelper.getAttribute(dataArr[i], "parameter1"));
						}
					}
				}
			}
		} catch (Throwable th) {
			GWT.log("Error processing commands", th);
		}

		if (response.getHttpResponseCode() == 200 && (commandSize > 0 || getCurrentTime()-startTime > 15*1000)) {
			GWT.log("Making new comet request", null);
			startTime=getCurrentTime();
			GuiUtil.RPCManagerSend(null, this, cometRequest);
		} else {
			GWT.log("Error in commet request -> Stopping comet", null);
		}
	}

	public void startComet() {
		if ((getCurrentTime()-startTime) > MAX_INACTIVE_COMET && Main.allowComet) {
			startTime=getCurrentTime();
			GWT.log("Starting comet", null);
			GuiUtil.RPCManagerSend(null, this, cometRequest);
		}
	}

	private long getCurrentTime() {
		return (new Date()).getTime();
	}
};
