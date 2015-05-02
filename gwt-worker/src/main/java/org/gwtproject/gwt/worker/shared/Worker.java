package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.WorkerJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(WorkerJsoImpl.class)
public interface Worker extends AbstractWorker {
	
	void terminate();
	
	/**
	 * Returns this worker as MessagePort
	 * which doesn't require starting or closing
	 * @return
	 */
	MessagePort asPort();
}
