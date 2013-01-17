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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * Form detail part
 * 
 * @author Ing. Pavel Tavoda
 */
class DetailForm extends VLayout {
	private HashMap<String, Object> aggrSubForm=new HashMap<String, Object>();
	ArrayList<DynamicForm> relSubForms=new ArrayList<DynamicForm>();
	TabSet updateTabs=null;
	DetailButtons buttons;
	DynamicForm internalForm=new DynamicForm();

	public DetailForm(Main mainScreen, int margin) {
		super(margin);
		buttons=new DetailButtons(mainScreen, 10);

		internalForm.setNumCols(GuiUtil.DEFAULT_NUM_COLUMNS);
		internalForm.setWidth100();
		internalForm.disable();

		Tab fieldsTab=new Tab("Detail");
		fieldsTab.setPane(internalForm);
		updateTabs=new TabSet();
		updateTabs.setTabs(fieldsTab);
		updateTabs.setHeight100();

		setMembers(updateTabs, buttons);
		setLayoutBottomMargin(5);
		setHeight100();
	}

	/* ###########################################################################
	 * # Interface override
	 * ########################################################################### */
	Record lastRecord=null;
	public void editRecord(Record record) {
		lastRecord=record;
		internalForm.editRecord(record);
		refreshDataInSubForm(record);
	}

	public void resetValues() {
		editRecord(lastRecord);
	}

	public void saveData() {
		updateDataInDS();
		internalForm.saveData();
	}

	public void saveData(DSCallback callback) {
		updateDataInDS();
		internalForm.saveData(callback);
	}

	public void saveData(DSCallback callback, DSRequest requestProperties) {
		updateDataInDS();
		internalForm.saveData(callback, requestProperties);
	}

	public void setDataSource(JavaScriptObject guiProps, DataSource ds) {
		buttons.alignButtons(guiProps, ds.getID());

		Tab[] tabs = updateTabs.getTabs();
		updateTabs.selectTab(0);
		boolean first=true;
		for (Tab tab : tabs) {
			if (first) {
				first=false;
				continue;
			}
			updateTabs.removeTab(tab);
		}

		internalForm.clearValues();
		internalForm.setDataSource(ds);
		refreshSubForm();
		disable();
		// updateForm.reset();
		markForRedraw();
	}

	/* ###########################################################################
	 * # Implementation and helper methods
	 * ########################################################################### */
	// Click in listGrid
	public void onListGridSelect(RecordClickEvent event) {
		editRecord(event.getRecord());

		FormItem[] fields = internalForm.getFields();
		for (FormItem field : fields) {
			try {
				JavaScriptObject changed = field.getAttributeAsJavaScriptObject("changed");
				if (changed != null) {
					SelectItem selItem = SelectItem.getOrCreateRef(field.getJsObj());
					ListGridRecord selectedRecord = selItem.getSelectedRecord();
					GuiUtil.runChanged(internalForm.getOrCreateJsObj(), selItem.getJsObj(), changed, selectedRecord.getAttributeAsInt("id"));
					/*
					SelectItem selItem = SelectItem.getOrCreateRef(field.getJsObj());
					String refText = selItem.getSelectedRecord().getAttributeAsString("textRef");
					if (refText != null) {
						selItem.setHint(refText.replaceAll(" ", "&nbsp;"));
					}
					*/
				}
			} catch (Throwable th) {
				// Do nothing, just ignore null pointer exception and iterate to other form item
			}
		}

		buttons.onListGridSelect(event);
	}

