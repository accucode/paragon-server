package com.kodemore.wiki;

import com.kodemore.utility.Kmu;

/**
 * The index, row, and column are primarilyi used for
 * debugging and error reporting.
 */
public class KmWikiSource
    implements KmWikiConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private String  _text;
    private Integer _index;
    private Integer _rowIndex;
    private Integer _columnIndex;

    //##################################################
    //# accessing
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    public Integer getIndex()
    {
        return _index;
    }

    public void setIndex(Integer e)
    {
        _index = e;
    }

    public Integer getRowIndex()
    {
        return _rowIndex;
    }

    public void setRowIndex(Integer e)
    {
        _rowIndex = e;
    }

    public Integer getRow()
    {
        return getRowIndex() + 1;
    }

    public Integer getColumnIndex()
    {
        return _columnIndex;
    }

    public void setColumnIndex(Integer e)
    {
        _columnIndex = e;
    }

    public Integer getColumn()
    {
        return getColumnIndex() + 1;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String getLine()
    {
        char[] arr = _text.toCharArray();

        StringBuilder out = new StringBuilder();

        int i = _index - 1;
        int min = 0;
        while ( i >= min )
        {
            char c = arr[i];
            if ( c == LF )
                break;
            out.append(c);
            i--;
        }

        out.reverse();

        i = _index;
        int max = arr.length - 1;
        while ( i <= max )
        {
            char c = arr[i];
            if ( c == LF )
                break;
            out.append(c);
            i++;
        }

        return out.toString();
    }

    public String getLinePointer()
    {
        int n = getColumnIndex();
        return Kmu.repeat(SPACE, n) + "^";
    }

    public String getLineWithPointer()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append(getLine());
        out.append(LF);
        out.append(getLinePointer());
        out.append(LF);
        return out.toString();
    }
}
