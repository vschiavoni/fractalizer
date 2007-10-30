
package org.objectweb.fractal.fractalizer.graph;

import org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor;

/**
 * Classes that implement this interface can be visited by Visitors.
 */
public interface Visitable {
  void accept(ADLWriterGraphVisitor v);
}
