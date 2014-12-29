package com.kodemore.wiki.parsers;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.io.KmIndentPrintWriter;
import com.kodemore.wiki.KmWikiSource;

public abstract class KmWikiContainer
    extends KmWikiElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmWikiElement> _children;

    //##################################################
    //# constructor
    //##################################################

    public KmWikiContainer(KmWikiSource e)
    {
        super(e);
        _children = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<KmWikiElement> getChildren()
    {
        return _children;
    }

    public void addChild(KmWikiElement e)
    {
        _children.add(e);
    }

    //##################################################
    //# print
    //##################################################

    protected void printChildrenOn(KmHtmlBuilder out)
    {
        for ( KmWikiElement e : getChildren() )
            e.printHtmlOn(out);
    }

    //##################################################
    //# printTree
    //##################################################

    @Override
    public void printTreeOn(KmIndentPrintWriter out)
    {
        super.printTreeOn(out);
        out.indent();
        for ( KmWikiElement e : getChildren() )
            e.printTreeOn(out);
        out.undent();
    }

}
