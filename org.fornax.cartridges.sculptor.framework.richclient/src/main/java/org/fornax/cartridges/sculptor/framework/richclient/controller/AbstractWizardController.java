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
package org.fornax.cartridges.sculptor.framework.richclient.controller;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.fornax.cartridges.sculptor.framework.richclient.data.RichObject;
import org.fornax.cartridges.sculptor.framework.richclient.data.RichObjectFactory;
import org.fornax.cartridges.sculptor.framework.richclient.databinding.RequiredValidator;

/**
 * 
 * @param <T>
 *            The data model class
 */
public abstract class AbstractWizardController<T extends RichObject> implements IValueChangeListener {
    private DataBindingContext bindingContext;
    private RichObject selectedObject;
    private T model;
    private RichObjectFactory<T> objectFactory;
    private WizardPresentation presentation;
    private ParentOfSubtask<T> subtaskParent;

    public AbstractWizardController() {
    }

    protected RichObjectFactory<T> getObjectFactory() {
        return objectFactory;
    }

    /**
     * Dependency injection
     */
    public void setObjectFactory(RichObjectFactory<T> objectFactory) {
        this.objectFactory = objectFactory;
        if (model == null) {
            model = this.objectFactory.create();
        }
    }

    public WizardPresentation getPresentation() {
        return presentation;
    }

    public void setSelection(IStructuredSelection selection) {
        if (selection != null && !selection.isEmpty()) {
            Object selected = selection.getFirstElement();
            if (selected instanceof RichObject) {
                setSelectedObject((RichObject) selected);
            }
        }
    }

    protected void setSelectedObject(RichObject selectedObject) {
        this.selectedObject = selectedObject;
    }

    public boolean isSelectedObjectValid() {
        return getSelectedObject() != null && getModel().getClass().equals(getSelectedObject().getClass());
    }

    protected RichObject getSelectedObject() {
        return selectedObject;
    }

    public T getModel() {
        return model;
    }

    public boolean isSubtask() {
        return subtaskParent != null;
    }

    public ParentOfSubtask<T> getSubtaskParent() {
        return subtaskParent;
    }

    public void setSubtaskParent(ParentOfSubtask<T> subtaskParent) {
        this.subtaskParent = subtaskParent;
    }

    public void pageCreated(WizardPresentation view) {
        this.presentation = view;
        disposeBindingContext();

        initDataBindingsInternal();

        getBindingContext().updateTargets();

        view.setPageComplete(updateValidationMessages());
    }

    protected void setBindingContext(DataBindingContext bindingContext) {
        this.bindingContext = bindingContext;
    }

    protected DataBindingContext getBindingContext() {
        return bindingContext;
    }

    public void copyFromSelection() {
        model.update(getSelectedObject());

        presentation.resetForm();
    }

    @Override
    public void handleValueChange(ValueChangeEvent event) {
        presentation.setPageComplete(updateValidationMessages());
    }

    /**
     * 
     * @return true if page is valid
     */
    protected boolean updateValidationMessages() {
        boolean messageSet = false;
        IStatus statusParent = AggregateValidationStatus.getStatusMerged(getBindingContext().getBindings());

        // Iter for errors
        for (IStatus statusChild : statusParent.getChildren()) {
            if (statusChild.getSeverity() == IStatus.ERROR) {
                presentation.setErrorMessage(statusChild.getMessage());
                messageSet = true;
                if (statusChild.getException() != null) {
                    statusChild.getException().printStackTrace();
                }
                break;
            }
        }
        if (!messageSet) {
            presentation.clearErrorMessage();
            // Iter for warnings
            for (IStatus statusChild : statusParent.getChildren()) {
                if (statusChild.getSeverity() == IStatus.WARNING) {
                    presentation.setMessage(statusChild.getMessage(), IMessageProvider.WARNING);
                    messageSet = true;
                    break;
                }
            }
        }
        if (!messageSet) {
            // Iter for information
            for (IStatus statusChild : statusParent.getChildren()) {
                if (statusChild.getSeverity() == IStatus.INFO) {
                    presentation.setMessage(statusChild.getMessage(), IMessageProvider.INFORMATION);
                    messageSet = true;
                    break;
                }
            }
        }

        if (!messageSet) {
            IStatus customValidationStatus = getValidationStatus();
            if (customValidationStatus == null) {
                presentation.clearErrorMessage();
                presentation.setMessage(null, IMessageProvider.NONE);
            } else if (customValidationStatus.getSeverity() == IStatus.ERROR) {
                presentation.setErrorMessage(customValidationStatus.getMessage());
            } else if (customValidationStatus.getSeverity() == IStatus.WARNING) {
                presentation.setMessage(customValidationStatus.getMessage(), IMessageProvider.WARNING);

            } else if (customValidationStatus.getSeverity() == IStatus.INFO) {
                presentation.setMessage(customValidationStatus.getMessage(), IMessageProvider.INFORMATION);
            }
        }

        if (!messageSet) {
            presentation.setMessage(null, IMessageProvider.NONE);
        }

        return !presentation.hasErrorMessage();
    }

    protected IStatus getValidationStatus() {
        return null;
    }

    protected WizardPresentation getView() {
        return presentation;
    }

    protected Map<String, IObservableValue> getTargetObservables() {
        return presentation.getTargetObservables();
    }

    protected abstract void initDataBindings(DataBindingContext bindingContext);

    private void initDataBindingsInternal() {
        if (getBindingContext() != null) {
            throw new IllegalStateException("Can only bind values once");
        }
        setBindingContext(new DataBindingContext());
        initDataBindings(getBindingContext());

        validateBindings();
    }

    protected void disposeBindingContext() {
        if (getBindingContext() != null) {
            getBindingContext().dispose();
            setBindingContext(null);
        }
    }

    public void dispose() {
        getBindingContext().dispose();
    }

    @SuppressWarnings("unchecked")
    private void validateBindings() {
        Iterator<Binding> iter = getBindingContext().getBindings().iterator();
        while (iter.hasNext()) {
            iter.next().getValidationStatus().addValueChangeListener(this);
        }
    }

    protected IObservableValue getTargetObservable(String name) {
        IObservableValue result = getTargetObservables().get(name);
        return result;
    }

    protected IObservableValue getModelObservable(String attributeName) {
        return BeansObservables.observeValue(getModel(), attributeName);
    }

    protected UpdateValueStrategy createRequiredUpdateStrategy(String validationMessage) {
        UpdateValueStrategy updateStrategy = new UpdateValueStrategy();
        updateStrategy.setBeforeSetValidator(new RequiredValidator(validationMessage));
        return updateStrategy;
    }

}
