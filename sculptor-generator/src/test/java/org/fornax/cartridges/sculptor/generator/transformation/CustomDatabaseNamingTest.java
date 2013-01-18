package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.fornax.cartridges.sculptor.generator.util.DatabaseGenerationHelper;
import org.fornax.cartridges.sculptor.generator.util.GeneratorProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Reference;
import sculptormetamodel.ValueObject;

public class CustomDatabaseNamingTest extends TransformationTestBase {

    private static Application app;
    private static XtendFacade xtend;
		public String getAbsolutePath() {
			throw new UnsupportedOperationException();

		}

    @BeforeClass
    public static void setUp() throws Exception {
        // need to add rcp nature to add populate method to scaffold operations
        System.getProperties().setProperty("project.nature", "business-tier, rcp");
        System.getProperties().setProperty("db.useUnderscoreNaming", "true");
        System.getProperties().setProperty("db.useIdSuffixInForeigKey", "true");
        System.getProperties().setProperty("db.useTablePrefixedIdColumn", "true");

        GeneratorProperties.initProperties(true); // reload

        initWorkflowContext("workflow-test-library.mwe");
        app = (Application) ctx.get("transformedModel");

        EmfRegistryMetaModel metaModel = new EmfRegistryMetaModel();
        xtend = XtendFacade.create("extensions::helper", "extensions::dbhelper", "extensions::properties");
        xtend.registerMetaModel(metaModel);
    }

    @AfterClass
    public static void tearDown() {
        System.getProperties().remove("project.nature");
        System.getProperties().remove("db.useUnderscoreNaming");
        System.getProperties().remove("db.useIdSuffixInForeigKey");
        System.getProperties().remove("db.useTablePrefixedIdColumn");
        GeneratorProperties.initProperties(true); // reload
    }

    private Module mediaModule() {
        return (Module) getNamedElement("media", app.getModules());
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
        assertEquals("MEDIA_PHYSICAL_MEDIA_ID", xtend.call("getOppositeForeignKeyName", new Object[] { libraryRef }));
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
        assertEquals("PHYSICAL_MEDIA_ID", xtend.call("getOppositeForeignKeyName", new Object[] { mediaRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(mediaRef);
        assertEquals("PHMED_MED", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "media", "physicalMedia");
        Reference manyToManyObjectMediaRef = (Reference) getNamedElement("media", manyToManyObject.getReferences());
        assertEquals("MEDIA_REF", manyToManyObjectMediaRef.getDatabaseColumn());
        Reference manyToManyObjectPhysicalMediaRef = (Reference) getNamedElement("physicalMedia", manyToManyObject
                .getReferences());
        assertEquals("PHYSICAL_MEDIA_ID", manyToManyObjectPhysicalMediaRef.getDatabaseColumn());
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
        assertEquals("PHYSICAL_MEDIA_ID", physicalMediaRef.getDatabaseColumn());
        assertEquals("PHYSICAL_MEDIA_ID", xtend.call("getForeignKeyName", new Object[] { physicalMediaRef }));
        assertEquals("MEDIA_REF", xtend.call("getOppositeForeignKeyName", new Object[] { physicalMediaRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(physicalMediaRef);
        assertEquals("PHMED_MED", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "media", "physicalMedia");
        Reference manyToManyObjectMediaRef = (Reference) getNamedElement("media", manyToManyObject.getReferences());
        assertEquals("MEDIA_REF", manyToManyObjectMediaRef.getDatabaseColumn());
        Reference manyToManyObjectPhysicalMediaRef = (Reference) getNamedElement("physicalMedia", manyToManyObject
                .getReferences());
        assertEquals("PHYSICAL_MEDIA_ID", manyToManyObjectPhysicalMediaRef.getDatabaseColumn());
    }

    /**
     * Unidirectional to-many with join table From obj has customer
     * databaseTable="MEDIA_CHR"
     */
    @Test
    public void assertReferencePlayedByFromMediaCharacter() throws Exception {
        ValueObject mediaCharacter = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        Reference playedByRef = (Reference) getNamedElement("playedBy", mediaCharacter.getReferences());
        assertFalse((Boolean) xtend.call("isInverse", new Object[] { playedByRef }));
        assertEquals("MEDIA_CHR_PLAYED_BY", xtend.call("getManyToManyJoinTableName", new Object[] { playedByRef }));
        assertEquals("PLAYED_BY_PERSON_ID", playedByRef.getDatabaseColumn());
        assertEquals("PLAYED_BY_PERSON_ID", xtend.call("getForeignKeyName", new Object[] { playedByRef }));
        assertEquals("MEDIA_CHR_ID", xtend.call("getOppositeForeignKeyName", new Object[] { playedByRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(playedByRef);
        assertEquals("MEDIA_CHR_PLAYED_BY", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "playedBy", "mediaCharacter");
        Reference manyToManyObjectPlayedByRef = (Reference) getNamedElement("playedBy", manyToManyObject
                .getReferences());
        assertEquals("PLAYED_BY_PERSON_ID", manyToManyObjectPlayedByRef.getDatabaseColumn());
        Reference manyToManyObjectMediaCharacterRef = (Reference) getNamedElement("mediaCharacter", manyToManyObject
                .getReferences());
        assertEquals("MEDIA_CHR_ID", manyToManyObjectMediaCharacterRef.getDatabaseColumn());
    }

    @Test
    public void assertReferenceToPersonFromMediaCharacter() throws Exception {
        ValueObject mediaCharacter = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        Reference personsRef = (Reference) getNamedElement("persons", mediaCharacter.getReferences());
        assertFalse((Boolean) xtend.call("isInverse", new Object[] { personsRef }));
        assertEquals("MEDIA_CHR_PERSON", xtend.call("getManyToManyJoinTableName", new Object[] { personsRef }));
        assertEquals("PERSON_ID", personsRef.getDatabaseColumn());
        assertEquals("PERSON_ID", xtend.call("getForeignKeyName", new Object[] { personsRef }));
        assertEquals("MEDIA_CHR_ID", xtend.call("getOppositeForeignKeyName", new Object[] { personsRef }));

        DomainObject manyToManyObject = DatabaseGenerationHelper.createFictiveManyToManyObject(personsRef);
        assertEquals("MEDIA_CHR_PERSON", manyToManyObject.getDatabaseTable());
        assertOneAndOnlyOne(manyToManyObject.getReferences(), "person", "mediaCharacter");
        Reference manyToManyObjectPersonRef = (Reference) getNamedElement("person", manyToManyObject.getReferences());
        assertEquals("PERSON_ID", manyToManyObjectPersonRef.getDatabaseColumn());
        Reference manyToManyObjectMediaCharacterRef = (Reference) getNamedElement("mediaCharacter", manyToManyObject
                .getReferences());
        assertEquals("MEDIA_CHR_ID", manyToManyObjectMediaCharacterRef.getDatabaseColumn());
    }

    /**
     * Unidirectional to-many without join table
     */
    @Test
    public void assertReferenceToReviewFromMediaCharacter() throws Exception {
        ValueObject mediaCharacter = (ValueObject) getNamedElement("MediaCharacter", mediaModule().getDomainObjects());
        Reference reviewsRef = (Reference) getNamedElement("reviews", mediaCharacter.getReferences());
        assertTrue((Boolean) xtend.call("isInverse", new Object[] { reviewsRef }));
        assertEquals("MEDIA_CHR_ID", reviewsRef.getDatabaseColumn());
        assertEquals("MEDIA_CHR_ID", xtend.call("getOppositeForeignKeyName", new Object[] { reviewsRef }));
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

}
