
package org.fornax.cartridges.sculptor.gui.dsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SculptorguidslStandaloneSetup extends SculptorguidslStandaloneSetupGenerated{

	public static void doSetup() {
		new SculptorguidslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

