/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Valerio Schiavoni <valerio.schiavoni@gmail.com>
 *
 */
public interface GraphNodeFactory
{
  PrimitiveComponentNode createUnnamedPrimitiveComponentNode();
  
  PrimitiveComponentNode createPrimitiveComponentNodeForImplName(String impl);
  
  BindingNode createBindingNode(String from);
}
