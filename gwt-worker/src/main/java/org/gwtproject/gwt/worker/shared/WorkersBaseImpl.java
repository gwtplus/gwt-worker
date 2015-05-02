package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.shared.service.ServiceWorker;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

public abstract class WorkersBaseImpl {

	public abstract boolean inWorkerContext();
	
	public abstract Worker newWorker(String scriptUrl);
	
	public abstract SharedWorker newSharedWorker(String scriptUrl, String name);
	
	public abstract Promise<ServiceWorker> registerServiceWorker(String url);
	
	public abstract AbstractWorkerScope getScope();
}
