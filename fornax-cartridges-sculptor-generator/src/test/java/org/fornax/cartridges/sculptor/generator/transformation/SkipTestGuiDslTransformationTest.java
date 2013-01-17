package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.ViewDataProperty;
import sculptormetamodel.NamedElement;

//@Ignore("Skip this test now, due to problems when running from maven")
@SuppressWarnings("unchecked")
public class SkipTestGuiDslTransformationTest extends TransformationTestBase {
    private static GuiApplication guiApp;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("skip-test-workflowguidsl.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @Test
    public void assertApplication() {
        assertEquals("LibraryWeb", guiApp.getName());
    }

    @Test
    public void assertModules() {
        EList modules = guiApp.getModules();
        assertNotNull(modules);
        assertEquals(2, modules.size());
        assertOneAndOnlyOne(modules, "media", "person");
    }

    @Test
    public void assertSkippedUserTasks() {
        // all user task should be here except:
        // viewBook
        // createMovie
        // createMediaCharacter
        // viewMediaCharacter
        assertNamedElementsIsNull(mediaModule().getUserTasks(), "createMovie", "createMediaCharacter",
                "viewMediaCharacter");

    }

    @Test
    public void assertMovieDoesntHaveReferenceToMediaCharacters() {
        assertOneAndOnlyOne(userTask("viewMovie").getViewProperties(), "title", "urlIMDB", "playLength",
                "physicalMedia", "engagements", "category");
    }

    @Test
    public void assertMovieDoesntHaveTransitionsToMediaCharacters() {
        assertOneAndOnlyOne(userTask("viewMovie").getSubTaskTransitions(), "viewPhysicalMediaSubtask",
                "viewEngagementSubtask");
    }

    @Test
    public void assertDirectorDoesntHaveSubtasksToAddress() {
        assertDoesntContainSubtaskTransition(userTask("viewDirector").getSubTaskTransitions(), "Address");
        assertDoesntContainSubtaskTransition(userTask("createDirector").getSubTaskTransitions(), "Address");
    }

    @Test
    public void assertDirectorDoesntHaveReferenceToAddress() {
        assertOneAndOnlyOne(userTask("viewDirector").getViewProperties(), "name", "car");
    }

    @Test
    public void assertPhysicalMediaDoesntHaveSubtaskToViewComicBook() {
        assertOneAndOnlyOne(userTask("viewPhysicalMedia").getSubTaskTransitions(), "viewMovieSubtask",
                "viewBookSubtask", "viewLibrarySubtask");
    }

    @Test
    public void assertAddressIsSkipped() {
        // no address related tasks
        assertNamedElementsIsNull(personModule().getUserTasks(), "viewAddress", "createAddress", "updateAddress",
                "deleteAddress", "listAddress", "addAddress");
    }

    @Test
    public void assertViewPersonDoesntHaveSubtaskToSummerHoliday() {
        assertDoesntContainSubtaskTransition(userTaskFromPersonModule("viewPerson").getSubTaskTransitions(),
                "SummerHoliday");
    }

    @Test
    public void assertCreatePersonDoesntHaveSubtaskToSummerHoliday() {
        assertDoesntContainSubtaskTransition(userTaskFromPersonModule("viewPerson").getSubTaskTransitions(),
                "SummerHoliday");
    }

    @Test
    public void assertViewPersonDoesntHaveReferenceToAddress() {
        assertNull(getNamedElement("address", userTaskFromPersonModule("viewPerson").getViewProperties()));
    }

    @Test
    public void assertCreatePersonDoesntHaveReferenceToAddress() {
        assertNull(getNamedElement("address", userTaskFromPersonModule("createPerson").getViewProperties()));
    }

    @Test
    public void assertCreatePersonDoesntHaveReferenceToSummerHoliday() {
        // control number of view data properties for last holiday
        // it should be 2, since we have skipped SummerHoliday, so, one for the
        // base and one for WinterHoliday
        int count = 0;
        for (Iterator iterator = userTaskFromPersonModule("createPerson").getViewProperties().iterator(); iterator
                .hasNext();) {
            ViewDataProperty type = (ViewDataProperty) iterator.next();
            if (type.getName().equals("lastHoliday")) {
                count++;
            }
        }
        assertEquals(2, count);
    }

    private void assertDoesntContainSubtaskTransition(EList subtaskTransitions, String pattern) {
        for (Iterator iterator = subtaskTransitions.iterator(); iterator.hasNext();) {
            SubTaskTransition subtask = (SubTaskTransition) iterator.next();
            assertNamedElementDoesntContainString(subtask, pattern);
        }
    }

    private void assertNamedElementDoesntContainString(NamedElement namedElement, String pattern) {
        assertFalse(namedElement.getName().contains(pattern));
    }

    private void assertNamedElementsIsNull(EList listOfNamedElements, String... names) {
        for (String name : names) {
            assertNull(name + " should have been null", getNamedElement(name, listOfNamedElements));
        }
    }

    private GuiModule mediaModule() {
        return (GuiModule) getNamedElement("media", guiApp.getModules());
    }

    private GuiModule personModule() {
        return (GuiModule) getNamedElement("person", guiApp.getModules());
    }

    private UserTask userTaskFromMediaModule(String taskName) {
        return (UserTask) getNamedElement(taskName, mediaModule().getUserTasks());
    }

    private UserTask userTaskFromPersonModule(String taskName) {
        return (UserTask) getNamedElement(taskName, personModule().getUserTasks());
    }

    private UserTask userTask(String taskName) {
        return userTaskFromMediaModule(taskName);
    }
}
