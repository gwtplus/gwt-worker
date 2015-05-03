package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.shared.service.ServiceWorkerScope;
import org.gwtproject.gwt.worker.shared.shared.SharedWorkerScope;

import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * WorkerGlobalScope
 */
public interface AbstractWorkerScope {
	
	//not needed in gwt since we already have instance
	//AbstractWorkerScope getSelf();
	
	boolean isDedicated();
	
	WorkerScope asDedicated();
	
	boolean isShared();
	
	SharedWorkerScope asShared();
	
	boolean isService();
	
	ServiceWorkerScope asService();
	
	WorkerLocation getLocation();
	
	WorkerNavigator getNavigator();
	
	void importScripts(String... urls);
	
	void close();
	
	HandlerRegistration addErrorHandler(ErrorEvent.Handler handler);
	
	HandlerRegistration addLanguageChangeHandler(LanguageChangeEvent.Handler handler);
	
	HandlerRegistration addConnectivityHandler(ConnectivityEvent.Handler handler);
}
