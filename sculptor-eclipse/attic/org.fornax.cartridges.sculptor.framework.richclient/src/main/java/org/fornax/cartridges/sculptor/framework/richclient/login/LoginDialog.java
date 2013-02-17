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
package org.fornax.cartridges.sculptor.framework.richclient.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.Policy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.branding.IProductConstants;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.fornax.cartridges.sculptor.framework.richclient.Messages;
import org.fornax.cartridges.sculptor.framework.richclient.SculptorFrameworkPlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * Login dialog, which prompts for the user's account info, and has Login and
 * Cancel buttons.
 */
public class LoginDialog extends Dialog {

    private static final String SECRET_NODE_PREFIX = "login.secret."; //$NON-NLS-1$

    public static final String AUTO_LOGIN_PREFERENCE = "prefs_auto_login"; //$NON-NLS-1$

    private static final String USER_ID = "userId"; //$NON-NLS-1$
    private static final String PASSWORD = "password"; //$NON-NLS-1$
    private static final String SAVED = "saved-users"; //$NON-NLS-1$
    private static final String LAST_USER = "prefs_last_user"; //$NON-NLS-1$

    private Combo userIdText;
    private Text passwordText;
    private UserDetails userDetails;

    private Map<String, UserDetails> savedDetails = new HashMap<String, UserDetails>();

    private Image[] images;
    private final String parentPluginId;

