/**
 * Author: Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */

package org.objectweb.fractal.fractalizer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.objectweb.fractal.fractalizer.JarClassLoader.JarClassLoaderException;
import org.objectweb.fractal.fractalizer.fixtures.Client;

/**
 * @author Valerio Schiavoni <valerio.schiavoni@gmail.com>
 */
public class JarClassLoaderTest {

  private static final String FIXTURES_PATH_JAR = "src/test/resources/fixtures.jar";
  JarClassLoader              cl;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.JarClassLoader#createJarClassLaoderFromFile(java.io.File)}.
   */
  @Test
  public void testCreateJarClassLaoderFromFile() {
    final File fixtures = new File(FIXTURES_PATH_JAR);
    try {
      cl = JarClassLoader.createJarClassLaoderFromFile(fixtures);
      checkClassLoader(cl);
    } catch (final JarClassLoaderException e) {
      fail("this should not happen");
    }
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.JarClassLoader#createJarClassLaoderFromFileWithName(java.lang.String)}.
   */
  @Test
  public void testCreateJarClassLaoderFromString() {
    try {
      cl = JarClassLoader
          .createJarClassLaoderFromFileWithName(FIXTURES_PATH_JAR);
      checkClassLoader(cl);
    } catch (final JarClassLoaderException e) {

    }
  }

  /**
   * Test method for
   * {@link org.objectweb.fractal.fractalizer.JarClassLoader#getAllClasses(java.io.File, java.lang.String)}.
   * 
   * @throws JarClassLoaderException
   */
  @Test
  public void testGetAllClasses() throws JarClassLoaderException {
    cl = JarClassLoader.createJarClassLaoderFromFileWithName(FIXTURES_PATH_JAR);
    final Set<Class<?>> allClasses = cl.getAllclasses();
    assertNotNull(allClasses);
    assertTrue(allClasses.size() > 0);
  }

  @After
  public void nullifyClassLoader() {
    this.cl = null;
  }

  /**
   * @throws ClassNotFoundException
   */
  private void checkClassLoader(final ClassLoader cl) {
    try {
      cl.loadClass(Client.class.getCanonicalName());
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
      fail("this should not happen");
    }
  }

}
