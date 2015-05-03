package org.gwtproject.gwt.worker.shared;


/**
 * DedicatedWorkerGlobalScope
 *
 */
public interface WorkerScope extends AbstractWorkerScope {
	
	/**
	 * Returns this worker as MessagePortRef
	 * which doesn't support starting or closing
	 * @return
	 */
	MessagePortRef asPortRef(); 
}
