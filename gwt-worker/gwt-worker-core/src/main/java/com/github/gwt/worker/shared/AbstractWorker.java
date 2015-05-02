package com.github.gwt.worker.shared;

import com.google.web.bindery.event.shared.HandlerRegistration;

public interface AbstractWorker {

	HandlerRegistration addErrorHandler(WorkerError.Handler handler);
}
