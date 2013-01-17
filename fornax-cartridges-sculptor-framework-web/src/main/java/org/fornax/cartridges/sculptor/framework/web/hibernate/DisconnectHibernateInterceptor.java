/*
 * Copyright 2007 The Fornax Project Team, including the original 
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.classic.Session;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * This HandlerInterceptor makes sure that the current Hibernate session 
 * is disconnected when the request is completed. It is intended to
 * be used together with {@link OpenHibernateSessionInConversationListener}, 
 * which will manage the Hibernate session. Normally the session is
 * disconnected by that listener, but when lazy loading occurs in the
 * view rendering (jsp) the session is disconnected by this HandlerInterceptor 
 * instead.  
 */
public class DisconnectHibernateInterceptor extends HandlerInterceptorAdapter {
    
    private static final String HIBERNATE_SESSION_ATTRIBUTE = "hibernateSession";
    

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc) {
        Session hibernateSession = (Session) request.getAttribute(HIBERNATE_SESSION_ATTRIBUTE);
        if (hibernateSession != null ) {
            request.removeAttribute(HIBERNATE_SESSION_ATTRIBUTE);
            if (hibernateSession.isConnected()) {
                hibernateSession.disconnect();
            }
        }
    }
    

}
