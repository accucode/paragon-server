package com.kodemore.email.format;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;

public class KmEmailTableRow
    extends KmAbstractEmailElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmEmailTableCell> _cells;

    //##################################################
    //# constructor
    //##################################################

    public KmEmailTableRow()
    {
        _cells = new KmList<>();
    }

    //##################################################
    //# children
    //##################################################

    public KmList<KmEmailTableCell> getCells()
    {
        return _cells;
    }

    public void addCell(KmEmailTableCell e)
    {
        getCells().add(e);
    }

    public KmEmailTableCell addCell()
    {
        KmEmailTableCell e;
        e = new KmEmailTableCell();
        addCell(e);
        return e;
    }

    public KmEmailTableCell addCell(KmHtmlBuilder content)
    {
        KmEmailTableCell e;
        e = new KmEmailTableCell();
        e.setContent(content);
        addCell(e);
        return e;
    }

    public KmEmailTableCell addCell(String text)
    {
        KmEmailTableCell e;
        e = new KmEmailTableCell();
        e.setContent(text);
        addCell(e);
        return e;
    }

    //##################################################
    //# format
    //##################################################

    protected void renderOpenOn(KmHtmlBuilder out)
    {
        out.openTableRow();
        out.close();
    }

    protected void renderCloseOn(KmHtmlBuilder out)
    {
        out.endTableRow();
    }

    //##################################################
    //# render on
    //##################################################

    @Override
    public void renderOn(KmHtmlBuilder out)
    {
        renderOpenOn(out);

        for ( KmEmailTableCell cell : getCells() )
            cell.renderOn(out);

        renderCloseOn(out);
    }
}
