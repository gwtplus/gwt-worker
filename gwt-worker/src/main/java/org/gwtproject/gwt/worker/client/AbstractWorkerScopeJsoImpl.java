package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.WorkerLocation;
import org.gwtproject.gwt.worker.shared.WorkerNavigator;
import org.gwtproject.gwt.worker.shared.WorkerScope;
import org.gwtproject.gwt.worker.shared.service.ServiceWorkerScope;
import org.gwtproject.gwt.worker.shared.shared.SharedWorkerScope;

import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AbstractWorkerScopeJsoImpl extends EventTarget implements
		AbstractWorkerScope {

	protected AbstractWorkerScopeJsoImpl() {

	}
	
	@Override
	public final boolean isShared() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isService() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isDedicated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final WorkerScope asDedicated() {
		return (WorkerScope) this;
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
		// TODO Auto-generated method stub

	}

	@Override
	public final native void close() /*-{
		this.close();
	}-*/;

	@Override
	public final HandlerRegistration addErrorHandler(ErrorHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final HandlerRegistration addLanguageChangeHandler(Object handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final HandlerRegistration addOnlineHandler(Object handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final HandlerRegistration addOfflineHandler(Object handler) {
		// TODO Auto-generated method stub
		return null;
	}
}
