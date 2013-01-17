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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.fornax.cartridges.sculptor.framework.richclient.Messages;

/**
 * Allows the user to hide/show columns in a table.
 */
public class ColumnChooserDlg extends Dialog {
    private List availableList;
    private List displayList;

    private Button okButton;
    private CustomizableTableViewer tableViewer;
    private ListViewer displayListViewer;
    private ListViewer availableListViewer;
    private Button downButton;
    private Button upButton;
    private Button removeButton;
    private Button addButton;

    public ColumnChooserDlg(Shell parentShell, CustomizableTableViewer tableViewer) {
        super(parentShell);
        this.tableViewer = tableViewer;
        setShellStyle(SWT.RESIZE | SWT.TITLE);
    }

    /**
     * Create contents of the button bar
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Create contents of the dialog
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        getShell().setText(Messages.ColumnChooserDlg_choseColumns);

        final Composite composite = new Composite((Composite) super.createDialogArea(parent), SWT.NONE);

        doCreateViewerComposite(composite);

        return composite;
    }

    private void doCreateViewerComposite(Composite composite) {
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout compositeLayout = new GridLayout();
        compositeLayout.numColumns = 3;
        composite.setLayout(compositeLayout);

        Label displayColumnsLabel = new Label(composite, SWT.NONE);
        displayColumnsLabel.setText(Messages.ColumnChooserDlg_displayColumns);
        new Label(composite, SWT.NONE);

        Label availableColumnsLabel = new Label(composite, SWT.NONE);
        availableColumnsLabel.setText(Messages.ColumnChooserDlg_availableColumns);

        displayListViewer = new ListViewer(composite, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER | SWT.H_SCROLL);
        displayListViewer.setContentProvider(new ArrayContentProvider());
        displayListViewer.setInput(tableViewer.getDefaultColumns().toArray());
        displayListViewer.setLabelProvider(new ColumnLabelProvider());
        displayList = displayListViewer.getList();
        displayList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        Composite buttonComposite = new Composite(composite, SWT.NONE);
        buttonComposite.setLayout(new GridLayout());

        addButton = new Button(buttonComposite, SWT.NONE);
        addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
        addButton.setText(Messages.ColumnChooserDlg_add);
        addButton.setEnabled(false);

        removeButton = new Button(buttonComposite, SWT.NONE);
        GridData removeButtonGd = new GridData(SWT.LEFT, SWT.TOP, false, false);
        removeButton.setLayoutData(removeButtonGd);
        removeButton.setText(Messages.ColumnChooserDlg_remove);
        removeButton.setEnabled(false);

        upButton = new Button(buttonComposite, SWT.NONE);
        GridData upButtonGd = new GridData(SWT.FILL, SWT.CENTER, false, false);
        upButtonGd.verticalIndent = 20;
        upButton.setLayoutData(upButtonGd);
        upButton.setText(Messages.ColumnChooserDlg_up);
        upButton.setEnabled(false);

        downButton = new Button(buttonComposite, SWT.NONE);
        downButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        downButton.setText(Messages.ColumnChooserDlg_down);
        downButton.setEnabled(false);

        availableListViewer = new ListViewer(composite, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER | SWT.H_SCROLL);
        availableListViewer.setContentProvider(new ArrayContentProvider());
        java.util.List<AbstractViewerColumn> availableColumns = new ArrayList<AbstractViewerColumn>();
        availableColumns.addAll(tableViewer.getAllColumns());
        Collections.sort(availableColumns, new Comparator<AbstractViewerColumn>() {
            public int compare(AbstractViewerColumn col1, AbstractViewerColumn col2) {
                return col1.getText().compareTo(col2.getText());
            }
        });
        availableListViewer.setInput(availableColumns.toArray());
        availableListViewer.setLabelProvider(new ColumnLabelProvider());
        availableList = availableListViewer.getList();
        availableList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        displayListViewer.addSelectionChangedListener(new UpdateButtons());
        availableListViewer.addSelectionChangedListener(new UpdateButtons());

        ViewerFilter filter = new ViewerFilter() {
            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                Object input = displayListViewer.getInput();
                if (input instanceof Object[]) {
                    return !Arrays.asList((Object[]) input).contains(element);
                }

                return true;
            }
        };
        availableListViewer.setFilters(new ViewerFilter[] { filter });

        addButton.addSelectionListener(new SelectionAdapter() {
            @SuppressWarnings("unchecked")
            @Override
            public void widgetSelected(SelectionEvent event) {
                StructuredSelection selection = (StructuredSelection) availableListViewer.getSelection();
                Object[] items = (Object[]) displayListViewer.getInput();
                java.util.List<Object> listItems = new ArrayList<Object>();
                listItems.addAll(Arrays.asList(items));
                listItems.addAll(selection.toList());
                displayListViewer.setInput(listItems.toArray());
                displayListViewer.refresh();
                availableListViewer.refresh();
                updateButtons();
            }
        });

        removeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                StructuredSelection selection = (StructuredSelection) displayListViewer.getSelection();
                Object[] items = (Object[]) displayListViewer.getInput();
                java.util.List<Object> listItems = new ArrayList<Object>();
                listItems.addAll(Arrays.asList(items));
                listItems.removeAll(selection.toList());
                displayListViewer.setInput(listItems.toArray());
                displayListViewer.refresh();
                availableListViewer.refresh();
                updateButtons();
            }
        });

        upButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                StructuredSelection selection = (StructuredSelection) displayListViewer.getSelection();
                Object[] items = (Object[]) displayListViewer.getInput();
                java.util.List<Object> listItems = new ArrayList<Object>();
                listItems.addAll(Arrays.asList(items));
                for (Object each : selection.toList()) {
                    int index = listItems.indexOf(each);
                    listItems.remove(each);
                    listItems.add(index - 1, each);
                }
                displayListViewer.setInput(listItems.toArray());
                displayListViewer.refresh();
                displayListViewer.setSelection(selection);
                displayListViewer.reveal(selection.getFirstElement());
                updateButtons();
            }
        });

        downButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                StructuredSelection selection = (StructuredSelection) displayListViewer.getSelection();
                Object[] items = (Object[]) displayListViewer.getInput();
                java.util.List<Object> listItems = new ArrayList<Object>();
                listItems.addAll(Arrays.asList(items));
                for (int i = selection.size() - 1; i > -1; i--) {
                    Object each = selection.toArray()[i];
                    int index = listItems.indexOf(each);
                    listItems.remove(each);
                    listItems.add(index + 1, each);
                }
                displayListViewer.setInput(listItems.toArray());
                displayListViewer.refresh();
                displayListViewer.setSelection(selection);
                displayListViewer.reveal(selection.getFirstElement());
                updateButtons();
            }
        });

        availableListViewer.refresh();
    }

    private void updateButtons() {
        updateAddButton();
        updateRemoveButton();
        updateUpButton();
        updateDownButton();
        updateOkButton();
    }

    private void updateOkButton() {
        okButton.setEnabled(displayList.getItemCount() > 0);
    }

    private void updateRemoveButton() {
        removeButton.setEnabled(!displayListViewer.getSelection().isEmpty()
                && ((StructuredSelection) displayListViewer.getSelection()).size() != displayList.getItemCount());
    }

    private void updateAddButton() {
        addButton.setEnabled(!availableListViewer.getSelection().isEmpty());
    }

    private void updateUpButton() {
        if (displayListViewer.getSelection().isEmpty()) {
            upButton.setEnabled(false);
        } else {
            StructuredSelection selection = (StructuredSelection) displayListViewer.getSelection();
            Object[] items = (Object[]) displayListViewer.getInput();
            Object firstItem = items[0];
            upButton.setEnabled(!selection.toList().contains(firstItem));
        }
    }

    private void updateDownButton() {
        if (displayListViewer.getSelection().isEmpty()) {
            downButton.setEnabled(false);
        } else {
            StructuredSelection selection = (StructuredSelection) displayListViewer.getSelection();
            Object[] items = (Object[]) displayListViewer.getInput();
            Object lastItem = items[items.length - 1];
            downButton.setEnabled(!selection.toList().contains(lastItem));
        }
    }

    @Override
    protected void okPressed() {
        Object[] input = (Object[]) displayListViewer.getInput();
        ArrayList<AbstractViewerColumn> columns = new ArrayList<AbstractViewerColumn>();
        for (Object each : input) {
            columns.add((AbstractViewerColumn) each);
        }
        tableViewer.setDefaultColumns(columns);
        tableViewer.createDefaultColumns();
        tableViewer.refresh();

        tableViewer.adjustTableWidth(true);
        super.okPressed();
    }

    private static class ColumnLabelProvider extends LabelProvider {
        @Override
        public String getText(Object element) {
            AbstractViewerColumn column = (AbstractViewerColumn) element;
            return column.getText();
        }
    }
    
    private class UpdateButtons implements ISelectionChangedListener {
        public void selectionChanged(SelectionChangedEvent event) {
            updateButtons();
        }
    }

}
