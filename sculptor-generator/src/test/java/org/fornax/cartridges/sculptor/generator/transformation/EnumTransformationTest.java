package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Entity;
import sculptormetamodel.Enum;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;

public class EnumTransformationTest extends TransformationTestBase {

    private static Application app;
    private static Module module;
    private static Entity entity;

    private static XtendFacade xtend;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-enum.mwe");
        setUpXtend();
        setUpApplication();
    }

    private static void setUpXtend() {
        EmfRegistryMetaModel metaModel = new EmfRegistryMetaModel();
        xtend = XtendFacade.create("extensions::helper", "extensions::dbhelper", "extensions::properties");
        xtend.registerMetaModel(metaModel);
    }

    private static void setUpApplication() {
        app = (Application) ctx.get("transformedModel");
        module = (Module) getNamedElement("module", app.getModules());
        entity = (Entity) getNamedElement("EnumTest", module.getDomainObjects());
    }

    @Test
    public void assertSimpleEnum() {
        Enum testEnum = (Enum) getNamedElement("SimpleEnum", module.getDomainObjects());
        assertFalse(testEnum.isOrdinal());
        assertEquals(0, testEnum.getAttributes().size());
        assertEquals(3, testEnum.getValues().size());
    }

    @Test
    public void assertSimpleEnumDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("SimpleEnum", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(5)", databaseType);
    }

    @Test
    public void assertSimpleEnumType() {
        Enum testEnum = (Enum) getNamedElement("SimpleEnum", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumType", testEnum);
        assertEquals("String", databaseType);
    }

    @Test
    public void assertSimpleEnumDatabaseLength() {
        Enum testEnum = (Enum) getNamedElement("SimpleEnum", module.getDomainObjects());
        String databaseLength = getStringResultFromXtendCall("getEnumDatabaseLength", testEnum);
        assertEquals("5", databaseLength);
    }

    @Test
    public void assertSimpleEnumIsOfTypeString() {
        Enum testEnum = (Enum) getNamedElement("SimpleEnum", module.getDomainObjects());
        boolean isString = getBooleanResultFromXtendCall("isOfTypeString", testEnum);
        assertTrue(isString);
    }

    @Test
    public void assertSimpleOrdinalEnumType() {
        Enum testEnum = (Enum) getNamedElement("SimpleOrdinalEnum", module.getDomainObjects());
        String type = getStringResultFromXtendCall("getEnumType", testEnum);
        assertEquals("int", type);
    }

    @Test
    public void assertSimpleOrdinalEnum() {
        Enum testEnum = (Enum) getNamedElement("SimpleOrdinalEnum", module.getDomainObjects());
        assertTrue(testEnum.isOrdinal());
        assertEquals(0, testEnum.getAttributes().size());
        assertEquals(2, testEnum.getValues().size());
    }

    @Test
    public void assertSimpleOrdinalEnumDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("SimpleOrdinalEnum", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("INTEGER", databaseType);
    }

    @Test
    public void assertSimpleOrdinalEnumIsOfTypeString() {
        Enum testEnum = (Enum) getNamedElement("SimpleOrdinalEnum", module.getDomainObjects());
        boolean isString = getBooleanResultFromXtendCall("isOfTypeString", testEnum);
        assertFalse(isString);
    }

    @Test
    public void assertEnumWithDefaultParameter() {
        Enum testEnum = (Enum) getNamedElement("EnumWithDefaultParameter", module.getDomainObjects());
        assertFalse(testEnum.isOrdinal());
        assertEquals(1, testEnum.getAttributes().size());
        assertEquals(3, testEnum.getValues().size());
    }

    @Test
    public void assertEnumWithDefaultParameterDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithDefaultParameter", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(1)", databaseType);
    }

    @Test
    public void assertEnumWithHintDatabaseLengthDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithHintDatabaseLength", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(10)", databaseType);
    }

    @Test
    public void assertEnumWithDefaultStringParameter() {
        Enum testEnum = (Enum) getNamedElement("EnumWithDefaultStringParameter", module.getDomainObjects());
        assertFalse(testEnum.isOrdinal());
        assertEquals(1, testEnum.getAttributes().size());
        assertEquals(3, testEnum.getValues().size());
    }

    @Test
    public void assertEnumWithDefaultStringParameterDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithDefaultStringParameter", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(2)", databaseType);
    }

    @Test
    public void assertEnumWithParametersWithoutKeyAttributeDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithParametersWithoutKeyAttribute", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(5)", databaseType);
    }

    @Test
    public void assertOrdinalEnumWithParametersWithoutKeyAttributeDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("OrdinalEnumWithParametersWithoutKeyAttribute", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("INTEGER", databaseType);
    }

    @Test
    public void assertEnumWithParametersWithDoubleKeyAttributeDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithParametersWithDoubleKeyAttribute", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(3)", databaseType);
    }

    @Test
    public void assertEnumWithParametersWithIntKeyAttributeDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithParametersWithIntKeyAttribute", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(1)", databaseType);
    }

    @Test
    public void assertEnumWithParametersWithStringKeyAttributeDatabaseType() {
        Enum testEnum = (Enum) getNamedElement("EnumWithParametersWithStringKeyAttribute", module.getDomainObjects());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", testEnum);
        assertEquals("VARCHAR(2)", databaseType);
    }

    @Test
    public void assertSimpleEnumReferenceDatabaseType() {
        Reference refenrence = (Reference) getNamedElement("simpleEnum", entity.getReferences());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", refenrence);
        assertEquals("VARCHAR(5)", databaseType);
    }

    @Test
    public void assertSimpleEnumReferenceWithHintDatabaseLengthDatabaseType() {
        Reference refenrence = (Reference) getNamedElement("simpleEnumWithHintDatabaseLength", entity.getReferences());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", refenrence);
        assertEquals("VARCHAR(20)", databaseType);
    }

    @Test
    public void assertSimpleOrdinalEnumReferenceDatabaseType() {
        Reference refenrence = (Reference) getNamedElement("simpleOrdinalEnum", entity.getReferences());
        String databaseType = getStringResultFromXtendCall("getEnumDatabaseType", refenrence);
        assertEquals("INTEGER", databaseType);
    }

    private String getStringResultFromXtendCall(String method, Object... parameters) {
    	Object result = getResultFromXtendCall(method, parameters);
    	if (!(result instanceof String))
    		fail("result is not of type String");
    	return (String) result;
    }

    private Boolean getBooleanResultFromXtendCall(String method, Object... parameters) {
    	Object result = getResultFromXtendCall(method, parameters);
    	if (!(result instanceof Boolean))
    		fail("result is not of type Boolean");
    	return (Boolean) result;
    }

    private Object getResultFromXtendCall(String method, Object... parameters) {
    	return xtend.call(method, parameters);
    }
}
