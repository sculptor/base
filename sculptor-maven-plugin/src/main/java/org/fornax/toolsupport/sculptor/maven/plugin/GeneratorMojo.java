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

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.FileSet;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.toolchain.Toolchain;
import org.apache.maven.toolchain.ToolchainManager;
import org.codehaus.plexus.util.FileUtils;

/**
 * This plugin starts the Sculptor code generator by launching an Eclipse MWE2
 * workflow.
 * <p>
 * You can configure resources that should be checked if they are up to date to
 * avoid needless generator runs and optimize build execution time.
 * <p>
 * This plugin reuses code from the <a href=
 * "http://fornax.itemis.de/confluence/display/fornax/OAW-M2-Plugin+%28TOM%29"
 * >Fornax OAW Maven2 plugin</a> created by Thorsten Kamann and Karsten Thoms.
 * 
 * @goal generate
 * @phase generate-sources
 * @requiresDependencyResolution test
 * @description Running Sculptor code generator by launching an Eclipse MWE2
 *              workflow
 * @author Torsten Juergeleit
 */
public class GeneratorMojo extends AbstractSculptorMojo {

	protected static final String LOGBACK_CONFIGURATION_FILE_PROPERTY = "logback.configurationFile";

	protected static final String MWE2_WORKFLOW_LAUNCHER = "org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher";

	protected static final String CHANGED_FILES_PROPERTY = "fornax-oaw-m2-plugin.changedFiles";

	protected static final String LOGBACK_NORMAL_CONFIGURATION_FILE_NAME = "logback-normal-sculptor-maven-plugin.xml";
	protected static final String LOGBACK_VERBOSE_CONFIGURATION_FILE_NAME = "logback-verbose-sculptor-maven-plugin.xml";

	/**
	 * The current build session instance. This is used for toolchain manager
	 * API calls.
	 * 
	 * @parameter default-value="${session}"
	 * @required
	 * @readonly
	 */
	private MavenSession session;

	/**
	 * The plugins dependencies. This is used to create the classpath for the
	 * JVM running the code generator.
	 * 
	 * @parameter default-value="${plugin.artifacts}"
	 * @required
	 * @readonly
	 */
	private List<Artifact> pluginDependencies;

	/**
	 * The current toolchain manager instance.
	 * 
	 * @component
	 */
	private ToolchainManager toolchainManager;

	/**
	 * Relative path of workflow descriptor file.
	 * 
	 * @parameter default-value="src/main/resources/generator/Workflow.mwe2"
	 * @required
	 */
	private String workflowDescriptor;

	/**
	 * A <code>java.util.List</code> of {@link FileSet}s that will be checked on
	 * up to date. If all resources are up to date the plugin stops the
	 * execution, because there are no files to regenerate. <br/>
	 * The entries of this list can be relative path to the project root or
	 * absolute path.
	 * <p>
	 * If not specified then a fileset with the default value of
	 * <code>"src/main/resources/*.btdesign"</code> is used.
	 * 
	 * @parameter
	 */
	private FileSet[] checkFileSets;

	/**
	 * Optional commandline arguments for the JVM which is used to execute the
	 * generator.
	 * <p>
	 * This can be used to specify different JVM memory settings, e.g.
	 * <code>-Xmx512m</code> or <code>-XX:MaxPermSize=128m</code>.
	 * <p>
	 * If not specified then the default value of
	 * <code>"-client -Xms100m -Xmx500m"</code> is used.
	 * 
	 * @parameter
	 */
	private String[] jvmArguments;

	/**
	 * Skip the execution.
	 * <p>
	 * Can be set from command line using '-Dsculptor.generator.skip=true'.
	 * 
	 * @parameter expression="${sculptor.generator.skip}" default-value="false"
	 */
	private boolean skip;

	/**
	 * Don't try to detect if Sculptor code generation is up-to-date and can be
	 * skipped.
	 * <p>
	 * Can be set from command line using '-Dsculptor.generator.force=true'.
	 * 
	 * @parameter expression="${sculptor.generator.force}" default-value="false"
	 */
	private boolean force;

