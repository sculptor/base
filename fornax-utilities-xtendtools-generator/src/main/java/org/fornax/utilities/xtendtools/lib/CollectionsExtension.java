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
package org.fornax.utilities.xtendtools.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;
import org.eclipse.emf.common.util.EList;

/**
 * This class provides the implementations for the Java extensions defined in collections.ext.
 * 
 * @author Ingo Feltes
 */
public final class CollectionsExtension {

	private CollectionsExtension() {
	}

	/**
	 * Concatenates the two collections. Returns a new list that contains all
	 * elements of c1 and all elements of c2 preserving the order.
	 */
	public static List<Object> concat(final Collection<Object> c1, final Collection<Object> c2) {
		if (c1 == null) {
			throw new NullArgumentException("c1");
		}
		if (c2 == null) {
			throw new NullArgumentException("c2");
		}

		List<Object> result = new ArrayList<Object>(c1.size() + c2.size());
		result.addAll(c1);
		result.addAll(c2);
		return result;
	}

	/**
	 * Sets the element at position <tt>index</tt> of the list <tt>list</tt> to
	 * <tt>value</tt> and returns the modified list.
	 */
	public static List<Object> set(final List<Object> list, final Integer index, final Object value) {
		list.set(index.intValue(), value);
		return list;
	}

	/**
	 * Inserts the element <tt>value</tt> at position <tt>index</tt> into the
	 * list <tt>list</tt> and returns the modified list.
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> insert(final List<Object> list, final Integer index, final Object value) {
		if (list instanceof EList) {
			EList<Object> elist = (EList<Object>) list;
			elist.add(value);
			elist.move(index, value);
			return elist;
		} else {
			throw new IllegalArgumentException("insert is only supported for EList");
		}
	}

}
