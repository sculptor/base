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

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;


/**
 * Class for handling creation of TableViewerColumn.
 *
 */
public abstract class AbstractViewerColumn {

    public static final int DEFAULT_WIDTH = 150;
    private String columnHeader;
    private ColumnLabelProvider columnLabelProvider;
    private int defaultWidth;
    private TableViewerColumn column;
    private boolean sortable;
    private ColumnViewerSorter columnViewerSorter;

    public AbstractViewerColumn(String columnHeader) {
        this(columnHeader, DEFAULT_WIDTH);
    }
    
    public AbstractViewerColumn(String columnHeader, int defaultWidth) {
        this(columnHeader, defaultWidth, true);
    }
    
    public AbstractViewerColumn(String columnHeader, int defaultWidth, boolean sortable) {
        this.columnHeader = columnHeader;
        this.defaultWidth = defaultWidth;
        this.sortable = sortable;
    }

    protected void createColumn(TableViewer tableViewer) {
        TableViewerColumn column = new TableViewerColumn(tableViewer, getStyle());
        column.getColumn().setWidth(getDefaultWidth());
        column.getColumn().setText(getText());
        columnLabelProvider = getColumnLabelProvider();
        column.setLabelProvider(columnLabelProvider);
        if (getEditingSupport(tableViewer) != null) {
            column.setEditingSupport(getEditingSupport(tableViewer));
        }
        setupColumnSorter(tableViewer, column);
        column.getColumn().addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent event) {
                if (columnLabelProvider != null) {
                    columnLabelProvider.dispose();
                }
            }
        });
        this.column = column;
    }
    
    public TableViewerColumn getColumn() {
        return column;
    }

    public abstract ColumnLabelProvider getColumnLabelProvider();

    protected EditingSupport getEditingSupport(ColumnViewer columnViewer) {
        return null;
    }

    protected int getStyle() {
        return SWT.NONE;
    }

    public final String getText() {
        return columnHeader;
    }
    
    protected int getDefaultWidth() {
        return defaultWidth;
    }
    
    public void setDefaultWidth(int pDefaultWidth) {
        defaultWidth = pDefaultWidth;
    }
    
    public int getColumnWidth() {
        return column.getColumn().getWidth();
    }
    
    public void setColumnWidth(int pWidth) {
        column.getColumn().setWidth(pWidth);
    }
    
    public boolean isSortable() {
        return sortable;
    }
    
    protected ColumnViewerSorter getColumnSorter() {
        return columnViewerSorter;
    }

    protected void setupColumnSorter(ColumnViewer columnViewer, TableViewerColumn column) {
        if (!isSortable()) {
            return;
        }
        
        columnViewerSorter = new ColumnViewerSorter(columnViewer, column) {
            @Override
            protected int doCompare(Viewer viewer, Object obj1, Object obj2) {
                String text1 = columnLabelProvider.getText(obj1);
                String text2 = columnLabelProvider.getText(obj2);
                if (text1 == null && text2 == null) {
                    return 0;
                }
                if (text1 != null && text2 == null) {
                    return -1;
                }
                if (text1 == null && text2 != null) {
                    return 1;
                }
                return text1.compareTo(text2);
            }
        };
    }
}
