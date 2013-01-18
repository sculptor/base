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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.MetaModel;

public class XtendUnit {
	
	private static MetaModel[] metamodels = new MetaModel[0]; 
	
    /**
     * Initializes XtendUnit.
     * @param metamodels the meta model(s) to register 
     */
    public static void initXtend(MetaModel... metamodels) {
        XtendUnit.metamodels = metamodels;
    }
    
    /**
     * Initializes XtendUnit.
     * @param epackage the interface name of the generated EPackage to register
     * @param metamodels the meta model(s) to register 
     */
    public static void initXtend(String epackage, MetaModel... metamodels) {
        StandaloneSetup setup = new StandaloneSetup();
       	setup.addRegisterGeneratedEPackage(epackage);
        XtendUnit.metamodels = metamodels;
    }
    
    /**
     * Calls the function <tt>function</tt> in the extension <tt>extension</tt>
     * with the parameters <tt>args</tt>. Returns the result of the function
     * call.
     */
    public static Object xtend(String extension, String function, List<?> args) {
    	return xtend(extension, function, args, new HashMap<String, Object>());
    }
    
    /**
     * Calls the function <tt>function</tt> in the extension <tt>extension</tt>
     * with the parameters <tt>args</tt>. Returns the result of the function
     * call.
     */
    public static Object xtend(String extension, String function, List<?> args, Map<String, Object> globalvars) {
        Map<String, Variable> gv = new HashMap<String, Variable>();
        for (Map.Entry<String, Object> entry : globalvars.entrySet()) {
			gv.put(entry.getKey(), new Variable(entry.getKey(), entry.getValue()));
		}
        ExecutionContextImpl ctx = new ExecutionContextImpl(gv);
        for (MetaModel mm : metamodels) {
        	ctx.registerMetaModel(mm);
		}
        XtendFacade facade = XtendFacade.create(ctx, extension);
        return facade.call(function, args);
    }

}
