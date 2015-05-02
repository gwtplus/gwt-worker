package com.github.gwt.worker.client;

import static com.github.gwt.worker.client.EventListeners.register;

import com.github.gwt.worker.shared.MessageEvent;
import com.github.gwt.worker.shared.MessagePort;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayUtils;
import com.google.gwt.typedarrays.client.ArrayBufferNative;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class MessagePortJsoImpl extends JavaScriptObject implements MessagePort {

	protected MessagePortJsoImpl() {
	}
	
	@Override
	public final native void postMessage(String message)/*-{
		this.postMessage(message);
	}-*/;

	@Override
	public final void postMessage(String message, ArrayBuffer... buffer) {
		JsArray<ArrayBufferNative> buffers = JsArrayUtils.readOnlyJsArray((ArrayBufferNative[])buffer);
		postMessage(message, buffers);
	}
	
	private final native void postMessage(String message, JsArray<ArrayBufferNative> buffer)/*-{
		this.postMessage(message, buffer);
	}-*/;

	@Override
	public final native void start()/*-{
		this.start();
	}-*/;

	@Override
	public final native void close()/*-{
		this.close();
	}-*/;

	@Override
	public final HandlerRegistration addMessageHandler(final MessageEvent.Handler handler) {
		return register(this, "message", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onMessage((MessageEventJsoImpl) event.cast());
			}
		});
	}
}
