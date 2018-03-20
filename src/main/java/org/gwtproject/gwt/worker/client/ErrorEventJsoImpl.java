package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.ErrorEvent;

import com.google.gwt.user.client.Event;

public class ErrorEventJsoImpl extends Event implements ErrorEvent {
	
	protected ErrorEventJsoImpl() {

	}
	
	@Override
	public final native String getMessage()/*-{
		return this.message;
	}-*/;

	@Override
	public final native String getFileName()/*-{
		return this.filename;
	}-*/;

	@Override
	public final native int getLineNumber() /*-{
		return this.lineno ? this.lineno : -1;
	}-*/;
}
