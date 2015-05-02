package com.github.gwt.worker.client;

import com.github.gwt.worker.shared.MessagePort;
import com.github.gwt.worker.shared.shared.SharedWorker;

public class SharedWorkerJsoImpl extends AbstractWorkerJsoImpl implements SharedWorker {

	protected SharedWorkerJsoImpl() {

	}

	@Override
	public final native MessagePort getPort()/*-{
		return this.port;
	}-*/;
}
