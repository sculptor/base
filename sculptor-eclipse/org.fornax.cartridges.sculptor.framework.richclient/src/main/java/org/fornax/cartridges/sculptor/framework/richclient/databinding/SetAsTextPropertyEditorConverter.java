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

public class SetAsTextPropertyEditorConverter implements IConverter {
    
    private PropertyEditor editor;
    private String message;

    public SetAsTextPropertyEditorConverter(PropertyEditor editor) {
        this.editor = editor;
    }
    
    public SetAsTextPropertyEditorConverter(PropertyEditor editor, String message) {
        this.editor = editor;
        this.message = message;
    }

    public Object convert(Object fromObject) {
        try {
            String text = (String) fromObject;
            editor.setAsText(text);
            return editor.getValue();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(message == null ? e.getMessage() : message);
        } finally {
            editor.setValue(null);
        }
    }

    public Object getFromType() {
        return String.class;
    }

    public Object getToType() {
        return null;
    }

}
