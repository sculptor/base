package org.fornax.toolsupport.maven2;

import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 
 * @author Karsten Thoms
 * @since 3.4.0
 */
public class LogDetectionPattern {
	public static final int DEBUG = 0;
	public static final String DEBUG_S = "DEBUG";
	public static final int INFO = 1;
	public static final String INFO_S = "INFO";
	public static final int WARNING = 2;
	public static final String WARNING_S = "WARNING";
	public static final int ERROR = 3;
	public static final String ERROR_S = "ERROR";
	/**
	 * Log Level
	 */
	private int level = DEBUG;
	/**
	 * String to search to detect the log level and message.
	 */
	private String detectionString;
	private Pattern detectionPattern;
	
	/**
	 * <code>true</code> if the detection pattern is a regular expression.
	 */
	private boolean regexp;
	/**
	 * set to <code>true</code> when the last detected log level should be kept until another level was detected.
	 */
	private boolean multiline;
	
	public LogDetectionPattern () {}
	public LogDetectionPattern (int level, String detectionString, boolean regexp, boolean multiline) {
		setLevel(level);
		setDetectionString(detectionString);
		setRegexp(regexp);
		this.multiline = multiline;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level < DEBUG || level >ERROR)
			throw new IllegalArgumentException("Invalid log level "+level);
		this.level = level;
	}
	
	public String getLevelAsString () {
		switch (level) {
		case DEBUG : return DEBUG_S;
		case INFO : return INFO_S;
		case WARNING : return WARNING_S;
		case ERROR : return ERROR_S;
		default: throw new IllegalStateException();
		}
	}
	
	public void setLevelAsString (String level) {
		if (ERROR_S.equals(level)) {
			this.level = ERROR;
		} else if (WARNING_S.equals(level)) {
			this.level = WARNING;
		} else if (INFO_S.equals(level)) {
			this.level = INFO;
		} else if (DEBUG_S.equals(level)) {
			this.level = DEBUG;
		} else {
			throw new IllegalArgumentException(level);
		}
	}

	public String getDetectionString() {
		if (detectionString == null) {
			throw new IllegalStateException("Property 'detectionString' was not initialized.");
		}
		return detectionString;
	}
	
	public Pattern getDetectionPattern() {
		return detectionPattern;
	}

	public void setDetectionString(String detectionString) {
		this.detectionString = detectionString;
		if (detectionString != null && isRegexp()) {
			detectionPattern = Pattern.compile(detectionString);
		} else {
			detectionPattern = null;
		}
	}

	public boolean isRegexp() {
		return regexp;
	}

	public void setRegexp(boolean regexp) {
		this.regexp = regexp;
		if (regexp && detectionString != null) {
			detectionPattern = Pattern.compile(detectionString);
		} else {
			detectionPattern = null;
		}
	}
	public boolean isMultiline() {
		return multiline;
	}
	public void setMultiline(boolean multiline) {
		this.multiline = multiline;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("level", level)
			.append("detectionString", detectionString)
			.append("regexp", regexp)
			.append("multiline",multiline)
			.toString();
	}
	
}
