/**
 * Simulates the native method side effects in class java.util.zip.ZipFile
 *
 * @author Feng Qian
 * @author <XXX>
 */

package soot.jimple.toolkits.pointer.nativemethods;

import soot.*;
import soot.jimple.toolkits.pointer.representations.*;
import soot.jimple.toolkits.pointer.util.*;

public class JavaUtilZipZipFileNative extends NativeMethodClass {

  private static JavaUtilZipZipFileNative instance =
    new JavaUtilZipZipFileNative();

  private JavaUtilZipZipFileNative(){}

  public static JavaUtilZipZipFileNative v() { return instance; }

  /**
   * Implements the abstract method simulateMethod.
   * It distributes the request to the corresponding methods 
   * by signatures.
   */
  public void simulateMethod(SootMethod method,
			     ReferenceVariable thisVar,
			     ReferenceVariable returnVar,
			     ReferenceVariable params[]){

    String subSignature = method.getSubSignature();

    {
      defaultMethod(method, thisVar, returnVar, params);
      return;

    }
  }
}