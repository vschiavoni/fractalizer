/**
 * 
 */

package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.fixtures.Client;
import org.objectweb.fractal.fractalizer.fixtures.Service;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentGraphImpl;
import org.objectweb.fractal.fractalizer.graph.InterfaceNodeImpl;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNodeImpl;

/**
 * @author Alessio Pace
 */
public class BindingResolverImplTest {

  private ComponentGraph componentGraph;

  /**
   * Create a {@link ComponentGraph} with a primitive component node having one
   * client interface to be bound.
   * 
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.componentGraph = new ComponentGraphImpl();

    final PrimitiveComponentNode clientComponentNode = new PrimitiveComponentNodeImpl(
        Client.class.getCanonicalName());
    clientComponentNode.addClientInterface(new InterfaceNodeImpl(
        clientComponentNode, "service", Service.class));

    /* add the component in the graph */
    this.componentGraph.addPrimitiveComponentNode(clientComponentNode);

  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.BindingsResolverImpl#resolveBindings(org.objectweb.fractal.fractalizer.graph.ComponentGraph)}.
   */
  @Test
  public final void testResolveBindings() {
    fail("Not yet implemented");
  }

}
