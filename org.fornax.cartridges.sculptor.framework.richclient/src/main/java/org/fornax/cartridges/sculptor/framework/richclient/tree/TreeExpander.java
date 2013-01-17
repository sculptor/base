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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class TreeExpander {
    
    private AbstractTreeViewer treeViewer;
    
    public TreeExpander(AbstractTreeViewer treeViewer) {
        this.treeViewer = treeViewer;
    }

    public void expandSelect(final IStructuredSelection selection) {
        final List<Object> expandedObjects = getExpandObjects(selection);
        if (treeViewer.getContentProvider() instanceof DeferredTreeContentProvider) {
            DeferredTreeListener listener = new DeferredTreeListener() {
                public void loadedChildren(Object parent, Object[] children) {
                    for (Object each : expandedObjects) {
                        if (!treeViewer.getExpandedState(each)) {
                            treeViewer.setExpandedState(each, true);
                        }
                    }
                    if (parent != null && expandedObjects.indexOf(parent) == expandedObjects.size() - 1) {
                        treeViewer.setSelection(selection, true);
                        if (!treeViewer.getSelection().isEmpty() || children == null || children.length == 0) {
                            ((DeferredTreeContentProvider) treeViewer.getContentProvider())
                                    .removeDeferredTreeListener(this);
                        }
                    }
                }
            };
            ((DeferredTreeContentProvider) treeViewer.getContentProvider()).addDeferredTreeListener(listener);
        }
        for (Object each : expandedObjects) {
            treeViewer.setExpandedState(each, true);
        }
        treeViewer.setSelection(selection, true);
    }

    private List<Object> getExpandObjects(IStructuredSelection selection) {
        List<Object> result = new ArrayList<Object>();
        for (Object each : selection.toList()) {
            findExpandedObjects(each, result);
        }
        return result;
    }

    private void findExpandedObjects(Object obj, List<Object> result) {
        IWorkbenchAdapter adapter;
        if (treeViewer.getContentProvider() instanceof DeferredTreeContentProvider) {
            adapter = ((DeferredTreeContentProvider) treeViewer.getContentProvider()).getAdapter(obj);
        } else {
            adapter = (IWorkbenchAdapter) Platform.getAdapterManager().getAdapter(obj, IWorkbenchAdapter.class);
        }
        
        if (adapter == null) {
            return;
        }
        Object parent = adapter.getParent(obj);
        if (parent != null) {
            result.add(0, parent);
            findExpandedObjects(parent, result);
        }
    }
    
}
