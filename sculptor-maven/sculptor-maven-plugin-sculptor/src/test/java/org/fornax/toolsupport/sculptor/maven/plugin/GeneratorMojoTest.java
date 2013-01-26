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

import static org.mockito.Matchers.anySet;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import junit.framework.AssertionFailedError;

import org.apache.commons.exec.CommandLine;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.testing.ArtifactStubFactory;
import org.apache.maven.project.MavenProject;

public class GeneratorMojoTest extends
		AbstractSculptorMojoTestCase<GeneratorMojo> {

	private static final String ONE_SHOT_GENERATED_FILE = "src/main/java/com/acme/test/domain/Foo.java";
	private static final String GENERATED_FILE = "src/generated/java/com/acme/test/domain/Bar.java";

	public void testGeneratorClasspath() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test1"));

		String classpath = mojo.getGeneratorClasspath();
		assertNotNull(classpath);
		String[] splittedClasspath = classpath.split(File.pathSeparator);
		assertEquals(3, splittedClasspath.length);
		assertTrue(splittedClasspath[0].endsWith("resources"));
		assertEquals("generator", splittedClasspath[1]);
		assertEquals("dep3", splittedClasspath[2]);
	}

	public void testChangedFilesNoStatusFile() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test1"));

		Set<String> changedFiles = mojo.getChangedFiles();
		assertNull(changedFiles);
	}

	public void testChangedFilesNoUpdatedFiles() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test2"));
		mojo.getStatusFile().setLastModified(System.currentTimeMillis() + 1000);

		Set<String> changedFiles = mojo.getChangedFiles();
		assertNotNull(changedFiles);
		assertEquals(0, changedFiles.size());
	}

	public void testChangedFilesOutdatedStatusFile() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test2"));
		mojo.getStatusFile().setLastModified(0);

		Set<String> changedFiles = mojo.getChangedFiles();
		assertNotNull(changedFiles);
		assertEquals(7, changedFiles.size());
	}

	public void testChangedFilesUpdatedWorkflowDescriptor() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test2"));
		mojo.getStatusFile().setLastModified(System.currentTimeMillis() + 1000);
		mojo.getWorkflowDescriptorFile().setLastModified(
				System.currentTimeMillis() + 2000);

		Set<String> changedFiles = mojo.getChangedFiles();
		assertNotNull(changedFiles);
		assertEquals(1, changedFiles.size());
	}

	public void testChangedFilesUpdatedGeneratorConfigFiles() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test2"));
		mojo.getStatusFile().setLastModified(System.currentTimeMillis() + 1000);
		new File(mojo.getProject().getBasedir(),
				"/src/main/resources/generator/SpecialCases.ext")
				.setLastModified(System.currentTimeMillis() + 2000);
		new File(mojo.getProject().getBasedir(),
				"/src/main/resources/generator/SpecialCases.xpt")
				.setLastModified(System.currentTimeMillis() + 2000);

		Set<String> changedFiles = mojo.getChangedFiles();
		assertNotNull(changedFiles);
		assertEquals(2, changedFiles.size());
	}

	public void testGeneratorCommandLineNoChangedFiles() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test1"));

		CommandLine commandline = mojo.getGeneratorCommandLine(null);
		assertNotNull(commandline);
		String[] arguments = commandline.getArguments();
		assertEquals(8, arguments.length);
		assertEquals("-client", arguments[0]);
		assertEquals("-Xms100m", arguments[1]);
		assertEquals("-Xmx500m", arguments[2]);
		assertTrue(arguments[3].startsWith("-D"
				+ GeneratorMojo.LOGBACK_CONFIGURATION_FILE_PROPERTY + "="));
		assertTrue(arguments[3]
				.endsWith(GeneratorMojo.LOGBACK_NORMAL_CONFIGURATION_FILE_NAME));
		assertEquals("-classpath", arguments[4]);
		assertEquals(mojo.getGeneratorClasspath(), arguments[5]);
		assertEquals(GeneratorMojo.MWE2_WORKFLOW_LAUNCHER, arguments[6]);
		assertEquals(mojo.getWorkflowDescriptor(), arguments[7]);
	}

	public void testGeneratorCommandLineWithChangedFiles() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test1"));
		Set<String> changedFiles = new HashSet<String>();
		changedFiles.add("file1");
		changedFiles.add("file2");
		changedFiles.add("file3");

		CommandLine commandline = mojo.getGeneratorCommandLine(changedFiles);
		assertNotNull(commandline);
		String[] arguments = commandline.getArguments();
		assertEquals(9, arguments.length);
		assertEquals("-client", arguments[0]);
		assertEquals("-Xms100m", arguments[1]);
		assertEquals("-Xmx500m", arguments[2]);
		assertTrue(arguments[3].startsWith("-D"
				+ GeneratorMojo.CHANGED_FILES_PROPERTY + "="));
		assertTrue(arguments[3].contains("file1"));
		assertTrue(arguments[3].contains("file2"));
		assertTrue(arguments[3].contains("file3"));
		assertTrue(arguments[4].startsWith("-D"
				+ GeneratorMojo.LOGBACK_CONFIGURATION_FILE_PROPERTY + "="));
		assertTrue(arguments[4]
				.endsWith(GeneratorMojo.LOGBACK_NORMAL_CONFIGURATION_FILE_NAME));
		assertEquals("-classpath", arguments[5]);
		assertEquals(mojo.getGeneratorClasspath(), arguments[6]);
		assertEquals(GeneratorMojo.MWE2_WORKFLOW_LAUNCHER, arguments[7]);
		assertEquals(mojo.getWorkflowDescriptor(), arguments[8]);
	}

	public void testUpdateStatusFile() throws Exception {
		GeneratorMojo mojo = createMojo(createProject("test2"));

		List<File> files = new ArrayList<File>();
		files.add(new File(mojo.getProject().getBasedir(),
				ONE_SHOT_GENERATED_FILE));
		files.add(new File(mojo.getProject().getBasedir(), GENERATED_FILE));
		assertTrue(mojo.updateStatusFile(files));

		Properties statusFileProps = new Properties();
		statusFileProps.load(new FileReader(mojo.getStatusFile()));

		assertEquals(2, statusFileProps.size());
		assertEquals("e747f800870423a6c554ae2ec80aeeb6",
				statusFileProps.getProperty(ONE_SHOT_GENERATED_FILE));
		assertEquals("7d436134142a2e69dfc98eb9f22f5907",
				statusFileProps.getProperty(GENERATED_FILE));
	}

	@SuppressWarnings("unchecked")
	public void testExecuteSkip() throws Exception {
		GeneratorMojo mojo = spy(createMojo(createProject("test1")));
		doThrow(AssertionFailedError.class).when(mojo).executeGenerator(
				anySet());
		setVariableValueToObject(mojo, "skip", true);

		mojo.execute();
	}

	@SuppressWarnings("unchecked")
	public void testExecuteForce() throws Exception {
		GeneratorMojo mojo = spy(createMojo(createProject("test2")));
		doReturn(null).when(mojo).executeGenerator(anySet());

		setVariableValueToObject(mojo, "force", true);
		try {
			mojo.execute();
		} catch (MojoExecutionException e) {
			return;
		}
		fail();
	}

	@SuppressWarnings("unchecked")
	public void testExecuteWithClean() throws Exception {
		GeneratorMojo mojo = spy(createMojo(createProject("test2")));
		doReturn(null).when(mojo).executeGenerator(anySet());
		mojo.getStatusFile().setLastModified(System.currentTimeMillis() + 1000);
		mojo.getWorkflowDescriptorFile().setLastModified(
				System.currentTimeMillis() + 2000);

		setVariableValueToObject(mojo, "clean", true);
		try {
			mojo.execute();
		} catch (MojoExecutionException e) {
			assertFalse(new File(mojo.getProject().getBasedir(),
					ONE_SHOT_GENERATED_FILE).exists());
			assertFalse(new File(mojo.getProject().getBasedir(), GENERATED_FILE)
					.exists());
			return;
		}
		fail();
	}

	@SuppressWarnings("unchecked")
	public void testExecuteWithoutClean() throws Exception {
		GeneratorMojo mojo = spy(createMojo(createProject("test2")));
		doReturn(null).when(mojo).executeGenerator(anySet());
		mojo.getStatusFile().setLastModified(System.currentTimeMillis() + 1000);
		mojo.getWorkflowDescriptorFile().setLastModified(
				System.currentTimeMillis() + 2000);

		setVariableValueToObject(mojo, "clean", false);
		try {
			mojo.execute();
		} catch (MojoExecutionException e) {
			assertTrue(new File(mojo.getProject().getBasedir(),
					ONE_SHOT_GENERATED_FILE).exists());
			assertTrue(new File(mojo.getProject().getBasedir(), GENERATED_FILE)
					.exists());
			return;
		}
		fail();
	}

	/**
	 * Returns Mojo instance initialized with a {@link MavenProject} created
	 * from the test projects in <code>"src/test/projects/"</code> by given
	 * project name.
	 */
	protected GeneratorMojo createMojo(MavenProject project) throws Exception {

		// Create spied mojo
		GeneratorMojo mojo = super.createMojo(project, "generate");

		// Set default values on mojo
		setVariableValueToObject(mojo, "workflowDescriptor",
				"src/main/resources/generator/Workflow.mwe2");

		// Add plugin dependencies
		List<Artifact> dependencies = new ArrayList<Artifact>();
		ArtifactStubFactory factory = new ArtifactStubFactory();
		dependencies.add(factory.createArtifact("org.apache.maven",
				"maven-project", "1.0.0"));
		dependencies.add(factory.createArtifact("org.codehaus.plexus",
				"plexus-utils", "1.0.0"));
		dependencies.add(factory.createArtifact("junit", "junit", "1.0.0"));
		Artifact artifact = factory.createArtifact("org.fornax.cartridges",
				"fornax-cartridges-sculptor-generator", "2.0.0");
		artifact.setFile(new File("generator"));
		dependencies.add(artifact);
		artifact = factory.createArtifact("dep3", "dep3", "1.0.0");
		artifact.setFile(new File("dep3"));
		dependencies.add(artifact);
		setVariableValueToObject(mojo, "pluginDependencies", dependencies);

		setVariableValueToObject(mojo, "clean", true);

		// Set defaults for multi-value parameters in mojo
		mojo.initMojoMultiValueParameters();
		return mojo;
	}

}