package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailText
    extends KmAbstractEmailStaticElement
{
    //##################################################
    //# variables
    //##################################################

    private String _text;

    //##################################################
    //# constructor
    //##################################################

    public KmEmailText(String e)
    {
        _text = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getText()
    {
        return _text;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    protected KmHtmlBuilder formatContent()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.print(getText());
        return out;
    }
}
