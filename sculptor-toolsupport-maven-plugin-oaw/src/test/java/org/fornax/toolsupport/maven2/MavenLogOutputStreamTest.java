package org.fornax.toolsupport.maven2;

import org.apache.maven.plugin.logging.Log;
import static org.mockito.Mockito.*;
import static org.fornax.toolsupport.maven2.LogDetectionPattern.*;
import junit.framework.TestCase;

public class MavenLogOutputStreamTest extends TestCase {
	Log log;
	MavenLogOutputStream os;
	
	@Override
	protected void setUp() throws Exception {
		log = mock (Log.class);
		os = new MavenLogOutputStream(log);
	}

	public void testSimpleLogging () {
		// without detection patterns everything is logged to info level
		os.processLine("foo bar");
		verify(log).info("foo bar");
	}
	
	public void testDebugLogNoRegexpNoMultiline () {
		LogDetectionPattern ldp = new LogDetectionPattern(DEBUG, "[DEBUG]", false, false);
		os.setLogDetectionPatterns(new LogDetectionPattern[]{ldp});

		// no debug out
		os.processLine("foo bar");
		verify(log).info("foo bar");
		
		// detect DEBUG output
		os.processLine("** [DEBUG] foo bar");
		verify(log).debug("** [DEBUG] foo bar");

		// next line is default level again, since multiline is false
		os.processLine("foo bar");
		verify(log, times(2)).info("foo bar");
	}

	public void testDebugLogNoRegexpWithMultiline () {
		LogDetectionPattern ldp = new LogDetectionPattern(DEBUG, "[DEBUG]", false, true);
		os.setLogDetectionPatterns(new LogDetectionPattern[]{ldp});

		// no debug out
		os.processLine("foo bar");
		verify(log).info("foo bar");
		
		// detect DEBUG output
		os.processLine("** [DEBUG] foo bar");
		verify(log).debug("** [DEBUG] foo bar");

		// next line is DEBUG level again, since multiline is true
		os.processLine("foo bar");
		verify(log).debug("foo bar");
	}

	public void testDebugLogWithRegexpNoMultiline () {
		LogDetectionPattern ldp = new LogDetectionPattern(DEBUG, "\\[D..UG\\]", true, false);
		os.setLogDetectionPatterns(new LogDetectionPattern[]{ldp});

		// no debug out
		os.processLine("foo bar");
		verify(log).info("foo bar");
		
		// detect DEBUG output
		os.processLine("** [DEBUG] foo bar");
		verify(log).debug("** [DEBUG] foo bar");

		// next line is default level again, since multiline is false
		os.processLine("foo bar");
		verify(log, times(2)).info("foo bar");
	}

	/** Using a regular expression that matches the output after the debug statement */
	public void testDebugLogWithRegexpExtractionNoMultiline () {
		LogDetectionPattern ldp = new LogDetectionPattern(DEBUG, "\\[DEBUG\\]\\s*(.*)", true, false);
		os.setLogDetectionPatterns(new LogDetectionPattern[]{ldp});

		// no debug out
		os.processLine("foo bar");
		verify(log).info("foo bar");
		
		// detect DEBUG output
		os.processLine("** [DEBUG] foo bar");
		// this time the PREFIX is stripped off
		verify(log).debug("foo bar");

		// next line is default level again, since multiline is false
		os.processLine("foo bar");
		verify(log, times(2)).info("foo bar");
	}


	public void testDetectError () {
		LogDetectionPattern ldp = new LogDetectionPattern(ERROR, "\\[ERROR\\]\\s*(.*)", true, false);
		LogDetectionPattern ldp2 = new LogDetectionPattern(ERROR, "^\\s+at .*", true, false);
		os.setLogDetectionPatterns(new LogDetectionPattern[]{ldp,ldp2});

		// no debug out
		os.processLine("foo bar");
		verify(log).info("foo bar");
		
		// detect DEBUG output
		os.processLine("** [ERROR] foo bar");
		// this time the PREFIX is stripped off
		verify(log).error("foo bar");

		// detect STACKTRACE
		os.processLine(" at my.class");
		// this time the PREFIX is stripped off
		verify(log).error(" at my.class");

		// next line is default level again, since multiline is false
		os.processLine("foo bar");
		verify(log, times(2)).info("foo bar");
		assertTrue(os.hasErrors());

	}
}
