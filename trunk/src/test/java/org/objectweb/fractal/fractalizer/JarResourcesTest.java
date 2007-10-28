
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.fixtures.Client;

/**
 * 
 **/
public class JarResourcesTest {

  JarResources jarResources;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    // todo create the jar archive within the test..for now, i've done it by
    // hand.
    this.jarResources = new JarResources("src/test/resources/fixtures.jar",
        true);

  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.JarResources#getResource(java.lang.String)}.
   */
  @Test
  public void testGetResource() {
    final String name = Client.class.getCanonicalName().replace('.', '/');

    System.err.println("Requested resouce: " + name + ".class");
    final byte[] clientBytes = this.jarResources.getResource(name + ".class");
    assertNotNull("Bytes for class " + Client.class.getCanonicalName()
        + " are null", clientBytes);
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.JarResources#classes()}.
   */
  @Test
  public void testClasses() {
    assertEquals(4, this.jarResources.classes().size());
  }

}
