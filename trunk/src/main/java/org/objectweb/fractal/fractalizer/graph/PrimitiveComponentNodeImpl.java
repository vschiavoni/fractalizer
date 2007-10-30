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
public class PrimitiveComponentNodeImpl implements PrimitiveComponentNode {

  private final Set<InterfaceNode> serverInterfaces;
  private final Set<InterfaceNode> clientInterfaces;

  private String                   implementation;
  private final String             name;

  public PrimitiveComponentNodeImpl(final String implementation) {
    this.implementation = implementation;
    this.name = implementation.substring(0, implementation.lastIndexOf("."));
    this.serverInterfaces = new HashSet<InterfaceNode>();
    this.clientInterfaces = new HashSet<InterfaceNode>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#addInterface(org.objectweb.fractal.fractalizer.graph.InterfaceNode)
   */
  public void addServerInterface(final InterfaceNode interfaceNode) {
    this.serverInterfaces.add(interfaceNode);

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getInterfaces()
   */
  public Set<InterfaceNode> getServerInterfaces() {
    return this.serverInterfaces;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getPrimitiveImplementation()
   */
  public String getPrimitiveImplementation() {
    return this.implementation;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#setPrimitiveImplementation(java.lang.String)
   */
  public void setPrimitiveImplementation(final String implementation) {
    this.implementation = implementation;
  }

  public Set<InterfaceNode> getClientInterfaces() {
    return clientInterfaces;
  }

  public void addClientInterface(final InterfaceNode interfaceNode) {
    this.clientInterfaces.add(interfaceNode);

  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.Visitable#accept(org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor)
   */
  public void accept(final ADLWriterGraphVisitor v) {

    v.accept(this);

  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getName()
   */
  public String getName() {
    return this.name;
  }
}
