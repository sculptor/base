package org.fornax.cartridges.sculptor.generator.util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sculptorguimetamodel.AttributeViewProperty;
import sculptorguimetamodel.ReferenceViewProperty;
import sculptorguimetamodel.ViewDataProperty;
import sculptorguimetamodel.impl.SculptorguimetamodelFactoryImpl;
import sculptormetamodel.Attribute;
import sculptormetamodel.DomainObject;
import sculptormetamodel.Reference;
import sculptormetamodel.impl.SculptormetamodelFactoryImpl;

public class GuiGenerationHelperTest {


    @Test
	public void testUncapitalizeSecondaryWordsSimple() {
		String result = GuiGenerationHelper
				.uncapitalizeSecondaryWords("Abc Def");
		assertEquals("Abc def", result);
	}

    @Test
	public void testUncapitalizeSecondaryWordsOneWord() {
		String result = GuiGenerationHelper.uncapitalizeSecondaryWords("Abc");
		assertEquals("Abc", result);
	}

    @Test
	public void testUncapitalizeSecondaryWordsSeveralUpper() {
		String result = GuiGenerationHelper
				.uncapitalizeSecondaryWords("Abc DEF GhI");
		assertEquals("Abc DEF ghI", result);
	}

    @Test
	public void testUncapitalizeSecondaryWordsSingleCharacterWord() {
		String result = GuiGenerationHelper
				.uncapitalizeSecondaryWords("Abc D Ghi");
		assertEquals("Abc d ghi", result);
	}

    @Test
	public void testFilterReferences() {
		AttributeViewProperty attProp = SculptorguimetamodelFactoryImpl.eINSTANCE
				.createAttributeViewProperty();
		Attribute att = SculptormetamodelFactoryImpl.eINSTANCE
				.createAttribute();
		att.setName("myAtt");
		attProp.setAttribute(att);
		attProp.setName(att.getName());

		DomainObject fromDO = makeDO("FROM");
		DomainObject parentDO = makeDO("PARENT");
		DomainObject childOneDO = makeChild("CHILD_ONE", parentDO);
		DomainObject childTwoDO = makeChild("CHILD_TWO", parentDO);
		DomainObject standaloneDO = makeDO("STANDALONE");
		Reference refOne = makeRef(fromDO, childOneDO);
		Reference refTwo = makeRef(fromDO, childTwoDO);
		Reference refStandalone = makeRef(fromDO, standaloneDO);
		ReferenceViewProperty refPropOne = makeRefProp(refOne, childOneDO);
		ReferenceViewProperty refPropTwo = makeRefProp(refTwo, childTwoDO);
		ReferenceViewProperty refPropStandalone = makeRefProp(refStandalone, standaloneDO);

		List<ViewDataProperty> original = new ArrayList<ViewDataProperty>();
		original.add(attProp);
		original.add(refPropOne);
		original.add(refPropTwo);
		original.add(refPropStandalone);
		List<ViewDataProperty> filteredList = GuiGenerationHelper
				.filterReferences(original);
		assertEquals(3, filteredList.size());
		assertTrue(filteredList.contains(attProp));
		assertTrue(filteredList.contains(refPropStandalone));
		assertTrue(filteredList.contains(refPropOne));
		assertFalse(filteredList.contains(refPropTwo));
	}
	
    @Test
	public void testFilterReferenceTargets() {
		DomainObject fromDO = makeDO("FROM");
		DomainObject parentDO = makeDO("PARENT");
		DomainObject childOneDO = makeChild("CHILD_ONE", parentDO);
		DomainObject childTwoDO = makeChild("CHILD_TWO", parentDO);
		DomainObject standaloneDO = makeDO("STANDALONE");
		Reference refOne = makeRef(fromDO, childOneDO);
		Reference refTwo = makeRef(fromDO, childTwoDO);
		Reference refStandalone = makeRef(fromDO, standaloneDO);
		Reference refStandalone2 = makeRef(fromDO, standaloneDO);
		ReferenceViewProperty refPropOne = makeRefProp(refOne, childOneDO);
		ReferenceViewProperty refPropTwo = makeRefProp(refTwo, childTwoDO);
		ReferenceViewProperty refPropStandalone = makeRefProp(refStandalone, standaloneDO);
		ReferenceViewProperty refPropStandalone2 = makeRefProp(refStandalone2, standaloneDO);

		List<ReferenceViewProperty> original = new ArrayList<ReferenceViewProperty>();
		original.add(refPropOne);
		original.add(refPropTwo);
		original.add(refPropStandalone);
		original.add(refPropStandalone2);
		List<ReferenceViewProperty> filteredList = GuiGenerationHelper
				.filterReferenceTargets(original);
		assertEquals(3, filteredList.size());
		assertTrue(filteredList.contains(refPropStandalone));
		assertFalse(filteredList.contains(refPropStandalone2));
		assertTrue(filteredList.contains(refPropOne));
		assertTrue(filteredList.contains(refPropTwo));
	}