	private void refreshSubForm() {
		// Destroy previous sub forms
		for (String key : aggrSubForm.keySet()) {
			Object val=aggrSubForm.get(key);
			if (val instanceof DynamicForm) {
				((DynamicForm) val).destroy();
			}
		}
		aggrSubForm.clear();

		DataSource ds=internalForm.getDataSource();
		List<CanvasItem> relCanvases=new ArrayList<CanvasItem>();
		JavaScriptObject fieldNames = GuiUtil.getFieldNames(ds);
		List<FormItem> subCanvasItems=new ArrayList<FormItem>();
		for (int i=0;  i < JSOHelper.getArrayLength(fieldNames); i++) {
			String fieldName=JSOHelper.getArrayValue(fieldNames, i);
			String type = ds.getField(fieldName).getAttribute("type");
			String isHidden=ds.getField(fieldName).getAttribute("hidden");

			String fieldTitle=ds.getField(fieldName).getAttribute("title");
			if (fieldTitle == null) {
				fieldTitle=ds.getField(fieldName).getAttribute("name");
			}
			if (type == null) {
				// normal field - do nothing
			} else if (type.equals("AssociationToManyPicklist")) {
				DataSource parentDS=DataSource.getDataSource(GuiUtil.extractDataSource(ds.getField(fieldName).getAttribute("foreignKey")));
				final DataSource subDs=new DataSource();
				subDs.setInheritsFrom(parentDS);
				subDs.setClientOnly(true);

				final ListGrid relGrid=new ListGrid();
				aggrSubForm.put(fieldName, relGrid);
				relGrid.setDataSource(subDs);
				relGrid.fetchData();
				// relGrid.setID(parentDS.getID());
				relGrid.setWidth100();
				relGrid.setHeight100();
				relGrid.setEmptyMessage("<br>Choose item and click <b>Add</b>.");

				final ComboBoxItem pickList=new ComboBoxItem(ds.getField(fieldName).getJsObj());

				DynamicForm pickListForm=new DynamicForm();
				pickListForm.setFields(pickList);
				pickListForm.setWidth("*");
				Button addButton=new Button("Add");
				addButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						ListGridRecord gridRecord = pickList.getSelectedRecord();
						ListGridRecord[] oldRecords = relGrid.getRecords();
						ListGridRecord[] newRecords=new ListGridRecord[oldRecords.length + 1];
						for (int i=0; i < oldRecords.length; i++) {
							if (oldRecords[i].getAttribute("id").equals(gridRecord.getAttribute("id"))) {
								newRecords=null;
								break;
							}
							newRecords[i]=oldRecords[i];
						}
						if (newRecords != null) {
							newRecords[oldRecords.length]=gridRecord;
							relGrid.setData(newRecords);
						}
					}
				});
				Button removeButton=new Button("Delete");
				removeButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						ListGridRecord selRecord=relGrid.getSelectedRecord();
						if (selRecord != null) {
							ListGridRecord[] oldRecords = relGrid.getRecords();
							ListGridRecord[] newRecords=new ListGridRecord[oldRecords.length - 1];
							int j=0;
							for (int i=0; i < oldRecords.length; i++) {
								if (!oldRecords[i].getAttribute("id").equals(selRecord.getAttribute("id"))) {
									newRecords[j++]=oldRecords[i];
								}
							}
							relGrid.setData(newRecords);
						}
					}
				});

				HLayout buttons=new HLayout(10);
				buttons.setMembers(pickListForm, addButton, removeButton);

				VLayout vLay=new VLayout(10);
				vLay.setHeight100();
				vLay.setMembers(relGrid, buttons);

				CanvasItem listGridItem=new CanvasItem(fieldName, fieldTitle+" Assoc");
				listGridItem.setCanvas(vLay);
				listGridItem.setShowTitle(false);
				relCanvases.add(listGridItem);
			} else if (type.equals("AssociationToMany")) {
				DataSource asDataSource=DataSource.getDataSource(GuiUtil.extractDataSource(ds.getField(fieldName).getAttribute("foreignKey")));

				final ListGrid relGrid=new ListGrid();
				aggrSubForm.put(fieldName, relGrid);
				relGrid.setDataSource(asDataSource);
				relGrid.setShowAllRecords(false);
				relGrid.setAutoFetchData(true);
				relGrid.setDataPageSize(30);
				relGrid.setMinHeight(150);
				relGrid.setWidth100();
				relGrid.setHeight100();
				relGrid.setSelectionType(SelectionStyle.SIMPLE);
				relGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
				relGrid.fetchData();

				Label relLabel=new Label(ds.getField(fieldName).getAttribute("assocDataSource"));
				relLabel.setHeight("*");
				VLayout vLay=new VLayout(10);
				vLay.setHeight100();
				vLay.setMembers(relLabel, relGrid);

				CanvasItem listGridItem=new CanvasItem(fieldName, fieldTitle+" Assoc" );
				listGridItem.setCanvas(vLay);
				listGridItem.setShowTitle(false);

				relCanvases.add(listGridItem);
			} else if (type.equals("AssociationToManyMap")) {
				ListGrid relGrid=new ListGrid();
				relGrid.setID(ds.getField(fieldName).getName());

				CanvasItem listGridItem=new CanvasItem(fieldName, fieldTitle+" Assoc");
				listGridItem.setCanvas(relGrid);
				listGridItem.setName(relGrid.getID());
			} else if (type.equals("AggregationToOne")) {
				GWT.log("AggrToOne: "+fieldName, null);
				DataSource aggrToOneDS=DataSource.getDataSource(ds.getField(fieldName).getAttribute("foreignDS"));
				DynamicForm aggrForm=new DynamicForm();
				aggrForm.setNumCols(getEmbededNumCols());
				aggrForm.setDataSource(aggrToOneDS);
				aggrSubForm.put(fieldName, aggrForm);

				List<FormItem> formItems=new ArrayList<FormItem>();
				/*
				CheckboxItem cbItem=new CheckboxItem(fieldName);
				cbItem.setEndRow(true);
				cbItem.addChangedHandler(new ChangedHandler() {
					public void onChanged(ChangedEvent event) {
						FormItem[] formFields = aggrForm.getFields();
						if ("true".equals(event.getValue().toString())) {
							for (FormItem formField : formFields) {
								formField.enable();
							}
						} else {
							for (FormItem formField : formFields) {
								if (!formField.equals(event.getItem())) {
									formField.disable();
								}
							}
						}
					}
				});
				cbItem.setValue(true);
				formItems.add(cbItem);
				*/

				JavaScriptObject fldNames = GuiUtil.getFieldNames(aggrToOneDS);
				if (JSOHelper.getArrayLength(fldNames) == 1) {
					String str=JSOHelper.getArrayValue(fldNames, 0);
					DataSourceField dsField = aggrToOneDS.getField(str);
					FormItem frmItem = new FormItem(dsField.getJsObj());
					frmItem.setTitle("");
					aggrForm.setFields(frmItem);
					aggrForm.setTitleWidth(0);
					aggrForm.setTitleSuffix("");
					aggrForm.setBorder("0px");
					aggrForm.setPadding(0);
				} else {
					for (int l=0; l < JSOHelper.getArrayLength(fldNames); l++) {
						String str=JSOHelper.getArrayValue(fldNames, l);
						DataSourceField dsField = aggrToOneDS.getField(str);
						if (!dsField.getHidden()) {
							JavaScriptObject fieldJS=dsField.getJsObj();

							String detailDS = JSOHelper.getAttribute(fieldJS, "detailOptionDS");
							if (detailDS != null) {
								JSOHelper.setAttribute(fieldJS, "optionDataSource", detailDS);
								JavaScriptObject[] pickList = JSOHelper.getAttributeAsJavaScriptObjectArray(fieldJS, "pickListFields");
								if (pickList != null && pickList.length > 0) {
									JSOHelper.setAttribute(fieldJS, "displayField", JSOHelper.getAttribute(pickList[0], "name"));
								}
							}
							FormItem frmItem = new FormItem(fieldJS);
							formItems.add(frmItem);
						}
					}
					// aggrForm.setIsGroup(true);
					aggrForm.setFields(formItems.toArray(new FormItem[formItems.size()]));
				}

				CanvasItem subCanvasItem=new CanvasItem(fieldName, fieldTitle+" Aggr");
				subCanvasItem.setCanvas(aggrForm);
				subCanvasItem.setStartRow(true);
				subCanvasItem.setEndRow(true);
				subCanvasItem.setColSpan(getEmbededNumCols()+1);
				subCanvasItem.setWidth("*");
				subCanvasItem.setShowTitle(true);
				// subCanvasItem.setTitleOrientation(TitleOrientation.TOP);

				subCanvasItems.add(subCanvasItem);
			} else if (type.equals("AggregationToMany")) {
				DataSource parentDS=DataSource.getDataSource(ds.getField(fieldName).getAttribute("foreignDS"));
				DataSource subDS=new DataSource();
				subDS.setInheritsFrom(parentDS);
				subDS.setClientOnly(true);

				ListGrid relGrid=new ListGrid();
				relGrid.setDataSource(subDS);
				// relGrid.setID(parentDS.getID());
				relGrid.setWidth100();
				relGrid.setHeight100();
				relGrid.setEmptyMessage("<br>For inserting new item press <b>Add</b>.");
				aggrSubForm.put(fieldName, relGrid);

				Button addButton=new Button("Add");
				addButton.addClickHandler(new AddAggregatedRecordHandler(getEmbededNumCols(), subDS, relGrid, true));

				Button upravButton=new Button("Edit");
				upravButton.addClickHandler(new AddAggregatedRecordHandler(getEmbededNumCols(), subDS, relGrid, false));

				Button removeButton=new Button("Delete");
				removeButton.addClickHandler(new DeleteAggregatedRecordHandler(relGrid));

				HLayout buttons=new HLayout(10);
				buttons.setAlign(Alignment.RIGHT);
				buttons.setMembers(addButton, upravButton, removeButton);

				VLayout vLay=new VLayout(10);
				vLay.setHeight100();
				vLay.setMembers(relGrid, buttons);

				CanvasItem listGridItem=new CanvasItem(fieldName, fieldTitle+" Aggr");
				listGridItem.setCanvas(vLay);
				GWT.log("aggrDataSource value from server: "+ds.getField(fieldName).getAttribute("foreignDS"), null);
				listGridItem.setShowTitle(false);
				relCanvases.add(listGridItem);
			} else if (isHidden == null || !isHidden.equals("true")) {
				JavaScriptObject fieldJS=JSOHelper.createObject();
				JSOHelper.apply(ds.getField(fieldName).getJsObj(), fieldJS);
				String detailDS = JSOHelper.getAttribute(fieldJS, "detailOptionDS");
				if (detailDS != null) {
					JSOHelper.setAttribute(fieldJS, "optionDataSource", detailDS);
					JavaScriptObject[] pickList = JSOHelper.getAttributeAsJavaScriptObjectArray(fieldJS, "pickListFields");
					if (pickList != null && pickList.length > 0) {
						JSOHelper.setAttribute(fieldJS, "displayField", JSOHelper.getAttribute(pickList[0], "name"));
					}
				}
				FormItem fi=new FormItem(fieldJS);
				subCanvasItems.add(fi);
			}
		}
		if (subCanvasItems.size() > 0) {
			FormItem fields[] = new FormItem[subCanvasItems.size()];
			int i=0;
			for (FormItem field : subCanvasItems) {
				fields[i++]=field;
			}
			internalForm.setFields(fields);
			// GWT error
			// internalForm.setFields(subCanvasItems.toArray(new FormItem[subCanvasItems.size()]));
		}

		relSubForms.clear();

		for (CanvasItem cnvsItem : relCanvases) {
			DynamicForm newRelForm=new DynamicForm();
			relSubForms.add(newRelForm);
			newRelForm.setTitleOrientation(TitleOrientation.TOP);
			newRelForm.setNumCols(1);
			newRelForm.setWidth100();
			newRelForm.setHeight100();
			newRelForm.setFields(cnvsItem);
			newRelForm.disable();

			Tab newRelTab=new Tab(cnvsItem.getName());
			newRelTab.setPane(newRelForm);
			updateTabs.addTab(newRelTab);
		}
	}

	private void refreshDataInSubForm(Record record) {
		DataSource ds=internalForm.getDataSource();
		String[] fieldNames = ds.getFieldNames();
		for (String fieldName : fieldNames) {
			String type = ds.getField(fieldName).getAttribute("type");
			if (type == null) {
				// normal field - do nothing
			} else if (type.equals("AssociationToManyPicklist")) {
				GWT.log("AssociationToManyPickList for "+fieldName, null);

				// Get array value from server
				if (record != null && record.getAttributeAsJavaScriptObject(fieldName) != null) {
					JSONArray fieldVal = new JSONArray(record.getAttributeAsJavaScriptObject(fieldName));

					// Iterate through recods in list
					ListGrid aggrList=(ListGrid) aggrSubForm.get(fieldName);
					aggrList.deselectAllRecords();
					ListGridRecord[] records = aggrList.getRecords();
					for (ListGridRecord rec : records) {
						for (int j=0; j < fieldVal.size(); j++) {
							if (!fieldVal.get(j).toString().equals(rec.getAttribute("id"))) {
								aggrList.selectRecord(rec);
							}
						}
					}
					aggrList.removeSelectedData();
				}
			} else if (type.equals("AssociationToMany")) {
				GWT.log("AssociationToMany for "+fieldName, null);

				// Get array value from server
				if (record != null && record.getAttributeAsJavaScriptObject(fieldName) != null) {
					JSONArray fieldVal = new JSONArray(record.getAttributeAsJavaScriptObject(fieldName));

					// Iterate through recods in list
					ListGrid aggrList=(ListGrid) aggrSubForm.get(fieldName);
					aggrList.deselectAllRecords();
					try {
						ListGridRecord[] records = aggrList.getRecords();
						for (ListGridRecord rec : records) {
							for (int j=0; j < fieldVal.size(); j++) {
								if (fieldVal.get(j).toString().equals(rec.getAttribute("id"))) {
									aggrList.selectRecord(rec);
								}
							}
						}
					} catch (Throwable e) {
						GWT.log("error", e);
					}

				}
			} else if (type.equals("AssociationToManyMap")) {
			} else if (type.equals("AggregationToOne")) {
				DynamicForm subForm=(DynamicForm) aggrSubForm.get(fieldName);
				if (record != null) {
					ListGridRecord newRecord=new ListGridRecord(record.getAttributeAsJavaScriptObject(fieldName));
					subForm.editRecord(newRecord);
					subForm.markForRedraw();
				}
			} else if (type.equals("AggregationToMany")) {
				if (record != null) {
					ListGrid subList=(ListGrid) aggrSubForm.get(fieldName);
					
//					for (String y : selectedRecord.getAttributes()) {
//						try {
//							GWT.log(  y +"=" + selectedRecord.getAttributeAsObject(y), new Exception());
//						} catch (Throwable e) {
//							GWT.log(y +"=error", e);
//						}
//					}
					JavaScriptObject fieldValue = record.getAttributeAsJavaScriptObject(fieldName);
					//GWT.log("field: "+fieldName+" :: value="+fieldValue+" ["+JSOHelper.getArrayLength(fieldValue)+"]", null);
					ArrayList<ListGridRecord> subRecords=new ArrayList<ListGridRecord>();
					for (int j=0; fieldValue != null && j < JSOHelper.getArrayLength(fieldValue); j++) {
						JavaScriptObject arrValue=JSOHelper.getValueFromJavaScriptObjectArray(fieldValue, j);
						subRecords.add(new ListGridRecord(arrValue));
					}
					subList.setData(subRecords.toArray(new ListGridRecord[subRecords.size()]));
				}
			}
		}
	}

	private void updateDataInDS() {
		DataSource ds=internalForm.getDataSource();
		boolean isFileUpload = JSOHelper.getAttributeAsBoolean(ds.getJsObj(), "isFileUpload");
		if (isFileUpload) {
			uploadFiles();
		}
		JavaScriptObject fieldNames = GuiUtil.getFieldNames(ds);
		for (int i=0;  i < JSOHelper.getArrayLength(fieldNames); i++) {
			String fieldName=JSOHelper.getArrayValue(fieldNames, i);
			String type = ds.getField(fieldName).getAttribute("type");
			if (type == null) {
				// normal field - do nothing
			} else if (type.equals("AssociationToManyPicklist")) {
			} else if (type.equals("AssociationToMany")) {
				GWT.log("Save AssociationToMany for "+fieldName, null);

				// Iterate through recods in list
				ListGrid aggrList=(ListGrid) aggrSubForm.get(fieldName);
				ListGridRecord[] selRecords = aggrList.getSelection();
				JavaScriptObject result = JavaScriptObject.createObject();
				for (int j=0; j < selRecords.length; j++) {
					JSOHelper.setAttribute(result, "f"+j, selRecords[j].getAttribute("id"));
				}
				JavaScriptObject values = getValues(internalForm);
				JSOHelper.setAttribute(values, fieldName, result);
			} else if (type.equals("AssociationToManyMap")) {
			} else if (type.equals("AggregationToOne")) {
				DynamicForm subForm=(DynamicForm) aggrSubForm.get(fieldName);
				JavaScriptObject values = getValues(subForm);
				internalForm.setValue(fieldName, values);
			} else if (type.equals("AggregationToMany")) {
				ListGrid subList=(ListGrid) aggrSubForm.get(fieldName);
				ListGridRecord[] records = subList.getRecords();
				JavaScriptObject valArray=JavaScriptObject.createObject();
				for (int j=0; j < records.length; j++) {
					JSOHelper.setAttribute(valArray, "f"+j, records[j].getJsObj());
				}
				JavaScriptObject values = getValues(internalForm);
				JSOHelper.setAttribute(values, fieldName, valArray);
			}
		}
	}

	public void editNewRecord() {
		internalForm.editNewRecord();
		DataSource ds=internalForm.getDataSource();
		JavaScriptObject fieldNames = GuiUtil.getFieldNames(ds);
		for (int i=0;  i < JSOHelper.getArrayLength(fieldNames); i++) {
			String fieldName=JSOHelper.getArrayValue(fieldNames, i);
			String type = ds.getField(fieldName).getAttribute("type");
			if (type == null) {
				// normal field - do nothing
			} else if (type.equals("AssociationToManyPicklist")) {
			} else if (type.equals("AssociationToMany")) {
				ListGrid subForm=(ListGrid) aggrSubForm.get(fieldName);
				subForm.deselectAllRecords();
			} else if (type.equals("AssociationToManyMap")) {
			} else if (type.equals("AggregationToOne")) {
			} else if (type.equals("AggregationToMany")) {
				ListGrid subForm=(ListGrid) aggrSubForm.get(fieldName);
				subForm.selectAllRecords();
				subForm.removeSelectedData();
			}
		}
	}

	public void uploadFiles() {
		DynamicForm mainForm = internalForm;
		Canvas[] childrens = mainForm.getChildren(); 
		for (Canvas children : childrens) {
			if (children.isVisible()) {
				SC.logEcho(children);
				DynamicForm df=DynamicForm.getOrCreateRef(children.getJsObj());
				if (df != null) {
					String action = df.getAction();

					df.setEncoding(Encoding.MULTIPART);
					df.setAction(Main.serviceUrl+"/upload");
					children.getDOM().getFirstChildElement().setAttribute("target", "upload");
					df.submitForm();

					df.setEncoding(Encoding.NORMAL);
					df.setAction(action);
					children.getDOM().getFirstChildElement().removeAttribute("target");
					/*
					Element dom = children.getDOM().getFirstChildElement();
					dom.setAttribute("encoding", "multipart/form-data");
					dom.setAttribute("action", Main.serviceUrl+"/upload");
					dom.setAttribute("target", "upload");
					formSubmit(dom);
					*/
				}
			}
		}
	}

	public void disable() {
		internalForm.disable();

		for (DynamicForm subForm : relSubForms) {
			System.out.println("Disable for "+subForm.getID());
			subForm.disable();
		}
/*
		for (String key : aggrSubForm.keySet()) {
			System.out.println("Disable for "+key);
			Object form=aggrSubForm.get(key);
			if (form instanceof ListGrid) {
				((ListGrid) form).disable();
			} else if (form instanceof DynamicForm) {
				((DynamicForm) form).disable();
			} else {
				GWT.log("ERROR: disable() for unknown type of subform "+form.getClass(), null);
			}
		}
		*/
	}

	public void enable() {
		internalForm.enable();

		for (DynamicForm subForm : relSubForms) {
			System.out.println("Enable for "+subForm.getID());
			subForm.enable();
		}
		/*
		for (String key : aggrSubForm.keySet()) {
			System.out.println("Enable for "+key);
			Object form=aggrSubForm.get(key);
			if (form instanceof ListGrid) {
				((ListGrid) form).enable();
			} else if (form instanceof DynamicForm) {
				((DynamicForm) form).enable();
			} else {
				GWT.log("ERROR: enable() for unknown type of subform "+form.getClass(), null);
			}
		}
		*/
	}
	public native JavaScriptObject getValues(DynamicForm form) /*-{
		var self = form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
		return self.getValues();
	}-*/;

	/* ###########################################################################
	 * # Getters and setters
	 * ########################################################################### */

	private int numCols=-1;

	public int getEmbededNumCols() {
		return numCols == -1 ? internalForm.getNumCols() : numCols;
	}

	public void setEmbededNumCols(int numCols) {
		this.numCols=numCols;
	}
}

