package org.fornax.cartridges.sculptor.generator.templates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import org.fornax.cartridges.sculptor.generator.transformation.TransformationTestBase;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Base class for unit tests that need to verify generated text.
 *
 */
public class TemplateTestBase extends TransformationTestBase {

	/**
	 * This is the directory where xpand output will be generated to
	 */
	private static File XPAND_OUTPUT_TEMP_DIR = new File("target/temp-xpandoutput");

	@BeforeClass
	public static void setupTempDir() {
		XPAND_OUTPUT_TEMP_DIR.mkdirs();
	}

	protected static File getXpandTempDir() {
		return XPAND_OUTPUT_TEMP_DIR;
	}

	protected static String getFileText(String filePath) throws IOException {
		File f = new File(XPAND_OUTPUT_TEMP_DIR, filePath);
		return getFileText(f);
	}

	protected void assertContains(String text, String subString) {
		Assert.assertTrue("text does not contain expected substring: "
				+ subString, text.contains(subString));
	}

	/**
	 * Assert that the given text contains the regular expression, using multiline matching
	 */
	protected void assertMatchesRegexp(String text, String regexp) {
		Pattern p = Pattern.compile(regexp, Pattern.MULTILINE);
		Assert.assertTrue("Text did not contain pattern \"" + regexp + "\"", p
				.matcher(text).find());
	}
	
	/**
	 * Assert that the given text contains the given text fragments, separated by whitespace (including newline).
	 */
	protected void assertContainsConsecutiveFragments(String text, String[] fragments) {
		StringBuilder sb = new StringBuilder();
		
		for (String fragment : fragments) {
			sb.append("\\Q" + fragment + "\\E\\s*");
		}
		assertMatchesRegexp(text, sb.toString());
	}

	protected void assertNotContains(String text, String subStr) {
		Assert.assertFalse("Text contained substring \"" + subStr + "\"",
				text.contains(subStr));
	}

	protected static String getFileText(File textFile) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new FileReader(textFile));
		String str;
		while ((str = in.readLine()) != null) {
			sb.append(str);
		}
		in.close();
		return sb.toString();
	}
}
