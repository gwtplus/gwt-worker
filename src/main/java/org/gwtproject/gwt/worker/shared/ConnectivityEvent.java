package org.gwtproject.gwt.worker.shared;

public interface ConnectivityEvent {

	interface Handler {
		void onConnectivity(ConnectivityEvent event);
	}
}
