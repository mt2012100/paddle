/* Soot - a J*va Optimization Framework
 * Copyright (C) 2000 Feng Qian
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

package soot.jimple.toolkits.annotation.arraycheck;

import java.util.*;

/** BoundedPriorityList keeps a list in a priority queue.
 * The order is decided by the initial list. 
 */
class BoundedPriorityList
{
    private List fulllist;
    private LinkedList worklist; 

    public BoundedPriorityList(List list)
    {
	this.fulllist = list;
	this.worklist = new LinkedList(list);
    }

    public boolean isEmpty()
    {
	return worklist.isEmpty();
    }

    public Object removeFirst()
    {
	return worklist.removeFirst();
    }

    public void add(Object toadd)
    {
	/* it is not added to the end, but keep it in the order */
	int index = fulllist.indexOf(toadd);

	int i = 0;
	int size = worklist.size();

	for (; i<size; i++)
	{
	    Object tocomp = worklist.get(i);
	    int tmpidx = fulllist.indexOf(tocomp);
	    if (index < tmpidx)
		break;
	}

	worklist.add(i, toadd);
    }
}