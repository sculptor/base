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
package org.fornax.cartridges.sculptor.framework.richclient.data;

/**
 * Event used for notification of data changes.
 * 
 */
public class DataEvent {
    public enum Action {
        INSERT, UPDATE, REMOVE, REFRESH
    }

    private Object sourceObject;
    private Action action;

    public DataEvent(Object object, Action action) {
        this.sourceObject = object;
        this.action = action;
    }

    public Object getSourceObject() {
        return sourceObject;
    }

    public Action getAction() {
        return action;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DataEvent)) {
            return false;
        }

        DataEvent other = (DataEvent) obj;
        
        if (other.getAction() != action) {
            return false;
        }

        return other.getSourceObject().equals(sourceObject);
    }

    public int hashCode() {
        return sourceObject.hashCode();
    }
    
    public String toString() {
        return action + " " + sourceObject.getClass().getSimpleName() + " : " + sourceObject;
    }
    
    

}
