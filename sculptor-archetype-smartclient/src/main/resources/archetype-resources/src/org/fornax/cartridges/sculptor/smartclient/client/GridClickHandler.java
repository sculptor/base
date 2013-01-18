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
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;


/**
 * Callback handler for list grid click event
 * 
 * @author Ing. Pavel Tavoda
 */
class GridClickHandler implements RecordClickHandler {
	com.smartgwt.client.widgets.Window subW=new com.smartgwt.client.widgets.Window();
	DynamicForm form=new DynamicForm();
	Button okButton1=new Button("Zatvorit");
	Button okButton2=new Button("Zatvorit");
	Main scmain;

	public GridClickHandler(Main scmain) {
		// Initialize button1
		Button okButton1=new Button("Zatvorit");
		okButton1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				subW.hide();
			}
		});
		okButton1.setWidth("100%");
		okButton1.setMargin(1);

		// Initialize button2
		Button okButton2=new Button("Zatvorit");
		okButton2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				subW.hide();
			}
		});
		okButton2.setWidth("100%");
		okButton2.setMargin(1);

		// Initialize internal form
		form.setNumCols(4);
		form.setMargin(10);

		// Initialize main window
		subW.setWidth("70%");
		subW.setHeight("70%");
		subW.setAutoCenter(true);
		subW.setShowHeader(true);
		subW.setShowShadow(true);
		subW.setShowCloseButton(false);
		subW.setShowMinimizeButton(false);
		subW.setTitle("Nahlad na polozku");
		subW.setModalMaskOpacity(30);
		subW.setShowModalMask(true);
		subW.setIsModal(true);
		subW.setCanDragResize(true);
		this.scmain=scmain;

		subW.addItem(okButton1);
		subW.addItem(form);
		subW.addItem(okButton2);
	}

	public void onRecordClick(RecordClickEvent event) {
		if (event.getField().getAttribute("detailOptionDS") != null
				&& event.getRecord().getAttribute(event.getField().getName()) != null) {
			DSCallback callback=new DSCallback() {
				public void execute(DSResponse response, Object rawData, DSRequest request) {
					JavaScriptObject record = JSOHelper.getValueFromJavaScriptObjectArray((JavaScriptObject) rawData, 0);
					form.editRecord(new Record(record));

					subW.show();
				}
			};

			DataSource ds = DataSource.getDataSource(event.getField().getAttribute("detailOptionDS"));
			form.setDataSource(ds);
			Criteria criteria=new Criteria();
			criteria.addCriteria("id", event.getRecord().getAttribute(event.getField().getName()));
			ds.fetchData(criteria, callback);
		}

		scmain.mainForm.onListGridSelect(event);
	}
}
