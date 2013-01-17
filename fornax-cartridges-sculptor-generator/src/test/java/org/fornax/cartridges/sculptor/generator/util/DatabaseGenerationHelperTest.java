package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

public class DatabaseGenerationHelperTest {

    private SculptormetamodelFactory factory;

    private Application app;
    private Entity a;
    private Entity b;

    @Before
    public void setUp() {
        factory = SculptormetamodelFactoryImpl.eINSTANCE;
        app = factory.createApplication();
        Module m1 = factory.createModule();
        m1.setApplication(app);
        a = factory.createEntity();
        a.setModule(m1);
        b = factory.createEntity();
        b.setModule(m1);

        Properties prop = new Properties();
        prop.setProperty("db.product", "oracle");
        prop.setProperty("db.oracle.maxNameLength", "27");
        prop.setProperty("db.useUnderscoreNaming", "false");
        prop.setProperty("db.useIdSuffixInForeigKey", "false");
        prop.setProperty("db.useTablePrefixedIdColumn", "false");
        prop.setProperty("db.errorWhenTooLongName", "false");
        GeneratorProperties.setProperties(prop);
    }

    @After
    public void tearDown() {
        GeneratorProperties.setProperties(null);
    }

    @Test
    public void testShortDatabaseName() {
        a.setName("Foo");
        assertEquals("FOO", DatabaseGenerationHelper.getDatabaseName(a));
    }

    @Test
    public void testLongDatabaseName() {
        a.setName(   "ThisNameIsFarTooLooooooongForOracleDatabase");
        String dbName1 = DatabaseGenerationHelper.getDatabaseName(a);
        assertEquals("ThisNameIsFarTooLooooooon".toUpperCase(), dbName1.substring(0, dbName1.length() - 2));

        // another long name will increase the counter
        b.setName(   "ThisNameIsFarTooLooooooongForOracleDatabase2");
        String dbName2 = DatabaseGenerationHelper.getDatabaseName(b);
        assertEquals("ThisNameIsFarTooLooooooon".toUpperCase(), dbName2.substring(0, dbName2.length() - 2));

        // same name again should result in the same as before
        String dbName3 = DatabaseGenerationHelper.getDatabaseName(b);
        assertEquals(dbName2, dbName3);

        // exactly max length
        b.setName(   "ThisNameIsAlrightForOraclee");
        assertEquals("ThisNameIsAlrightForOraclee".toUpperCase(), DatabaseGenerationHelper.getDatabaseName(b));
    }

    @Test
    public void testShortManyToManyJoinTableName() {
        Reference ref1 = createManyToManyReference("foo", "bar");

        String tableName1 = DatabaseGenerationHelper.getManyToManyJoinTableName(ref1);
        assertEquals("BAR_FOO", tableName1);

        Reference ref2 = createManyToManyReference("bar", "foo");
        String tableName2 = DatabaseGenerationHelper.getManyToManyJoinTableName(ref2);
        assertEquals(tableName1, tableName2);
    }

    @Test
    public void testPluralManyToManyJoinTableName() {
        Reference ref1 = createManyToManyReference("foos", "bar");

        String tableName1 = DatabaseGenerationHelper.getManyToManyJoinTableName(ref1);
        assertEquals("BAR_FOO", tableName1);

        Reference ref2 = createManyToManyReference("bar", "foos");
        String tableName2 = DatabaseGenerationHelper.getManyToManyJoinTableName(ref2);
        assertEquals(tableName1, tableName2);
    }

    @Test
    public void testLongManyToManyJoinTableName() {
        Reference ref1 = createManyToManyReference("foo", "averyLoooooooooooooooongName");

        String tableName1 = DatabaseGenerationHelper.getManyToManyJoinTableName(ref1);
        assertEquals("averyLoooooooooooooooon_FOO".toUpperCase(), tableName1);

    }

    @Test
    public void testLongLongManyToManyJoinTableName() {
        Reference ref1 = createManyToManyReference("a234567890123456789012345", "b234567890123456789012345");

        String tableName1 = DatabaseGenerationHelper.getManyToManyJoinTableName(ref1);
        assertEquals("A234567890123_B234567890123".toUpperCase(), tableName1);
    }

    @Test
    public void testIsInverse() {
        Reference ref1 = createManyToManyReference("foo", "bar");
        assertTrue(DatabaseGenerationHelper.isInverse(ref1));
        assertFalse(DatabaseGenerationHelper.isInverse(ref1.getOpposite()));

        Reference ref2 = createManyToManyReference("bar", "foo");
        assertFalse(DatabaseGenerationHelper.isInverse(ref2));
        assertTrue(DatabaseGenerationHelper.isInverse(ref2.getOpposite()));

    }

    @Test
    public void testIsInverseSameStart() {
        Reference ref1 = createManyToManyReference("media", "mediaCharacter");
        assertFalse(DatabaseGenerationHelper.isInverse(ref1));
        assertTrue(DatabaseGenerationHelper.isInverse(ref1.getOpposite()));
    }

