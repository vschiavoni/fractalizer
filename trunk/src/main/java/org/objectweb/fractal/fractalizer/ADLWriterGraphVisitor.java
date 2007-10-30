
package org.objectweb.fractal.fractalizer;

import org.objectweb.fractal.fractalizer.graph.BindingNode;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.InterfaceNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;

/**
 * A writer can visit a {@link ComponentGraph} and produce a corresponding
 * Fractal-ADL XML file with a proposed architecture.
 * 
 * @author <a href="mailto:valerio.schiavoni@gmail.com">Valerio Schiavoni</a>
 */
public interface ADLWriterGraphVisitor {

  /**
   * @param graph the graph to visit
   * @return the ADL file as string
   */
  String visit(ComponentGraph graph);

  /**
   * Visit a component graph.
   * 
   * @param graph
   */
  void accept(ComponentGraph graph);

  /**
   * @param primitiveComponentNodeImpl
   */
  void accept(PrimitiveComponentNode primitive);

  void accept(InterfaceNode interfaceNode);

  /**
   * @param bindingNodeImpl
   */
  void accept(BindingNode bindingNodeImpl);
}
