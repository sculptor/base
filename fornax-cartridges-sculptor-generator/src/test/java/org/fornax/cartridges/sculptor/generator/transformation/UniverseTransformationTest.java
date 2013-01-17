package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.Attribute;
import sculptormetamodel.Consumer;
import sculptormetamodel.Entity;
import sculptormetamodel.Module;
import sculptormetamodel.Repository;
import sculptormetamodel.Service;
import sculptormetamodel.ValueObject;

public class UniverseTransformationTest extends TransformationTestBase {

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-universe.mwe");
    }

    @Test
    public void assertApplication() {
        Application application = (Application) ctx.get("transformedModel");
        assertEquals("Universe", application.getName());
        EList modules = application.getModules();
        assertNotNull(modules);
        assertEquals(1, modules.size());
        assertModules(modules);
    }

    @SuppressWarnings("unchecked")
    protected void assertModules(EList modules) {
        assertOneAndOnlyOne(modules, "milkyway");
        assertMilkyWayModule((Module) modules.get(0));
    }

    private void assertMilkyWayModule(Module module) {
        // domain objects
        assertOneAndOnlyOne(module.getDomainObjects(), "Planet", "Moon", "MoonMessage", "PlanetMessage", "XmlMoon");
        assertPlanet((Entity) getNamedElement("Planet", module.getDomainObjects()));
        assertMoon((Entity) getNamedElement("Moon", module.getDomainObjects()));
        assertMoonMessage((ValueObject) getNamedElement("MoonMessage", module.getDomainObjects()));
        assertPlanetMessage((ValueObject) getNamedElement("PlanetMessage", module.getDomainObjects()));
        assertXmlMoon((ValueObject) getNamedElement("XmlMoon", module.getDomainObjects()));
        // services
        assertOneAndOnlyOne(module.getServices(), "PlanetService");
        assertPlanetService((Service) module.getServices().get(0));

        // consumers
        assertOneAndOnlyOne(module.getConsumers(), "PlanetConsumer", "MoonConsumer");
        assertPlanetConsumer((Consumer) getNamedElement("PlanetConsumer", module.getConsumers()));
        assertMoonConsumer((Consumer) getNamedElement("MoonConsumer", module.getConsumers()));
    }

    private void assertMoonConsumer(Consumer moonConsumer) {
        assertEquals("MoonConsumer", moonConsumer.getName());
        assertEquals("MoonMessage", moonConsumer.getMessageRoot().getName());
        assertEquals("milkyway", moonConsumer.getModule().getName());
        assertEquals(0, moonConsumer.getOtherDependencies().size());
        assertEquals(1, moonConsumer.getRepositoryDependencies().size());
        assertEquals("PlanetRepository", ((Repository) moonConsumer.getRepositoryDependencies().get(0)).getName());
        assertNull(moonConsumer.getChannel());
        assertEquals(0, moonConsumer.getServiceDependencies().size());
    }

    private void assertPlanetConsumer(Consumer planetConsumer) {
        assertEquals("PlanetConsumer", planetConsumer.getName());
        assertEquals("PlanetMessage", planetConsumer.getMessageRoot().getName());
        assertEquals("milkyway", planetConsumer.getModule().getName());
        assertEquals(0, planetConsumer.getOtherDependencies().size());
        assertEquals(1, planetConsumer.getRepositoryDependencies().size());
        assertEquals("PlanetRepository", ((Repository) planetConsumer.getRepositoryDependencies().get(0)).getName());
        assertNull(planetConsumer.getChannel());
        assertEquals(0, planetConsumer.getServiceDependencies().size());
    }

    private void assertPlanetService(Service service) {
        assertEquals("PlanetService", service.getName());
        assertEquals("milkyway", service.getModule().getName());
        assertOneAndOnlyOne(service.getOperations(), "sayHello", "findByExample", "getPlanet", "findById", "findAll",
                "save", "delete");
        assertEquals(0, service.getOtherDependencies().size());
        assertEquals(0, service.getRepositoryDependencies().size());

    }

    private void assertPlanet(Entity planet) {
        assertEquals("Planet", planet.getName());
        assertFalse(planet.isAbstract());
        assertTrue(planet.isAggregateRoot());
        assertEquals(planet, planet.getBelongsToAggregate());
        assertTrue(planet.isAuditable());
        assertFalse(planet.isCache());
        assertTrue(planet.isOptimisticLocking());
        assertEquals("PLANET", planet.getDatabaseTable());
        assertEquals("milkyway", planet.getModule().getName());
        assertNull(planet.getExtends());

        assertOneAndOnlyOne(planet.getAttributes(), "name", "message", "diameter", "population");
        assertOneAndOnlyOne(planet.getReferences(), "moons");
        assertPlanetRepository(planet.getRepository());
        assertAttribute((Attribute) getNamedElement("name", planet.getAttributes()), "String", false, false, false,
                true);
        assertAttribute((Attribute) getNamedElement("message", planet.getAttributes()), "String", true, false, false,
                false);
        assertAttribute((Attribute) getNamedElement("diameter", planet.getAttributes()), "Integer", true, true, false,
                false);
        assertAttribute((Attribute) getNamedElement("population", planet.getAttributes()), "Integer", true, true,
                false, false);

    }

    private void assertMoon(Entity moon) {
        assertEquals("Moon", moon.getName());
        assertFalse(moon.isAbstract());
        assertFalse(moon.isAggregateRoot());
        Entity planet = (Entity) getNamedElement("Planet", moon.getModule().getDomainObjects());
        assertEquals(planet, moon.getBelongsToAggregate());
        assertTrue(moon.isAuditable());
        assertFalse(moon.isCache());
        assertTrue(moon.isOptimisticLocking());
        assertEquals("MOON", moon.getDatabaseTable());
        assertEquals("milkyway", moon.getModule().getName());
        assertNull(moon.getExtends());

        assertOneAndOnlyOne(moon.getAttributes(), "name", "diameter");
        assertOneAndOnlyOne(moon.getReferences(), "planet");
        assertAttribute((Attribute) getNamedElement("name", moon.getAttributes()), "String", false, false, false, true);
        assertAttribute((Attribute) getNamedElement("diameter", moon.getAttributes()), "Integer", true, true, false,
                false);
    }

    private void assertPlanetMessage(ValueObject planetMessage) {
        assertFalse(planetMessage.isAbstract());
        assertFalse(planetMessage.isCache());
        assertTrue(planetMessage.isImmutable());
        assertTrue(planetMessage.isOptimisticLocking());
        assertFalse(planetMessage.isPersistent());
        assertNull(planetMessage.getRepository());
        assertOneAndOnlyOne(planetMessage.getReferences(), "planets");
    }

    private void assertMoonMessage(ValueObject moonMessage) {
        assertFalse(moonMessage.isAbstract());
        assertFalse(moonMessage.isCache());
        assertTrue(moonMessage.isImmutable());
        assertTrue(moonMessage.isOptimisticLocking());
        assertFalse(moonMessage.isPersistent());
        assertNull(moonMessage.getRepository());
        assertOneAndOnlyOne(moonMessage.getReferences(), "moons");
    }

    private void assertXmlMoon(ValueObject xmlMoon) {
        assertOneAndOnlyOne(xmlMoon.getAttributes(), "name", "planetName");
        assertFalse(xmlMoon.isAbstract());
        assertFalse(xmlMoon.isCache());
        assertFalse(xmlMoon.isImmutable());
        assertTrue(xmlMoon.isOptimisticLocking());
        assertFalse(xmlMoon.isPersistent());
        assertEquals(0, xmlMoon.getReferences().size());
        assertNull(xmlMoon.getRepository());
    }

    private void assertPlanetRepository(Repository repository) {
        assertOneAndOnlyOne(repository.getOperations(), "findById", "findAll", "delete", "findByExample", "findByKeys",
                "save");
        assertEquals("Planet", repository.getAggregateRoot().getName());
        assertEquals("PlanetRepository", repository.getName());
        assertEquals(0, repository.getOtherDependencies().size());
        assertEquals(0, repository.getRepositoryDependencies().size());
    }

    private void assertAttribute(Attribute attribute, String type, boolean changeable, boolean nullable,
            boolean required, boolean key) {
        assertEquals(type, attribute.getType());
        assertEquals(changeable, attribute.isChangeable());
        assertEquals(nullable, attribute.isNullable());
        assertEquals(required, attribute.isRequired());
        assertEquals(key, attribute.isNaturalKey());
    }

}
