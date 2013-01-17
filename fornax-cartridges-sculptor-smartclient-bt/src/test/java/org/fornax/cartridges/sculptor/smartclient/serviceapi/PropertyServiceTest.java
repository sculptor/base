package org.fornax.cartridges.sculptor.smartclient.serviceapi;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;
import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.fornax.cartridges.sculptor.smartclient.domain.Property;
import org.fornax.cartridges.sculptor.smartclient.serviceimpl.PropertySupportFacade;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
public class PropertyServiceTest extends AbstractDbUnitJpaTests implements PropertyServiceTestBase {
	@Autowired
	private PropertyService propertyService;

	@Autowired
	private PropertySupportFacade propertyFacade;

	@Test
	public void testFindById() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testFindAll() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testFindByQuery() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testPropertyFacade() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testGetPropertyValue() throws Exception {
		String propRef= propertyService.getPropertyValue(getServiceContext(), null, "balanceItemService.clientAccount.jsonPostfix", "new value");
		assertEquals("detail:false, hidden:false, filterEditorProperties:{optionDataSource: 'clientAccountService', displayField: 'accId'}, editorProperties:{optionDataSource:'clientAccountService', displayField:'accId'}, displayField:\"clientAccount_VAL\", valueField:\"id\", editorType:\"ComboBoxItem\", type:\"integer\", pickListFields: $wnd.Array.create([{name: \"accId\"}, {name: \"ownerName\"}])", propRef);

		String value = propertyService.getPropertyValue(getServiceContext(), null, "test.prop", "new value");
		assertEquals("result from default.properties", value);

		value = propertyService.getPropertyValue(getServiceContext(), null, "test.new.prop", "new value");
		assertEquals("new value", value);

		String fileValue = propertyService.getPropertyValue(getServiceContext(), null, "test.file.prop", null);
		assertTrue(fileValue.startsWith("SOME TEXT"));
		assertEquals(27, fileValue.length());

		String subimport = propertyService.getPropertyValue(getServiceContext(), null, "subimport", "NOT");
		assertEquals("working", subimport);

		// Test path
		ServiceContext sck=new ServiceContext("kuku", "sessionID", "applicationID");
		String followPathD = propertyService.getPropertyValue(sck, "a.b.c.d", "test.followPath", "NOT");
		assertEquals("d-follow", followPathD);

		String followPathA = propertyService.getPropertyValue(sck, "a.b.c", "test.followPath", "NOT");
		assertEquals("a-follow", followPathA);

		String userListA = propertyService.getPropertyValue(sck, "a.b.c", "userList", "NOT");
		assertEquals("userListInA", userListA);

		ServiceContext scb=new ServiceContext("bubu", "sessionID", "applicationID");
		String userListDef = propertyService.getPropertyValue(scb, "a.b.c", "userList", "NOT");
		assertEquals("userListDefault", userListDef);

		String qqqNOT = propertyService.getPropertyValue(scb, "a.b.c", "qqq", "NOT");
		assertEquals("NOT", qqqNOT);

		// Save as kuku
		Property prop=new Property();
		prop.setPropName("userProp");
		prop.setPropValue("User kuku");
		propertyService.save(sck, prop);

		String userPropBubu = propertyService.getPropertyValue(scb, null, "userProp", "NOT");
		assertEquals("defaultValue", userPropBubu);

		String userPropKuku = propertyService.getPropertyValue(sck, null, "userProp", "NOT");
		assertEquals("User kuku", userPropKuku);

		ServiceContext scz=new ServiceContext("zuzu", "sessionID", "applicationID");
		String userPropZuzu = propertyService.getPropertyValue(scz, null, "userProp", "NOT");
		assertEquals("Zuzu userProp", userPropZuzu);

		ServiceContextStore.set(scb);
		String userDepBu=propertyFacade.getProperty("test.userDepReplace");
		assertEquals("prop replace bubuValue", userDepBu);

		ServiceContextStore.set(sck);
		String userDepKu=propertyFacade.getProperty("test.userDepReplace");
		assertEquals("prop replace kukuValue", userDepKu);

		ServiceContextStore.set(scz);
		String userDepZu=propertyFacade.getProperty("test.userDepReplace");
		assertEquals("prop replace defaultValue", userDepZu);

		ServiceContextStore.set(getServiceContext());
		String transValue=propertyService.getPropertyValue(scb, null, "test.trans", null);
		assertEquals("{test language 11111111 and 222 and 3333}", transValue);
	}

	@Test
	public void testTranslate() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testLoadDefaultProperties() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testSave() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testDelete() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testFindByCondition() throws Exception {
		assertTrue(true);
	}

	@Test
	public void testMakeLangProperty() throws Exception {
		assertTrue(true);
	}
}