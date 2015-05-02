package com.github.gwt.worker.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;
import com.google.gwt.core.ext.linker.Shardable;
import com.google.gwt.core.ext.linker.impl.SelectionScriptLinker;

@Shardable
@LinkerOrder(Order.PRIMARY)
//TODO: Implement xsworker
public class CrossSiteWorkerLinker extends SelectionScriptLinker {

	@Override
	protected String getCompilationExtension(TreeLogger logger,
			LinkerContext context) throws UnableToCompleteException {
		throw new UnableToCompleteException();
	}

	@Override
	protected String getModulePrefix(TreeLogger logger, LinkerContext context,
			String strongName) throws UnableToCompleteException {
		throw new UnableToCompleteException();
	}

	@Override
	protected String getSelectionScriptTemplate(TreeLogger logger,
			LinkerContext context) throws UnableToCompleteException {
		throw new UnableToCompleteException();
	}

	@Override
	public String getDescription() {
		return "Cross-Site-Worker";
	}

}
