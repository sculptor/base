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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.maven.plugin.logging.Log;
import org.apache.tools.ant.util.LineOrientedOutputStream;

/**
 * 
 * @author Karsten Thoms
 * @since 3.1.0
 */
public class MavenLogOutputStream extends LineOrientedOutputStream {
	private Log log;
	private int lastLevel;
	private boolean hasErrors;
	private List<List<LogDetectionPattern>> logDetectionPatterns;
	
	public MavenLogOutputStream (Log log) {
		this.log = log;
		this.lastLevel = LogDetectionPattern.INFO;
		// Initialize the list of lists. The outer list has an element for each level,
		// the inner list will take the LogDetectionPatterns for that level
		logDetectionPatterns = new ArrayList<List<LogDetectionPattern>>(4);
		for (int i=0; i<4; i++) {
			logDetectionPatterns.add(new ArrayList<LogDetectionPattern>(1));
		}
	}
	
	public void setLogDetectionPatterns(
			LogDetectionPattern[] ldps) {
		for (LogDetectionPattern ldp: ldps) {
			getLogDetectionPatterns(ldp.getLevel()).add(ldp);
		}
	}
	
	@Override
	protected void processLine(String line) {
		boolean matched = false;
		int level = lastLevel;
		boolean multiline = true;
		String message = line;
		for (int i=LogDetectionPattern.ERROR; !matched && i>=0; i--) {
			for (LogDetectionPattern ldp: getLogDetectionPatterns(i)) {
				if (ldp.isRegexp()) {
					Matcher m = ldp.getDetectionPattern().matcher(line);
					if (m.find()) {
						level = ldp.getLevel();
						// remember the level
						lastLevel = level;
						if (m.groupCount()>0) {
							message = m.group(1);
						}
						matched = true;
						multiline = ldp.isMultiline();
						break;
					}
				} else {
					if (line.contains(ldp.getDetectionString())) {
						level = ldp.getLevel();
						// remember the level
						lastLevel = level;
						matched = true;
						multiline = ldp.isMultiline();
						break;
					}
				}
			}
		}
		switch (level) {
			case LogDetectionPattern.DEBUG: log.debug(message); break;
			case LogDetectionPattern.INFO: log.info(message); break;
			case LogDetectionPattern.WARNING: log.warn(message); break;
			case LogDetectionPattern.ERROR: log.error(message); hasErrors = true; break;
			default: log.info(message); break;
		}
		if (!multiline) {
			// reset last level
			lastLevel = LogDetectionPattern.INFO;
		}
	}
	
	public boolean hasErrors () {
		return hasErrors;
	}
	
	protected List<LogDetectionPattern> getLogDetectionPatterns (Integer level) {
		return logDetectionPatterns.get(level);
	}

}
