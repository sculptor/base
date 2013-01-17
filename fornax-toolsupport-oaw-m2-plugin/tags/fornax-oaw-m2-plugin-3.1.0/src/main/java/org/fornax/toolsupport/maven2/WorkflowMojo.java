/*
 *	Copyright 2006-2010 The Fornax Project Team
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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.FileSet;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Java;
import org.apache.tools.ant.taskdefs.Redirector;
import org.apache.tools.ant.types.Path;
import org.codehaus.classworlds.ClassRealm;
import org.codehaus.classworlds.ClassWorld;
import org.codehaus.classworlds.DuplicateRealmException;
import org.codehaus.plexus.util.FileUtils;

/**
 * This is the plugin to the openArchitectureWare/Eclipse MWE Workflow-component. This plugin can used to generate artifacts out
 * of models (e.g. UML, EMF).
 * <p>
 * You can configure resources that should be checked if they are up to date to avoid needless generator runs and optimize build
 * execution time.
 * 
 * @phase generate-sources
 * @goal run-workflow
 * @execute goal="run-workflow"
 * @requiresDependencyResolution test
 * @description Executes the Workflow-Engine from the openArchitectureWare Generator-Framework
 * @author Thorsten Kamann <thorsten.kamann@googlemail.com>
 * @author Karsten Thoms <karsten.thoms@itemis.de>
 */
public class WorkflowMojo extends AbstractMojo {
	private static final String MOJO_VERSION = "3.1.0";
	public static final String WFENGINE_OAW = "oaw";
	public static final String WFENGINE_MWE = "mwe";
	public static final String WFENGINE_MWE2 = "mwe2";
	// Standard classes for invocation
	public static final String OAW_WORKFLOWRUNNER = "org.openarchitectureware.workflow.WorkflowRunner";
	public static final String OAW_PROGRESSMONITOR = "org.openarchitectureware.workflow.monitor.NullProgressMonitor";
	public static final String MWE_WORKFLOWRUNNER = "org.eclipse.emf.mwe.core.WorkflowRunner";
	public static final String MWE_PROGRESSMONITOR = "org.eclipse.emf.mwe.core.monitor.NullProgressMonitor";
	public static final String MWE2_WORKFLOWRUNNER = "org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher";

	/**
	 * The project itself. This parameter is set by maven.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	private MavenProject project;

	/**
	 * @parameter default-value="${project.artifacts}"
	 * @required
	 * @readonly
	 */
	private Set<Artifact> dependencies;

	/**
	 * The name of the workflow descriptor.
	 * <p>
	 * <i>Only supported for workflow engine 'oaw' and 'mwe'</i>
	 * 
	 * @parameter default-value="workflow.mwe2"
	 * @required
	 */
	private String workflowDescriptor;

	/**
	 * Directory for source-code artifacts. If an artifact with the same name already exists, the generation of the artifact will
	 * be skipped.
	 * 
	 * @parameter expression="${project.build.sourceDirectory}"
	 * @required
	 */
	private String outletSrcOnceDir;

	/**
	 * Directory for non-source-code artifacts. If an artifact with the same name already exists, the generation of the artifact
	 * will be skipped.
	 * 
	 * @parameter default-value="src/main/resources"
	 * @required
	 */
	private String outletResOnceDir;

	/**
	 * Directory for source-code artifacts. Existings artifacts will be overwritten.
	 * 
	 * @parameter default-value="src/generated/java"
	 * @required
	 */
	private String outletSrcDir;

	/**
	 * Directory for non-source-code artifacts. Existings artifacts will be overwritten.
	 * 
	 * @parameter default-value="src/generated/resources"
	 * @required
	 */
	private String outletResDir;

	/**
	 * Directory for source-code test-artifacts. Existings artifacts will be overwritten.
	 * 
	 * @parameter default-value="src/test/generated/java"
	 * @required
	 */
	private String outletSrcTestDir;

