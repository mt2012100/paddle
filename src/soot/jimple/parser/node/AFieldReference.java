package soot.jimple.parser.node;

import ca.mcgill.sable.util.*;
import java.util.*;
import soot.jimple.parser.analysis.*;

public final class AFieldReference extends PReference
{
    private PFieldRef _fieldRef_;

    public AFieldReference()
    {
    }

    public AFieldReference(
        PFieldRef _fieldRef_)
    {
        setFieldRef(_fieldRef_);

    }
    public Object clone()
    {
        return new AFieldReference(
            (PFieldRef) cloneNode(_fieldRef_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFieldReference(this);
    }

    public PFieldRef getFieldRef()
    {
        return _fieldRef_;
    }

    public void setFieldRef(PFieldRef node)
    {
        if(_fieldRef_ != null)
        {
            _fieldRef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _fieldRef_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_fieldRef_);
    }

    void removeChild(Node child)
    {
        if(_fieldRef_ == child)
        {
            _fieldRef_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_fieldRef_ == oldChild)
        {
            setFieldRef((PFieldRef) newChild);
            return;
        }

    }
}