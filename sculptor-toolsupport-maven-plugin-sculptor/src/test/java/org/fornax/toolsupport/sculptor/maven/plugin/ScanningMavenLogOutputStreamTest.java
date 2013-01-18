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
import java.util.List;

import org.apache.maven.plugin.testing.SilentLog;

import junit.framework.TestCase;

public class ScanningMavenLogOutputStreamTest extends TestCase {

	public void testErrorCount() {
		ScanningMavenLogOutputStream outputStream = new ScanningMavenLogOutputStream(
				new SilentLog());
		outputStream.processLine(
				ScanningMavenLogOutputStream.LINE_PREFIX_DEBUG, 0);
		outputStream.processLine(
				ScanningMavenLogOutputStream.LINE_PREFIX_ERROR, 0);
		outputStream.processLine(ScanningMavenLogOutputStream.LINE_PREFIX_WARN,
				0);
		assertEquals(3, outputStream.getLineCount());
		assertEquals(1, outputStream.getErrorCount());
	}

	public void testCreatedFiles() {
		ScanningMavenLogOutputStream outputStream = new ScanningMavenLogOutputStream(
				new SilentLog());
		outputStream
				.processLine(
						ScanningMavenLogOutputStream.LINE_PREFIX_FILE_CREATED
								+ "File1", 0);
		outputStream
				.processLine(
						ScanningMavenLogOutputStream.LINE_PREFIX_FILE_CREATED
								+ "File2", 0);
		outputStream
				.processLine(
						ScanningMavenLogOutputStream.LINE_PREFIX_FILE_CREATED
								+ "File3", 0);
		assertEquals(3, outputStream.getLineCount());
		List<File> createdFiles = outputStream.getCreatedFiles();
		assertNotNull(createdFiles);
		assertEquals(3, createdFiles.size());
		for (int i = 0; i < createdFiles.size(); i++) {
			assertEquals("File" + (i + 1), createdFiles.get(i).getName());

		}
	}

	public void testSkippedFiles() {
		ScanningMavenLogOutputStream outputStream = new ScanningMavenLogOutputStream(
				new SilentLog());
		outputStream
				.processLine(
						ScanningMavenLogOutputStream.LINE_PREFIX_FILE_SKIPPED
								+ "File1", 0);
		outputStream
				.processLine(
						ScanningMavenLogOutputStream.LINE_PREFIX_FILE_SKIPPED
								+ "File2", 0);
		outputStream
				.processLine(
						ScanningMavenLogOutputStream.LINE_PREFIX_FILE_SKIPPED
								+ "File3", 0);
		assertEquals(3, outputStream.getLineCount());
		List<File> skippedFiles = outputStream.getSkippedFiles();
		assertNotNull(skippedFiles);
		assertEquals(3, skippedFiles.size());
		for (int i = 0; i < skippedFiles.size(); i++) {
			assertEquals("File" + (i + 1), skippedFiles.get(i).getName());

		}
	}

}
