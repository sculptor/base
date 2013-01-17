package org.fornax.toolsupport.maven2;

enum Outlet {

	RES_DIR("outletResDir", "target/generated-resources/fornax-workflow"), RES_ONCE_DIR("outletResOnceDir", "src/main/resources"), RES_PROTECTED_DIR(
			"outletResProtectedDir", "src/generated-resources-prot/fornax-workflow"), RES_TEST_DIR("outletResTestDir",
			"src/test/resources"), RES_TEST_ONCE_DIR("outletResTestOnceDir", "src/test/resources"), RES_TEST_PROTECTED_DIR(
			"outletResTestProtectedDir", "src/test/protected"), SRC_DIR("outletSrcDir", "src/main/java"), SRC_ONCE_DIR(
			"outletSrcOnceDir", "src/main/java"), SRC_PROTECTED_DIR("outletSrcProtectedDir",
			"src/generated-sources-prot/fornax-workflow"), SRC_TEST_DIR("outletSrcTestDir", "src/test/java"), SRC_TEST_ONCE_DIR(
			"outletSrcTestOnceDir", "src/test/java"), SRC_TEST_PROTECTED_DIR("outletSrcTestProtectedDir",
			"src/generated-testsources-prot/fornax-workflow");

	String propertyName;
	String defaultDir;

	private Outlet(String propertyName, String defaultDir) {
		this.propertyName = propertyName;
		this.defaultDir = defaultDir;
	}
}