package org.gwtproject.gwt.worker.shared;

public interface ErrorEvent {
	
	interface Handler {
		void onError(ErrorEvent error);
	}

	String getMessage();

	String getFileName();

	int getLineNumber();
}
