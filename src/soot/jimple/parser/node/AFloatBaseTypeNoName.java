package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class AFloatBaseTypeNoName extends PBaseTypeNoName
{
    private TFloat _float_;

    public AFloatBaseTypeNoName()
    {
    }

    public AFloatBaseTypeNoName(
        TFloat _float_)
    {
        setFloat(_float_);

    }
    public Object clone()
    {
        return new AFloatBaseTypeNoName(
            (TFloat) cloneNode(_float_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFloatBaseTypeNoName(this);
    }

    public TFloat getFloat()
    {
        return _float_;
    }

    public void setFloat(TFloat node)
    {
        if(_float_ != null)
        {
            _float_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _float_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_float_);
    }

    void removeChild(Node child)
    {
        if(_float_ == child)
        {
            _float_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_float_ == oldChild)
        {
            setFloat((TFloat) newChild);
            return;
        }

    }
}