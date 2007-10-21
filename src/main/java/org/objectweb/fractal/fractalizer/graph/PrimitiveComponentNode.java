/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import java.util.Set;

/**
 * @author Alessio Pace
 *
 */
public interface PrimitiveComponentNode {
	
	String getPrimitiveImplementation();
	
	void setPrimitiveImplementation(String implementation);
	
	Set<InterfaceNode> getInterfaces();
	
	void addInterface(InterfaceNode interfaceNode);
}
