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
	
	/**
	 * @return the set of primitive component nodes forming the graph.
	 */
	Set<PrimitiveComponentNode> getPrimitiveComponentNodes();
	
	void addPrimitiveComponentNode(PrimitiveComponentNode node);
	
	/**
	 * Return the {@link PrimitiveComponentNode primitive component node} with the given implementation, or 
	 * {@link ComponentNotFoundException} 
	 * 
	 * @param implementation
	 * @return
	 */
	PrimitiveComponentNode getPrimitiveComponentNodeByImplementation(String implementation) throws ComponentNotFoundException;
}
