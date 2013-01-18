package org.fornax.cartridges.sculptor.generator.templates;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.fornax.utilities.xtendtools.xunit.XpandUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;

public class BuilderTemplatesTest extends TemplateTestBase {

    private static Application app;

    private static String libraryBuilderCode;
    
    @BeforeClass
    public static void before() throws Exception {
    	
            System.setProperty("project.nature", "business-tier, rcp");
            System.setProperty("datetime.library", "joda");
            System.setProperty("gui.createDefaults", "false");
            
            initWorkflowContext("workflow-test-library.mwe");
            app = (Application) ctx.get("transformedModel");

            XpandUnit.initXpand(new EmfRegistryMetaModel());
    }
    
    @BeforeClass
    public static void generateFile() throws IOException {
    	Entity library = (Entity)getNamedElement("Library", mediaModule().getDomainObjects());
    	
        XpandUnit.xpand("templates::domain::Builder::builder", library,
                new HashMap<String, Object>(), getXpandTempDir());
        
        libraryBuilderCode = getFileText("org/fornax/cartridges/sculptor/examples/library/media/domain/LibraryBuilder.java");

    }

    @AfterClass
    public static void after() {
            System.getProperties().remove("project.nature");
            System.getProperties().remove("datetime.library");
            System.getProperties().remove("gui.createDefaults");
    }
    
    @Test
    public void assertPackageDeclaration() {
        assertContains(libraryBuilderCode, "package org.fornax.cartridges.sculptor.examples.library.media.domain;");
    }
    
    @Test
    public void assertDateAttribute() {
        assertContains(libraryBuilderCode, "private org.joda.time.DateTime createdDate;");    	
    }
    
    @Test
    public void assertAttributes() {
        assertContains(libraryBuilderCode, "private java.util.Set<org.fornax.cartridges.sculptor.examples.library.media.domain.PhysicalMedia> media = new java.util.HashSet<org.fornax.cartridges.sculptor.examples.library.media.domain.PhysicalMedia>();");

        assertContains(libraryBuilderCode, "org.fornax.cartridges.sculptor.examples.library.media.domain.Library obj = new Library(getName());");
    }
    
    @Test
    public void assertMultiRefAdder() {
    	assertContains(libraryBuilderCode, "public LibraryBuilder addMedia(org.fornax.cartridges.sculptor.examples.library.media.domain.PhysicalMedia mediaElement) {");
    }
    
    @Test
    public void assertInheritedManyRefs() throws IOException {
    	Entity book = (Entity)getNamedElement("Book", mediaModule().getDomainObjects());
    	
        XpandUnit.xpand("templates::domain::Builder::builder", book,
                new HashMap<String, Object>(), getXpandTempDir());
        
        String bookBuilderCode = getFileText("org/fornax/cartridges/sculptor/examples/library/media/domain/BookBuilder.java");
        
        Assert.assertNotNull(bookBuilderCode);
        
        assertContains(bookBuilderCode, "obj.getPhysicalMedia().addAll(physicalMedia);");

    }
    @Test
    public void testSetterWithDoc() {
        assertContainsConsecutiveFragments(libraryBuilderCode, new String[] {
        		"/**", 
        		"* Name of library", 
        		"*/",
        		"public LibraryBuilder name(String val) {",
        		"this.name = val;",
        		"return this;",
        		"}"});
    }
    
    @Test
    public void assertBuilder() {
    	assertContainsConsecutiveFragments(libraryBuilderCode, new String[] {
    			"public org.fornax.cartridges.sculptor.examples.library.media.domain.Library build() {",
    			"org.fornax.cartridges.sculptor.examples.library.media.domain.Library obj = new Library(getName());"
    	});
    	
    	assertNotContains(libraryBuilderCode, "setName");
    	
    }
    private static Module mediaModule() {
        return (Module) getNamedElement("media", app.getModules());
}
    
    
    
}
