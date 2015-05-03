package org.gwtproject.gwt.worker.client;

import static org.gwtproject.gwt.worker.client.EventListeners.register;

import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.ConnectivityEvent;
import org.gwtproject.gwt.worker.shared.ErrorEvent;
import org.gwtproject.gwt.worker.shared.LanguageChangeEvent;
import org.gwtproject.gwt.worker.shared.WorkerLocation;
import org.gwtproject.gwt.worker.shared.WorkerNavigator;
import org.gwtproject.gwt.worker.shared.WorkerScope;
import org.gwtproject.gwt.worker.shared.service.ServiceWorkerScope;
import org.gwtproject.gwt.worker.shared.shared.SharedWorkerScope;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AbstractWorkerScopeJsoImpl extends EventTarget implements
		AbstractWorkerScope {

	protected AbstractWorkerScopeJsoImpl() {

	}
	
	@Override
	public final native boolean isShared() /*-{
		return typeof SharedWorkerGlobalScope === 'function';
	}-*/;

	@Override
	public final native boolean isService() /*-{
		return typeof ServiceWorkerGlobalScope === 'function';
	}-*/;

	@Override
	public final native boolean isDedicated() /*-{
		return typeof DedicatedWorkerGlobalScope === 'function';
	}-*/;

	@Override
	public final WorkerScope asDedicated() {
		return (WorkerScopeJsoImpl) this.cast();
	}

	@Override
	public final SharedWorkerScope asShared() {
		return (SharedWorkerScope) this;
	}

	@Override
	public final ServiceWorkerScope asService() {
		return (ServiceWorkerScope) this;
	}

	@Override
	public final native WorkerLocation getLocation()/*-{
		return this.location;
	}-*/;

	@Override
	public final native WorkerNavigator getNavigator()/*-{
		return this.navigator;
	}-*/;

	@Override
	public final void importScripts(String... urls) {
		if(urls.length == 0) {
			return;
		}
		
		JsArrayString us = JsArray.createArray().cast();
		for(String url : urls) {
			us.push(url);
		}
		
		importScripts0(us);
	}
	
	private final native void importScripts0(JsArrayString urls) /*-{
		this.importScripts(urls);
	}-*/;

	@Override
	public final native void close() /*-{
		this.close();
	}-*/;

	@Override
	public final HandlerRegistration addErrorHandler(final ErrorEvent.Handler handler) {
		return register(this, "error", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onError((ErrorEventJsoImpl) event.cast());
			}
		});
	}

	@Override
	public HandlerRegistration addLanguageChangeHandler(final LanguageChangeEvent.Handler handler) {
		return register(this, "languagechange", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onLanguageChange((LanguageChangeEventJsoImpl) event.cast());
			}
		});
	}

	@Override
	public HandlerRegistration addConnectivityHandler(final ConnectivityEvent.Handler handler) {
		EventListener el = new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onConnectivity((ConnectivityEventJsoImpl) event.cast());
			}
		};
		
		final HandlerRegistration hr1 = register(this, "online", el);
		final HandlerRegistration hr2 = register(this, "offline", el);
		
		return new HandlerRegistration() {
			
			@Override
			public void removeHandler() {
				hr1.removeHandler();
				hr2.removeHandler();
			}
		};
	}
}
