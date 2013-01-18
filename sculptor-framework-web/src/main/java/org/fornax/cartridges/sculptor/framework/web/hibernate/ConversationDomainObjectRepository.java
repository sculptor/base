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

import java.io.Serializable;

/**
 * Repository for retrieving domain objects that are used in
 * a conversation in the presentation tier. Only a few simple
 * operations are provided by this repository. Other
 * operations are provided by services in the business
 * tier. The objects operated on here are normally already
 * loaded into memory, but they can be retrieved from
 * the backing database.
 */
public interface ConversationDomainObjectRepository {

    /**
     * Retrieve a domain object with a specific id.
     */
    <T> T get(Class<T> domainObjectClass, Serializable id);

    /**
     * Discard modifications of the domain object and
     * populate it with fresh state.
     */
    void revert(Object domainObject);

    /**
     * Remove all objects from memory, to ensure fresh reload.
     */
    void clear();


}
