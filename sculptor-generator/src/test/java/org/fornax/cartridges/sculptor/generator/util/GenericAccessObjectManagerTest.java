package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sculptormetamodel.RepositoryOperation;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

public class GenericAccessObjectManagerTest {

    private SculptormetamodelFactory factory;

    @Before
    public void setUp() {
        factory = SculptormetamodelFactoryImpl.eINSTANCE;

        Properties prop = new Properties();
        prop.setProperty("framework.accessapi.package", "org.myown.accessapi");
        prop.setProperty("framework.accessimpl.package", "org.myown.accessimpl");
        prop.setProperty("framework.accessimpl.prefix", "");
        prop.setProperty("framework.accessapi.EvictAccess", "org.someother.accessapi.EvictAcess");
        prop.setProperty("framework.accessimpl.EvictAccessImpl", "org.someother.accessimpl.EvictAcessImpl");
        GeneratorProperties.setProperties(prop);
    }

    @After
    public void tearDown() {
        GeneratorProperties.setProperties(null);
    }

    @Test
    public void shouldUseEvictAccessAsGenericAccessObject() {
        RepositoryOperation op = factory.createRepositoryOperation();
        op.setName("evict");
        assertTrue(GenericAccessObjectManager.createInstance().isGenericAccessObject(op));
    }

}
