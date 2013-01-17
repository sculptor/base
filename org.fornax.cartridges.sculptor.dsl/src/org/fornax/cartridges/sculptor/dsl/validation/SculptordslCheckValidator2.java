
package org.fornax.cartridges.sculptor.dsl.validation;

import org.eclipse.xtext.validation.CheckType;

public class SculptordslCheckValidator2 extends SculptordslCheckValidator {

	public SculptordslCheckValidator2() {
	}

	@Override
	protected void configure() {
//		addCheckFile("org::fornax::cartridges::sculptor::dsl::validation::SculptordslFastChecks", CheckType.FAST);
		addCheckFile("org::fornax::cartridges::sculptor::dsl::validation::SculptordslChecks", CheckType.NORMAL);
//		addCheckFile("org::fornax::cartridges::sculptor::dsl::validation::SculptordslExpensiveChecks", CheckType.EXPENSIVE);
	}

}
