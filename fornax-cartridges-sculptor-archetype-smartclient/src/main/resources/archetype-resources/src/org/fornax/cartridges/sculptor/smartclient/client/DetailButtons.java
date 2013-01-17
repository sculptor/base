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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.State;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;

/**
 * Buttons on detail form
 * 
 * @author Ing. Pavel Tavoda
 */
public class DetailButtons extends HLayout {
	public static final String GUI_PROPS = "guiProps";

	DetailMode detailMode=DetailMode.VIEW;
	boolean isRecordSelected=false;
	Main mainScreen;

	Button cancelButton=new Button("Cancel");
	Button editButton=new Button("Edit");
	Button newButton=new Button("New");
	Button upload=new Button("Upload");

	ClickHandler actionButtonClickHandler=new ClickHandler() {
		public void onClick(ClickEvent event) {
			onActionButtonClick(event);
		}
	};

	final DSCallback backToViewMode=new DSCallback() {
		public void execute(DSResponse response, Object rawData, DSRequest request) {
			if (response.getStatus() == 0) {
				Record[] data = response.getData();
				if (data != null && data.length > 0) {
					mainScreen.mainForm.editRecord(data[0]);
				} else {
					mainScreen.mainForm.resetValues();
				}
				mainScreen.mainForm.disable();

				mainScreen.actualGrid.markForRedraw();
				setDetailMode(DetailMode.VIEW);
			} else if (response.getStatus() != 0) {
				SC.say(response.getAttribute("data"));
			}
		}
	};

