
package org.objectweb.fractal.fractalizer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.objectweb.fractal.fractalizer.JarClassLoader.JarClassLoaderException;
import org.objectweb.fractal.fractalizer.graph.ComponentGraph;

/**
 * Fractalizer is a best-effort tool to automatically transform an
 * Object-Oriented java application to a corresponding Component-Oriented java
 * application, according to the Fractal Component Model.
 * 
 * @author Valerio Schiavoni, Alessio Pace
 */
public class Fractalizer {

  boolean                             debug = false;
  private final ClassVisitor          classVisitor;
  private final BindingsResolver      bindingResolver;
  private JarClassLoader              jarLoader;
  private final ADLWriterGraphVisitor adlWriter;

  /**
   * @param debug on if debug is activated, false otherwise
   */
  public Fractalizer(final boolean debug) {
    this.debug = debug;
    classVisitor = new ClassVisitorImpl();
    bindingResolver = new BindingsResolverImpl();
    jarLoader = null;
    adlWriter = new ADLWriterGraphVisitorImpl();
  }

  /**
   * The steps are the following:
   * <ol>
   * <li>creation of a JarClassLoader from the input jar file</li>
   * <li>creation of the ComponentGraph from the classes found in the jar</li>
   * <li>resolution of the bindings in the ComponentGrah</li>
   * <li>writing of the ComponentGraph to output format</li>
   * </ol>.
   * 
   * @param jarName
   * @return
   */
  public String fractalize(final String jarName) {
    /*
     * 1) jar class loade creation
     */
    try {
      jarLoader = JarClassLoader.createJarClassLoaderFromFileWithName(jarName);
    } catch (final JarClassLoaderException e) {
      e.printStackTrace();
    }

    /*
     * 2) ComponentGraph creation
     */
    for (final Class<?> clazz : jarLoader.getAllclasses()) {
      if (debug) {
        System.err.println("Class under visit: " + clazz.getCanonicalName());
      }
      classVisitor.visit(clazz);
    }

    /* the ComponentGraph */
    final ComponentGraph componentGraph = classVisitor.getComponentGraph();

    /*
     * 3) Binding resolution
     */
    this.bindingResolver.resolveBindings(componentGraph);

    /*
     * 4) ADL writing
     */
    return adlWriter.visit(componentGraph);

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
