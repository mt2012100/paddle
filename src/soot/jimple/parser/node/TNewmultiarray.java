package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class TNewmultiarray extends Token
{
    public TNewmultiarray()
    {
        super.setText("newmultiarray");
    }

    public TNewmultiarray(int line, int pos)
    {
        super.setText("newmultiarray");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TNewmultiarray(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNewmultiarray(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TNewmultiarray text.");
    }
}