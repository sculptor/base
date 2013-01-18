package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.DiscriminatorType;
import sculptormetamodel.Entity;
import sculptormetamodel.InheritanceType;
import sculptormetamodel.Module;

public class InheritanceTransformationTest extends TransformationTestBase {

    private static Application app;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-inheritance.mwe");
        app = (Application) ctx.get("transformedModel");
    }

    private Module module(int number) {
        return (Module) getNamedElement("module" + number, app.getModules());
    }

    @Test
    public void assertPerson1() {
        Entity person = (Entity) getNamedElement("Person1", module(1).getDomainObjects());
        assertNull(person.getInheritance());
        assertNull(person.getDiscriminatorColumnValue());
    }

    @Test
    public void assertMedia1() {
        Entity media = (Entity) getNamedElement("Media1", module(1).getDomainObjects());
        assertNotNull(media.getInheritance());
        assertEquals(InheritanceType.JOINED, media.getInheritance().getType().getValue());
        assertNull(media.getInheritance().getDiscriminatorColumnName());
        assertNull(media.getInheritance().getDiscriminatorColumnLength());
        assertEquals(DiscriminatorType.STRING, media.getInheritance().getDiscriminatorType().getValue());
    }

    @Test
    public void assertBook1() {
        Entity book = (Entity) getNamedElement("Book1", module(1).getDomainObjects());
        assertNull(book.getInheritance());
        assertNull(book.getDiscriminatorColumnValue());
    }

    @Test
    public void assertMedia2() {
        Entity media = (Entity) getNamedElement("Media2", module(2).getDomainObjects());
        assertNotNull(media.getInheritance());
        assertEquals(InheritanceType.SINGLE_TABLE, media.getInheritance().getType().getValue());
        assertNull(media.getInheritance().getDiscriminatorColumnName());
        assertEquals(DiscriminatorType.STRING, media.getInheritance().getDiscriminatorType().getValue());
        assertNull(media.getInheritance().getDiscriminatorColumnLength());
    }

    @Test
    public void assertMovie2() {
        Entity movie = (Entity) getNamedElement("Movie2", module(2).getDomainObjects());
        assertEquals("M2", movie.getDiscriminatorColumnValue());
    }

    @Test
    public void assertMedia3() {
        Entity media = (Entity) getNamedElement("Media3", module(3).getDomainObjects());
        assertNotNull(media.getInheritance());
        assertEquals(InheritanceType.SINGLE_TABLE, media.getInheritance().getType().getValue());
        assertEquals("MEDIA_TYPE", media.getInheritance().getDiscriminatorColumnName());
        assertEquals(DiscriminatorType.CHAR, media.getInheritance().getDiscriminatorType().getValue());
        assertNull(media.getInheritance().getDiscriminatorColumnLength());
    }

    @Test
    public void assertMovie3() {
        Entity movie = (Entity) getNamedElement("Movie3", module(3).getDomainObjects());
        assertEquals("M", movie.getDiscriminatorColumnValue());
    }

    @Test
    public void assertBook4() {
        Entity book = (Entity) getNamedElement("Book4", module(4).getDomainObjects());
        assertEquals("B4", book.getDiscriminatorColumnValue());
        assertNull(book.getInheritance());
    }

}
