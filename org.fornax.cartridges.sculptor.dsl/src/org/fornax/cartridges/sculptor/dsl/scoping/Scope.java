package org.fornax.cartridges.sculptor.dsl.scoping;

import java.util.List;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
/**
 * 
 * @author Todd Ferrell
 *
 */
public class Scope extends AbstractScope {
	private List<IEObjectDescription> elements;

	public Scope() {
		super();
	}	

	public IScope getOuterScope() {
		return outer == null ? EmptyScope.INSTANCE : outer;
	}

	
	private IScope outer;
	
	public void setOuterScope(IScope outer) {
		this.outer = outer;
	}

	@Override
	protected Iterable<IEObjectDescription> internalGetContents() {
		return elements;
	}

	public void setElements(List<IEObjectDescription> elements) {
		this.elements = elements;
	}	
}
