package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class TNewarray extends Token
{
    public TNewarray()
    {
        super.setText("newarray");
    }

    public TNewarray(int line, int pos)
    {
        super.setText("newarray");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TNewarray(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNewarray(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TNewarray text.");
    }
}