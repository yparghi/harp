/*
 * Copyright 2013 Yash Parghi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package harp.script;

import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;

/**
 * Logic for evaluating a Harp script.
 */
public final class GroovyRunner {

  private GroovyRunner() {}  // Do not instantiate.

  /**
   * Evaluates the text of a Harp script and returns a {@code Context} with all the parsed
   * elements in it.
   */
  public static Context parseHarpScript(String scriptText) {
    CompilerConfiguration config = new CompilerConfiguration();
    config.setScriptBaseClass(HarpScript.class.getCanonicalName());

    HarpBinding binding = new HarpBinding();
    GroovyShell shell = new GroovyShell(binding, config);

    shell.evaluate(scriptText);

    return binding.getContextBuilder().build();
  }
}
