package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.WorkersJsoImpl;
import org.gwtproject.gwt.worker.shared.service.ServiceWorker;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

public class Workers {
	
	protected static WorkersBaseImpl sImpl = new WorkersJsoImpl();
	
	/**
	 * Checks if code is running in worker context
	 */
	public static boolean inWorkerContext() {
		return sImpl.inWorkerContext();
	}

	/**
	 * Creates new dedicated worker
	 * @param scriptUrl
	 * @return
	 */
	public static Worker newWorker(String scriptUrl) {
		return sImpl.newWorker(scriptUrl);
	}
	
	/**
	 * Creates new shared worker instance (or returns current instance)
	 * @param scriptUrl
	 * @param name
	 * @return
	 */
	public static SharedWorker newSharedWorker(String scriptUrl, String name) {
		return sImpl.newSharedWorker(scriptUrl, name);
	}
	
	/**
	 * Registers new service worker
	 * @param url
	 * @return
	 */
	public Promise<ServiceWorker> registerServiceWorker(String url) {
		return sImpl.registerServiceWorker(url);
	}
	
	/**
	 * Gets current scope (dedicated, shared, service or emulated)
	 * 
	 * @return
	 */
	public AbstractWorkerScope getScope() {
		return sImpl.getScope();
	}
}
