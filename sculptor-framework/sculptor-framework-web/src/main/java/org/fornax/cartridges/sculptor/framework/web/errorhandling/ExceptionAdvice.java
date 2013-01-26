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
package org.fornax.cartridges.sculptor.framework.web.errorhandling;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.fornax.cartridges.sculptor.framework.errorhandling.ApplicationException;
import org.fornax.cartridges.sculptor.framework.errorhandling.OptimisticLockingException;
import org.fornax.cartridges.sculptor.framework.errorhandling.SystemException;
import org.fornax.cartridges.sculptor.framework.errorhandling.ValidationException;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.webflow.execution.RequestContext;

/**
 * Intercepts every call to action methods catching exceptions and adding
 * appropriate error messages to the context.
 */
public class ExceptionAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            /* Try to excecute the method in question. */
            return methodInvocation.proceed();
        } catch (ApplicationException e) {
            return handleApplicationExcpetion(getRequestContext(methodInvocation), e);
        } catch (OptimisticLockingException e) {
            return handleOptimisticLockingException(getRequestContext(methodInvocation), e);
        } catch (ValidationException e) {
            return handleValidationException(getRequestContext(methodInvocation), e);
        } catch (RemoteAccessException e) {
            return handleRemoteAccessException(getRequestContext(methodInvocation), e);
        } catch (RuntimeException e) {
            return handleWrappingException(getRequestContext(methodInvocation), e);
        }
    }

    protected String handleApplicationExcpetion(RequestContext requestContext, ApplicationException e) {
        reportError(requestContext, e);
        return "error";
    }

    protected String handleRemoteAccessException(RequestContext requestContext, RemoteAccessException e) {
        return handleWrappingException(requestContext, e);
    }

    protected String handleOptimisticLockingException(RequestContext requestContext, OptimisticLockingException e) {
        reportError(requestContext, e);
        return "error";
    }

    protected String handleValidationException(RequestContext requestContext, ValidationException e) {
        reportError(requestContext, e);
        return "error";
    }

    protected String handleWrappingException(RequestContext requestContext, RuntimeException e) {
        Throwable cause = (e.getCause() == null ? e : e.getCause());
        if (cause instanceof RemoteException) {
            cause = cause.getCause();
        }
        OptimisticLockingException ole = unwrapOptimisticLockingException(cause);
        ValidationException idoe = unwrapValidationException(cause);
        if (ole != null) {
            return handleOptimisticLockingException(requestContext, ole);
        } else if (idoe != null) {
            return handleValidationException(requestContext, idoe);
        } else if (cause instanceof RuntimeException) {
            throw (RuntimeException) cause;
        } else {
            // not a wrapped exception
            throw e;
        }
    }

    protected OptimisticLockingException unwrapOptimisticLockingException(Throwable throwable) {
        if (throwable == null) {
            return null;
        } else if (throwable instanceof OptimisticLockingException) {
            return (OptimisticLockingException) throwable;
        } else if (throwable.getCause() != null) {
            // recursive call to unwrap the cause
            return unwrapOptimisticLockingException(throwable.getCause());
        } else {
            // didn't find any OptimisticLockingException in the cause stack
            return null;
        }
    }

    protected ValidationException unwrapValidationException(Throwable throwable) {
        if (throwable == null) {
            return null;
        } else if (throwable instanceof ValidationException) {
            return (ValidationException) throwable;
        } else if (throwable.getCause() != null) {
            // recursive call to unwrap the cause
            return unwrapValidationException(throwable.getCause());
        } else {
            // didn't find any ValidationException in the cause stack
            return null;
        }
    }

    private void reportError(RequestContext requestContext, ApplicationException e) {
        MessageBuilder builder = new MessageBuilder().error().code(e.getErrorCode()).defaultText(e.getMessage());
        if (e.getMessageParameters() != null) {
            builder = builder.args(e.getMessageParameters());
        }
        requestContext.getMessageContext().addMessage(builder.build());

    }

    private void reportError(RequestContext requestContext, SystemException e) {
        requestContext.getMessageContext().addMessage(
                new MessageBuilder().error().code(e.getErrorCode()).defaultText(e.getMessage()).build());

    }

    private void reportError(RequestContext requestContext, ValidationException e) {
        requestContext.getMessageContext().addMessage(
                new MessageBuilder().error().code(e.getErrorCode()).defaultText(e.getMessage()).build());
        if (e.getConstraintViolations() != null) {
            for (ConstraintViolation<?> each : e.getConstraintViolations()) {

                requestContext.getMessageContext().addMessage(
                        new MessageBuilder().error().code(
                                each.getRootBeanClass() + "." + each.getPropertyPath() + ".invalidValue").defaultText(
                                each.toString()).build());

            }
        }

    }

    private RequestContext getRequestContext(MethodInvocation methodInvocation) {
        // RequestContext is normally the first parameter of the method
        List<?> args = Arrays.asList(methodInvocation.getArguments());
        for (Object arg : args) {
            if (arg instanceof RequestContext) {
                return (RequestContext) arg;
            }
        }
        // RequestContext not supplied in arguments
        throw new IllegalArgumentException("Expected RequestContext as parameter in method: "
                + methodInvocation.getMethod().getName());
    }

}
