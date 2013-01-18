package org.fornax.cartridges.sculptor.generator.helper;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

public class AggregateTest {

    private static XtendFacade xtend;
    private SculptormetamodelFactory factory;
    private Application app;
    private Entity a;
    private Entity b;
    private Entity c;
    private Entity d;

    @BeforeClass
    public static void init() throws Exception {
        EmfRegistryMetaModel metaModel = new EmfRegistryMetaModel();
        xtend = XtendFacade.create("extensions::helper", "extensions::dbhelper", "extensions::properties");
        xtend.registerMetaModel(metaModel);
    }

    @Before
    public void setUp() throws Exception {
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


    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateForAggregateRootWithoutReferences() throws Exception {
        a.setAggregateRoot(true);
        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(1, aggregate.size());
        assertTrue(aggregate.contains(a));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateForAggregateRootWithExternalReference() throws Exception {
        a.setAggregateRoot(true);
        b.setAggregateRoot(true);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);
        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(1, aggregate.size());
        assertTrue(aggregate.contains(a));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
        assertEquals(b, xtend.call("getAggregateRootObject", b));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateWithInternalReference() throws Exception {
        a.setAggregateRoot(true);
        b.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);
        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(2, aggregate.size());
        assertTrue(aggregate.contains(a));
        assertTrue(aggregate.contains(b));

        Collection<DomainObject> aggregate2 = (Collection<DomainObject>) xtend.call("getAggregate", b);
        assertEquals(2, aggregate2.size());
        assertTrue(aggregate2.contains(a));
        assertTrue(aggregate2.contains(b));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
        assertEquals(a, xtend.call("getAggregateRootObject", b));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateWithReferenceOnlyFromChild() throws Exception {

        // TODO inconsistent aggregate when only reference from child:
        // This kind of association is rather strange design and the aggregate
        // is inconsistent depending on who you are asking (a or b) but since it
        // doesn't feel like a real world case I keep it as this for now

        a.setAggregateRoot(true);
        b.setAggregateRoot(false);
        Reference refBA = factory.createReference();
        refBA.setTo(a);
        b.getReferences().add(refBA);
        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(1, aggregate.size());
        assertTrue(aggregate.contains(a));

        Collection<DomainObject> aggregate2 = (Collection<DomainObject>) xtend.call("getAggregate", b);
        assertEquals(1, aggregate2.size());
        assertTrue(aggregate2.contains(b));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
        assertNull(xtend.call("getAggregateRootObject", b));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateWithBidirectionInternalReference() throws Exception {
        a.setAggregateRoot(true);
        b.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);

        Reference refBA = factory.createReference();
        refBA.setTo(a);
        b.getReferences().add(refBA);

        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(2, aggregate.size());
        assertTrue(aggregate.contains(a));
        assertTrue(aggregate.contains(b));

        Collection<DomainObject> aggregate2 = (Collection<DomainObject>) xtend.call("getAggregate", b);
        assertEquals(2, aggregate2.size());
        assertTrue(aggregate2.contains(a));
        assertTrue(aggregate2.contains(b));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
        assertEquals(a, xtend.call("getAggregateRootObject", b));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateWithTwoInternalReferences() throws Exception {
        a.setAggregateRoot(true);
        b.setAggregateRoot(false);
        c.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);

        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);

        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(3, aggregate.size());
        assertTrue(aggregate.contains(a));
        assertTrue(aggregate.contains(b));
        assertTrue(aggregate.contains(c));

        Collection<DomainObject> aggregate2 = (Collection<DomainObject>) xtend.call("getAggregate", b);
        assertEquals(3, aggregate2.size());
        assertTrue(aggregate2.contains(a));
        assertTrue(aggregate2.contains(b));
        assertTrue(aggregate2.contains(c));

        Collection<DomainObject> aggregate3 = (Collection<DomainObject>) xtend.call("getAggregate", c);
        assertEquals(3, aggregate3.size());
        assertTrue(aggregate3.contains(a));
        assertTrue(aggregate3.contains(b));
        assertTrue(aggregate3.contains(c));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
        assertEquals(a, xtend.call("getAggregateRootObject", b));
        assertEquals(a, xtend.call("getAggregateRootObject", c));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAggreagateWithCircularReferences() throws Exception {
        a.setAggregateRoot(true);
        b.setAggregateRoot(false);
        c.setAggregateRoot(false);
        Reference refAB = factory.createReference();
        refAB.setTo(b);
        a.getReferences().add(refAB);

        Reference refBA = factory.createReference();
        refBA.setTo(a);
        b.getReferences().add(refBA);

        Reference refBC = factory.createReference();
        refBC.setTo(c);
        b.getReferences().add(refBC);

        Reference refCB = factory.createReference();
        refCB.setTo(b);
        refCB.setOpposite(refBC);
        refBC.setOpposite(refCB);
        c.getReferences().add(refCB);

        Collection<DomainObject> aggregate = (Collection<DomainObject>) xtend.call("getAggregate", a);
        assertEquals(3, aggregate.size());
        assertTrue(aggregate.contains(a));
        assertTrue(aggregate.contains(b));
        assertTrue(aggregate.contains(c));

        Collection<DomainObject> aggregate2 = (Collection<DomainObject>) xtend.call("getAggregate", b);
        assertEquals(3, aggregate2.size());
        assertTrue(aggregate2.contains(a));
        assertTrue(aggregate2.contains(b));
        assertTrue(aggregate2.contains(c));

        Collection<DomainObject> aggregate3 = (Collection<DomainObject>) xtend.call("getAggregate", c);
        assertEquals(3, aggregate3.size());
        assertTrue(aggregate3.contains(a));
        assertTrue(aggregate3.contains(b));
        assertTrue(aggregate3.contains(c));

        assertEquals(a, xtend.call("getAggregateRootObject", a));
        assertEquals(a, xtend.call("getAggregateRootObject", b));
        assertEquals(a, xtend.call("getAggregateRootObject", c));
    }


}
