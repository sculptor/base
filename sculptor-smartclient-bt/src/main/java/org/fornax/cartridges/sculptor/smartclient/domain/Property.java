package org.fornax.cartridges.sculptor.smartclient.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity representing Property.
 * <p>
 * This class is responsible for the domain object related
 * business logic for Property. Properties and associations are
 * implemented in the generated base class {@link org.fornax.cartridges.sculptor.smartclient.domain.PropertyBase}.
 */
@Entity
@Table(name = "PROPERTY")
public class Property extends PropertyBase {
    private static final long serialVersionUID = 1L;

    public Property() {
    }
}

