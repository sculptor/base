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
package org.fornax.cartridges.sculptor.framework.richclient.table;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

/**
 * A sorter class for sorting ViewerColumns
 * 
 */
public abstract class ColumnViewerSorter extends ViewerComparator {
    public static final int ASC = 1;
    public static final int NONE = 0;
    public static final int DESC = -1;

    private int direction;
    private TableViewerColumn column;
    private ColumnViewer viewer;

    public ColumnViewerSorter(ColumnViewer viewer, TableViewerColumn column) {
        this.column = column;
        this.viewer = viewer;

        column.getColumn().addSelectionListener(new SorterSelectionAdapter());
    }

    public int getDirection() {
        return direction;
    }

    private void setSortColumn(TableViewerColumn column) {
        TableColumn tableColumn = column == null ? null : column.getColumn();
        column.getColumn().getParent().setSortColumn(tableColumn);
    }

    private void setSortDirection(int direction) {
        column.getColumn().getParent().setSortDirection(direction);
    }

    void setSorter(int dir) {
        direction = dir;
        if (dir == NONE) {
            setSortDirection(SWT.NONE);
            setSortColumn(null);
            viewer.setComparator(null);
        } else {
            setSortColumn(column);

            if (dir == ASC) {
                setSortDirection(SWT.DOWN);
            } else {
                setSortDirection(SWT.UP);
            }

            if (viewer.getComparator() == this) {
                viewer.refresh();
            } else {
                viewer.setComparator(this);
            }
        }
    }

    @Override
    public int compare(Viewer viewer, Object obj1, Object obj2) {
        return direction * doCompare(viewer, obj1, obj2);
    }

    protected abstract int doCompare(Viewer viewer, Object obj1, Object obj2);

    private class SorterSelectionAdapter extends SelectionAdapter {
        @Override
        public void widgetSelected(SelectionEvent event) {
            if (ColumnViewerSorter.this.viewer.getComparator() == ColumnViewerSorter.this) {
                if (getDirection() == ASC) {
                    setSorter(DESC);
                    return;
                } else if (getDirection() == DESC) {
                    setSorter(NONE);
                    return;
                }
            }

            setSorter(ASC);
        }
    }
    
    public ViewerColumn getColumn() {
        return column;
    }
}
