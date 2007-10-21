/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer.graph;


public class GraphNodeFactoryImpl implements GraphNodeFactory
{

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createPrimitiveComponentNode()
   */
  public PrimitiveComponentNode createPrimitiveComponentNode(String impl)
  {
    return new PrimitiveComponentNodeImpl(impl);
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createPrimitiveComponentNode()
   */
  public PrimitiveComponentNode createPrimitiveComponentNode()
  {
   
    return createPrimitiveComponentNode("unnamed");
  }

}
