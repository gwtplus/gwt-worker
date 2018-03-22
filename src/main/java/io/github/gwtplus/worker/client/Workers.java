package io.github.gwtplus.worker.client;

import elemental2.promise.Promise;

/**
 * Worker API entry point. Methods can be statically imported
 * 
 * @author metteo
 *
 */
public class Workers {
  
  private static WorkersImpl sImpl = new WorkersImpl();
  
  /**
   * Useful for setting mock impl. null input is ignored
   * @param impl 
   */
  //@VisibleForTesting
  public static void setImpl(WorkersImpl impl) {
    if (sImpl == null) { return; }
    sImpl = impl;
  }

  private Workers() {
    //utility class
  }
  
  //Master utilities
  
  public static boolean isWorkerSupported() {
    return sImpl.isWorkerSupported();
  }
  
  public static boolean isSharedWorkerSupported() {
    return sImpl.isSharedWorkerSupported();
  }
  
  public static boolean isServiceWorkerSupported() {
    return sImpl.isServiceWorkerSupported();
  }
  
  public static Promise<Worker> registerServiceWorker(String url) {
    return sImpl.registerServiceWorker(url);
  }
  
  //Slave utilities
  
  public static boolean inWorkerScope() {
    return sImpl.inWorker() && sImpl.inWorkerScope();
  }
  
  public static boolean inSharedWorkerScope() {
    return sImpl.inWorker() && sImpl.inSharedWorkerScope();
  }
  
  public static boolean inServiceWorkerScope() {
    return sImpl.inWorker() && sImpl.inServiceWorkerScope();
  }
  
  @SuppressWarnings("unchecked")
  public static <T extends AbstractWorkerScope> T getScope() {
    return sImpl.inWorker() ? (T) sImpl.getScope() : null;
  }
}
