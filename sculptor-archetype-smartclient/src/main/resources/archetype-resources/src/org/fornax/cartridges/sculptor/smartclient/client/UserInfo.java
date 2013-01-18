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
package org.fornax.cartridges.sculptor.smartclient.client;

import java.util.ArrayList;

/**
 * Client side user informations.
 * 
 * @author Ing. Pavel Tavoda
 */
class UserInfo {
	private String username=null;
	private ArrayList<String> userroles=new ArrayList<String>();

	public UserInfo(String serverResult) {
		String[] split = serverResult.split("[ ,;:]");
		if (split.length > 0) {
			boolean first=true;
			for (int i = 0; i < split.length; i++) {
				if (split[i] != null && split[i].length() > 0) {
					if (first) {
						first=false;
						username=split[i];
					} else {
						userroles.add(split[i]);
					}
				}
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public boolean isUserInRole(String role) {
		for (String userrole : userroles) {
			if (userrole.equalsIgnoreCase(role)) {
				return true;
			}
		}

		return false;
	}
}
