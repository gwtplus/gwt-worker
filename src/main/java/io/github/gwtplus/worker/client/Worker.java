package io.github.gwtplus.worker.client;

import elemental2.core.Transferable;
import elemental2.dom.EventListener;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Worker
 * 
 * @author metteo
 * @see <a href="https://www.w3.org/TR/workers/#worker">Worker in W3C spec</a>
 */
@JsType(isNative = true)
public class Worker extends AbstractWorker {

  /**
   * Constructs and starts a new worker
   * 
   * @param scriptUrl relative to host page
   */
  @JsConstructor
  public Worker(String scriptUrl) {}
  
  public native void terminate();

  public native void postMessage(Object message, Transferable... transfer);
  
  @JsProperty
  private EventListener onmessage;
}
