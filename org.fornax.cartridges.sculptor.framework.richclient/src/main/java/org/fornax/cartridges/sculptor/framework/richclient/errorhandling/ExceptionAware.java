/*
 * Copyright 2009 The Fornax Project Team, including the original
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
package org.fornax.cartridges.sculptor.framework.richclient.errorhandling;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.Policy;
import org.fornax.cartridges.sculptor.framework.errorhandling.ApplicationException;
import org.fornax.cartridges.sculptor.framework.errorhandling.OptimisticLockingException;
import org.fornax.cartridges.sculptor.framework.errorhandling.ValidationException;
import org.fornax.cartridges.sculptor.framework.richclient.SculptorFrameworkPlugin;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.remoting.RemoteAccessException;

public class ExceptionAware<T> {

    private MessageSource messages;
    private T returnValueWhenException;

    public ExceptionAware(MessageSource messages) {
        this(messages, null);
    }

    public ExceptionAware(MessageSource messages, T returnValueWhenException) {
        this.messages = messages;
        this.returnValueWhenException = returnValueWhenException;

    }

    protected MessageSource getMessages() {
        return messages;
    }

    /**
     * It is convenient to use the
     * {@link org.springframework.context.support.MessageSourceAccessor} to
     * fetch messages. Note that it uses the locale held by
     * {@link org.springframework.context.i18nLocaleContextHolder}.
     */
    protected MessageSourceAccessor getMessagesAccessor() {
        return new MessageSourceAccessor(getMessages());
    }

    public T run(java.util.concurrent.Callable<T> callable) {
        try {
            return callable.call();
        } catch (ApplicationException e) {
            return handleApplicationException(e);
        } catch (OptimisticLockingException e) {
            return handleOptimisticLockingException(e);
        } catch (ValidationException e) {
            return handleValidationException(e);
        } catch (RemoteAccessException e) {
            return handleRemoteAccessException(e);
        } catch (Exception e) {
            return handleWrappingException(e);
        } catch (Error e) {
            return handleError(e);
        }
    }

    protected T handleApplicationException(ApplicationException e) {
        Object[] parameters;
        if (e.getMessageParameters() == null) {
            parameters = new Object[0];
        } else {
            parameters = e.getMessageParameters();
        }

        String errorCode = e.getErrorCode();
        String translatedMsg = getMessage(errorCode, parameters);
        Status status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, translatedMsg);
        Policy.getStatusHandler().show(status, translatedMsg);
        return returnValueWhenException;
    }

    protected T handleOptimisticLockingException(OptimisticLockingException e) {
        String errorCode = e.getErrorCode();
        String translatedMsg = getMessage(errorCode);
        if (translatedMsg == null) {
            translatedMsg = e.getLocalizedMessage();
        }
        Status status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, translatedMsg);
        Policy.getStatusHandler().show(status, translatedMsg);
        return returnValueWhenException;
    }

    protected T handleValidationException(ValidationException e) {
        String errorCode = e.getErrorCode();
        String title = getMessage(errorCode);
        if (title == null) {
            title = e.getLocalizedMessage();
        }

        Status status;
        if (e.getConstraintViolations() == null || e.getConstraintViolations().isEmpty()) {
            status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, title);
        } else if (e.getConstraintViolations().size() == 1) {
            ConstraintViolation<?> invalidValue = e.getConstraintViolations().iterator().next();
            String translatedMsg = createMessage(invalidValue);
            status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, translatedMsg);
        } else {
            List<Status> children = new ArrayList<Status>();
            String firstMsg = null;
            for (ConstraintViolation<?> each : e.getConstraintViolations()) {
                String translatedMsg = createMessage(each);
                status = new Status(IStatus.WARNING, SculptorFrameworkPlugin.PLUGIN_ID, translatedMsg);
                children.add(status);
                if (firstMsg == null) {
                    firstMsg = translatedMsg;
                }
            }

            Status[] childrenArray = children.toArray(new Status[children.size()]);
            status = new MultiStatus(SculptorFrameworkPlugin.PLUGIN_ID, Status.OK, childrenArray, firstMsg, null);
        }

        Policy.getStatusHandler().show(status, title);
        return returnValueWhenException;
    }

    private String createMessage(ConstraintViolation<?> invalidValue) {
        if (hasMessage(invalidValue.getMessage())) {
            // possibility to use error code as message, to be able to define
            // own messages that are localized
            return getMessage(
                    invalidValue.getMessage(),
                    new Object[] { invalidValue.getRootBeanClass(), invalidValue.getPropertyPath(),
                            invalidValue.getInvalidValue() });
        } else {
            return invalidValue.getMessage();
        }
    }

    protected T handleRemoteAccessException(RemoteAccessException e) {
        return handleWrappingException(e);
    }

    protected T handleWrappingException(Exception e) {
        OptimisticLockingException ole = ExceptionUtil.unwrapOptimisticLockingException(e);
        if (ole != null) {
            return handleOptimisticLockingException(ole);
        }
        ValidationException ve = ExceptionUtil.unwrapValidationException(e);
        if (ve != null) {
            return handleValidationException(ve);
        }
        String errorCode = ExceptionUtil.resolveSystemExceptionErrorCode(e);
        String translatedMsg = getMessage(errorCode);
        if (translatedMsg == null) {
            translatedMsg = e.getLocalizedMessage();
        }
        String systemExceptionMsg = ExceptionUtil.resolveSystemExceptionMessage(e);

        Status status = new Status(IStatus.ERROR, SculptorFrameworkPlugin.PLUGIN_ID, systemExceptionMsg, e);
        Policy.getLog().log(status);
        Policy.getStatusHandler().show(status, translatedMsg);
        return returnValueWhenException;
    }

    protected T handleError(Error e) {
        String errorCode = ExceptionUtil.resolveSystemExceptionErrorCode(e);
        String translatedMsg = getMessage(errorCode);
        if (translatedMsg == null) {
            translatedMsg = e.getLocalizedMessage();
        }
        String systemExceptionMsg = ExceptionUtil.resolveSystemExceptionMessage(e);

        Status status = new Status(IStatus.ERROR, SculptorFrameworkPlugin.PLUGIN_ID, systemExceptionMsg, e);
        Policy.getLog().log(status);
        Policy.getStatusHandler().show(status, translatedMsg);
        throw e;
    }

    protected String getMessage(String errorCode) {
        return getMessage(errorCode, null);
    }

    protected boolean hasMessage(String errorCode) {
        String message = getMessage(errorCode);
        return (message != null && !message.startsWith("???"));
    }

    protected String getMessage(String errorCode, Object[] parameters) {
        try {
            String transformedErrorCode = transformErrorCode(errorCode);
            return getMessagesAccessor().getMessage(transformedErrorCode, parameters,
                    "??? " + transformedErrorCode + " ???");
        } catch (Exception e) {
            return null;
        }
    }

    protected String transformErrorCode(String errorCode) {
        errorCode = errorCode.replace('.', '_');
        return errorCode;
    }

}
