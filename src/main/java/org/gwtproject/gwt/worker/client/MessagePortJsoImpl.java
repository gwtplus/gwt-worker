package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.MessagePort;

public class MessagePortJsoImpl extends MessagePortRefJsoImpl implements MessagePort {

	protected MessagePortJsoImpl() {
	}

	@Override
	public final native void start()/*-{
		this.start();
	}-*/;

	@Override
	public final native void close()/*-{
		this.close();
	}-*/;

}
