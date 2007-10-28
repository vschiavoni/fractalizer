
package org.objectweb.fractal.fractalizer;

import java.util.Set;

public class JarClassLoader extends MultiClassLoader {
  private final JarResources jarResources;

  public JarClassLoader(final String jarName) {
    // Create the JarResource and suck in the jar file.
    jarResources = new JarResources(jarName);
    this.monitorOn = true;
  }

  @Override
  protected byte[] loadClassBytes(final String className) {
    // Support the MultiClassLoader's class name munging facility.
    // className = formatClassName(className); XXX commented out by me

    // Attempt to get the class data from the JarResource.
    return (jarResources.getResource(className));
  }

  protected Set<String> classes() {
    return this.jarResources.classes();
  }

  public static void main(final String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: java JarClassLoader "
          + "<jar file name> <class name>");
      System.exit(1);
    }
    /*
     * Create the jar class loader and use the first argument passed in from the
     * command line as the jar file to use.
     */
    final JarClassLoader jarLoader = new JarClassLoader(args[0]);
    /* Load the class from the jar file and resolve it. */

    final Class c = jarLoader.loadClass(args[1], true);

  }
}