	/**
	 * Directory for non-source-code test-artifacts. Existings artifacts will be overwritten.
	 * 
	 * @parameter default-value="src/test/generated/resources"
	 * @required
	 */
	private String outletResTestDir;

	/**
	 * Directory for source-code artifacts. If an artifact with the same name already exists, the generation of the artifact will
	 * be skipped.
	 * 
	 * @parameter expression="${project.build.testSourceDirectory}"
	 * @required
	 */
	private String outletSrcTestOnceDir;

	/**
	 * Directory for source-code test-artifacts. Existings artifacts will not be overwritten.
	 * 
	 * @parameter default-value="src/testgenerated/java"
	 * @required
	 */
	private String outletResTestOnceDir;

	/**
	 * Directory for source-code artifacts with Protected Regions.
	 * 
	 * @parameter default-value="src/protected/java"
	 * @required
	 */
	private String outletSrcProtectedDir;

	/**
	 * Directory for non-source-code artifacts with Protected Regions.
	 * 
	 * @parameter default-value="src/protected/resources"
	 * @required
	 */
	private String outletResProtectedDir;

	/**
	 * Directory for source-code test-artifacts with Protected Regions.
	 * 
	 * @parameter default-value="src/test/protected/java"
	 * @required
	 */
	private String outletSrcTestProtectedDir;

	/**
	 * Directory for non-source-code test-artifacts with Protected Regions.
	 * 
	 * @parameter default-value="src/test/protected/resources"
	 * @required
	 */
	private String outletResTestProtectedDir;

	/**
	 * A <code>java.util.List</code> with resources that will be checked on up to date. If all resources are uptodate the plugin
	 * stopps the execution, because there are nothing newer to regenerate. <br/>
	 * The entries of this list can be relative path to the project root or absolute path.
	 * 
	 * @parameter
	 */
	private List<String> checkResources;
	/**
	 * A <code>java.util.List</code> with resources that will be checked on up to date. If all resources are up to date the plugin
	 * stops the execution, because there are no files to regenerate. <br/>
	 * The entries of this list can be relative path to the project root or absolute path.
	 * 
	 * @parameter
	 */
	private FileSet[] checkFilesets;

	/**
	 * @parameter default-value="oaw-generation-lastrun.timestamp"
	 * @required
	 */
	private String timestampFileName;

	/**
	 * Defines the directory containing the runtime configurations, resources (eg. the models, log-configurations,
	 * properties,...). This directory will be added to the classpath temporarily, but removed after the generation.
	 * 
	 * @parameter default-value="oaw-generator"
	 * @required
	 */
	private String defaultOawResourceDir;

	/**
	 * The Workflow Engine type to execute.
	 * <ul>
	 * <li><tt>oaw</tt>: openArchitectureWare 4.x
	 * <li><tt>mwe</tt>: Eclipse Model Workflow Engine (MWE)
	 * <li><tt>mwe2</tt>: Eclipse Model Workflow Engine 2 (MWE2)
	 * </ul>
	 * 
	 * @parameter default-value="mwe2"
	 * @required
	 */
	private String workflowEngine;

	/**
	 * @parameter
	 */
	private String workflowRunnerClass;
	/**
	 * @parameter
	 */
	private String progressMonitorClass;

	/**
	 * The root where the <code>workflowDescriptor</code> resides.
	 */
	private File workflowDescriptorRoot;

	/**
	 * Additional Map with parameter for the generator
	 * 
	 * @parameter
	 */
	private Map<String, String> properties;

	private boolean isDefaultOawResourceDirManaged = false;

