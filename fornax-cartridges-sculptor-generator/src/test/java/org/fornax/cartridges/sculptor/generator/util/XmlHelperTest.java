package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import sculptormetamodel.Application;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

public class XmlHelperTest {
    
    @Test
    public void testToXmlName() {
        String name = "MyDomainObject";
        String xmlName = XmlHelper.toXmlName(name);
        assertEquals("my-domain-object", xmlName);
    }
    
    @Test
    public void testToXmlNameWithXmlPrefix() {
        String name = "XmlMyDomainObject";
        String xmlName = XmlHelper.toXmlName(name);
        assertEquals("my-domain-object", xmlName);
    }
    
    @Test
    public void testSchemaUrl() {
        SculptormetamodelFactory factory = SculptormetamodelFactoryImpl.eINSTANCE;
        Application app = factory.createApplication();
        app.setBasePackage("se.mycomp.aaa.bbb");
        app.setName("MyApp");
        String url = XmlHelper.schemaUrl(app);
        assertEquals("http://www.mycomp.se/myapp", url);
    }
    


}
