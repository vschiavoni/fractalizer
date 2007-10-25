/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

import org.objectweb.fractal.fractalizer.ADLWriterGraphVisitor;

/**
 * @author Alessio Pace
 *
 */
public class InterfaceNodeImpl implements InterfaceNode {

	private PrimitiveComponentNode owner;
	private String name;
	private String signature;
    private Boolean isClient;

    /**
     * Construct a  client interface.
     *
     * @param owner  the owner of this interface
     * @param name    the name of this interface
     * @param signature   the signature, that is its runtime type
     */
    public InterfaceNodeImpl(PrimitiveComponentNode owner, String name, String signature) {
		       this(owner,name,signature, true);
	}

    /**
     * @param owner  the owner of this interface
     * @param name    the name of this interface
     * @param signature   the signature, that is its runtime type
     * @param isClient true if this interface is a client interface, false otherwise.
     */
    public InterfaceNodeImpl(PrimitiveComponentNode owner, String name, String signature, Boolean isClient){
        this.owner = owner;
		this.name = name;
		this.signature = signature;
        this.isClient = isClient;
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

    public Boolean isClient() {
        return this.isClient;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
  public String toString()
  {
    return "InterfaceNode ["+name+","+signature+"]";
  }

    public void accept(ADLWriterGraphVisitor v) {
        v.accept(this);
    }
}
