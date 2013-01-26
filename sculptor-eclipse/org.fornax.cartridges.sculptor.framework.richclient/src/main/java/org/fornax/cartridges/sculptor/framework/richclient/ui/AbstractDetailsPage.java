/*
 * Copyright 2009 The Fornax Project Team, including the original 
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
package org.fornax.cartridges.sculptor.framework.richclient.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.fornax.cartridges.sculptor.framework.richclient.controller.AbstractDetailsController;
import org.fornax.cartridges.sculptor.framework.richclient.controller.DetailsPresentation;
import org.fornax.cartridges.sculptor.framework.richclient.data.RichObject;

public abstract class AbstractDetailsPage<T extends RichObject> implements DetailsPresentation, ISaveablePart{

    private AbstractDetailsController<T> controller;
    private IManagedForm managedForm;
    private Map<String, IObservableValue> targetObservables = new HashMap<String, IObservableValue>();
    private boolean readOnly;
    
    public void initialize(IManagedForm form) {
        this.managedForm = form;
    }
    
    /**
     * Dependency injection
     */
    public void setController(AbstractDetailsController<T> controller) {
        this.controller = controller;
    }
    
    protected AbstractDetailsController<T> getController() {
        return controller;
    }
    
    protected IManagedForm getManagedForm() {
        return managedForm;
    }
    
    protected FormToolkit getToolkit() {
        return managedForm.getToolkit();
    }
    
    public Map<String, IObservableValue> getTargetObservables() {
        return targetObservables;
    }
    
    @SuppressWarnings("unchecked")
    public boolean setFormInput(Object input) {
        return controller.setFormInput((T) input);
    }
    
    public void resetForm() {
    }
    
    public boolean openQuestion(String title, String message) {
        return MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            title, message);
    }

    public void dirtyStateChanged() {
        managedForm.dirtyStateChanged();
    }
    
    public void staleStateChanged() {
        managedForm.staleStateChanged();
    }
    
    public IMessageManager getMessageManager() {
        return managedForm.getMessageManager();
    }

    public void doSaveAs() {
        controller.doSaveAs();
    }

    public boolean isDirty() {
        if (isReadOnly()) {
            return false;
        }
        return controller.isDirty();
    }

    public boolean isSaveAsAllowed() {
        return controller.isSaveAsAllowed();
    }

    public boolean isSaveOnCloseNeeded() {
        return controller.isSaveOnCloseNeeded();
    }
    
    public void doSave(IProgressMonitor monitor) {
        controller.doSave(monitor);
    }

    public void commit(boolean onSave) {
        controller.commit(onSave);
    }

    public void dispose() {
        controller.dispose();
    }

    public boolean isStale() {
        return controller.isStale();
    }

    public void refresh() {
        controller.refresh();
    }

    public void selectionChanged(IFormPart part, ISelection selection) {
        controller.selectionChanged(selection);
    }
    
    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
    
    
    
}
