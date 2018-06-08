package com.kodemore.google;

import java.util.List;
import java.util.Objects;

import com.google.gdata.data.spreadsheet.CellEntry;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I represent a single cell within a spreadsheet document.
 * I wrap the CellEntry.
 * I am immutable.
 */
public class KmSpreadsheetCell
    implements Comparable<KmSpreadsheetCell>
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmSpreadsheetCell wrap(CellEntry e)
    {
        return new KmSpreadsheetCell(e);
    }

    public static KmList<KmSpreadsheetCell> wrap(List<CellEntry> v)
    {
        return KmList.wrap(v).collect(x -> wrap(x));
    }

    //##################################################
    //# variables
    //##################################################

    private CellEntry _inner;

    //##################################################
    //# constructor
    //##################################################

    private KmSpreadsheetCell(CellEntry e)
    {
        _inner = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getTitle()
    {
        return _inner.getTitle().getPlainText();
    }

    /**
     * Return the row position, 1..maxRows.
     */
    public int getRowPosition()
    {
        return _inner.getCell().getRow();
    }

    /**
     * Return the row index, 0..maxRows-1.
     */
    public int getRowIndex()
    {
        return getRowPosition() - 1;
    }

    /**
     * Return the column position, 1..maxColumns.
     */
    public int getColumnPosition()
    {
        return _inner.getCell().getCol();
    }

    /**
     * Return the column index, 0..maxColumns-1.
     */
    public int getColumnIndex()
    {
        return getColumnPosition() - 1;
    }

    //==================================================
    //= value
    //==================================================

    /**
     * Return the display value as a string.
     * Values are trimmed.
     * This should never return a null value, though it may return an empty string.
     */
    public String getValue()
    {
        return _inner.getPlainTextContent().trim();
    }

    /**
     * Attempt to convert the value to a double.
     * Return null if the value cannot be converted.
     */
    public Double getDoubleValue()
    {
        String s;
        s = getValue();
        s = s.trim();
        s = Kmu.removePrefix(s, "$");
        s = Kmu.stripCharacters(s, ',');
        return Kmu.parseDouble(s);
    }

    /**
     * Attempt to convert the value to a Integer.
     * Return null if the value cannot be converted.
     */
    public Integer getIntegerValue()
    {
        String s;
        s = getValue();
        s = s.trim();
        s = Kmu.removePrefix(s, "$");
        s = Kmu.stripCharacters(s, ',');

        return Kmu.parseInteger(s);
    }

    //##################################################
    //# equals
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof KmSpreadsheetCell) )
            return false;

        KmSpreadsheetCell e = (KmSpreadsheetCell)o;

        return Objects.equals(getRowPosition(), e.getRowPosition())
            && Objects.equals(getColumnPosition(), e.getColumnPosition());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getRowPosition(), getColumnPosition());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public int compareTo(KmSpreadsheetCell e)
    {
        int a = getRowPosition();
        int b = e.getRowPosition();

        if ( a != b )
            return a - b;

        a = getColumnPosition();
        b = e.getColumnPosition();

        return a - b;
    }
}
