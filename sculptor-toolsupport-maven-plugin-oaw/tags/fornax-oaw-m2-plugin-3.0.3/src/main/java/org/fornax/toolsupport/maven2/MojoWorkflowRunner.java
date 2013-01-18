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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.plugin.logging.Log;

/**
 * Local class to execute the Workflow Engine. 
 * @author Thorsten Kamann <thorsten.kamann@googlemail.com>
 * @author Karsten Thoms <karsten.thoms@itemis.de>
 * @since 1.0.0
 * @see org.openarchitectureware.workflow.WorkflowRunner
 * @see org.eclipse.emf.mwe.core.WorkflowRunner
 */
public class MojoWorkflowRunner {
	private Object workflowRunner;
	private Object progressMonitor;
	private Method runMethod;
	private Log log;
	
	protected void setLog(Log log) {
		this.log = log;
	}

	public boolean run(String workflowDescriptor, 
			Map<String, String> params, HashMap<String, Object> externalSlotContents) {

		if (workflowRunner == null) throw new IllegalStateException("workflowRunnerClass not set");
		if (progressMonitor == null) throw new IllegalStateException("progressMonitorClass not set");

		try {
			return (Boolean) runMethod.invoke(workflowRunner, workflowDescriptor, progressMonitor, params, externalSlotContents);
		} catch (InvocationTargetException e) {
			log.error(e.getTargetException().getClass().getSimpleName()+" occurred while running workflow: "+e.getTargetException().getMessage());
			return false;
		} catch (Exception e) {
			log.error(e.getClass().getSimpleName()+" occurred while running workflow: "+e.getMessage());
			return false;
		}
		
	}


	public void setWorkflowRunnerClass(String workflowRunnerClassName) {
		if (workflowRunnerClassName == null) throw new IllegalArgumentException ("null argument not allowed");
		Class<?> workflowRunnerClass = null;
		try {
			workflowRunnerClass = Class.forName(workflowRunnerClassName, true, Thread.currentThread().getContextClassLoader());
			workflowRunner = workflowRunnerClass.newInstance();
			runMethod = getRunMethod(workflowRunnerClass);
		} catch (IllegalArgumentException e) {
			// thrown by getRunMethod()
			throw e;
		} catch (Exception e) {
			throw new IllegalArgumentException ("Cannot load or instantiate class "+workflowRunnerClassName);
		}
	}


	public void setProgressMonitorClass(String progressMonitorClass) {
		if (progressMonitorClass == null) throw new IllegalArgumentException ("null argument not allowed");
		try {
			progressMonitor = Class.forName(progressMonitorClass, true, Thread.currentThread().getContextClassLoader()).newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException ("Cannot load or instantiate class "+progressMonitorClass);
		}
	}

	/**
	 * Find the run method using reflection. Problem is that the ProgressMonitor interface is different. 
	 * @param workflowRunner
	 * @return
	 */
	private Method getRunMethod (Class<?> workflowRunner) {
		Method run = null;
		for (Method m : workflowRunner.getMethods()) {
			if ("run".equals(m.getName())) {
				Class<?>[] paramTypes = m.getParameterTypes();
				if (paramTypes.length==4
					&& String.class.equals(paramTypes[0])
					&& "ProgressMonitor".equals(paramTypes[1].getSimpleName())
					&& Map.class.isAssignableFrom(paramTypes[2])
					&& Map.class.isAssignableFrom(paramTypes[3])
					) {
					run = m;
				}
			}
		}
		if (run == null) {
			throw new IllegalArgumentException ("Cannot find 'run' method in class "+workflowRunner.getName());
		}
		return run;
	}


}
