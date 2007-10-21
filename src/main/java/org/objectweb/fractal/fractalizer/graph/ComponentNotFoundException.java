/**
 * 
 */
package org.objectweb.fractal.fractalizer.graph;

/**
 * @author Alessio Pace
 *
 */
public class ComponentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3888728277370739748L;

	/**
	 * 
	 */
	public ComponentNotFoundException() {
	}

	/**
	 * @param message
	 */
	public ComponentNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ComponentNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ComponentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
