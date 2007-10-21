/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer.graph;


public class GraphNodeFactoryImpl implements GraphNodeFactory
{

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createUnnamedPrimitiveComponentNode()
   */
  public PrimitiveComponentNode createPrimitiveComponentNodeForImplName(String impl)
  {
    return new PrimitiveComponentNodeImpl(impl);
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createUnnamedPrimitiveComponentNode()
   */
  public PrimitiveComponentNode createUnnamedPrimitiveComponentNode()
  {
   
    return createPrimitiveComponentNodeForImplName("unnamed");
  }

}
