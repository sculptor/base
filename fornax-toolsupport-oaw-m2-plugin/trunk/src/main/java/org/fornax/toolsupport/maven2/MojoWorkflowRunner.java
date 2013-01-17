/*
*	Copyright 2006 The Fornax Project Team
*	Licensed under the Apache License, Version 2.0 (the "License");
*	you may not use this file except in compliance with the License.
* 	You may obtain a copy of the License at
*
*	http://www.apache.org/licenses/LICENSE-2.0
*
* 	Unless required by applicable law or agreed to in writing, software
* 	distributed under the License is distributed on an "AS IS" BASIS,
* 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* 	See the License for the specific language governing permissions and
* 	limitations under the License.
*/
package org.fornax.toolsupport.maven2;

import org.apache.maven.plugin.logging.Log;
import org.apache.tools.ant.taskdefs.Java;

/**
 * Local class to execute the Workflow Engine.
 * @author Thorsten Kamann <thorsten.kamann@googlemail.com>
 * @author Karsten Thoms <karsten.thoms@itemis.de>
 * @since 1.0.0
 * @see org.openarchitectureware.workflow.WorkflowRunner
 * @see org.eclipse.emf.mwe.core.WorkflowRunner
 */
public class MojoWorkflowRunner {
	private Log log;
	private Java javaTask;

	public boolean run() {
		try {
			log.debug(javaTask.getCommandLine().toString());
			javaTask.getProject().executeTarget("run-workflow");
			return true;
		} catch (Exception e) {
			log.error(e.getClass().getSimpleName()+" occurred while running workflow: "+e.getMessage());
			log.debug(e);
			return false;
		}
	}

	protected void setLog(Log log) {
		this.log = log;
	}

	public void setJavaTask(Java javaTask) {
		this.javaTask = javaTask;
	}

}
