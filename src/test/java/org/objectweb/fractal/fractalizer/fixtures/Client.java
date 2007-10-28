/**
 * 
 */

package org.objectweb.fractal.fractalizer.fixtures;

/**
 * @author Alessio Pace
 */
public class Client implements Runnable {

  private Service service;

  public Client() {
    this.service = new ServiceImpl();
  }

  public Client(final Service s) {
    this.service = s;
  }

  public final Service getService() {
    return this.service;
  }

  public final void setService(final Service service) {
    this.service = service;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  public void run() {
    this.service.doSomething();
  }

  public static void main(final String[] args) throws Exception {

    final Client c = new Client();

    final Service s = new ServiceImpl();

    c.setService(s);

    c.run();

  }

}
