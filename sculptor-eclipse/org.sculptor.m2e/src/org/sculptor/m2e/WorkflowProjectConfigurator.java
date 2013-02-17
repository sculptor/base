/*
 * Copyright 2011 The Fornax Project Team, including the original 
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

package org.sculptor.m2e;

import java.io.File;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;
import org.eclipse.m2e.jdt.AbstractJavaProjectConfigurator;
import org.eclipse.m2e.jdt.IClasspathDescriptor;
import org.eclipse.m2e.jdt.IClasspathEntryDescriptor;

/**
 * {@link AbstractJavaProjectConfigurator} which adds the folders with the
 * artifacts created by the Fornax code generator plugin to a Java projects
 * classpath.
 * 
 * @author Torsten Juergeleit
 */
public class WorkflowProjectConfigurator extends
		AbstractJavaProjectConfigurator {

	@Override
	public void configureRawClasspath(ProjectConfigurationRequest request,
			IClasspathDescriptor classpath, IProgressMonitor monitor)
			throws CoreException {

		assertHasNature(request.getProject(), JavaCore.NATURE_ID);

		// Remove exclusion patterns from resources classpath entries
		for (IClasspathEntryDescriptor entry : classpath.getEntryDescriptors()) {
			if (entry.getPath().lastSegment().equals("resources")) {
				IPath[] patterns = entry.getExclusionPatterns();
				if (patterns.length == 1 && patterns[0].segmentCount() == 1
						&& patterns[0].lastSegment().equals("**")) {
					entry.setExclusionPatterns(new IPath[0]);
				}
			}
		}

		// Add generator outlet folders to classpath
		for (MojoExecution mojoExecution : getMojoExecutions(request, monitor)) {
			addSourcePath("outletSrcDir", mojoExecution, request, classpath,
					false);
			addSourcePath("outletResDir", mojoExecution, request, classpath,
					false);
			addSourcePath("outletSrcTestDir", mojoExecution, request,
					classpath, true);
			addSourcePath("outletResTestDir", mojoExecution, request,
					classpath, true);
		}
	}

	private void addSourcePath(String parameter, MojoExecution mojoExecution,
			ProjectConfigurationRequest request,
			IClasspathDescriptor classpath, boolean isTest)
			throws CoreException {
		IMavenProjectFacade facade = request.getMavenProjectFacade();
		File source = maven.getMojoParameterValue(request.getMavenSession(),
				mojoExecution, parameter, File.class);
		if (source != null) {
			IPath sourcePath = getFullPath(facade, source);
			if (sourcePath != null && !classpath.containsPath(sourcePath)) {
				IPath outputLocation = (isTest ? facade.getTestOutputLocation()
						: facade.getOutputLocation());
				classpath.addSourceEntry(sourcePath, outputLocation, true);
			}
		}
	}
}
