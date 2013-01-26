package org.fornax.cartridges.sculptor.dsl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * Utility class to handle resource loading. 
 * 
 * This is a very simple implementation and will likely need revision.
 * 
 * @author koehnlein
 * @author tferrel
 */
public class ModelLoad {

	private static Log log = LogFactory.getLog(ModelLoad.class);

	private static ResourceSet defaultResourceSet = new XtextResourceSet();

	/**
	 * Loads the resource with the given URI into the same resource set as the
	 * contextElement. If the ResourceSet is an {@link XtextResourceSet}, it is
	 * capable of resolving classpath relative URIs. If forceLinking if set to
	 * true, the loaded resource is linked. This may cause further resources to
	 * be loaded and linked. Disabling linking can significantly improve memory
	 * consumption and performance, but the loaded resource will not have any
	 * cross references set.
	 * 
	 * @param uri
	 *            the URI of the resource to be loaded.
	 * @param contextElement
	 *            an element whose resource set is used to load the resource.
	 *            Even though there is a default resource set that is used if
	 *            the contextElement is null, you should always provide the
	 *            contextElement.
	 * @param forceLinking
	 *            if set to true, the loaded resource is linked.
	 * @return the contents of the loaded resource.
	 */
	public static List<EObject> load(String uri, EObject contextElement,
			Boolean loadOnDemand) {
		Resource contextResource = contextElement.eResource();
		if (contextResource == null) {
			throw new IllegalArgumentException(
					"Context EObject must be in a Resource");
		}
		ResourceSet resourceSet = getResourceSet(contextResource
				.getResourceSet());						
		try {			
			Resource resource = resourceSet.getResource(URI.createURI(uri), loadOnDemand);			
			return resource != null ? resource.getContents() : Collections
					.<EObject> emptyList();
		} catch (Exception e) {
			log.error("Error loading resource", e);			
			return null;
		} 
	}

	private static ResourceSet getResourceSet(ResourceSet resourceSet) {
		if (resourceSet == null) {
			log.warn("Passed ResourceSet is null. Using default ResourceSet");
			return defaultResourceSet;
		}
		return resourceSet;
	}
}
