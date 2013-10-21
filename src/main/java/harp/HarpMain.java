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

package harp;

import com.google.common.base.Joiner;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;

/**
 * TODO
 */
public final class HarpMain {

  public static void main(String[] args) {
    System.out.println("Hello Harp!");

    ContextBuilder builder = Context.builder();

    Binding binding = new Binding();
    binding.setVariable("context", builder);

    // TODO set a property or variable for the context builder so that I can access it in
    // HarpScript code for delegation purposes?
    CompilerConfiguration config = new CompilerConfiguration();
    config.setScriptBaseClass(HarpScript.class.getCanonicalName());

    GroovyShell shell = new GroovyShell(binding, config);

    Object scriptResult = shell.evaluate(Joiner.on("\n").join(
        "println \"Running!\"",
        "someMethod()"
        ));

    //Context context = builder.build();
    //System.out.println("scriptResult: " + context.getExecutables().get(0).getCommand());
  }

}