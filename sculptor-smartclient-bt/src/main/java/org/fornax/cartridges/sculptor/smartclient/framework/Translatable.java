package org.fornax.cartridges.sculptor.smartclient.framework;

import java.io.Serializable;

public class Translatable implements Serializable {
	private static final long serialVersionUID = -699604312554871868L;
	private String obj;

	public Translatable(String str) {
		obj=str;
	}

	public String getContent() {
		return obj;
	}
}
