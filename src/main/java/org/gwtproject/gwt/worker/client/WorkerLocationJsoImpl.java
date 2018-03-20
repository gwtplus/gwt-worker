package org.gwtproject.gwt.worker.client;

import org.gwtproject.gwt.worker.shared.WorkerLocation;

import com.google.gwt.core.client.JavaScriptObject;

public class WorkerLocationJsoImpl extends JavaScriptObject implements
		WorkerLocation {

	protected WorkerLocationJsoImpl() {

	}
	
	@Override
	public final native String getHref() /*-{
		return this.href;
	}-*/;

	@Override
	public final native String getOrigin() /*-{
		return this.origin;
	}-*/;

	@Override
	public final native String getProtocol() /*-{
		return this.protocol;
	}-*/;

	@Override
	public final native String getHost() /*-{
		return this.host;
	}-*/;

	@Override
	public final native String getHostName() /*-{
		return this.hostname;
	}-*/;

	@Override
	public final native String getPort() /*-{
		return this.port;
	}-*/;

	@Override
	public final native String getPathName() /*-{
		return this.pathname;
	}-*/;


	@Override
	public final native String getSearch() /*-{
		return this.search;
	}-*/;

	@Override
	public final native String getHash() /*-{
		return this.hash;
	}-*/;
}
