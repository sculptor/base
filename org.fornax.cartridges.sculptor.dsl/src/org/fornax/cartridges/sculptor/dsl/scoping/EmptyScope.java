/**
 * 
 */
package org.fornax.cartridges.sculptor.dsl.scoping;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Iterables;

/**
 * @author tferrel
 *
 */
public class EmptyScope implements IScope, IEObjectDescription {

	public static final EmptyScope INSTANCE = new EmptyScope();
	private static final Iterable<IEObjectDescription> EMPTY_ITERABLE = Iterables.emptyIterable();
	
	/**
	 * @see org.eclipse.xtext.scoping.IScope#getAllContents()
	 */

	public Iterable<IEObjectDescription> getAllContents() {		
		return EMPTY_ITERABLE;
	}

	/**
	 * @see org.eclipse.xtext.scoping.IScope#getContents()
	 */

	public Iterable<IEObjectDescription> getContents() {		
		return EMPTY_ITERABLE;
	}

	/**
	 * @see org.eclipse.xtext.scoping.IScope#getOuterScope()
	 */

	public IScope getOuterScope() {		
		return this;
	}

	/**
	 * @see org.eclipse.xtext.resource.IEObjectDescription#getName()
	 */	

	public String getName() {		
		return null;
	}


	public String getQualifiedName() {
		return null;
	}


	public EObject getEObjectOrProxy() {
		return null;
	}


	public URI getEObjectURI() {
		return null;
	}


	public EClass getEClass() {
		return null;
	}


	public String getUserData(String name) {
		return null;
	}


	public String[] getUserDataKeys() {
		return new String[0];
	}


	public IEObjectDescription getContentByName(String name) {
		return null;
	}


	public IEObjectDescription getContentByEObject(EObject object) {
		return null;
	}


	public Iterable<IEObjectDescription> getAllContentsByEObject(EObject object) {
		return Collections.emptyList();
	}

	
}
