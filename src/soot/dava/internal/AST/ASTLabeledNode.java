package soot.dava.internal.AST;

import soot.dava.internal.SET.*;

public abstract class ASTLabeledNode extends ASTNode
{
    private SETNodeLabel label;
    
    public ASTLabeledNode( SETNodeLabel label)
    {
	super();

	set_Label( label);
    }

    public SETNodeLabel get_Label()
    {
	return label;
    }

    public void set_Label( SETNodeLabel label)
    {
	this.label = label;
    }

    public String label_toString( String indentation)
    {
	if (label.toString() == null)
	    return new String();

	else {
	    StringBuffer b = new StringBuffer();

	    b.append( indentation);
	    b.append( label.toString());
	    b.append( ":");
	    b.append( ASTNode.NEWLINE);

	    return b.toString();
	}
    }
}