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
public class ClientCommandServiceTest extends AbstractDbUnitJpaTests
    implements ClientCommandServiceTestBase {
    private ClientCommandService clientCommandService;

    @Autowired
    public void setClientCommandService(
        ClientCommandService clientCommandService) {
        this.clientCommandService = clientCommandService;
    }

    @Test
    public void testGetCommands() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testSendCommand() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testSendCommands() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testFindById() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testFindAll() throws Exception {
        // TODO Auto-generated method stub
    }

	public void testFindByCondition() throws Exception {
	   // TODO Auto-generated method stub
	   
   }
}
