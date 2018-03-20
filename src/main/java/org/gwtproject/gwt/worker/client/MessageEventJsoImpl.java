package org.gwtproject.gwt.worker.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gwtproject.gwt.worker.shared.MessageEvent;
import org.gwtproject.gwt.worker.shared.MessagePort;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Event;

public class MessageEventJsoImpl extends Event implements MessageEvent {

	public static class DataJsoImpl extends JavaScriptObject implements Data {

		protected DataJsoImpl() {

		}

		@Override
		public final native int getAsInt()/*-{
			return this.data;
		}-*/;

		@Override
		public final native String getAsString() /*-{
			return this.data;
		}-*/;

		@Override
		public final native JavaScriptObject getAsObject() /*-{
			return this.data;
		}-*/;

	}

	protected MessageEventJsoImpl() {

	}

	@Override
	public final native Data asData()/*-{
		return this;
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
		if (ports == null || ports.length() == 0) {
			return Collections.emptyList();
		}

		List<MessagePort> ps = new ArrayList<>();
		for (int i = 0; i < ports.length(); i++) {
			MessagePortJsoImpl p = ports.get(i);
			ps.add(p);
		}

		return ps;
	}

	private final native JsArray<MessagePortJsoImpl> getPorts0()/*-{
		return this.ports;
	}-*/;
}
