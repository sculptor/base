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

import org.hibernate.FlushMode;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListener;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.FlowSession;
import org.springframework.webflow.execution.RequestContext;

/**
 * A {@link FlowExecutionListener} that is used to manage an extended Hibernate
 * session to make it possible to lazy load objects in the presentation tier,
 * including the views. The hibernate session is used during the flow and
 * subflows, but it is disconnected inbetween each request. The hibernate
 * session is stored in flow scope and serialized together with form beans and
 * references to domain objects.
 * <p>
 * It is intended to be used with transactional services that perform write
 * operations. The hibernate session is created with FlushMode.MANUAL and it is
 * intended that the updating services will perform the flush. Note that
 * read-only services should not flush.
 * <p>
 * The general pattern is as follows:
 * <ul>
 * <li>When a persistent root flow execution starts, create a new Hibernate
 * Session and bind it to flow scope.
 * <li>Before processing a flow execution request, expose the flow-bound session
 * as the "current session" for the current thread.
 * <li>When an existing flow pauses, or a subflow ends, unbind the session from
 * the current thread.
 * <li>When an existing persistent root flow ends unbind and close the Hibernate
 * session.
 * </ul>
 * <p>
 * The Hibernate SessionFactory should be defined with the following properties:
 *
 * <pre>
 * hibernate.current_session_context_class = org.hibernate.context.ManagedSessionContext
 * hibernate.transaction.auto_close_session = false
 * </pre>
 *
 * <p>
 * The flow must have an attribute named persistenceContext to make this
 * listener active. The attribute can have value "supports" to specify that
 * nested subflows will use the same Hibernate session. It can have value
 * "requiresNew" to specify that a new Hibernate session is to be created.
 * <p>
 * The Hibernate session is disconnected by this class, but when lazy loading
 * occurs in the view rendering (jsp) the session must be disconnected by
 * {@link DisconnectHibernateInterceptor}.
 * <p>
 * Note: All data access will, by default, be non-transactional. However, a flow
 * may call into a transactional service layer.
 *
 */
public class OpenHibernateSessionInConversationListener extends FlowExecutionListenerAdapter {

    private static final String PERSISTENCE_CONTEXT_ATTRIBUTE = "persistenceContext";
    private static final String HIBERNATE_SESSION_ATTRIBUTE = "hibernateSession";

    private final SessionFactory sessionFactory;
    private Interceptor entityInterceptor;

    /**
     * Create a new Hibernate Flow Execution Listener using giving Hibernate
     * session factory and transaction manager.
     *
     * @param sessionFactory
     *            the session factory to use
     */
    public OpenHibernateSessionInConversationListener(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Sets the entity interceptor to attach to sessions opened by this
     * listener.
     *
     * @param entityInterceptor
     *            the entity interceptor
     */
    public void setEntityInterceptor(Interceptor entityInterceptor) {
        this.entityInterceptor = entityInterceptor;
    }

    @Override
    public void sessionStarting(RequestContext context, FlowSession session, MutableAttributeMap input) {
        if (isPersistenceContext(session.getDefinition())) {
            Session hibernateSession = getHibernateSession(context);
            if (hibernateSession == null) {
                hibernateSession = createSession(context);
                context.getFlowScope().put(HIBERNATE_SESSION_ATTRIBUTE, hibernateSession);
            }
            bind(hibernateSession);
            // store the hibernateSession in the request to make it available
            // for DisconnectHibernateInterceptor
            getRequest(context).put(HIBERNATE_SESSION_ATTRIBUTE, hibernateSession);
        }
    }

    @Override
    public void resuming(RequestContext context) {
        if (isPersistenceContext(context.getActiveFlow())) {
            Session hibernateSession = getHibernateSession(context);
            bind(hibernateSession);
            // store the hibernateSession in the request to make it available
            // for DisconnectHibernateInterceptor
            getRequest(context).put(HIBERNATE_SESSION_ATTRIBUTE, hibernateSession);
        }
    }

    @Override
    public void paused(RequestContext context) {
        if (isPersistenceContext(context.getActiveFlow())) {
            Session hibernateSession = getHibernateSession(context);
            unbind(hibernateSession);
            hibernateSession.disconnect();
        }
    }

    @Override
    public void sessionEnded(RequestContext context, FlowSession session, String outcome, AttributeMap output) {
        if (isPersistenceContext(session.getDefinition())) {
            if (session.getScope().contains(HIBERNATE_SESSION_ATTRIBUTE)) {
                // the hibernate session was created by this flow, and will be
                // closed by this flow
                Session hibernateSession = (Session) session.getScope().remove(HIBERNATE_SESSION_ATTRIBUTE);
                unbind(hibernateSession);
                hibernateSession.close();
            } else {
                Session hibernateSession = getHibernateSession(context);
                unbind(hibernateSession);
                hibernateSession.disconnect();
            }
        }
    }

    @Override
    public void exceptionThrown(RequestContext context, FlowExecutionException exception) {
        if (isPersistenceContext(context.getActiveFlow())) {
            Session hibernateSession = getHibernateSession(context);
            unbind(hibernateSession);
            hibernateSession.disconnect();
        }
    }

    // internal helpers

    private boolean isPersistenceContext(FlowDefinition flow) {
        return flow.getAttributes().contains(PERSISTENCE_CONTEXT_ATTRIBUTE);
    }

    private boolean isSupportsPersistenceContext(FlowDefinition flow) {
        return isPersistenceContext(flow)
                && "supports".equalsIgnoreCase(flow.getAttributes().getString(PERSISTENCE_CONTEXT_ATTRIBUTE));
    }

    private Session createSession(RequestContext context) {
        Session session = (entityInterceptor != null ? sessionFactory.openSession(entityInterceptor) : sessionFactory
                .openSession());
        session.setFlushMode(FlushMode.MANUAL);
        return session;
    }

    private Session getHibernateSession(RequestContext context) {
        if (context.getFlowExecutionContext().isActive()) {
            FlowSession flowSession = context.getFlowExecutionContext().getActiveSession();
            while (flowSession != null) {
                Session hibernateSession = (Session) flowSession.getScope().get(HIBERNATE_SESSION_ATTRIBUTE);
                if (hibernateSession != null) {
                    return hibernateSession;
                }
                if (isSupportsPersistenceContext(flowSession.getDefinition())) {
                    // continue and look in parent scope, if there is any parent
                    flowSession = flowSession.getParent();
                } else {
                    return null;
                }
            }
        }
        // no existing hibernate session
        return null;
    }

    private void bind(Session session) {
        if (!TransactionSynchronizationManager.hasResource(sessionFactory)) {
            TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
        }
    }

    private void unbind(Session session) {
        if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
            TransactionSynchronizationManager.unbindResource(sessionFactory);
        }
    }

    private MutableAttributeMap getRequest(RequestContext context) {
        return context.getExternalContext().getRequestMap();
    }

}