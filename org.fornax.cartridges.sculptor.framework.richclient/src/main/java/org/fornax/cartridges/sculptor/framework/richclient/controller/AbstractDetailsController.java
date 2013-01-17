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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISaveablePart;
import org.fornax.cartridges.sculptor.framework.richclient.SculptorFrameworkPlugin;
import org.fornax.cartridges.sculptor.framework.richclient.data.DataEvent;
import org.fornax.cartridges.sculptor.framework.richclient.data.DataEvent.Action;
import org.fornax.cartridges.sculptor.framework.richclient.data.RichObject;
import org.fornax.cartridges.sculptor.framework.richclient.data.RichObjectFactory;
import org.fornax.cartridges.sculptor.framework.richclient.databinding.RequiredValidator;
import org.fornax.cartridges.sculptor.framework.util.EqualsHelper;

public abstract class AbstractDetailsController<T extends RichObject> implements ISaveablePart, PropertyChangeListener,
        Observer {

    // TODO ISaveablePart2 instead?

    private DetailsPresentation presentation;

    private DataBindingContext bindingContext;

    private volatile boolean dirty;
    private volatile boolean stale;
    private volatile boolean validationStatus = true;

    private T model;
    private RichObjectFactory<T> objectFactory;

    public AbstractDetailsController() {
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

    public void presentationCreated(DetailsPresentation presentation) {
        this.presentation = presentation;
    }

    protected DetailsPresentation getPresentation() {
        return presentation;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (EqualsHelper.equals(event.getOldValue(), event.getNewValue())) {
            return;
        }
        if (Display.getCurrent() == null) {
            Display.getDefault().syncExec(new Runnable() {
                @Override
                public void run() {
                    dirty = true;
                    presentation.dirtyStateChanged();
                }
            });
        } else {
            dirty = true;
            presentation.dirtyStateChanged();
        }
    }

    public void dispose() {
        if (getBindingContext() != null) {
            getBindingContext().dispose();
        }
    }

    protected Map<String, IObservableValue> getTargetObservables() {
        return presentation.getTargetObservables();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Observable repository, Object event) {
        DataEvent dataEvent = (DataEvent) event;
        if (dataEvent.getSourceObject() == getModel()) {
            // same object, skip
            // updates of properties are handled by PropertyChangeListener
            return;
        }

        if (dataEvent.getAction() == Action.REMOVE) {
            return;
        }

        if (getModel() != null && getModel().getClass().isInstance(dataEvent.getSourceObject())) {
            T source = (T) dataEvent.getSourceObject();
            if (isMyModelUpdated(source)) {
                if (isDirty()) {
                    if (presentation.openQuestion("Model changed",
                            "The model has been changed by another person, would you like to reload the page?")) {
                        setFormInput(source);
                    } else {
                        stale = true;
                        presentation.staleStateChanged();
                    }
                } else {
                    setFormInput(source);
                }
            }
        }
    }

    protected boolean isMyModelUpdated(T source) {
        return getModel().equals(source);
    }

    public boolean setFormInput(T input) {
        dirty = false;
        stale = false;
        getModel().removePropertyChangeListener(this);

        setModel(cloneModel(input));

        if (getBindingContext() != null) {
            getBindingContext().dispose();
            setBindingContext(null);
        }
        initDataBindingsInternal();

        getBindingContext().updateTargets();
        getModel().addPropertyChangeListener(this);

        presentation.resetForm();

        return false;
    }

    public void selectionChanged(ISelection selection) {
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        presentation.setFormInput(structuredSelection.getFirstElement());
    }

    public T getModel() {
        return model;
    }

    protected void setModel(T model) {
        this.model = model;
    }

    @SuppressWarnings("unchecked")
    protected final T cloneModel(T model) {
        return (T) model.clone();
    }

    protected abstract void initDataBindings(DataBindingContext bindingContext);

    @Override
    public boolean isDirty() {
        if (!validationStatus) {
            // TODO trick to disable save, can probably be done better
            return false;
        }
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
        presentation.dirtyStateChanged();
    }

    private void setValidationStatus(boolean ok) {
        this.validationStatus = ok;
        // TODO trick to disable save, can probably be done better
        presentation.dirtyStateChanged();
    }

    public boolean isStale() {
        return stale;
    }

    public void refresh() {
    }

    private void initDataBindingsInternal() {
        if (getBindingContext() != null) {
            throw new IllegalStateException("Can only bind values once");
        }
        setBindingContext(new DataBindingContext());
        initDataBindings(getBindingContext());
        setupBindingValidations();
        initValidationStatusListener();
    }

    private void initValidationStatusListener() {
        final AggregateValidationStatus aggregatedStatus = new AggregateValidationStatus(getBindingContext(),
                AggregateValidationStatus.MAX_SEVERITY);
        aggregatedStatus.addChangeListener(new IChangeListener() {
            @Override
            public void handleChange(ChangeEvent event) {
                boolean validationOk = (((IStatus) aggregatedStatus.getValue()).getSeverity() == IStatus.OK);
                if (validationStatus != validationOk) {
                    setValidationStatus(validationOk);
                }
            }
        });
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

    @Override
    public void doSave(IProgressMonitor monitor) {
        stale = false;
        setDirty(false);
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public boolean isSaveOnCloseNeeded() {
        return isDirty();
    }

    public void commit(boolean onSave) {
    }

    @SuppressWarnings("unchecked")
    protected void setupBindingValidations() {
        Iterator<Binding> iter = getBindingContext().getBindings().iterator();
        while (iter.hasNext()) {
            Binding binding = iter.next();
            if (binding.getTarget() instanceof ISWTObservableValue) {
                ISWTObservableValue observableValue = (ISWTObservableValue) binding.getTarget();
                if (observableValue.getWidget() instanceof Control) {
                    binding.getValidationStatus().addValueChangeListener(
                            new ValueChangeListener((Control) observableValue.getWidget()));
                } else if (binding.getTarget() != null) {
                    String msg = "Unknown target: " + binding.getTarget().getClass().getName();
                    Status status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, msg);
                    Policy.getLog().log(status);
                }
            }
        }
    }

    protected void setBindingContext(DataBindingContext bindingContext) {
        this.bindingContext = bindingContext;
    }

    protected DataBindingContext getBindingContext() {
        return bindingContext;
    }

    class ValueChangeListener implements IValueChangeListener {

        private final Control control;

        public ValueChangeListener(Control control) {
            this.control = control;
        }

        @Override
        public void handleValueChange(ValueChangeEvent pEvent) {
            IStatus status = (IStatus) pEvent.getObservableValue().getValue();
            if (status.getSeverity() == IStatus.ERROR) {
                presentation.getMessageManager().addMessage("requiredField", status.getMessage(), null,
                        IMessageProvider.ERROR, control);
            } else if (status.getSeverity() == IStatus.WARNING) {
                presentation.getMessageManager().addMessage("requiredField", status.getMessage(), null,
                        IMessageProvider.WARNING, control);
            } else if (status.getSeverity() == IStatus.INFO) {
                presentation.getMessageManager().addMessage("requiredField", status.getMessage(), null,
                        IMessageProvider.INFORMATION, control);
            } else if (status.getSeverity() == IStatus.OK) {
                presentation.getMessageManager().removeMessage("requiredField", control);
            }
        }
    }

}
