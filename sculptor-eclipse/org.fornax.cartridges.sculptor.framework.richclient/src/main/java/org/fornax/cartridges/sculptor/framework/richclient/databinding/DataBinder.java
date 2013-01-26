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
package org.fornax.cartridges.sculptor.framework.richclient.databinding;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * Utility for data binding
 * 
 */
public class DataBinder {

    private DataBindingContext bindingContext;
    private Object bean;

    public DataBinder(DataBindingContext bindingContext, Object bean) {
        this.bindingContext = bindingContext;
        this.bean = bean;
    }

    public void bind(String attributeName, IObservableValue observableWidget, UpdateValueStrategy targetToModel,
            UpdateValueStrategy modelToTarget) {
        IObservableValue observeValue = BeansObservables.observeValue(bean, attributeName);
        bindingContext.bindValue(observableWidget, observeValue, targetToModel, modelToTarget);
    }

    public void bindControl(String attributeName, Control control) {
        bindControl(attributeName, control, null, null);
    }

    public void bindControl(String attributeName, Control control, UpdateValueStrategy targetToModel,
            UpdateValueStrategy modelToTarget) {
        IObservableValue observeWidget = null;
        if (control instanceof Text) {
            observeWidget = SWTObservables.observeText(control, SWT.Modify);
        } else if (control instanceof Button || control instanceof Spinner || control instanceof Combo) {
            observeWidget = SWTObservables.observeSelection(control);
        } else {
            throw new IllegalArgumentException("Unsupported widget: " + control);
        }

        bind(attributeName, observeWidget, targetToModel, modelToTarget);
    }

}
