package com.kodemore.email.format;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

public abstract class KmAbstractEmailContainer
    extends KmAbstractEmailElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmEmailElementIF> _children;

    //##################################################
    //# constructor
    //##################################################

    public KmAbstractEmailContainer()
    {
        _children = new KmList<>();
    }

    //##################################################
    //# children
    //##################################################

    public KmList<KmEmailElementIF> getChildren()
    {
        return _children;
    }

    public void add(KmEmailElementIF e)
    {
        getChildren().add(e);
    }

    //==================================================
    //= children :: text
    //==================================================

    public KmEmailText addText(String text)
    {
        KmEmailText e;
        e = new KmEmailText(text);
        add(e);
        return e;
    }

    public KmEmailText addText(String msg, Object... args)
    {
        return addText(Kmu.format(msg, args));
    }

    public KmEmailHeader addHeader(String text)
    {
        KmEmailHeader e;
        e = new KmEmailHeader(text);
        add(e);
        return e;
    }

    public KmEmailHeader addHeader(String msg, Object... args)
    {
        return addHeader(Kmu.format(msg, args));
    }

    public KmEmailSubHeader addSubHeader(String text)
    {
        KmEmailSubHeader e;
        e = new KmEmailSubHeader(text);
        add(e);
        return e;
    }

    public KmEmailSubHeader addSubHeader(String msg, Object... args)
    {
        return addSubHeader(Kmu.format(msg, args));
    }

    //==================================================
    //= children :: layout
    //==================================================

    public void addGap()
    {
        add(new KmEmailGap());
    }

    public void addGapSmall()
    {
        add(new KmEmailSmallGap());
    }

    public void addDivider()
    {
        add(new KmEmailDivider());
    }

    public void addSpacedDivider()
    {
        addGap();
        addDivider();
        addGap();
    }

    //==================================================
    //= children :: section
    //==================================================

    public KmEmailSection addSection(String title, String subtitle)
    {
        KmEmailSection e;
        e = new KmEmailSection(title, subtitle);
        add(e);
        return e;
    }

    public KmEmailSubSection addSubSection(String title, String subtitle)
    {
        KmEmailSubSection e;
        e = new KmEmailSubSection(title, subtitle);
        add(e);
        return e;
    }

    //==================================================
    //= children :: table
    //==================================================

    public KmEmailTable addTable()
    {
        KmEmailTable e;
        e = new KmEmailTable();
        add(e);
        return e;
    }

    //==================================================
    //= children :: literal
    //==================================================

    public KmEmailLiteral addLiteral()
    {
        KmEmailLiteral e;
        e = new KmEmailLiteral();
        add(e);
        return e;
    }

    public KmEmailLiteral addLiteral(KmHtmlBuilder content)
    {
        KmEmailLiteral e;
        e = addLiteral();
        e.setContent(content);
        return e;
    }

    //##################################################
    //# format
    //##################################################

    protected abstract void renderOpenOn(KmHtmlBuilder out);

    protected abstract void renderCloseOn(KmHtmlBuilder out);

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderOn(KmHtmlBuilder out)
    {
        renderOpenOn(out);

        for ( KmEmailElementIF child : getChildren() )
            child.renderOn(out);

        renderCloseOn(out);
    }
}
