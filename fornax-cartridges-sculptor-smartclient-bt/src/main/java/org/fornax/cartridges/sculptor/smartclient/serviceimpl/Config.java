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
package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

import java.util.Properties;

/**
 * Server side configuration
 * 
 * @author Ing. Pavel Tavoda
 */
public class Config {
	private static Properties props;

	public void setProperties(Properties props) {
		Config.props=props;
	}

	public static boolean isDevelopmentMode() {
		String dev=props.getProperty("developmentMode", "prod");
		return dev.equals("true");
	}

	public static boolean isProductionMode() {
		return !isDevelopmentMode();
	}

	public static String getEnvironment() {
		return props.getProperty("environment", "");
	}
}
