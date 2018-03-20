package org.gwtproject.gwt.worker.client;

class WorkerSupport {

	static abstract class AbstractDetector {
		abstract boolean isSupportedRunTime();

		abstract boolean isSupportedCompileTime();
	}

	//Worker
	static abstract class WorkerDetector extends AbstractDetector {

		@Override
		native boolean isSupportedRunTime() /*-{
			return typeof Worker === 'function';
		}-*/;
	}
	
	static class WorkerDetectedNo extends WorkerDetector {

		@Override
		boolean isSupportedCompileTime() {
			return false;
		}
	}
	
	static class WorkerDetectedMaybe extends WorkerDetector {

		@Override
		boolean isSupportedCompileTime() {
			return true;
		}
	}

	//SharedWorker
	static abstract class SharedWorkerDetector extends AbstractDetector {

		@Override
		native boolean isSupportedRunTime() /*-{
			return typeof SharedWorker === 'function';
		}-*/;
	}
	
	static class SharedWorkerDetectedNo extends SharedWorkerDetector {

		@Override
		boolean isSupportedCompileTime() {
			return false;
		}
	}
	
	static class SharedWorkerDetectedMaybe extends SharedWorkerDetector {

		@Override
		boolean isSupportedCompileTime() {
			return true;
		}
	}

	static abstract class ServiceWorkerDetector extends AbstractDetector {

		@Override
		native boolean isSupportedRunTime() /*-{
			return typeof ServiceWorker === 'function';
		}-*/;
	}
	
	static class ServiceWorkerDetectedNo extends ServiceWorkerDetector {

		@Override
		boolean isSupportedCompileTime() {
			return false;
		}
	}
	
	static class ServiceWorkerDetectedMaybe extends ServiceWorkerDetector {

		@Override
		boolean isSupportedCompileTime() {
			return true;
		}
	}
}
