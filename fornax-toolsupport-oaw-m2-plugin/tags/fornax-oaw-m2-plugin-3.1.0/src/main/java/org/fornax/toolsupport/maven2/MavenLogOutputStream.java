package org.fornax.toolsupport.maven2;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.logging.Log;
import org.apache.tools.ant.util.LineOrientedOutputStream;

public class MavenLogOutputStream extends LineOrientedOutputStream {
	private static final Pattern LOGPATTERN = Pattern.compile(".*\\[main\\] (\\w+) (.*)");
	private Log log;
	private String lastLevel;
	
	public MavenLogOutputStream (Log log) {
		this.log = log;
		this.lastLevel = "INFO";
	}
	
	@Override
	protected void processLine(String line) throws IOException {
		Matcher m = LOGPATTERN.matcher(line);
		String level = null;
		String message = null;
		if (m.matches()) {
			level = m.group(1);
			message = m.group(2);
		} else {
			level = lastLevel; // to get stack traces after ERROR
			message = line;
		}
		if ("DEBUG".equals(level)) {
			log.debug(message);
		} else if ("INFO".equals(level)) {
			log.info(message);
		} else if ("WARN".equals(level)) {
			log.warn(message);
		} else if ("ERROR".equals(level)) {
			log.error(message);
		} else {
			log.info(message);
		}
		lastLevel = level;
	}

}
