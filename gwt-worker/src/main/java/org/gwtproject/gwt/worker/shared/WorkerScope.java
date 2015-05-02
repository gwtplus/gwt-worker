package org.gwtproject.gwt.worker.shared;


/**
 * DedicatedWorkerGlobalScope
 *
 */
public interface WorkerScope extends AbstractWorkerScope {
	
	MessagePort asPort(); 
}
