package ca.mcgill.sable.soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TCmpl extends Token
{
    public TCmpl()
    {
        super.setText("cmpl");
    }

    public TCmpl(int line, int pos)
    {
        super.setText("cmpl");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TCmpl(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCmpl(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TCmpl text.");
    }
}