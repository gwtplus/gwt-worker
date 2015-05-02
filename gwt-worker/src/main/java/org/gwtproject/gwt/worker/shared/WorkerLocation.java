package org.gwtproject.gwt.worker.shared;

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
