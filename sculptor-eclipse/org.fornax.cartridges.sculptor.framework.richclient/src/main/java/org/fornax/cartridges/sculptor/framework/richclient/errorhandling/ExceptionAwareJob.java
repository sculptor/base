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
package org.fornax.cartridges.sculptor.framework.richclient.errorhandling;

import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.springframework.context.MessageSource;

public abstract class ExceptionAwareJob extends Job {

    private ExceptionAware<IStatus> exceptionAware;
    
    public ExceptionAwareJob(String name, MessageSource messages) {
        super(name);
        exceptionAware = new ExceptionAware<IStatus>(messages, Status.CANCEL_STATUS);
    }

    @Override
    protected IStatus run(final IProgressMonitor monitor) {
        Callable<IStatus> callable = new Callable<IStatus>() {
            public IStatus call() throws Exception {
                return doRun(monitor);
            }
        };
        return exceptionAware.run(callable);
    }
    
    protected abstract IStatus doRun(IProgressMonitor monitor) throws Exception;

}
