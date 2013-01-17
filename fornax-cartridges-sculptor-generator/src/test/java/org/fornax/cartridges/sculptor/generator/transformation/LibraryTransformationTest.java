package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.fornax.cartridges.sculptor.generator.util.DatabaseGenerationHelper;
import org.fornax.cartridges.sculptor.generator.util.GeneratorProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Operation;
import sculptormetamodel.Reference;
import sculptormetamodel.Repository;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;
import sculptormetamodel.ValueObject;

public class LibraryTransformationTest extends TransformationTestBase {

    private static Application app;
    private static XtendFacade xtend;

    @BeforeClass
    public static void setUp() throws Exception {
        // need to add rcp nature to add populate method to scaffold operations
        System.getProperties().setProperty("project.nature", "business-tier, rcp");
        new GeneratorProperties(); // reload
        initWorkflowContext("workflow-test-library.mwe");
        app = (Application) ctx.get("transformedModel");

        EmfRegistryMetaModel metaModel = new EmfRegistryMetaModel();
        xtend = XtendFacade.create("extensions::helper", "extensions::dbhelper", "extensions::properties");
        xtend.registerMetaModel(metaModel);
    }

    @AfterClass
    public static void tearDown() {
        System.getProperties().remove("project.nature");
        new GeneratorProperties(); // reload
    }

    private Module personModule() {
        return (Module) getNamedElement("person", app.getModules());
    }

    private Module mediaModule() {
        return (Module) getNamedElement("media", app.getModules());
    }

    @Test
    public void assertApplication() {
        assertEquals("Library", app.getName());
    }

    @SuppressWarnings("unchecked")
    protected void assertModules() {
        EList modules = app.getModules();
        assertNotNull(modules);
        assertOneAndOnlyOne(modules, "media", "person");
    }

    @Test
    public void assertMediaModule() {
        Module module = mediaModule();
        assertOneAndOnlyOne(module.getDomainObjects(), "Library", "PhysicalMedia", "Media", "Book", "Movie",
                "Engagement", "MediaCharacter", "Genre", "Review", "Comment");
    }

    @Test
    public void assertPersonModule() {
        Module module = personModule();
        assertOneAndOnlyOne(module.getDomainObjects(), "Person", "Ssn", "Country", "Gender", "PersonName");
    }

    @Test
    public void assertPerson() {
        Entity person = (Entity) getNamedElement("Person", personModule().getDomainObjects());
        assertOneAndOnlyOne(person.getAttributes(), "birthDate");
        assertOneAndOnlyOne(person.getReferences(), "ssn", "name", "sex");
        Reference ssn = (Reference) getNamedElement("ssn", person.getReferences());
        assertTrue(ssn.isNaturalKey());
        Attribute ssnNumber = (Attribute) getNamedElement("number", ssn.getTo().getAttributes());
        assertTrue(ssnNumber.isNaturalKey());
        Reference ssnCountry = (Reference) getNamedElement("country", ssn.getTo().getReferences());
        assertTrue(ssnCountry.isNaturalKey());
        assertTrue(person.isGapClass());
        assertFalse(ssn.getTo().isGapClass());
    }

    /**
     * Bidirectional one-to-many
     */
    @Test
    public void assertReferenceToPhysicalMediaFromLibrary() throws Exception {
        Entity library = (Entity) getNamedElement("Library", mediaModule().getDomainObjects());
        Reference mediaRef = (Reference) getNamedElement("media", library.getReferences());
        assertFalse((Boolean) xtend.call("isInverse", new Object[] { mediaRef }));
        assertEquals("LIB_REF", xtend.call("getOppositeForeignKeyName", new Object[] { mediaRef }));
    }

    /**
     * Bidirectional many-to-one
     */
    @Test
    public void assertReferenceToLibraryFromPhysicalMedia() throws Exception {
        Entity physicalMedia = (Entity) getNamedElement("PhysicalMedia", mediaModule().getDomainObjects());
        Reference libraryRef = (Reference) getNamedElement("library", physicalMedia.getReferences());
        assertTrue((Boolean) xtend.call("isInverse", new Object[] { libraryRef }));
        assertEquals("LIB_REF", libraryRef.getDatabaseColumn());
        assertEquals("LIB_REF", xtend.call("getForeignKeyName", new Object[] { libraryRef }));
        assertEquals("MEDIA", xtend.call("getOppositeForeignKeyName", new Object[] { libraryRef }));
    }

