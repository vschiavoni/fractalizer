
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentNotFoundException;
import org.objectweb.fractal.fractalizer.graph.InterfaceNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;

/**
 * Tests for the {@link ClassSignatureVisitorImpl} visitor.
 */

public class ClassSignatureVisitorTest
{

  ClassSignatureVisitor visitor;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception
  {
    this.visitor = new ClassSignatureVisitorImpl();
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.ClassSignatureVisitorImpl#visit(java.lang.Class)}.
   */
  @Test
  public void testVisit()
  {
    visitor.visit(Client.class);

    ComponentGraph graph = visitor.getComponentGraph();

    assertNotNull("The component graph should not be null", graph);

    assertEquals(1, graph.getPrimitiveComponentNodes().size());

    try
    {
      PrimitiveComponentNode primitive = graph
          .getPrimitiveComponentNodeByImplementation(Client.class
              .getCanonicalName());

      assertNotNull("the primitive comp should not be null", primitive);

      assertEquals(Client.class.getCanonicalName(), primitive
          .getPrimitiveImplementation());

      final Set<InterfaceNode> interfaces = primitive.getInterfaces();

      assertNotNull(interfaces);

      assertEquals("Client exposes 'Runnable' as server interfaces ", 1,
          interfaces.size());

    }
    catch (ComponentNotFoundException e)
    {
      fail("Primitive component for class " + Client.class.toString()
          + " was not found");
    }

  }

}
