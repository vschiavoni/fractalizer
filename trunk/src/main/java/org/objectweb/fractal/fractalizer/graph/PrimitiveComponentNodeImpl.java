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
public class PrimitiveComponentNodeImpl implements PrimitiveComponentNode {

	private Set<InterfaceNode> interfaces;
	private String implementation;
	
	public PrimitiveComponentNodeImpl(String implementation) {
		this.implementation = implementation;
		this.interfaces = new HashSet<InterfaceNode>();
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#addInterface(org.objectweb.fractal.fractalizer.graph.InterfaceNode)
	 */
	public void addInterface(InterfaceNode interfaceNode) {
		this.interfaces.add(interfaceNode);
		
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getInterfaces()
	 */
	public Set<InterfaceNode> getInterfaces() {
		return this.getInterfaces();
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#getPrimitiveImplementation()
	 */
	public String getPrimitiveImplementation() {
		return this.implementation;
	}

	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.PrimitiveComponentNode#setPrimitiveImplementation(java.lang.String)
	 */
	public void setPrimitiveImplementation(String implementation) {
		this.implementation = implementation;
	}

}
