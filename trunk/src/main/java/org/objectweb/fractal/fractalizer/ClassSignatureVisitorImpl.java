/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer;

import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentGraphImpl;



public class ClassSignatureVisitorImpl implements ClassSignatureVisitor
{
  
  private ComponentGraph componentGraph;

  public ClassSignatureVisitorImpl() {
   
    this.componentGraph = new ComponentGraphImpl();
    
  }
  
  /**
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#visit(java.lang.Class)
   */
  public void visit(Class<?> clazz)
  {
    // TODO Auto-generated method stub

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
