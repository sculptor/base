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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.logging.Log;

/**
 * {@link MavenLogOutputStream} which scans the lines befor logging: The prefix
 * with the SLF4J log level is removed. For the log level <code>ERROR</code> the
 * line is logged as an error.
 * <p>
 * The lines from logger of class
 * <code>org.eclipse.xpand2.output.FileHandleImpl</code> are checked for files
 * created or skipped by the Xpand code generator. The list of these
 * {@link File}s can be retrieved by via the corresponding getters.
 * 
 * @author Torsten Juergeleit
 */
public class ScanningMavenLogOutputStream extends MavenLogOutputStream {

	protected static final String LINE_PREFIX_DEBUG = "[DEBUG] ";
	protected static final String LINE_PREFIX_INFO = "[INFO] ";
	protected static final String LINE_PREFIX_WARN = "[WARN] ";
	protected static final String LINE_PREFIX_ERROR = "[ERROR] ";
	protected static final String LINE_PREFIX_FILE_CREATED = "[FILE] Opening file : ";
	protected static final String LINE_PREFIX_FILE_SKIPPED = "[FILE] Skipping file : ";

	private List<File> createdFiles = new ArrayList<File>();
	private List<File> skippedFiles = new ArrayList<File>();

	/**
	 * Creates a new output stream for stdout.
	 * 
	 * @param log
	 *            plugins {@link Log}
	 */
	public ScanningMavenLogOutputStream(Log log) {
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
	public ScanningMavenLogOutputStream(Log log, boolean isErrorStream) {
		super(log, isErrorStream);
	}

	public List<File> getCreatedFiles() {
		return createdFiles;
	}

	public List<File> getSkippedFiles() {
		return skippedFiles;
	}

	/**
	 * Before logging the SLF4J log level is removed from the line. For the log
	 * level <code>ERROR</code> the line is logged as an error.
	 */
	@Override
	protected void logInfo(String line) {
		if (line.startsWith(LINE_PREFIX_DEBUG)) {
			super.logInfo(line.substring(LINE_PREFIX_DEBUG.length()));
		} else if (line.startsWith(LINE_PREFIX_INFO)) {
			super.logInfo(line.substring(LINE_PREFIX_INFO.length()));
		} else if (line.startsWith(LINE_PREFIX_WARN)) {
			super.logInfo(line.substring(LINE_PREFIX_WARN.length()));
		} else if (line.startsWith(LINE_PREFIX_ERROR)) {
			super.logError(line.substring(LINE_PREFIX_ERROR.length()));
		} else if (line.startsWith(LINE_PREFIX_FILE_CREATED)) {
			createdFiles.add(new File(line.substring(LINE_PREFIX_FILE_CREATED
					.length())));
		} else if (line.startsWith(LINE_PREFIX_FILE_SKIPPED)) {
			skippedFiles.add(new File(line.substring(LINE_PREFIX_FILE_SKIPPED
					.length())));
		} else {
			super.logInfo(line);
		}
	}

}
