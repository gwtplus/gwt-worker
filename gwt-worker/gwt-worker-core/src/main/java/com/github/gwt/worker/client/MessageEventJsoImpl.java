package com.github.gwt.worker.client;

import java.util.List;

import com.github.gwt.worker.shared.MessageEvent;
import com.github.gwt.worker.shared.MessagePort;
import com.google.gwt.user.client.Event;

public class MessageEventJsoImpl extends Event implements MessageEvent {

	protected MessageEventJsoImpl() {
		
	}
	
	@Override
	public final native String getData()/*-{
		return this.data;
	}-*/;

	@Override
	public final native String getOrigin()/*-{
		return this.origin;
	}-*/;

	@Override
	public final native String getLastEventId()/*-{
		return this.lastEventId;
	}-*/;

	@Override
	public final native MessagePort getSource()/*-{
		return this.source;
	}-*/;

	@Override
	public final List<MessagePort> getPorts() {
		throw new UnsupportedOperationException("Not implemented !");
	}

}
