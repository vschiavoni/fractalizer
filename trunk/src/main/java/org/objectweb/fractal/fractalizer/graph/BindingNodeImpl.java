/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Valerio Schiavoni <valerio.schiavoni@gmail.com>
 *
 */
public class BindingNodeImpl implements BindingNode
{
  
  Set<InterfaceNode> possibleTos;
  
  InterfaceNode from;
  
  public BindingNodeImpl() {
    this.possibleTos = new HashSet<InterfaceNode>();
  }
  
  /**
   * @see org.objectweb.fractal.fractalizer.graph.BindingNode#getFrom()
   */
  public InterfaceNode getFrom()
  {
    return this.from;
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.BindingNode#getPossibleTos()
   */
  public Set<InterfaceNode> getPossibleTos()
  {
    return this.possibleTos;
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.BindingNode#addPossibleTo(org.objectweb.fractal.fractalizer.graph.InterfaceNode)
   */
  public void addPossibleTo(InterfaceNode to)
  {
   this.possibleTos.add(to);
  }

  public void setFrom(InterfaceNode from)
  {
    this.from = from;
  }

}