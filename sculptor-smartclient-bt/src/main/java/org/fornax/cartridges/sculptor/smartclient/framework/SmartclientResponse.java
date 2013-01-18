package org.fornax.cartridges.sculptor.smartclient.framework;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import org.fornax.cartridges.sculptor.smartclient.quartz.ServiceInvoker;

public abstract class SmartclientResponse {
	String contentType;
	HashMap<String, String> header=new HashMap<String,String>();
	String messageForUser=null;

	public String getMessageForUser() {
		return messageForUser;
	}

	public void setMessageForUser(String messageForUser) {
		this.messageForUser = messageForUser;
	}

	public SmartclientResponse(String contentType) {
		this.contentType=contentType;
	}

	public void addHeader(String key, String value) {
		header.put(key, value);
	}

	public void addHeader(HashMap<String, String> items) {
		header.putAll(items);
	}

	public void setHeader(HashMap<String, String> items) {
		header=items;
	}

	public String getContentType() {
		return this.contentType;
	}

	public HashMap<String, String> getHeader() {
		return header;
	}

	public abstract void writeOutput(OutputStream output, ServiceInvoker invoker) throws IOException;
}