package org.gwtproject.gwt.worker.shared;

public interface WorkerError {
	
	interface Handler {
		void onWorkerError(WorkerError error);
	}

	String getMessage();

	String getFileName();

	String getLineNumber();
}
