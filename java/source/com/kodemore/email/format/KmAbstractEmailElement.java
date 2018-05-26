package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public abstract class KmAbstractEmailElement
    implements KmEmailElementIF
{
    //##################################################
    //# convenience
    //##################################################

    protected void renderStyleOn(KmHtmlBuilder out, String style)
    {
        if ( style == null )
            return;

        out.printAttribute(STYLE_KEY, style);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public KmHtmlBuilder toHtmlBuilder()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        renderOn(out);
        return out;
    }

    @Override
    public String formatHtml()
    {
        return toHtmlBuilder().formatHtml();
    }

    @Override
    public String toString()
    {
        return formatHtml();
    }
}
