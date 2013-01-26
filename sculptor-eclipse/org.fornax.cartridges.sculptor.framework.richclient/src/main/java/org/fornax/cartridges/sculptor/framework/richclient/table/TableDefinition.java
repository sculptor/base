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

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.fornax.cartridges.sculptor.framework.richclient.databinding.GetAsTextPropertyEditorConverter;

/**
 * Internal DSL expression builder to define columns for table.
 *
 */
public class TableDefinition {

    private CustomizableTableViewer tableViewer;
    private List<ColumnBuilderImpl> columnBuilders = new ArrayList<ColumnBuilderImpl>();

    public TableDefinition(CustomizableTableViewer tableViewer) {
        this.tableViewer = tableViewer;
    }

    public void build() {
        for (ColumnBuilderImpl colBuilder : columnBuilders) {
            tableViewer.addColumn(colBuilder.createTableColumn(), colBuilder.isUseAsDefault());
        }
        tableViewer.createDefaultColumns();
    }

    public ColumnBuilder column(String header) {
        ColumnBuilderImpl columnBuilder = new ColumnBuilderImpl(header);
        columnBuilders.add(columnBuilder);
        return columnBuilder;
    }

    public interface ColumnBuilder {
        ColumnBuilder property(String propertyName);

        ColumnBuilder hide();

        ColumnBuilder convertWith(UpdateValueStrategy convertStrategy);
        
        ColumnBuilder convertWith(IConverter converter);
        
        ColumnBuilder convertWith(PropertyEditor converter);

        ColumnBuilder modelSorting();
        
        ColumnBuilder notSortable();
        
        ColumnBuilder alignRight();

        ColumnBuilder alignLeft();

        ColumnBuilder alignCenter();
    }

    class ColumnBuilderImpl implements ColumnBuilder {
        private String header;
        private String propertyName;
        private int style = SWT.NONE;
        private UpdateValueStrategy convertStrategy;
        private boolean useModelComparable;
        private boolean useAsDefault = true;
        private boolean sortable = true;

        ColumnBuilderImpl(String header) {
            this.header = header;
        }

        boolean isUseAsDefault() {
            return useAsDefault;
        }
        
        public ColumnBuilder hide() {
            this.useAsDefault = false;
            return this;
        }
        
        public ColumnBuilder property(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }
        
        public ColumnBuilder convertWith(UpdateValueStrategy convertStrategy) {
            this.convertStrategy = convertStrategy;
            return this;
        }
        
        public ColumnBuilder convertWith(IConverter converter) {
            UpdateValueStrategy strategy = new UpdateValueStrategy();
            strategy.setConverter(converter);
            return convertWith(strategy);
        }
        
        public ColumnBuilder convertWith(PropertyEditor converter) {
            return convertWith(new GetAsTextPropertyEditorConverter(converter));
        }
        
        public ColumnBuilder modelSorting() {
            useModelComparable = true;
            return this;
        }
        
        public ColumnBuilder notSortable() {
            sortable = false;
            return this;
        }
        
        public ColumnBuilder alignRight() {
            return style(SWT.RIGHT);
        }
        
        public ColumnBuilder alignLeft() {
            return style(SWT.LEFT);
        }
        
        public ColumnBuilder alignCenter() {
            return style(SWT.CENTER);
        }
        
        public ColumnBuilder style(int appendStyle) {
            this.style = this.style | appendStyle;
            return this;
        }
        

        AbstractViewerColumn createTableColumn() {
            if (!sortable || !useModelComparable) {
                return new ViewerColumnImpl(header, propertyName, style, convertStrategy, sortable);
            } else {
                return new ViewerColumnComparableImpl(header, propertyName, style, convertStrategy);
            }
        }

    }

    static class ViewerColumnImpl extends AbstractViewerColumn {
        String propertyName;
        int style;
        UpdateValueStrategy convertStrategy;

        protected ViewerColumnImpl(String header, String propertyName, int style, UpdateValueStrategy convertStrategy,
                boolean sortable) {
            super(header, AbstractViewerColumn.DEFAULT_WIDTH, sortable);
            this.propertyName = propertyName;
            this.style = style;
            this.convertStrategy = convertStrategy;
        }

        @Override
        protected int getStyle() {
            return style;
        }

        @Override
        public ColumnLabelProvider getColumnLabelProvider() {
            return new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    if (convertStrategy != null) {
                        return (String) convertStrategy.convert(getProperty(element, propertyName));
                    }
                    Object value = getProperty(element, propertyName);
                    if (value == null) {
                        return "";
                    }
                    return String.valueOf(value);

                }
            };
        }

        protected Object getProperty(Object obj, String propertyName) {
            try {
                if (obj == null) {
                    return null;
                }
                return PropertyUtils.getProperty(obj, propertyName);
                
            } catch (Exception e) {
                return null;
            }
        }
    }

    static class ViewerColumnComparableImpl extends ViewerColumnImpl {

        ViewerColumnComparableImpl(String header, String propertyName, int style, UpdateValueStrategy convertStrategy) {
            super(header, propertyName, style, convertStrategy, true);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void setupColumnSorter(ColumnViewer columnViewer, TableViewerColumn column) {
            new ColumnViewerSorter(columnViewer, column) {
                @Override
                protected int doCompare(Viewer viewer, Object object1, Object object2) {
                    Comparable value1 = (Comparable) getProperty(object1, propertyName);
                    Comparable value2 = (Comparable) getProperty(object2, propertyName);
                    if (value1 != null && value2 != null) {
                        return value1.compareTo(value2);
                    }
                    return 0;
                }
            };
        }

    }

}
