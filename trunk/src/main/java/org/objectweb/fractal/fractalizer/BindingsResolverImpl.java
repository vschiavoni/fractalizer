/**
 * 
 */

package org.objectweb.fractal.fractalizer;

import java.util.Set;

import org.objectweb.fractal.fractalizer.graph.BindingNode;
import org.objectweb.fractal.fractalizer.graph.BindingNodeImpl;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.InterfaceNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;

/**
 * @author Alessio Pace
 */
public class BindingsResolverImpl implements BindingsResolver {

  /*
   * (non-Javadoc)
   * 
   * @see org.objectweb.fractal.fractalizer.BindingsResolver#resolveBindings(org.objectweb.fractal.fractalizer.graph.ComponentGraph)
   */
  public void resolveBindings(final ComponentGraph componentGraph) {

    /*
     * for each Component..
     */
    for (final PrimitiveComponentNode component : componentGraph
        .getPrimitiveComponentNodes()) {

      /*
       * ..and for each of its client interfaces..
       */
      for (final InterfaceNode clientInterface : component
          .getClientInterfaces()) {

        final Class<?> requiredType = clientInterface.getSignature();

        /* create the new BindingNode */
        final BindingNode bindingNode = new BindingNodeImpl();

        /* set the "from" edge of the binding */
        bindingNode.setFrom(clientInterface);

        /* find the possible matching server interfaces */
        final Set<InterfaceNode> possibileTos = this
            .findCompatibleServerInterfaceNodes(componentGraph, requiredType);

        /*
         * XXX what if the Set is empty?
         */
        if (possibileTos.isEmpty()) {
          throw new RuntimeException(
              "Unable to find a matching server interface for "
                  + clientInterface);
        } else {
          for (final InterfaceNode target : possibileTos) {
            bindingNode.addPossibleTo(target);
          }
        }

        /* add the BindingNode into the ComponentGraph */
        componentGraph.addBindingNode(bindingNode);
      }
    }
  }

  protected Set<InterfaceNode> findCompatibleServerInterfaceNodes(
      final ComponentGraph componentGraph,
      final Class<?> requiredProvidedInterfaceSignature) {

    throw new UnsupportedOperationException("NOT IMPLEMENTED YET");
  }

}