    public LoginDialog(Shell parentShell, String parentPluginId) {
        super(parentShell);
        this.parentPluginId = parentPluginId;
        loadDescriptors();
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.LoginDialog_title);
        // load the image from the product definition
        IProduct product = Platform.getProduct();
        if (product != null) {
            String[] imageURLs = parseCSL(product.getProperty(IProductConstants.WINDOW_IMAGES));
            if (imageURLs.length > 0) {
                images = new Image[imageURLs.length];
                for (int i = 0; i < imageURLs.length; i++) {
                    String url = imageURLs[i];
                    ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(product.getDefiningBundle()
                            .getSymbolicName(), url);
                    images[i] = descriptor.createImage(true);
                }
                newShell.setImages(images);
            }
        }
    }

    public static String[] parseCSL(String csl) {
        if (csl == null)
            return null;

        StringTokenizer tokens = new StringTokenizer(csl, ","); //$NON-NLS-1$
        List<String> list = new ArrayList<String>();
        while (tokens.hasMoreTokens()) {
            list.add(tokens.nextToken().trim());
        }

        return (String[]) list.toArray(new String[list.size()]);
    }

    public boolean close() {
        if (images != null) {
            for (int i = 0; i < images.length; i++)
                images[i].dispose();
        }
        return super.close();
    }

    protected Control createDialogArea(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        composite.setLayout(layout);

        Label accountLabel = new Label(composite, SWT.NONE);
        accountLabel.setText(Messages.LoginDialog_account);
        accountLabel.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false, 2, 1));

        Label userIdLabel = new Label(composite, SWT.NONE);
        userIdLabel.setText(Messages.LoginDialog_userId);
        userIdLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));

        userIdText = new Combo(composite, SWT.BORDER);
        GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
        gridData.widthHint = convertHeightInCharsToPixels(20);
        userIdText.setLayoutData(gridData);
        userIdText.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                UserDetails d = (UserDetails) savedDetails.get(userIdText.getText());
                if (d != null) {
                    passwordText.setText(d.getPassword() == null ? "" : d.getPassword());
                }
            }
        });

        Label passwordLabel = new Label(composite, SWT.NONE);
        passwordLabel.setText(Messages.LoginDialog_password);
        passwordLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));

        passwordText = new Text(composite, SWT.BORDER | SWT.PASSWORD);
        passwordText.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

        final Button autoLogin = new Button(composite, SWT.CHECK);
        autoLogin.setText(Messages.LoginDialog_autoLogin);
        autoLogin.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, true, 2, 1));
        autoLogin.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                IEclipsePreferences prefs = new ConfigurationScope().getNode(parentPluginId);
                prefs.putBoolean(AUTO_LOGIN_PREFERENCE, autoLogin.getSelection());
            }
        });
        IPreferencesService service = Platform.getPreferencesService();
        boolean auto_login = service.getBoolean(parentPluginId, AUTO_LOGIN_PREFERENCE, true,
                null);

        autoLogin.setSelection(auto_login);

        String lastUser = "none"; //$NON-NLS-1$
        if (userDetails != null) {
            lastUser = userDetails.getUserId();
        }
        initializeUsers(lastUser);

        return composite;
    }

    protected void createButtonsForButtonBar(Composite parent) {
        Button removeCurrentUser = createButton(parent, IDialogConstants.CLIENT_ID, Messages.LoginDialog_delete, false);
        removeCurrentUser.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                savedDetails.remove(userIdText.getText());
                initializeUsers(""); //$NON-NLS-1$
            }
        });
        createButton(parent, IDialogConstants.OK_ID, Messages.LoginDialog_ok, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

    }

    protected void initializeUsers(String defaultUser) {
        userIdText.removeAll();
        passwordText.setText(""); //$NON-NLS-1$
        for (String each : savedDetails.keySet()) {
            userIdText.add(each);
        }
        int index = Math.max(userIdText.indexOf(defaultUser), 0);
        userIdText.select(index);
    }

    protected void okPressed() {
        if (userDetails.getUserId().equals("")) { //$NON-NLS-1$
            MessageDialog.openError(getShell(), Messages.LoginDialog_invalidUserIdTitle, Messages.LoginDialog_invalidUserIdMessage);
            return;
        }
        super.okPressed();
    }

    protected void buttonPressed(int buttonId) {
        String userId = userIdText.getText();
        String password = passwordText.getText();
        userDetails = new UserDetails(userId, password);
        savedDetails.put(userId, userDetails);
        if (buttonId == IDialogConstants.OK_ID || buttonId == IDialogConstants.CANCEL_ID) {
            saveDescriptors();
        }
        super.buttonPressed(buttonId);
    }

    protected void saveDescriptors() {
        try {
            Preferences preferences = new ConfigurationScope().getNode(parentPluginId);
            preferences.put(LAST_USER, userDetails.getUserId());
            Preferences connections = preferences.node(SAVED);
            connections.removeNode();
            connections = preferences.node(SAVED);
            for (String name : savedDetails.keySet()) {
                UserDetails d = (UserDetails) savedDetails.get(name);
                Preferences node = connections.node(name);
                node.put(USER_ID, d.getUserId());
                saveSecret(d);
            }
        
            preferences.flush();
        } catch (BackingStoreException e) {
            Status status = new Status(IStatus.ERROR, SculptorFrameworkPlugin.PLUGIN_ID, e.getMessage(), e);
            Policy.getLog().log(status);
        }
    }
        
    protected void loadDescriptors() {
        try {
            Preferences preferences = new ConfigurationScope().getNode(parentPluginId);
            Preferences connections = preferences.node(SAVED);
            String[] accountNames = connections.childrenNames();
            for (int i = 0; i < accountNames.length; i++) {
                String userName = accountNames[i];
                Preferences node = connections.node(userName);
                String userId = node.get(USER_ID, userName);
                String password = loadSecret(userName);
                savedDetails.put(userName, new UserDetails(userId, password));
            }
            if (savedDetails.isEmpty()) {
                savedDetails.put(Messages.LoginDialog_guestUserId, new UserDetails(Messages.LoginDialog_guestUserId, Messages.LoginDialog_guestPassword));
            }
            userDetails = (UserDetails) savedDetails.get(preferences.get(LAST_USER, "")); //$NON-NLS-1$
        } catch (BackingStoreException e) {
            Status status = new Status(IStatus.ERROR, SculptorFrameworkPlugin.PLUGIN_ID, e.getMessage(), e);
            Policy.getLog().log(status);
        }
    }
    
    protected void saveSecret(UserDetails userDetails) {
        ISecurePreferences securePreferences = SecurePreferencesFactory.getDefault().node(
                SECRET_NODE_PREFIX + userDetails.getUserId());
        try {
            securePreferences.put(PASSWORD, userDetails.getPassword(), true);
        } catch (StorageException e) {
            Status status = new Status(IStatus.ERROR, SculptorFrameworkPlugin.PLUGIN_ID, e.getMessage(), e);
            Policy.getLog().log(status);
        }
    }
    
    protected String loadSecret(String userName) {
        try {
            String nodeName = SECRET_NODE_PREFIX + userName;
            if (!SecurePreferencesFactory.getDefault().nodeExists(nodeName)) {
                return null;
            }
        
            return SecurePreferencesFactory.getDefault().node(nodeName).get(PASSWORD, null);
        } catch (StorageException e) {
            Status status = new Status(IStatus.ERROR, SculptorFrameworkPlugin.PLUGIN_ID, e.getMessage(), e);
            Policy.getLog().log(status);
            return null;
        }
    }

    /**
     * Returns the connection details entered by the user, or <code>null</code>
     * if the dialog was canceled.
     */
    public UserDetails getUserDetails() {
        return userDetails;
    }
}
