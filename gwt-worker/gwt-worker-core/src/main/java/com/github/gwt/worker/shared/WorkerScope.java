package com.github.gwt.worker.shared;


/**
 * DedicatedWorkerGlobalScope
 *
 */
public interface WorkerScope extends AbstractWorkerScope {
	
	MessagePort asMessagePort(); 
}
