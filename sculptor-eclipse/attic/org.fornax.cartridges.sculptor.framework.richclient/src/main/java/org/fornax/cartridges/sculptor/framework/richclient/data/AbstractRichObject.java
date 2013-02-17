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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public abstract class AbstractRichObject implements RichObject {
    private Set<String> modifications = Collections.synchronizedSet(new HashSet<String>());

    public AbstractRichObject() {
        addPropertyChangeListener(new ModificationListener());
    }
    
    public void clearModifications() {
        modifications.clear();
    }
    
    public boolean isModified(String propertyName) {
        return modifications.contains(propertyName);
    }
    
    public boolean isModified() {
        return !modifications.isEmpty();
    }
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }
    
    /**
     * Subclass will typically override this method and return the real natural
     * key or UUID key. If it is not overridden this default implementation
     * returns null, which means that equals and hashCode will be implemented by
     * java.lang.Object (if those methods are not overridden in subclass).
     */
    public Object getKey() {
        return null;
    }

    public boolean equals(Object obj) {
        if (getKey() == null) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        AbstractRichObject other = (AbstractRichObject) obj;

        return getKey().equals(other.getKey());
    }

    public int hashCode() {
        if (getKey() == null) {
            return super.hashCode();
        }
        return getKey().hashCode();
    }
    
    private class ModificationListener implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            modifications.add(evt.getPropertyName());
        }
    }
}
