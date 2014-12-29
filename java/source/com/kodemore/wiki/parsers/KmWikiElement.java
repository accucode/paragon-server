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
        try
        {
            StringWriter w = new StringWriter();
            printTreeOn(w);
            w.close();
            return w.toString();
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

    public final void printTreeOn(OutputStream os)
    {
        KmIndentPrintWriter out;
        out = new KmIndentPrintWriter(os);
        printTreeOn(out);
        out.flush();
    }

    public final void printTreeOn(Writer w)
    {
        KmIndentPrintWriter out;
        out = new KmIndentPrintWriter(w);
        printTreeOn(out);
        out.flush();
    }

    public void printTreeOn(KmIndentPrintWriter out)
    {
        String s =
            Kmu.format("%s (%s,%s)", getName(), getSource().getRow(), getSource().getColumn());
        out.println(s);
    }
}
