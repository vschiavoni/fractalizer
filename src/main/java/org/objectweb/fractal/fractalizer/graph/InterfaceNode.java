/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Alessio Pace
 *
 */
public interface InterfaceNode {
	
	String getName();
	
	String getSignature();
	
	/**
	 * 
	 * @return the {@link PrimitiveComponentNode} the component node owning this interface.
	 */
	PrimitiveComponentNode getOwner();
}