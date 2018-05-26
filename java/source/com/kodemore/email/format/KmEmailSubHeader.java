package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailSubHeader
    extends KmEmailText
{
    //##################################################
    //# constructor
    //##################################################

    public KmEmailSubHeader(String e)
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
        renderStyleOn(out, SUB_HEADER_STYLE);
        out.close();
        out.print(getText());
        out.endDiv();
        return out;
    }
}
