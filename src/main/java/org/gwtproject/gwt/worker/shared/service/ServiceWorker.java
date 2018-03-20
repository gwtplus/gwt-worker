package org.gwtproject.gwt.worker.shared.service;

import org.gwtproject.gwt.worker.shared.AbstractWorker;

import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 *
 * @see http://slightlyoff.github.io/ServiceWorker/spec/service_worker/
 */
public interface ServiceWorker extends AbstractWorker {

	enum State {
		/**
		 * 
		 */
		INSTALLING,
		/**
		   * 
		   */
		INSTALLED,
		/**
		   * 
		   */
		ACTIVATING,
		/**
		   * 
		   */
		ACTIVATED,
		/**
		   * 
		   */
		REDUNDANT;
	}

	String getId();

	String getScriptUrl();

	State getState();

	HandlerRegistration addStateChangeHandler(Object handler);
}
