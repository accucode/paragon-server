package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailLiteral
    extends KmAbstractEmailStaticElement
{
    //##################################################
    //# variables
    //##################################################

    private KmHtmlBuilder _content;

    //##################################################
    //# accessing
    //##################################################

    public KmHtmlBuilder getContent()
    {
        return _content;
    }

    public void setContent(KmHtmlBuilder e)
    {
        _content = e;
    }

    //##################################################
    //# content
    //##################################################

    @Override
    protected KmHtmlBuilder formatContent()
    {
        return getContent();
    }
}
