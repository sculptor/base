package org.fornax.cartridges.sculptor.smartclient.client;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;

public class DebugWindow extends Window {
	public DebugWindow() {
		final TextAreaItem codeTextArea=new TextAreaItem("Script");
		codeTextArea.setWidth("*");
		codeTextArea.setHeight("*");
	
		DynamicForm codeForm=new DynamicForm();
		codeForm.setTitleOrientation(TitleOrientation.TOP);
		codeForm.setNumCols(1);
		codeForm.setWidth100();
		codeForm.setHeight100();
		codeForm.setItems(codeTextArea);
	
		Button evalButton=new Button("Run script");
		evalButton.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
			public void onClick(ClickEvent event) {
				try {
					String value = (String) codeTextArea.getValue();
					GuiUtil.getStringAsJavaScriptObject(value);
				} catch (Throwable th) {
					GWT.log("Evaluation error", th);
					SC.say(th.getMessage());
				}
			}
		});
	
		setTitle("Debug");
		setCanDragResize(true);
		setWidth(600);
		setHeight(400);
		setShowHeader(true);
		setShowShadow(true);
		setShowCloseButton(true);
		setShowMinimizeButton(true);
		addItem(codeForm);
		addItem(evalButton);
		centerInPage();
	}
}
