package com.github.gwt.worker.client;

import static com.github.gwt.worker.client.EventListeners.register;

import com.github.gwt.worker.shared.AbstractWorker;
import com.github.gwt.worker.shared.WorkerError;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AbstractWorkerJsoImpl extends EventTarget implements AbstractWorker {
	
	protected AbstractWorkerJsoImpl() {

	}

	@Override
	public final HandlerRegistration addErrorHandler(final WorkerError.Handler handler) {
		return register(this, "error", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onWorkerError((WorkerErrorJsoImpl) event.cast());
			}
		});
	}
}
