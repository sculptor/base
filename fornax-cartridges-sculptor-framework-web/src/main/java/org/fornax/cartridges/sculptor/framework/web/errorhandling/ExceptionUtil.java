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

import javax.servlet.ServletException;

import org.fornax.cartridges.sculptor.framework.errorhandling.SystemException;

/**
 * Utilities to work with nested exceptions
 */
public class ExceptionUtil {
    
    public static Throwable unwrapCause(Throwable throwable) {
        Throwable cause = unwrapSystemException(throwable);
        if (cause == null) {
            cause = unwrapRootCause(throwable);
        }
        return cause;
    }
    
    public static SystemException unwrapSystemException(Throwable throwable) {
        if (throwable == null) {
            return null;
        } else if (throwable instanceof SystemException) {
            return (SystemException) throwable;
        } else if (throwable.getCause() != null) {
            // recursive call to unwrap the cause
            return unwrapSystemException(throwable.getCause());
        } else {
            // didn't find any SystemException in the cause stack
            return null;
        }
    }
    
    public static Throwable unwrapRootCause(Throwable throwable) {
        if (throwable == null) {
            return null;
        } else if (throwable instanceof SystemException) {
            // favour SystemException
            return throwable;
        } else if ((throwable instanceof ServletException) && ((ServletException) throwable).getRootCause() != null) {
            // recursive call to unwrap the root cause
            return unwrapRootCause(((ServletException) throwable).getRootCause());
        } else if (throwable.getCause() != null) {
            // recursive call to unwrap the cause
            return unwrapRootCause(throwable.getCause());
        } else {
            // this must be the cause
            return throwable;
        }
    }

    public static String resolveSystemExceptionErrorCode(Throwable throwable) {
        Throwable cause = unwrapCause(throwable);
        if (cause instanceof SystemException) {
            return ((SystemException) cause).getErrorCode();
        } else {
            // no wrapped SystemException
            return cause.getClass().getName();
        } 
    }
    
    public static String resolveSystemExceptionMessage(Throwable throwable) {
        Throwable cause = unwrapCause(throwable);
        String message;
        if (cause instanceof SystemException) {
            SystemException se = ((SystemException) cause);
            message = se.getMessage();
        } else {
            // no wrapped SystemException
            message = cause.getMessage();
            if (message == null || message.equals("")) {
                message = cause.getClass().getName();
            }
        } 
        return message;
    }
    
}
