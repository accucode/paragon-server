/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper;

import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperPage
{
    //##################################################
    //# variables
    //##################################################

    private int     _width;
    private int     _height;
    private String  _orientation;

    private int     _left;
    private int     _right;
    private int     _top;
    private int     _bottom;

    private Integer _columnWidth;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperPage()
    {
        setSizeLetter();
        setMarginInches(.5);
    }

    //##################################################
    //# width
    //##################################################

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int e)
    {
        _width = e;
    }

    public void setWidthInches(double e)
    {
        setWidth(KmJasperUtility.inches(e));
    }

    //##################################################
    //# height
    //##################################################

    public int getHeight()
    {
        return _height;
    }

    public void setHeight(int e)
    {
        _height = e;
    }

    public void setHeightInches(double e)
    {
        setHeight(KmJasperUtility.inches(e));
    }

    //##################################################
    //# size (convenience)
    //##################################################

    public void setSizeLetter()
    {
        setWidthInches(8.5);
        setHeightInches(11);
        setPortrait();
    }

    public void setSizeLetterLandscape()
    {
        setWidthInches(11);
        setHeightInches(8.5);
        setLandscape();
    }

    //##################################################
    //# client dimensions
    //##################################################

    public int getClientWidth()
    {
        return getWidth() - getLeft() - getRight();
    }

    public int getClientHeight()
    {
        return getHeight() - getTop() - getBottom();
    }

    //##################################################
    //# orientation
    //##################################################

    public String getOrientation()
    {
        return _orientation;
    }

    public void setOrientation(String e)
    {
        _orientation = e;
    }

    public void setLandscape()
    {
        setOrientation("Landscape");
    }

    public void setPortrait()
    {
        setOrientation("Portrait");
    }

    //##################################################
    //# left 
    //##################################################

    public int getLeft()
    {
        return _left;
    }

    public void setLeft(int e)
    {
        _left = e;
    }

    public void setLeftInches(double e)
    {
        setLeft(KmJasperUtility.inches(e));
    }

    //##################################################
    //# right 
    //##################################################

    public int getRight()
    {
        return _right;
    }

    public void setRight(int e)
    {
        _right = e;
    }

    public void setRightInches(double e)
    {
        setRight(KmJasperUtility.inches(e));
    }

    //##################################################
    //# top 
    //##################################################

    public int getTop()
    {
        return _top;
    }

    public void setTop(int e)
    {
        _top = e;
    }

    public void setTopInches(double e)
    {
        setTop(KmJasperUtility.inches(e));
    }

    //##################################################
    //# bottom
    //##################################################

    public int getBottom()
    {
        return _bottom;
    }

    public void setBottom(int e)
    {
        _bottom = e;
    }

    public void setBottomInches(double e)
    {
        setBottom(KmJasperUtility.inches(e));
    }

    //##################################################
    //# margins
    //##################################################

    public void setMarginInches(double e)
    {
        setLeftInches(e);
        setRightInches(e);
        setTopInches(e);
        setBottomInches(e);
    }

    //##################################################
    //# column width
    //##################################################

    public int getColumnWidth()
    {
        return _columnWidth;
    }

    public void setColumnWidth(int e)
    {
        _columnWidth = e;
    }

    public void setColumnWidthAuto()
    {
        setColumnWidth(getClientWidth());
    }

    public int getEffectiveColumnWidth()
    {
        if ( _columnWidth != null )
            return _columnWidth;

        return getClientWidth();
    }

    //##################################################
    //# compose
    //##################################################

    public void addAttributesTo(KmJasperXmlElement report)
    {
        report.addAttribute("pageWidth", getWidth());
        report.addAttribute("pageHeight", getHeight());
        report.addAttribute("orientation", getOrientation());

        report.addAttribute("leftMargin", getLeft());
        report.addAttribute("rightMargin", getRight());
        report.addAttribute("topMargin", getTop());
        report.addAttribute("bottomMargin", getBottom());

        report.addAttribute("columnWidth", getEffectiveColumnWidth());
    }

}
