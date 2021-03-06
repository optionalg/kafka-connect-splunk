/**
 * Copyright © 2016 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.kafka.connect.splunk;

import org.slf4j.Logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

class RequestLoggingHandler extends Handler {
  private final Logger log;

  RequestLoggingHandler(Logger log) {
    this.log = log;
  }

  @Override
  public void close() throws SecurityException {
  }

  @Override
  public void flush() {
  }

  @Override
  public void publish(LogRecord record) {
    if (Level.SEVERE.intValue() == record.getLevel().intValue()) {
      log.error(record.getMessage());
    } else if (Level.WARNING.intValue() == record.getLevel().intValue()) {
      log.warn(record.getMessage());
    } else if (Level.INFO.intValue() == record.getLevel().intValue()) {
      log.info(record.getMessage());
    } else if (Level.INFO.intValue() > record.getLevel().intValue()) {
      log.debug(record.getMessage());
    }
  }
}
