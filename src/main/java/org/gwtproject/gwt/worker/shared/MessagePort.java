package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.MessagePortJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(MessagePortJsoImpl.class)
public interface MessagePort extends MessagePortRef {
	
	void start();
	
	void close();
}
