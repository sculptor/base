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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IMemento;
import org.fornax.cartridges.sculptor.framework.richclient.SculptorFrameworkPlugin;


/**
 * Table viewer for handling adding and removing columns
 *
 */
public class CustomizableTableViewer {
    
    private static final String MEMENTO_SORT_DIRECTION_SUFFIX = ".sortDirection";
    private static final String MEMENTO_SORT_COLUMN_SUFFIX = ".sortColumn";
    private static final String MEMENTO_SEPARATOR = ";";
    private static final String MEMENTO_WIDTH_SUFFIX = ".width";

    private List<AbstractViewerColumn> allColumns = new ArrayList<AbstractViewerColumn>();
    private List<AbstractViewerColumn> defaultColumns = new ArrayList<AbstractViewerColumn>();
    private TableViewer viewer;
    private List<ColumnViewerSorter> columnSorters = new ArrayList<ColumnViewerSorter>();

    private CustomizableTableViewer(TableViewer viewer) {
        this.viewer = viewer;
    }

    public static CustomizableTableViewer newTable(Composite parent, int style) {
        return new CustomizableTableViewer(new TableViewer(parent, style));
    }
    
    public static CustomizableTableViewer newCheckList(Composite parent, int style) {
        return new CustomizableTableViewer(CheckboxTableViewer.newCheckList(parent, style));
    }
    
    public static CustomizableTableViewer newSingleCheckList(Composite parent, int style) {
        final CheckboxTableViewer checkedViewer = CheckboxTableViewer.newCheckList(parent, style);
        checkedViewer.addCheckStateListener(new ICheckStateListener() {
            public void checkStateChanged(final org.eclipse.jface.viewers.CheckStateChangedEvent event) {
                checkedViewer.setCheckedElements(new Object[] { event.getElement() });
            }
        });
        
        return new CustomizableTableViewer(checkedViewer);
    }
    
    public TableViewer getViewer() {
        return viewer;
    }
    
    public void refresh() {
        viewer.refresh();
    }

    public void addColumn(AbstractViewerColumn column, boolean asDefault) {
        if (asDefault) {
            defaultColumns.add(column);
        }
        allColumns.add(column);
    }

    public void createDefaultColumns() {
        viewer.getTable().setRedraw(false);
        if (viewer.getTable().getColumns() != null) {
            for (TableColumn column : viewer.getTable().getColumns()) {
                column.dispose();
            }
        }
        for (AbstractViewerColumn column : defaultColumns) {
            column.createColumn(viewer);
            if (column.getColumnSorter() != null) {
                addColumnViewerSorter(column.getColumnSorter());
            }
        }
        viewer.getTable().setRedraw(true);
    }

    public List<AbstractViewerColumn> getAllColumns() {
        return new ArrayList<AbstractViewerColumn>(allColumns);
    }

    public List<AbstractViewerColumn> getDefaultColumns() {
        return new ArrayList<AbstractViewerColumn>(defaultColumns);
    }

    public AbstractViewerColumn removeColumn(String columnHeader, boolean onlyFromDefault) {
        for (AbstractViewerColumn column : allColumns) {
            if (column.getText().equals(columnHeader)) {
                defaultColumns.remove(column);
                if (!onlyFromDefault) {
                    allColumns.remove(column);
                }
                return column;
            }
        }
        
        // not found
        throw new IllegalArgumentException("There is no column: " + columnHeader);
    }
    
