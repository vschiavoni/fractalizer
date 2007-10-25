/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Alessio Pace
 *
 */
public interface InterfaceNode extends Visitable{
	
	String getName();
	
	String getSignature();

    Boolean isClient();

    /**
	 * 
	 * @return the {@link PrimitiveComponentNode} the component node owning this interface.
	 */
	PrimitiveComponentNode getOwner();
}
