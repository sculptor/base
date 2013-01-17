package org.fornax.cartridges.sculptor.framework.accessimpl.jpa2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Holds the expressions of the query
 *
 * @author Oliver Ringel
 *
 */
public class QueryExpressionsTest {

	@Test
	public void testAddSelections() {
		QueryExpressions<Person> qe = new QueryExpressions<Person>(Person.class);
		qe.addSelections(PersonDto.class);
		assertEquals(2, qe.getSelections().size());
		assertEquals("name", qe.getSelections().get(0));
		assertEquals("counter", qe.getSelections().get(1));
	}

    public static class Person {
    	private String name;
    	private Long sal;
    	private int counter;
    }

    public static class PersonDto {
    	private String name;
    	private Long salary;
    	private int counter;
    }
}