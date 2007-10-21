/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Alessio Pace
 *
 */
public class InterfaceNodeImpl implements InterfaceNode {

	private PrimitiveComponentNode owner;
	private String name;
	private String signature;
	
	public InterfaceNodeImpl(PrimitiveComponentNode owner, String name, String signature) {
		this.owner = owner;
		this.name = name;
		this.signature = signature;
	}


	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.InterfaceNode#getOwner()
	 */
	public PrimitiveComponentNode getOwner() {
		return this.owner;
	}


	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.InterfaceNode#getName()
	 */
	public String getName() {
		return this.name;
	}


	/* (non-Javadoc)
	 * @see org.objectweb.fractal.fractalizer.graph.InterfaceNode#getSignature()
	 */
	public String getSignature() {
		return this.signature;
	}

}
