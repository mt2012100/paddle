package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class X1PCatchClause extends XPCatchClause
{
    private XPCatchClause _xPCatchClause_;
    private PCatchClause _pCatchClause_;

    public X1PCatchClause()
    {
    }

    public X1PCatchClause(
        XPCatchClause _xPCatchClause_,
        PCatchClause _pCatchClause_)
    {
        setXPCatchClause(_xPCatchClause_);
        setPCatchClause(_pCatchClause_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPCatchClause getXPCatchClause()
    {
        return _xPCatchClause_;
    }

    public void setXPCatchClause(XPCatchClause node)
    {
        if(_xPCatchClause_ != null)
        {
            _xPCatchClause_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPCatchClause_ = node;
    }

    public PCatchClause getPCatchClause()
    {
        return _pCatchClause_;
    }

    public void setPCatchClause(PCatchClause node)
    {
        if(_pCatchClause_ != null)
        {
            _pCatchClause_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pCatchClause_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPCatchClause_ == child)
        {
            _xPCatchClause_ = null;
        }

        if(_pCatchClause_ == child)
        {
            _pCatchClause_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPCatchClause_) +
            toString(_pCatchClause_);
    }
}