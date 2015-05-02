package com.github.gwt.worker.shared;

import java.util.List;

public interface MessageEvent {
	
	interface Handler {
		void onMessage(MessageEvent event);
	}
	
	String getData();

	String getOrigin();

	String getLastEventId();

	MessagePort getSource();

	List<MessagePort> getPorts();
}
