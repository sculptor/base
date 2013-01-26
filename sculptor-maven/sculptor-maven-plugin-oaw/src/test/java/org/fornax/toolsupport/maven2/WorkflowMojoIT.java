package org.fornax.toolsupport.maven2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.it.Verifier;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class WorkflowMojoIT extends AbstractMojoTestCase {

	private static final String GROUP_ID = "org.sculptor";
	private static final String ARTIFACT_ID = "sculptor-maven-plugin-oaw";
	private static final String GOAL = "run-workflow";

	public void testOawWorkflow() throws Exception {

		File testDir = getTestFile("src/test/projects/oaw-workflow");

		Verifier verifier = new Verifier(testDir.getAbsolutePath());
		verifier.deleteDirectory("src/main/java");

		// turns on debugging
		List<String> cliOptions = new ArrayList<String>();
		cliOptions.add("-X");
		verifier.setCliOptions(cliOptions);
		verifier.executeGoal(GROUP_ID + ":" + ARTIFACT_ID + ":" + GOAL);

		// writes streams to src/test/projects/oaw-workflow/log.txt
		verifier.displayStreamBuffers();

		verifier.verifyErrorFreeLog();
		verifier.resetStreams();

		verifier.assertFilePresent(new File(testDir,
				"src/main/java/org/test/CustomerImpl.java").getAbsolutePath());
		verifier.assertFilePresent(new File(testDir,
				"target/generated-sources/fornax-workflow/org/test/Customer.java")
				.getAbsolutePath());
		verifier.assertFilePresent(new File(testDir,
				"target/generated-sources/fornax-workflow/org/test/AbstractCustomer.java")
				.getAbsolutePath());

	}
}
