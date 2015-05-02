package org.gwtproject.gwt.worker.shared.service;

import org.gwtproject.gwt.worker.shared.Promise;

import com.google.web.bindery.event.shared.HandlerRegistration;

public interface ServiceWorkerRegistration {

	ServiceWorker getInstalling();
	
	ServiceWorker getWaiting();
	
	ServiceWorker getActive();
	
	String getScope();
	
	void update();
	
	Promise<Boolean> unregister();
	
	HandlerRegistration addUpdateFoundHandler(Object handler);
}
