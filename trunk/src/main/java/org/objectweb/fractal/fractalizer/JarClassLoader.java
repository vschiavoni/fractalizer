
package org.objectweb.fractal.fractalizer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarClassLoader extends URLClassLoader {

  /**
   * A set of class names providing access to this class loader's classes. This
   * set is initialized right after this constructor.
   */
  public static Set<String> clazzes = new LinkedHashSet<String>();

  protected Set<Class<?>> getAllclasses() {
    final Set<Class<?>> classesInCL = new LinkedHashSet<Class<?>>();

    for (final String cn : clazzes) {
      try {
        classesInCL.add(this.loadClass(cn.substring(0, cn.length() - 6)
            .replace('/', '.')));
      } catch (final ClassNotFoundException e) {
        e.printStackTrace();

      }
    }

    return classesInCL;
  }

  private JarClassLoader(final URL url) {
    super(new URL[]{url});

  }

  private JarClassLoader(final String url) throws MalformedURLException {

    this(new URL(url));
  }

  /**
   * @param jarFile the jar file to load
   * @return
   * @throws JarClassLoaderException
   */
  public static JarClassLoader createJarClassLaoderFromFile(final File jarFile)
      throws JarClassLoaderException {
    final String jarFileURL = "jar:file:" + jarFile.getAbsolutePath() + "!/";
    // Log.debug("Attempting to load from " + jarFileURL);

    init(jarFile);

    URL url;
    try {
      url = new URL(jarFileURL);
    } catch (final MalformedURLException e) {
      e.printStackTrace();
      throw new JarClassLoaderException(e);
    }
    return new JarClassLoader(url);
  }

  /**
   * @param jarFile the jar file to load
   * @return
   * @throws JarClassLoaderException
   */
  public static JarClassLoader createJarClassLaoderFromFileWithName(
      final String jarName) throws JarClassLoaderException {

    return createJarClassLaoderFromFile(new File(jarName));
  }

  /**
   * @param jarFile Jarfile to browse
   * @return
   */
  public static void init(final File jarFile) {

    try {
      final JarFile jar = new JarFile(jarFile);
      for (final Enumeration<JarEntry> e = jar.entries(); e.hasMoreElements();) {
        final JarEntry je = e.nextElement();
        if (!je.isDirectory() && je.getName().endsWith(".class")) {
          clazzes.add(je.getName());
        }
      }
    } catch (final IOException ioe) {
      System.err.println(ioe.getMessage());
    }

  }

  /**
   * @author wyatt An exception thrown when loading jars.
   */
  public static class JarClassLoaderException extends Exception {
    public static final long serialVersionUID = 0;

    public JarClassLoaderException(final Exception e) {
      super(e);
    }

    public JarClassLoaderException(final String s) {
      super(s);
    }

    public JarClassLoaderException(final Error e) {
      super(e);
    }
  }

}