    /**
     * Bidirectional many-to-many
     */
    @Test
    public void assertReferenceToMediaFromPhysicalMedia() throws Exception {
        Entity physicalMedia = (Entity) getNamedElement("PhysicalMedia", mediaModule().getDomainObjects());
        Reference mediaRef = (Reference) getNamedElement("media", physicalMedia.getReferences());
        assertFalse((Boolean) xtend.call("isInverse", new Object[] { mediaRef }));
        assertEquals("PHMED_MED", xtend.call("getManyToManyJoinTableName", new Object[] { mediaRef }));
        assertEquals("MEDIA_REF", mediaRef.getDatabaseColumn());
        assertEquals("MEDIA_REF", xtend.call("getForeignKeyName", new Object[] { mediaRef }));
        assertEquals("PHYSICALMEDIA", xtend.call("getOppositeForeignKeyName", new Object[] { mediaRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(mediaRef);
        assertEquals("PHMED_MED", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "media", "physicalMedia");
        Reference manyToManyObjectMediaRef = (Reference) getNamedElement("media", manyToManyObject.getReferences());
        assertEquals("MEDIA_REF", manyToManyObjectMediaRef.getDatabaseColumn());
        Reference manyToManyObjectPhysicalMediaRef = (Reference) getNamedElement("physicalMedia", manyToManyObject
                .getReferences());
        assertEquals("PHYSICALMEDIA", manyToManyObjectPhysicalMediaRef.getDatabaseColumn());
    }

    /**
     * Bidirectional many-to-many
     */
    @Test
    public void assertReferenceToPhysicalMediaFromMedia() throws Exception {
        Entity media = (Entity) getNamedElement("Media", mediaModule().getDomainObjects());
        Reference physicalMediaRef = (Reference) getNamedElement("physicalMedia", media.getReferences());
        assertTrue((Boolean) xtend.call("isInverse", new Object[] { physicalMediaRef }));
        assertEquals("PHMED_MED", xtend.call("getManyToManyJoinTableName", new Object[] { physicalMediaRef }));
        assertEquals("PHYSICALMEDIA", physicalMediaRef.getDatabaseColumn());
        assertEquals("PHYSICALMEDIA", xtend.call("getForeignKeyName", new Object[] { physicalMediaRef }));
        assertEquals("MEDIA_REF", xtend.call("getOppositeForeignKeyName", new Object[] { physicalMediaRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(physicalMediaRef);
        assertEquals("PHMED_MED", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "media", "physicalMedia");
        Reference manyToManyObjectMediaRef = (Reference) getNamedElement("media", manyToManyObject.getReferences());
        assertEquals("MEDIA_REF", manyToManyObjectMediaRef.getDatabaseColumn());
        Reference manyToManyObjectPhysicalMediaRef = (Reference) getNamedElement("physicalMedia", manyToManyObject
                .getReferences());
        assertEquals("PHYSICALMEDIA", manyToManyObjectPhysicalMediaRef.getDatabaseColumn());
    }

    /**
     * Unidirectional to-many with join table
     */
    @Test
    public void assertReferenceToPersonFromMediaCharacter() throws Exception {
        ValueObject mediaCharacter = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        Reference personRef = (Reference) getNamedElement("playedBy", mediaCharacter.getReferences());
        assertFalse((Boolean) xtend.call("isInverse", new Object[] { personRef }));
        assertEquals("MEDIA_CHR_PLAYEDBY", xtend.call("getManyToManyJoinTableName", new Object[] { personRef }));
        assertEquals("PLAYEDBY", personRef.getDatabaseColumn());
        assertEquals("PLAYEDBY", xtend.call("getForeignKeyName", new Object[] { personRef }));
        assertEquals("MEDIA_CHR", xtend.call("getOppositeForeignKeyName", new Object[] { personRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(personRef);
        assertEquals("MEDIA_CHR_PLAYEDBY", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "playedBy", "mediaCharacter");
        Reference manyToManyObjectPlayedByRef = (Reference) getNamedElement("playedBy", manyToManyObject
                .getReferences());
        assertEquals("PLAYEDBY", manyToManyObjectPlayedByRef.getDatabaseColumn());
        Reference manyToManyObjectMediaCharacterRef = (Reference) getNamedElement("mediaCharacter", manyToManyObject
                .getReferences());
        assertEquals("MEDIA_CHR", manyToManyObjectMediaCharacterRef.getDatabaseColumn());
    }

    /**
     * Unidirectional to-many without join table
     */
    @Test
    public void assertReferenceToReviewFromMediaCharacter() throws Exception {
        ValueObject mediaCharacter = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        Reference reviewsRef = (Reference) getNamedElement("reviews", mediaCharacter.getReferences());
        assertTrue((Boolean) xtend.call("isInverse", new Object[] { reviewsRef }));
        assertEquals("MEDIA_CHR", reviewsRef.getDatabaseColumn());
        assertEquals("MEDIA_CHR", xtend.call("getOppositeForeignKeyName", new Object[] { reviewsRef }));
    }

    /**
     * Unidirectional to-many without join table, custom databaseColumn name.
     * List collection.
     */
    @Test
    public void assertReferenceToCommentFromMediaCharacter() throws Exception {
        ValueObject mediaCharacter = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        Reference commentsRef = (Reference) getNamedElement("comments", mediaCharacter.getReferences());
        assertTrue((Boolean) xtend.call("isInverse", new Object[] { commentsRef }));
        assertEquals("COMMENT_OF_CHARACTER", commentsRef.getDatabaseColumn());
        assertEquals("COMMENT_OF_CHARACTER", xtend.call("getOppositeForeignKeyName", new Object[] { commentsRef }));
        assertEquals("COMMENT_OF_CHARACTER", xtend.call("getDatabaseName", new Object[] { commentsRef }));
        assertEquals("COMMENTS_INDEX", xtend.call("getListIndexColumnName", new Object[] { commentsRef }));
    }

    @Test
    public void assertLibraryService() {
        Service service = (Service) getNamedElement("LibraryService", mediaModule().getServices());
        assertTrue(service.isGapClass()); // due to saveLibrary, someOtherMethod
                                          // and populate
        assertEquals("serviceHint", service.getHint());
    }

    @Test
    public void assertLibraryRepository() {
        Entity library = (Entity) getNamedElement("Library", mediaModule().getDomainObjects());
        assertEquals("entityHint", library.getHint());
        Attribute attrName = (Attribute) getNamedElement("name", library.getAttributes());
        assertEquals("attrHint", attrName.getHint());
        Reference refMedia = (Reference) getNamedElement("media", library.getReferences());
        assertEquals("referenceHint", refMedia.getHint());

        Repository repository = library.getRepository();
        assertTrue(repository.isGapClass());
        assertEquals("repositoryHint", repository.getHint());
        Operation operFindByQuery = (Operation) getNamedElement("findByQuery", repository.getOperations());
        assertEquals("repoMethodHint", operFindByQuery.getHint());
    }

    @Test
    public void assertMediaCharacterValueObject() {
        ValueObject mediaCharacterVO = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        assertEquals("valueObjectHint", mediaCharacterVO.getHint());
        Attribute attrName = (Attribute) getNamedElement("name", mediaCharacterVO.getAttributes());
        assertEquals("valueObjectAttrHint", attrName.getHint());
        Reference refMedia = (Reference) getNamedElement("existsInMedia", mediaCharacterVO.getReferences());
        assertEquals("valueObjectRefHint", refMedia.getHint());
    }

    @Test
    public void assertPhysicalMediaRepository() {
        Entity physicalMedia = (Entity) getNamedElement("PhysicalMedia", mediaModule().getDomainObjects());
        Repository repository = physicalMedia.getRepository();
        assertFalse(repository.isGapClass());
    }

    @Test
    public void assertPersonRepository() {
        Entity person = (Entity) getNamedElement("Person", personModule().getDomainObjects());
        Repository repository = person.getRepository();
        assertFalse(repository.isGapClass());
    }

    @Test
    public void assertPersonService() {
        Service personService = (Service) getNamedElement("PersonService", personModule().getServices());
        ServiceOperation op = (ServiceOperation) getNamedElement("findPaged", personService.getOperations());
        assertNull(op.getCollectionType());
        assertEquals("PagedResult", op.getType());
        assertEquals("Person", op.getDomainObjectType().getName());
        String typeName = (String) xtend.call("getTypeName", new Object[] { op });
        assertEquals(
                "org.fornax.cartridges.sculptor.framework.domain.PagedResult<org.fornax.cartridges.sculptor.examples.library.person.domain.Person>",
                typeName);
    }

}
