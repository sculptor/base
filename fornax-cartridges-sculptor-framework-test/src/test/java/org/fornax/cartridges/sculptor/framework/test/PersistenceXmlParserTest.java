package org.fornax.cartridges.sculptor.framework.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class PersistenceXmlParserTest {

    @Test
    public void shouldFindPersistenceUnitName() throws Exception {
        String persistenceXml = DataHelper.content("/persistence-testdata.xml");
        PersistenceXmlParser parser = new PersistenceXmlParser();
        parser.parse(persistenceXml);

        Set<String> unitNames = parser.getPersictenceUnitNames();
        assertTrue(unitNames.contains("UniverseEntityManagerFactory"));
        assertTrue(unitNames.contains("SecondaryEntityManagerFactory"));
        assertEquals(2, unitNames.size());
    }


}
