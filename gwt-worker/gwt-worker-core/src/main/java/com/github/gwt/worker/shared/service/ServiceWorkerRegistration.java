package com.github.gwt.worker.shared.service;

import com.github.gwt.worker.shared.Promise;
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
