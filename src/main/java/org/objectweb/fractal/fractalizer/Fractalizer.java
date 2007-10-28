
package org.objectweb.fractal.fractalizer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Fractalizer is a best-effort tool to automatically transform an
 * Object-Oriented java application to a corresponding Component-Oriented java
 * application, according to the Fractal Component Model.
 */
public class Fractalizer {

  boolean debug = false;

  /**
   * @param debug on if debug is activated, false otherwise
   */
  public Fractalizer(final boolean debug) {
    this.debug = debug;
  }

  public String fractalize(final String jarName) {
    final ClassVisitor visitor = new ClassVisitorImpl();

    final JarClassLoader jarLoader = new JarClassLoader(jarName);

    for (final String clazz : jarLoader.classes()) {
      if (!clazz.endsWith(".class")) {
        if (debug) {
          System.err.println("Skipping file: " + clazz);
        }
        continue;
      }
      try {
        if (debug) {
          System.err.println("Loading: " + clazz);
        }
        final Class<?> c = jarLoader.loadClass(clazz, true); // true to resolve
                                                              // the class,
                                                              // required to use
                                                              // it.
        visitor.visit(c);
      } catch (final ClassNotFoundException e) {
        System.err.println("Could not load class with name: " + clazz);
        e.printStackTrace();

      }
    }

    final ADLWriterGraphVisitor writer = new ADLWriterGraphVisitorImpl();

    return writer.visit(visitor.getComponentGraph());
  }

  public void writeAdlOn(final String adlContent, final String adlFileName)
      throws IOException {
    FileUtils.writeStringToFile(new File(adlFileName), adlContent);
  }

  /**
   * @param args
   * @throws IOException if some error occurs while crating output file
   */
  public static void main(final String[] args) throws IOException {
    if (args.length < 2) {
      help("Wrong arguments (expected:2, given:" + args.length + ")");
      help();
    }

    final String jarFileName = args[0];
    final String adlFileName = args[1];
    if (jarFileName != null) {
      if (!jarFileName.endsWith(".jar")) {
        help("Input file is not a jar archive");
      } else if (!adlFileName.endsWith(".fractal")) {
        help("Output file is not a valid fractal file");
      }
    }

    final Fractalizer fractalizer = new Fractalizer(true);
    final String adlAsString = fractalizer.fractalize(jarFileName);
    fractalizer.writeAdlOn(adlAsString, adlFileName);
  }

  private static void help(final String message) {
    System.out.println(message);
    help();
  }

  /**
   * Print usage and exit badly.
   */
  private static void help() {
    System.out.println("* Fractalizer - Help *");
    System.out
        .println("Usage: \n java -jar fractalizer-${current.version} [inputFile.jar] [outputAdlFile.fractal]");
    System.exit(1);
  }

}
