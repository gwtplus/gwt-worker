package io.github.gwtplus.worker.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * AbstractWorker
 * 
 * @author metteo
 * @see <a href="https://www.w3.org/TR/workers/#abstractworker">AbstractWorker in W3C spec</a>
 */
@JsType(isNative = true)
public class AbstractWorker {

  @JsProperty(name = "onerror")
  public ErrorEvent.Handler onError;
  
  //@JsOverlay
  //default HandlerRegistration addErrorHandler(ErrorEvent.Handler handler) {
  //  return null;
  //};
}
