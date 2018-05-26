package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

public class KmEmailSection
    extends KmAbstractEmailContainer
{
    //##################################################
    //# constuctor
    //##################################################

    public KmEmailSection(String title, String subtitle)
    {
        super();

        boolean hasTitle = Kmu.hasValue(title);
        boolean hasSubTitle = Kmu.hasValue(subtitle);

        addSpacedDivider();

        if ( hasTitle )
            addHeader(title);

        if ( hasSubTitle )
            addText(subtitle);

        if ( hasTitle || hasSubTitle )
            addGap();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderOpenOn(KmHtmlBuilder out)
    {
        // none
    }

    @Override
    protected void renderCloseOn(KmHtmlBuilder out)
    {
        // none
    }
}
