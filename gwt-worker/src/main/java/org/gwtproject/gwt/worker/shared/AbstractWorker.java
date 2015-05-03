package org.gwtproject.gwt.worker.shared;

import com.google.web.bindery.event.shared.HandlerRegistration;

public interface AbstractWorker {

	HandlerRegistration addErrorHandler(ErrorEvent.Handler handler);
}