    @Test
	public void testGetReferencePropertiesWithAdditionlBaseReferenceProperties() {
		List<ReferenceViewProperty> original = new ArrayList<ReferenceViewProperty>();
		List<ReferenceViewProperty> newList = null;
		DomainObject fromDO = makeDO("FROM");
		DomainObject parentDO = makeDO("PARENT");
		DomainObject childOneDO = makeChild("CHILD_ONE", parentDO);
		DomainObject childTwoDO = makeChild("CHILD_TWO", parentDO);
		DomainObject standaloneDO = makeDO("STANDALONE");
		Reference refOne = makeRef(fromDO, childOneDO);
		Reference refTwo = makeRef(fromDO, childTwoDO);
		Reference refStandalone = makeRef(fromDO, standaloneDO);
		ReferenceViewProperty refPropOne = makeRefProp(refOne, childOneDO);
		ReferenceViewProperty refPropTwo = makeRefProp(refTwo, childTwoDO);
		ReferenceViewProperty refPropStandalone = makeRefProp(refStandalone, standaloneDO);
		original.add(refPropOne);
		original.add(refPropTwo);
		original.add(refPropStandalone);
		newList = GuiGenerationHelper
		.referencePropertiesWithAdditionlBaseReferenceProperties(original);
		assertNotNull(newList);
		assertEquals(4, newList.size());
		assertTrue(newList.containsAll(original));
	}

    @Test
	public void testcreateParentProperties() {
		List<ReferenceViewProperty> original = new ArrayList<ReferenceViewProperty>();
		List<ReferenceViewProperty> newList = null;
		DomainObject fromDO = makeDO("FROM");
		DomainObject parentDO = makeDO("PARENT");
		DomainObject childOneDO = makeChild("CHILD_ONE", parentDO);
		DomainObject childTwoDO = makeChild("CHILD_TWO", parentDO);
		Reference refOne = makeRef(fromDO, childOneDO);
		Reference refTwo = makeRef(fromDO, childTwoDO);
		ReferenceViewProperty refPropOne = makeRefProp(refOne, childOneDO);
		ReferenceViewProperty refPropTwo = makeRefProp(refTwo, childTwoDO);
		original.add(refPropOne);
		original.add(refPropTwo);
		newList = GuiGenerationHelper
		.createParentProperties(original);
		assertNotNull(newList);
		assertEquals(1, newList.size());
		assertTrue(newList.get(0).getTarget().equals(parentDO));
	}

	private DomainObject makeDO(String name) {
		DomainObject fromDO = SculptormetamodelFactoryImpl.eINSTANCE
				.createValueObject();
		fromDO.setName(name);
		return fromDO;
	}

	private DomainObject makeChild(String name, DomainObject parentDO) {
		DomainObject childDO = makeDO(name);
		childDO.setExtends(parentDO);
		return childDO;
	}
	private ReferenceViewProperty makeRefProp(Reference ref, DomainObject target) {
		ReferenceViewProperty refProp = SculptorguimetamodelFactoryImpl.eINSTANCE
				.createReferenceViewProperty();
		refProp.setReference(ref);
		refProp.setName(ref.getName());
		refProp.setTarget(target);
		return refProp;
	}

	private Reference makeRef(DomainObject fromDO, DomainObject toDO) {
		Reference ref = SculptormetamodelFactoryImpl.eINSTANCE
				.createReference();
		ref.setFrom(fromDO);
		ref.setTo(toDO);
		return ref;
	}

}
