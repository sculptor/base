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

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.grid.ListGrid;

/**
 * Implementation of reusable code and some JavaScript methods available in SmartClient library
 * which I'm missing in SmartGWT
 * 
 * @author Ing. Pavel Tavoda
 */
public class GuiUtil {
	static int DEFAULT_NUM_COLUMNS=4;

	public static String extractDataSource(String foreignField) {
		int dotOffset=foreignField.indexOf('.');
		return dotOffset == -1 ? "" : foreignField.substring(0, dotOffset);
	}

	public static native JavaScriptObject getFieldNames(DataSource ds) /*-{
	    var self = ds.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
	    return self.getFieldNames();
	}-*/;

	public static native JavaScriptObject getFormValues(DynamicForm form) /*-{
    var self = form.@com.smartgwt.client.widgets.form.DynamicForm::getOrCreateJsObj()();
    return self.getValues();
	}-*/;

	public static native JavaScriptObject getMembers(ValuesManager valuesManager) /*-{
    	var self = valuesManager.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
    	return self.members;
	}-*/;

	public static String getVariableValue(JavaScriptObject value) {
		String[] propList = JSOHelper.getProperties(value);
		StringBuilder sBuilder=new StringBuilder();
		for (int i=0; i < propList.length; i++) {
			try {
				sBuilder.append(propList[i]).append(": '").append(JSOHelper.getAttribute(value, propList[i])).append("'\n");
			} catch (Exception e) {
				// do nothing
			}
		}
		return sBuilder.toString();
	}

	public static native JavaScriptObject getStringAsJavaScriptObject(String str) /*-{
		return eval(str);
	}-*/;

	public static native JavaScriptObject[] getStringAsJavaScriptObjectArray(String str) /*-{
		var arrayJS = eval(str);
		return (arrayJS === undefined) ? null : @com.smartgwt.client.util.JSOHelper::toArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrayJS);
	}-*/;

	public static native void RPCManagerSend(JavaScriptObject data, DSCallback callback, DSRequest requestProperties) /*-{
	    var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
	    $wnd.isc.RPCManager.send(data, function (dsResponse, data, dsRequest) {
	    	if(callback != null) {
	        	var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
	        	var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
	         	callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
	         }
		}, requestPropertiesJS);
	}-*/;

	public static native void setDateChooserLocalization(String today, String cancel) /*-{
		$wnd.isc.DateChooser.addProperties({todayButtonTitle:today});
		$wnd.isc.DateChooser.addProperties({cancelButtonTitle:cancel});
	}-*/;

	public static native void setShortDayNames(String ne, String po, String ut, String st, String stv, String pi, String so) /*-{
		$wnd.isc.addProperties($wnd.Date, {shortDayNames: [ne, po, ut, st, stv, pi, so]});
	}-*/;

	public static native void setShortMonthNames(String jan, String feb, String mar, String apr, String may, String jun, String jul, String aug, String sep, String oct, String nov, String dec) /*-{
		$wnd.isc.addProperties($wnd.Date, {shortMonthNames: [jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec]});
	}-*/;

	public static native void runChanged(JavaScriptObject internalForm, JavaScriptObject field, JavaScriptObject changed, Integer value) /*-{
		changed(internalForm, field, value);
	}-*/;

	public static native void clearSort(ListGrid actualGrid) /*-{
		var self = actualGrid.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
		self.clearSort();
	}-*/;
}
