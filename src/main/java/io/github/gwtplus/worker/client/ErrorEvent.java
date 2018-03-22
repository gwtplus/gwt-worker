package io.github.gwtplus.worker.client;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * ErrorEvent
 * 
 * @author metteo
 * @see <a href="https://www.w3.org/TR/workers/#runtime-script-errors">ErrorEvent in W3C spec</a>
 */
@JsType(isNative = true)
public interface ErrorEvent {
	
  @JsFunction
	interface Handler {
		void onError(ErrorEvent error);
	}

	String getMessage();

	@JsProperty(name = "filename")
	String getFileName();

	@JsProperty(name = "lineno")
	int getLineNumber();
	
	@JsProperty(name = "colno")
	int getColumnNumber();
}
