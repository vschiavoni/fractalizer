
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

  public ClassVisitorImpl() {

    this.componentGraph = new ComponentGraphImpl();

    this.factory = new GraphNodeFactoryImpl();

  }

  /**
   * @see org.objectweb.fractal.fractalizer.ClassVisitor#visit(java.lang.Class)
   */
  public void visit(final Class<?> clazz) {

    if (!clazz.isInterface()) {

      final PrimitiveComponentNode primitive = factory
          .createPrimitiveComponentNodeForImplName(clazz.getCanonicalName());

      for (final Class<?> itf : clazz.getInterfaces()) {
        final String itfName = itf.getSimpleName();
        final String itfSign = itf.getCanonicalName();
        primitive.addServerInterface(factory.createServerInterface(primitive,
            itfName, itfSign));
      }

      final Field[] fields = clazz.getDeclaredFields(); // potential
      // client-interfaces
      for (final Field f : fields) {
        final String clientItfType = f.getType().getCanonicalName();
        log.info("Field class type: " + clientItfType);
        final String clientItfName = f.getName();
        log.info("Field name: " + clientItfName);

        primitive.addClientInterface(factory.createClientInterface(primitive,
            clientItfName, clientItfType));

      }

      this.componentGraph.addPrimitiveComponentNode(primitive);
    }
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