	private ClassRealm workflowRealm;
	private Java javaTask;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException {
		MojoWorkflowRunner wfr = null;
		Map<String, String> params = new HashMap<String, String>();

		getLog().info("Fornax oAW/MWE/MWE2 Maven2 Plugin V" + MOJO_VERSION);

		// Check workflowEngine parameter
		if (!WFENGINE_OAW.equals(workflowEngine) && !WFENGINE_MWE.equals(workflowEngine) && !WFENGINE_MWE2.equals(workflowEngine)) {
			throw new IllegalArgumentException("Illegal value specified for parameter workflowEngine");
		}

		wfr = new MojoWorkflowRunner();
		wfr.setLog(getLog());

		if ("true".equals(System.getProperty("fornax.generator.omit.execution"))) {
			getLog().info("Omitting workflow execution.");
			return;
		}

		if ("true".equalsIgnoreCase(System.getProperty("fornax.generator.force.execution"))) {
			getLog().info("Forced workflow execution");
			File timeStampFile = getTimeStampFile();
			if (timeStampFile != null) {
				timeStampFile.delete();
			}
		}

		if (!isUpToDate()) {
			extendCurrentClassloader(wfr);
			initJavaTask(wfr);

			params.put("basedir", project.getBasedir().getPath());
			params.put("outlet.src.dir", getNormalizedFilePath(outletSrcDir));
			params.put("outlet.res.dir", getNormalizedFilePath(outletResDir));
			params.put("outlet.src.once.dir", getNormalizedFilePath(outletSrcOnceDir));
			params.put("outlet.res.once.dir", getNormalizedFilePath(outletResOnceDir));
			params.put("outlet.src.test.dir", getNormalizedFilePath(outletSrcTestDir));
			params.put("outlet.res.test.dir", getNormalizedFilePath(outletResTestDir));
			params.put("outlet.src.test.once.dir", getNormalizedFilePath(outletSrcTestOnceDir));
			params.put("outlet.res.test.once.dir", getNormalizedFilePath(outletResTestOnceDir));
			params.put("outlet.src.protected.dir", getNormalizedFilePath(outletSrcProtectedDir));
			params.put("outlet.res.protected.dir", getNormalizedFilePath(outletResTestProtectedDir));
			params.put("outlet.src.test.protected.dir", getNormalizedFilePath(outletSrcProtectedDir));
			params.put("outlet.res.test.protected.dir", getNormalizedFilePath(outletResTestProtectedDir));
			if (properties != null && properties.size() > 0) {
				params.putAll(properties);
			}

			String prevUserDir = System.getProperty("user.dir");
			System.setProperty("user.dir", project.getBasedir().getPath());

			// Initialize MojoWorkflowRunner
			if (progressMonitorClass != null) {
				wfr.setProgressMonitorClass(progressMonitorClass);
			} else if (WFENGINE_OAW.equals(workflowEngine)) {
				wfr.setProgressMonitorClass(OAW_PROGRESSMONITOR);
			} else if (WFENGINE_MWE.equals(workflowEngine)) {
				wfr.setProgressMonitorClass(MWE_PROGRESSMONITOR);
			} else if (WFENGINE_MWE2.equals(workflowEngine)) {
				// do nothing
			}

			if (workflowRunnerClass != null) {
				wfr.setWorkflowRunnerClass(workflowRunnerClass);
			} else if (WFENGINE_OAW.equals(workflowEngine)) {
				wfr.setWorkflowRunnerClass(OAW_WORKFLOWRUNNER);
			} else if (WFENGINE_MWE.equals(workflowEngine)) {
				wfr.setWorkflowRunnerClass(MWE_WORKFLOWRUNNER);
			} else if (WFENGINE_MWE2.equals(workflowEngine)) {
				wfr.setWorkflowRunnerClass(MWE2_WORKFLOWRUNNER);
			}

			// Set properties depending on workflow engine
			if (WFENGINE_OAW.equals(workflowEngine) || WFENGINE_MWE.equals(workflowEngine)) {
				// Prove for default workflowDescriptor. If workflowEngine is
				// set to "mwe"
				// replace default value by "workflow.mwe"
				if ("workflow.oaw".equals(workflowDescriptor) && "mwe".equals(workflowEngine)) {
					workflowDescriptor = "workflow.mwe";
				}

				if (getWorkflowDescriptorRoot() == null) {
					throw new MojoExecutionException("Could not find the Workflow-Descriptor \"" + workflowDescriptor + "\".");
				}

				wfr.setWorkflowDescriptor(workflowDescriptor);
				wfr.setParams(params);
			} else if (WFENGINE_MWE2.equals(workflowEngine)) {
				if ("workflow.oaw".equals(workflowDescriptor)) {
					workflowDescriptor = "workflow.mwe2";
				}
				wfr.setWorkflowDescriptor(workflowDescriptor);
			}

			boolean success = wfr.run();
			if (success) {
				getLog().info("Workflow '" + workflowDescriptor + "' finished.");
			} else {
				System.setProperty("user.dir", prevUserDir);
				throw new MojoExecutionException("Generation failed");
			}
			System.setProperty("user.dir", prevUserDir);

			try {
				createTimeStampFile();
			} catch (IOException ie) {
				throw new MojoExecutionException("Could not create the timestamp file.", ie);
			}
		}

		if (project != null) {
			try {
				extendCompileSourceRoot();
				extendResources(outletResDir, false);
				extendResources(outletResOnceDir, false);
				extendResources(outletResTestDir, true);
				extendResources(outletResTestOnceDir, true);
				extendResources(outletResProtectedDir, false);
				extendResources(outletResTestProtectedDir, true);
			} catch (Exception ex) {
				throw new MojoExecutionException("Could not extend the project's compile path.", ex);
			}
		}

		if (!isDefaultOawResourceDirManaged) {
			for (int i = 0; i < project.getBuild().getResources().size(); i++) {
				Resource resource = (Resource) project.getBuild().getResources().get(i);
				if (resource.getDirectory().equalsIgnoreCase(defaultOawResourceDir)) {
					project.getBuild().removeResource(resource);
				}
			}
		}

	}

