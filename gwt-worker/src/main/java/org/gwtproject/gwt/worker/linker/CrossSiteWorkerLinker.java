package org.gwtproject.gwt.worker.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;
import com.google.gwt.core.ext.linker.Shardable;
import com.google.gwt.core.linker.CrossSiteIframeLinker;
import com.google.gwt.dev.util.DefaultTextOutput;
import com.google.gwt.dev.util.TextOutput;

@Shardable
@LinkerOrder(Order.PRIMARY)
//TODO: Implement xsworker
public class CrossSiteWorkerLinker extends CrossSiteIframeLinker {

	@Override
	public String getDescription() {
		return "Cross-Site-Worker";
	}
	
	@Override
	protected String getSelectionScriptTemplate(TreeLogger logger,
			LinkerContext context) {
		return getClass().getPackage().getName().replace('.', '/')
				+ "/CrossSiteWorkerTemplate.js";
	}
	
	@Override
	protected String getJsProcessMetas(LinkerContext context) {
		return "com/google/gwt/core/ext/linker/impl/processMetasNull.js";
	}
	
	@Override
	protected String getModulePrefix(TreeLogger logger, LinkerContext context,
			String strongName) throws UnableToCompleteException {
		String prefix =  super.getModulePrefix(logger, context, strongName);
		
		TextOutput out = new DefaultTextOutput(context.isOutputCompact());
		
		out.print("var isWorker = typeof importScripts === 'function';");
		out.newlineOpt();
		
		out.print("var $self = isWorker ? self : window;");
		out.newlineOpt();
		
		out.print("if(isWorker) {");
		{
			//simple document emulation in worker context
			out.print("$self.document = {");
			out.print("documentMode: 10,");
			out.print("compatMode: 'CSS1Compat',");
			out.print("location: $self.location,");
			out.print("createElement: function(){throw 'worker!'}");
			out.print("};");
		}
		out.print("}");
		out.newlineOpt();

		// support running of worker code in renderer context
		out.print("var $wnd = $self;");
		out.newlineOpt();
		
		//replace the first line with our code
		prefix.replace("var $wnd = $wnd || window.parent;", out.toString());
		
		return prefix;
	}

}
