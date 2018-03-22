/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.gwtplus.worker.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.Artifact;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.CompilationResult;
import com.google.gwt.core.ext.linker.EmittedArtifact;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.core.ext.linker.LinkerOrder.Order;
import com.google.gwt.core.ext.linker.Shardable;
import com.google.gwt.core.ext.linker.Transferable;
import com.google.gwt.core.ext.linker.impl.SelectionScriptLinker;
import com.google.gwt.dev.About;
import com.google.gwt.dev.util.DefaultTextOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * A Linker for producing a single JavaScript file from a GWT module. The use of
 * this Linker requires that the module has exactly one distinct compilation
 * result.
 * 
 * Customized to support worker linker. See //#worker comments
 */
@LinkerOrder(Order.PRIMARY)
@Shardable
public class SingleScriptLinker extends SelectionScriptLinker {
  @Override
  public String getDescription() {
    return "Single Script";
  }

  @Transferable
  protected static class Script extends Artifact<Script> {

	private static final long serialVersionUID = -8385802388145548029L;
	private final String javaScript;
    private final String strongName;

    public Script(String strongName, String javaScript) {
      super(SingleScriptLinker.class);
      this.strongName = strongName;
      this.javaScript = javaScript;
    }

    @Override
    public int compareToComparableArtifact(Script that) {
      int res = strongName.compareTo(that.strongName);
      if (res == 0) {
        res = javaScript.compareTo(that.javaScript);
      }
      return res;
    }

    @Override
    public Class<Script> getComparableArtifactType() {
      return Script.class;
    }

    public String getJavaScript() {
      return javaScript;
    }

    public String getStrongName() {
      return strongName;
    }

    @Override
    public int hashCode() {
      return strongName.hashCode() ^ javaScript.hashCode();
    }

    @Override
    public String toString() {
      return "Script " + strongName;
    }
  }

  @Override
  protected Collection<Artifact<?>> doEmitCompilation(TreeLogger logger,
      LinkerContext context, CompilationResult result, ArtifactSet artifacts)
      throws UnableToCompleteException {

    String[] js = result.getJavaScript();
    if (js.length != 1) {
      logger.branch(TreeLogger.ERROR, getMultiFragmentWarningMessage(), null);
      throw new UnableToCompleteException();
    }

    Collection<Artifact<?>> toReturn = new ArrayList<Artifact<?>>();
    toReturn.add(new Script(result.getStrongName(), js[0]));
    toReturn.addAll(emitSelectionInformation(result.getStrongName(), result));
    return toReturn;
  }
  
  @Override
  protected EmittedArtifact emitSelectionScript(TreeLogger logger,
      LinkerContext context, ArtifactSet artifacts)
      throws UnableToCompleteException {

    // Find the single Script result
    Set<Script> results = artifacts.find(Script.class);
    ensureSinglePermutation(logger, context, results);
    Script result = results.iterator().next();

    DefaultTextOutput out = new DefaultTextOutput(true);

    // Emit the selection script.
    String bootstrap = generateSelectionScript(logger, context, artifacts);
    bootstrap = context.optimizeJavaScript(logger, bootstrap);
    out.print(bootstrap);
    out.newlineOpt();

    // Emit the module's JS a closure.
    out.print("(function () {");
    out.newlineOpt();
    out.print("var $gwt_version = \"" + About.getGwtVersionNum() + "\";");
    out.newlineOpt();
    
    defineJsWndAndDoc(out);
    
    out.print("var $moduleName, $moduleBase;");
    out.newlineOpt();
    out.print("var $stats = $wnd.__gwtStatsEvent ? function(a) {$wnd.__gwtStatsEvent(a)} : null;");
    out.newlineOpt();

    out.print("var $strongName = '" + result.getStrongName() + "';");
    out.newlineOpt();

    out.print(result.getJavaScript());

    // Generate the call to tell the bootstrap code that we're ready to go.
    out.newlineOpt();
    out.print("if (" + context.getModuleFunctionName() + ") "
        + context.getModuleFunctionName() + ".onScriptLoad(gwtOnLoad);");
    out.newlineOpt();
    out.print("})();");
    out.newlineOpt();

    return emitString(logger, out.toString(), context.getModuleName()
        + getCompilationExtension(logger, context));
  }
  
  //#worker used so it's possible to override
  @Override
  protected String getCompilationExtension(TreeLogger logger,
      LinkerContext context) throws UnableToCompleteException {
    return ".nocache.js";
  }

  /**
   * Unimplemented. Normally required by
   * {@link #doEmitCompilation(TreeLogger, LinkerContext, CompilationResult, ArtifactSet)}.
   */
  @Override
  protected String getModulePrefix(TreeLogger logger, LinkerContext context,
      String strongName) throws UnableToCompleteException {
    throw new UnableToCompleteException();
  }

  @Override
  protected String getSelectionScriptTemplate(TreeLogger logger, LinkerContext context)
      throws UnableToCompleteException {
    return "com/google/gwt/core/linker/SingleScriptTemplate.js";
  }
  
  //#worker: refactored out to be able to customize the message
  protected String getMultiFragmentWarningMessage() {
  	return "The module must not have multiple fragments when using the "
  	      + getDescription() + " Linker.";
  }

  //#worker: refactored out to be able to customize creation of $wnd and $doc
  protected void defineJsWndAndDoc(DefaultTextOutput out) {
	out.print("var $wnd = window;");
    out.newlineOpt();
    out.print("var $doc = $wnd.document;");
    out.newlineOpt();
  }

  //#worker: refactored out to be able to print helper message what may have
  //caused multiply permutations
  protected void ensureSinglePermutation(TreeLogger logger, LinkerContext context,
		  Set<Script> results) throws UnableToCompleteException {
	if (results.size() != 1) {
      logger.log(TreeLogger.ERROR, "The module must have exactly one distinct"
          + " permutation when using the " + getDescription() + " Linker; found "
    	  + results.size(), null);
      throw new UnableToCompleteException();
    }
  }
}