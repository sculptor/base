package org.fornax.cartridges.sculptor.smartclient.serviceimpl;

/*
 * (C) Copyright Factory4Solutions a.s. 2009
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

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;
import org.fornax.cartridges.sculptor.smartclient.serviceapi.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Server side service facade for property service implementing defaulting from property files
 * 
 * @author Ing. Pavel Tavoda
 */
@Component
public class PropertySupportFacade {
	private static final Logger log = LoggerFactory.getLogger(PropertySupportFacade.class);

	public Integer getPropertyAsInt(String propKey) {
		Integer retVal=null;
		try {
			retVal=Integer.valueOf(getProperty(propKey, null));
		} catch (Throwable th) {
			log.warn("Error geting property '{}' as Integer", propKey);
		}
		return retVal;
	}

	public Integer getPropertyAsInt(String propKey, int defaultValue) {
		Integer retVal=null;
		try {
			retVal=Integer.valueOf(getProperty(propKey, Integer.toString(defaultValue)));
		} catch (Throwable th) {
			log.warn("Error geting property '{}' as Integer", propKey);
		}
		return retVal;
	}

	public Long getPropertyAsLong(String propKey) {
		Long retVal=null;
		try {
			retVal=Long.valueOf(getProperty(propKey, null));
		} catch (Throwable th) {
			log.warn("Error geting property '{}' as Long", propKey);
		}
		return retVal;
	}

	public Long getPropertyAsLong(String propKey, long defaultValue) {
		Long retVal=null;
		try {
			retVal=Long.valueOf(getProperty(propKey, Long.toString(defaultValue)));
		} catch (Throwable th) {
			log.warn("Error geting property '{}' as Long", propKey);
		}
		return retVal;
	}

	public String getProperty(String propKey) {
		return getProperty(null, propKey, null);
	}

	public String getProperty(String propKey, String defaultValue) {
		return getProperty(null, propKey, defaultValue);
	}

	public String getProperty(String path, String propKey, String defaultValue) {
		return propertyService.getPropertyValue(ServiceContextStore.get(), path, propKey, defaultValue);
	}

	public String translate(String propName) {
		return propertyService.translate(ServiceContextStore.get(), propName);
	}

	@Autowired
	private PropertyService propertyService;
}