	/**
	 * Indicates whether all resources are uptodate
	 * 
	 * @return <code>true</code> if all resources are uptodate otherwise <code>false</code>
	 */
	private boolean isUpToDate() {
		final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-hh:mm:ss");
		File basedir = project.getBasedir();
		File timeStampFile = getTimeStampFile();

		// If there is no timestamp file to compare against then always run the
		// generator
		if (timeStampFile == null) {
			return false;
		}

		List<FileSet> checkSets = new ArrayList<FileSet>();
		// Add FileSet for the Workflow descriptor and project's pom.xml
		FileSet defaultCheckSet = new FileSet();
		defaultCheckSet.setDirectory(project.getBasedir().getAbsolutePath());
		defaultCheckSet.addInclude("pom.xml");
		defaultCheckSet.addInclude(workflowDescriptor);
		checkSets.add(defaultCheckSet);

		// Add a check fileset with all resources configured by 'checkResources'
		if (checkResources != null) {
			FileSet fs = new FileSet();
			fs.setDirectory(basedir.getAbsolutePath());
			for (String res : checkResources) {
				fs.addInclude(res);
			}
			checkSets.add(fs);
		}

		// Add all configured filesets from 'checkFilesets'
		if (checkFilesets != null) {
			checkSets.addAll(Arrays.asList(checkFilesets));
		}

		List<File> filesToCheck = new ArrayList<File>();
		for (FileSet fs : checkSets) {
			try {
				filesToCheck.addAll(toFileList(fs));
			} catch (IOException e) {
				getLog().warn(e);
			}
		}

		if (getLog().isDebugEnabled()) {
			getLog().debug("Generator timestamp: " + df.format(new Date(timeStampFile.lastModified())));
		}
		int outdatedFiles = 0;
		File lastOutdatedResource = null;
		for (File checkResource : filesToCheck) {
			if (getLog().isDebugEnabled())
				getLog().debug(checkResource.getAbsolutePath());
			if (!checkResource.isAbsolute()) {
				checkResource = new File(basedir, checkResource.getPath());
			}

			if (getLog().isDebugEnabled()) {
				String status = (checkResource.lastModified() <= timeStampFile.lastModified()) ? "UPTODATE" : "OUTDATED ";
				getLog().debug(status + " " + df.format(new Date(checkResource.lastModified())));
			}

			if (checkResource.lastModified() > timeStampFile.lastModified()) {
				outdatedFiles++;
				lastOutdatedResource = checkResource;
			}
		}
		if (getLog().isInfoEnabled()) {
			if (outdatedFiles == 1) {
				String fileName = lastOutdatedResource.getAbsolutePath();
				if (fileName.startsWith(project.getBasedir().getAbsolutePath())) {
					fileName = fileName.substring(project.getBasedir().getAbsolutePath().length() + 1);
				}
				final String message = MessageFormat.format("{0} has been modified since last generator run at {1}.", fileName,
						df.format(new Date(timeStampFile.lastModified())));
				getLog().info(message);
			} else if (outdatedFiles > 1) {
				final String message = MessageFormat.format(
						"{0} checked resources have been modified since last generator run at {1}.", outdatedFiles, df
								.format(new Date(timeStampFile.lastModified())));
				getLog().info(message);
			} else {
				this.getLog().info("Everything is up to date. No generation is needed.");
			}
		}

		return outdatedFiles == 0;
	}

