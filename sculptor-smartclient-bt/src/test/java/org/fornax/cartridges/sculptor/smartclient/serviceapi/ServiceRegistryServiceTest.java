package org.fornax.cartridges.sculptor.smartclient.serviceapi;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
@Ignore
//TODO Ignore due to Could not autowire field: private org.springframework.security.providers.encoding.PasswordEncoder
public class ServiceRegistryServiceTest extends AbstractDbUnitJpaTests
    implements ServiceRegistryServiceTestBase {
    private ServiceRegistryService serviceRegistryService;

    @Autowired
    public void setServiceRegistryService(
        ServiceRegistryService serviceRegistryService) {
        this.serviceRegistryService = serviceRegistryService;
    }

    @Test
    public void testGetServices() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testRefresh() throws Exception {
        // TODO Auto-generated method stub
    }
}