    public void init(IMemento memento, String propertyId) {
        if (memento == null) {
            return;
        }
        try {
            String properties = memento.getString(propertyId);
            String widthProperties = memento.getString(propertyId + MEMENTO_WIDTH_SUFFIX);
            if (widthProperties == null) {
                widthProperties = "";
            }
            if (properties != null) {
                List<AbstractViewerColumn> columns = new ArrayList<AbstractViewerColumn>();
                StringTokenizer st = new StringTokenizer(properties, MEMENTO_SEPARATOR);
                StringTokenizer columnWidths = new StringTokenizer(widthProperties, MEMENTO_SEPARATOR);
                while (st.hasMoreTokens()) {
                    String id = st.nextToken();
                    boolean found = false;
                    for (AbstractViewerColumn column : getAllColumns()) {
                        if (column.getText().equals(id)) {
                            columns.add(column);
                            if (columnWidths.hasMoreTokens()) {
                                int width = Integer.valueOf(columnWidths.nextToken());
                                column.setDefaultWidth(width);
                            }
                            found = true;
                        }
                    }
                    if (!found) {
                        return;
                    }
                    
                }
                defaultColumns.clear();
                defaultColumns.addAll(columns);
            }
            createDefaultColumns();
            
            initSortState(memento, propertyId);
        }
        catch (RuntimeException e) {
            String msg = "Problem initializing state for " + getClass().getName() +
                " from memento property " + propertyId + ". " + e.getMessage();
            Status status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, msg, e);
            Policy.getLog().log(status);
            // continue anyway
        }
    }

    protected void initSortState(IMemento memento, String propertyId) {
        String sortColumn = memento.getString(propertyId + MEMENTO_SORT_COLUMN_SUFFIX);
        Integer sortDirection = memento.getInteger(propertyId + MEMENTO_SORT_DIRECTION_SUFFIX);
        if (sortColumn == null || sortDirection == null) {
            return;
        }
        AbstractViewerColumn column = findAbstractViewerColumn(sortColumn);
        if (column == null) {
            return;
        }
        ViewerColumn viewerColumn = column.getColumn();
        for (ColumnViewerSorter sorter : columnSorters) {
            if (sorter.getColumn() == viewerColumn) {
                sorter.setSorter(sortDirection);
                break;
            }
        }
    }
    
    private void addColumnViewerSorter(ColumnViewerSorter sorter) {
        columnSorters.add(sorter);
    }

    public void saveState(IMemento memento, String propertyId) {
        StringBuffer sb = new StringBuffer();
        StringBuffer columnWidths = new StringBuffer();
        for (AbstractViewerColumn column : getDefaultColumns()) {
            sb.append(column.getText()).append(MEMENTO_SEPARATOR);
            columnWidths.append(column.getColumnWidth()).append(MEMENTO_SEPARATOR);
        }
        memento.putString(propertyId, sb.toString());
        memento.putString(propertyId + MEMENTO_WIDTH_SUFFIX, columnWidths.toString());
        
        saveSortState(memento, propertyId);
    }

    protected void saveSortState(IMemento memento, String propertyId) {
        ViewerComparator comparator = viewer.getComparator();
        if (comparator instanceof ColumnViewerSorter) {
            ColumnViewerSorter sorter = (ColumnViewerSorter) comparator;
            if (sorter.getDirection() != ColumnViewerSorter.NONE) {
                AbstractViewerColumn column = findAbstractViewerColumn(sorter.getColumn());
                if (column != null) {
                    memento.putString(propertyId + MEMENTO_SORT_COLUMN_SUFFIX, column.getText());
                    memento.putInteger(propertyId + MEMENTO_SORT_DIRECTION_SUFFIX, sorter.getDirection());
                    return;
                }
            }
        }
    }
    
    private AbstractViewerColumn findAbstractViewerColumn(ViewerColumn viewerColumn) {
        for (AbstractViewerColumn column : getAllColumns()) {
            if (column.getColumn() == viewerColumn) {
                return column;
            }
        }
        // not found
        return null;
    }
    
    private AbstractViewerColumn findAbstractViewerColumn(String columnText) {
        for (AbstractViewerColumn column : getAllColumns()) {
            if (column.getText().equals(columnText)) {
                return column;
            }
        }
        // not found
        return null;
    }

    void setDefaultColumns(List<AbstractViewerColumn> defaultColumns) {
        this.defaultColumns = defaultColumns;
    }
    
    public void adjustTableColumnWidth(TableColumn tableColumn) {
        TextLayout textLayout = new TextLayout(viewer.getControl().getDisplay());
        ITableLabelProvider labelProvider = null;
        if (viewer.getLabelProvider() instanceof ITableLabelProvider) {
            labelProvider = (ITableLabelProvider) viewer.getLabelProvider();
        }

        int coloumnMaxWith = 0;
        textLayout.setText(tableColumn.getText());
        coloumnMaxWith = textLayout.getBounds().width + 15;
        if (viewer.getTable().getSortColumn() != null
                && viewer.getTable().getSortColumn().equals(tableColumn)) {
            coloumnMaxWith += 27;
        }

        if (labelProvider != null) {
            for (TableItem tableItem : viewer.getTable().getItems()) {
                String text = tableItem.getText(viewer.getTable().indexOf(tableColumn));
                if (text != null) {
                    textLayout.setText(text);
                    coloumnMaxWith = Math.max(coloumnMaxWith, textLayout.getBounds().width + 12);
                }
            }
        }

        tableColumn.setWidth(coloumnMaxWith);
    }

    public void adjustTableWidth(boolean includeHeader) {
        TextLayout textLayout = new TextLayout(viewer.getControl().getDisplay());
        for (int i = 0; i < viewer.getTable().getColumnCount(); i++) {
            TableColumn column = viewer.getTable().getColumn(i);
            if (column.getWidth() == 0) {
                continue;
            }
            int coloumnMaxWith = 0;
            if (includeHeader) {
                textLayout.setText(column.getText());
                coloumnMaxWith = textLayout.getBounds().width + 15;
                if (viewer.getTable().getSortColumn() != null
                        && viewer.getTable().getSortColumn().equals(column)) {
                    coloumnMaxWith += 27;
                }
            }

            for (TableItem tableItem : viewer.getTable().getItems()) {
                String text = tableItem.getText(i);
                int icon = tableItem.getImage(i) != null ? tableItem.getImage(i).getBounds().width + 5 : 0;
                if (text != null) {
                    textLayout.setText(text);
                    coloumnMaxWith = Math.max(coloumnMaxWith, textLayout.getBounds().width + 12 + icon);
                }
            }

            column.setWidth(coloumnMaxWith);
        }
    }
    

}
