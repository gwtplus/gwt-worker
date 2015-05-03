package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.MessagePortRefJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Message port handle which doesn't allow starting or closing
 * Mainly used for dedicated worker which is implicitly a message port ref
 */
@SingleJsoImpl(MessagePortRefJsoImpl.class)
public interface MessagePortRef {

	//TODO: support different message types (structured clone algorithm is used for message)
	void postMessage(String message);
	
	void postMessage(String message, ArrayBuffer... buffers);
	
	void postMessage(String message, MessagePort... ports);
	
	//void postMessage(String message, CanvasProxy... proxies);
	
	HandlerRegistration addMessageHandler(MessageHandler handler);
}
