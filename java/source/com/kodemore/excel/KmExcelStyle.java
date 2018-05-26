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

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.kodemore.utility.Kmu;

/**
 * Export data as Excel.
 */
public class KmExcelStyle
{
    //##################################################
    //# variables
    //##################################################

    private KmExcelBook _book;
    private CellStyle   _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmExcelStyle(KmExcelBook book, CellStyle style)
    {
        _book = book;
        _inner = style;
    }

    //##################################################
    //# context
    //##################################################

    protected KmExcelBook getBook()
    {
        return _book;
    }

    protected CellStyle getInner()
    {
        return _inner;
    }

    //##################################################
    //# font
    //##################################################

    public void setFont(KmExcelFont e)
    {
        _inner.setFont(e.getInner());
    }

    public void setFont(String key)
    {
        KmExcelFont e = _book.getFont(key);
        setFont(e);
    }

    //##################################################
    //# wrap
    //##################################################

    private void setWrap(boolean e)
    {
        _inner.setWrapText(e);
    }

    public void setWrap()
    {
        setWrap(true);
    }

    //##################################################
    //# format
    //##################################################

    public void setFormat(String format)
    {
        short i = _book.getFormatIndexFor(format);
        _inner.setDataFormat(i);
    }

    public void setFormatText()
    {
        setFormat("text");
    }

    public void setFormatNumeric(int decimalPlaces)
    {
        String f = "#,###";

        if ( decimalPlaces > 0 )
            f += "." + Kmu.repeat('0', decimalPlaces);

        setFormat(f);
    }

    public void setFormatMoney()
    {
        String f = "$#,##0.00";
        setFormat(f);
    }

    //##################################################
    //# horizontal alignment
    //##################################################

    public void setAlignLeft()
    {
        _inner.setAlignment(CellStyle.ALIGN_LEFT);
    }

    public void setAlignCenter()
    {
        _inner.setAlignment(CellStyle.ALIGN_CENTER);
    }

    public void setAlignRight()
    {
        _inner.setAlignment(CellStyle.ALIGN_RIGHT);
    }

    //##################################################
    //# vertical alignment
    //##################################################

    public void setAlignTop()
    {
        _inner.setVerticalAlignment(CellStyle.VERTICAL_TOP);
    }

    public void setAlignMiddle()
    {
        _inner.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    }

    public void setAlignBottom()
    {
        _inner.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);
    }

    //##################################################
    //# background color
    //##################################################

    private void setBackgroundColor(IndexedColors e)
    {
        _inner.setFillForegroundColor(e.getIndex());
        _inner.setFillPattern(CellStyle.SOLID_FOREGROUND);
    }

    public void setBackgroundRed()
    {
        setBackgroundColor(IndexedColors.RED);
    }

    public void setBackgroundYellow()
    {
        setBackgroundColor(IndexedColors.YELLOW);
    }

    public void setBackgroundBlack()
    {
        setBackgroundColor(IndexedColors.BLACK);
    }

    public void setBackgroundGray25()
    {
        setBackgroundColor(IndexedColors.GREY_25_PERCENT);
    }

    public void setBackgroundGray50()
    {
        setBackgroundColor(IndexedColors.GREY_50_PERCENT);
    }

    public void setBackgroundGray80()
    {
        setBackgroundColor(IndexedColors.GREY_80_PERCENT);
    }

}
