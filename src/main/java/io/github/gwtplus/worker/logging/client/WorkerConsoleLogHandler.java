/*
 * Copyright 2010 Google Inc.
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

package io.github.gwtplus.worker.logging.client;

import static io.github.gwtplus.worker.client.WorkerGlobal.console;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import com.google.gwt.logging.client.TextLogFormatter;

/**
 * A Handler that prints logs to the self.console.
 * <p>
 * Note we are consciously using 'self' rather than window or $wnd
 * since they are not available in workers
 */
public class WorkerConsoleLogHandler extends Handler {

  public WorkerConsoleLogHandler() {
    setFormatter(new TextLogFormatter(true));
    setLevel(Level.ALL);
  }
  
  @Override
  public void close() {
    // No action needed
  }

  @Override
  public void flush() {
    // No action needed
  }

  @Override
  public void publish(LogRecord record) {
    if (console == null || !isLoggable(record)) {
      return;
    }
    String msg = getFormatter().format(record);
    int val = record.getLevel().intValue();
    if (val >= Level.SEVERE.intValue()) {
      console.error(msg);
    } else if (val >= Level.WARNING.intValue()) {
      console.warn(msg);
    } else if (val >= Level.INFO.intValue()) {
      console.info(msg);
    } else {
      console.log(msg);
    }
  }
}
