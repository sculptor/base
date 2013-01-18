package org.fornax.utilities.formatter.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlFormatter implements PostProcessor {

	private final Log log = LogFactory.getLog(getClass());

	// Some well known XML file extensions
	private String[] fileExtensions = new String[] { ".xml", ".xsl", ".xsd",
			".wsdd", ".wsdl" };

	/**
	 * Sets file extensions recognized as XML files
	 * @param fileExtensions A comma separated list of file extensions
	 */
	public void setFileExtensions(final String fileExtensions) {
		this.fileExtensions = fileExtensions.split(",");
		for (int i=0; i<this.fileExtensions.length; i++)
			this.fileExtensions[i] = this.fileExtensions[i].trim();
	}

	public void beforeWriteAndClose(final FileHandle info) {
		if (isXmlFile(info.getTargetFile().getAbsolutePath())) {
			try {
				final SAXReader reader = new SAXReader();
				reader.setValidation(false);
				reader.setIncludeExternalDTDDeclarations(false);
				reader.setIncludeInternalDTDDeclarations(true);
				reader.setEntityResolver(new EntityResolver() {

					public InputSource resolveEntity(final String publicId,
							final String systemId) throws SAXException,
							IOException {
						return new InputSource(new ByteArrayInputStream(
								"<!--DUMMY -->".getBytes()));
					}
				});
				final Document document = reader.read(new StringReader(info
						.getBuffer().toString().trim()));
				final StringWriter sw = new StringWriter();
				final OutputFormat format = OutputFormat.createPrettyPrint();
				final XMLWriter writer = new XMLWriter(sw, format);
				writer.write(document);
				info.setBuffer(sw.getBuffer());
			} catch (final Exception e) {
				log.error(e.getMessage(), e);
			}
		}

	}

	public boolean isXmlFile(final String absolutePath) {
		for (int i = 0; i < fileExtensions.length; i++) {
			if (absolutePath.endsWith(fileExtensions[i].trim()))
				return true;
		}
		return false;
	}

	public void afterClose(final FileHandle impl) {
		// do nothing here
	}

}
