package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.MessagePortRef;
import org.gwtproject.gwt.worker.shared.WorkerScope;

public class WorkerScopeJsoImpl extends AbstractWorkerScopeJsoImpl implements
		WorkerScope {

	protected WorkerScopeJsoImpl() {

	}
	
	@Override
	public final MessagePortRef asPortRef() {
		return (MessagePortRefJsoImpl) this.cast();
	}

}
