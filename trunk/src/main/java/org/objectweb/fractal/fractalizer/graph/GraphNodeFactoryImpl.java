
package org.objectweb.fractal.fractalizer.graph;

public class GraphNodeFactoryImpl implements GraphNodeFactory {

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createUnnamedPrimitiveComponentNode()
   */
  public PrimitiveComponentNode createPrimitiveComponentNodeForImplName(
      final String impl) {
    return new PrimitiveComponentNodeImpl(impl);
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createUnnamedPrimitiveComponentNode()
   */
  public PrimitiveComponentNode createUnnamedPrimitiveComponentNode() {

    return createPrimitiveComponentNodeForImplName("unnamed");
  }

  /**
   * @see org.objectweb.fractal.fractalizer.graph.GraphNodeFactory#createBindingNode(java.lang.String)
   */
  public BindingNode createBindingNode(final String from) {

    final BindingNode bn = new BindingNodeImpl();

    return bn;
  }

  /**
   * Create a client interface.
   * 
   * @param owner
   * @param name
   * @param signature
   * @return the created client interface
   */
  public InterfaceNode createClientInterface(
      final PrimitiveComponentNode owner, final String name,
      final Class<?> signature) {
    return new InterfaceNodeImpl(owner, name, signature, true);
  }

  /**
   * Create a server interface
   * 
   * @param owner
   * @param name
   * @param signature
   * @return the created server interface
   */
  public InterfaceNode createServerInterface(
      final PrimitiveComponentNode owner, final String name,
      final Class<?> signature) {
    return new InterfaceNodeImpl(owner, name, signature, false);
  }

}
