/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Ondrej Lhotak
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

package soot.jimple.spark.fieldrw;

import soot.*;
import java.util.*;

import soot.tagkit.*;

public class FieldReadTagAggregator extends TagAggregator
{    
    public FieldReadTagAggregator( Singletons.Global g ) {}
    public static FieldReadTagAggregator v() { return G.v().FieldReadTagAggregator(); }

    /** Decide whether this tag should be aggregated by this aggregator.
     *  Return the tag to be attached to this unit, or null if nothing should
     *  be attached. */
    public Tag wantTag(Tag t, Unit u)
    {
	if(t instanceof FieldReadTag) 
	{
            return t;
	}
        return null;
    }
    
    public String aggregatedName()
    {
        return "FieldRead";
    }
}
