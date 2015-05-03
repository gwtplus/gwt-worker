package org.gwtproject.gwt.worker.shared;

import java.util.List;

public interface MessageEvent {
	
	String getData();

	String getOrigin();

	String getLastEventId();

	MessagePort getSource();

	List<MessagePort> getPorts();
}
