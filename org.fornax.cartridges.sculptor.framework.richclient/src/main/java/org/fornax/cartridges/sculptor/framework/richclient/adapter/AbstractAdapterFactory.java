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
package org.fornax.cartridges.sculptor.framework.richclient.adapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;

/**
 * Base functionality for factory for adapters.
 * 
 */
public abstract class AbstractAdapterFactory implements IAdapterFactory {
    
    private List<Mapping> adapterForObjectMappings = new ArrayList<Mapping>();

    public void addAdapterForObject(Class<?> objectClass, Class<? extends IDeferredWorkbenchAdapter> adapterClass) {
        adapterForObjectMappings.add(new Mapping(objectClass, adapterClass));
    }
    
    @SuppressWarnings("unchecked")
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        // loop backwards so that the last added are used first
        for (int i = adapterForObjectMappings.size() - 1; i >= 0; i--) {
            Mapping mapping = adapterForObjectMappings.get(i);
            if (mapping.handle(adaptableObject)) {
                return mapping.createAdapter();
            }
        }
     
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public Class[] getAdapterList() {
        Set<Class> adapterClasses = new HashSet<Class>();
        for (Mapping mapping : adapterForObjectMappings) {
            adapterClasses.add(mapping.getAdapterClass());
        }
        Class[] result = new Class[adapterClasses.size()];
        adapterClasses.toArray(result);
        return result;
    }
    
    private static class Mapping {
        private Class<?> objectClass;
        private Class<? extends IDeferredWorkbenchAdapter> adapterClass;

        Mapping(Class<?> objectClass, Class<? extends IDeferredWorkbenchAdapter> adapterClass) {
            this.objectClass = objectClass;
            this.adapterClass = adapterClass;
        }
        
        Class<?> getObjectClass() {
            return objectClass;
        }

        Class<? extends IDeferredWorkbenchAdapter> getAdapterClass() {
            return adapterClass;
        }

        boolean handle(Object adaptableObject) {
            return objectClass.isAssignableFrom(adaptableObject.getClass());
        }
        
        IDeferredWorkbenchAdapter createAdapter() {
            try {
                return adapterClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
        
    }

}
