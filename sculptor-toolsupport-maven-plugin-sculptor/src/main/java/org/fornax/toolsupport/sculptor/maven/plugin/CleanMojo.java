/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.toolsupport.sculptor.maven.plugin;

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.plexus.util.FileUtils;

/**
 * This plugin deletes all files created by a previous run of the Sculptor code
 * generator. The {@link AbstractSculptorMojo#statusFile} is deleted as well.
 * 
 * @goal clean
 * @phase clean
 * @description Delete all files created by a previous run of the Sculptor code
 *              generator
 * @author Torsten Juergeleit
 */
public class CleanMojo extends AbstractSculptorMojo {

	/**
	 * Skip the clean-up of previously generated files.
	 * <p>
	 * Can be set from command line using '-Dsculptor.clean.skip=true'.
	 * 
	 * @parameter expression="${sculptor.clean.skip}" default-value="false"
	 */
	private boolean skip;

	/**
	 * Check if the execution should be skipped.
	 * 
	 * @return true to skip
	 */
	protected boolean isSkip() {
		return skip;
	}

	public final void execute() throws MojoExecutionException,
			MojoFailureException {

		// If skip flag set then omit clean-up
		if (isSkip()) {
			getLog().info("Skipping deletion of previously generated files");
		} else {

			// First delete all the previously generated files
			deleteGeneratedFiles();

			// Finally delete the status file
			if (statusFile.exists()) {
				try {
					// We have to make sure the file is deleted on Windows as
					// well
					FileUtils.forceDelete(statusFile);
				} catch (IOException e) {
					throw new MojoExecutionException(
							"Deleting status file failed", e);
				}
				if (isVerbose() || getLog().isDebugEnabled()) {
					getLog().info("Deleted status file: " + statusFile);
				}
			}
		}
	}

}
