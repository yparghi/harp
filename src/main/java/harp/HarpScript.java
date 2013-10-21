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

import groovy.lang.Closure;
import groovy.lang.Script;

/**
 * TODO
 */
public abstract class HarpScript extends Script {

  // TODO remove this testing class
  public static class ForClosureModification {
    public void myArg(int n) {
      System.out.println("You called myArg with arg: " + n);
    }
  }

  /*
  @Override
  public Object invokeMethod(String name, Object args) {
    System.out.println("Harp invoking method name: " + name + "; args: " + args);
    return super.invokeMethod(name, args);
  }*/

  public void someMethod(Closure closure) {
    System.out.println("You called some method!");
    System.out.println("Delegate: " + closure.getDelegate());
    System.out.println("Owner: " + closure.getOwner());
    System.out.println("This object: " + closure.getThisObject());
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    ForClosureModification delegate = new ForClosureModification();
    closure.setDelegate(delegate);
    System.out.println("Delegate again: " + closure.getDelegate());
    closure.call();
  }
}
