package org.fornax.cartridges.sculptor.dsl.ui;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class SculptordslSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

    private static Set<String> terminalKeywords = new HashSet<String>();
    {
        terminalKeywords.add("=>");
        terminalKeywords.add("delegates to");
        terminalKeywords.add("<->");
        terminalKeywords.add("opposite");
        terminalKeywords.add("!");
        terminalKeywords.add("not");
        terminalKeywords.add("-");
        terminalKeywords.add("reference");
        terminalKeywords.add("Map");

    }

    public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
        if (resource == null)
            return;

        if (resource.getContents().size() > 0) {
            Iterable<AbstractNode> allNodes = NodeUtil.getAllContents(resource.getParseResult().getRootNode());
            for (AbstractNode node : allNodes) {
                if (node instanceof LeafNode) {
                    LeafNode leafNode = (LeafNode) node;
                    if ("doc".equals(leafNode.getFeature())) {
                        acceptor.addPosition(node.getOffset(), node.getLength(),
                        		DefaultHighlightingConfiguration.COMMENT_ID);
                    } else if (terminalKeywords.contains(leafNode.getText())) {
                        acceptor.addPosition(node.getOffset(), node.getLength(),
                        		DefaultHighlightingConfiguration.KEYWORD_ID);
                    }
                }
            }
        }
    }
}