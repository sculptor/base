package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowRunner;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.fornax.cartridges.sculptor.generator.util.GenerationHelper;

import sculptorguimetamodel.AttributeViewProperty;
import sculptorguimetamodel.BasicTypeEnumViewProperty;
import sculptorguimetamodel.BasicTypeViewProperty;
import sculptorguimetamodel.DerivedReferenceViewProperty;
import sculptorguimetamodel.EnumViewProperty;
import sculptorguimetamodel.ReferenceViewProperty;
import sculptormetamodel.NamedElement;

@SuppressWarnings("unchecked")
public abstract class TransformationTestBase {
    protected final static Set<String> SYSTEM_ATTRIBUTES = new HashSet<String>(Arrays.asList("id", "uuid", "version",
            "createdBy", "createdDate", "updatedBy", "updatedDate", "lastUpdated", "lastUpdatedBy"));
    protected static WorkflowContext ctx;

    public static void initWorkflowContext(String workflowFile) throws Exception {
        try {
            String wfFile = workflowFile;
            assertNotNull(wfFile);
            Map<String, String> properties = new HashMap<String, String>();
            Map<String, ?> slotContents = new HashMap<String, Object>();
            WorkflowRunner runner = new WorkflowRunner();
            runner.run(wfFile, new NullProgressMonitor(), properties, slotContents);
            ctx = runner.getContext();
            assertNotNull(ctx);
        } catch (Exception e) {
            LoggerFactory.getLogger(TransformationTestBase.class).error(e.getMessage(), e);
            throw e;
        } catch (Error e) {
            LoggerFactory.getLogger(TransformationTestBase.class).error(e.getMessage(), e);
            throw e;
        }

    }

    protected void assertOneAndOnlyOne(EList listOfNamedElements, String... expectedNames) {
        Set<String> expectedOnes = new HashSet<String>(Arrays.asList(expectedNames));
        for (Iterator iterator = listOfNamedElements.iterator(); iterator.hasNext();) {
            NamedElement namedElement = (NamedElement) iterator.next();
            String name = namedElement.getName();
            if (SYSTEM_ATTRIBUTES.contains(name) && !expectedOnes.contains(name)) {
                continue;
            }
            assertTrue("Unexpected: " + name, expectedOnes.contains(name));
            expectedOnes.remove(name);
        }
        if (!expectedOnes.isEmpty()) {
            String unexpected = "";
            for (String each : expectedOnes) {
                unexpected += each + ", ";
            }
            assertEquals("Expected to find: " + unexpected, expectedOnes.size(), 0);
        }
    }

    protected static NamedElement getNamedElement(String name, EList namedElements) {
        return namedElement(name, namedElements);
    }

    protected static NamedElement namedElement(String name, List<? extends NamedElement> namedElements) {
        for (NamedElement each : namedElements) {
            if (name.equals(each.getName())) {
                return each;
            }
        }
        return null;
    }

    protected List<NamedElement> namedElements(String name, List<? extends NamedElement> namedElements) {
        List<NamedElement> result = new ArrayList<NamedElement>();
        for (NamedElement each : namedElements) {
            if (name.equals(each.getName())) {
                result.add(each);
            }
        }
        return result;
    }

    protected <T> List<T> elementsOfType(Class<T> type, List<?> elements) {
        List<T> result = new ArrayList<T>();
        for (Object each : elements) {
            if (type.isAssignableFrom(each.getClass())) {
                result.add((T) each);
            }
        }
        return result;
    }

    protected ReferenceViewProperty namedReferenceViewProperty(String name, List<? extends NamedElement> elements) {
        List<NamedElement> namedElements = namedElements(name, elements);
        List<ReferenceViewProperty> elementsOfType = elementsOfType(ReferenceViewProperty.class, namedElements);
        elementsOfType.removeAll(elementsOfType(DerivedReferenceViewProperty.class, namedElements));
        if (elementsOfType.isEmpty()) {
            return null;
        } else {
            return elementsOfType.get(0);
        }
    }

