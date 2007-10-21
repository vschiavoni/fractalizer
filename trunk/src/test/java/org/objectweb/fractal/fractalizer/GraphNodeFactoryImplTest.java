/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactory;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl;

/**
 * @author Valerio Schiavoni <valerio.schiavoni@gmail.com>
 *
 */
public class GraphNodeFactoryImplTest
{
  
  GraphNodeFactory factory;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception
  {
    this.factory = new GraphNodeFactoryImpl();
  }

  /**
   * Test method for {@link org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl#createPrimitiveComponentNode(java.lang.String)}.
   */
  @Test
  public void testCreatePrimitiveComponentNodeString()
  {
   assertNotNull(factory.createPrimitiveComponentNode("foo"));
  }

  /**
   * Test method for {@link org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl#createPrimitiveComponentNode()}.
   */
  @Test
  public void testCreatePrimitiveComponentNode()
  {
    assertNotNull(factory.createPrimitiveComponentNode());
  }

}
