package io.github.gwtplus.worker.client;

import elemental2.dom.Console;
import jsinterop.annotations.JsType;

//internal
@JsType(namespace = "<window>", name = "self", isNative = true)
public class WorkerGlobal {

  public static Console console;

}
