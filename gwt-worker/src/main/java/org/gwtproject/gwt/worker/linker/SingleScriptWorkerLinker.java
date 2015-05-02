package org.gwtproject.gwt.worker.linker;

import java.util.Set;
import java.util.SortedSet;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;
import com.google.gwt.core.ext.linker.SelectionProperty;
import com.google.gwt.core.ext.linker.Shardable;
import com.google.gwt.dev.util.DefaultTextOutput;

@Shardable
@LinkerOrder(Order.PRIMARY)
public class SingleScriptWorkerLinker extends SingleScriptLinker {

	@Override
	protected String getMultiFragmentWarningMessage() {
		return "The module must not have multiple fragments"
				+ " when using the " + getDescription()
				+ " Linker. Use of GWT.runAsync within Worker"
				+ " code is the most likely cause of this error.";
	}

	@Override
	protected void ensureSinglePermutation(TreeLogger logger,
			LinkerContext context, Set<Script> results)
			throws UnableToCompleteException {

		try {
			super.ensureSinglePermutation(logger, context, results);
		} catch (UnableToCompleteException e) {
			logPermutationProperties(logger, context.getProperties());
			throw e;
		}
	}

	/**
	 * Output the deferred binding properties to the logger to help the user of
	 * this linker determine what is causing multiple compilation permutations.
	 * 
	 * @param logger
	 *            the TreeLogger to record to
	 * @param properties
	 *            The deferred binding properties
	 */
	protected void logPermutationProperties(TreeLogger logger,
			SortedSet<SelectionProperty> properties) {
		TreeLogger branch = logger.branch(TreeLogger.INFO,
				"Deferred binding properties of current " + "module:");

		for (SelectionProperty property : properties) {
			String name = property.getName();
			String value = property.tryGetValue();
			String prefix = null;
			if (value == null) {
				value = "?";
				if (property.isDerived()) {
					prefix = " ! ";
				} else {
					prefix = "!! ";
				}
			} else {
				prefix = "   ";
			}

			branch.log(TreeLogger.INFO, prefix + name + "=" + value);
		}
	}

	protected void defineJsWndAndDoc(DefaultTextOutput out) {
		//http://stackoverflow.com/questions/7931182/reliably-detect-if-the-script-is-executing-in-a-web-worker
		out.print("var $isWorker = typeof importScripts === 'function';");
		out.newlineOpt();
		
		//support running of worker code in renderer context
		out.print("var $wnd = $isWorker ? self : window;");
		out.newlineOpt();

		//docMode:10 triggers ie10 permutation and doesn't trigger gecko (so gecko1_8 is used)
		//same solution should be in template so there are no runtime warnings about permutation
		//incompatibility
		out.print("var $doc = $isWorker ? {"
				+ "documentMode: 10, "
				+ "compatMode: 'CSS1Compat',"
				+ "location: $wnd.location"
				+ "} : $wnd.document;");
		out.newlineOpt();
	}
	
	@Override
	protected String getSelectionScriptTemplate(TreeLogger logger,
			LinkerContext context) throws UnableToCompleteException {
		return getClass().getPackage().getName().replace('.', '/')
				+ "/SingleScriptWorkerTemplate.js";
	}
	
	//possible to setup proper caching strategy for worker scripts
	//nocache.js or cache.js are not useful in this case
	@Override
	protected String getCompilationExtension(TreeLogger logger,
			LinkerContext context) throws UnableToCompleteException {
		return ".worker.js";
	}
}
