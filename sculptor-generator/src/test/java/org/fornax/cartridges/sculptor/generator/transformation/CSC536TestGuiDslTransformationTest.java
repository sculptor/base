package org.fornax.cartridges.sculptor.generator.transformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import sculptorguimetamodel.GuiApplication;
import sculptorguimetamodel.GuiModule;
import sculptorguimetamodel.SubTaskTransition;
import sculptorguimetamodel.UserTask;
import sculptorguimetamodel.ViewDataProperty;
import sculptormetamodel.NamedElement;

//@Ignore("Skip this test now, due to problems when running from maven")
@SuppressWarnings("unchecked")
public class CSC536TestGuiDslTransformationTest extends TransformationTestBase {
    private static GuiApplication guiApp;

    @BeforeClass
    public static void setUp() throws Exception {
        initWorkflowContext("csc-536-test-workflowguidsl.mwe");
        guiApp = (GuiApplication) ctx.get("guiModel");
    }

    @Test
    public void assertNoUpdateTaskForAuditEntry() {
        assertEquals("AuditRepoWeb", guiApp.getName());
        System.out.println(((GuiModule) guiApp.getModules().get(0)).getUserTasks());
        assertNull(getNamedElement("updateAuditEntry", ((GuiModule) guiApp.getModules().get(0)).getUserTasks()));
    }

    
}
