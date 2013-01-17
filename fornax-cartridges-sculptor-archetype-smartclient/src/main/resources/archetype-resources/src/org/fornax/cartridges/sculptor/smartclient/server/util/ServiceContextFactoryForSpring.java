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

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextFactory;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;

/**
 * Bridge class for creating Fornax compatible service context from Spring security context
 * 
 * @author Ing. Pavel Tavoda
 */
public class ServiceContextFactoryForSpring extends ServiceContextFactory {

	@Override
	protected Subject activeSubject() {
		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
			return new Subject();
		} else {
			return null;
		}
	}

	@Override
	protected Set<String> rolesFromSubject(Subject subject) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		HashSet<String> roles=new HashSet<String>();
		GrantedAuthority[] authorities = auth.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			roles.add(grantedAuthority.getAuthority());
		}
		return roles;
	}

	@Override
	protected String userIdFromSubject(Subject subject) {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	protected ServiceContext createServiceContextImpl(HttpServletRequest request) {
		ServiceContext contextImpl = super.createServiceContextImpl(request);
		try {
			Object userDetail=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (userDetail instanceof SculptorUserDetail) {
				contextImpl.setProperty("lang", ((SculptorUserDetail) userDetail).getLang());
			}
		} catch (NullPointerException npe) {
			// do nothing, it's not our provider
		}

		return contextImpl;
	}
}
