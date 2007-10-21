/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Alessio Pace
 *
 */
public class InterfaceNodeImpl implements InterfaceNode {

	private String name;
	private String signature;
	
	public InterfaceNodeImpl(String name, String signature) {
		this.name = name;
		this.signature = signature;
	}
	
	public final String getName() {
		return this.name;
	}

	public final String getSignature() {
		return this.signature;
	}

}
