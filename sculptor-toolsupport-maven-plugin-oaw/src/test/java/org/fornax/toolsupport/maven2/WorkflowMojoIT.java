package org.fornax.toolsupport.maven2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.it.Verifier;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class WorkflowMojoIT extends AbstractMojoTestCase {

	public void testOawWorkflow() throws Exception {

		File testDir = getTestFile("src/test/projects/oaw-workflow");

		Verifier verifier = new Verifier(testDir.getAbsolutePath());
		verifier.deleteDirectory("src/main/java");

		// turns on debugging
		List<String> cliOptions = new ArrayList<String>();
		cliOptions.add("-X");
		verifier.setCliOptions(cliOptions);
		verifier.executeGoal("org.sculptor:sculptor-toolsupport-maven-plugin-oaw:run-workflow");

		// writes streams to src/test/projects/oaw-workflow/log.txt
		verifier.displayStreamBuffers();

		verifier.verifyErrorFreeLog();
		verifier.resetStreams();

		verifier.assertFilePresent(new File(testDir, "src/main/java/org/test/CustomerImpl.java").getAbsolutePath());
		verifier.assertFilePresent(new File(testDir, "target/generated-sources/fornax-workflow/org/test/Customer.java")
				.getAbsolutePath());
		verifier.assertFilePresent(new File(testDir, "target/generated-sources/fornax-workflow/org/test/AbstractCustomer.java")
				.getAbsolutePath());

	}
}
