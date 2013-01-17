package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.EList;
import org.fornax.cartridges.sculptor.generator.util.GenerationHelper;
import org.fornax.cartridges.sculptor.generator.util.GeneratorProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.ValueObject;

@SuppressWarnings("unchecked")
public class NestedTransformationTest extends TransformationTestBase {
    @BeforeClass
    public static void setUp() throws Exception {
        System.getProperties().setProperty("generate.module.nested3", "false");
        System.getProperties().setProperty("generate.module.nested4", "false");
        GeneratorProperties.initProperties(true); // reload
        
        initWorkflowContext("workflow-test-nested.mwe");
    }
    
    @AfterClass
    public static void tearDown() {
        System.getProperties().remove("generate.module.nested3");
        System.getProperties().remove("generate.module.nested4");
        GeneratorProperties.initProperties(true); // reload
    }

    @Test
    public void assertApplication() {
        Application application = (Application) ctx.get("transformedModel");
        assertEquals("Nested", application.getName());
        EList modules = application.getModules();
        assertNotNull(modules);
        assertEquals(4, modules.size());
        assertModules(modules);
    }

    protected void assertModules(EList modules) {
        assertOneAndOnlyOne(modules, "nested1", "nested2", "nested3", "nested4");
        for (int i = 0; i < modules.size(); i++) {
            Module module = (Module) modules.get(i);
            if (module.getName().equals("nested1")) {
                assertNested1Module(module);
            } else if (module.getName().equals("nested2")) {
                assertNested2Module(module);
            } else if (module.getName().equals("nested3")) {
                assertNested3Module(module);
            } else if (module.getName().equals("nested4")) {
                assertNested4Module(module);
            } else {
                fail("unexpected module: " + module.getName());
            }
        }
    }

    private void assertNested1Module(Module module) {
        assertFalse(module.isExternal());
        assertOneAndOnlyOne(module.getDomainObjects(), "A");

    }

    private void assertNested2Module(Module module) {
        assertFalse(module.isExternal());
        assertEquals("org.fornax.cartridges.sculptor.test.nested.nested2.domain", GenerationHelper
                .getDomainPackage(module));
        assertOneAndOnlyOne(module.getDomainObjects(), "B");
        ValueObject bObj = (ValueObject) getNamedElement("B", module.getDomainObjects());
        assertEquals("B", bObj.getName());
        assertEquals("org.fornax.cartridges.sculptor.test.nested.nested2.domain", GenerationHelper
                .getDomainPackage(bObj));
        assertOneAndOnlyOne(bObj.getAttributes(), "b");
        assertOneAndOnlyOne(bObj.getReferences(), "c", "d");
        Reference cRef = (Reference) getNamedElement("c", bObj.getReferences());
        assertTrue(cRef.getTo().getModule().isExternal());
        Reference dRef = (Reference) getNamedElement("d", bObj.getReferences());
        assertTrue(dRef.getTo().getModule().isExternal());

    }

    private void assertNested3Module(Module module) {
        assertTrue(module.isExternal());
        assertEquals("org.fornax.cartridges.sculptor.test.common.nested3.domain", GenerationHelper
                .getDomainPackage(module));
        assertOneAndOnlyOne(module.getDomainObjects(), "C");
    }

    private void assertNested4Module(Module module) {
        assertTrue(module.isExternal());
        assertOneAndOnlyOne(module.getDomainObjects(), "D");
    }

}
