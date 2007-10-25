/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */

package org.objectweb.fractal.fractalizer;

import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.fixtures.Client;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;

import java.util.logging.Logger;

/**
 * Test the ADLWriter
 */
public class ADLWriterGraphVisitorTest
{
  
  Logger log = Logger.getLogger(ADLWriterGraphVisitorTest.class.getCanonicalName());
  
  ADLWriterGraphVisitor              writer;

  ComponentGraph         theGraph;

  protected ClassVisitor visitor;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception
  {
    visitor = new ClassVisitorImpl();
    
    writer = new ADLWriterGraphVisitorImpl();
  }

  @Test
  public void visitGraphWithOneComponentNode()
  {

    visitor.visit(Client.class);
    theGraph = visitor.getComponentGraph();
    
    String xml = writer.visit(theGraph);
    
    print(xml);
    
    assertNotNull(xml);
    assertFalse("Resulting XML can't be empty string",xml.equalsIgnoreCase(""));

  }

  /**
   * @param xml
   */
  private void print(String xml)
  {
   log.info("ADL :\n"+xml); 
  }

  @After
  public void emptyGraph()
  {
    theGraph.empty();
  }

}
