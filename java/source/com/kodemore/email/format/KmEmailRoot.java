package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailRoot
    extends KmAbstractEmailContainer
{
    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderOpenOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderStyleOn(out, ROOT_STYLE_OUTER);
        out.close();

        out.openDiv();
        renderStyleOn(out, ROOT_STYLE_INNER);
        out.close();
    }

    @Override
    protected void renderCloseOn(KmHtmlBuilder out)
    {
        out.endDiv();
        out.endDiv();
    }
}
