package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

@SuppressWarnings("unchecked")
public class AggregateConstraintsTest {
    private SculptormetamodelFactory factory;

    private Application app;
    private Entity a;
    private Entity b;
    private Entity c;
    private Entity d;

    @Before
    public void setUp() {
        factory = SculptormetamodelFactoryImpl.eINSTANCE;
        app = factory.createApplication();
        Module m1 = factory.createModule();
        m1.setApplication(app);
        Module m2 = factory.createModule();
        m2.setApplication(app);
        a = factory.createEntity();
        a.setModule(m1);
        b = factory.createEntity();
        b.setModule(m2);
        c = factory.createEntity();
        c.setModule(m2);
        d = factory.createEntity();
        d.setModule(m2);
    }

    @Test
    public void testOkReferences() {

        Reference refAB = factory.createReference();
        refAB.setTo(b);
        b.getReferences().add(refAB);
        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);

        assertTrue(AggregateConstraints.checkAggregateReferences(app));

    }

    @Test
    public void testOkReferencesFromAggregate() {
        b.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        b.getReferences().add(refAB);
        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);
        Reference refCA = factory.createReference();
        refCA.setTo(a);
        c.getReferences().add(refCA);

        assertTrue(AggregateConstraints.checkAggregateReferences(app));
    }

    @Test
    public void testInvalidReferencesToAggregate() {
        b.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);
        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);
        Reference refCB = factory.createReference();
        refCB.setTo(b);
        c.getReferences().add(refCB);

        assertFalse(AggregateConstraints.checkAggregateReferences(app));
    }

    @Test
    public void testInvalidReferencesToDeepAggregate() {
        b.setAggregateRoot(false);
        c.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);
        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);
        Reference refCA = factory.createReference();
        refCA.setTo(a);
        c.getReferences().add(refCA);
        Reference refDC = factory.createReference();
        refDC.setTo(c);
        d.getReferences().add(refDC);

        assertFalse(AggregateConstraints.checkAggregateReferences(app));
    }

    @Test
    public void testOkCycleReferences() {
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        b.getReferences().add(refAB);
        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);
        Reference refCA = factory.createReference();
        refCA.setTo(a);
        c.getReferences().add(refCA);

        assertTrue(AggregateConstraints.checkAggregateReferences(app));
    }

}
