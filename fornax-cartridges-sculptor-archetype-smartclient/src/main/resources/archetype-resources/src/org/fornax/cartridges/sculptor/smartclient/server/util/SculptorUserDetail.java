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

import java.util.Set;

import org.fornax.cartridges.sculptor.smartclient.domain.Roles;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

public class SculptorUserDetail implements UserDetails {
	private static final long serialVersionUID = 1L;

	String username;
	String password;
	boolean enabled;
	boolean expired;
	GrantedAuthority[] grantedAuthority;
	String lang;

	SculptorUserDetail(String username, String password, Set<Roles> roles, boolean enabled, boolean expired, String lang) {
		this.username=username;
		this.password=password;
		this.enabled=enabled;
		this.expired=expired;
		this.lang=lang;

		if (roles != null) {
			grantedAuthority=new GrantedAuthority[roles.size()];
			int i=0;
			for (Roles role : roles) {
				grantedAuthority[i++]=new SculptorAuthority(role.getRoleName());
			}
		} else {
			grantedAuthority=null;
		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public GrantedAuthority[] getAuthorities() {
		return grantedAuthority;
	}

	public String getLang() {
		return lang;
	}

	public boolean isAccountNonExpired() {
		return ! expired;
	}

	public boolean isCredentialsNonExpired() {
		return ! expired;
	}

	public boolean isAccountNonLocked() {
		return enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public String toString() {
		return username;
	}
}

class SculptorAuthority implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	String authority;

	SculptorAuthority(String authority) {
		this.authority=authority;
	}

	public String getAuthority() {
		return authority;
	}

	public int compareTo(Object compareTo) {
		if (compareTo == null || ! (compareTo instanceof String)) {
			return -1;
		}

		return ((String) compareTo).compareTo(authority);
	}
}