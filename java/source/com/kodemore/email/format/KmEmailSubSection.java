package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

public class KmEmailSubSection
    extends KmAbstractEmailContainer
{
    //##################################################
    //# constuctor
    //##################################################

    public KmEmailSubSection(String title, String subtitle)
    {
        super();

        boolean hasTitle = Kmu.hasValue(title);
        boolean hasSubtitle = Kmu.hasValue(subtitle);

        if ( hasTitle )
            addSubHeader(title);

        if ( hasSubtitle )
            addText(subtitle);

        if ( hasTitle || hasSubtitle )
            addGapSmall();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderOpenOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderStyleOn(out, SUB_SECTION_STYLE);
        out.close();
    }

    @Override
    protected void renderCloseOn(KmHtmlBuilder out)
    {
        out.endDiv();

        new KmEmailSmallGap().renderOn(out);
    }
}
