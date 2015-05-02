package com.github.gwt.worker.client;

import com.github.gwt.worker.shared.MessagePort;
import com.github.gwt.worker.shared.Worker;

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
