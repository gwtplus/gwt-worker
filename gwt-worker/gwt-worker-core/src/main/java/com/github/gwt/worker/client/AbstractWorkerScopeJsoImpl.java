package com.github.gwt.worker.client;

import com.github.gwt.worker.shared.AbstractWorkerScope;
import com.github.gwt.worker.shared.WorkerLocation;
import com.github.gwt.worker.shared.WorkerNavigator;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AbstractWorkerScopeJsoImpl extends EventTarget implements
		AbstractWorkerScope {

	protected AbstractWorkerScopeJsoImpl() {

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
