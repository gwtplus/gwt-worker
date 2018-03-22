package io.github.gwtplus.worker.client;

import jsinterop.annotations.JsType;

/**
 * WorkerGlobalScope
 * 
 * @author metteo
 * @see <a href="https://www.w3.org/TR/workers/#workerglobalscope">WorkerGlobalScope in W3C spec</a>
 */
@JsType(name = "WorkerGlobalScope", isNative = true)
public interface AbstractWorkerScope {

  //getSelf not needed
  
  //WorkerLocation getLocation();

//  WorkerNavigator getNavigator();

  void importScripts(String... urls);

  void close();

//  HandlerRegistration addErrorHandler(ErrorEvent.Handler handler);

//  HandlerRegistration addLanguageChangeHandler(LanguageChangeEvent.Handler handler);

//  HandlerRegistration addConnectivityHandler(ConnectivityEvent.Handler handler);
}
