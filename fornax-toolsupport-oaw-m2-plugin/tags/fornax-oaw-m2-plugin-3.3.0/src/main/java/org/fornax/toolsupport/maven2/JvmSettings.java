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
import java.util.Properties;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Karsten Thoms
 * @since 3.2.0
 */
public class JvmSettings {
	private boolean fork;
	private boolean copySysProperties;
	private boolean copyEnvProperties;
	private List<String> jvmArgs = new ArrayList<String>();
	private Properties sysProperties = new Properties();
	private Properties envProperties = new Properties();

	public void setFork(boolean fork) {
		this.fork = fork;
	}

	public boolean isFork() {
		return fork;
	}

	public void setCopySysProperties(boolean copySysProperties) {
		this.copySysProperties = copySysProperties;
	}

	public boolean isCopySysProperties() {
		return copySysProperties;
	}

	public void setCopyEnvProperties(boolean copyEnvProperties) {
		this.copyEnvProperties = copyEnvProperties;
	}

	public boolean isCopyEnvProperties() {
		return copyEnvProperties;
	}

	public void setJvmArgs(List<String> jvmArgs) {
		this.jvmArgs = jvmArgs;
	}

	public List<String> getJvmArgs() {
		return jvmArgs;
	}

	public void setSysProperties(Properties sysProperties) {
		this.sysProperties = sysProperties;
	}

	public Properties getSysProperties() {
		if (fork==true && copySysProperties) {
			Properties props = new Properties(sysProperties);
			props.putAll(System.getProperties());
			return props;
		} else {
			return sysProperties;
		}
	}

	public void setEnvProperties(Properties envProperties) {
		this.envProperties = envProperties;
	}

	public Properties getEnvProperties() {
		if (fork==true && copyEnvProperties) {
			Properties props = new Properties(envProperties);
			props.putAll(System.getenv());
			return props;
		} else {
			return envProperties;
		}
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this)
			.append("fork",fork);
		if (fork) {
			builder.append("jvmArgs", jvmArgs);
			builder.append("copySysProperties",copySysProperties);
			builder.append("copyEnvProperties",copyEnvProperties);
		}
		builder.append("sysProperties", getSysProperties());
		builder.append("envProperties", getEnvProperties());
		return builder.toString();
	}

}
