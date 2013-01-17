package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.junit.BeforeClass;
import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.CommandEvent;
import sculptormetamodel.Consumer;
import sculptormetamodel.DomainEvent;
import sculptormetamodel.Module;
import sculptormetamodel.Service;
import sculptormetamodel.ServiceOperation;

public class ShippingTransformationTest extends TransformationTestBase {

    private static Application app;
    private static XtendFacade xtend;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("workflow-test-shipping.mwe");
        app = (Application) ctx.get("transformedModel");

        EmfRegistryMetaModel metaModel = new EmfRegistryMetaModel();
        xtend = XtendFacade.create("extensions::helper", "extensions::dbhelper", "extensions::properties");
        xtend.registerMetaModel(metaModel);
    }

    private Module coreModule() {
        return (Module) getNamedElement("core", app.getModules());
    }

    private Module curiousModule() {
        return (Module) getNamedElement("curious", app.getModules());
    }

    private Module statisticsModule() {
        return (Module) getNamedElement("statistics", app.getModules());
    }

    @Test
    public void assertShipHasArrivedDomainEvent() {
        DomainEvent event = (DomainEvent) getNamedElement("ShipHasArrived", coreModule().getDomainObjects());
        assertOneAndOnlyOne(event.getReferences(), "port", "ship");
        assertFalse(event.isPersistent());
        String pkg = (String) xtend.call("getDomainPackage", new Object[] { event });
        assertEquals("org.sculptor.shipping.core.domain", pkg);
        assertOneAndOnlyOne(event.getAttributes(), "recorded", "occurred");
    }

    @Test
    public void assertRecordArrivalCommandEvent() {
        CommandEvent event = (CommandEvent) getNamedElement("RecordArrival", coreModule().getDomainObjects());
        assertOneAndOnlyOne(event.getReferences(), "port", "ship");
        assertFalse(event.isPersistent());
        String pkg = (String) xtend.call("getDomainPackage", new Object[] { event });
        assertEquals("org.sculptor.shipping.core.domain", pkg);
        assertOneAndOnlyOne(event.getAttributes(), "recorded", "occurred");
    }

    @Test
    public void assertInspectorConsumer() throws Exception {
        Consumer consumer = (Consumer) getNamedElement("Inspector", curiousModule().getConsumers());
        assertEquals("shippingChannel", consumer.getSubscribe().getTopic());
        assertEquals("extraBus", consumer.getSubscribe().getEventBus());
        assertEquals("shippingChannel", consumer.getChannel());
    }

    @Test
    public void assertStatisticsSubscriber() throws Exception {
        Service service = (Service) getNamedElement("Statistics", statisticsModule().getServices());
        assertEquals("statisticsChannel", service.getSubscribe().getTopic());
        assertNull(service.getSubscribe().getEventBus());
        ServiceOperation op = (ServiceOperation) getNamedElement("receive", service.getOperations());
        assertNotNull(op);
        assertOneAndOnlyOne(op.getParameters(), "event");
    }

    @Test
    public void assertPublishInReferenceDataService() throws Exception {
        Service service = (Service) getNamedElement("ReferenceDataService", coreModule().getServices());
        ServiceOperation op = (ServiceOperation) getNamedElement("saveShip", service.getOperations());
        assertNotNull(op.getPublish());
        assertEquals("shippingChannel", op.getPublish().getTopic());
        assertNotNull(op.getPublish().getEventType());
        assertEquals("SavedDomainObjectEvent", op.getPublish().getEventType().getName());
        assertNull(op.getPublish().getEventBus());
    }

    @Test
    public void assertPublishToCommandBus() throws Exception {
        Service service = (Service) getNamedElement("TrackingService", coreModule().getServices());
        ServiceOperation op = (ServiceOperation) getNamedElement("recordArrival2", service.getOperations());
        assertNotNull(op.getPublish());
        assertEquals("shippingProcessor", op.getPublish().getTopic());
        assertNotNull(op.getPublish().getEventType());
        assertEquals("RecordArrival", op.getPublish().getEventType().getName());
        assertEquals("commandBus", op.getPublish().getEventBus());
    }
}
