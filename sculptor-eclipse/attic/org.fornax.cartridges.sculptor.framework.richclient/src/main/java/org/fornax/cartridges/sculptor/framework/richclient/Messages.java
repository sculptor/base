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
package org.fornax.cartridges.sculptor.framework.richclient;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.fornax.cartridges.sculptor.framework.richclient.messages"; //$NON-NLS-1$
    public static String ColumnChooserDlg_add;
    public static String ColumnChooserDlg_availableColumns;
    public static String ColumnChooserDlg_choseColumns;
    public static String ColumnChooserDlg_displayColumns;
    public static String ColumnChooserDlg_down;
    public static String ColumnChooserDlg_remove;
    public static String ColumnChooserDlg_up;
    public static String DateTimeStrategy_dateTimePattern;
    public static String LoginDialog_account;
    public static String LoginDialog_autoLogin;
    public static String LoginDialog_delete;
    public static String LoginDialog_guestPassword;
    public static String LoginDialog_guestUserId;
    public static String LoginDialog_invalidUserIdMessage;
    public static String LoginDialog_invalidUserIdTitle;
    public static String LoginDialog_ok;
    public static String LoginDialog_password;
    public static String LoginDialog_title;
    public static String LoginDialog_userId;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
