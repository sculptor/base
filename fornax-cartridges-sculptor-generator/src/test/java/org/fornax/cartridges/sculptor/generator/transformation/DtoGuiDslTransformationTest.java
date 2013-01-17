package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptorguimetamodel.CreateTask;
import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.UpdateTask;
import sculptorguimetamodel.ViewTask;
import sculptormetamodel.Module;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;

public class DtoGuiDslTransformationTest extends TransformationTestBase {
    private static GuiApplication guiApp;

    @BeforeClass
    public static void before() throws Exception {
        initWorkflowContext("workflowguidsl-test-dto.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @Test
    public void assertApplication() {
        assertEquals("DtoAppWeb", guiApp.getName());
    }

    @Test
    public void assertModules() {
        EList modules = guiApp.getModules();
        assertNotNull(modules);
        assertEquals(1, modules.size());
        assertOneAndOnlyOne(modules, "media");
    }

    @Test
    public void assertMediaModule() {
        GuiModule module = mediaModule();
        // tasks objects
        assertOneAndOnlyOne(module.getUserTasks(), "createLibraryDto", "viewLibraryDto", "updateLibraryDto",
                "deleteLibraryDto", "listLibraryDto", "createPhysicalMediaDto", "viewPhysicalMediaDto",
                "updatePhysicalMediaDto");
    }

    @Test
    public void assertCreateLibraryTask() {
        CreateTask task = (CreateTask) getNamedElement("createLibraryDto", mediaModule().getUserTasks());
        assertEquals("createLibraryDto", task.getName());
        assertEquals("create", task.getTaskType());
        assertEquals("LibraryDto", task.getFor().getName());

        assertEquals("save", task.getCreateDOWith().getName());
        assertEquals("LibraryDtoService", task.getCreateDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement("media", task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement("LibraryDtoService", businessModule.getServices());
        assertSame(service, task.getCreateDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("save", service.getOperations());
        assertSame(operation, task.getCreateDOWith());

        assertOneAndOnlyOne(task.getViewProperties(), "name", "media");

        assertAttributeViewProperty("name", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPhysicalMediaDtoSubtask",
                "createPhysicalMediaDtoSubtask", "updatePhysicalMediaDtoSubtask");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertReferenceViewProperty("media", task.getViewProperties(), new String[] { "viewPhysicalMediaDtoSubtask",
                "createPhysicalMediaDtoSubtask", "updatePhysicalMediaDtoSubtask" },
        // only location defined
                new String[] { "location" }, "PhysicalMediaDto");

        assertNotNull(task.getCreateDOWith());
        assertEquals("save", task.getCreateDOWith().getName());

        assertTrue(task.isGapClass());
    }

    @Test
    public void assertUpdateLibraryTask() {
        UpdateTask task = (UpdateTask) getNamedElement("updateLibraryDto", mediaModule().getUserTasks());
        assertEquals("updateLibraryDto", task.getName());
        assertEquals("update", task.getTaskType());
        assertEquals("LibraryDto", task.getFor().getName());

        assertEquals("save", task.getUpdateDOWith().getName());
        assertEquals("LibraryDtoService", task.getUpdateDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement("media", task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement("LibraryDtoService", businessModule.getServices());
        assertSame(service, task.getUpdateDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("save", service.getOperations());
        assertSame(operation, task.getUpdateDOWith());

        assertOneAndOnlyOne(task.getViewProperties(), "name", "media", "rating");

        assertAttributeViewProperty("name", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPhysicalMediaDtoSubtask",
                "createPhysicalMediaDtoSubtask", "updatePhysicalMediaDtoSubtask");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertReferenceViewProperty("media", task.getViewProperties(), new String[] { "viewPhysicalMediaDtoSubtask",
                "createPhysicalMediaDtoSubtask", "updatePhysicalMediaDtoSubtask" },
                new String[] { "location", "status" }, "PhysicalMediaDto");

        assertNotNull(task.getUpdateDOWith());
        assertEquals("save", task.getUpdateDOWith().getName());

    }

    @Test
    public void assertViewLibraryTask() {
        ViewTask task = (ViewTask) getNamedElement("viewLibraryDto", mediaModule().getUserTasks());
        assertEquals("viewLibraryDto", task.getName());
        assertEquals("view", task.getTaskType());
        assertEquals("LibraryDto", task.getFor().getName());

        assertEquals("findById", task.getFindDOWith().getName());
        assertEquals("LibraryDtoService", task.getFindDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement("media", task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement("LibraryDtoService", businessModule.getServices());
        assertSame(service, task.getFindDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("findById", service.getOperations());
        assertSame(operation, task.getFindDOWith());

        // skip media
        assertOneAndOnlyOne(task.getViewProperties(), "name", "rating");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertEnumViewProperty("rating", task.getViewProperties());
        assertEquals(0, task.getSubTaskTransitions().size());
    }

    @Test
    public void assertViewPhysicalMedia() {
        ViewTask task = (ViewTask) getNamedElement("viewPhysicalMediaDto", mediaModule().getUserTasks());
        assertAttributeViewProperty("status", task.getViewProperties());
        assertAttributeViewProperty("location", task.getViewProperties());
    }

    private GuiModule mediaModule() {
        return (GuiModule) getNamedElement("media", guiApp.getModules());
    }

}
