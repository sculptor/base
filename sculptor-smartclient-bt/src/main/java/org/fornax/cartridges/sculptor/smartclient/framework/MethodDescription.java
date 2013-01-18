package org.fornax.cartridges.sculptor.smartclient.framework;

import java.lang.reflect.Method;

import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.DetailBehavior;
import org.fornax.cartridges.sculptor.framework.annotation.GuiHints.VisibleOn;

public class MethodDescription {
	public DetailBehavior detailBehavior=DetailBehavior.ON_VIEW;
	public Method method; // Should be null from decorator (gui action or Rule action)
	public String title;
	public String name;
	public String[] parameterNames;
	public String[] parameterTypes;
	public String[] ifStatus;
	public String[] ifRole;
	public VisibleOn visibleOn;
	public String doAction;
	public String jsonPostfix;
	public boolean requireConfirmation=false;

	public String[] getIfRole() {
		return ifRole;
	}

	public String[] getIfStatus() {
		return ifStatus;
	}
	
	public VisibleOn getVisibleOn() {
		return visibleOn;
	}

	public String getTranslateGuiName() {
		return title == null ? name : title;
	}

	public String getTranslateGuiHover() {
		return (title == null ? name : title) + "Hover";
	}

	public DetailBehavior getDetailBehavior() {
		return detailBehavior;
	}

	public String getDoAction() {
		return doAction;
	}

	public String getMethodName() {
		return name;
	}

	public String[] getParameterNames() {
		return parameterNames;
	}

	public String[] getParameterTypes() {
		return parameterTypes;
	}

	public String getJsonPostfix() {
		return jsonPostfix;
	}

	public Boolean getRequireConfirmation() {
		return requireConfirmation;
	}

	public String toString() {
		StringBuilder sb=new StringBuilder("MethodDescription: ");
		sb.append(name).append("{detailBehavior=").append(detailBehavior);
		sb.append(", parameterNames=[");
		if (parameterNames != null) {
			String delim="";
			for (int i = 0; i < parameterNames.length; i++) {
				sb.append(delim).append(parameterNames[i]);
				delim=",";
			}
		}
		sb.append("]");

		sb.append(", ifStatus=[");
		if (ifStatus != null) {
			String delim="";
			for (int i = 0; i < ifStatus.length; i++) {
				sb.append(delim).append(ifStatus[i]);
				delim=",";
			}
		}
		sb.append("]");

		sb.append(", ifRole=[");
		if (ifRole != null) {
			String delim="";
			for (int i = 0; i < ifRole.length; i++) {
				sb.append(delim).append(ifRole[i]);
				delim=",";
			}
		}
		sb.append("], requireConfirmation=").append(requireConfirmation);
		sb.append("}");

		return sb.toString();
	}
}
