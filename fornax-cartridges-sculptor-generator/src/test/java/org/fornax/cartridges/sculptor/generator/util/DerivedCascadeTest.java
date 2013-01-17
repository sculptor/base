package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

@SuppressWarnings("unchecked")
public class DerivedCascadeTest {
    private SculptormetamodelFactory factory;

    private Application app;
    private Entity a;
    private Entity b;
    private Entity c;

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
        b.setModule(m1);
        c = factory.createEntity();
        c.setModule(m2);
    }

    @Test
    public void testDifferentModules() {
        Reference ref = factory.createReference();
        ref.setFrom(a);
        ref.setTo(c);
        a.getReferences().add(ref);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertNull(cascade);
    }
    
    @Test
    public void testUnidirectionalMultpOne() {
        Reference ref = createUnidirectional();
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertEquals("all", cascade);
    }

    @Test
    public void testUnidirectionalMultpMany() {
    	Reference ref = createUnidirectional();
        ref.setMany(true);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertEquals("all", cascade);
    }
    
    @Test
    public void testUnidirectionalMultpManyAggregate() {
    	Reference ref = createUnidirectional();
        ref.setMany(true);
        ((Entity) ref.getTo()).setAggregateRoot(false);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertEquals("all", cascade);
    }
    
    @Test
    public void testOneToMany() {
        Reference ref = createBidirectional();
        ref.setMany(true);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertEquals("all", cascade);
    }
    
    @Test
    public void testOneToManyAggregate() {
        Reference ref = createBidirectional();
        ref.setMany(true);
        ((Entity) ref.getTo()).setAggregateRoot(false);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertEquals("all-delete-orphan", cascade);
    }
    
    @Test
    public void testManyToMany() {
        Reference ref = createBidirectional();
        ref.setMany(true);
        ref.getOpposite().setMany(true);
        ref.getOpposite().setInverse(true);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertEquals("all", cascade);
    }
    
    @Test
    public void testManyToManyInverse() {
        Reference ref = createBidirectional();
        ref.setMany(true);
        ref.setInverse(true);
        ref.getOpposite().setMany(true);
        ref.getOpposite().setInverse(false);
        
        String cascade = DatabaseGenerationHelper.getDerivedCascade(ref);
        assertNull(cascade);
    }

    private Reference createUnidirectional() {
		Reference ref = factory.createReference();
        ref.setFrom(a);
        ref.setTo(b);
        a.getReferences().add(ref);
		return ref;
	}
    
	private Reference createBidirectional() {
		Reference ref = factory.createReference();
        ref.setFrom(a);
        ref.setTo(b);
        a.getReferences().add(ref);
        Reference ref2 = factory.createReference();
        ref2.setFrom(b);
        ref2.setTo(a);
        ref.setOpposite(ref2);
		return ref;
	}

}
