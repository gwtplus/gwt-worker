package slave.client;

import java.util.logging.Logger;

import org.gwtproject.gwt.worker.shared.AbstractWorkerScope;
import org.gwtproject.gwt.worker.shared.MessageEvent;
import org.gwtproject.gwt.worker.shared.WorkerScope;
import org.gwtproject.gwt.worker.shared.Workers;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

public class SlaveEntry implements EntryPoint {

	private static final Logger sLogger = Logger.getLogger("SlaveEntry");
	
	@Override
	public void onModuleLoad() {
		logWorkerInfo();
		
		final boolean inWorker = Workers.inWorker();
		final String name = inWorker ? "Worker:  " : "Renderer:";
		
		if(inWorker) {
			AbstractWorkerScope scope = Workers.getScope();
			
			MessageEvent.Handler h = new MessageEvent.Handler() {
				
				@Override
				public void onMessage(MessageEvent event) {
					sLogger.warning("Message from master: '" + event.getData() + "'");
				}
			};
			
			if(scope.isDedicated()) {
				WorkerScope ws = scope.asDedicated();
				ws.asPortRef().addMessageHandler(h);
			} else if (scope.isShared()) {
				//SharedWorkerScope sws = scope.asShared();
				//TODO: implement on connect
			}
		}
		
		//check worker locations:
		sLogger.info(name + "host page: " + GWT.getHostPageBaseURL());
		sLogger.info(name + "module: " + GWT.getModuleBaseURL());
		
		//simulate works is doing sth
		new Timer(){
			
			int count = 0;

			@Override
			public void run() {
				sLogger.info(name + "Loop count: " + count);
				count++;
				
				this.schedule(1000);
			}
			
		}.schedule(1000);
		
		//simulate worker throws some error
		throwError(name);
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
	
	private static native void throwError(String name)/*-{
		var n = name;
		//no $entry on purpose
		setTimeout(function() {throw ("Simulated exception in " + n)}, 3000);
	}-*/;


}
