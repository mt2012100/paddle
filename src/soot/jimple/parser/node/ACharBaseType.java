package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class ACharBaseType extends PBaseType
{
    private TChar _char_;

    public ACharBaseType()
    {
    }

    public ACharBaseType(
        TChar _char_)
    {
        setChar(_char_);

    }
    public Object clone()
    {
        return new ACharBaseType(
            (TChar) cloneNode(_char_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACharBaseType(this);
    }

    public TChar getChar()
    {
        return _char_;
    }

    public void setChar(TChar node)
    {
        if(_char_ != null)
        {
            _char_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _char_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_char_);
    }

    void removeChild(Node child)
    {
        if(_char_ == child)
        {
            _char_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_char_ == oldChild)
        {
            setChar((TChar) newChild);
            return;
        }

    }
}