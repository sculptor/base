package org.fornax.cartridges.sculptor.smartclient.framework;

public interface MessageBroadcaster {
	public int broadcastMessage(Object message, String... destinations);
}
