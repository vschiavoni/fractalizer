
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.fixtures.Client;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNodeImpl;

public class PrimitiveComponentNodeImplTest {

  PrimitiveComponentNode primitiveComp;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNodeImpl#PrimitiveComponentNodeImpl(java.lang.String)}.
   */
  @Test
  public void testPrimitiveComponentNodeImpl() {
    this.primitiveComp = new PrimitiveComponentNodeImpl(Client.class
        .getCanonicalName());
    assertEquals("Client", primitiveComp.getName());
  }

}
