package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailGap
    extends KmAbstractEmailStaticElement
{
    //##################################################
    //# format
    //##################################################

    @Override
    protected KmHtmlBuilder formatContent()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.openDiv();
        renderStyleOn(out, GAP_STYLE);
        out.close();
        out.endDiv();
        return out;
    }
}
