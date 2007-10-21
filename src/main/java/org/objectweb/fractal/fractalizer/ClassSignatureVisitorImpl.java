/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
package org.objectweb.fractal.fractalizer;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import org.objectweb.fractal.fractalizer.graph.ComponentGraph;
import org.objectweb.fractal.fractalizer.graph.ComponentGraphImpl;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactory;
import org.objectweb.fractal.fractalizer.graph.GraphNodeFactoryImpl;
import org.objectweb.fractal.fractalizer.graph.InterfaceNodeImpl;
import org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode;



public class ClassSignatureVisitorImpl implements ClassSignatureVisitor
{
  
  Logger log = Logger.getLogger(ClassSignatureVisitorImpl.class.getCanonicalName());
  
  private ComponentGraph componentGraph;
  private GraphNodeFactory factory;

  public ClassSignatureVisitorImpl() {
   
    this.componentGraph = new ComponentGraphImpl();
    
    this.factory = new GraphNodeFactoryImpl();
    
  }
  
  /**
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#visit(java.lang.Class)
   */
  public void visit(Class<?> clazz)
  {
    
    PrimitiveComponentNode primitive = factory.createPrimitiveComponentNodeForImplName(clazz.getCanonicalName());
    
    //enrich the node
    
    for (Class<?> itf: clazz.getInterfaces()) {
      String itfName = itf.getSimpleName();
      String itfSign = itf.getCanonicalName();
      primitive.addInterface(new InterfaceNodeImpl(primitive,itfName, itfSign ));
    }
    
    
    Field[] fields = clazz.getDeclaredFields(); //potential client-interfaces
    for (Field f: fields) {
      log.info(f.toString());
    }
    
    
    this.componentGraph.addPrimitiveComponentNode(primitive);

  }
  
  /**
   * Visit all classes.
   * 
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#visit(java.lang.Class<?>[])
   */
  public void visit(Class<?>[] clazzes) {
    for (Class<?> c: clazzes) {
      visit(c);
    }
  }

  /**
   * @see org.objectweb.fractal.fractalizer.ClassSignatureVisitor#getComponentGraph()
   */
  public ComponentGraph getComponentGraph()
  {
    return this.componentGraph;
  }

}
