/**
 * 
 */

package org.objectweb.fractal.fractalizer.graph;

import java.util.HashSet;
import java.util.Set;

import org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor;

/**
 * @author Alessio Pace, Valerio Schiavoni
 */
public class PrimitiveComponentNodeImpl implements PrimitiveComponentNode
{

  private Set<InterfaceNode> serverInterfaces;
  private Set<InterfaceNode> clientInterfaces;

  private String             implementation;

  public PrimitiveComponentNodeImpl(String implementation)
  {
    this.implementation = implementation;
    this.serverInterfaces = new HashSet<InterfaceNode>();
    this.clientInterfaces = new HashSet<InterfaceNode>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#addInterface(org.objectweb.fractal.fractalizer.graph.InterfaceNode)
   */
  public void addServerInterface(InterfaceNode interfaceNode)
  {
    this.serverInterfaces.add(interfaceNode);

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getInterfaces()
   */
  public Set<InterfaceNode> getServerInterfaces()
  {
    return this.serverInterfaces;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getPrimitiveImplementation()
   */
  public String getPrimitiveImplementation()
  {
    return this.implementation;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#setPrimitiveImplementation(java.lang.String)
   */
  public void setPrimitiveImplementation(String implementation)
  {
    this.implementation = implementation;
  }

  public Set<InterfaceNode> getClientInterfaces()
  {
    return clientInterfaces;
  }

  public void addClientInterface(InterfaceNode interfaceNode)
  {
    this.clientInterfaces.add(interfaceNode);

  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.Visitable#accept(org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor)
   */
  public void accept(ADLWriterGraphVisitor v)
  {
    
    v.accept(this);
    
  }
}
