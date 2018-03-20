package org.gwtproject.gwt.worker.client;

import static org.gwtproject.gwt.worker.client.EventListeners.register;

import org.gwtproject.gwt.worker.shared.MessageHandler;
import org.gwtproject.gwt.worker.shared.MessagePortRef;
import org.gwtproject.gwt.worker.shared.Transferable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayUtils;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class MessagePortRefJsoImpl extends JavaScriptObject implements MessagePortRef {

	protected MessagePortRefJsoImpl() {
	}
	
	@Override
	public final native void postMessage(int message)/*-{
		this.postMessage(message);
	}-*/;
	
	@Override
	public final native void postMessage(String message)/*-{
		this.postMessage(message);
	}-*/;
	
	@Override
	public final native void postMessage(JavaScriptObject message)/*-{
		this.postMessage(message);
	}-*/;

	@Override
	public final void postMessage(int message, Transferable... t) {
		JsArray<TransferableJsoImpl> ts = JsArrayUtils.readOnlyJsArray((TransferableJsoImpl[])t);
		postMessage(message, ts);
	}
	
	private final native void postMessage(int message, JsArray<TransferableJsoImpl> ts)/*-{
		this.postMessage(message, ts);
	}-*/;
	
	@Override
	public final void postMessage(String message, Transferable... t) {
		JsArray<TransferableJsoImpl> ts = JsArrayUtils.readOnlyJsArray((TransferableJsoImpl[])t);
		postMessage(message, ts);
	}
	
	private final native void postMessage(String message, JsArray<TransferableJsoImpl> ts)/*-{
		this.postMessage(message, ts);
	}-*/;
	
	@Override
	public final void postMessage(JavaScriptObject message, Transferable... t) {
		JsArray<TransferableJsoImpl> ts = JsArrayUtils.readOnlyJsArray((TransferableJsoImpl[])t);
		postMessage(message, ts);
	}
	
	private final native void postMessage(JavaScriptObject message, JsArray<TransferableJsoImpl> ts)/*-{
		this.postMessage(message, ts);
	}-*/;

	@Override
	public final HandlerRegistration addMessageHandler(final MessageHandler handler) {
		return register(this, "message", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onMessage((MessageEventJsoImpl) event.cast());
			}
		});
	}
}
