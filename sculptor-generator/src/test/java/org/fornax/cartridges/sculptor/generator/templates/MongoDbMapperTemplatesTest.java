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

public class MongoDbMapperTemplatesTest extends TemplateTestBase {

    private static Application app;

    private static String libraryBuilderCode;

    private static Module mediaModule() {
        return (Module) getNamedElement("media", app.getModules());
    }

    @BeforeClass
    public static void before() throws Exception {
    	
            System.setProperty("project.nature", "business-tier, rcp");
            System.setProperty("datetime.library", "joda");
            System.setProperty("gui.createDefaults", "false");
            System.setProperty("nosql.provider", "mongoDb");
            
            initWorkflowContext("workflow-test-library-mongodb.mwe");
            app = (Application) ctx.get("transformedModel");

            XpandUnit.initXpand(new EmfRegistryMetaModel());
    }
    
    @BeforeClass
    public static void generateFile() throws IOException {
    	Entity book = (Entity)getNamedElement("Book", mediaModule().getDomainObjects());
    	Assert.assertNotNull(book);
    	
        XpandUnit.xpand("templates::mongodb::MongoDbMapper::mongoDbMapper", book,
                new HashMap<String, Object>(), getXpandTempDir());
        
        libraryBuilderCode = getFileText("org/fornax/cartridges/sculptor/examples/library/media/mapper/BookMapper.java");

    }

    @AfterClass
    public static void after() {
            System.getProperties().remove("project.nature");
            System.getProperties().remove("datetime.library");
            System.getProperties().remove("gui.createDefaults");
            System.getProperties().remove("nosql.provider");
    }

	
    @Test
    public void assertToDataInheritedOneManyAssoc() {
    	assertContainsConsecutiveFragments(libraryBuilderCode, new String[] {
    			"java.util.List<com.mongodb.DBObject> engagementsData = new java.util.ArrayList<com.mongodb.DBObject>();",
    			"for (org.fornax.cartridges.sculptor.examples.library.media.domain.Engagement each : from.getEngagements()) {",
    			"engagementsData.add(org.fornax.cartridges.sculptor.examples.library.media.mapper.EngagementMapper.getInstance().toData(each));"
        	});
//    	assertContains(libraryBuilderCode, "public LibraryBuilder addMedia(org.fornax.cartridges.sculptor.examples.library.media.domain.PhysicalMedia mediaElement) {");
    }

}
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

public class MongoDbMapperTemplatesTest extends TemplateTestBase {

    private static Application app;

    private static String libraryBuilderCode;

    private static Module mediaModule() {
        return (Module) getNamedElement("media", app.getModules());
    }

    @BeforeClass
    public static void before() throws Exception {
    	
            System.setProperty("project.nature", "business-tier, rcp");
            System.setProperty("datetime.library", "joda");
            System.setProperty("gui.createDefaults", "false");
            System.setProperty("nosql.provider", "mongoDb");
            
            initWorkflowContext("workflow-test-library-mongodb.mwe");
            app = (Application) ctx.get("transformedModel");

            XpandUnit.initXpand(new EmfRegistryMetaModel());
    }
    
    @BeforeClass
    public static void generateFile() throws IOException {
    	Entity book = (Entity)getNamedElement("Book", mediaModule().getDomainObjects());
    	Assert.assertNotNull(book);
    	
        XpandUnit.xpand("templates::mongodb::MongoDbMapper::mongoDbMapper", book,
                new HashMap<String, Object>(), getXpandTempDir());
        
        libraryBuilderCode = getFileText("org/fornax/cartridges/sculptor/examples/library/media/mapper/BookMapper.java");

    }

    @AfterClass
    public static void after() {
            System.getProperties().remove("project.nature");
            System.getProperties().remove("datetime.library");
            System.getProperties().remove("gui.createDefaults");
            System.getProperties().remove("nosql.provider");
    }

	
    @Test
    public void assertToDataInheritedOneManyAssoc() {
    	assertContainsConsecutiveFragments(libraryBuilderCode, new String[] {
    			"java.util.List<com.mongodb.DBObject> engagementsData = new java.util.ArrayList<com.mongodb.DBObject>();",
    			"for (org.fornax.cartridges.sculptor.examples.library.media.domain.Engagement each : from.getEngagements()) {",
    			"engagementsData.add(org.fornax.cartridges.sculptor.examples.library.media.mapper.EngagementMapper.getInstance().toData(each));"
        	});
//    	assertContains(libraryBuilderCode, "public LibraryBuilder addMedia(org.fornax.cartridges.sculptor.examples.library.media.domain.PhysicalMedia mediaElement) {");
    }

}