	/**
	 * Extends the current classloader with all resource path and the given additional ClassLoaderURLs.
	 * 
	 * @param wfr
	 *            The current classloader to extend
	 */
	private void extendCurrentClassloader(MojoWorkflowRunner wfr) {
		final List<?> resources = project.getBuild().getResources();
		// http://blogs.webtide.com/janb/entry/extending_the_maven_plugin_classpath
		// create a new classloading space
		// MWE requires Tycho 0.9.0, due to this bug:
		// https://issues.sonatype.org/browse/TYCHO-291
		ClassWorld world = new ClassWorld();
		try {
			// use the existing ContextClassLoader in a realm of the
			// classloading space
			ClassRealm containerRealm = world.newRealm("plugin.fornax.oaw.container", Thread.currentThread()
					.getContextClassLoader());
			// create another realm for just the jars we have downloaded
			// on-the-fly and make
			// sure it is in a child-parent relationship with the current
			// ContextClassLoader
			workflowRealm = containerRealm.createChildRealm("plugin.fornax.oaw.workflow");
			// add all the jars we just downloaded to the new child realm
		} catch (DuplicateRealmException e) {
			throw new RuntimeException(e);
		}

		if (resources != null) {
			for (int i = 0; i < resources.size(); i++) {
				Resource resource = (Resource) resources.get(i);
				File directory = resolvePath(new File(resource.getDirectory()));
				workflowRealm.addConstituent(toURL(directory, true));
				if (getLog().isDebugEnabled()) {
					getLog().debug("Added resource to classpath: " + toURL(directory, true));
				}
			}
		}

		String path = "";
		for (Artifact artifact : dependencies) {
			if ("".equals(path)) {
				path += artifact.getFile().getAbsolutePath();
			} else {
				path += System.getProperty("path.separator") + artifact.getFile().getAbsolutePath();
			}
			try {
				// only add archives, for non-archives an exception is thrown
				new ZipFile(artifact.getFile());
				workflowRealm.addConstituent(artifact.getFile().toURL());
				if (getLog().isDebugEnabled()) {
					getLog().debug("Added dependency to classpath: " + artifact.getFile().toURL());
				}
			} catch (ZipException e) {
			} catch (IOException e) {
			}
		}
		// make the child realm the ContextClassLoader
		Thread.currentThread().setContextClassLoader(workflowRealm.getClassLoader());
	}

