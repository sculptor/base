package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptorguimetamodel.AddTask;
import sculptorguimetamodel.CreateTask;
import sculptorguimetamodel.DeleteTask;
import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.ListTask;
import sculptorguimetamodel.UpdateTask;
import sculptorguimetamodel.ViewTask;

//@Ignore("Skip this test now, due to problems when running from maven")
public class UniverseGuiDslTransformationTest extends TransformationTestBase {
    private static GuiApplication guiApp;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflowguidsl-test-universe.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @Test
    public void assertApplication() {
        assertEquals("UniverseWeb", guiApp.getName());
        EList modules = guiApp.getModules();
        assertNotNull(modules);
        assertEquals(1, modules.size());
    }

    @Test
    public void assertMilkyWayModule() {
        GuiModule module = milkywayModule();
        assertEquals("milkyway", module.getName());
        assertEquals("milkyway", module.getFor().getName());
        assertOneAndOnlyOne(module.getUserTasks(), "createPlanet", "updatePlanet", "viewPlanet", "deletePlanet",
                "listPlanet", "createMoon", "updateMoon", "viewMoon", "addPlanet");
    }

    @Test
    public void assertCreatePlanetTask() {
        CreateTask createPlanetTask = (CreateTask) getNamedElement("createPlanet", milkywayModule().getUserTasks());
        assertEquals("createPlanet", createPlanetTask.getName());
        assertEquals("create", createPlanetTask.getTaskType());
        assertEquals("save", createPlanetTask.getCreateDOWith().getName());
        assertEquals("PlanetService", createPlanetTask.getCreateDOWith().getService().getName());
        assertEquals("Planet", createPlanetTask.getFor().getName());

        assertOneAndOnlyOne(createPlanetTask.getSubTaskTransitions(), "createMoonSubtask", "updateMoonSubtask",
                "viewMoonSubtask");
        assertOneAndOnlyOne(createPlanetTask.getViewProperties(), "name", "message", "diameter", "population", "moons");
        assertAttributeViewProperty("name", createPlanetTask.getViewProperties());
        assertAttributeViewProperty("message", createPlanetTask.getViewProperties());
        assertAttributeViewProperty("diameter", createPlanetTask.getViewProperties());
        assertAttributeViewProperty("population", createPlanetTask.getViewProperties());
        assertReferenceViewProperty("moons", createPlanetTask.getViewProperties(), new String[] { "createMoonSubtask",
                "updateMoonSubtask", "viewMoonSubtask" }, new String[] { "name", "diameter" }, "Moon");
        assertEquals(11, createPlanetTask.getViewProperties().size());
    }

    @Test
    public void assertCreateMoonTask() {
        CreateTask createMoonTask = (CreateTask) getNamedElement("createMoon", milkywayModule().getUserTasks());
        assertEquals("createMoon", createMoonTask.getName());
        assertEquals("create", createMoonTask.getTaskType());
        assertNull(createMoonTask.getCreateDOWith());
        assertEquals("Moon", createMoonTask.getFor().getName());
        assertOneAndOnlyOne(createMoonTask.getSubTaskTransitions(), "viewPlanetSubtask", "addPlanetSubtask");

        assertOneAndOnlyOne(createMoonTask.getViewProperties(), "planet", "name", "diameter");
        assertAttributeViewProperty("name", createMoonTask.getViewProperties());
        assertAttributeViewProperty("diameter", createMoonTask.getViewProperties());
        assertReferenceViewProperty("planet", createMoonTask.getViewProperties(), new String[] { "viewPlanetSubtask",
                "addPlanetSubtask" }, new String[] { "name", "message", "diameter", "population" }, "Planet");
        assertEquals(9, createMoonTask.getViewProperties().size());
    }

