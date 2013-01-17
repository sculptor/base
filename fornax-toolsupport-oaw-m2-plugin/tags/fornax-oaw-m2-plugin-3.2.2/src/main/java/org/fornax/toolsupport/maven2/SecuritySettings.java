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

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author Karsten Thoms
 * @since 3.2.0
 */
public class SecuritySettings {
	/**
	 * Permissions to be granted.
	 */
	private List<Permission> grantedPermissions = new ArrayList<Permission>();
	/**
	 * Permissions to be revoked.
	 */
	private List<Permission> revokedPermissions = new ArrayList<Permission>();

	public List<Permission> getGrantedPermissions() {
		return grantedPermissions;
	}

	public void setGrantedPermissions(List<Permission> grantedPermissions) {
		this.grantedPermissions = grantedPermissions;
	}

	public List<Permission> getRevokedPermissions() {
		return revokedPermissions;
	}

	public void setRevokedPermissions(List<Permission> revokedPermissions) {
		this.revokedPermissions = revokedPermissions;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("granted", grantedPermissions)
			.append("revoked", revokedPermissions)
			.toString();
	}

}
