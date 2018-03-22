package slave.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

import io.github.gwtplus.worker.client.WorkerScope;

import static io.github.gwtplus.worker.client.Workers.*;

public class SlaveEntry implements EntryPoint {

	private static final Logger sLogger = Logger.getLogger("SlaveEntry");
	
	@Override
	public void onModuleLoad() {
		logWorkerInfo();
		
		final boolean inWorker = inWorkerScope();
		final String name = inWorker ? "Worker:  " : "Renderer:";
		
		/*if(inWorker) {
			AbstractWorkerScope scope = Workers.getScope();
			
			final MessageHandler h = new MessageHandler() {
				
				@Override
				public void onMessage(MessageEvent event) {
					sLogger.warning("Message from master: '" + event.asData().getAsString() + "'");
				}
			};
			
			if(scope.isDedicated()) {
				WorkerScope ws = scope.asDedicated();
				ws.asPortRef().addMessageHandler(h);
			} else if (scope.isShared()) {
				SharedWorkerScope sws = scope.asShared();
				sws.addConnectHandler(new ConnectHandler() {
					
					@Override
					public void onConnect(MessageEvent event) {
						sLogger.info("Master connected");
						
						MessagePort port = event.getPorts().get(0);
						
						port.addMessageHandler(h);
						port.start();
						//port.close();
					}
				});
			}
		}
		*/
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
		boolean dedicatedSupport = isWorkerSupported();
		sLogger.info("workerSupport=" + dedicatedSupport);
		
		boolean sharedSupport = isSharedWorkerSupported();
		sLogger.info("sharedSupport=" + sharedSupport);
		
		boolean serviceSupport = isServiceWorkerSupported();
		sLogger.info("serviceSupport=" + serviceSupport);
		
		boolean inWorker = inWorkerScope();
		sLogger.info("inWorker=" + inWorker);

		if (inWorker) {
			WorkerScope scope = getScope();

			sLogger.info("WorkerScope=" + scope);
		}
	}
	
	private static native void throwError(String name)/*-{
		var n = name;
		//no $entry on purpose
		setTimeout(function() {throw ("Simulated exception in " + n)}, 3000);
	}-*/;


}
