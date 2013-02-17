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
package org.fornax.cartridges.sculptor.framework.richclient.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * This advice change the thread ContextClassLoader to the specified classloader, or
 * if a classloader is not specified the classloader of the target object is used, 
 * i.e. invocation.getThis(). After the invocation it is changed back to previous classloader.
 * 
 * @author Patrik Nordwall
 * 
 */
public class ContextClassLoaderAdvice implements MethodInterceptor {
    
    private ClassLoader classLoader;
    
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
    
    public void setUseClassloaderFromObject(Object obj) {
        setClassLoader(obj.getClass().getClassLoader());
    }
    
    public Object invoke(MethodInvocation invocation) throws Throwable {
        ClassLoader previousContextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            ClassLoader newClassLoader = classLoader;
            if (newClassLoader == null) {
                Object target = invocation.getThis();
                newClassLoader = target.getClass().getClassLoader();
            }
            Thread.currentThread().setContextClassLoader(newClassLoader);
            return invocation.proceed();
        } finally {
            Thread.currentThread().setContextClassLoader(previousContextClassLoader);
        }
    }

}
