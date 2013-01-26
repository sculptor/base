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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Several validators can be combined with this validator. It will
 * invoke the added validators in turn and return error on first
 * failure.
 *
 */
public class CompositeValidator implements IValidator {

    private List<IValidator> validators = new ArrayList<IValidator>();
    
    public CompositeValidator() {
    }
    
    public CompositeValidator(IValidator... validators) {
        for (IValidator each : validators) {
            addValidator(each);
        }
    }

    public void addValidator(IValidator validator) {
        validators.add(validator);
    }
    
    public IStatus validate(Object value) {
        for (IValidator each : validators) {
            IStatus result = each.validate(value);
            if (result.getSeverity() >= IStatus.WARNING) {
                return result;
            }
        }
        
        return Status.OK_STATUS;
    }
}
