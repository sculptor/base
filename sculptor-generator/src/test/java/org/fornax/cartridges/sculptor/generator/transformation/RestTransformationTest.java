package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.DomainObject;
import sculptormetamodel.HttpMethod;
import sculptormetamodel.Module;
import sculptormetamodel.Parameter;
import sculptormetamodel.Resource;
import sculptormetamodel.ResourceOperation;

public class RestTransformationTest extends TransformationTestBase {

    private static Application app;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-rest.mwe");
        app = (Application) ctx.get("transformedModel");
    }

    private Module module() {
        return (Module) getNamedElement("module1", app.getModules());
    }

    @Test
    public void assertPersonCreateForm() {
        Resource person = personResource();

        ResourceOperation createForm = (ResourceOperation) getNamedElement("createForm", person.getOperations());
        assertEquals("String", createForm.getType());
        assertEquals(HttpMethod.GET_LITERAL, createForm.getHttpMethod());
        assertEquals("/person/form", createForm.getPath());
        assertEquals("person/create", createForm.getReturnString());
        assertOneAndOnlyOne(createForm.getParameters(), "modelMap");
    }

    @Test
    public void assertPersonUpdateForm() {
        Resource person = personResource();

        ResourceOperation updateForm = (ResourceOperation) getNamedElement("updateForm", person.getOperations());
        assertEquals("String", updateForm.getType());
        assertEquals(HttpMethod.GET_LITERAL, updateForm.getHttpMethod());
        assertEquals("/person/{id}/form", updateForm.getPath());
        assertEquals("person/update", updateForm.getReturnString());
        assertOneAndOnlyOne(updateForm.getParameters(), "id", "modelMap");
    }

    @Test
    public void assertPersonFindById() {
        Resource person = personResource();

        ResourceOperation findById = (ResourceOperation) getNamedElement("findById", person.getOperations());
        assertEquals(HttpMethod.GET_LITERAL, findById.getHttpMethod());
        assertEquals("/person/{id}", findById.getPath());
        assertEquals("person/show", findById.getReturnString());
        assertOneAndOnlyOne(findById.getParameters(), "modelMap");
    }

    @Test
    public void assertPersonFindAll() {
        Resource person = personResource();

        ResourceOperation findAll = (ResourceOperation) getNamedElement("findAll", person.getOperations());
        // TODO
        // assertEquals("String", findAll.getType());
        assertEquals(HttpMethod.GET_LITERAL, findAll.getHttpMethod());
        assertEquals("/person", findAll.getPath());
        assertEquals("person/showlist", findAll.getReturnString());
        assertOneAndOnlyOne(findAll.getParameters(), "modelMap");
    }

    @Test
    public void assertPersonCreate() {
        Resource person = personResource();

        ResourceOperation create = (ResourceOperation) getNamedElement("create", person.getOperations());
        assertEquals(HttpMethod.POST_LITERAL, create.getHttpMethod());
        assertEquals("/person", create.getPath());
        assertEquals("redirect:/rest/person/{id}", create.getReturnString());
        assertOneAndOnlyOne(create.getParameters(), "entity");
        assertOneAndOnlyOne(create.getDelegate().getParameters(), "ctx", "entity");

    }

    @Test
    public void assertPersonUpdate() {
        Resource person = personResource();

        ResourceOperation update = (ResourceOperation) getNamedElement("update", person.getOperations());
        assertEquals(HttpMethod.PUT_LITERAL, update.getHttpMethod());
        assertEquals("/person", update.getPath());
        assertEquals("redirect:/rest/person/{id}", update.getReturnString());
    }

    @Test
    public void assertPersonDelete() {
        Resource person = personResource();

        ResourceOperation delete = (ResourceOperation) getNamedElement("delete", person.getOperations());
        assertEquals(HttpMethod.DELETE_LITERAL, delete.getHttpMethod());
        assertEquals("/person/{id}", delete.getPath());
        assertEquals("redirect:/rest/person", delete.getReturnString());
    }

    private Resource personResource() {
        Resource person = (Resource) getNamedElement("PersonResource", module().getResources());
        assertNotNull(person);
        return person;
    }

    private Resource customerResource() {
        Resource customer = (Resource) getNamedElement("CustomerResource", module().getResources());
        assertNotNull(customer);
        return customer;
    }

    @Test
    public void assertFooBarResource() {
        Resource foobar = (Resource) getNamedElement("FooBarResource", module().getResources());
        assertNotNull(foobar);

        ResourceOperation foo = (ResourceOperation) getNamedElement("foo", foobar.getOperations());
        assertEquals(HttpMethod.GET_LITERAL, foo.getHttpMethod());
        assertEquals("/fooBar", foo.getPath());

        ResourceOperation bar = (ResourceOperation) getNamedElement("bar", foobar.getOperations());
        assertEquals(HttpMethod.POST_LITERAL, bar.getHttpMethod());
        assertEquals("/fooBar/baz", bar.getPath());

    }

    @Test
    public void assertCustomerScaffold() {
        Resource customer = customerResource();

        assertOneAndOnlyOne(customer.getOperations(), "createForm", "create", "show", "showAll", "delete");

        ResourceOperation delete = (ResourceOperation) getNamedElement("delete", customer.getOperations());
        assertNotNull(delete.getDelegate());
        assertEquals("/customer/{id}", delete.getPath());
        assertEquals("redirect:/rest/customer", delete.getReturnString());

        ResourceOperation createForm = (ResourceOperation) getNamedElement("createForm", customer.getOperations());
        assertNull(createForm.getDelegate());
        ResourceOperation save = (ResourceOperation) getNamedElement("create", customer.getOperations());
        assertNotNull(save.getDelegate());

        assertTrue(customer.isGapClass());
    }

    @Test
    public void assertXmlRoot() {
        Resource foobar = (Resource) getNamedElement("FooBarResource", module().getResources());
        ResourceOperation something = (ResourceOperation) getNamedElement("something", foobar.getOperations());
        Parameter p = (Parameter) something.getParameters().get(0);
        DomainObject someDto = p.getDomainObjectType();
        assertEquals("xmlRoot=true", someDto.getHint());
    }

}
