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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class provides the implementations for the Java extensions defined in ecore.ext.
 * 
 * @author Ingo Feltes
 */
public final class EcoreExtension {

    private EcoreExtension() {
    }

    /**
     * Recursively removes the model element from the model.
     */
    public static void delete(final EObject o) {
        EcoreUtil.delete(o, true);
    }

    @SuppressWarnings("unchecked")
    public static void replaceInContainer(final EObject search, final EObject replacement) {
        EObject container = search.eContainer();
        EStructuralFeature f = search.eContainingFeature();
        if (f.isMany()) {
            EList l = (EList) container.eGet(f);
            l.set(l.indexOf(search), replacement);
        } else {
            container.eSet(f, replacement);
        }
    }
}
