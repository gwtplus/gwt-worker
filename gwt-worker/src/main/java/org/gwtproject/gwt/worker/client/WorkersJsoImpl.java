package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.client.WorkerSupport.ServiceWorkerDetector;
import org.gwtproject.gwt.worker.client.WorkerSupport.SharedWorkerDetector;
import org.gwtproject.gwt.worker.client.WorkerSupport.WorkerDetector;
import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.MessagePort;
import org.gwtproject.gwt.worker.shared.Promise;
import org.gwtproject.gwt.worker.shared.Transferable;
import org.gwtproject.gwt.worker.shared.Worker;
import org.gwtproject.gwt.worker.shared.WorkersBaseImpl;
import org.gwtproject.gwt.worker.shared.service.ServiceWorker;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.typedarrays.shared.ArrayBuffer;

public class WorkersJsoImpl extends WorkersBaseImpl {

	private static WorkerDetector sWorkerDetector;
	private static SharedWorkerDetector sSharedDetector;
	private static ServiceWorkerDetector sServiceDetector;
	
	@Override
	public boolean isDedicatedSupported() {
		if(sWorkerDetector == null) {
			sWorkerDetector = GWT.create(WorkerDetector.class);
		}
		
		if(!sWorkerDetector.isSupportedCompileTime()) {
			return false;
		}
		
		return sWorkerDetector.isSupportedRunTime();
	}

	@Override
	public boolean isSharedSupported() {
		if(sSharedDetector == null) {
			sSharedDetector = GWT.create(SharedWorkerDetector.class);
		}
		
		if(!sSharedDetector.isSupportedCompileTime()) {
			return false;
		}
		
		return sSharedDetector.isSupportedRunTime();
	}
	
	@Override
	public boolean isServiceSupported() {
		if(sServiceDetector == null) {
			sServiceDetector = GWT.create(ServiceWorkerDetector.class);
		}
		
		if(!sServiceDetector.isSupportedCompileTime()) {
			return false;
		}
		
		return sServiceDetector.isSupportedRunTime();
	}
	
	@Override
	public native boolean inWorker()/*-{
		return typeof $wnd.importScripts === 'function';
	}-*/;
	
	@Override
	public native AbstractWorkerScope getScope()/*-{
		return $self;
	}-*/;

	@Override
	public native Worker newWorker(String scriptUrl) /*-{
		return new Worker(scriptUrl);
	}-*/;
	
	@Override
	public native SharedWorker newSharedWorker(String scriptUrl, String name)/*-{
		return new SharedWorker(scriptUrl, name);
	}-*/;
	
	@Override
	public Promise<ServiceWorker> registerServiceWorker(String url) {
		//TODO: implement registering of service workers
		return null;
	}

	@Override
	public native Transferable asTransferable(ArrayBuffer buffer) /*-{
		return buffer;
	}-*/;

	@Override
	public native Transferable asTransferable(MessagePort port) /*-{
		return port;
	}-*/;

}
