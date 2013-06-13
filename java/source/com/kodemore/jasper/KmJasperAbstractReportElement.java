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

import com.kodemore.jasper.field.KmJasperBooleanField;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public abstract class KmJasperAbstractReportElement
    extends KmJasperElement
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperStyle      _style;

    private String             _positionType;
    private String             _stretchType;
    private Boolean            _printRepeatedValues;

    private int                _x;
    private int                _y;
    private int                _width;
    private int                _height;

    private KmJasperColor      _color;
    private KmJasperColor      _fillColor;

    private KmJasperExpression _printWhen;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperAbstractReportElement(KmJasperReportBuilder e)
    {
        super(e);
        _width = 100;
    }

    //##################################################
    //# style
    //##################################################

    public KmJasperStyle getStyle()
    {
        return _style;
    }

    public void setStyle(KmJasperStyle e)
    {
        _style = e;
    }

    //##################################################
    //# position type
    //##################################################

    public String getPositionType()
    {
        return _positionType;
    }

    public void setPositionTypeFloat()
    {
        _positionType = "Float";
    }

    public void setPositionTypeTop()
    {
        _positionType = "FixRelativeToTop";
    }

    public void setPositionTypeBottom()
    {
        _positionType = "FixRelativeToBottom";
    }

    //##################################################
    //# stretch type
    //##################################################

    public String getStretchType()
    {
        return _stretchType;
    }

    public void setStretchTypeNone()
    {
        _stretchType = "NoStretch";
    }

    public void setStretchTypeTallest()
    {
        _stretchType = "RelativeToTallestObject";
    }

    public void setStretchTypeBand()
    {
        _stretchType = "RelativeToBandHeight";
    }

    //##################################################
    //# print repeated values
    //##################################################

    public Boolean getPrintRepeatedValues()
    {
        return _printRepeatedValues;
    }

    public void setPrintRepeatedValues(Boolean e)
    {
        _printRepeatedValues = e;
    }

    public void hideRepeatedValues()
    {
        setPrintRepeatedValues(false);
    }

    //##################################################
    //# position
    //##################################################

    public int getX()
    {
        return _x;
    }

    public void setX(int e)
    {
        _x = e;
    }

    public int getY()
    {
        return _y;
    }

    public void setY(int e)
    {
        _y = e;
    }

    public void setPosition(int x, int y)
    {
        setX(x);
        setY(y);
    }

    public void setPosition(KmJasperAbstractReportElement e)
    {
        setX(e.getX());
        setY(e.getY());
    }

    public void setShape(int x, int y, int w, int h)
    {
        setPosition(x, y);
        setSize(w, h);
    }

    public void setShape(KmJasperAbstractReportElement e)
    {
        setPosition(e);
        setSize(e);
    }

    public void insetBy(int i)
    {
        setX(getX() + i);
        setY(getY() + i);
        setWidth(getWidth() - 2 * i);
        setHeight(getHeight() - 2 * i);
    }

    //##################################################
    //# size
    //##################################################

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int e)
    {
        _width = e;
    }

    public int getHeight()
    {
        return _height;
    }

    public void setHeight(int e)
    {
        _height = e;
    }

    public boolean hasHeight()
    {
        return _height != 0;
    }

    public void setSize(int w, int h)
    {
        setWidth(w);
        setHeight(h);
    }

    public void setSize(KmJasperAbstractReportElement e)
    {
        setWidth(e.getWidth());
        setHeight(e.getHeight());
    }

    //##################################################
    //# color
    //##################################################

    public KmJasperColor getColor()
    {
        if ( _color == null )
            _color = new KmJasperColor();
        return _color;
    }

    public KmJasperColor getFillColor()
    {
        if ( _fillColor == null )
            _fillColor = new KmJasperColor();
        return _fillColor;
    }

    //##################################################
    //# print when
    //##################################################

    public KmJasperExpression getPrintWhen()
    {
        return _printWhen;
    }

    public void setPrintWhen(KmJasperExpression e)
    {
        _printWhen = e;
    }

    public void setPrintWhen(KmJasperBooleanField e)
    {
        setPrintWhen(e.getExpression());
    }

    public void setPrintEveryNthRow(int i)
    {
        String s;
        s = String.format("Boolean.valueOf(($V{REPORT_COUNT}.intValue()) %% %s == 0)", i);

        KmJasperExpression e;
        e = new KmJasperExpression();
        e.setType(KmJasperType.Boolean);
        e.setRawValue(s);
        setPrintWhen(e);
    }

    //##################################################
    //# compose
    //##################################################

    public void addReportElementTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement e;
        e = root.addElement("reportElement");
        e.addAttribute("style", getStyle());
        e.addAttribute("positionType", getPositionType());
        e.addAttribute("stretchType", getStretchType());
        e.addAttribute("isPrintRepeatedValues", getPrintRepeatedValues());
        e.addAttribute("x", getX());
        e.addAttribute("y", getY());
        e.addAttribute("width", getWidth());
        e.addAttribute("height", getHeight());
        e.addAttribute("forecolor", _color);
        e.addAttribute("backcolor", _fillColor);

        if ( _printWhen != null )
            _printWhen.addToWithoutClass(e, "printWhenExpression");
    }

}
