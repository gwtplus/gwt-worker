package org.gwtproject.gwt.worker.shared.shared;

import org.gwtproject.gwt.worker.client.SharedWorkerJsoImpl;
import org.gwtproject.gwt.worker.shared.AbstractWorker;
import org.gwtproject.gwt.worker.shared.MessagePort;

import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(SharedWorkerJsoImpl.class)
public interface SharedWorker extends AbstractWorker {

	MessagePort getPort();
}
