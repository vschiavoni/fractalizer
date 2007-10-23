/**
 * 
 */

package org.objectweb.fractal.fractalizer.graph;

import java.util.Set;

/**
 * @author Alessio Pace, Valerio Schiavoni
 */
public interface PrimitiveComponentNode extends Visitable
{

  String getPrimitiveImplementation();

  void setPrimitiveImplementation(String implementation);

  Set<InterfaceNode> getServerInterfaces();

  void addServerInterface(InterfaceNode interfaceNode);
  
  /*
   * Need to distinguish between client and server interfaces, because otherwise when adding a client interface to the
   * set of interfaces (so, mixing client and server), we couldn't recover the information regarding its original role.
   * Instead, by splitting the information into two different sets, this information is kept intact.
   * 
   */
  public Set<InterfaceNode> getClientInterfaces();

  public void addClientInterface(InterfaceNode interfaceNode);
}
