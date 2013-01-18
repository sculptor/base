package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptorguimetamodel.AddTask;
import sculptorguimetamodel.CreateTask;
import sculptorguimetamodel.DerivedReferenceViewProperty;
import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.ListTask;
import sculptorguimetamodel.ReferenceViewProperty;
import sculptorguimetamodel.UpdateTask;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.ViewDataProperty;
import sculptorguimetamodel.ViewTask;
import sculptormetamodel.Module;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;

//@Ignore("Skip this test now, due to problems when running from maven")
@SuppressWarnings("unchecked")
public class LibraryGuiDslTransformationTest extends TransformationTestBase {
    private static final boolean VALIDATE_SERVICE_OPERATION = true;
    private static final boolean DONT_VALIDATE_SERVICE_OPERATION = false;
    private static GuiApplication guiApp;

    @BeforeClass
    public static void before() throws Exception {
        System.setProperty("project.nature", "business-tier, rcp");
        initWorkflowContext("workflowguidsl-test-library.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @AfterClass
    public static void after() {
        System.getProperties().remove("project.nature");
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
    public void assertMediaModule() {
        GuiModule module = mediaModule();
        assertEquals("media", module.getName());
        assertEquals("media", module.getFor().getName());
        // tasks objects
        assertOneAndOnlyOne(module.getUserTasks(), "createLibrary", "viewLibrary", "updateLibrary", "deleteLibrary",
                "listLibrary", "addLibrary", "createPhysicalMedia", "viewPhysicalMedia", "updatePhysicalMedia",
                "deletePhysicalMedia", "listPhysicalMedia", "addPhysicalMedia", "createBook", "viewBook", "updateBook",
                "listBook", "addBook", "createMovie", "viewMovie", "updateMovie", "listMovie", "addMovie",
                "createEngagement", "viewEngagement", "createMediaCharacter", "viewMediaCharacter",
                "listMediaCharacter", "addMediaCharacter", "viewReview", "createReview", "viewComment", "createComment");
    }

    @Test
    public void assertCreateLibraryTask() {
        CreateTask task = (CreateTask) getNamedElement("createLibrary", mediaModule().getUserTasks());
        assertEquals("createLibrary", task.getName());
        assertEquals("create", task.getTaskType());
        assertEquals("Library", task.getFor().getName());

        assertEquals("saveLibrary", task.getCreateDOWith().getName());
        assertEquals("LibraryService", task.getCreateDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement("media", task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement("LibraryService", businessModule.getServices());
        assertSame(service, task.getCreateDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("saveLibrary", service.getOperations());
        assertSame(operation, task.getCreateDOWith());

        assertOneAndOnlyOne(task.getViewProperties(), "name", "media");

        assertAttributeViewProperty("name", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPhysicalMediaSubtask", "addPhysicalMediaSubtask");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertReferenceViewProperty("media", task.getViewProperties(), new String[] { "viewPhysicalMediaSubtask",
                "addPhysicalMediaSubtask" },
        // only location defined
                new String[] { "location" }, "PhysicalMedia");

        assertNotNull(task.getCreateDOWith());
        assertEquals("saveLibrary", task.getCreateDOWith().getName());

        assertNotNull(task.getPopulateDOWith());
        assertEquals("populate", task.getPopulateDOWith().getName());

        assertTrue(task.isGapClass());

    }

    @Test
    public void assertUpdateLibraryTask() {
        UpdateTask task = (UpdateTask) getNamedElement("updateLibrary", mediaModule().getUserTasks());
        assertEquals("updateLibrary", task.getName());
        assertEquals("update", task.getTaskType());
        assertEquals("Library", task.getFor().getName());

        assertEquals("save", task.getUpdateDOWith().getName());
        assertEquals("LibraryService", task.getUpdateDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement("media", task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement("LibraryService", businessModule.getServices());
        assertSame(service, task.getUpdateDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("save", service.getOperations());
        assertSame(operation, task.getUpdateDOWith());

        assertOneAndOnlyOne(task.getViewProperties(), "name", "media");

        assertAttributeViewProperty("name", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPhysicalMediaSubtask", "addPhysicalMediaSubtask");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertReferenceViewProperty("media", task.getViewProperties(), new String[] { "viewPhysicalMediaSubtask",
                "addPhysicalMediaSubtask" },
        // only location defined
                new String[] { "location", "status" }, "PhysicalMedia");

        assertNotNull(task.getUpdateDOWith());
        assertEquals("save", task.getUpdateDOWith().getName());

        assertNotNull(task.getPopulateDOWith());
        assertEquals("populateAssociations", task.getPopulateDOWith().getName());

        assertFalse(task.isGapClass());
    }

    @Test
    public void assertViewLibraryTask() {
        ViewTask task = (ViewTask) getNamedElement("viewLibrary", mediaModule().getUserTasks());
        assertEquals("viewLibrary", task.getName());
        assertEquals("view", task.getTaskType());
        assertEquals("Library", task.getFor().getName());

        assertEquals("findById", task.getFindDOWith().getName());
        assertEquals("LibraryService", task.getFindDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement("media", task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement("LibraryService", businessModule.getServices());
        assertSame(service, task.getFindDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("findById", service.getOperations());
        assertSame(operation, task.getFindDOWith());

        // skip media
        assertOneAndOnlyOne(task.getViewProperties(), "name");
        assertAttributeViewProperty("name", task.getViewProperties());
        assertEquals(0, task.getSubTaskTransitions().size());

        assertTrue(task.isGapClass());

        assertEquals("myhint", getNamedElement("name", task.getViewProperties()).getHint());
    }

    @Test
    public void assertListLibraryTask() {
        assertListTask("Library", "media", "name");
    }

    @Test
    public void assertAddPhysicalMediaTask() {
        AddTask task = (AddTask) getNamedElement("addPhysicalMedia", mediaModule().getUserTasks());
        assertOneAndOnlyOne(task.getViewProperties(), "location");
        assertAttributeViewProperty("location", task.getViewProperties());
    }

    @Test
    public void assertCreatePhysicalMedia() {

        assertCreateTask("PhysicalMedia", "media", new String[] { "status", "location" }, new String[] {
                "viewLibrarySubtask", "addLibrarySubtask", "createMovieSubtask", "viewMovieSubtask",
                "updateMovieSubtask", "addMovieSubtask", "createBookSubtask", "viewBookSubtask", "updateBookSubtask",
                "addBookSubtask" }, VALIDATE_SERVICE_OPERATION);
        CreateTask task = (CreateTask) getNamedElement("createPhysicalMedia", mediaModule().getUserTasks());
        assertReferenceViewProperty("library", task.getViewProperties(), new String[] { "viewLibrarySubtask",
                "addLibrarySubtask" }, new String[] { "name" }, "Library");

        assertNotNull(task.getPopulateDOWith());
        assertEquals("populateAssociations", task.getPopulateDOWith().getName());
    }

    @Test
    public void assertUpdatePhysicalMedia() {
        assertUpdateTask("PhysicalMedia", "media", new String[] { "status", "location" }, new String[] {
                "viewLibrarySubtask", "addLibrarySubtask", "createMovieSubtask", "viewMovieSubtask",
                "updateMovieSubtask", "addMovieSubtask", "createBookSubtask", "viewBookSubtask", "updateBookSubtask",
                "addBookSubtask" });
        UpdateTask task = (UpdateTask) getNamedElement("updatePhysicalMedia", mediaModule().getUserTasks());

        assertReferenceViewProperty("library", task.getViewProperties(), new String[] { "viewLibrarySubtask",
                "addLibrarySubtask" }, new String[] { "name" }, "Library");

        assertNotNull(task.getPopulateDOWith());
        assertEquals("populateAssociations", task.getPopulateDOWith().getName());
    }

    @Test
    public void assertMediaReferenceForCreatePhyicalMedia() {
        assertMediaReferenceForCreateUpdatePhysicalMedia((CreateTask) getNamedElement("createPhysicalMedia",
                mediaModule().getUserTasks()));
    }

    @Test
    public void assertMediaReferenceForUpdatePhyicalMedia() {
        assertMediaReferenceForCreateUpdatePhysicalMedia((UpdateTask) getNamedElement("updatePhysicalMedia",
                mediaModule().getUserTasks()));
    }

    private void assertMediaReferenceForCreateUpdatePhysicalMedia(UserTask task) {
        // not possible to use assertReferenceViewProperty for media reference,
        // since there are derived reference props

        ReferenceViewProperty mediaRefProp = namedReferenceViewProperty("media", task.getViewProperties());
        assertEquals("Media", mediaRefProp.getTarget().getName());
        assertEquals("media", mediaRefProp.getReference().getName());
        assertOneAndOnlyOne(mediaRefProp.getPreviewProperties(), "isbn", "title", "urlIMDB", "playLength", "category");

        List<ReferenceViewProperty> mediaProps = elementsOfType(ReferenceViewProperty.class,
                namedElements("media", task.getViewProperties()));
        assertEquals(3, mediaProps.size());
        List<DerivedReferenceViewProperty> mediaDerivedRefProps = elementsOfType(DerivedReferenceViewProperty.class,
                mediaProps);
        assertEquals(2, mediaDerivedRefProps.size());

        for (DerivedReferenceViewProperty each : mediaDerivedRefProps) {
            if ("Book".equals(each.getTarget().getName())) {
                assertEquals("Media", each.getDerivedFrom().getTarget().getName());
                assertEquals("media", each.getReference().getName());
                assertAttributeViewProperty("isbn", each.getPreviewProperties());
                assertAttributeViewProperty("title", each.getPreviewProperties());
                assertReferenceViewProperty("media", each, new String[] { "createBookSubtask", "viewBookSubtask",
                        "updateBookSubtask", "addBookSubtask" }, new String[] { "isbn", "title" }, "Book");
            } else if ("Movie".equals(each.getTarget().getName())) {
                assertEquals("Media", each.getDerivedFrom().getTarget().getName());
                assertEquals("media", each.getReference().getName());
                assertAttributeViewProperty("urlIMDB", each.getPreviewProperties());
                assertAttributeViewProperty("title", each.getPreviewProperties());
                assertAttributeViewProperty("playLength", each.getPreviewProperties());
                assertReferenceViewProperty("media", each, new String[] { "createMovieSubtask", "viewMovieSubtask",
                        "updateMovieSubtask", "addMovieSubtask" }, new String[] { "urlIMDB", "title", "playLength",
                        "category" }, "Movie");
            } else {
                assertTrue("Unexpected DerivedReferenceViewProperty for media: " + each.getTarget().getName(), false);
            }
        }
    }

    @Test
    public void assertViewPhysicalMedia() {
        ViewTask task = (ViewTask) getNamedElement("viewPhysicalMedia", mediaModule().getUserTasks());
        assertAttributeViewProperty("status", task.getViewProperties());
        assertAttributeViewProperty("location", task.getViewProperties());

        assertReferenceViewProperty("library", task.getViewProperties(), new String[] { "viewLibrarySubtask" },
                new String[] { "name" }, "Library");

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewLibrarySubtask", "viewMovieSubtask", "viewBookSubtask");

    }

    @Test
    public void assertMediaReferenceForViewPhysicalMedia() {
        ViewTask task = (ViewTask) getNamedElement("viewPhysicalMedia", mediaModule().getUserTasks());
        ReferenceViewProperty mediaRefProp = namedReferenceViewProperty("media", task.getViewProperties());
        assertEquals("Media", mediaRefProp.getTarget().getName());
        assertEquals("media", mediaRefProp.getReference().getName());

        List<ReferenceViewProperty> mediaProps = elementsOfType(ReferenceViewProperty.class,
                namedElements("media", task.getViewProperties()));
        assertEquals(3, mediaProps.size());
        List<DerivedReferenceViewProperty> mediaDerivedRefProps = elementsOfType(DerivedReferenceViewProperty.class,
                mediaProps);
        assertEquals(2, mediaDerivedRefProps.size());

        for (DerivedReferenceViewProperty each : mediaDerivedRefProps) {
            if ("Book".equals(each.getTarget().getName())) {
                assertReferenceViewProperty("media", each, new String[] { "viewBookSubtask" }, new String[] { "isbn",
                        "title" }, "Book");
            } else if ("Movie".equals(each.getTarget().getName())) {
                assertReferenceViewProperty("media", each, new String[] { "viewMovieSubtask" }, new String[] { "title",
                        "category" }, "Movie");
            } else {
                assertTrue("Unexpected DerivedReferenceViewProperty for media: " + each.getTarget().getName(), false);
            }
        }

    }

    @Test
    public void assertListPhysicalMedia() {
        assertListTask("PhysicalMedia", "media", "status", "location");
    }

    @Test
    public void assertViewMovie() {
        ViewTask task = (ViewTask) getNamedElement("viewMovie", mediaModule().getUserTasks());

        assertOneAndOnlyOne(task.getViewProperties(), "urlIMDB", "playLength", "category", "title", "physicalMedia",
                "engagements", "mediaCharacters");
        assertAttributeViewProperty("urlIMDB", task.getViewProperties());
        assertAttributeViewProperty("playLength", task.getViewProperties());
        assertAttributeViewProperty("title", task.getViewProperties());

        assertEnumViewProperty("category", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPhysicalMediaSubtask", "viewEngagementSubtask",
                "viewMediaCharacterSubtask");

        assertReferenceViewProperty("physicalMedia", task.getViewProperties(),
                new String[] { "viewPhysicalMediaSubtask" }, new String[] { "status", "location" }, "PhysicalMedia");
        assertReferenceViewProperty("engagements", task.getViewProperties(), new String[] { "viewEngagementSubtask" },
                new String[] { "role" }, "Engagement");
        assertReferenceViewProperty("mediaCharacters", task.getViewProperties(),
                new String[] { "viewMediaCharacterSubtask" }, new String[] { "name" }, "MediaCharacter");
    }

    @Test
    public void assertCreateBook() {
        assertCreateTask("Book", "media", new String[] { "isbn", "title" }, new String[] { "viewPhysicalMediaSubtask",
                "addPhysicalMediaSubtask", "viewEngagementSubtask", "createEngagementSubtask",
                "createMediaCharacterSubtask", "viewMediaCharacterSubtask", "addMediaCharacterSubtask" },
                DONT_VALIDATE_SERVICE_OPERATION);

        CreateTask task = (CreateTask) getNamedElement("createBook", mediaModule().getUserTasks());

        assertReferenceViewProperty("physicalMedia", task.getViewProperties(), new String[] {
                "viewPhysicalMediaSubtask", "addPhysicalMediaSubtask" }, new String[] { "status", "location" },
                "PhysicalMedia");
        assertReferenceViewProperty("engagements", task.getViewProperties(), new String[] { "viewEngagementSubtask",
                "createEngagementSubtask", }, new String[] { "role" }, "Engagement");

        assertNull(task.getPopulateDOWith());
    }

    @Test
    public void assertCreateMovie() {
        assertCreateTask("Movie", "media", new String[] { "urlIMDB", "title" }, new String[] {
                "viewPhysicalMediaSubtask", "addPhysicalMediaSubtask", "viewEngagementSubtask",
                "createEngagementSubtask", "createMediaCharacterSubtask", "viewMediaCharacterSubtask",
                "addMediaCharacterSubtask" }, DONT_VALIDATE_SERVICE_OPERATION);

        CreateTask task = (CreateTask) getNamedElement("createMovie", mediaModule().getUserTasks());

        assertReferenceViewProperty("physicalMedia", task.getViewProperties(), new String[] {
                "viewPhysicalMediaSubtask", "addPhysicalMediaSubtask" }, new String[] { "status", "location" },
                "PhysicalMedia");
        assertReferenceViewProperty("engagements", task.getViewProperties(), new String[] { "viewEngagementSubtask",
                "createEngagementSubtask" }, new String[] { "role" }, "Engagement");
    }

    @Test
    public void assertCreateEngagement() {
        CreateTask task = (CreateTask) getNamedElement("createEngagement", mediaModule().getUserTasks());

        assertAttributeViewProperty("role", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPersonSubtask", "addPersonSubtask", "viewMovieSubtask",
                "addMovieSubtask", "viewBookSubtask", "addBookSubtask");

        assertReferenceViewProperty("person", task.getViewProperties(), new String[] { "viewPersonSubtask",
                "addPersonSubtask" },
        // birtDate not included in previewProperties, since it is not
        // defined in the ViewTask for Person
                new String[] { "ssnCountry", "sex", "nameFirst", "nameLast" }, "Person");

        // verify order of properties
        assertEquals("person", ((ViewDataProperty) task.getViewProperties().get(0)).getName());
        assertEquals("role", ((ViewDataProperty) task.getViewProperties().get(1)).getName());
        assertEquals("media", ((ViewDataProperty) task.getViewProperties().get(2)).getName());

        // verify order of preview properties
        ReferenceViewProperty personRef = (ReferenceViewProperty) getNamedElement("person", task.getViewProperties());
        assertBasicTypeEnumViewProperty("ssn", "country", personRef.getPreviewProperties());
        assertEquals("ssnCountry", ((ViewDataProperty) personRef.getPreviewProperties().get(0)).getName());
        assertEnumViewProperty("sex", personRef.getPreviewProperties());
        assertEquals("sex", ((ViewDataProperty) personRef.getPreviewProperties().get(1)).getName());
        assertBasicTypeAttributeViewProperty("name", "first", personRef.getPreviewProperties());
        assertEquals("nameFirst", ((ViewDataProperty) personRef.getPreviewProperties().get(2)).getName());
        assertBasicTypeAttributeViewProperty("name", "last", personRef.getPreviewProperties());
        assertEquals("nameLast", ((ViewDataProperty) personRef.getPreviewProperties().get(3)).getName());

    }

    @Test
    public void assertMediaReferenceForCreateEngagement() {
        UserTask task = (UserTask) getNamedElement("createEngagement", mediaModule().getUserTasks());
        ReferenceViewProperty mediaRefProp = namedReferenceViewProperty("media", task.getViewProperties());
        assertEquals("Media", mediaRefProp.getTarget().getName());
        assertEquals("media", mediaRefProp.getReference().getName());
        assertOneAndOnlyOne(mediaRefProp.getPreviewProperties(), "isbn", "title", "urlIMDB", "playLength", "category");

        List<ReferenceViewProperty> mediaProps = elementsOfType(ReferenceViewProperty.class,
                namedElements("media", task.getViewProperties()));
        assertEquals(3, mediaProps.size());
        List<DerivedReferenceViewProperty> mediaDerivedRefProps = elementsOfType(DerivedReferenceViewProperty.class,
                mediaProps);
        assertEquals(2, mediaDerivedRefProps.size());

        for (DerivedReferenceViewProperty each : mediaDerivedRefProps) {
            if ("Book".equals(each.getTarget().getName())) {
                assertReferenceViewProperty("media", each, new String[] { "viewBookSubtask", "addBookSubtask" },
                        new String[] { "isbn", "title" }, "Book");
            } else if ("Movie".equals(each.getTarget().getName())) {
                assertReferenceViewProperty("media", each, new String[] { "viewMovieSubtask", "addMovieSubtask" },
                        new String[] { "urlIMDB", "title", "playLength", "category" }, "Movie");
            } else {
                assertTrue("Unexpected DerivedReferenceViewProperty for media: " + each.getTarget().getName(), false);
            }
        }
    }

    @Test
    public void assertViewEngagement() {
        ViewTask task = (ViewTask) getNamedElement("viewEngagement", mediaModule().getUserTasks());
        assertAttributeViewProperty("role", task.getViewProperties());

        assertOneAndOnlyOne(task.getSubTaskTransitions(), "viewPersonSubtask", "viewMovieSubtask", "viewBookSubtask");

        assertReferenceViewProperty("person", task.getViewProperties(), new String[] { "viewPersonSubtask" },
                new String[] { "ssnNumber", "ssnCountry", "nameFirst", "nameLast", "sex", "birthDate" }, "Person");

    }

    @Test
    public void assertPersonModule() {
        GuiModule module = personModule();
        assertOneAndOnlyOne(module.getUserTasks(), "viewPerson", "createPerson", "updatePerson", "deletePerson",
                "listPerson", "addPerson");
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

    @Test
    public void assertCreatePerson() {
        CreateTask task = (CreateTask) getNamedElement("createPerson", personModule().getUserTasks());
        assertOneAndOnlyOne(task.getViewProperties(), "nameFirst", "nameLast", "ssnNumber", "ssnCountry", "sex",
                "birthDate");

        assertAttributeViewProperty("birthDate", task.getViewProperties());

        assertBasicTypeAttributeViewProperty("name", "first", task.getViewProperties());
        assertBasicTypeAttributeViewProperty("name", "last", task.getViewProperties());
        assertBasicTypeAttributeViewProperty("ssn", "number", task.getViewProperties());
        assertBasicTypeEnumViewProperty("ssn", "country", task.getViewProperties());

        assertEnumViewProperty("sex", task.getViewProperties());

        assertEquals(0, task.getSubTaskTransitions().size());
    }

    private GuiModule mediaModule() {
        return (GuiModule) getNamedElement("media", guiApp.getModules());
    }

    private GuiModule personModule() {
        return (GuiModule) getNamedElement("person", guiApp.getModules());
    }

    private void assertListTask(String domainObjectName, String moduleName, String... attributeNames) {
        ListTask task = (ListTask) getNamedElement("list" + domainObjectName,
                ((GuiModule) getNamedElement(moduleName, guiApp.getModules())).getUserTasks());

        assertEquals("list" + domainObjectName, task.getName());
        assertEquals("list", task.getTaskType());
        assertEquals(domainObjectName, task.getFor().getName());

        assertEquals("findAll", task.getSearchDOWith().getName());
        assertEquals(domainObjectName + "Service", task.getSearchDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement(moduleName, task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement(domainObjectName + "Service", businessModule.getServices());
        assertSame(service, task.getSearchDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("findAll", service.getOperations());
        assertSame(operation, task.getSearchDOWith());
        assertOneAndOnlyOne(task.getViewProperties(), attributeNames);
        for (String attribute : attributeNames) {
            assertAttributeViewProperty(attribute, task.getViewProperties());
        }
        assertEquals(3, task.getSubTaskTransitions().size());
        assertOneAndOnlyOne(task.getSubTaskTransitions(), "view subtask", "update subtask", "delete subtask");

    }

    private void assertCreateTask(String domainObjectName, String moduleName, String[] attributeNames,
            String[] subtaskNames, boolean assertServiceOperation) {
        CreateTask task = (CreateTask) getNamedElement("create" + domainObjectName,
                ((GuiModule) getNamedElement(moduleName, guiApp.getModules())).getUserTasks());
        assertEquals("create" + domainObjectName, task.getName());
        assertEquals("create", task.getTaskType());
        assertEquals(domainObjectName, task.getFor().getName());

        if (assertServiceOperation) {
            assertEquals("save", task.getCreateDOWith().getName());
            assertEquals(domainObjectName + "Service", task.getCreateDOWith().getService().getName());
            Module businessModule = (Module) getNamedElement(moduleName, task.getModule().getApplication()
                    .getGuiForApplication().getModules());
            Service service = (Service) getNamedElement(domainObjectName + "Service", businessModule.getServices());
            assertSame(service, task.getCreateDOWith().getService());
            ServiceOperation operation = (ServiceOperation) getNamedElement("save", service.getOperations());
            assertSame(operation, task.getCreateDOWith());
        }
        for (String attributeName : attributeNames) {
            assertAttributeViewProperty(attributeName, task.getViewProperties());
        }

        assertOneAndOnlyOne(task.getSubTaskTransitions(), subtaskNames);

    }

    private void assertUpdateTask(String domainObjectName, String moduleName, String[] attributeNames,
            String[] subtaskNames) {
        UpdateTask task = (UpdateTask) getNamedElement("update" + domainObjectName,
                ((GuiModule) getNamedElement(moduleName, guiApp.getModules())).getUserTasks());
        assertEquals("update" + domainObjectName, task.getName());
        assertEquals("update", task.getTaskType());
        assertEquals(domainObjectName, task.getFor().getName());

        assertEquals("save", task.getUpdateDOWith().getName());
        assertEquals(domainObjectName + "Service", task.getUpdateDOWith().getService().getName());
        Module businessModule = (Module) getNamedElement(moduleName, task.getModule().getApplication()
                .getGuiForApplication().getModules());
        Service service = (Service) getNamedElement(domainObjectName + "Service", businessModule.getServices());
        assertSame(service, task.getUpdateDOWith().getService());
        ServiceOperation operation = (ServiceOperation) getNamedElement("save", service.getOperations());
        assertSame(operation, task.getUpdateDOWith());
        for (String attributeName : attributeNames) {
            assertAttributeViewProperty(attributeName, task.getViewProperties());
        }

        assertOneAndOnlyOne(task.getSubTaskTransitions(), subtaskNames);

    }

}
