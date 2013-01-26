/*
 * Copyright 2007 The Fornax Project Team, including the original 
 * author or authors.
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
package org.fornax.cartridges.sculptor.wizard.richclient;


import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RichClientProjectWizardPage extends WizardPage {
    private Text projectNameText;
    private Text projectIdText;
    private Text businessProjectText;

    private ProjectInfo projectInfo = new ProjectInfo();

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    
    @SuppressWarnings("unused")
    public RichClientProjectWizardPage(ISelection selection) {
        super("wizardPage");
        setTitle("Sculptor rich client project wizard");
        setDescription("This wizard creates a project for your rich client.");
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        Label label = new Label(container, SWT.NULL);
        label.setText("&Project name:");

        projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        projectNameText.setLayoutData(gd);
        projectNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("Project &id:");

        projectIdText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        projectIdText.setLayoutData(gd);
        projectIdText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        label = new Label(container, SWT.NULL);
        label.setText("&Business tier project:");

        businessProjectText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        businessProjectText.setLayoutData(gd);
        businessProjectText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });
        
        initialize();
        dialogChanged();
        setControl(container);
    }


    private void initialize() {
        projectNameText.setText("My rich client");
        projectIdText.setText("myapp.richclient");
        businessProjectText.setText("myapp");
    }

    void dialogChanged() {
        projectInfo.setProjectName(projectNameText.getText());
        projectInfo.setProjectId(projectIdText.getText());
        projectInfo.setBusinessProjectId(businessProjectText.getText());

        if (!projectInfo.getProjectId().matches("\\w+[\\w\\.]*\\w+")) {
            setErrorMessage("Project id must be specified (And must be in Java Package syntax (e.g. org.example))");
            return;
        }
        
        if (projectInfo.getBusinessProjectId().trim().length() == 0) {
            setErrorMessage("Business tier project must be specified.");
            return;
        }
        
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        if (!(workspace.getRoot().getProjectRelativePath().isValidPath(projectInfo.getBusinessProjectId()) &&
                workspace.getRoot().getProject(projectInfo.getBusinessProjectId()).exists())) {
            setErrorMessage("Business tier project must be an existing project in the workspace.");
            return;
        }
        
        setErrorMessage(null);
        setPageComplete(true);
    }

}