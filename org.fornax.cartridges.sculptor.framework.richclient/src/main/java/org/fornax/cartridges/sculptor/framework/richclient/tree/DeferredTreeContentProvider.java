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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.progress.ProgressMessages;
import org.eclipse.ui.internal.util.Util;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.progress.DeferredTreeContentManager;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;
import org.eclipse.ui.progress.WorkbenchJob;

/**
 * A content provider for deferred trees
 * 
 */
public class DeferredTreeContentProvider extends BaseWorkbenchContentProvider implements ITreeContentProvider {
    private DeferredTreeContentManager manager;

    private Map<Class<?>, IDeferredWorkbenchAdapter> adapters = new HashMap<Class<?>, IDeferredWorkbenchAdapter>();
    private List<DeferredTreeListener> listeners = Collections.synchronizedList(new ArrayList<DeferredTreeListener>());

    public void addDeferredTreeListener(DeferredTreeListener listener) {
        listeners.add(listener);
    }

    public void removeDeferredTreeListener(DeferredTreeListener listener) {
        listeners.remove(listener);
    }

    private void notifyLoadedChildren(Object parent, Object[] children) {
        for (DeferredTreeListener listener : new ArrayList<DeferredTreeListener>(listeners)) {
            listener.loadedChildren(parent, children);
        }
    }

    public void registerAdapter(Class<?> objectClass, IDeferredWorkbenchAdapter adapter) {
        adapters.put(objectClass, adapter);
    }

    @Override
    public IWorkbenchAdapter getAdapter(Object element) {
        IDeferredWorkbenchAdapter adapter = adapters.get(element.getClass());
        if (adapter != null) {
            return adapter;
        }
        return (IWorkbenchAdapter) Util.getAdapter(element, IDeferredWorkbenchAdapter.class);
    }

    @Override
    public void inputChanged(final Viewer viewer, Object oldInput, Object newInput) {
        if (viewer instanceof AbstractTreeViewer) {
            manager = new ContentManager((AbstractTreeViewer) viewer);
        }
    }

    @Override
    public Object[] getChildren(Object parent) {
        if (manager != null) {
            Object[] children = manager.getChildren(parent);
            if (children != null) {
                // This will be a placeholder to indicate
                // that the real children are being fetched
                return children;
            }
        }
        return new Object[0];
    }

    @Override
    public boolean hasChildren(Object element) {
        if (manager != null) {
            if (manager.isDeferredAdapter(element)) {
                return manager.mayHaveChildren(element);
            }
        }
        return super.hasChildren(element);
    }
    
    private class ContentManager extends DeferredTreeContentManager {
        private AbstractTreeViewer viewer;
        public ContentManager(AbstractTreeViewer viewer) {
            super(DeferredTreeContentProvider.this, viewer);
            this.viewer = viewer;
        }
        
        @Override
        protected void addChildren(final Object parent, final Object[] children, IProgressMonitor monitor) {
            WorkbenchJob job = new WorkbenchJob(ProgressMessages.DeferredTreeContentManager_AddingChildren) {
                @Override
                public IStatus runInUIThread(IProgressMonitor monitor) {
                    // Cancel the job if the tree viewer got closed
                    if (viewer.getControl().isDisposed() || monitor.isCanceled()) {
                        return Status.CANCEL_STATUS;
                    }
                    ((AbstractTreeViewer) viewer).add(parent, children);
                    Display.getDefault().asyncExec(new Runnable() {
                        public void run() {
                            notifyLoadedChildren(parent, children);
                        }
                    });
                    return Status.OK_STATUS;
                }
            };
            job.setSystem(true);
            job.schedule();
        }
    };
    
}
