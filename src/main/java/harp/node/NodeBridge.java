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

package harp.node;

import harp.script.HarpJob;

/**
 * An interface for interacting with a running {@link Node}.
 *
 * Typically, a {@link harp.dispatch.Dispatcher} uses a {@code NodeBridge} to send a job to a
 * {@code Node} and to monitor the job's progress.
 */
public interface NodeBridge {

  SendJobResult sendJob(HarpJob job);

  // TODO a method for monitoring or asking questions about a sent job
}
