
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactory;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl;

public class GraphNodeFactoryImplTest {

  GraphNodeFactory factory;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.factory = new GraphNodeFactoryImpl();
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl#createPrimitiveComponentNodeForImplName(java.lang.String)}.
   */
  @Test
  public void testCreatePrimitiveComponentNodeString() {
    assertNotNull(factory.createPrimitiveComponentNodeForImplName("foo"));
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl#createUnnamedPrimitiveComponentNode()}.
   */
  @Test
  public void testCreatePrimitiveComponentNode() {
    assertNotNull(factory.createUnnamedPrimitiveComponentNode());
  }

}
