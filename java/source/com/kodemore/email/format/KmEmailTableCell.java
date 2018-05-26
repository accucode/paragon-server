package com.kodemore.email.format;

import com.kodemore.html.KmHtmlBuilder;

public class KmEmailTableCell
    extends KmAbstractEmailElement
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

    public void setContent(KmHtmlBuilder content)
    {
        _content = content;
    }

    public void setContent(String text)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.print(text);
        setContent(out);
    }

    //##################################################
    //# format
    //##################################################

    protected void renderOpenOn(KmHtmlBuilder out)
    {
        out.openTableData();
        renderStyleOn(out, TABLE_CELL_STYLE);
        out.close();
    }

    protected void renderCloseOn(KmHtmlBuilder out)
    {
        out.endTableData();
    }

    //##################################################
    //# render on
    //##################################################

    @Override
    public void renderOn(KmHtmlBuilder out)
    {
        renderOpenOn(out);

        KmHtmlBuilder content = getContent();
        if ( content != null )
            out.render(content);

        renderCloseOn(out);
    }
}
