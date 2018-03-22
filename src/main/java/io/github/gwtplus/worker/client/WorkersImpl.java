package io.github.gwtplus.worker.client;

import static jsinterop.annotations.JsPackage.GLOBAL;

import elemental2.core.Function;
import elemental2.promise.Promise;
import jsinterop.annotations.JsProperty;
import static jsinterop.base.Js.*;

//Internal
public class WorkersImpl {
  
  @JsProperty(name="Worker", namespace=GLOBAL)
  private static native Function getWorkerFn();
  
  @JsProperty(name="DedicatedWorkerGlobalScope", namespace="<window>")
  private static native Function getWorkerScopeFn();
  
  @JsProperty(name="SharedWorker", namespace=GLOBAL)
  private static native Function getSharedWorkerFn();
  
  @JsProperty(name="SharedWorkerGlobalScope", namespace="<window>")
  private static native Function getSharedWorkerScopeFn();
  
  @JsProperty(name="ServiceWorker", namespace=GLOBAL)
  private static native Function getServiceWorkerFn();
  
  @JsProperty(name="ServiceWorkerGlobalScope", namespace="<window>")
  private static native Function getServiceWorkerScopeFn();
  
  @JsProperty(name="importScripts", namespace=GLOBAL)
  private static native Function getImportScriptsFn();
  
  @JsProperty(name="self", namespace="<window>")
  private static native AbstractWorkerScope getScope0();
  
  private boolean isFunction(Object input) {
    return "function".equals(typeof(input));
  }
  
  public boolean isWorkerSupported() {
    return isFunction(getWorkerFn());
  }

  public boolean isSharedWorkerSupported() {
    return isFunction(getSharedWorkerFn());
  }

  public boolean isServiceWorkerSupported() {
    return isFunction(getServiceWorkerFn());
  }

  public Promise<Worker> registerServiceWorker(String url) {
    return null; //TODO: implement
  }

  public boolean inWorker() {
    return isFunction(getImportScriptsFn());
  }
  
  public boolean inWorkerScope() {
    return isFunction(getWorkerScopeFn());
  }

  public boolean inSharedWorkerScope() {
    return isFunction(getSharedWorkerScopeFn());
  }

  public boolean inServiceWorkerScope() {
    return isFunction(getSharedWorkerScopeFn());
  }

  public AbstractWorkerScope getScope() {
    return getScope0();
  }
}
