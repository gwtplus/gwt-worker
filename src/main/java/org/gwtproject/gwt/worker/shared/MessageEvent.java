package org.gwtproject.gwt.worker.shared;

import java.util.List;

import org.gwtproject.gwt.worker.client.MessageEventJsoImpl.DataJsoImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.SingleJsoImpl;

public interface MessageEvent {
	
	@SingleJsoImpl(DataJsoImpl.class)
	interface Data {
		int getAsInt();
		
		String getAsString();
		
		JavaScriptObject getAsObject();
	}
	
	Data asData();

	String getOrigin();

	String getLastEventId();

	MessagePort getSource();

	List<MessagePort> getPorts();
}
