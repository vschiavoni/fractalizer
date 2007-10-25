/**
 * 
 */

package org.objectweb.fractal.fractalizer.graph;

import java.util.Set;

/**
 * @author Alessio Pace, Valerio Schiavoni
 */
public interface ComponentGraph extends Visitable 
{

  /**
   * @return the set of primitive component nodes forming the graph.
   */
  Set<PrimitiveComponentNode> getPrimitiveComponentNodes();

  void addPrimitiveComponentNode(PrimitiveComponentNode node);

  /**
   * Return the {@link PrimitiveComponentNode primitive component node} with the
   * given implementation, or {@link ComponentNotFoundException}
   * 
   * @param implementation
   * @return
   */
  PrimitiveComponentNode getPrimitiveComponentNodeByImplementation(
      String implementation) throws ComponentNotFoundException;

  /**
   * Empty the graph, removing every node.
   */
  void empty();

    /**
     * return the name of the application
     * @return
     */
    String getName();
}
