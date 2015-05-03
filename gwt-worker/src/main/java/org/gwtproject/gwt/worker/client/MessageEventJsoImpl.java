package org.gwtproject.gwt.worker.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gwtproject.gwt.worker.shared.MessageEvent;
import org.gwtproject.gwt.worker.shared.MessagePort;

import com.google.gwt.core.client.JsArray;
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
		JsArray<MessagePortJsoImpl> ports = getPorts0();
		if(ports == null || ports.length() == 0) {
			return Collections.emptyList();
		}
		
		List<MessagePort> ps = new ArrayList<>();
		for(int i = 0; i < ports.length(); i++) {
			MessagePortJsoImpl p = ports.get(i);
			ps.add(p);
		}
		
		return ps;
	}
	
	private final native JsArray<MessagePortJsoImpl> getPorts0()/*-{
		return this.ports;
	}-*/;
}
