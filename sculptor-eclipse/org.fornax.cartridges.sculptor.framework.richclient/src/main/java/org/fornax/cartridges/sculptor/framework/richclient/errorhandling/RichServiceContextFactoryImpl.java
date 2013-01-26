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

import java.util.Random;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

public class RichServiceContextFactoryImpl implements RichServiceContextFactory {
    
    private static final int MAX_GENERATED_SESSION_ID = 1000000;
    
    public static final String UNKNOWN_USER = "unknown";
    public static final String GUEST_USER = "guest";
    
    private static Random randomGenerator = new Random(System.currentTimeMillis());

    private String sessionId;
    private String userId = UNKNOWN_USER;
    private String applicationId;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public RichServiceContextFactoryImpl() {
        sessionId = String.valueOf(randomGenerator.nextInt(MAX_GENERATED_SESSION_ID));
    }

    public ServiceContext createServiceContext() {
        return new ServiceContext(userId, sessionId, applicationId);
    }

}
