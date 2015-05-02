package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.MessagePort;
import org.gwtproject.gwt.worker.shared.WorkerScope;

public class WorkerScopeJsoImpl extends AbstractWorkerScopeJsoImpl implements
		WorkerScope {

	protected WorkerScopeJsoImpl() {

	}
	
	@Override
	public final MessagePort asPort() {
		return (MessagePortJsoImpl) this.cast();
	}

}
