package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.DataTransferObject;
import sculptormetamodel.Module;
import sculptormetamodel.Service;

public class DtoTransformationTest extends TransformationTestBase {

    private static Application app;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-dto.mwe");
        app = (Application) ctx.get("transformedModel");
    }

    private Module module() {
        return (Module) getNamedElement("media", app.getModules());
    }

    @Test
    public void assertLibrary() {
        DataTransferObject library = (DataTransferObject) getNamedElement("LibraryDto", module().getDomainObjects());

        assertOneAndOnlyOne(library.getAttributes(), "id", "name");
        assertOneAndOnlyOne(library.getReferences(), "media", "rating");

        Attribute name = (Attribute) getNamedElement("name", library.getAttributes());
        assertFalse(name.isChangeable());

        Attribute id = (Attribute) getNamedElement("id", library.getAttributes());
        assertTrue(id.isChangeable());
    }

    @Test
    public void assertLibraryDtoService() {
        Service libraryWs = (Service) getNamedElement("LibraryDtoService", module().getServices());

        assertTrue(libraryWs.isWebService());
        assertOneAndOnlyOne(libraryWs.getOperations(), "findByName", "save", "findById", "findAll", "delete");
    }

}
