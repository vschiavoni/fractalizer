
package org.objectweb.fractal.fractalizer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * JarResources: JarResources maps all resources included in a Zip or Jar file.
 * Additionally, it provides a method to extract one as a blob.
 */
public final class JarResources {

  // external debug flag
  private boolean                          debugOn       = false;

  // jar resource mapping tables
  private final Hashtable<String, Integer> htSizes       = new Hashtable<String, Integer>();
  private final Hashtable<String, byte[]>  htJarContents = new Hashtable<String, byte[]>();

  // a jar file
  private final String                     jarFileName;

  /**
   * creates a JarResources. It extracts all resources from a Jar into an
   * internal hashtable, keyed by resource names.
   * 
   * @param jarFileName a jar or zip file
   */
  public JarResources(final String jarFileName) {
    this.jarFileName = jarFileName;
    init();
  }

  public JarResources(final String jarFileName, final boolean debug) {
    this.debugOn = debug;
    this.jarFileName = jarFileName;
    init();
  }

  /**
   * Extracts a jar resource as a blob.
   * 
   * @param name a resource name.
   */
  public byte[] getResource(final String name) {
    return htJarContents.get(name);
  }

  /**
   * Keyset view of classes available for this JarResources. The set contains
   * only .class files. If other resources are available in the JAR archive,
   * those are not part of the returned set.
   * 
   * @return a keyset view of classes available for this JarResources.
   */
  public Set<String> classes() {
    final Set<String> classes = new HashSet<String>();
    for (final String resource : htJarContents.keySet()) {
      if (resource.endsWith(".class")) {
        classes.add(resource);
      }
    }
    return classes;
  }

  /** initializes internal hash tables with Jar file resources. */
  private void init() {
    try {
      // extracts just sizes only.
      final ZipFile zf = new ZipFile(jarFileName);
      final Enumeration e = zf.entries();
      while (e.hasMoreElements()) {
        final ZipEntry ze = (ZipEntry) e.nextElement();

        if (debugOn) {
          System.out.println(dumpZipEntry(ze));
        }

        htSizes.put(ze.getName(), new Integer((int) ze.getSize()));
      }
      zf.close();

      // extract resources and put them into the hashtable.
      final FileInputStream fis = new FileInputStream(jarFileName);
      final BufferedInputStream bis = new BufferedInputStream(fis);
      final ZipInputStream zis = new ZipInputStream(bis);
      ZipEntry ze = null;
      while ((ze = zis.getNextEntry()) != null) {
        if (ze.isDirectory()) {
          continue;
        }

        if (debugOn) {
          System.out.println("ze.getName()=" + ze.getName() + ","
              + "getSize()=" + ze.getSize());
        }

        int size = (int) ze.getSize();
        // -1 means unknown size.
        if (size == -1) {
          size = (htSizes.get(ze.getName())).intValue();
        }

        final byte[] b = new byte[size];
        int rb = 0;
        int chunk = 0;
        while ((size - rb) > 0) {
          chunk = zis.read(b, rb, size - rb);
          if (chunk == -1) {
            break;
          }
          rb += chunk;
        }

        // add to internal resource hashtable
        htJarContents.put(ze.getName(), b);

        if (debugOn) {
          System.out.println(ze.getName() + "  rb=" + rb + ",size=" + size
              + ",csize=" + ze.getCompressedSize());
        }
      }
    } catch (final NullPointerException e) {
      System.out.println("done.");
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Dumps a zip entry into a string.
   * 
   * @param ze a ZipEntry
   */
  private String dumpZipEntry(final ZipEntry ze) {
    final StringBuffer sb = new StringBuffer();
    if (ze.isDirectory()) {
      sb.append("d ");
    } else {
      sb.append("f ");
    }

    if (ze.getMethod() == ZipEntry.STORED) {
      sb.append("stored   ");
    } else {
      sb.append("deflated ");
    }

    sb.append(ze.getName());
    sb.append("\t");
    sb.append("" + ze.getSize());
    if (ze.getMethod() == ZipEntry.DEFLATED) {
      sb.append("/" + ze.getCompressedSize());
    }

    return (sb.toString());
  }

  /**
   * Is a test driver. Given a jar file and a resource name, it tries to extract
   * the resource and then tells us whether it could or not. <strong>Example</strong>
   * Let's say you have a JAR file which jarred up a bunch of gif image files.
   * Now, by using JarResources, you could extract, create, and display those
   * images on-the-fly.
   * 
   * <pre>
   *     ...
   *     JarResources JR=new JarResources(&quot;GifBundle.jar&quot;);
   *     Image image=Toolkit.createImage(JR.getResource(&quot;logo.gif&quot;);
   *     Image logo=Toolkit.getDefaultToolkit().createImage(
   *                   JR.getResources(&quot;logo.gif&quot;)
   *                   );
   *     ...
   * </pre>
   */
  public static void main(final String[] args) throws IOException {
    if (args.length != 2) {
      System.err
          .println("usage: java JarResources <jar file name> <resource name>");
      System.exit(1);
    }

    final JarResources jr = new JarResources(args[0]);
    final byte[] buff = jr.getResource(args[1]);
    if (buff == null) {
      System.out.println("Could not find " + args[1] + ".");
    } else {
      System.out.println("Found " + args[1] + " (length=" + buff.length + ").");
    }
  }

  public void setDebugOn(final boolean debugOn) {
    this.debugOn = debugOn;
  }

} // End of JarResources class.

