package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailHeader
    extends KmEmailText
{
    //##################################################
    //# constructor
    //##################################################

    public KmEmailHeader(String e)
    {
        super(e);
    }

    //##################################################
    //# format
    //##################################################

    @Override
    protected KmHtmlBuilder formatContent()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.openDiv();
        renderStyleOn(out, HEADER_STYLE);
        out.close();
        out.print(getText());
        out.endDiv();
        return out;
    }
}
