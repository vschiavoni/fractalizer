/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alessio Pace
 *
 */
public class ComponentGraphImpl implements ComponentGraph {
	
	private Set<PrimitiveComponentNode> components;
	
	public ComponentGraphImpl() {
		this.components = new HashSet<PrimitiveComponentNode>();
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#addPrimitiveComponentNode(org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode)
	 */
	public void addPrimitiveComponentNode(PrimitiveComponentNode node) {
		components.add(node);

	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.ComponentGraph#getPrimitiveComponentNodes()
	 */
	public Set<PrimitiveComponentNode> getPrimitiveComponentNodes() {
		return this.components;
	}

}
