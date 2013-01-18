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

import org.apache.commons.exec.LogOutputStream;
import org.apache.maven.plugin.logging.Log;

/**
 * {@link LogOutputStream} which redirects the output or error stream to the
 * plugins Maven {@link Log} and increases the correspondig counters (
 * <code>lineCount</code> and <code>errorCount</code>).
 * 
 * @author Torsten Juergeleit
 */
public class MavenLogOutputStream extends LogOutputStream {

	private Log log;
	private boolean isErrorStream;
	private int lineCount = 0;
	private int errorCount = 0;

	/**
	 * Creates a new output stream for stdout.
	 * 
	 * @param log
	 *            plugins {@link Log}
	 */
	public MavenLogOutputStream(Log log) {
		this(log, false);
	}

	/**
	 * Creates a new output stream for stdout or stderr.
	 * 
	 * @param log
	 *            plugins {@link Log}
	 * @param isErrorStream
	 *            if <code>true</code> then every line sen to this output stream
	 *            increases the error count
	 */
	public MavenLogOutputStream(Log log, boolean isErrorStream) {
		this.log = log;
		this.isErrorStream = isErrorStream;
	}

	public final int getLineCount() {
		return lineCount;
	}

	public final int getErrorCount() {
		return errorCount;
	}

	/**
	 * Depending on stream type the given line is logged and the correspondig
	 * counter is increased.
	 */
	@Override
	protected final void processLine(String line, int level) {
		if (!isErrorStream) {
			logInfo(line);
		} else {
			logError(line);
		}
		lineCount++;
	}

	protected void logInfo(String line) {
		log.info(line);
	}

	protected void logError(String line) {
		log.error(line);
		errorCount++;
	}

}
