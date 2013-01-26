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
package org.fornax.utilities.xtendtools.xunit

import net.feltes.emfbuilder.EmfBuilder

import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel
import org.junit.After;
import org.junit.Before;
import org.junit.Test

import static org.junit.Assert.*

class XpandUnitTest {
	
	def TEMP = new File('temp')
	
	@Before
	void setUp() {
		TEMP.mkdirs()
		XpandUnit.initXpand(new EmfRegistryMetaModel())
	}
	
	@After
	void tearDown() {
		TEMP.deleteDir()
	}
	
	@Test
	void textXpand() {
		def builder = new EmfBuilder(EcorePackage)
		def model = builder.EClass('Library')
		
		assertEquals '\n\nName: Library\n\n', XpandUnit.xpand('Template::Class', model).normalize()
	}
	
	@Test
	void testXpandWithBeautifier() {
		def builder = new EmfBuilder(EcorePackage)
		def model = builder.EClass('Library')

		// without beautifier
		XpandUnit.xpand 'Java::Class', model, [:], TEMP
		assertEquals '\npublic class Library {\npublic Library() {}\n}\n', new File(TEMP, 'Library.java').getText().normalize()
		
		// with beautifier
		XpandUnit.xpand 'Java::Class', model, [:], TEMP, new JavaBeautifier()
		assertEquals 'public class Library {\n\tpublic Library() {\n\t}\n}\n', new File(TEMP, 'Library.java').getText().normalize()
	}

}
