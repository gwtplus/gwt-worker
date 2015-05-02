package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.MessagePortJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.web.bindery.event.shared.HandlerRegistration;

@SingleJsoImpl(MessagePortJsoImpl.class)
public interface MessagePort {
	
	//TODO: support different message types (structured clone algorithm is used for message)
	void postMessage(String message);
	
	void postMessage(String message, ArrayBuffer... buffers);
	
	void postMessage(String message, MessagePort... ports);
	
	//void postMessage(String message, CanvasProxy... proxies);
	
	void start();
	
	void close();
	
	HandlerRegistration addMessageHandler(MessageEvent.Handler handler);
}
