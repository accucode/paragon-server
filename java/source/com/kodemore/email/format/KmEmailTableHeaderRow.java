package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailTableHeaderRow
    extends KmEmailTableRow
{
    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderOpenOn(KmHtmlBuilder out)
    {
        out.openTableRow();
        renderStyleOn(out, TABLE_HEADER_ROW_STYLE);
        out.close();
    }
}
