package org.fornax.cartridges.sculptor.smartclient.serviceapi;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
@Ignore
// TODO Ignore due to Could not autowire field: private org.springframework.security.providers.encoding.PasswordEncoder
public class AuditLogServiceTest extends AbstractDbUnitJpaTests
    implements AuditLogServiceTestBase {
    private AuditLogService auditLogService;

    @Autowired
    public void setAuditLogService(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @Test
    public void testFindAll() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testFindById() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testSave() throws Exception {
        // TODO Auto-generated method stub
    }

    @Test
    public void testDelete() throws Exception {
        // TODO Auto-generated method stub
    }

	public void testFindByCondition() throws Exception {
	   // TODO Auto-generated method stub
	   
   }
}
