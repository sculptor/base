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
public class GuiDataSourceServiceTest extends AbstractDbUnitJpaTests
    implements GuiDataSourceServiceTestBase {
    private GuiDataSourceService guiDataSourceService;

    @Autowired
    public void setGuiDataSourceService(
        GuiDataSourceService guiDataSourceService) {
        this.guiDataSourceService = guiDataSourceService;
    }

    @Test
    public void testFindById() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testFindAll() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testSave() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testSetServiceMapping() throws Exception {
        // TODO Auto-generated method stub
    }
}