	/**
	 * Delete all previously generated files before starting code generation.
	 * <p>
	 * Can be set from command line using '-Dsculptor.generator.clean=false'.
	 * 
	 * @parameter expression="${sculptor.generator.clean}" default-value="true"
	 */
	private boolean clean;

	/**
	 * Returns <code>workflowDescriptor</code>.
	 */
	protected String getWorkflowDescriptor() {
		return workflowDescriptor;
	}

	/**
	 * Returns <code>workflowDescriptor</code> file.
	 */
	protected File getWorkflowDescriptorFile() {
		File workflowDescriptorFile = new File(project.getBasedir(),
				workflowDescriptor);
		return workflowDescriptorFile;
	}

	/**
	 * Check if the execution should be skipped.
	 * 
	 * @return true to skip
	 */
	protected boolean isSkip() {
		return skip;
	}

	/**
	 * Check if the execution should be forced.
	 * 
	 * @return true to force
	 */
	protected boolean isForce() {
		return force;
	}

	/**
	 * Check if the previously generated files.
	 * 
	 * @return true to delete
	 */
	protected boolean isClean() {
		return clean;
	}

	/**
	 * Strategy implementation of running the code generator:
	 * <ol>
	 * <li>check the <code>skip</code> flag
	 * <li>check the specified <code>workflowDescriptor</code> file
	 * <li>get a list of modified files from <code>checkFileSets</code>
	 * <li>run the code generator
	 * <li>update the <code>statusFile</code>
	 * <li>extend the compile roots and resources of the enclosing Maven project
	 * with the output directories of the code generator
	 * </ol>
	 */
	public final void execute() throws MojoExecutionException {

		// Initialize missing Mojo parameters
		initMojoMultiValueParameters();

		// If skip flag set then omit code generator execution
		if (isSkip()) {
			getLog().info("Skipping workflow execution");
			return;
		}

		// Check workflow descriptor file
		File workflowDescriptorFile = getWorkflowDescriptorFile();
		if (!workflowDescriptorFile.exists()
				|| !workflowDescriptorFile.isFile()) {
			throw new MojoExecutionException("Workflow descriptor file '"
					+ workflowDescriptor + "' specified in "
					+ "<workflowDescriptor/> does not exists");
		}

		// If not forced flag set the check for modified source files
		Set<String> changedFiles;
		if (isForce()) {
			getLog().info("Forced workflow execution");
			changedFiles = null;
		} else {
			changedFiles = getChangedFiles();
		}

		// Code generator is only executed if force flag is set or source files
		// are modified
		if (changedFiles == null || !changedFiles.isEmpty()) {

			// If clean flag set then delete the previously generated files
			if (isClean()) {
				deleteGeneratedFiles();
			} else {
				getLog().info(
						"Automatic cleanup disabled - keeping "
								+ "previously generated files");
			}

			// Execute Sculptor code generator and update status file
			List<File> createdFiles = executeGenerator(changedFiles);
			if (createdFiles != null) {
				updateStatusFile(createdFiles);
			} else {
				throw new MojoExecutionException(
						"Sculptor code generator failed");
			}
		}

		// Extend the Maven projects compile source roots and resource
		// directories with the generators directories
		extendProjectCompileRootsAndResources();
	}

	/**
	 * Initialize default values for the multi-value Mojo parameters
	 * <code>checkFileSets</code> and <code>jvmArguments</code>.
	 */
	protected void initMojoMultiValueParameters() {

		// Set default values for 'checkFileSets' to
		// "src/main/resources/*.btdesign"
		if (checkFileSets == null) {
			FileSet defaultFileSet = new FileSet();
			defaultFileSet.setDirectory(project.getBasedir()
					+ "/src/main/resources");
			defaultFileSet.addInclude("*.btdesign");
			checkFileSets = new FileSet[] { defaultFileSet };
		}

		// Set default values for 'jvmArguments' to
		// "-client -Xms100m -Xmx500m"
		if (jvmArguments == null) {
			jvmArguments = new String[] { "-client", "-Xms100m", "-Xmx500m" };
		}
	}

