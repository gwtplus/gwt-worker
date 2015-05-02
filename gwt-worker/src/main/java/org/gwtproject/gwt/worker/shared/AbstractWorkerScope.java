package org.gwtproject.gwt.worker.shared;

import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * WorkerGlobalScope
 */
public interface AbstractWorkerScope {

	//not needed in gwt since we already have instance
	//AbstractWorkerScope getSelf();
	
	WorkerLocation getLocation();
	
	WorkerNavigator getNavigator();
	
	void importScripts(String... urls);
	
	void close();
	
	HandlerRegistration addErrorHandler(ErrorHandler handler);
	
	HandlerRegistration addLanguageChangeHandler(Object handler);
	
	HandlerRegistration addOnlineHandler(Object handler);
	
	HandlerRegistration addOfflineHandler(Object handler);
}