class AddAggregatedRecordHandler implements ClickHandler {
	Window subW=null;
	int numCols;
	DataSource subDS;
	ListGrid relGrid;
	boolean editNew;
	ListGridRecord selRecord=null;							

	public AddAggregatedRecordHandler(int numCols, DataSource subDS, ListGrid relGrid, boolean editNew) {
		this.numCols=numCols;
		this.subDS=subDS;
		this.relGrid=relGrid;
		this.editNew=editNew;
	}

	public void onClick(ClickEvent event) {
		if (subW == null) {
			subW=new Window();
			subW.setWidth("60%");
			subW.setHeight("60%");
			subW.setAutoCenter(true);
	
			subW.setShowHeader(true);
			subW.setShowShadow(true);
			subW.setShowCloseButton(false);
			subW.setShowMinimizeButton(false);
			subW.setTitle("Add item");
			subW.setModalMaskOpacity(30);
			subW.setShowModalMask(true);
			subW.setIsModal(true);
			subW.setCanDragResize(true);
	
			final DynamicForm form=new DynamicForm();

			form.setNumCols(numCols);
			form.setDataSource(subDS);
			form.setMargin(10);

			JavaScriptObject fieldNames = GuiUtil.getFieldNames(subDS);
			List<FormItem> subCanvasItems=new ArrayList<FormItem>();
			for (int i=0;  i < JSOHelper.getArrayLength(fieldNames); i++) {
				String fieldName=JSOHelper.getArrayValue(fieldNames, i);
				String isHidden=subDS.getField(fieldName).getAttribute("hidden");
				if (isHidden == null || !isHidden.equals("true")) {
					JavaScriptObject fieldJS=JSOHelper.createObject();
					JSOHelper.apply(subDS.getField(fieldName).getJsObj(), fieldJS);
					String detailDS = JSOHelper.getAttribute(fieldJS, "detailOptionDS");
					if (detailDS != null) {
						JSOHelper.setAttribute(fieldJS, "optionDataSource", detailDS);
						JavaScriptObject[] pickList = JSOHelper.getAttributeAsJavaScriptObjectArray(fieldJS, "pickListFields");
						if (pickList != null && pickList.length > 0) {
							JSOHelper.setAttribute(fieldJS, "displayField", JSOHelper.getAttribute(pickList[0], "name"));
						}
					}
					FormItem fi=new FormItem(fieldJS);
					subCanvasItems.add(fi);
				}
			}
			if (subCanvasItems.size() > 0) {
				FormItem fields[] = new FormItem[subCanvasItems.size()];
				int i=0;
				for (FormItem field : subCanvasItems) {
					fields[i++]=field;
				}
				form.setFields(fields);
			}

			if (editNew) {
				form.editNewRecord();
			} else {
				form.editSelectedData(relGrid);
			}
			subW.addItem(form);
	
			Button okButton=new Button("OK");
			okButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if (form.validate()) {
						if (editNew) {
							JavaScriptObject formVals=GuiUtil.getFormValues(form);
							ListGridRecord[] oldRecords=relGrid.getRecords();
							ListGridRecord[] records=new ListGridRecord[oldRecords.length + 1];
							for (int i=0; i < oldRecords.length; i++) {
								records[i]=oldRecords[i];
							}
							records[oldRecords.length]=new ListGridRecord(formVals);
							relGrid.setData(records);
						} else {
							JavaScriptObject formVals=GuiUtil.getFormValues(form);
							ListGridRecord newRecord=new ListGridRecord(formVals);

							selRecord=relGrid.getSelectedRecord();
							ListGridRecord[] oldRecords=relGrid.getRecords();
							for (int i=0; i < oldRecords.length; i++) {
								if (oldRecords[i].getJsObj().equals(selRecord.getJsObj())) {
									oldRecords[i]=newRecord;
									break;
								}
							}
							relGrid.setData(oldRecords);
						}

						subW.hide();
						subW=null;
					}
				}
			});
			Button cancelButton=new Button("Cancel");
			cancelButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					form.clearValues();
					subW.hide();
					subW=null;
				}
			});
			HLayout buttons=new HLayout(10);
			buttons.setAlign(Alignment.RIGHT);
			buttons.setMargin(10);
			buttons.setMembers(okButton, cancelButton);
			subW.addItem(buttons);
		}
	
		subW.show();
	}
}

class DeleteAggregatedRecordHandler implements ClickHandler {
	ListGrid subGrid;
	public DeleteAggregatedRecordHandler(ListGrid grid) {
		subGrid=grid;
	}

	public void onClick(ClickEvent event) {
		GWT.log("Delete aggregated record "+GuiUtil.getVariableValue(subGrid.getSelectedRecord().getJsObj()), null);
		ListGridRecord selRecord=subGrid.getSelectedRecord();
		if (selRecord != null) {
			ListGridRecord[] oldRecords = subGrid.getRecords();
			ListGridRecord[] newRecords=new ListGridRecord[oldRecords.length - 1];
			int j=0;
			for (int i=0; i < oldRecords.length; i++) {
				if (!oldRecords[i].getJsObj().equals(selRecord.getJsObj())) {
					newRecords[j++]=oldRecords[i];
				}
			}
			subGrid.setData(newRecords);
		}
	}
}