    @Test
    public void testIsInverseLongNames() {
        Reference ref1 = createManyToManyReference("a234567890123456789012345", "b234567890123456789012345");
        assertFalse(DatabaseGenerationHelper.isInverse(ref1));
        assertTrue(DatabaseGenerationHelper.isInverse(ref1.getOpposite()));
    }

    private Reference createManyToManyReference(String refName, String oppositeRefName) {
        a.setName(GenerationHelper.toFirstUpper(refName));
        b.setName(GenerationHelper.toFirstUpper(oppositeRefName));
        Reference a2b = factory.createReference();
        a2b.setMany(true);
        a2b.setName(refName);
        a2b.setFrom(a);
        a2b.setTo(b);

        Reference b2a = factory.createReference();
        b2a.setMany(true);
        b2a.setName(GenerationHelper.toFirstLower(oppositeRefName));
        b2a.setFrom(b);
        b2a.setTo(a);
        a2b.setOpposite(b2a);
        b2a.setOpposite(a2b);

        a2b.setDatabaseColumn(DatabaseGenerationHelper.getDefaultForeignKeyName(a2b));
        b2a.setDatabaseColumn(DatabaseGenerationHelper.getDefaultForeignKeyName(b2a));

        return a2b;
    }

    @Test
    public void testGetDomainObjectsInCreateOrderA2ManyB() {
        Reference a2b = factory.createReference();
        a2b.setMany(true);
        a2b.setFrom(a);
        a2b.setTo(b);

        Reference b2a = factory.createReference();
        b2a.setMany(false);
        b2a.setFrom(b);
        b2a.setTo(a);
        a2b.setOpposite(b2a);
        b2a.setOpposite(a2b);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(2, ordered.size());
        assertSame(a, ordered.get(0));
        assertSame(b, ordered.get(1));
    }

    @Test
    public void testGetDomainObjectsInCreateOrderB2ManyA() {
        Reference a2b = factory.createReference();
        a2b.setMany(false);
        a2b.setFrom(a);
        a2b.setTo(b);

        Reference b2a = factory.createReference();
        b2a.setMany(true);
        b2a.setFrom(b);
        b2a.setTo(a);
        a2b.setOpposite(b2a);
        b2a.setOpposite(a2b);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(2, ordered.size());
        assertSame(b, ordered.get(0));
        assertSame(a, ordered.get(1));
    }

    @Test
    public void testGetDomainObjectsInCreateOrderA2Self() {
        Reference a2parent = factory.createReference();
        a2parent.setMany(false);
        a2parent.setFrom(a);
        a2parent.setTo(a);

        Reference a2children = factory.createReference();
        a2children.setMany(true);
        a2children.setFrom(a);
        a2children.setTo(a);
        a2parent.setOpposite(a2children);
        a2children.setOpposite(a2parent);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(2, ordered.size());
        assertSame(a, ordered.get(0));
        assertSame(b, ordered.get(1));
    }

    /**
     * This caused StackOverflow in CSC-178
     */
    @Test
    public void testGetDomainObjectsInCreateOrderOne2One() {
        Reference a2b = factory.createReference();
        a2b.setMany(false);
        a2b.setFrom(a);
        a2b.setTo(b);

        Reference b2a = factory.createReference();
        b2a.setMany(false);
        b2a.setFrom(b);
        b2a.setTo(a);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(2, ordered.size());
        assertSame(b, ordered.get(0));
        assertSame(a, ordered.get(1));
    }

    /**
     * This caused StackOverflow in CSC-178
     */
    @Test
    public void testGetDomainObjectsInCreateOrderCircle() {
        Entity c = factory.createEntity();
        c.setModule(a.getModule());

        Reference a2b = factory.createReference();
        a2b.setMany(false);
        a2b.setFrom(a);
        a2b.setTo(b);

        Reference b2c = factory.createReference();
        b2c.setMany(false);
        b2c.setFrom(b);
        b2c.setTo(c);

        Reference c2a = factory.createReference();
        c2a.setMany(false);
        c2a.setFrom(c);
        c2a.setTo(a);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(3, ordered.size());
        assertSame(c, ordered.get(0));
        assertSame(b, ordered.get(1));
        assertSame(a, ordered.get(2));
    }

    @Test
    public void testGetDomainObjectsInCreateOrderAExtendsB() {
        b.setAbstract(true);
        a.setExtends(b);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(2, ordered.size());
        assertSame(b, ordered.get(0));
        assertSame(a, ordered.get(1));
    }

    @Test
    public void testGetDomainObjectsInCreateOrderBExtendsA() {
        a.setAbstract(true);
        b.setExtends(a);

        List<DomainObject> ordered = DatabaseGenerationHelper.getDomainObjectsInCreateOrder(app, true);
        assertEquals(2, ordered.size());
        assertSame(a, ordered.get(0));
        assertSame(b, ordered.get(1));
    }
}