	private void initJavaTask(MojoWorkflowRunner wfr) {
		Project antProject = new Project();
		antProject.setBaseDir(project.getBasedir());
		javaTask = new Java();
		javaTask.setProject(antProject);

		String classpath = "";
		for (URL url : workflowRealm.getConstituents()) {
			if ("".equals(classpath)) {
				classpath += url.getFile();
			} else {
				classpath += System.getProperty("path.separator") + url.getFile();
			}
		}
		javaTask.setClasspath(new Path(antProject, classpath));
		javaTask.setFork(true);
		javaTask.setFailonerror(true);
		javaTask.setInputString("y\n");

		Target target = new Target();
		antProject.addTarget("default", target);
		target.addTask(javaTask);
		final MavenLogOutputStream os = new MavenLogOutputStream(getLog());
		Redirector redirector = new Redirector(javaTask) {
			@Override
			public OutputStream getOutputStream() {
				return os;
			}
			@Override
			public OutputStream getErrorStream() {
				return os;
			}
		};
		try {
			Field redirectorField = Java.class.getDeclaredField("redirector");
			redirectorField.setAccessible(true);
			redirectorField.set(javaTask, redirector);
			redirectorField.setAccessible(false);
		} catch (Exception e) { // SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
			throw new RuntimeException(e);
		}
		wfr.setJavaTask(javaTask);
	}

	/**
	 * Converts the given path to an url
	 * 
	 * @param path
	 *            The path to convert
	 * @return The converted <code>java.net.URL</code>
	 */
	private URL toURL(File path, boolean trailingSlash) {
		URL url = null;
		try {
			url = new URL(path.toURI().toString() + ((trailingSlash) ? "/" : ""));
		} catch (Exception e) {
			getLog().error("Could not resolve \"" + path.getPath() + "\".", e);
		}
		return url;
	}

	/**
	 * Resolve the given path. That means that the given path is converted to an absolute path
	 * 
	 * @param path
	 *            The path to resolve
	 * @return The resolved path as <code>java.io.File</code>
	 */
	private File resolvePath(File path) {
		if (!path.isAbsolute()) {
			path = new File(project.getBasedir(), path.getPath());
		}
		if (path.isDirectory()) {
			String name = path.getName();
			if (!name.endsWith(File.separator)) {
				path = new File(path.getPath() + File.separator);
			}
		}
		return path;
	}

	/**
	 * Extends the Maven CompileSourceRoot. This must be done because the generated resources must be in the compile srcpath.
	 */
	private void extendCompileSourceRoot() throws Exception {
		if (!project.getBuild().getSourceDirectory().equalsIgnoreCase(outletSrcDir)) {
			getLog().debug("Adding compile source directory " + getNormalizedFilePath(outletSrcDir));
			project.addCompileSourceRoot(getNormalizedFilePath(outletSrcDir));
		}

		if (!project.getBuild().getSourceDirectory().equalsIgnoreCase(outletSrcProtectedDir)) {
			getLog().debug("Adding compile source directory " + getNormalizedFilePath(outletSrcProtectedDir));
			project.addCompileSourceRoot(getNormalizedFilePath(outletSrcProtectedDir));
		}

		if (!project.getBuild().getSourceDirectory().equalsIgnoreCase(outletSrcOnceDir)
				&& !outletSrcDir.equalsIgnoreCase(outletSrcOnceDir)) {
			project.addCompileSourceRoot(getNormalizedFilePath(outletSrcOnceDir));
		}

		if (!project.getBuild().getTestSourceDirectory().equalsIgnoreCase(outletSrcTestDir)) {
			getLog().debug("Adding compile source directory " + getNormalizedFilePath(outletSrcTestDir));
			project.addTestCompileSourceRoot(getNormalizedFilePath(outletSrcTestDir));
		}

		if (!project.getBuild().getTestSourceDirectory().equalsIgnoreCase(outletSrcOnceDir)
				&& !outletSrcTestDir.equalsIgnoreCase(outletSrcTestOnceDir)) {
			project.addTestCompileSourceRoot(getNormalizedFilePath(outletSrcTestOnceDir));
		}

		if (!project.getBuild().getTestSourceDirectory().equalsIgnoreCase(outletSrcTestProtectedDir)
				&& !outletSrcTestDir.equalsIgnoreCase(outletSrcTestProtectedDir)
				&& outletSrcTestOnceDir.equalsIgnoreCase(outletSrcTestProtectedDir)) {
			project.addTestCompileSourceRoot(getNormalizedFilePath(outletSrcTestProtectedDir));
		}
	}

