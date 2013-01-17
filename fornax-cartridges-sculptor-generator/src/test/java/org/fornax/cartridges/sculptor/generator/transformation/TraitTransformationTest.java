package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.DomainObjectOperation;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Trait;

public class TraitTransformationTest extends TransformationTestBase {

    private static Application app;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-trait.mwe");
        app = (Application) ctx.get("transformedModel");
    }

    private Module module() {
        return (Module) getNamedElement("catalog", app.getModules());
    }

    @Test
    public void assertProduct() {
        Trait product = (Trait) getNamedElement("Product", module().getDomainObjects());

        assertOneAndOnlyOne(product.getAttributes(), "title");
        assertOneAndOnlyOne(product.getOperations(), "price", "priceFactor", "getTitle", "setTitle");

        DomainObjectOperation price = (DomainObjectOperation) getNamedElement("price", product.getOperations());
        assertSame(product, price.getDomainObject());

        DomainObjectOperation priceFactor = (DomainObjectOperation) getNamedElement("priceFactor",
                product.getOperations());
        assertTrue(priceFactor.isAbstract());

        DomainObjectOperation getTitle = (DomainObjectOperation) getNamedElement("getTitle", product.getOperations());
        assertEquals("public", getTitle.getVisibility());
        assertSame(product, getTitle.getDomainObject());
        assertEquals("String", getTitle.getType());
    }

    @Test
    public void assertProductMixin() {
        Entity movie = (Entity) getNamedElement("Movie", module().getDomainObjects());

        assertOneAndOnlyOne(movie.getAttributes(), "title", "urlIMDB", "playLength");
        assertOneAndOnlyOne(movie.getOperations(), "price", "priceFactor");

        Attribute title = (Attribute) getNamedElement("title", movie.getAttributes());
        assertEquals("trait=Product", title.getHint());

        DomainObjectOperation price = (DomainObjectOperation) getNamedElement("price", movie.getOperations());
        assertEquals("trait=Product", price.getHint());
        assertFalse(price.isAbstract());
        assertSame(movie, price.getDomainObject());

        DomainObjectOperation priceFactor = (DomainObjectOperation) getNamedElement("priceFactor",
                movie.getOperations());
        assertEquals("trait=Product", price.getHint());
        assertTrue(priceFactor.isAbstract());

        assertTrue(movie.isGapClass());

    }

    @Test
    public void shouldRecognizeExistingPropertiesAndOperations() {
        Entity qwerty = (Entity) getNamedElement("Qwerty", module().getDomainObjects());
        assertOneAndOnlyOne(qwerty.getAttributes(), "qqq", "www", "eee", "ddd");
        assertOneAndOnlyOne(qwerty.getOperations(), "getAaa", "spellCheck", "somethingElse");
    }

    @Test
    public void shouldMixinSeveralTraitsInOrder() {
        Entity abc = (Entity) getNamedElement("Abc", module().getDomainObjects());
        assertOneAndOnlyOne(abc.getAttributes(), "aaa", "bbb", "ccc", "ddd", "eee");
        assertOneAndOnlyOne(abc.getOperations(), "aha", "boom", "caboom", "ding", "eeh");

        assertEquals("Bcd", ((Trait) abc.getTraits().get(0)).getName());
        assertEquals("Cde", ((Trait) abc.getTraits().get(1)).getName());

        DomainObjectOperation aha = (DomainObjectOperation) getNamedElement("aha", abc.getOperations());
        assertNull(aha.getHint());

        DomainObjectOperation boom = (DomainObjectOperation) getNamedElement("boom", abc.getOperations());
        assertNull(boom.getHint());

        DomainObjectOperation caboom = (DomainObjectOperation) getNamedElement("caboom", abc.getOperations());
        assertEquals("trait=Bcd", caboom.getHint());

        DomainObjectOperation ding = (DomainObjectOperation) getNamedElement("ding", abc.getOperations());
        assertEquals("trait=Cde", ding.getHint());

        DomainObjectOperation eeh = (DomainObjectOperation) getNamedElement("eeh", abc.getOperations());
        assertEquals("trait=Cde", eeh.getHint());
    }

    @Test
    public void shouldAssignGapFromOperations() {
        Entity e1 = (Entity) getNamedElement("Ent1", module().getDomainObjects());
        assertTrue(e1.isGapClass());

        Entity e2 = (Entity) getNamedElement("Ent2", module().getDomainObjects());
        assertFalse(e2.isGapClass());
    }

    @Test
    public void shouldAssignGapFromTraitOperations() {
        Entity e3 = (Entity) getNamedElement("Ent3", module().getDomainObjects());
        assertFalse(e3.isGapClass());

        Entity e4 = (Entity) getNamedElement("Ent4", module().getDomainObjects());
        assertTrue(e4.isGapClass());
    }

}
