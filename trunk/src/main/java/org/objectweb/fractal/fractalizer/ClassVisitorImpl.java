
package org.objectweb.fractal.fractalizer;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentGraphImpl;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactory;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;

/**
 * Default impl.
 * 
 * @author Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
public class ClassVisitorImpl implements ClassVisitor {

  Logger                         log = Logger.getLogger(ClassVisitorImpl.class
                                         .getCanonicalName());

  private final ComponentGraph   componentGraph;
  private final GraphNodeFactory factory;
  private final BindingsResolver bindingResolver;

  public ClassVisitorImpl() {

    this.componentGraph = new ComponentGraphImpl();

    this.factory = new GraphNodeFactoryImpl();

    this.bindingResolver = new BindingsResolverImpl();

  }

  /**
   * @see org.objectweb.fractal.fractalizer.ClassVisitor#visit(java.lang.Class)
   */
  public void visit(final Class<?> clazz) {

    /* if it is not an interface it is a candidate to be a primitive component */
    if (!clazz.isInterface()) {

      final PrimitiveComponentNode primitive = factory
          .createPrimitiveComponentNodeForImplName(clazz.getCanonicalName());

      for (final Class<?> itf : clazz.getInterfaces()) {
        final String itfName = itf.getSimpleName();
        primitive.addServerInterface(factory.createServerInterface(primitive,
            itfName, itf));
      }

      final Field[] fields = clazz.getDeclaredFields(); // potential
      // client-interfaces
      for (final Field f : fields) {
        final Class<?> clientItfType = f.getType();
        log.info("Field class type: " + clientItfType);
        final String clientItfName = f.getName();
        log.info("Field name: " + clientItfName);

        primitive.addClientInterface(factory.createClientInterface(primitive,
            clientItfName, clientItfType));

      }

      this.componentGraph.addPrimitiveComponentNode(primitive);
    }

    log.info("Launching binding resolution step...");
    // bindingResolver.resolveBindings(this.componentGraph);
  }

  /**
   * Visit all classes.
   * 
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#visit(java.lang.Class<?>[])
   */
  public void visit(final Class<?>[] clazzes) {
    for (final Class<?> c : clazzes) {
      visit(c);
    }
  }

  /**
   * @see org.objectweb.fractal.fractalizer.ClassVisitor#getComponentGraph()
   */
  public ComponentGraph getComponentGraph() {
    return this.componentGraph;
  }

}
