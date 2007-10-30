/**
 * 
 */

package org.objectweb.fractal.fractalizer.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor;

/**
 * @author Alessio Pace, Valerio Schiavoni
 */
public class ComponentGraphImpl implements ComponentGraph {

  private final Map<String, PrimitiveComponentNode> components;

  public ComponentGraphImpl() {
    this.components = new HashMap<String, PrimitiveComponentNode>();

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#addPrimitiveComponentNode(org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode)
   */
  public void addPrimitiveComponentNode(final PrimitiveComponentNode node) {
    components.put(node.getPrimitiveImplementation(), node);

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getPrimitiveComponentNodes()
   */
  public Set<PrimitiveComponentNode> getPrimitiveComponentNodes() {
    return new HashSet<PrimitiveComponentNode>(this.components.values());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getPrimitiveComponentNodeByImplementation(java.lang.String)
   */
  public PrimitiveComponentNode getPrimitiveComponentNodeByImplementation(
      final String implementation) throws ComponentNotFoundException {

    return this.components.get(implementation);

  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#empty()
   */
  public void empty() {
    this.components.clear();

  }

  /**
   * return the name of the application.
   * 
   * @return
   */
  public String getName() {
    return null; // To change body of implemented methods use File | Settings |
    // File Templates.
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.Visitable#accept(org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor)
   */
  public void accept(final ADLWriterGraphVisitor v) {
    v.accept(this);

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#addBindingNode(org.objectweb.fractal.fractalizer.graph.BindingNode)
   */
  public void addBindingNode(final BindingNode bindingNode) {
    throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getBindingNodes()
   */
  public Set<BindingNode> getBindingNodes() {
    throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
  }

}
