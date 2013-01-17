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
package org.fornax.cartridges.sculptor.framework.richclient.databinding;

import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.swt.widgets.Display;

public class ObservableUtil {

    public static WritableList createWritableList(final List<?> wrappedList) {
        if (Realm.getDefault() == null) {
            final WritableList[] resultHolder = new WritableList[1];
            Display.getDefault().syncExec(new Runnable() {
                public void run() {
                    WritableList result = new WritableList(wrappedList, null);
                    resultHolder[0] = result;
                }
            });
            return resultHolder[0];
        } else {
            WritableList result = new WritableList(wrappedList, null);
            return result;
        }
        
    }

}
