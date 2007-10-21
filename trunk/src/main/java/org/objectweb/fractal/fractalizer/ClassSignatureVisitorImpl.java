/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer;

import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentGraphImpl;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactory;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;



public class ClassSignatureVisitorImpl implements ClassSignatureVisitor
{
  
  private ComponentGraph componentGraph;
  private GraphNodeFactory factory;

  public ClassSignatureVisitorImpl() {
   
    this.componentGraph = new ComponentGraphImpl();
    
    this.factory = new GraphNodeFactoryImpl();
    
  }
  
  /**
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#visit(java.lang.Class)
   */
  public void visit(Class<?> clazz)
  {
    
    PrimitiveComponentNode primitive = factory.createPrimitiveComponentNode();
    
    //enrich the node
    
    this.componentGraph.addPrimitiveComponentNode(primitive);

  }
  
  public void visit(Class<?>[] clazzes) {
    
  }

  /**
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#getComponentGraph()
   */
  public ComponentGraph getComponentGraph()
  {
    return this.componentGraph;
  }

}