    @Test
    public void assertUpdatePlanetTask() {
        UpdateTask updatePlanetTask = (UpdateTask) getNamedElement("updatePlanet", milkywayModule().getUserTasks());
        assertEquals("updatePlanet", updatePlanetTask.getName());
        assertEquals("update", updatePlanetTask.getTaskType());
        assertEquals("save", updatePlanetTask.getUpdateDOWith().getName());
        assertEquals("PlanetService", updatePlanetTask.getUpdateDOWith().getService().getName());
        assertEquals("Planet", updatePlanetTask.getFor().getName());
        assertEquals(3, updatePlanetTask.getSubTaskTransitions().size());
        assertEquals(11, updatePlanetTask.getViewProperties().size());
        assertOneAndOnlyOne(updatePlanetTask.getSubTaskTransitions(), "createMoonSubtask", "updateMoonSubtask",
                "viewMoonSubtask");
        assertOneAndOnlyOne(updatePlanetTask.getViewProperties(), "name", "message", "diameter", "population", "moons");
        EList propList = updatePlanetTask.getViewProperties();
        assertAttributeViewProperty("name", propList);
        assertAttributeViewProperty("message", propList);
        assertAttributeViewProperty("diameter", propList);
        assertAttributeViewProperty("population", propList);
        assertReferenceViewProperty("moons", propList, new String[] { "createMoonSubtask", "updateMoonSubtask",
                "viewMoonSubtask" }, new String[] { "name", "diameter" }, "Moon");
    }

    @Test
    public void assertUpdateMoonTask() {
        UpdateTask updateMoonTask = (UpdateTask) getNamedElement("updateMoon", milkywayModule().getUserTasks());

        assertEquals("updateMoon", updateMoonTask.getName());
        assertEquals("update", updateMoonTask.getTaskType());
        assertNull(updateMoonTask.getUpdateDOWith());
        assertEquals("Moon", updateMoonTask.getFor().getName());
        assertOneAndOnlyOne(updateMoonTask.getSubTaskTransitions(), "viewPlanetSubtask", "addPlanetSubtask");

        assertOneAndOnlyOne(updateMoonTask.getViewProperties(), "planet", "diameter", "name");
        EList listOfProperties = updateMoonTask.getViewProperties();
        assertAttributeViewProperty("name", listOfProperties);
        assertAttributeViewProperty("diameter", listOfProperties);
        assertReferenceViewProperty("planet", listOfProperties,
                new String[] { "viewPlanetSubtask", "addPlanetSubtask" }, new String[] { "name", "diameter",
                        "population", "message" }, "Planet");
        assertEquals(9, updateMoonTask.getViewProperties().size());

    }

    @Test
    public void assertViewPlanetTask() {
        ViewTask viewPlanetTask = (ViewTask) getNamedElement("viewPlanet", milkywayModule().getUserTasks());
        assertEquals("viewPlanet", viewPlanetTask.getName());
        assertEquals("view", viewPlanetTask.getTaskType());
        assertEquals("findById", viewPlanetTask.getFindDOWith().getName());
        assertEquals("PlanetService", viewPlanetTask.getFindDOWith().getService().getName());
        assertEquals("Planet", viewPlanetTask.getFor().getName());
        assertEquals(1, viewPlanetTask.getSubTaskTransitions().size());
        assertEquals(11, viewPlanetTask.getViewProperties().size());

        assertOneAndOnlyOne(viewPlanetTask.getSubTaskTransitions(), "viewMoonSubtask");
        assertOneAndOnlyOne(viewPlanetTask.getViewProperties(), "name", "message", "diameter", "population", "moons");
        EList listOfProperties = viewPlanetTask.getViewProperties();
        assertAttributeViewProperty("name", listOfProperties);
        assertAttributeViewProperty("message", listOfProperties);
        assertAttributeViewProperty("diameter", listOfProperties);
        assertAttributeViewProperty("population", listOfProperties);
        assertReferenceViewProperty("moons", listOfProperties, new String[] { "viewMoonSubtask" }, new String[] {
                "name", "diameter" }, "Moon");
    }

    @Test
    public void assertViewMoonTask() {
        ViewTask viewMoonTask = (ViewTask) getNamedElement("viewMoon", milkywayModule().getUserTasks());
        assertEquals("viewMoon", viewMoonTask.getName());
        assertEquals("view", viewMoonTask.getTaskType());
        assertNull(viewMoonTask.getFindDOWith());
        assertEquals("Moon", viewMoonTask.getFor().getName());
        assertEquals(1, viewMoonTask.getSubTaskTransitions().size());
        assertEquals(9, viewMoonTask.getViewProperties().size());

        assertOneAndOnlyOne(viewMoonTask.getSubTaskTransitions(), "viewPlanetSubtask");
        assertOneAndOnlyOne(viewMoonTask.getViewProperties(), "name", "diameter", "planet");

        EList listOfProperties = viewMoonTask.getViewProperties();
        assertAttributeViewProperty("name", listOfProperties);
        assertAttributeViewProperty("diameter", listOfProperties);
        assertReferenceViewProperty("planet", listOfProperties, new String[] { "viewPlanetSubtask" }, new String[] {
                "name", "message", "diameter", "population" }, "Planet");
    }

