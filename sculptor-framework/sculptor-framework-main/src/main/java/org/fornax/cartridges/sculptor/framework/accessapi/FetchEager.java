package org.fornax.cartridges.sculptor.framework.accessapi;

import org.fornax.cartridges.sculptor.framework.domain.Property;

/**
 * Access Objects that return an result 
 * may implement this interface.
 *
 */
public interface FetchEager {
    
    /**
     * Set list of properties to fetch eager
     */
    void setFetchEager(Property<?>[] fetchEager);

    /**
     * Get list of properties to fetch eager
     */
    Property<?>[] getFetchEager();

}
