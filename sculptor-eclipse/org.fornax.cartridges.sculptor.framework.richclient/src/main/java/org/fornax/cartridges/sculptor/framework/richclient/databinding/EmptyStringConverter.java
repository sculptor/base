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

import org.eclipse.core.databinding.conversion.IConverter;

public class EmptyStringConverter implements IConverter {
    
    private boolean targetToModel;

    /**
     * @param targetToModel if true it is conversion from widget to model, otherwise from model to widget
     */
    public EmptyStringConverter(boolean targetToModel) {
        this.targetToModel = targetToModel;
    }

    public Object convert(Object fromObject) {
        if (fromObject == null || fromObject.equals("")) {
            return targetToModel ? null : "";
        }
        return fromObject;
    }

    public Object getFromType() {
        return targetToModel ? String.class : null;
    }

    public Object getToType() {
        return targetToModel ? null : String.class;
    }

}
