package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.WorkerJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(WorkerJsoImpl.class)
public interface Worker extends AbstractWorker {
	
	void terminate();
	
	/**
	 * Returns this worker as MessagePortRef
	 * which doesn't support starting or closing
	 * @return
	 */
	MessagePortRef asPortRef();
}
