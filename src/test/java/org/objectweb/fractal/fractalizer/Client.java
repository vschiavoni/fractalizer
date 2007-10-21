/**
 * 
 */
package org.objectweb.fractal.fractalizer;

/**
 * @author Alessio Pace
 *
 */
public class Client implements Runnable {

	private Service service;
	
	public Client() {
		this.service = new ServiceImpl();
	}
	
	public Client(Service s) {
		this.service = s;
	}
	
	public final Service getService() {
		return this.service;
	}

	public final void setService(Service service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.service.doSomething();
	}
	
	public static void main(String[] args) throws Exception {
		
		Client c = new Client();
		
		Service s = new ServiceImpl();
		
		c.setService(s);
		
		c.run();
		
	}

}
