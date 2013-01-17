package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptorguimetamodel.CreateTask;
import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.ReferenceViewProperty;

public class StringIDTransformationTest extends TransformationTestBase {
    private static GuiApplication guiApp;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflowguidsl-test-stringid.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @Test
    public void assertApplication() {
        assertEquals("StringIdWeb", guiApp.getName());
        EList modules = guiApp.getModules();
        assertNotNull(modules);
        assertEquals(1, modules.size());
    }

    @Test
    public void assertStringIdModule() {
        GuiModule module = testModule();
        assertOneAndOnlyOne(module.getUserTasks(), "createEntityWithStringId", "updateEntityWithStringId",
                "viewEntityWithStringId", "deleteEntityWithStringId", "listEntityWithStringId",
                "createValueObjectWithStringId", "viewValueObjectWithStringId",
                "listValueObjectWithStringId", "deleteValueObjectWithStringId", "createValueObjectWithStringId2",
                "viewValueObjectWithStringId2");
    }

    @Test
    public void assertCreateTaskEntityWithStringId() {
        CreateTask createTask = (CreateTask) getNamedElement("createEntityWithStringId", testModule().getUserTasks());
        assertEquals("createEntityWithStringId", createTask.getName());
        assertEquals("create", createTask.getTaskType());
        assertEquals("save", createTask.getCreateDOWith().getName());
        assertEquals("EntityWithStringIdService", createTask.getCreateDOWith().getService().getName());
        assertEquals("EntityWithStringId", createTask.getFor().getName());

    }

    @Test
    public void assertCreateTaskValueObjectWithStringId() {
        CreateTask createTask = (CreateTask) getNamedElement("createValueObjectWithStringId", testModule()
                .getUserTasks());
        assertEquals("createValueObjectWithStringId", createTask.getName());
        assertEquals("create", createTask.getTaskType());
        assertEquals("save", createTask.getCreateDOWith().getName());
        assertEquals("ValueObjectWithStringIdService", createTask.getCreateDOWith().getService().getName());
        assertEquals("ValueObjectWithStringId", createTask.getFor().getName());

        assertReferenceViewProperty("two", createTask.getViewProperties(), new String[] {
                "createValueObjectWithStringId2Subtask", 
                "viewValueObjectWithStringId2Subtask" }, new String[] { "message" }, "ValueObjectWithStringId2");
        ReferenceViewProperty twoRef = (ReferenceViewProperty) getNamedElement("two", createTask.getViewProperties());
        assertNull(getNamedElement("id", twoRef.getPreviewProperties()));
    }

    private GuiModule testModule() {
        return (GuiModule) getNamedElement("test", guiApp.getModules());
    }
}
