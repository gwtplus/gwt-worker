package com.github.gwt.worker.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

final class EventListeners {

	private EventListeners() {
		
	}
	
	private static native JavaScriptObject getListener(EventListener listener)/*-{
		var l = listener;
		var func = function(event) {
			l.@com.google.gwt.user.client.EventListener::onBrowserEvent(Lcom/google/gwt/user/client/Event;)(event);
		};
		return $entry(func);
	}-*/;
	
	private static native void addEventListener(JavaScriptObject obj, String type, JavaScriptObject l) /*-{
		obj.addEventListener(type, l);
	}-*/;

	private static native void removeEventListener(JavaScriptObject obj, String type, JavaScriptObject l) /*-{
		obj.removeEventListener(type, l);
	}-*/;
	
	public static HandlerRegistration register(JavaScriptObject object, String type, EventListener listener) {
		JavaScriptObject l = getListener(listener);
		
		addEventListener(object, type, l);
		
		return new HandlerRegistrationImpl(object, type, l);
	}
	
	private static class HandlerRegistrationImpl implements HandlerRegistration {
		
		private JavaScriptObject mObject;
		private String mType;
		private JavaScriptObject mListener;

		public HandlerRegistrationImpl(JavaScriptObject object, String type, JavaScriptObject listener) {
			mObject = object;
			mType = type;
			mListener = listener;
		}
		
		@Override
		public void removeHandler() {
			removeEventListener(mObject, mType, mListener);
		}
	}
}
