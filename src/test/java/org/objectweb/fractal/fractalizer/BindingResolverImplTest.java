/**
 * 
 */

package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.fixtures.Client;
import org.objectweb.fractal.fractalizer.fixtures.Service;
import org.objectweb.fractal.fractalizer.fixtures.ServiceImpl;
import org.objectweb.fractal.fractalizer.fixtures.ServiceImpl2;
import org.objectweb.fractal.fractalizer.graph.BindingNode;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentGraphImpl;
import org.objectweb.fractal.fractalizer.graph.InterfaceNodeImpl;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNodeImpl;

/**
 * @author Alessio Pace
 */
public class BindingResolverImplTest {

  private ComponentGraph   componentGraph;
  private BindingsResolver bindingResolver;

  /**
   * Create a {@link ComponentGraph} with a primitive component node having one
   * client interface to be bound.
   * 
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.bindingResolver = new BindingsResolverImpl();
    this.componentGraph = new ComponentGraphImpl();

    final PrimitiveComponentNode clientComponentNode = new PrimitiveComponentNodeImpl(
        Client.class.getCanonicalName());
    clientComponentNode.addClientInterface(new InterfaceNodeImpl(
        clientComponentNode, "service", Service.class));

    /* add the component in the graph */
    this.componentGraph.addPrimitiveComponentNode(clientComponentNode);

  }

  protected PrimitiveComponentNode createServiceImplComponent(
      final Class<?> concreteImplementation) {

    final PrimitiveComponentNode serviceImpl = new PrimitiveComponentNodeImpl(
        concreteImplementation.getCanonicalName());
    serviceImpl.addServerInterface(new InterfaceNodeImpl(serviceImpl,
        "service", Service.class));

    return serviceImpl;
  }

  /**
   * In this test the ComponentGraph to be resolved contains 2 primitive
   * components:
   * <ol>
   * <li>a Client component, with a Service client interface to be bound</li>
   * <li>a ServiceImpl component, providing a Service interface</li>
   * </ol>.
   */
  @Test
  public final void testResolveBindingsWithOneClientComponentAndOneMatchingServerComponent() {

    final PrimitiveComponentNode serviceImpl = createServiceImplComponent(ServiceImpl.class);
    this.componentGraph.addPrimitiveComponentNode(serviceImpl);
    this.bindingResolver.resolveBindings(componentGraph);

    assertEquals("Assert there is one matching server interface", 1,
        componentGraph.getBindingNodes().size());

  }

  @Test
  public final void testResolveBindingsWithOneClientComponentAndTwoMatchingServerComponents() {
    final PrimitiveComponentNode serviceImpl = createServiceImplComponent(ServiceImpl.class);
    this.componentGraph.addPrimitiveComponentNode(serviceImpl);

    final PrimitiveComponentNode serviceImpl2 = createServiceImplComponent(ServiceImpl2.class);
    this.componentGraph.addPrimitiveComponentNode(serviceImpl2);

    assertEquals("Assert number of components", 3, componentGraph
        .getPrimitiveComponentNodes().size());

    this.bindingResolver.resolveBindings(componentGraph);

    assertEquals("Assert number of BindingNodes", 1, componentGraph
        .getBindingNodes().size());

    final BindingNode bindingNode = new ArrayList<BindingNode>(
        this.componentGraph.getBindingNodes()).get(0);

    assertEquals("Assert number of possible matching server interfaces", 2,
        bindingNode.getPossibleTos().size());

  }

}
