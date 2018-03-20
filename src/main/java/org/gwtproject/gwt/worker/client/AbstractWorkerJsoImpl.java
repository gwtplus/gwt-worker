package org.gwtproject.gwt.worker.client;

import static org.gwtproject.gwt.worker.client.EventListeners.register;

import org.gwtproject.gwt.worker.shared.AbstractWorker;
import org.gwtproject.gwt.worker.shared.ErrorEvent;

import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AbstractWorkerJsoImpl extends EventTarget implements AbstractWorker {
	
	protected AbstractWorkerJsoImpl() {

	}

	@Override
	public final HandlerRegistration addErrorHandler(final ErrorEvent.Handler handler) {
		return register(this, "error", new EventListener() {
			@Override
			public void onBrowserEvent(Event event) {
				handler.onError((ErrorEventJsoImpl) event.cast());
			}
		});
	}
}
