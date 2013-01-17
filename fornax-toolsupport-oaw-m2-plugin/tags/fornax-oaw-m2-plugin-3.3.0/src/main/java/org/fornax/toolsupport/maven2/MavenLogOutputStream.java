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

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.logging.Log;
import org.apache.tools.ant.util.LineOrientedOutputStream;

/**
 * 
 * @author Karsten Thoms
 * @since 3.1.0
 */
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
