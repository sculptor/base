package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SingularPluralConverterTest {

    @Before
    public void setUp() {
        // reload properties
        GeneratorProperties.initProperties(true);
        SingularPluralConverter.init();
    }

    @Test
    public void testToPluralDefault() {
        String input = "cat";
        String result = SingularPluralConverter.toPlural(input);
        assertEquals("cats", result);
    }

    @Test
    public void testToSingularDefault() {
        String input = "cats";
        String result = SingularPluralConverter.toSingular(input);
        assertEquals("cat", result);
    }

    @Test
    public void testToPluralAlreadyPlural() {
        String input = "cats";
        String result = SingularPluralConverter.toPlural(input);
        assertEquals("cats", result);
    }

    @Test
    public void testToSingularAlreadySingular() {
        String input = "cat";
        String result = SingularPluralConverter.toSingular(input);
        assertEquals("cat", result);
    }

    @Test
    public void testToPluralSuffixY() {
        String input = "category";
        String result = SingularPluralConverter.toPlural(input);
        assertEquals("categories", result);
    }

    @Test
    public void testToSingularSuffixY() {
        String input = "categories";
        String result = SingularPluralConverter.toSingular(input);
        assertEquals("category", result);
    }

    @Test
    public void testToPluralSuffixSs() {
        String input = "address";
        String result = SingularPluralConverter.toPlural(input);
        assertEquals("addresses", result);
    }

    @Test
    public void testToSingularSuffixSs() {
        String input = "addresses";
        String result = SingularPluralConverter.toSingular(input);
        assertEquals("address", result);
    }

    @Test
    public void testToSingularAlreadySingularSuffixSs() {
        String input = "address";
        String result = SingularPluralConverter.toSingular(input);
        assertEquals("address", result);
    }

    @Test
    public void testToPluralSpecialLookup() {
        String input = "criterion";
        String result = SingularPluralConverter.toPlural(input);
        assertEquals("criteria", result);
    }

    @Test
    public void testToSingularSpecialLookup() {
        String input = "criteria";
        String result = SingularPluralConverter.toSingular(input);
        assertEquals("criterion", result);
    }



}
