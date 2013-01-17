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
package org.fornax.cartridges.sculptor.framework.richclient.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.swt.widgets.Display;

public class HeadlessRealm extends Realm {
    
    public static void useAsDefault() {
        Realm.setDefault(new HeadlessRealm());
        Display.getDefault();
    }
    
    private HeadlessRealm() {
    }

    @Override
    public boolean isCurrent() {
        return true;
    }
    
    public static void processDisplayEvents() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        
        final CountDownLatch displayLatch = new CountDownLatch(1);
        Runnable runnable = new Runnable() {
            public void run() {
                displayLatch.countDown();
            }
        };
        Display.getDefault().asyncExec(runnable);
        readAndDispatchAll();
        
        try {
            displayLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
    }
    
    private static void readAndDispatchAll() {
        while (true) {
            boolean more = Display.getDefault().readAndDispatch();
            if (!more) {
                break;
            }
        }
    }
    
}
