package org.objectweb.fractal.fractalizer;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;

/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
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
   * Test method for {@link org.objectweb.fractal.fractalizer.ClassSignatureVisitorImpl#visit(java.lang.Class)}.
   */
  @Test
  public void testVisit()
  {
    visitor.visit(Client.class);
    
    ComponentGraph graph =  visitor.getComponentGraph();
    
    assertNotNull("The component graph should not be null",graph);
    
    assertEquals(1,graph.getPrimitiveComponentNodes().size());
  }

}
