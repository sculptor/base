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
package org.fornax.utilities.xtendtools.xunit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.MetaModel;

/**
 * Provides utility methods for invoking Xpand templates.
 *  
 * @author Ingo Feltes
 */
public class XpandUnit {
    
	private static MetaModel[] metamodels = new MetaModel[0];
	
    /**
     * Initializes XpandUnit.
     * @param metamodels the meta model(s) to register 
     */
    public static void initXpand(MetaModel... metamodels) {
        XpandUnit.metamodels = metamodels;
    }
    
    /**
     * Initializes XpandUnit.
     * @param epackage the interface name of the generated EPackage to register
     * @param metamodels the meta model(s) to register 
     */
    public static void initXpand(String epackage, MetaModel... metamodels) {
        StandaloneSetup setup = new StandaloneSetup();
    	setup.addRegisterGeneratedEPackage(epackage);
        XpandUnit.metamodels = metamodels;
    }
    
    /**
     * Expands the template <tt>template</tt> for <tt>target</tt>. Returns the
     * generator output.
     */
    public static String xpand(String template, Object target) {
        return xpand(template, target, new HashMap<String, Object>());
    }
    
    /**
     * Expands the template <tt>template</tt> for <tt>target</tt>, using the given
     * global variables. Returns the generator output.
     */
    public static String xpand(String template, Object target, Map<String, Object> globalvars) {
        StringOutput output = new StringOutput();
        Outlet defaultOutlet = new Outlet();
        defaultOutlet.setPath("src-gen");
        output.addOutlet(defaultOutlet);
        xpand(template, target, globalvars, output);
        return output.getOutput();
    }
    
    /**
     * Expands the template <tt>template</tt> for <tt>target</tt>, using the given
     * global variables. The output is written to <tt>outputFolder</tt> and is
     * processed by the given post processors <tt>postProcessors</tt>.
     */
    public static void xpand(String template, Object target, Map<String, Object> globalvars, File outputFolder, PostProcessor... postProcessors) {
        Output output = new OutputImpl();
        Outlet defaultOutlet = new Outlet();
        defaultOutlet.setPath(outputFolder.toString());
        for (PostProcessor pp : postProcessors) {
        	defaultOutlet.addPostprocessor(pp);
        }
        output.addOutlet(defaultOutlet);
        xpand(template, target, globalvars, output);
    }
    
    private static void xpand(String template, Object target, Map<String, Object> globalvars, Output output) {
        Map<String, Variable> gv = new HashMap<String, Variable>();
        for (Map.Entry<String, Object> entry : globalvars.entrySet()) {
			gv.put(entry.getKey(), new Variable(entry.getKey(), entry.getValue()));
		}
        XpandExecutionContextImpl ctx = new XpandExecutionContextImpl(output, null, gv, null, null);
        for (MetaModel mm : metamodels) {
        	ctx.registerMetaModel(mm);
		}
        XpandFacade facade = XpandFacade.create(ctx);
        facade.evaluate(template, target);
    }

    /**
     * Internal class to capture the generator output.
     */
    private static class StringOutput extends OutputImpl {
        FileHandle current = new DummyFileHandle();
        private String getOutput() {
            return current.getBuffer().toString();
        }
        protected FileHandle current() {
            return current;
        }
        public void closeFile() {
    	}
        public void openFile(String path, String outletName) {
        }
    }
    
    /**
     * Internal class to capture the generator output.
     */
    private static class DummyFileHandle implements FileHandle {
        StringBuffer buffer = new StringBuffer();
        public CharSequence getBuffer() {
            return buffer;
        }
        public void setBuffer(CharSequence b) {
            buffer = new StringBuffer(b);
        }
        public String getFileEncoding() {
            throw new UnsupportedOperationException();
        }
        public Outlet getOutlet() {
            throw new UnsupportedOperationException();
        }
        // deprecated in Xpand 1.0
        public File getTargetFile() {
            throw new UnsupportedOperationException();
        }
        public boolean isAppend() {
            throw new UnsupportedOperationException();
        }
        public boolean isOverwrite() {
            throw new UnsupportedOperationException();
        }
        public void writeAndClose() {
            throw new UnsupportedOperationException();
        }
        // for Xpand 1.0
        @SuppressWarnings("unused")
		public String getAbsolutePath() {
        	throw new UnsupportedOperationException();
        }
    }
}

