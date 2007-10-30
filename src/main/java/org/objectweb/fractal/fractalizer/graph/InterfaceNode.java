/**
 * 
 */

package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Alessio Pace
 */
public interface InterfaceNode extends Visitable {

  /**
   * @return the name of this <code>InterfaceNode</code>.
   */
  String getName();

  /**
   * @return the signature type of this <code>InterfaceNode</code>.
   */
  Class<?> getSignature();

  /**
   * @return <code>true</code> if it is a client interface, false otherwise.
   */
  Boolean isClient();

  /**
   * @return the {@link PrimitiveComponentNode} component node owning this
   *         interface.
   */
  PrimitiveComponentNode getOwner();
}
