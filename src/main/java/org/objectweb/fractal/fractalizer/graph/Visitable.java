
package org.objectweb.fractal.fractalizer.graph;

import org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor;

/**
 * An interface for visitable elements
 */
public interface Visitable
{
  void accept(ADLWriterGraphVisitor v);
}
