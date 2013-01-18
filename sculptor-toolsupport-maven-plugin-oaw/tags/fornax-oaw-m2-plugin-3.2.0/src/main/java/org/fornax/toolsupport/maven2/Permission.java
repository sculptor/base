/*
 *	Copyright 2006-2010 The Fornax Project Team
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 * 	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 * 	Unless required by applicable law or agreed to in writing, software
 * 	distributed under the License is distributed on an "AS IS" BASIS,
 * 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 	See the License for the specific language governing permissions and
 * 	limitations under the License.
 */
package org.fornax.toolsupport.maven2;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * Represents a permission.
 * @author Karsten Thoms
 * @since 3.2.0
 * @see http://ant.apache.org/manual/Types/permissions.html
 */
public class Permission {
	/** The fully qualified name of the Permission class. Required. */
	private String className;
	/** The name of the Permission. The actual contents depends on the Permission class. Optional. */
	private String name;
	/** The actions allowed. The actual contents depend on the Permission class and name. Optional. */
	private String actions;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getActions() {
		return actions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public org.apache.tools.ant.types.Permissions.Permission toAntPermission () {
		org.apache.tools.ant.types.Permissions.Permission result = new org.apache.tools.ant.types.Permissions.Permission();
		result.setName(name);
		result.setClass(className);
		if (actions!=null) {
			result.setActions(actions);
		}
		return result;
	}
}
