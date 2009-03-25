/* $HeadURL$
 * $Id$
 *
 * Copyright (c) 2008,2009 by Fedora Commons Inc.
 * http://www.fedoracommons.org
 *
 * In collaboration with Topaz Inc.
 * http://www.topazproject.org
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
package org.fedoracommons.akubra.impl;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit tests for {@link ManagedOutputStream}.
 *
 * @author Chris Wilper
 */
public class TestManagedOutputStream {

  /**
   * Close notification should be sent to the provided listener.
   */
  @Test
  public void testCloseNotification() throws Exception {
    MockCloseListener listener = new MockCloseListener();
    ManagedOutputStream managed = new ManagedOutputStream(listener, new ByteArrayOutputStream());
    managed.close();
    assertTrue(listener.getClosedSet().contains(managed));
  }
}