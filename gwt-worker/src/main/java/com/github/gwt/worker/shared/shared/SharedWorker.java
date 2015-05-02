package com.github.gwt.worker.shared.shared;

import com.github.gwt.worker.client.SharedWorkerJsoImpl;
import com.github.gwt.worker.shared.AbstractWorker;
import com.github.gwt.worker.shared.MessagePort;
import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(SharedWorkerJsoImpl.class)
public interface SharedWorker extends AbstractWorker {

	MessagePort getPort();
}
