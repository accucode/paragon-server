/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Export data as Excel.
 */
public class KmExcelSheet
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The default maximum width to use when resizing columns.
     * This can be overridden on a case-by-case basis.
     */
    private static final int DEFAULT_MAXIMUM_COLUMN_WIDTH = 50;

    //##################################################
    //# variables
    //##################################################

    private KmExcelBook _book;
    private Sheet       _inner;
    private int         _nextRowIndex;

    //##################################################
    //# constructor
    //##################################################

    public KmExcelSheet(KmExcelBook book, Sheet sheet)
    {
        _book = book;
        _inner = sheet;
        _nextRowIndex = 0;
    }

    //##################################################
    //# context
    //##################################################

    protected KmExcelBook getBook()
    {
        return _book;
    }

    protected Sheet getInner()
    {
        return _inner;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return getInner().getSheetName();
    }

    //##################################################
    //# rows
    //##################################################

    public KmExcelRow addRow()
    {
        Row row = _inner.createRow(_nextRowIndex);
        _nextRowIndex++;

        return new KmExcelRow(this, row);
    }

    public boolean hasRows()
    {
        return _inner.getPhysicalNumberOfRows() > 0;
    }

    /**
     * Return the index of the first row,
     * or -1 if there are no rows.
     */
    public int getFirstRowIndex()
    {
        return hasRows()
            ? _inner.getFirstRowNum()
            : -1;
    }

    /**
     * Return the index of the last row,
     * or -1 if there are no rows.
     */
    public int getLastRowIndex()
    {
        return hasRows()
            ? _inner.getLastRowNum()
            : -1;
    }

    /**
     * Get the row at the requested index.
     * Creates a new row if none exists.
     */
    public KmExcelRow getRow(int i)
    {
        Row row = _inner.getRow(i);
        if ( row == null )
            row = _inner.createRow(i);
        return new KmExcelRow(this, row);
    }

    //##################################################
    //# columns
    //##################################################

    public int getColumnCount()
    {
        int max = 0;
        int count;
        KmExcelRow row;

        int first = getFirstRowIndex();
        int last = getLastRowIndex();

        for ( int i = first; i <= last; i++ )
        {
            row = getRow(i);
            count = row.getLastCellIndex();
            if ( count > max )
                max = count;
        }

        return max;
    }

    //##################################################
    //# column width
    //##################################################

    public void setColumnWidth(int colIndex, int charWidth)
    {
        int width = charWidth * 256;
        _inner.setColumnWidth(colIndex, width);
    }

    //##################################################
    //# auto size columns
    //##################################################

    public void autoSizeColumns()
    {
        int maxCharWidth = DEFAULT_MAXIMUM_COLUMN_WIDTH;
        autoSizeColumns(maxCharWidth);
    }

    public void autoSizeColumns(Integer maxCharWidth)
    {
        int last = getColumnCount();

        for ( int i = 0; i <= last; i++ )
            autoSizeColumn(i, maxCharWidth);
    }

    public void autoSizeColumn(int colIndex)
    {
        int maxCharWidth = DEFAULT_MAXIMUM_COLUMN_WIDTH;
        autoSizeColumn(colIndex, maxCharWidth);
    }

    /**
     * Auto-size the column. The column with is set to a maximum
     * size that accomodates approximately maxChars.
     */
    public void autoSizeColumn(int colIndex, Integer maxChars)
    {
        _inner.autoSizeColumn(colIndex);

        if ( maxChars != null )
        {
            int width = _inner.getColumnWidth(colIndex);
            int maxWidth = maxChars * 256;
            if ( width > maxWidth )
                _inner.setColumnWidth(colIndex, maxWidth);
        }
    }

    //##################################################
    //# freeze
    //##################################################

    public void freeze(int rows, int columns)
    {
        _inner.createFreezePane(columns, rows);
    }

}
