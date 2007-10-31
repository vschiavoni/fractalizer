
package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Valerio Schiavoni, Alessio Pace
 */
public class FractalizerTest {

  Fractalizer fractalizer;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.fractalizer = new Fractalizer(true);
  }

  @Test
  public void testMain() throws IOException {
    this.fractalizer.main(new String[]{"src/test/resources/fixtures.jar",
        "target/fixtures.fractal"});

    assertTrue(new File("target/fixtures.fractal").exists());
  }
}
