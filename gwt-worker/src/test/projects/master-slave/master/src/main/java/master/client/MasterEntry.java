package master.client;

import java.util.logging.Logger;

import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.MessagePort;
import org.gwtproject.gwt.worker.shared.Worker;
import org.gwtproject.gwt.worker.shared.WorkerError;
import org.gwtproject.gwt.worker.shared.Workers;
import org.gwtproject.gwt.worker.shared.shared.SharedWorker;

import com.google.gwt.core.client.EntryPoint;

public class MasterEntry implements EntryPoint {

	private static final Logger sLogger = Logger.getLogger("MasterEntry");

	@Override
	public void onModuleLoad() {
		logWorkerState();

		// web inspector threads
		Worker w = Workers.newWorker("./Slave/Slave.worker.js");
		w.asPort().postMessage("You are a slave :)");
		w.addErrorHandler(new WorkerError.Handler() {

			@Override
			public void onWorkerError(WorkerError error) {
				sLogger.severe(error.getMessage() + "(" + error.getFileName()
						+ ":" + error.getLineNumber() + ")");
			}
		});

		 //chrome://inspect/#workers
		 SharedWorker sw = Workers.newSharedWorker("./Slave/Slave.worker.js", "looper");
		 MessagePort port = sw.getPort();
		 port.start();
	}

	private void logWorkerState() {
		boolean inWorker = Workers.inWorker();
		sLogger.info("inWorker=" + inWorker);
		
		if(inWorker) {
			AbstractWorkerScope scope = Workers.getScope();
			
			boolean dedicated = scope.isDedicated();
			boolean shared = scope.isShared();
			boolean service = scope.isService();
			
			sLogger.info("dedicated=" + dedicated);
			sLogger.info("shared=" + shared);
			sLogger.info("service=" + service);
		}
	}
}
