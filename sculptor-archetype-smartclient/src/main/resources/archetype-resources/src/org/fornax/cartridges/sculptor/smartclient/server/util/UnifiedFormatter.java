/*
 * (C) Copyright Factory4Solutions a.s. 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.cartridges.sculptor.smartclient.server.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

/**
 * Java logging output formmater
 * 
 * @author Ing. Pavel Tavoda
 */
public class UnifiedFormatter extends Formatter {
	private static final String RST="";   // Record Start Token
	private static final String RET="\n"; // Record End Token
	private static final String FST="<";  // Field Start Token
	private static final String FET=">";  // Field End Token
	private static final String FSEP=" "; // Field SEParator
	// private static final SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yy HH:mm:ss");
	private static final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss.SSS");

	@Override
	public String format(LogRecord record) {
		String username="ANONYMOUS";
		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof User) {
				username=((User) principal).getUsername();
			} else {
				username=principal.toString();
			}
		}

		int dotIndex=record.getSourceClassName().lastIndexOf(".");
		String className=record.getSourceClassName().substring(dotIndex != -1 ? dotIndex + 1 : 0);
		String msg=record.getMessage();
		if (record.getParameters() != null && record.getParameters().length > 0) {
			msg=MessageFormat.format(record.getMessage(), record.getParameters());
		}
		if (record.getThrown() != null) {
			Throwable thrown = record.getThrown();
			StringWriter result=new StringWriter();
			thrown.printStackTrace(new PrintWriter(result));
			result.flush();
			msg+="\n"+result.getBuffer();
		}
		return FST+dateFormat.format(record.getMillis())+FET+FSEP
				+RST+FST+record.getLevel()+FET+FSEP
				+FST+className+"."+record.getSourceMethodName()+FET+FSEP
				+FST+username+FET+FSEP
				+FST+record.getThreadID()+FET+FSEP
				+FST+msg+FET+RET;
	}

	public String toString() {
		return UnifiedFormatter.class.getName();
	}
}
