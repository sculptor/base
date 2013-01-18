package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import sculptormetamodel.Attribute;
import sculptormetamodel.SculptormetamodelFactory;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

public class ValidateParserTest {
    private SculptormetamodelFactory factory;
    private Attribute attribute;

    @Before
    public void setUp() {
        // reload properties
        GeneratorProperties.initProperties(true);
        factory = SculptormetamodelFactoryImpl.eINSTANCE;
        attribute = factory.createAttribute();
    }

    @Test
    public void customLength() {
        attribute.setNullable(true);
        attribute.setValidate("@length(min=2, max=9)");
        String result = GenerationHelper.getValidationAnnotations(attribute);
        assertEquals("@org.hibernate.validator.constraints.Length(min=2, max=9)", result);
    }

    @Test
    public void customLengthFirstUpper() {
        attribute.setNullable(true);
        attribute.setValidate("@Length(min=2, max=9)");
        String result = GenerationHelper.getValidationAnnotations(attribute);
        assertEquals("@org.hibernate.validator.constraints.Length(min=2, max=9)", result);
    }

    @Test
    public void several() {
        attribute.setNullable(true);
        attribute.setValidate("@Length(min=2, max=9) @notEmpty");
        String result = GenerationHelper.getValidationAnnotations(attribute);
        assertEquals(
                "@org.hibernate.validator.constraints.Length(min=2, max=9) " +
        		"@org.hibernate.validator.constraints.NotEmpty",
        		result);
    }



}
