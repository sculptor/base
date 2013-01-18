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

import org.eclipse.emf.common.util.BasicEList 
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel 
import org.junit.BeforeClass
import org.junit.Test;

import static org.junit.Assert.*
import static org.fornax.utilities.xtendtools.xunit.XtendUnit.*

/**
 * Unit tests for the extension collections.ext.
 * 
 * @author Ingo Feltes
 */
class CollectionsTest {

	private static final EXTENSION = 'org::fornax::utilities::xtendtools::lib::collections'
	
	@BeforeClass
	static void setUpClass() {
		initXtend()
	}
	
	@Test
	void testConcat() {
		assertEquals(['a', 'b', 'c', 'a'], xtend(EXTENSION, 'concat', [['a', 'b'], ['c', 'a']]))
		assertEquals(['a', 'b', 'c', 'a'], xtend(EXTENSION, 'concat', [['a', 'b', 'c'], ['a']]))
		assertEquals(['a', 'b', 'c', 'a'], xtend(EXTENSION, 'concat', [['a'], ['b', 'c', 'a']]))
		
		assertEquals(['a', 'b', 'c', 'a'], xtend(EXTENSION, 'concat', [['a', 'b', 'c'], 'a']))
		assertEquals(['a', 'b', 'c', 'a'], xtend(EXTENSION, 'concat', ['a', ['b', 'c', 'a']]))
	}
	
	@Test
	void testReplace() {
		assertEquals(['c', 'b'], xtend(EXTENSION, 'replace', [['a', 'b'], 'a', 'c']))
		assertEquals(['c', 'b', 'a'], xtend(EXTENSION, 'replace', [['a', 'b', 'a'], 'a', 'c']))
	}
	
	
	@Test
	void testSet() {
		assertEquals(['c', 'b'], xtend(EXTENSION, 'set', [['a', 'b'], 0, 'c']))
		assertEquals(['c', 'b', 'a'], xtend(EXTENSION, 'set', [['a', 'b', 'a'], 0, 'c']))
		assertEquals(['a', 'b', 'c'], xtend(EXTENSION, 'set', [['a', 'b', 'a'], 2, 'c']))
	}
	
	@Test
	void testInsert_EList() {
		def list = new BasicEList<String>(['a', 'b', 'c'])
		def result = xtend(EXTENSION, 'insert', [list, 2, 'd'])
		assertEquals(['a', 'b', 'd', 'c'], result)
		assertSame(list, result)
	}
	
	@Test(expected=RuntimeException)
	void testInsert_NotEList() {
		xtend(EXTENSION, 'insert', [['a', 'b'], 2, 'd'])
	}
}
