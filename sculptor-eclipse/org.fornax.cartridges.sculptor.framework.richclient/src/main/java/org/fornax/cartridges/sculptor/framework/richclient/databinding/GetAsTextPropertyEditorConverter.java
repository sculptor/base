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

import java.beans.PropertyEditor;

import org.eclipse.core.databinding.conversion.IConverter;

public class GetAsTextPropertyEditorConverter implements IConverter {
    
    private PropertyEditor editor;

    public GetAsTextPropertyEditorConverter(PropertyEditor editor) {
        this.editor = editor;
    }

    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return "";
        }
        try {
            editor.setValue(fromObject);
            return editor.getAsText();
        } finally {
            editor.setValue(null);
        }
    }

    public Object getFromType() {
        return null;
    }

    public Object getToType() {
        return String.class;
    }

}
