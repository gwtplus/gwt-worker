package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.MessagePort;
import org.gwtproject.gwt.worker.shared.Worker;

public class WorkerJsoImpl extends AbstractWorkerJsoImpl implements Worker {

	protected WorkerJsoImpl() {
		
	}

	@Override
	public final native void terminate()/*-{
		this.terminate();
	}-*/;

	@Override
	public final MessagePort asPort() {
		return (MessagePortJsoImpl)this.cast();
	}

}
