package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.WorkerError;

import com.google.gwt.user.client.Event;

public class WorkerErrorJsoImpl extends Event implements WorkerError {
	
	protected WorkerErrorJsoImpl() {

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
	public final native String getLineNumber() /*-{
		return this.lineno;
	}-*/;
}
