/*
 * (C) Copyright Factory4Solutions a.s. 2009
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
package org.fornax.cartridges.sculptor.smartclient.server.util;

import java.util.List;

import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.DetailBehavior;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.VisibleOn;
import org.fornax.cartridges.sculptor.smartclient.framework.GuiDecorator;
import org.fornax.cartridges.sculptor.smartclient.framework.MethodDescription;
import org.fornax.cartridges.sculptor.smartclient.framework.ServiceDescription;

/**
 * GuiDecorator which add "Debug" button to form
 * 
 * @author Ing. Pavel Tavoda
 */
public class DebugDecorator implements GuiDecorator {
	public void decorateServiceDescriptor(List<ServiceDescription> initDescription) {
		if (developmentMode) {
			MethodDescription debugDesc=new MethodDescription();
			debugDesc.visibleOn=VisibleOn.ON_LIST;
			debugDesc.detailBehavior=DetailBehavior.ON_VIEW;
			debugDesc.name="Debug";
			debugDesc.doAction="debug";

			for (ServiceDescription serviceDescription : initDescription) {
				serviceDescription.getOtherMethods().put("Debug", debugDesc);
			}
		}
	}

	public boolean isDevelopmentMode() {
		return developmentMode;
	}

	public void setDevelopmentMode(boolean developmentMode) {
		this.developmentMode = developmentMode;
	}

	private boolean developmentMode;
}
