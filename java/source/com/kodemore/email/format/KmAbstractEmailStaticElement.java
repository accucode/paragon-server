package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public abstract class KmAbstractEmailStaticElement
    extends KmAbstractEmailElement
{
    //##################################################
    //# content
    //##################################################

    protected abstract KmHtmlBuilder formatContent();

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderOn(KmHtmlBuilder out)
    {
        KmHtmlBuilder content = formatContent();
        if ( content == null )
            return;

        out.render(content);
    }
}
