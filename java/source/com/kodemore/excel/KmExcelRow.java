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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Export data as Excel.
 */
public class KmExcelRow
{
    //##################################################
    //# variables
    //##################################################

    private KmExcelSheet _sheet;
    private Row          _row;
    private int          _nextCellIndex;

    //##################################################
    //# constructor
    //##################################################

    public KmExcelRow(KmExcelSheet sheet, Row row)
    {
        _sheet = sheet;
        _row = row;
        _nextCellIndex = 0;
    }

    //##################################################
    //# context
    //##################################################

    public KmExcelSheet getSheet()
    {
        return _sheet;
    }

    public KmExcelBook getBook()
    {
        return getSheet().getBook();
    }

    protected Row getInner()
    {
        return _row;
    }

    //##################################################
    //# cells
    //##################################################

    public KmExcelCell addCell()
    {
        return getCell(_nextCellIndex++);
    }

    public KmExcelCell getCell(int i)
    {
        Cell cell = _row.getCell(i);

        if ( cell == null )
            cell = _row.createCell(i);

        return new KmExcelCell(this, cell);
    }

    /**
     * Return the 0-based index of the first logical cell,
     * or -1 if no cells are defined.
     */
    public int getFirstCellIndex()
    {
        return _row.getFirstCellNum();
    }

    /**
     * Return the 0-based index of the last logical cell,
     * or -1 if no cells are defined.
     */
    public int getLastCellIndex()
    {
        return _row.getLastCellNum();
    }
}
