/**
 * Copyright 2010 The Xtend Tools Team and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fornax.utilities.xtendtools.lib

import org.eclipse.xtend.expression.EvaluationException 
import org.junit.BeforeClass
import org.junit.Test

import static org.junit.Assert.*
import static org.fornax.utilities.xtendtools.xunit.XtendUnit.*

/**
 * Unit tests for the extension assert.ext.
 * 
 * @author Ingo Feltes
 */
class AssertTest {
	
	private static final EXTENSION = 'org::fornax::utilities::xtendtools::lib::assert'
	
	@BeforeClass
	static void setUpClass() {
		initXtend()
	}

	/**
	 * Tests that assert returns <tt>null</tt> and does not throw an exception,
	 * if the condition was true.
	 */
	@Test
	void testAssert_True() {
		assertNull xtend(EXTENSION, 'assert', [Boolean.TRUE, 'assertion failed'])
	}
	
	/**
	 * Tests that assert throws an exception, if the condition was false.
	 */
	@Test(expected=EvaluationException)
	void testAssert_False() {
		xtend(EXTENSION, 'assert', [Boolean.FALSE, 'assertion failed'])
	}
	
	/**
	 * Tests that assertNotNull returns the object and does not throw an exceptions,
	 * if the object was not null.
	 */
	@Test
	void testAssertNotNull_NotNull() {
		assertEquals 'test', xtend(EXTENSION, 'assertNotNull', ['test', 'assertion failed'])
	}
	
	/**
	 * Tests that assertNotNull throws an exception, if the object was null.
	 */
	@Test(expected=EvaluationException)
	void testAssertNotNull_Null() {
		xtend(EXTENSION, 'assertNotNull', [null, 'assertion failed'])
	}
	
}
