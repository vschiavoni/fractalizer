
package org.objectweb.fractal.fractalizer;

/**
 * Inspect  a class signature
 */
public interface ClassSignatureVisitor
{
  
  public void visit(Class<?> clazz);
  
}
