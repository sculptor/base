/*
 * Copyright 2008 The Fornax Project Team, including the original 
 * author or authors.
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
package org.fornax.cartridges.sculptor.framework.web.hibernate;

import java.util.Map;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.hibernate.Session;

/**
 * Makes sure that the current Hibernate session is disconnected when the 
 * request is completed.
 * This faces listener is the JSF version of DisconnectHibernateInterceptor.
 * @see org.fornax.cartridges.sculptor.framework.web.hibernate.DisconnectHibernateInterceptor
 */
public class DisconnectHibernatePhaseListener implements PhaseListener {
	private static final String HIBERNATE_SESSION_ATTRIBUTE = "hibernateSession";
    
	public void afterPhase(PhaseEvent event) {
		Map<String,Object> requestMap = event.getFacesContext().getExternalContext().getRequestMap();
		if (requestMap.containsKey(HIBERNATE_SESSION_ATTRIBUTE)) {
			Session hibernateSession = (Session) requestMap.get(HIBERNATE_SESSION_ATTRIBUTE);
	        if (hibernateSession != null) {
	        	requestMap.remove(HIBERNATE_SESSION_ATTRIBUTE);
	            if (hibernateSession.isConnected()) {
	                hibernateSession.disconnect();
	            }
	        }
		}
	}
	
	public void beforePhase(PhaseEvent event) {
		// do nothing
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
}
