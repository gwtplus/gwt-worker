package master.client;

import static io.github.gwtplus.worker.client.Workers.*;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;

import io.github.gwtplus.worker.client.Worker;

public class MasterEntry implements EntryPoint {

	private static final Logger sLogger = Logger.getLogger("MasterEntry");

	@Override
	public void onModuleLoad() {
		logWorkerInfo();

		if (isWorkerSupported()) {
			startWorker();
		}

		/*if(Workers.isSharedSupported()) {
			startSharedWorker();
		}*/
	}
	
	private void logWorkerInfo() {
		boolean dedicatedSupport = isWorkerSupported();
		sLogger.info("workerSupport=" + dedicatedSupport);
		
		boolean sharedSupport = isSharedWorkerSupported();
		sLogger.info("sharedSupport=" + sharedSupport);
		
		boolean serviceSupport = isServiceWorkerSupported();
		sLogger.info("serviceSupport=" + serviceSupport);
		
		boolean inWorker = inWorkerScope();
		sLogger.info("inWorker=" + inWorker);
	}

	private void startWorker() {
		
	  sLogger.info("Starting Slave...");
	  
	// web inspector threads
		Worker w = new Worker("./Slave/Slave.worker.js");
		/*w.postMessage("You are a slave :)");
		w.addErrorHandler(new ErrorEvent.Handler() {

			@Override
			public void onError(ErrorEvent error) {
				sLogger.severe("Dedicated: " + error.getMessage() + "(" + error.getFileName()
						+ ":" + error.getLineNumber() + ")");
			}
		});
		*/
		new Timer() {
      
      @Override
      public void run() {
        sLogger.info("Stopping Slave...");
        w.terminate();
      }
    }.schedule(60000);
	}
	
	/*private void startSharedWorker() {
		// chrome://inspect/#workers
		SharedWorker sw = Workers.newSharedWorker("./Slave/Slave.worker.js",
				"looper");
		
		sw.addErrorHandler(new ErrorEvent.Handler() {

			@Override
			public void onError(ErrorEvent error) {
				sLogger.severe("Shared: " + error.getMessage() + "(" + error.getFileName()
						+ ":" + error.getLineNumber() + ")");
			}
		});
		
		MessagePort port = sw.getPort();
		port.start();
		
		port.postMessage("You are a shared slave");
		port.close();
	}
	*/
}
