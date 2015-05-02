package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.MessagePortJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.web.bindery.event.shared.HandlerRegistration;

@SingleJsoImpl(MessagePortJsoImpl.class)
public interface MessagePort {
	
	void postMessage(String message);
	
	/**
	 * Just an example that post message allows sending Transferable objects:
	 * ArrayBuffer or CanvasProxy or MessagePort
	 * 
	 * @param message
	 * @param buffer
	 */
	void postMessage(String message, ArrayBuffer... buffer);
	
	void start();
	
	void close();
	
	HandlerRegistration addMessageHandler(MessageEvent.Handler handler);
}
