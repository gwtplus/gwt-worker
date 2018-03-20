package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.MessagePort;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

public class SharedWorkerJsoImpl extends AbstractWorkerJsoImpl implements SharedWorker {

	protected SharedWorkerJsoImpl() {

	}

	@Override
	public final native MessagePort getPort()/*-{
		return this.port;
	}-*/;
}
