package slave.client;

import java.util.logging.Logger;

import org.gwtproject.gwt.worker.shared.Workers;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

public class WorkerSlaveEntry implements EntryPoint {

	private static final Logger sLogger = Logger.getLogger("WorkerSlaveEntry");
	
	@Override
	public void onModuleLoad() {
		final boolean isWorker = Workers.isWorker();
		final String name = isWorker ? "Worker:  " : "Renderer:";
		
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
	
	private static native void throwError(String name)/*-{
		var n = name;
		//no $entry on purpose
		setTimeout(function() {throw ("Simulated exception in " + n)}, 3000);
	}-*/;


}
