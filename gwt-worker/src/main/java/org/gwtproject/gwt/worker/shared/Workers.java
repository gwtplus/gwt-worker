package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.WorkersJsoImpl;
import org.gwtproject.gwt.worker.shared.service.ServiceWorker;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

public class Workers {
	
	protected static WorkersBaseImpl sImpl = new WorkersJsoImpl();
	
	public static boolean isDedicatedSupported() {
		return sImpl.isDedicatedSupported();
	}
	
	public static boolean isSharedSupported() {
		return sImpl.isSharedSupported();
	}
	
	public static boolean isServiceSupported() {
		return sImpl.isServiceSupported();
	}
	
	/**
	 * Checks if code is running in worker context
	 */
	public static boolean inWorker() {
		return sImpl.inWorker();
	}

	/**
	 * Creates new dedicated worker
	 * @param scriptUrl
	 * @return
	 */
	public static Worker newWorker(String scriptUrl) {
		if(!sImpl.isDedicatedSupported()) {
			//TODO maybe support emulation by injecting worker script into the page?
			throw new UnsupportedOperationException("Worker not supported");
		}
		
		return sImpl.newWorker(scriptUrl);
	}
	
	/**
	 * Creates new shared worker instance (or returns current instance)
	 * @param scriptUrl
	 * @param name
	 * @return
	 */
	public static SharedWorker newSharedWorker(String scriptUrl, String name) {
		if(!sImpl.isSharedSupported()) {
			throw new UnsupportedOperationException("Shared Worker not supported");
		}
		
		return sImpl.newSharedWorker(scriptUrl, name);
	}
	
	/**
	 * Registers new service worker
	 * @param url
	 * @return
	 */
	public static Promise<ServiceWorker> registerServiceWorker(String url) {
		if(!sImpl.isServiceSupported()) {
			throw new UnsupportedOperationException("Service Worker not supported");
		}
		
		return sImpl.registerServiceWorker(url);
	}
	
	/**
	 * Gets current scope (dedicated, shared, service or emulated)
	 * 
	 * @return
	 */
	public static AbstractWorkerScope getScope() {
		if(!sImpl.inWorker()) {
			throw new UnsupportedOperationException("Not in worker scope");
		}
		
		return sImpl.getScope();
	}
}
