package com.app.convert;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class MyXmlLabelAdaptorZpl
    extends MyXmlLabelAdaptor
{
    //##################################################
    //# variables
    //##################################################

    private MyLabelJob      _job;
    private MyLabelSettings _settings;
    private KmStringBuilder _out;

    //##################################################
    //# public
    //##################################################

    @Override
    public byte[] format(MyLabelJob job, MyLabelSettings settings)
    {
        _job = job;
        _settings = settings;
        _out = new KmStringBuilder();

        render();

        return _out.toString().getBytes();
    }

    private void render()
    {
        beginJob();
        printQuantity();

        KmList<MyLabelElementIF> v = _job.getElements();
        for ( MyLabelElementIF e : v )
            render(e);

        endJob();
    }

    private void render(MyLabelElementIF e)
    {
        MyLabelElementType type = e.getLabelElementType();
        switch ( type )
        {
            case Text:
                renderText((MyLabelText)e);
                break;

            case Barcode:
                renderBarcode((MyLabelBarcode)e);
                break;
        }
    }

    private void renderText(MyLabelText e)
    {
        if ( !e.hasValue() )
            return;

        String o = formatOrientation(e.getOrientation());
        int h = toPrinter(e.getHeight());
        int w = (int)(h * 4.0 / 5.0);
        _out.printfln("^A0%s,%s,%s", o, h, w);

        int x = toPrinter(e.getX());
        int y = toPrinter(e.getY());
        _out.printfln("^FO%s,%s", x, y);

        _out.println("^FH\\");
        _out.printfln("^FD%s^FS", escapeField(e.getValue()));
    }

    private void renderBarcode(MyLabelBarcode e)
    {
        if ( !e.hasValue() )
            return;

        String printCheckDigit = formatYN(e.getPrintCheckDigit());
        String o = formatOrientation(e.getOrientation());
        int h = toPrinter(e.getHeight());

        String printText = null;
        String printTextAbove = null;
        MyLabelInterpretationLinePosition pos = e.getInterpretationLinePosition();
        switch ( pos )
        {
            case None:
                printText = "N";
                printTextAbove = "N";
                break;

            case Bottom:
                printText = "Y";
                printTextAbove = "N";
                break;

            case Top:
                printText = "Y";
                printTextAbove = "Y";
                break;
        }

        int x = toPrinter(e.getX());
        int y = toPrinter(e.getY());
        _out.printfln("^FO%s,%s", x, y);

        _out.println("^FH\\");

        MyLabelBarcodeType type = e.getType();
        switch ( type )
        {
            case UPC_A:
                _out
                    .printfln("^BU%s,%s,%s,%s,%s", o, h, printText, printTextAbove, printCheckDigit);
                break;

            case Code_39:
                _out
                    .printfln("^B3%s,%s,%s,%s,%s", o, printCheckDigit, h, printText, printTextAbove);
                break;

            case Standard_2_of_5:
                _out.printfln("^BJ%s,%s,%s,%s", o, h, printText, printTextAbove);
                break;
        }

        _out.printfln("^FD%s^FS", escapeField(e.getValue()));
    }

    private String formatYN(Boolean e)
    {
        if ( e == null )
            return "";

        return e
            ? "Y"
            : "N";
    }

    private String escapeField(String s)
    {
        StringBuilder out = new StringBuilder();

        for ( char c : s.toCharArray() )
            if ( c == '^' || c == '~' || c == '\\' )
            {
                out.append("\\");
                out.append(Kmu.formatHexString((byte)c));
            }
            else
                out.append(c);

        return out.toString();
    }

    private String formatOrientation(MyLabelOrientation e)
    {
        switch ( e )
        {
            case Normal:
                return "N";

            case Rotate90:
                return "R";

            case Rotate180:
                return "I";

            case Rotate270:
                return "B";
        }
        return null;
    }

    private void beginJob()
    {
        _out.println("^XA");
    }

    private void endJob()
    {
        _out.println("^XZ");
    }

    private void printQuantity()
    {
        int qty = _job.getQuantity();
        if ( qty > 1 )
            _out.printfln("^PQ%s", qty);
    }

    //##################################################
    //# support
    //##################################################

    /**
     * Convert from points to local printer coordinates
     */
    private int toPrinter(Double y)
    {
        return (int)(y / 72.0 * _settings.getDotsPerInch());
    }

}
