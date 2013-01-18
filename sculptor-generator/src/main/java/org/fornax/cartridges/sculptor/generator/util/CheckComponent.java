/*
 * Copyright 2010 The Fornax Project Team, including the original
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
package org.fornax.cartridges.sculptor.generator.util;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Fixes the problem with reporting of issues.
 */
public class CheckComponent extends org.eclipse.xtend.check.CheckComponent {
    @Override
    protected void invokeInternal2(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
        try {
            super.invokeInternal2(ctx, monitor, issues);
        } catch (WorkflowInterruptedException e) {
            throw new WorkflowInterruptedException(e.getMessage() + issues);
        }
    }
}