    protected void assertReferenceViewProperty(String name, EList listOfProperties, String[] relatedTransitions,
            String[] previewProperties, String doName) {
        NamedElement namedElement = getNamedElement(name, listOfProperties);
        assertNotNull(name + " is null", namedElement);
        assertTrue(name + " is not an ReferenceViewProperty, got " + namedElement.getClass().getName(),
                namedElement instanceof ReferenceViewProperty);
        ReferenceViewProperty ref = (ReferenceViewProperty) namedElement;
        assertReferenceViewProperty(name, ref, relatedTransitions, previewProperties, doName);
    }

    protected void assertReferenceViewProperty(String name, ReferenceViewProperty ref, String[] relatedTransitions,
            String[] previewProperties, String doName) {
        assertNotNull(name + ".refererence is null", ref.getReference());
        assertEquals(ref.getName(), ref.getReference().getName());
        assertNotNull(name + ".relatedTransitions is null", ref.getRelatedTransitions());
        assertOneAndOnlyOne(ref.getRelatedTransitions(), relatedTransitions);
        assertNotNull(name + ".previewProperties is null", ref.getPreviewProperties());
        assertOneAndOnlyOne(ref.getPreviewProperties(), previewProperties);
        assertNotNull(name + ".target is null", ref.getTarget());
        assertTrue(ref.getTarget().getName().equals(doName));
    }

    protected void assertAttributeViewProperty(String name, EList listOfProperties) {
        NamedElement namedElement = getNamedElement(name, listOfProperties);
        assertNotNull(name + " is null", namedElement);
        assertTrue(name + " is not an AttributeViewProperty, got " + namedElement.getClass().getName(),
                namedElement instanceof AttributeViewProperty);
        assertNotNull(((AttributeViewProperty) namedElement).getAttribute());
        assertTrue(((AttributeViewProperty) namedElement).getAttribute().getName().equals(name));
    }

    protected void assertEnumViewProperty(String name, EList listOfProperties) {
        NamedElement namedElement = getNamedElement(name, listOfProperties);
        assertNotNull(name + " is null", namedElement);
        assertTrue(name + " is not a EnumViewProperty, got " + namedElement.getClass().getName(),
                namedElement instanceof EnumViewProperty);
        assertNotNull(((EnumViewProperty) namedElement).getReference());
        assertTrue(((EnumViewProperty) namedElement).getReference().getName().equals(name));
        assertTrue(((EnumViewProperty) namedElement).getReference().getTo() instanceof sculptormetamodel.Enum);
    }

    protected void assertBasicTypeAttributeViewProperty(String referenceName, String name, EList listOfProperties) {
        String combinedName = referenceName + GenerationHelper.toFirstUpper(name);
        NamedElement namedElement = getNamedElement(combinedName, listOfProperties);
        assertNotNull(name + " is null", namedElement);
        assertTrue(name + " is not a BasicTypeViewProperty, got " + namedElement.getClass().getName(),
                namedElement instanceof BasicTypeViewProperty);
        assertTrue(((BasicTypeViewProperty) namedElement).getName().equals(combinedName));
        assertNotNull(((BasicTypeViewProperty) namedElement).getReference());
        assertTrue(((BasicTypeViewProperty) namedElement).getReference().getName().equals(referenceName));
        assertNotNull(((BasicTypeViewProperty) namedElement).getAttribute());
        assertTrue(((BasicTypeViewProperty) namedElement).getAttribute().getName().equals(name));
    }

    protected void assertBasicTypeEnumViewProperty(String referenceName, String name, EList listOfProperties) {
        String combinedName = referenceName + GenerationHelper.toFirstUpper(name);
        NamedElement namedElement = getNamedElement(combinedName, listOfProperties);
        assertNotNull(name + " is null", namedElement);
        assertTrue(name + " is not a BasicTypeEnumViewProperty, got " + namedElement.getClass().getName(),
                namedElement instanceof BasicTypeEnumViewProperty);
        assertTrue(((BasicTypeEnumViewProperty) namedElement).getName().equals(combinedName));
        assertNotNull(((BasicTypeEnumViewProperty) namedElement).getReference());
        assertTrue(((BasicTypeEnumViewProperty) namedElement).getReference().getName().equals(name));
        assertTrue(((BasicTypeEnumViewProperty) namedElement).getBasicTypeReference().getName().equals(referenceName));
        assertTrue(((BasicTypeEnumViewProperty) namedElement).getReference().getTo() instanceof sculptormetamodel.Enum);
    }

}
