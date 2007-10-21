/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alessio Pace
 *
 */
public class ComponentGraphImpl implements ComponentGraph {
	
	private Map<String, PrimitiveComponentNode> components;
	
	public ComponentGraphImpl() {
		this.components = new HashMap<String, PrimitiveComponentNode>();
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#addPrimitiveComponentNode(org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode)
	 */
	public void addPrimitiveComponentNode(PrimitiveComponentNode node) {
		components.put(node.getPrimitiveImplementation(), node);

	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getPrimitiveComponentNodes()
	 */
	public Set<PrimitiveComponentNode> getPrimitiveComponentNodes() {
		return new HashSet<PrimitiveComponentNode>(this.components.values());
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getPrimitiveComponentNodeByImplementation(java.lang.String)
	 */
	public PrimitiveComponentNode getPrimitiveComponentNodeByImplementation(
			String implementation) throws ComponentNotFoundException {
		
		return this.components.get(implementation);
		
	}

}