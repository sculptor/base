package org.fornax.cartridges.sculptor.wizard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PomParser {

    private String artifactId;
    private String groupId;
    private String parentArtifactId;
    private String version;

    public PomParser(String xml) {
        parse(xml);

    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getParentArtifactId() {
        return parentArtifactId;
    }

    public String getVersion() {
        return version;
    }

    private void parse(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream in = new ByteArrayInputStream(xml.getBytes("ISO-8859-1"));
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node subnode = list.item(i);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    if (subnode.getNodeName().equals("parent")) {
                        parseParentElement(subnode);
                    } else if (subnode.getNodeName().equals("artifactId")) {
                        artifactId = getText(subnode);
                    }

                }
            }
            doc.getElementsByTagName("artifactId");

        } catch (SAXException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    private void parseParentElement(Node parent) {
        NodeList list = parent.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Node subnode = list.item(j);
            if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                if (subnode.getNodeName().equals("groupId")) {
                    groupId = getText(subnode);
                } else if (subnode.getNodeName().equals("artifactId")) {
                    parentArtifactId = getText(subnode);
                } else if (subnode.getNodeName().equals("version")) {
                    version = getText(subnode);
                }
            }
        }
    }

    /**
     * Return the text that a node contains. This routine:
     * <ul>
     * <li>Ignores comments and processing instructions.
     * <li>Concatenates TEXT nodes, CDATA nodes, and the results of recursively
     * processing EntityRef nodes.
     * <li>Ignores any element nodes in the sublist. (Other possible options are
     * to recurse into element sublists or throw an exception.)
     * </ul>
     * 
     * @param node
     *            a DOM node
     * @return a String representing its contents
     */
    private String getText(Node node) {
        StringBuffer result = new StringBuffer();
        if (!node.hasChildNodes())
            return "";

        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node subnode = list.item(i);
            if (subnode.getNodeType() == Node.TEXT_NODE) {
                result.append(subnode.getNodeValue());
            } else if (subnode.getNodeType() == Node.CDATA_SECTION_NODE) {
                result.append(subnode.getNodeValue());
            } else if (subnode.getNodeType() == Node.ENTITY_REFERENCE_NODE) {
                // Recurse into the subtree for text
                // (and ignore comments)
                result.append(getText(subnode));
            }
        }
        return result.toString();
    }

}
