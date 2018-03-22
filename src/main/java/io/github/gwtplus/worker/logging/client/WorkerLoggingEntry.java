package io.github.gwtplus.worker.logging.client;

import java.util.logging.Handler;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.logging.client.NullLogHandler;

public class WorkerLoggingEntry implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Handler logHandler = GWT.create(WorkerConsoleLogHandler.class);
		if(!(logHandler instanceof NullLogHandler)) {
			Logger root = Logger.getLogger("");
			root.addHandler(logHandler);
		}
	}
}