    @Test
    public void assertAddPlanetTask() {
        AddTask task = (AddTask) getNamedElement("addPlanet", milkywayModule().getUserTasks());
        assertEquals("addPlanet", task.getName());
        assertEquals("add", task.getTaskType());
        assertNotNull(task.getFindDOWith());
        assertEquals("findAll", task.getFindDOWith().getName());
        assertEquals("Planet", task.getFor().getName());
        assertEquals(0, task.getSubTaskTransitions().size());

        assertOneAndOnlyOne(task.getViewProperties(), "name", "message", "diameter", "population");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertAttributeViewProperty("message", task.getViewProperties());
        assertAttributeViewProperty("diameter", task.getViewProperties());
        assertAttributeViewProperty("population", task.getViewProperties());
    }

    @Test
    public void assertDeletePlanetTask() {
        DeleteTask deletePlanetTask = (DeleteTask) getNamedElement("deletePlanet", milkywayModule().getUserTasks());
        assertEquals("deletePlanet", deletePlanetTask.getName());
        assertEquals("delete", deletePlanetTask.getTaskType());
        assertEquals("findById", deletePlanetTask.getFindDOWith().getName());
        assertEquals("delete", deletePlanetTask.getDeleteDOWith().getName());
        assertEquals("PlanetService", deletePlanetTask.getFindDOWith().getService().getName());
        assertEquals("Planet", deletePlanetTask.getFor().getName());
        assertEquals(1, deletePlanetTask.getSubTaskTransitions().size());
        assertEquals(11, deletePlanetTask.getViewProperties().size());

        assertOneAndOnlyOne(deletePlanetTask.getSubTaskTransitions(), "viewMoonSubtask");
        assertOneAndOnlyOne(deletePlanetTask.getViewProperties(), "name", "message", "diameter", "population", "moons");

        EList listOfProperties = deletePlanetTask.getViewProperties();
        assertAttributeViewProperty("name", listOfProperties);
        assertAttributeViewProperty("message", listOfProperties);
        assertAttributeViewProperty("diameter", listOfProperties);
        assertAttributeViewProperty("population", listOfProperties);
        assertReferenceViewProperty("moons", listOfProperties, new String[] { "viewMoonSubtask" }, new String[] {
                "name", "diameter" }, "Moon");
    }

    @Test
    public void assertListPlanetTask() {
        ListTask listPlanetTask = (ListTask) getNamedElement("listPlanet", milkywayModule().getUserTasks());
        assertEquals("listPlanet", listPlanetTask.getName());
        assertEquals("list", listPlanetTask.getTaskType());
        assertEquals("findAll", listPlanetTask.getSearchDOWith().getName());
        assertEquals("PlanetService", listPlanetTask.getSearchDOWith().getService().getName());
        assertEquals("Planet", listPlanetTask.getFor().getName());
        assertEquals(3, listPlanetTask.getSubTaskTransitions().size());
        System.out.println(listPlanetTask.getViewProperties());
        assertEquals(10, listPlanetTask.getViewProperties().size());

        assertOneAndOnlyOne(listPlanetTask.getSubTaskTransitions(), "view subtask", "update subtask", "delete subtask");
        assertOneAndOnlyOne(listPlanetTask.getViewProperties(), "name", "message", "diameter", "population");

        EList listOfProperties = listPlanetTask.getViewProperties();
        assertAttributeViewProperty("name", listOfProperties);
        assertAttributeViewProperty("message", listOfProperties);
        assertAttributeViewProperty("diameter", listOfProperties);
        assertAttributeViewProperty("population", listOfProperties);
    }

    private GuiModule milkywayModule() {
        return (GuiModule) getNamedElement("milkyway", guiApp.getModules());
    }
}
