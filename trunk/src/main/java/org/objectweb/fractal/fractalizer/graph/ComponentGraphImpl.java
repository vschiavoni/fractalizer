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
 * ComponentGraph invariants:
 * <ul>
 * <li>there can't be more than one primitive component with the same
 * implementation</li>
 * </ul>.
 * 
 * @author Alessio Pace, Valerio Schiavoni
 */
public class ComponentGraphImpl implements ComponentGraph {

  private final Map<String, PrimitiveComponentNode> components;
  private final Set<BindingNode>                    bindings;

  public ComponentGraphImpl() {
    this.components = new HashMap<String, PrimitiveComponentNode>();
    this.bindings = new HashSet<BindingNode>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#addPrimitiveComponentNode(org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode)
   */
  public void addPrimitiveComponentNode(final PrimitiveComponentNode node) {
    if (node == null) {
      throw new IllegalArgumentException("PrimitiveComponentNode can't be null");
    }
    final String primitiveImplementation = node.getPrimitiveImplementation();
    components.put(primitiveImplementation, node);

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
    this.bindings.add(bindingNode);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getBindingNodes()
   */
  public Set<BindingNode> getBindingNodes() {
    return this.bindings;
  }

}
