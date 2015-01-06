package com.kodemore.wiki.parsers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.io.KmIndentPrintWriter;
import com.kodemore.utility.Kmu;
import com.kodemore.wiki.KmWikiSource;

public abstract class KmWikiElement
{
    //##################################################
    //# variables
    //##################################################

    private KmWikiSource _source;

    //##################################################
    //# constructor
    //##################################################

    public KmWikiElement(KmWikiSource e)
    {
        _source = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmWikiSource getSource()
    {
        return _source;
    }

    public String getName()
    {
        return getClass().getSimpleName();
    }

    //##################################################
    //# testing
    //##################################################

    public abstract boolean isBlock();

    public boolean isNotBlock()
    {
        return !isBlock();
    }

    public boolean isDocument()
    {
        return false;
    }

    //##################################################
    //# print
    //##################################################

    public final String printHtml()
    {
        KmHtmlBuilder out = new KmHtmlBuilder();
        printHtmlOn(out);
        return out.toString();
    }

    public abstract void printHtmlOn(KmHtmlBuilder out);

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getName();
    }

    //##################################################
    //# printTree
    //##################################################

    public final String printTree()
    {
        try ( StringWriter out = new StringWriter() )
        {
            printTreeOn(out);
            return out.toString();
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public final void dumpTree()
    {
        printTreeOn(System.out);
    }

    @SuppressWarnings("resource")
    public final void printTreeOn(OutputStream os)
    {
        printTreeOn(new KmIndentPrintWriter(os));
    }

    @SuppressWarnings("resource")
    public final void printTreeOn(Writer w)
    {
        printTreeOn(new KmIndentPrintWriter(w));
    }

    public void printTreeOn(KmIndentPrintWriter out)
    {
        out.printf("%s (%s,%s)%n", getName(), getSource().getRow(), getSource().getColumn());
    }
}
