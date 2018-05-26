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

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * Export data as Excel.
 */
public class KmExcelFont
{
    //##################################################
    //# variables
    //##################################################

    private Font _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmExcelFont(Font font)
    {
        _inner = font;
    }

    //##################################################
    //# context
    //##################################################

    protected Font getInner()
    {
        return _inner;
    }

    //##################################################
    //# family
    //##################################################

    public void setFamily(String e)
    {
        _inner.setFontName(e);
    }

    public void setFamilyArial()
    {
        setFamily("Arial");
    }

    //##################################################
    //# bold
    //##################################################

    public void setBold(boolean e)
    {
        _inner.setBold(e);
    }

    public void setBold()
    {
        setBold(true);
    }

    //##################################################
    //# italic
    //##################################################

    public void setItalic(boolean e)
    {
        _inner.setItalic(e);
    }

    public void setItalic()
    {
        setItalic(true);
    }

    //##################################################
    //# strikeout
    //##################################################

    public void setStrikeout(boolean e)
    {
        _inner.setStrikeout(e);
    }

    public void setStrikeout()
    {
        setStrikeout(true);
    }

    //##################################################
    //# height
    //##################################################

    public void setPointHeight(int e)
    {
        _inner.setFontHeightInPoints((short)e);
    }

    //##################################################
    //# colors
    //##################################################

    private void setColor(IndexedColors c)
    {
        _inner.setColor(c.getIndex());
    }

    public void setColorBlack()
    {
        setColor(IndexedColors.BLACK);
    }

    public void setColorRed()
    {
        setColor(IndexedColors.RED);
    }

    public void setColorBlue()
    {
        setColor(IndexedColors.BLUE);
    }

    public void setColorGreen()
    {
        setColor(IndexedColors.GREEN);
    }

}
