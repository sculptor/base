package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.common.util.EList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.ViewDataProperty;
import sculptorguimetamodel.ViewTask;

public class CustomViewsGuiDslTransformationTest extends TransformationTestBase {
    private static GuiApplication guiApp;

    
    @BeforeClass
    public static void before() throws Exception {
        System.setProperty("project.nature", "business-tier, rcp");
        System.setProperty("gui.createDefaults", "false");

      
        initWorkflowContext("workflowguidsl-test-custom-library.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @AfterClass
    public static void after() {
        System.getProperties().remove("project.nature");
        System.getProperties().remove("gui.createDefaults");
    }


    @Test
    public void assertModules() {
        EList modules = guiApp.getModules();
        assertNotNull(modules);
        assertEquals(1, modules.size());
        assertOneAndOnlyOne(modules, "person");
    }
    
    @Test
    public void assertNoDefaultTasks() {
    	assertEquals(1, personModule().getUserTasks().size());
    }
    
    @Test
    public void assertViewPerson() {
        ViewTask task = (ViewTask) getNamedElement("viewPerson", personModule().getUserTasks());
        assertEquals("person", task.getModule().getName());
        assertOneAndOnlyOne(task.getViewProperties(), "nameFirst", "nameLast", "sex", "birthDate");

        assertBasicTypeAttributeViewProperty("name", "first", task.getViewProperties());
        assertBasicTypeAttributeViewProperty("name", "last", task.getViewProperties());

        assertEnumViewProperty("sex", task.getViewProperties());
        assertEquals(0, task.getSubTaskTransitions().size());

        // verify order of properties
        assertEquals("nameFirst", ((ViewDataProperty) task.getViewProperties().get(0)).getName());
        assertEquals("nameLast", ((ViewDataProperty) task.getViewProperties().get(1)).getName());
        assertEquals("birthDate", ((ViewDataProperty) task.getViewProperties().get(2)).getName());
        assertEquals("sex", ((ViewDataProperty) task.getViewProperties().get(3)).getName());

    }

    private GuiModule personModule() {
        return (GuiModule) getNamedElement("person", guiApp.getModules());
    }

}
