/* Soot - a J*va Optimization Framework
 * Copyright (C) 2000 Patrice Pominville and Feng Qian
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
 * Modified by the Sable Research Group and others 1997-1999.  
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */


package soot.tagkit;

import java.util.*;
import soot.baf.*;
import soot.*;


/** A CodeAttribute object holds PC -> Tag pairs.
 */
public class CodeAttribute extends JasminAttribute
{
    private List mUnits;
    private List mTags;

    private byte[] value;
    
    private String name = "CodeAtribute";

    public CodeAttribute(){}
    
  /** Creates an attribute object with the given name. */
    public CodeAttribute(String name)
    {
    	this.name = name;
    }

  /** Create an attribute object with the name and lists of unit-tag pairs. */
    public CodeAttribute(String name, List units, List tags)
    {
    	this.name = name;
	this.mUnits = units;
	this.mTags = tags;
    }

  /** Returns the name.*/
    public String toString()
    {
	return name;
    }

  /** Returns the attribute name. */
    public String getName()
    {
	return name;
    }

  /** Only used by SOOT to read in an existing attribute without interpret it.*/
    public void setValue(byte[] v)
    {
    	this.value = v;
    }
    
  /** Also only used as setValue(). */
    public byte[] getValue() throws AttributeValueException
    {
	if (value == null)
	    throw new AttributeValueException();
	else
	    return value;
    }

  /** Generates Jasmin Value String */
    public String getJasminValue(Map instToLabel)
    {
	StringBuffer buf = new StringBuffer();
	
	if (mTags.size() != mUnits.size())
	    throw new RuntimeException("Sizes must match!");
	
	Iterator tagIt = mTags.iterator();
	Iterator unitIt = mUnits.iterator();

	while (tagIt.hasNext())
	{
	    Object unit = unitIt.next();
	    Object tag = tagIt.next();

	    buf.append("%"+instToLabel.get(unit) + "%"+ 
		       new String(Base64.encode(((Tag)tag).getValue())));
	}
    
	return buf.toString();
    }

  /** Returns a list of unit boxes that have tags attached. */
    public List getUnitBoxes()
    {
	List unitBoxes = new ArrayList(mUnits.size());
	
	Iterator it = mUnits.iterator();
	
	while(it.hasNext()) {
	    unitBoxes.add(Baf.v().newInstBox((Unit)it.next()));
	}

	return unitBoxes;
    }    
}
	  