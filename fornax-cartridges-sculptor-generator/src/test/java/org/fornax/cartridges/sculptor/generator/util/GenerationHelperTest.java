package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenerationHelperTest {

    @Test
    public void testFormatJavaDocOneLine() {
        String doc = "Single line doc";
        String formattedDoc = GenerationHelper.formatJavaDoc(doc);
        assertEquals("/**\n" + " * Single line doc\n" + " */", formattedDoc);
    }

    @Test
    public void testFormatJavaDocEmpty() {
        String doc = "";
        String formattedDoc = GenerationHelper.formatJavaDoc(doc);
        assertEquals("", formattedDoc);
    }

    @Test
    public void testFormatJavaDocNull() {
        String doc = null;
        String formattedDoc = GenerationHelper.formatJavaDoc(doc);
        assertEquals("", formattedDoc);
    }

    @Test
    public void testFormatJavaDocMultiLine() {
        String doc = "Doc that \n spans over several \n  rows";
        String formattedDoc = GenerationHelper.formatJavaDoc(doc);
        assertEquals("/**\n" + " * Doc that\n" + " * spans over several\n" + " * rows\n" + " */", formattedDoc);
    }

    @Test
    public void testFormatAnnotationParametersEmpty() {
        List<Object> list = new ArrayList<Object>();
        list.add(false);
        list.add("aaa");
        list.add("111");

        String result = GenerationHelper.formatAnnotationParameters(list);
        assertEquals("", result);
    }

    @Test
    public void testFormatAnnotationParametersOne() {
        List<Object> list = new ArrayList<Object>();
        list.add(true);
        list.add("aaa");
        list.add("111");

        String result = GenerationHelper.formatAnnotationParameters(list);
        assertEquals("aaa=111", result);
    }

    @Test
    public void testFormatAnnotationParametersTwo() {
        List<Object> list = new ArrayList<Object>();
        list.add(true);
        list.add("aaa");
        list.add("\"zzz\"");
        list.add(false);
        list.add("bbb");
        list.add("222");
        list.add(true);
        list.add("ccc");
        list.add(Boolean.TRUE);

        String result = GenerationHelper.formatAnnotationParameters(list);
        assertEquals("aaa=\"zzz\", ccc=true", result);
    }

    @Test
    public void testFormatAnnotationParametersNoKey() {
        List<Object> list = new ArrayList<Object>();
        list.add(true);
        list.add("");
        list.add("111");
        list.add(true);
        list.add("");
        list.add("222");
        list.add(true);
        list.add("");
        list.add("333");

        String result = GenerationHelper.formatAnnotationParameters(list);
        assertEquals("111, 222, 333", result);
    }

    @Test
    public void testFormatAnnotationEmptyParameters() {
        List<Object> list = new ArrayList<Object>();
        list.add(false);
        list.add("aaa");
        list.add("111");

        String result = GenerationHelper.formatAnnotationParameters("@SomeAnnotation", list);
        assertEquals("", result);
    }

    @Test
    public void testFormatAnnotationOneParameter() {
        List<Object> list = new ArrayList<Object>();
        list.add(true);
        list.add("aaa");
        list.add("111");

        String result = GenerationHelper.formatAnnotationParameters("@SomeAnnotation", list);
        assertEquals("@SomeAnnotation(aaa=111)", result);
    }

    @Test
    public void testReplacePlaceholder() {
        String result = GenerationHelper.replacePlaceholder("/person/{id}", "{id}", "1234");
        assertEquals("/person/1234", result);
    }
}
