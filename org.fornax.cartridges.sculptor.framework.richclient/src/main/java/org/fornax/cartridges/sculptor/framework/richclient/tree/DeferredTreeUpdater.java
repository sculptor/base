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
package org.fornax.cartridges.sculptor.framework.richclient.tree;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.fornax.cartridges.sculptor.framework.richclient.data.DataEvent;

/**
 * Handles updates for deferred trees.
 * 
 */
public class DeferredTreeUpdater {
    private TreeViewer treeViewer;
    private Class<?>[] classesOfInterest;
    private TreeExpander treeExpander;

    public DeferredTreeUpdater(TreeViewer treeViewer, Class<?>[] classesOfInterest) {
        this.treeViewer = treeViewer;
        treeExpander = new TreeExpander(this.treeViewer);
        this.classesOfInterest = classesOfInterest;
    }

    public void update(final Object object) {
        if (!(object instanceof DataEvent)) {
            return;
        }
        final DataEvent event = (DataEvent) object;
        if (!isOfInterest(event.getSourceObject())) {
            return;
        }
        
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchAdapter adapter = null;
                switch (event.getAction()) {
                case INSERT:
                    adapter = ((DeferredTreeContentProvider) treeViewer.getContentProvider())
                            .getAdapter(event.getSourceObject());
                    if (adapter != null) {
                        Object parent = adapter.getParent(event.getSourceObject());
                        if (parent != null) {
                            treeViewer.add(parent, event.getSourceObject());
                            treeExpander.expandSelect(new StructuredSelection(event.getSourceObject()));
                        }
                    }
                    break;
                case REMOVE:
                    treeViewer.remove(event.getSourceObject());
                    break;
                case UPDATE:
                    treeViewer.update(event.getSourceObject(), null);
                    break;
                case REFRESH:
                    adapter = ((DeferredTreeContentProvider) treeViewer.getContentProvider())
                            .getAdapter(event.getSourceObject());
                    if (adapter == null) {
                        treeViewer.refresh();
                    } else {
                        Object parent = adapter.getParent(event.getSourceObject());
                        if (parent != null) {
                            treeViewer.refresh(parent);
                            treeExpander.expandSelect(new StructuredSelection(event.getSourceObject()));
                        }
                    }
                    treeExpander.expandSelect(new StructuredSelection(event.getSourceObject()));
                    break;
                default:
                    // Unknown type, not handled anyway
                }
            }

        });
    }

    public boolean isOfInterest(Object sourceObject) {
        if (sourceObject == null) {
            return false;
        }
        return isOfInterest(sourceObject.getClass());
    }
    
    private boolean isOfInterest(Class<?> type) {
        if (classesOfInterest == null) {
            // accept all
            return true;
        }
        for (Class<?> clazz : classesOfInterest) {
            if (clazz.isAssignableFrom(type)) {
                return true;
            }
        }
        return false;
    }
}
