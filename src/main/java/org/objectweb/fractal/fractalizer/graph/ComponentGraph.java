/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.Set;

/**
 * @author Alessio Pace
 *
 */
public interface ComponentGraph {
	
	Set<PrimitiveComponentNode> getPrimitiveComponentNodes();
	
	void addPrimitiveComponentNode(PrimitiveComponentNode node);
}
