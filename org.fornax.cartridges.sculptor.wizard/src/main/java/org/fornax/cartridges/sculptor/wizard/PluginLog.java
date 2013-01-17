/*
 * Copyright 2007 The Fornax Project Team, including the original 
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
package org.fornax.cartridges.sculptor.wizard;


import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class PluginLog {
    public final static void logInfo(final String msg) {
        log(IStatus.INFO, IStatus.OK, msg, null);
    }

    public final static void logError(final Throwable t) {
        logError(t.getMessage(), t);
    }

    public final static void logError(final String msg, final Throwable t) {
        t.printStackTrace();
        log(IStatus.ERROR, IStatus.OK, msg, t);
    }

    private final static void log(final int severity, final int code, final String message, final Throwable exception) {
        log(createStatus(severity, code, message, exception));
    }

    public final static IStatus createStatus(final int severity, final int code, final String message,
            final Throwable exception) {
        return new Status(severity, Activator.getDefault().getBundle().getSymbolicName(), code,
                message != null ? message : "", exception);
    }

    private final static void log(final IStatus status) {
        Activator.getDefault().getLog().log(status);
    }
}
