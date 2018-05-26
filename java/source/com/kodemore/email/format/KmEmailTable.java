package com.kodemore.email.format;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;

public class KmEmailTable
    extends KmAbstractEmailElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmEmailTableRow> _rows;

    //##################################################
    //# constructor
    //##################################################

    public KmEmailTable()
    {
        _rows = new KmList<>();
    }

    //##################################################
    //# children
    //##################################################

    public KmList<KmEmailTableRow> getRows()
    {
        return _rows;
    }

    public void addRow(KmEmailTableRow e)
    {
        getRows().add(e);
    }

    public KmEmailTableRow addRow()
    {
        KmEmailTableRow e;
        e = new KmEmailTableRow();
        addRow(e);
        return e;
    }

    public KmEmailTableRow addHeaderRow()
    {
        KmEmailTableHeaderRow e;
        e = new KmEmailTableHeaderRow();
        addRow(e);
        return e;
    }

    //##################################################
    //# format
    //##################################################

    protected void renderOpenOn(KmHtmlBuilder out)
    {
        out.openTable();
        out.close();
    }

    protected void renderCloseOn(KmHtmlBuilder out)
    {
        out.endTable();
    }

    //##################################################
    //# render on
    //##################################################

    @Override
    public void renderOn(KmHtmlBuilder out)
    {
        renderOpenOn(out);

        for ( KmEmailTableRow row : getRows() )
            row.renderOn(out);

        renderCloseOn(out);
    }
}