	// Setup buttons for detail
	public DetailButtons(Main mainScreen, int membersMargin) {
		super(membersMargin);
		this.mainScreen=mainScreen;
		setAlign(Alignment.RIGHT);

		newButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				onNewButtonClick();
			}
		});

		editButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				onEditButtonClick();
			}
		});

		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				onCancelButtonClick();
			}
		});

		upload.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				uploadFiles();
			}
		});

		newButton.setAutoFit(true);
		editButton.setAutoFit(true);
		cancelButton.setAutoFit(true);
		upload.setAutoFit(true);
		setMembers(newButton, editButton, cancelButton); //, upload);

		isRecordSelected=false;
		setDetailMode(DetailMode.UNKNOWN);
	}

	void alignButtons(JavaScriptObject guiProps, String serviceName) {
		// Remove unused buttons
		Canvas[] members = getMembers();
		for (Canvas member : members) {
			if (!member.equals(cancelButton)
					&& !member.equals(editButton)
					&& !member.equals(newButton)
					&& !member.equals(upload)) {
				member.destroy();
			}
		}

		// Add new button actions
		boolean hasEditAction=false;
		boolean hasNewAction=false;
		List<Canvas> newButtons=new ArrayList<Canvas>();
		for (int u=0; u < JSOHelper.getArrayLength(guiProps); u++) {
			JavaScriptObject guiProp = JSOHelper.getValueFromJavaScriptObjectArray(guiProps, u);
			String visibleOn = JSOHelper.getAttribute(guiProp, "visibleOn");
			String detailBehavior=JSOHelper.getAttribute(guiProp, "detailBehavior");
			if (visibleOn == null || (visibleOn.contains("_DETAIL") && !"NONE".equalsIgnoreCase(detailBehavior))) {
				Button actionButton=new Button(JSOHelper.getAttribute(guiProp, "guiName"));
				actionButton.addClickHandler(actionButtonClickHandler);
				actionButton.setAutoFit(true);
				JSOHelper.setAttribute(actionButton.getConfig(), GUI_PROPS, guiProp);

				actionButton.setPrompt(JSOHelper.getAttribute(guiProp, "guiHover"));
				if (! (detailBehavior.contains("_ALL") || detailBehavior.contains("_VIEW")) ) {
					actionButton.disable();
				}
				if (detailBehavior.contains("_ALL") || detailBehavior.contains("_EDIT")) {
					hasEditAction=true;
				}
				if (detailBehavior.contains("_ALL") || detailBehavior.contains("_NEW")) {
					hasNewAction=true;
				}
				newButtons.add(actionButton);
			}
		}
		Button[] buttArray=newButtons.toArray(new Button[newButtons.size()]);
		Arrays.sort(buttArray, new Comparator<Button>() {
			public int compare(Button b1, Button b2) {
				int retVal;
				String b1Title=b1.getTitle();
				String b2Title=b2.getTitle();
				if (b1Title != null && b2Title != null) {
					retVal=b1.getTitle().compareTo(b2.getTitle());
				} else if (b1Title == null) {
					retVal=-1;
				} else {
					retVal=1;
				}
				return retVal;
			}
		});

		// Following crash in GWT
		// newButtons = Arrays.asList(buttArray);
		newButtons.clear();
		for (int i=0; i < buttArray.length; i++) {
			newButtons.add(buttArray[i]);
		}

		if (hasEditAction || hasNewAction) {
			newButtons.add(0, cancelButton);
		}
		if (hasEditAction) {
			newButtons.add(0, editButton);
			// newButtons.add(0, upload);
		}
		if (hasNewAction) {
			newButtons.add(0, newButton);
		}

		setMembers();
		for (Canvas button : newButtons) {
			addMember(button);
		}

		isRecordSelected=false;
		setDetailMode(DetailMode.UNKNOWN);
	}

	public void onActionButtonClick(ClickEvent event) {
		Button actionButton=(Button) event.getSource();
		JavaScriptObject guiProps = JSOHelper.getAttributeAsJavaScriptObject(actionButton.getConfig(), GUI_PROPS);
		String action=JSOHelper.getAttribute(guiProps, "doAction");
		if (action!=null && action.startsWith(Main.JAVASCRIPT_PREFIX)) {
			try {
				String execCode=action.substring(Main.JAVASCRIPT_PREFIX.length());
				GWT.log("executing javascript: "+execCode, null);
				GuiUtil.getStringAsJavaScriptObject(execCode);
			} catch (Throwable th) {
				GWT.log("Evaluation error", th);
				SC.say(th.getMessage());
			}
		} else if ("debug".equals(action)) {
			Window debugWin=new DebugWindow();
			debugWin.show();
		} else {
			try {
				JavaScriptObject guiProp = JSOHelper.getAttributeAsJavaScriptObject(actionButton.getConfig(), GUI_PROPS);
				String methodName=JSOHelper.getAttribute(guiProp, "methodName");
				String guiName=JSOHelper.getAttribute(guiProp, "guiName");

				DSRequest serverReq=new DSRequest();
				serverReq.setOperationId(methodName);
				serverReq.setPrompt("Executing action "+guiName);
				mainScreen.mainForm.saveData(backToViewMode, serverReq);
			} catch (Throwable th) {
				GWT.log("Execute command error", th);
			}
		}
	}

	public void onNewButtonClick() {
		mainScreen.actualGrid.deselectAllRecords();
		mainScreen.mainForm.editNewRecord();
		mainScreen.mainForm.enable();
		setDetailMode(DetailMode.NEW);
	}

	public void onEditButtonClick() {
		mainScreen.mainForm.enable();
		setDetailMode(DetailMode.EDIT);
	}

	public void uploadFiles() {
		DynamicForm mainForm = mainScreen.mainForm.internalForm;
		Canvas[] childrens = mainForm.getChildren(); 
		for (Canvas children : childrens) {
			if (children.isVisible()) {
				SC.logEcho(children);
				DynamicForm df=DynamicForm.getOrCreateRef(children.getJsObj());
				if (df != null) {
					df.setEncoding(Encoding.MULTIPART);
					df.setAction(Main.serviceUrl+"/upload");
					children.getDOM().getFirstChildElement().setAttribute("target", "upload");
					df.submitForm();
					/*
					df.setEncoding(Encoding.MULTIPART);
					df.setAction(Main.serviceUrl+"/upload");
					df.setTarget("upload");
					df.submitForm();

					Element dom = children.getDOM().getFirstChildElement();
					dom.setAttribute("encoding", "multipart/form-data");
					dom.setAttribute("action", Main.serviceUrl+"/upload");
					dom.setAttribute("target", "upload");
					formSubmit(dom);
					*/
				}
			}
		}
		/*
		mainForm.setEncoding(Encoding.MULTIPART);
		mainForm.setAction(Main.serviceUrl+"/upload");
		mainForm.setTarget("upload");
		mainForm.submit();
		*/
	}

	public void onCancelButtonClick() {
		mainScreen.mainForm.disable();
		mainScreen.mainForm.resetValues();

		if (isRecordSelected) {
			setDetailMode(DetailMode.VIEW);
		} else {
			setDetailMode(DetailMode.UNKNOWN);
		}
	}

	// Click in listGrid
	public void onListGridSelect(RecordClickEvent event) {
		if (DetailMode.EDIT.equals(getDetailMode()) || DetailMode.NEW.equals(getDetailMode())) {
			SC.ask("Abandon changes?", new BooleanCallback() {
				public void execute(Boolean value) {
					if (value) {
						onCancelButtonClick();
					}
				}
			});
		}
		if (DetailMode.VIEW.equals(getDetailMode()) || DetailMode.UNKNOWN.equals(getDetailMode())) {
			if (DetailMode.UNKNOWN.equals(getDetailMode())) {
				isRecordSelected=true;
			}
			GWT.log("setDetailMode current state="+getDetailMode(), null);
			setDetailMode(DetailMode.VIEW);
		}
	}

	/*
	 * Detail mode getter and setter. Setter is also doing all status changes
	 */
	private DetailMode getDetailMode() {
		return detailMode;
	}

	private void enableButton (Button btn) {
		btn.enable();
		btn.setState(State.STATE_UP);
	}

	private void setDetailMode(DetailMode newStatus) {
		detailMode=newStatus;

		boolean editAction=false;
		boolean newAction=false;
		for (Canvas canvas:getMembers()) {
			Button button=(Button) canvas;
			JavaScriptObject guiProps = JSOHelper.getAttributeAsJavaScriptObject(button.getConfig(), GUI_PROPS);
			if (guiProps != null) {
				// Resolve status
				Record selectedRecord = mainScreen.mainForm.lastRecord;
				boolean statusOK=true;
				String status = selectedRecord != null ? selectedRecord.getAttribute("status") : null;
				String[] ifStatuses=JSOHelper.getAttributeAsStringArray(guiProps, "ifStatus");
				if (status != null && ifStatuses != null && ifStatuses.length > 0) {
					statusOK=false;
					for (String ifStatus : ifStatuses) {
						if (ifStatus.equals(status)) {
							statusOK=true;
							break;
						}
					}
				}

				String detailBehavior=JSOHelper.getAttribute(guiProps, "detailBehavior");
				if (DetailMode.VIEW.equals(detailMode)
						&& (detailBehavior.contains("_ALL") || detailBehavior.contains("_VIEW"))
						&& statusOK) {
					enableButton(button);
				} else if (DetailMode.EDIT.equals(detailMode)
							&& (detailBehavior.contains("_ALL") || detailBehavior.contains("_EDIT"))
							&& statusOK) {
					enableButton(button);
				} else if (DetailMode.NEW.equals(detailMode)
						&& (detailBehavior.contains("_ALL") || detailBehavior.contains("_NEW"))) {
					enableButton(button);
				} else if (detailBehavior.contains("_ALL")) {
					enableButton(button);
				} else {
					button.disable();
				}

				if ((detailBehavior.contains("_ALL") || detailBehavior.contains("_EDIT")) && statusOK) {
					editAction=true;
				}
				if (detailBehavior.contains("_ALL") || detailBehavior.contains("_NEW")) {
					newAction=true;
				}
			}
		}

		if (DetailMode.NEW.equals(detailMode)) {
			newButton.disable();
			editButton.disable();
			enableButton(cancelButton);
		} else if (DetailMode.EDIT.equals(detailMode)) {
			newButton.disable();
			editButton.disable();
			enableButton(cancelButton);
		} else if (DetailMode.VIEW.equals(detailMode)) {
			if (newAction) {
				enableButton(newButton);
			} else {
				editButton.disable();
			}

			if (editAction) {
				enableButton(editButton);
			} else {
				editButton.disable();
			}

			cancelButton.disable();
		} else if (DetailMode.UNKNOWN.equals(detailMode)) {
			if (newAction) {
				enableButton(newButton);
			} else {
				newButton.disable();
			}

			editButton.disable();
			cancelButton.disable();
		}
	}

	enum DetailMode {
		VIEW, EDIT, NEW, UNKNOWN
	}
}
