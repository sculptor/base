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

import org.junit.BeforeClass
import org.junit.Test

import static org.junit.Assert.*
import static org.fornax.utilities.xtendtools.xunit.XtendUnit.*

/**
 * Unit tests for the extension strings.ext.
 * 
 * @author Ingo Feltes
 */
class StringsTest {
	
	private static final EXTENSION = 'org::fornax::utilities::xtendtools::lib::strings'
	
	@BeforeClass
	static void setUpClass() {
		initXtend()
	}
	
	@Test
	void testChomp() {
		assertNull xtend(EXTENSION, 'chomp', [null])
		assertEquals '', xtend(EXTENSION, 'chomp', [''])
		assertEquals 'abc ', xtend(EXTENSION, 'chomp', ['abc \r'])
		assertEquals 'abc', xtend(EXTENSION, 'chomp', ['abc\n'])
		assertEquals 'abc', xtend(EXTENSION, 'chomp', ['abc\r\n'])
		assertEquals 'abc\r\n', xtend(EXTENSION, 'chomp', ['abc\r\n\r\n'])
		assertEquals 'abc\n', xtend(EXTENSION, 'chomp', ['abc\n\r'])
		assertEquals 'abc\n\rabc', xtend(EXTENSION, 'chomp', ['abc\n\rabc'])
		assertEquals '', xtend(EXTENSION, 'chomp', ['\r'])
		assertEquals '', xtend(EXTENSION, 'chomp', ['\n'])
		assertEquals '', xtend(EXTENSION, 'chomp', ['\r\n'])
	}
	
	@Test
	void testChomp_Separator() {
		assertNull xtend(EXTENSION, 'chomp', [null, null])
		assertNull xtend(EXTENSION, 'chomp', [null, ''])
		assertNull xtend(EXTENSION, 'chomp', [null, 'foo'])
		
		assertEquals '', xtend(EXTENSION, 'chomp', ['', null])
		assertEquals '', xtend(EXTENSION, 'chomp', ['', ''])
		assertEquals '', xtend(EXTENSION, 'chomp', ['', 'foo'])
		
		assertEquals 'foo', xtend(EXTENSION, 'chomp', ['foobar', 'bar'])
		assertEquals 'foobar', xtend(EXTENSION, 'chomp', ['foobar', 'baz'])
		assertEquals '', xtend(EXTENSION, 'chomp', ['foo', 'foo'])
		assertEquals 'foo ', xtend(EXTENSION, 'chomp', ['foo ', 'foo'])
		assertEquals ' ', xtend(EXTENSION, 'chomp', [' foo', 'foo'])
		assertEquals 'foo', xtend(EXTENSION, 'chomp', ['foo', 'foooo'])
		assertEquals 'foo', xtend(EXTENSION, 'chomp', ['foo', ''])
		assertEquals 'foo', xtend(EXTENSION, 'chomp', ['foo', null])
	}
	
	@Test
	void testChop() {
		assertNull xtend(EXTENSION, 'chop', [null])
		assertEquals '', xtend(EXTENSION, 'chop', [''])
		assertEquals 'abc ', xtend(EXTENSION, 'chop', ['abc \r'])
		assertEquals 'abc', xtend(EXTENSION, 'chop', ['abc\n'])
		assertEquals 'abc', xtend(EXTENSION, 'chop', ['abc\r\n'])
		assertEquals 'ab', xtend(EXTENSION, 'chop', ['abc'])
		assertEquals 'abc\nab', xtend(EXTENSION, 'chop', ['abc\nabc'])
		assertEquals '', xtend(EXTENSION, 'chop', ['a'])
		assertEquals '', xtend(EXTENSION, 'chop', ['\r'])
		assertEquals '', xtend(EXTENSION, 'chop', ['\n'])
		assertEquals '', xtend(EXTENSION, 'chop', ['\r\n'])
	}
	
	@Test
	void testRepeat() {
		assertNull xtend(EXTENSION, 'repeat', [null, null])
		assertNull xtend(EXTENSION, 'repeat', [null, 0])
		assertNull xtend(EXTENSION, 'repeat', [null, 2])
		
		assertEquals '', xtend(EXTENSION, 'repeat', ['', null])
		assertEquals '', xtend(EXTENSION, 'repeat', ['', 0])
		assertEquals '', xtend(EXTENSION, 'repeat', ['', 2])
		
		assertEquals 'aaa', xtend(EXTENSION, 'repeat', ['a', 3])
		assertEquals 'abab', xtend(EXTENSION, 'repeat', ['ab', 2])
		assertEquals '', xtend(EXTENSION, 'repeat', ['a', -2])
	}
	
	@Test
	void testRepeat_Separator() {
		assertNull xtend(EXTENSION, 'repeat', [null, null, null])
		assertNull xtend(EXTENSION, 'repeat', [null, null, 0])
		assertNull xtend(EXTENSION, 'repeat', [null, null, 2])
		
		assertNull xtend(EXTENSION, 'repeat', [null, 'x', null])
		assertNull xtend(EXTENSION, 'repeat', [null, 'x', 0])
		assertNull xtend(EXTENSION, 'repeat', [null, 'x', 2])
		
		assertEquals '', xtend(EXTENSION, 'repeat', ['', null, 0])
		assertEquals '', xtend(EXTENSION, 'repeat', ['', null, 2])
		assertEquals '', xtend(EXTENSION, 'repeat', ['', '', 2])

		assertEquals 'xx', xtend(EXTENSION, 'repeat', ['', 'x', 3])
		assertEquals 'axaxa', xtend(EXTENSION, 'repeat', ['a', 'x', 3])
		assertEquals '?, ?, ?', xtend(EXTENSION, 'repeat', ['?', ', ', 3])
	}
	
}
