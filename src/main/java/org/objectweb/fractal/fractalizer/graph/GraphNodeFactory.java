
package org.objectweb.fractal.fractalizer.graph;

public interface GraphNodeFactory {

  /**
   * Create a primitive component node without name.
   * 
   * @return
   */
  PrimitiveComponentNode createUnnamedPrimitiveComponentNode();

  /**
   * @param name
   * @return
   */
  PrimitiveComponentNode createPrimitiveComponentNodeForImplName(String name);

  BindingNode createBindingNode(String from);

  /**
   * Create a client interface.
   * 
   * @param owner
   * @param name
   * @param signature
   * @return the created client interface
   */
  InterfaceNode createClientInterface(PrimitiveComponentNode owner,
      String name, String signature);

  /**
   * Create a server interface
   * 
   * @param owner
   * @param name
   * @param signature
   * @return the created server interface
   */
  InterfaceNode createServerInterface(PrimitiveComponentNode owner,
      String name, String signature);

}
