/* Soot - a J*va Optimization Framework
 * Copyright (C) 2002 Florian Loitsch
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

/*
 * Modified by the Sable Research Group and others 1997-2002.
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */


package soot.jimple.toolkits.scalar.pre;
import soot.*;
import soot.toolkits.scalar.*;
import soot.toolkits.graph.*;
import soot.jimple.toolkits.scalar.*;
import soot.jimple.*;
import java.util.*;
import soot.util.*;

/** 
 * Performs a Not-Isolated-analysis on the given graph, which is basicly the
 * same as an Isolated-analysis (we just return the complement, as it's easier
 * to calculate it).
 * A computation is isolated, if it can only be used at the current
 * computation-point. In other words: if the result of the computation will not
 * be used later on (modification of an operand, or not the only path to the
 * next computation point) the computation is isolated.<br>
 * The Earliest-analysis helps us in finding isolated computations, as they
 * show us points, where a precedent computation can't be used anymore.
 */
public class NotIsolatedAnalysis extends BackwardFlowAnalysis {
  private EarliestnessComputation unitToEarliest;
  private Map unitToGen;
  private FlowSet emptySet;

  /**
   * this constructor should not be used, and will throw a runtime-exception!
   */
  public NotIsolatedAnalysis(DirectedGraph dg) {
    /* we have to add super(dg). otherwise Javac complains. */
    super(dg);
    throw new RuntimeException("Don't use this Constructor!");
  }

  /**
   * automaticly performs the Isolation-analysis on the graph
   * <code>dg</code> using the Earliest-computation <code>earliest</code>.<br>
   * the <code>equivRhsMap</code> is only here to avoid doing these things
   * again...
   *
   * @param dg a CompleteUnitGraph
   * @param earliest the earliest-computation of the same graph.
   * @param equivRhsMap the rhs of each unit (if assignment-stmt).
   */
  public NotIsolatedAnalysis(DirectedGraph dg, EarliestnessComputation earliest,
      Map equivRhsMap) {
    super(dg);
    UnitGraph g = (UnitGraph)dg;
    emptySet = new ToppedSet(new ArraySparseSet());
    unitToGen = equivRhsMap;
    unitToEarliest = earliest;
    doAnalysis();
  }

  protected Object newInitialFlow() {
    Object newSet = emptySet.clone();
    return newSet;
  }

  protected void flowThrough(Object inValue, Object unit, Object outValue) {
    FlowSet in = (FlowSet) inValue, out = (FlowSet) outValue;

    in.copy(out);

    // Perform generation
    EquivalentValue rhs = (EquivalentValue)unitToGen.get(unit);
    if (rhs != null)
      out.add(rhs, out);

    Iterator earliestIt = unitToEarliest.getEarliestBefore((Unit)unit).iterator();
    while (earliestIt.hasNext())
      out.remove(earliestIt.next(), out);
  }

  protected void merge(Object in1, Object in2, Object out) {
    FlowSet inSet1 = (FlowSet) in1;
    FlowSet inSet2 = (FlowSet) in2;

    FlowSet outSet = (FlowSet) out;

    inSet1.union(inSet2, outSet);
  }

  protected void copy(Object source, Object dest) {
    FlowSet sourceSet = (FlowSet) source;
    FlowSet destSet = (FlowSet) dest;

    sourceSet.copy(destSet);
  }
}