package org.gwtproject.gwt.worker.shared;

import org.gwtproject.gwt.worker.client.WorkerLocationJsoImpl;

import com.google.gwt.core.client.SingleJsoImpl;

@SingleJsoImpl(WorkerLocationJsoImpl.class)
public interface WorkerLocation {

	String getHref();

	String getOrigin();

	String getProtocol();

	String getHost();

	String getHostName();

	String getPort();

	String getPathName();

	String getSearch();

	String getHash();
}
