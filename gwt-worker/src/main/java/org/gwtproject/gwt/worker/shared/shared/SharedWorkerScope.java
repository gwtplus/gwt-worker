package org.gwtproject.gwt.worker.shared.shared;

import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.ConnectHandler;

import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * SharedWorkerGlobalScope
 *
 */
public interface SharedWorkerScope extends AbstractWorkerScope {

	String getName();
	
	Object getApplicationCache();
	
	HandlerRegistration addConnectHandler(ConnectHandler handler);
}
