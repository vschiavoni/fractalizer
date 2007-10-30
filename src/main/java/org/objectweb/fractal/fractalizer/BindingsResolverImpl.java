/**
 * 
 */

package org.objectweb.fractal.fractalizer;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.objectweb.fractal.fractalizer.graph.BindingNode;
import org.objectweb.fractal.fractalizer.graph.BindingNodeImpl;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.InterfaceNode;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;

/**
 * @author Alessio Pace
 */
public class BindingsResolverImpl implements BindingsResolver {

  Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

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

            /* if the two interfaces do not belong to the same component :-) */
            if (target.getOwner() != clientInterface.getOwner()) {
              bindingNode.addPossibleTo(target);
            }
          }
        }

        /* add the BindingNode into the ComponentGraph */
        componentGraph.addBindingNode(bindingNode);
      }
    }
  }

  /**
   * @param componentGraph the ComponentGraph
   * @param requiredProvidedInterfaceSignature the type of the server interfaces
   *            to be returned
   * @return a Set of InterfaceNode whose signature is the same type or a
   *         subtype of the requiredProvidedInterfaceSignature
   */
  protected Set<InterfaceNode> findCompatibleServerInterfaceNodes(
      final ComponentGraph componentGraph,
      final Class<?> requiredProvidedInterfaceSignature) {

    final Set<InterfaceNode> result = new HashSet<InterfaceNode>();

    // TODO make it more efficient, eventually adjusting the ComponentGraph
    // interface to provide more convient methods and/or using better internal
    // organization of the data structure of the ComponentGraph concrete
    // implementation.

    for (final PrimitiveComponentNode component : componentGraph
        .getPrimitiveComponentNodes()) {

      for (final InterfaceNode serverInterface : component
          .getServerInterfaces()) {

        /* if the serverInterface is compatible */
        if (requiredProvidedInterfaceSignature.isAssignableFrom(serverInterface
            .getSignature())) {

          result.add(serverInterface);
        }
      }
    }

    /* the result could eventually be empty */
    return result;

  }

}
