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
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel 
import org.junit.BeforeClass
import org.junit.Test

import static org.junit.Assert.*
import static org.fornax.utilities.xtendtools.xunit.XtendUnit.*

/**
 * Unit tests for the extension math.ext.
 * 
 * @author Ingo Feltes
 */
class MathTest {

	private static final EXTENSION = 'org::fornax::utilities::xtendtools::lib::math'
	
	@BeforeClass
	static void setUpClass() {
		initXtend()
	}
	
	/**
	 * Tests that assert returns <tt>null</tt> and does not throw an exception,
	 * if the condition was true.
	 */
	@Test
	void testMod() {
		assertEquals 0, xtend(EXTENSION, 'mod', [0, 1]).intValue()
		assertEquals 0, xtend(EXTENSION, 'mod', [0, 2]).intValue()
		assertEquals 0, xtend(EXTENSION, 'mod', [1, 1]).intValue()
		assertEquals 1, xtend(EXTENSION, 'mod', [1, 2]).intValue()
		assertEquals 0, xtend(EXTENSION, 'mod', [2, 1]).intValue()
		assertEquals 0, xtend(EXTENSION, 'mod', [2, 2]).intValue()
		assertEquals 0, xtend(EXTENSION, 'mod', [4, 2]).intValue()
		assertEquals 1, xtend(EXTENSION, 'mod', [5, 2]).intValue()
		assertEquals 2, xtend(EXTENSION, 'mod', [23, 3]).intValue()
		assertEquals 0, xtend(EXTENSION, 'mod', [42, 7]).intValue()
		assertEquals 6, xtend(EXTENSION, 'mod', [42, 9]).intValue()
	}
	
	/**
	 * Tests that assert returns <tt>null</tt> and does not throw an exception,
	 * if the condition was true.
	 */
	@Test(expected=EvaluationException)
	void testMod_DivideByZero() {
		xtend(EXTENSION, 'mod', [5, 0])
	}
}
