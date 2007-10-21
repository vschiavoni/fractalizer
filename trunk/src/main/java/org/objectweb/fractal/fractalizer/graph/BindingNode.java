/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.Set;

/**
 * @author Alessio Pace
 *
 */
public interface BindingNode {
	
	InterfaceNode getFrom();
	
	/**
	 * 
	 * @return The target server interface which can match the signature requested by the the client interface in the <code>getFrom()</code>.
	 */
	Set<InterfaceNode> getPossibleTos();
}
