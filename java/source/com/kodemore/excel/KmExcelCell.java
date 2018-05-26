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
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Workbook;

import com.kodemore.time.KmDate;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.Kmu;

/**
 * Export data as Excel.
 */
public class KmExcelCell
{
    //##################################################
    //# variables
    //##################################################

    private KmExcelRow _row;
    private Cell       _cell;

    //##################################################
    //# constructor
    //##################################################

    public KmExcelCell(KmExcelRow row, Cell cell)
    {
        _row = row;
        _cell = cell;
    }

    //##################################################
    //# context
    //##################################################

    protected KmExcelRow getRow()
    {
        return _row;
    }

    protected KmExcelBook getBook()
    {
        return getRow().getSheet().getBook();
    }

    protected Cell getInner()
    {
        return _cell;
    }

    //##################################################
    //# value
    //##################################################

    public void setValue(String value)
    {
        if ( value == null )
        {
            clearValue();
            return;
        }

        _cell.setCellValue(value);
    }

    public void setValue(Double value)
    {
        if ( value == null )
        {
            clearValue();
            return;
        }

        _cell.setCellValue(value.doubleValue());
    }

    public void setValue(Integer value)
    {
        if ( value == null )
        {
            clearValue();
            return;
        }

        _cell.setCellValue(value.doubleValue());
    }

    public void setValue(KmDate value)
    {
        if ( value == null )
        {
            clearValue();
            return;
        }

        _cell.setCellValue(value.toJavaDate());
    }

    public void setValue(KmMoney value)
    {
        if ( value == null )
        {
            clearValue();
            return;
        }

        _cell.setCellValue(value.toDouble());
    }

    public void setHyperlink(String url)
    {
        try (Workbook book = getBook().getInner())
        {
            Hyperlink link;
            link = book.getCreationHelper().createHyperlink(Hyperlink.LINK_URL);
            link.setAddress(url);

            _cell.setHyperlink(link);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void clearValue()
    {
        _cell.setCellValue((String)null);
    }

    //##################################################
    //# style
    //##################################################

    public void setStyle(KmExcelStyle e)
    {
        _cell.setCellStyle(e.getInner());
    }

    public void setStyle(String key)
    {
        KmExcelStyle style = getBook().getStyle(key);
        setStyle(style);
    }

}
