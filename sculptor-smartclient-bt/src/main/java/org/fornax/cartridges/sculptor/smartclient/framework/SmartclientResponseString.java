package org.fornax.cartridges.sculptor.smartclient.framework;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.fornax.cartridges.sculptor.smartclient.quartz.ServiceInvoker;

public class SmartclientResponseString extends SmartclientResponse {
	String content;

	public SmartclientResponseString(String content) {
		super("text/plain;charset=UTF-8");
		addHeader("Cache-Control", "no-cache");
		addHeader("Expires", "-1");

		this.content=content;
	}

	public void setContent(String content) {
		this.content=content;
	}

	public void writeOutput(OutputStream output, ServiceInvoker invoker) throws IOException {
		if (content != null) {
			Writer os=new OutputStreamWriter(output, Charset.forName("UTF-8"));
			os.write(content, 0, content.length());
			os.close();
		}
	}
}