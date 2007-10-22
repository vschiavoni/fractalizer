
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
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
  public void testVisitClient()
  {
    visitor.visit(Client.class);

    ComponentGraph graph = visitor.getComponentGraph();

    assertNotNull("The component graph should not be null", graph);

    checkTotalNodesInGraph(graph, 1);

    try
    {
      PrimitiveComponentNode primitive = graph
          .getPrimitiveComponentNodeByImplementation(Client.class
              .getCanonicalName());

      checkNotNull(primitive);

      checkImplementation(primitive, Client.class.getCanonicalName());

      final Set<InterfaceNode> serverItfs = primitive.getServerInterfaces();

      checkServerInterfaces(serverItfs, 1);
      
      final Set<InterfaceNode>  clientItfs = primitive.getClientInterfaces();
      
      checkClientInterfaces(clientItfs,1);
     

    }
    catch (ComponentNotFoundException e)
    {
      fail("Primitive component for class " + Client.class.toString()
          + " was not found");
    }

  }
  
  @Test
  public void testVisitServiceImpl() {
    
    visitor.visit(ServiceImpl.class);

    ComponentGraph graph = visitor.getComponentGraph();
    
    

    checkTotalNodesInGraph(graph, 1);
  }
  
  @Test
  public void testVisitClassesOneAfterAnother()
  {
    visitor.visit(Service.class);
    visitor.visit(ServiceImpl.class);
    ComponentGraph graph = visitor.getComponentGraph();
    checkTotalNodesInGraph(graph, 2);
  }

  @Test
  public void testVisitClassesInArray()
  {
    visitor.visit(new Class[]{Service.class, ServiceImpl.class});

    ComponentGraph graph = visitor.getComponentGraph();
    checkTotalNodesInGraph(graph, 2);
  }
  
  @Test
  public void testVisitTwiceSameClass()
  {
    visitor.visit(Service.class);
    visitor.visit(Service.class);
    ComponentGraph graph = visitor.getComponentGraph();
    checkTotalNodesInGraph(graph, 1);
  }
  
  /**
   * @param graph
   * @param expected TODO
   */
  private void checkTotalNodesInGraph(ComponentGraph graph, int expected)
  {
    assertNotNull("The component graph should not be null", graph);
    assertEquals(expected, graph.getPrimitiveComponentNodes().size());
  }
  
  

  /**
   * @param clientItfs
   * @param expected
   */
  private void checkClientInterfaces(Set<InterfaceNode> clientItfs, int expected)
  {
    assertNotNull(clientItfs);
    assertEquals(expected, clientItfs.size());
  }

  /**
   * @param serverItfs
   * @param expected TODO
   */
  private void checkServerInterfaces(final Set<InterfaceNode> serverItfs,
      int expected)
  {
    assertNotNull(serverItfs);
    assertEquals(expected, serverItfs.size());
  }

  /**
   * @param primitive
   * @param expected TODO
   */
  private void checkImplementation(PrimitiveComponentNode primitive,
      String expected)
  {
    assertEquals(expected, primitive.getPrimitiveImplementation());
  }

  /**
   * @param primitive
   */
  private void checkNotNull(PrimitiveComponentNode primitive)
  {
    assertNotNull("the primitive comp should not be null", primitive);
  }
  
  @After
  public void emptyGraphAfterVisit(){
    visitor.getComponentGraph().empty();
    assertTrue(visitor.getComponentGraph().getPrimitiveComponentNodes().isEmpty());
  }

}