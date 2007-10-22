/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.Set;

/**
 * @author Alessio Pace, Valerio Schiavoni
 *
 */
public interface BindingNode {
	
	InterfaceNode getFrom();
	
	/**
	 * 
	 * @return The target server interface which can match the signature requested by the the client interface in the <code>getFrom()</code>.
	 */
	Set<InterfaceNode> getPossibleTos();
	
	/**
	 * Add a possible interface node to the set of possible interface nodes
	 * @param to
	 */
	void addPossibleTo(InterfaceNode to);
}
