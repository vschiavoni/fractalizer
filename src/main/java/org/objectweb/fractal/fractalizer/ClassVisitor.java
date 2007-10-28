
package org.objectweb.fractal.fractalizer;

import org.objectweb.fractal.fractalizer.graph.ComponentGraph;

/**
 * Inspect a class signature
 */
public interface ClassVisitor {

  void visit(Class<?> clazz);

  void visit(Class<?>[] clazzes);

  /**
   * @return the component graph
   */
  ComponentGraph getComponentGraph();

}
