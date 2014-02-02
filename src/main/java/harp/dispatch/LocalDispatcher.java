/*
 * Copyright 2014 Yash Parghi
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

package harp.dispatch;

import harp.Context;
import harp.GroovyRunner;
import harp.HarpJob;
import harp.executable.Executable;
import harp.executor.Executor;
import harp.executor.LocalExecutor;

/**
 * TODO
 */
public final class LocalDispatcher implements Dispatcher {

  public LocalDispatcher() {

  }

  @Override
  public void dispatch(HarpJob job) {
    // TODO loop through each executable.
    String executableName = job.getExecutablesToRun().get(0);
    System.out.println("Running executable '" + executableName + "' locally.");

    Context context = GroovyRunner.parseHarpScript(job.getScript());

    Executable executableToRun = null;
    for (Executable exec : context.getExecutables()) {
      if (exec.getName().equals(executableName)) {
        executableToRun = exec;
        break;
      }
    }

    if (executableToRun == null) {
      throw new IllegalArgumentException("Executable '" + executableName + "' not found!");
    }

    Executor executor = new LocalExecutor();
    executor.execute(executableToRun, context);
  }

}
