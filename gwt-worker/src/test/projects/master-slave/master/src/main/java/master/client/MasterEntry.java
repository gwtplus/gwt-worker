package master.client;

import java.util.logging.Logger;

import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.MessagePort;
import org.gwtproject.gwt.worker.shared.Worker;
import org.gwtproject.gwt.worker.shared.ErrorEvent;
import org.gwtproject.gwt.worker.shared.Workers;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

import com.google.gwt.core.client.EntryPoint;

public class MasterEntry implements EntryPoint {

	private static final Logger sLogger = Logger.getLogger("MasterEntry");

	@Override
	public void onModuleLoad() {
		logWorkerInfo();

		if (Workers.isDedicatedSupported()) {
			startWorker();
		}

		if(Workers.isSharedSupported()) {
			startSharedWorker();
		}
	}
	
	private void logWorkerInfo() {
		boolean dedicatedSupport = Workers.isDedicatedSupported();
		sLogger.info("dedicatedSupport=" + dedicatedSupport);
		
		boolean sharedSupport = Workers.isSharedSupported();
		sLogger.info("sharedSupport=" + sharedSupport);
		
		boolean serviceSupport = Workers.isServiceSupported();
		sLogger.info("serviceSupport=" + serviceSupport);
		
		boolean inWorker = Workers.inWorker();
		sLogger.info("inWorker=" + inWorker);

		if (inWorker) {
			AbstractWorkerScope scope = Workers.getScope();

			boolean dedicated = scope.isDedicated();
			boolean shared = scope.isShared();
			boolean service = scope.isService();

			sLogger.info("dedicated=" + dedicated);
			sLogger.info("shared=" + shared);
			sLogger.info("service=" + service);
		}
	}

	private void startWorker() {
		// web inspector threads
		Worker w = Workers.newWorker("./Slave/Slave.worker.js");
		w.asPortRef().postMessage("You are a slave :)");
		w.addErrorHandler(new ErrorEvent.Handler() {

			@Override
			public void onError(ErrorEvent error) {
				sLogger.severe(error.getMessage() + "(" + error.getFileName()
						+ ":" + error.getLineNumber() + ")");
			}
		});
	}
	
	private void startSharedWorker() {
		// chrome://inspect/#workers
		SharedWorker sw = Workers.newSharedWorker("./Slave/Slave.worker.js",
				"looper");
		MessagePort port = sw.getPort();
		port.start();
		
		port.postMessage("You are a shared slave");
		port.close();
	}
}