	/**
	 * Extends {@link MavenProject}s compile source roots and resource
	 * directories with the directories holding the generated artifacts.
	 * <p>
	 * There's no problem to call this method multiple time. The corresponding
	 * directories are added only once.
	 */
	protected void extendProjectCompileRootsAndResources()
			throws MojoExecutionException {
		if (project != null) {
			try {
				extendCompileSourceRoots();
				extendResources(outletResDir, false);
				extendResources(outletResOnceDir, false);
				extendResources(outletResTestDir, true);
				extendResources(outletResTestOnceDir, true);
			} catch (Exception ex) {
				throw new MojoExecutionException("Could not extend the "
						+ "projects compile paths", ex);
			}
		}
	}

	/**
	 * Extends {@link MavenProject}s <code>CompileSourceRoots</code> and
	 * <code>TestCompileSourceRoots</code> with the directories holding the
	 * generated source code artifacts.
	 * <p>
	 * There's no problem in adding the same directory multiple times because
	 * this is handled by {@link MavenProject}.
	 */
	private void extendCompileSourceRoots() {

		// Add source artifacts
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info(
					"Adding compile source directory '" + outletSrcDir + "'");
		}
		project.addCompileSourceRoot(outletSrcDir.getAbsolutePath());
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info(
					"Adding compile source directory '" + outletSrcOnceDir
							+ "'");
		}
		project.addCompileSourceRoot(outletSrcOnceDir.getAbsolutePath());

		// Add test source artifacts
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info(
					"Adding test compile source directory '" + outletSrcTestDir
							+ "'");
		}
		project.addTestCompileSourceRoot(outletSrcTestDir.getAbsolutePath());
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info(
					"Adding test compile source directory '"
							+ outletSrcTestOnceDir + "'");
		}
		project.addTestCompileSourceRoot(outletSrcTestOnceDir.getAbsolutePath());
	}

	/**
	 * Extends {@link MavenProject}s <code>Resources</code> and
	 * <code>TestResources</code> (depending on <code>isTest</code>) with the
	 * directories holding the generated resource artifacts.
	 * <p>
	 * There's no problem in adding the same directory multiple times.
	 * 
	 * @param resourceDir
	 *            resource directory to be added
	 * @param isTest
	 *            if <code>true</code> then then given directory is added to the
	 *            test resources otherwise it's added to the source resources
	 */
	private void extendResources(File resourceDir, boolean isTest) {
		@SuppressWarnings("unchecked")
		List<Resource> resources = (isTest ? project.getTestResources()
				: project.getResources());

		// Check if resource directory is already added
		for (Resource resource : resources) {
			if (resource.getDirectory().equalsIgnoreCase(
					resourceDir.getAbsolutePath())) {
				return;
			}
		}

		// Add new resource to list of resources
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info("Adding resource directory '" + resourceDir + "'");
		}
		Resource resource = new Resource();
		resource.setDirectory(resourceDir.getAbsolutePath());
		resources.add(resource);
	}

	/**
	 * Returns a list with file names from the <code>checkFileSets</code>
	 * parameter that have been modified since previous generator run. Empty if
	 * no files changed or <code>null</code> if there is no status file to
	 * compare against, i.e. always run the generator.
	 */
	protected Set<String> getChangedFiles() {

		// If there is no status file to compare against then always run the
		// generator
		if (!statusFile.exists()) {
			return null;
		}
		final long statusFileLastModified = statusFile.lastModified();
		final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info(
					"Last code generator execution: "
							+ df.format(new Date(statusFileLastModified)));
		}

		// Create list of files to check - start with project pom.xml and
		// generator config files
		List<File> filesToCheck = new ArrayList<File>();
		filesToCheck.add(new File(project.getBasedir(), "pom.xml"));

		// Now add generator config files
		FileSet generatorFileSet = new FileSet();
		generatorFileSet.setDirectory(project.getBasedir()
				+ "/src/main/resources/generator");
		generatorFileSet.addInclude("*");
		filesToCheck.addAll(toFileList(generatorFileSet));

		// Finally add files from configured filesets in 'checkFileSets'
		for (FileSet fs : checkFileSets) {
			filesToCheck.addAll(toFileList(fs));
		}

		// Check files for modification
		Set<String> changedFiles = new HashSet<String>();
		for (File checkFile : filesToCheck) {
			if (!checkFile.isAbsolute()) {
				checkFile = new File(project.getBasedir(), checkFile.getPath());
			}
			final boolean isModified = checkFile.lastModified() > statusFileLastModified;
			if (isModified) {
				changedFiles.add(checkFile.getAbsolutePath());
			}
			if (isVerbose() || getLog().isDebugEnabled()) {
				getLog().info(
						"File '" + checkFile.getAbsolutePath() + "': "
								+ (isModified ? "outdated" : "up-to-date")
								+ " (" + " "
								+ df.format(new Date(checkFile.lastModified()))
								+ ")");
			}
		}

		// Print info of result
		if (changedFiles.size() == 1) {
			String fileName = changedFiles.iterator().next();
			if (fileName.startsWith(project.getBasedir().getAbsolutePath())) {
				fileName = fileName.substring(project.getBasedir()
						.getAbsolutePath().length() + 1);
			}
			final String message = MessageFormat.format(
					"\"{0}\" has been modified since last generator "
							+ "run at {1}", fileName,
					df.format(new Date(statusFileLastModified)));
			getLog().info(message);
		} else if (changedFiles.size() > 1) {
			final String message = MessageFormat.format(
					"{0} checked resources have been modified since "
							+ "last generator run at {1}", changedFiles.size(),
					df.format(new Date(statusFileLastModified)));
			getLog().info(message);
		} else {
			getLog().info(
					"Everything is up to date - no generator run is needed");
		}
		return changedFiles;
	}

	/**
	 * Executes the commandline running the Eclipse MWE2 launcher and returns
	 * the commandlines exit value.
	 * 
	 * @param changedFiles
	 *            list of files from <code>checkFileSets</code> which are
	 *            modified since last generator execution or <code>null</code>
	 *            if code generation is enforced
	 */
	protected List<File> executeGenerator(Set<String> changedFiles)
			throws MojoExecutionException {
		List<File> createdFiles = null;

		// Build executor for projects base directory
		ScanningMavenLogOutputStream stdout = getStdoutStream();
		ScanningMavenLogOutputStream stderr = getStderrStream();
		Executor exec = getExecutor();
		exec.setWorkingDirectory(project.getBasedir());
		exec.setStreamHandler(new PumpStreamHandler(stdout, stderr, System.in));

		// Execute commandline and check return code
		try {
			int exitValue = exec.execute(getGeneratorCommandLine(changedFiles));

			// Check exit value and output streams for errors
			if (exitValue == 0 && stdout.getErrorCount() == 0
					&& stderr.getLineCount() == 0) {

				// Return list of created files
				createdFiles = stdout.getCreatedFiles();
			}
		} catch (ExecuteException e) {
			// ignore
		} catch (IOException e) {
			// ignore
		}
		return createdFiles;
	}

	/**
	 * Returns {@link ScanningMavenLogOutputStream} implementation for stdout.
	 * <p>
	 * Can be overriden to replace the default implementation of
	 * <code>ScanningMavenLogOutputStream(getLog())</code>.
	 */
	protected ScanningMavenLogOutputStream getStdoutStream() {
		return new ScanningMavenLogOutputStream(getLog());
	}

	/**
	 * Returns {@link ScanningMavenLogOutputStream} implementation for stderr.
	 * <p>
	 * Can be overriden to replace the default implementation of
	 * <code>ScanningMavenLogOutputStream(getLog(), true)</code>.
	 */
	protected ScanningMavenLogOutputStream getStderrStream() {
		return new ScanningMavenLogOutputStream(getLog(), true);
	}

	/**
	 * Returns {@link Executor} implementation.
	 * <p>
	 * Can be overriden to replace the default implementation of
	 * {@link DefaultExecutor}.
	 */
	protected Executor getExecutor() {
		return new DefaultExecutor();
	}

	/**
	 * Builds command line for starting the Eclipse MWE2 launcher in a JVM.
	 * 
	 * @param changedFiles
	 *            list of files from <code>checkFileSets</code> which are
	 *            modified since last generator execution or <code>null</code>
	 *            if code generation is enforced
	 */
	protected CommandLine getGeneratorCommandLine(Set<String> changedFiles)
			throws MojoExecutionException {
		CommandLine cl = new CommandLine(getJavaExecutable());
		cl.addArguments(jvmArguments);
		if (changedFiles != null) {
			cl.addArgument("-D" + CHANGED_FILES_PROPERTY + "="
					+ toCommaSeparatedString(changedFiles));
		}
		cl.addArgument("-D"
				+ GeneratorMojo.LOGBACK_CONFIGURATION_FILE_PROPERTY
				+ "="
				+ this.getClass()
						.getResource(
								"/"
										+ (isVerbose() ? LOGBACK_VERBOSE_CONFIGURATION_FILE_NAME
												: LOGBACK_NORMAL_CONFIGURATION_FILE_NAME)));
		cl.addArguments("-classpath " + getGeneratorClasspath());
		cl.addArgument(MWE2_WORKFLOW_LAUNCHER);
		cl.addArgument(workflowDescriptor);
		if (isVerbose() || getLog().isDebugEnabled()) {
			getLog().info("Commandline: " + cl);
		}
		return cl;
	}

	/**
	 * Returns path to the 'java' executable via Mavens toolchain API.
	 */
	private String getJavaExecutable() throws MojoExecutionException {
		Toolchain tc = toolchainManager.getToolchainFromBuildContext("jdk",
				session);
		if (tc != null) {
			if (isVerbose() || getLog().isDebugEnabled()) {
				getLog().info("Toolchain: " + tc);
			}
			String javaExecutable = tc.findTool("java");
			if (javaExecutable != null) {
				return javaExecutable;
			} else {
				throw new MojoExecutionException(
						"Unable to find 'java' executable for toolchain: " + tc);
			}
		}
		return "java";
	}

	/**
	 * Returns the generators classpath by adding the artifacts from the plugins
	 * dependencies. The dependencies used by the plugin itself (the Maven
	 * stuff) are skipped.
	 */
	@SuppressWarnings("rawtypes")
	protected String getGeneratorClasspath() {
		StringBuilder classpath = new StringBuilder();

		// First add the maven projects resource folder to the classpath
		List resources = project.getResources();
		for (Iterator iterator = resources.iterator(); iterator.hasNext();) {
			Resource resource = (Resource) iterator.next();
			if (isVerbose() || getLog().isDebugEnabled()) {
				getLog().info(
						"Adding resource to classpath: "
								+ resource.getDirectory());
			}
			if (classpath.length() > 0) {
				classpath.append(File.pathSeparatorChar);
			}
			classpath.append(resource.getDirectory());
		}

		// Now add plugin dependencies to the classpath
		for (Artifact artifact : pluginDependencies) {
			String groupId = artifact.getGroupId();

			// Skip all dependencies only used by Maven
			if (!groupId.startsWith("org.apache.maven")
					&& !groupId.startsWith("org.codehaus.plexus")
					&& !groupId.startsWith("junit")) {
				if (isVerbose() || getLog().isDebugEnabled()) {
					getLog().info("Adding dependency to classpath: " + artifact);
				}
				if (classpath.length() > 0) {
					classpath.append(File.pathSeparatorChar);
				}
				classpath.append(artifact.getFile());
			}
		}
		return classpath.toString();
	}

	@SuppressWarnings("unchecked")
	private List<File> toFileList(FileSet fileSet) {
		File directory = new File(fileSet.getDirectory());
		String includes = toCommaSeparatedString(fileSet.getIncludes());
		String excludes = toCommaSeparatedString(fileSet.getExcludes());
		try {
			return FileUtils.getFiles(directory, includes, excludes);
		} catch (IllegalStateException e) {
			getLog().warn(e.getMessage() + ". Ignoring fileset.");
		} catch (IOException e) {
			getLog().warn(e);
		}
		return Collections.emptyList();
	}

	private String toCommaSeparatedString(Collection<String> strings) {
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(string);
		}
		return sb.toString();
	}
}
