package soot.jimple.toolkits.annotation.tags;


import soot.*;
import java.util.*;

import soot.tagkit.*;

/** The aggregator for ArrayNullCheckAttribute. */

public class ArrayNullTagAggregator implements TagAggregator
{    
    private boolean status = false;
    private List tags = new LinkedList();
    private List units = new LinkedList();

    private Unit lastUnit = null;
    private ArrayNullCheckTag lastTag = null;

    public ArrayNullTagAggregator(boolean active)
    {
	this.status = active;
    }

    public boolean isActive()
    {
	return this.status;
    }

  /** Clears accumulated tags. */
    public void refresh()
    {
        tags.clear();
	units.clear();
	lastUnit = null;
	lastTag = null;
    }

  /** Adds a new (unit, tag) pair. */
    public void aggregateTag(Tag t, Unit u)
    {
	if(t instanceof OneByteCodeTag) 
	{	
	    if (lastUnit == u)
	    {
		byte[] v = ((OneByteCodeTag)t).getValue();
	    	lastTag.accumulate(v[0]);
            }
	    else
	    {
		units.add(u);
		lastUnit = u;
		
		byte[] v = ((OneByteCodeTag)t).getValue();
		lastTag = new ArrayNullCheckTag(v[0]);
		tags.add(lastTag);
	    }
	}
    }
    
  /** Returns a CodeAttribute with all tags aggregated. */ 
    public Tag produceAggregateTag()
    {
	if(units.size() == 0)
	    return null;
	else
	    return new CodeAttribute("ArrayNullCheckAttribute", 
				     new LinkedList(units), 
				     new LinkedList(tags));
    }
}






