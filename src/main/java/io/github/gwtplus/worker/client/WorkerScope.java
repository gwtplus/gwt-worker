package io.github.gwtplus.worker.client;

import elemental2.core.Transferable;
import jsinterop.annotations.JsType;

/**
 * DedicatedWorkerGlobalScope
 * 
 * @author metteo
 * @see <a href="https://www.w3.org/TR/workers/#dedicatedworkerglobalscope">DedicatedWorkerGlobalScope in W3C spec</a>
 */
@JsType(name = "DedicatedWorkerGlobalScope", isNative = true)
public interface WorkerScope extends AbstractWorkerScope {
	
  void postMessage(Object message, Transferable... transfer);
  
  //EventHandler onmessage
}
