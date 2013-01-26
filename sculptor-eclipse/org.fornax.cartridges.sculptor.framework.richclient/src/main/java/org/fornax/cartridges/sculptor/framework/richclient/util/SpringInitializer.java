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

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitializer {

    private static String DEFAULT_SPRING_CONFIG_FILE_LOCATION = "applicationContext.xml";

    private ApplicationContext springContext;
    private ClassLoader classLoader;
    
    
    
    public SpringInitializer(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public synchronized void start() {
        if (springContext == null) {
            springContext = createSpringContext();
        }
    }
    
    public synchronized void stop() {
        if (springContext != null) {
            ((ConfigurableApplicationContext) springContext).close();
            springContext = null;
        }
    }
    
    protected ApplicationContext createSpringContext() {
        
        // Need to temporary adjust the thread ContextClassLoader to be able to find config xml file
        ClassLoader previousContextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(classLoader);
            
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(getSpringConfig());

            return context;
        } finally {
            Thread.currentThread().setContextClassLoader(previousContextClassLoader);
        }
    }
    
    /**
     * Override this method to specify the main Spring configuration file to
     * use. By default applicationContext.xml will be used.
     */
    protected String getSpringConfig() {
        return DEFAULT_SPRING_CONFIG_FILE_LOCATION;
    }
    
    public synchronized ApplicationContext getSpringContext() {
        if (springContext == null) {
            start();
        }
        return springContext;
    }
    
    @SuppressWarnings("unchecked")
    public<T> T getBeanFromSimpleClassName(Class<T> beanClass) {
        String beanName = beanClass.getSimpleName();
        beanName = toFirstLower(beanName);
        T result = (T) getSpringContext().getBean(beanName);
        return result;
    }

    /**
     * First character to lower case.
     */
    private String toFirstLower(String name) {
        if (name.length() == 0) {
            return name;
        } else {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
    }
}