	/**
	 * Extends the configured resources with the given resource
	 * 
	 * @param res
	 *            The res to extend the current resources with
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void extendResources(String res, boolean forTest) throws Exception {
		List<Resource> resources = (forTest) ? project.getTestResources() : project.getResources();
		File fileRes = null;

		if (!new File(res).isAbsolute()) {
			fileRes = new File(project.getBasedir(), res);
		}

		if (!fileRes.exists()) {
			return;
		}

		for (Resource resource : resources) {
			if (resource.getDirectory().equalsIgnoreCase(res)) {
				return;
			}
		}

		getLog().info("Adding " + fileRes.getPath() + " to the list of current resources.");
		Resource resource = new Resource();
		resource.setDirectory(fileRes.getPath());
		resources.add(resource);
	}

	/**
	 * Creates the TimeStampFile. This is used to check the state of the resources
	 * 
	 * @throws IOException
	 */
	private void createTimeStampFile() throws IOException {
		File timeStampFile = null;

		timeStampFile = new File(project.getBuild().getDirectory(), timestampFileName);
		timeStampFile.getParentFile().mkdirs();
		if (timeStampFile.exists()) {
			timeStampFile.delete();
		}
		timeStampFile.createNewFile();
	}

	/**
	 * Returns the TimeStampFile or <code>null</code> if none exists.
	 */
	private File getTimeStampFile() {
		File timeStampFile = new File(project.getBuild().getDirectory(), timestampFileName);

		if (timeStampFile.exists()) {
			return timeStampFile;
		}
		return null;
	}

	/**
	 * @return The root where the <code>workflowDescriptor</code> resides
	 */
	private File getWorkflowDescriptorRoot() {

		for (int i = 0; i < project.getBuild().getResources().size(); i++) {
			Resource resource = (Resource) project.getBuild().getResources().get(i);
			if (resource.getDirectory().equalsIgnoreCase(defaultOawResourceDir)) {
				isDefaultOawResourceDirManaged = true;
			}
		}

		if (!isDefaultOawResourceDirManaged) {
			Resource oawDefaultResource = new Resource();
			oawDefaultResource.setDirectory(defaultOawResourceDir);
			project.getBuild().addResource(oawDefaultResource);
		}

		if (workflowDescriptorRoot == null) {
			List<?> resources = project.getBuild().getResources();
			for (int i = 0; i < resources.size(); i++) {
				Resource resource = (Resource) resources.get(i);
				File directory = new File(resource.getDirectory());
				if (directory.exists()) {
					File workflowScript = new File(directory, workflowDescriptor);
					if (workflowScript.exists()) {
						workflowDescriptorRoot = directory;
						break;
					}
				}
			}
		}
		return workflowDescriptorRoot;
	}

	/**
	 * @param path
	 *            The path to normalize
	 * @return The normalized path
	 */
	private String getNormalizedFilePath(String path) {
		if (new File(path).isAbsolute()) {
			return path;
		}

		return new File(project.getBasedir(), path).getPath();
	}

	@SuppressWarnings("unchecked")
	private List<File> toFileList(FileSet fileSet) throws IOException {
		File directory = new File(fileSet.getDirectory());
		String includes = toString(fileSet.getIncludes());
		String excludes = toString(fileSet.getExcludes());
		try {
			return FileUtils.getFiles(directory, includes, excludes);
		} catch (IllegalStateException e) {
			getLog().warn(e.getMessage() + ". Ignoring fileset.");
			return Collections.emptyList();
		}
	}

	private static String toString(List<String> strings) {
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			if (sb.length() > 0)
				sb.append(", ");
			sb.append(string);
		}
		return sb.toString();
	}
}
