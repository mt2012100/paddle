package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class AInterfaceNonstaticInvoke extends PNonstaticInvoke
{
    private TInterfaceinvoke _interfaceinvoke_;

    public AInterfaceNonstaticInvoke()
    {
    }

    public AInterfaceNonstaticInvoke(
        TInterfaceinvoke _interfaceinvoke_)
    {
        setInterfaceinvoke(_interfaceinvoke_);

    }
    public Object clone()
    {
        return new AInterfaceNonstaticInvoke(
            (TInterfaceinvoke) cloneNode(_interfaceinvoke_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInterfaceNonstaticInvoke(this);
    }

    public TInterfaceinvoke getInterfaceinvoke()
    {
        return _interfaceinvoke_;
    }

    public void setInterfaceinvoke(TInterfaceinvoke node)
    {
        if(_interfaceinvoke_ != null)
        {
            _interfaceinvoke_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _interfaceinvoke_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_interfaceinvoke_);
    }

    void removeChild(Node child)
    {
        if(_interfaceinvoke_ == child)
        {
            _interfaceinvoke_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_interfaceinvoke_ == oldChild)
        {
            setInterfaceinvoke((TInterfaceinvoke) newChild);
            return;
        }

    }
}