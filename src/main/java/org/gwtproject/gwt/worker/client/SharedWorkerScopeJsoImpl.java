package org.gwtproject.gwt.worker.client;

import static org.gwtproject.gwt.worker.client.EventListeners.register;

import org.gwtproject.gwt.worker.shared.ConnectHandler;
import org.gwtproject.gwt.worker.shared.shared.SharedWorkerScope;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class SharedWorkerScopeJsoImpl extends AbstractWorkerScopeJsoImpl
		implements SharedWorkerScope {

	protected SharedWorkerScopeJsoImpl() {
	}
	
	@Override
	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * Support for application cache is not the point of this library
	 */
	@Override
	public final native JavaScriptObject getApplicationCache()/*-{
		return this.applicationCache;
	}-*/;

	@Override
	public final HandlerRegistration addConnectHandler(final ConnectHandler handler) {
		return register(this, "connect", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onConnect((MessageEventJsoImpl) event.cast());
			}
		});
	}
}
