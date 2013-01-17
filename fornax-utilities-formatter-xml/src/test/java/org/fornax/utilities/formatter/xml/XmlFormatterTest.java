package org.fornax.utilities.formatter.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.fornax.utilities.formatter.xml.XmlFormatter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.FileHandleImpl;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.internal.xpand2.pr.util.FSIO;


public class XmlFormatterTest {
	@Test
    public void testIsXmlFile() {
        final XmlFormatter b = new XmlFormatter();
        b.setFileExtensions(".foo, .bar" );

        assertTrue(b.isXmlFile("happe/bappe.foo"));
        assertFalse(b.isXmlFile("happe/bappe.xml"));
        assertTrue(b.isXmlFile("happe/bappe.bar"));
    }
    
	@Test
    public void testBeautifyIso88591 () {
    	final XmlFormatter b = new XmlFormatter();
    	final Outlet outlet = new Outlet ();
    	outlet.setFileEncoding ("iso-8859-1");
    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
    	
    	fh.setBuffer (readInput("test_iso-8859-1.xml", "iso-8859-1"));
    	b.beforeWriteAndClose(fh);
    	String formatted = fh.getBuffer().toString().replace (" standalone=\"no\"", ""); 

    	assertTrue (formatted.startsWith("<?xml version"));
    	// do the actual check without the header line because that depends on the JDK version
    	assertEquals (withoutFirstLine(readInput("test_iso-8859-1_beautified.xml", "iso-8859-1")), withoutFirstLine(formatted));
    }

	@Test
    public void testBeautifyIso88591WithHeader () {
    	final XmlFormatter b = new XmlFormatter();
    	final Outlet outlet = new Outlet ();
    	outlet.setFileEncoding ("iso-8859-1");
    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
    	
    	fh.setBuffer (readInput("test_iso-8859-1_header.xml", outlet.getFileEncoding()));
    	b.beforeWriteAndClose(fh);
    	String formatted = fh.getBuffer().toString().replace (" standalone=\"no\"", ""); 
    	
    	assertTrue (fh.getBuffer().toString().startsWith("<?xml version"));
    	// do the actual check without the header line because that depends on the JDK version
    	assertEquals (withoutFirstLine(readInput("test_iso-8859-1_beautified.xml", "iso-8859-1")), withoutFirstLine(formatted));
    }
    
	@Test
    public void testBeautifyUtf8 () {
    	final XmlFormatter b = new XmlFormatter();
    	final Outlet outlet = new Outlet ();
    	outlet.setFileEncoding ("utf-8");
    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
    	
    	fh.setBuffer (readInput("test_utf8.xml", "utf8"));
    	b.beforeWriteAndClose(fh);
    	String formatted = fh.getBuffer().toString().replace (" standalone=\"no\"", ""); 
    	
    	assertTrue (fh.getBuffer().toString().startsWith("<?xml version"));
    	// do the actual check without the header line because that depends on the JDK version
    	assertEquals (withoutFirstLine(readInput("test_utf8_beautified.xml", "utf8")), withoutFirstLine(formatted));
    }
    
	@Test
    public void testBeautifyUtf8WithHeader () {
    	final XmlFormatter b = new XmlFormatter();
    	final Outlet outlet = new Outlet ();
    	outlet.setFileEncoding ("utf-8");
    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
    	
    	fh.setBuffer (readInput("test_utf8_header.xml", "utf8"));
    	b.beforeWriteAndClose(fh);
    	String formatted = fh.getBuffer().toString().replace (" standalone=\"no\"", ""); 
    	
    	assertTrue (fh.getBuffer().toString().startsWith("<?xml version"));
    	// do the actual check without the header line because that depends on the JDK version
    	assertEquals (withoutFirstLine(readInput("test_utf8_beautified.xml", "utf8")), withoutFirstLine(formatted));
    }
    
	@Test
    public void testBeautifyDefaultEncoding () {
    	final XmlFormatter b = new XmlFormatter();
    	final Outlet outlet = new Outlet ();
    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
    	
    	fh.setBuffer (readInput("test_defaultEncoding.xml", "utf8"));
    	b.beforeWriteAndClose(fh);
    	String formatted = fh.getBuffer().toString().replace (" standalone=\"no\"", ""); 
    	assertTrue (fh.getBuffer().toString().startsWith("<?xml version"));
    	
    	// do the actual check without the header line because that depends on the JDK version
    	assertEquals (readInput("test_defaultEncoding_beautified.xml", "utf8"), withoutFirstLine(formatted));
    }

    @Test
    public void testBug193113 () throws Exception {
    	final XmlFormatter b = new XmlFormatter();
    	final Outlet outlet = new Outlet ();
    	outlet.setFileEncoding ("utf-8");
    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
    	
    	fh.setBuffer (readInput("bug193113_input.xml", "utf8"));
    	b.beforeWriteAndClose(fh);
    	String output = fh.getBuffer().toString();
    	
    	assertTrue("DOCTYPE got lost: "+output, output.contains("DOCTYPE hibernate-mapping"));
    }
    
//    @Test
//    public void testBug175488 () throws Exception {
//    	final XmlFormatter b = new XmlFormatter();
//    	final Outlet outlet = new Outlet ();
//    	outlet.setFileEncoding ("utf-8");
//    	final FileHandle fh = new FileHandleImpl (outlet, new File ("a.xml"));
//    	
//    	fh.setBuffer (readInput("bug175488_input.xml", "utf8"));
//    	String expected = readInput("bug175488_beautified.xml", "utf8");
//    	b.beforeWriteAndClose(fh);
//    	String output = fh.getBuffer().toString();
//
//    	assertEquals(expected, output);
//    }
    
    private String readInput (String filename, String encoding) {
    	try {
	    	Reader r = new InputStreamReader(getClass().getResourceAsStream(filename), encoding);
	    	StringWriter w = new StringWriter();
			FSIO.writeSingleFile(w, r);
			return w.getBuffer().toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
    private String withoutFirstLine (String s) {
    	return s.substring(s.indexOf("\n")+1);    	
    }
}
