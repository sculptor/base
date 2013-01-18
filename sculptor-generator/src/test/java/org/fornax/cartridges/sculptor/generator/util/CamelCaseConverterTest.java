package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CamelCaseConverterTest {

    @Test
	public void testCamelCaseToWordsSimple() {
		String result = CamelCaseConverter.camelCaseToWords("CamelCase");
		assertEquals("Camel Case", result);
	}

    @Test
	public void testCamelCaseToWordsOneChar() {
		String result = CamelCaseConverter.camelCaseToWords("a");
		assertEquals("a", result);
	}

    @Test
	public void testCamelCaseToWordsTwoChars() {
		String result = CamelCaseConverter.camelCaseToWords("ab");
		assertEquals("ab", result);
	}

    @Test
	public void testCamelCaseToWordsThreeChars() {
		String result = CamelCaseConverter.camelCaseToWords("abc");
		assertEquals("abc", result);
		result = CamelCaseConverter.camelCaseToWords("aBc");
		assertEquals("a Bc", result);
		result = CamelCaseConverter.camelCaseToWords("abC");
		assertEquals("ab C", result);
	}

    @Test
	public void testCamelCaseToWordsSeveralUpper() {
		String result = CamelCaseConverter.camelCaseToWords("AbcDEF");
		assertEquals("Abc DEF", result);
		result = CamelCaseConverter.camelCaseToWords("AbcDEFefGh");
		assertEquals("Abc DE Fef Gh", result);
		result = CamelCaseConverter.camelCaseToWords("AbcDEFefGH");
		assertEquals("Abc DE Fef GH", result);
		result = CamelCaseConverter.camelCaseToWords("AbcDEFefGHi");
		assertEquals("Abc DE Fef G Hi", result);
	}

    @Test
    public void testCamelCaseTwice() {
        String result1 = CamelCaseConverter.camelCaseToWords("CamelCase");
        assertEquals("Camel Case", result1);
        String result2 = CamelCaseConverter.camelCaseToWords(result1);
        assertEquals(result1, result2);
    }

    @Test
    public void testCamelCaseFirstAlreadySeparator() {
        String result = CamelCaseConverter.camelCaseToWords(" CamelCase");
        assertEquals(" Camel Case", result);
    }

}
