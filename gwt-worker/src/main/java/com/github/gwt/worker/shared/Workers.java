package com.github.gwt.worker.shared;

import com.github.gwt.worker.shared.service.ServiceWorker;
import com.github.gwt.worker.shared.shared.SharedWorker;

public class Workers {
	
	public static native boolean isWorker()/*-{
		return $isWorker;
	}-*/;

	public static native Worker newWorker(String scriptUrl) /*-{
		return new Worker(scriptUrl);
	}-*/;
	
	public static native SharedWorker newSharedWorker(String scriptUrl, String name)/*-{
		return new SharedWorker(scriptUrl, name);
	}-*/;
	
	public Promise<ServiceWorker> registerServiceWorker(String url) {
		return null;
	}
	
	public <T extends AbstractWorkerScope> T getSelf() {
		return null;
	}
}
