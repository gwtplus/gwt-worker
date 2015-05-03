package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.shared.service.ServiceWorker;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

import com.google.gwt.typedarrays.shared.ArrayBuffer;

public abstract class WorkersBaseImpl {
	
	public abstract boolean isDedicatedSupported();
	
	public abstract boolean isSharedSupported();
	
	public abstract boolean isServiceSupported();

	public abstract boolean inWorker();
	
	public abstract Worker newWorker(String scriptUrl);
	
	public abstract SharedWorker newSharedWorker(String scriptUrl, String name);
	
	public abstract Promise<ServiceWorker> registerServiceWorker(String url);
	
	public abstract AbstractWorkerScope getScope();

	public abstract Transferable asTransferable(ArrayBuffer buffer);
	
	public abstract Transferable asTransferable(MessagePort port);
}
