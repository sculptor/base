package org.fornax.cartridges.sculptor.smartclient.framework;

import java.io.Serializable;

import org.fornax.cartridges.sculptor.framework.errorhandling.ApplicationException;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;

public class StringUtil {
	public static final String SPLIT_REGEX = "[,;: ]";
	public static final String MESSAGE_FOR_USER = "messageForUser";

	public static void throwApplicationException(String errCode, String message, Serializable... parameters) throws ApplicationException {
		ApplicationException ex=new ApplicationException(message, errCode);
		ex.setMessageParameters(parameters);
		throw ex;
	}

	public static boolean findStringInList(String find, String string) {
		if (string != null) {
			String[] split = string.split(SPLIT_REGEX);
			for (String subStr : split) {
				if (subStr.equals(find)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasItem(String string) {
		if (string != null) {
			String[] split = string.split(SPLIT_REGEX);
			for (String s : split) {
				if (s.length() > 0) {
					return true;
				}
			}
		}
	
		return false;
	}

	public static Translatable getTranslatable(Serializable ser) {
		return new Translatable(ser.toString());
	}

	public static void setResponseInfoMessage(String message) {
		ServiceContextStore.get().setProperty(MESSAGE_FOR_USER, message);
	}

	public static String getResponseInfoMessage() {
		return (String) ServiceContextStore.get().getProperty(MESSAGE_FOR_USER);
	}
}
