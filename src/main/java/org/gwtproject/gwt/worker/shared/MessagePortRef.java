package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.MessagePortRefJsoImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.SingleJsoImpl;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Message port handle which doesn't allow starting or closing
 * Mainly used for dedicated worker which is implicitly a message port ref
 */
@SingleJsoImpl(MessagePortRefJsoImpl.class)
public interface MessagePortRef {
	
	void postMessage(int message);
	
	void postMessage(String message);
	
	void postMessage(JavaScriptObject message);
	
	void postMessage(int message, Transferable... t);
	
	void postMessage(String message, Transferable... t);
	
	void postMessage(JavaScriptObject message, Transferable... t);
	
	HandlerRegistration addMessageHandler(MessageHandler handler);
}
