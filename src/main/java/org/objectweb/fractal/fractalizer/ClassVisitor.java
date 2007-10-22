
package org.objectweb.fractal.fractalizer;

import org.objectweb.fractal.fractalizer.graph.ComponentGraph;

/**
 * Inspect  a class signature
 */
public interface ClassVisitor
{
  
  public void visit(Class<?> clazz);

  public void visit(Class<?>[] clazzes);

  /**
   * @return the component graph
   */
  public ComponentGraph getComponentGraph();
  
  
}
