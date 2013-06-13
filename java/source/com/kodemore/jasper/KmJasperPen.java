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

public class KmJasperPen
    implements KmJasperElementIF

{
    //##################################################
    //# variables
    //##################################################

    private String        _name;
    private Double        _width;
    private String        _style;
    private KmJasperColor _color;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperPen()
    {
        this("pen");
    }

    public KmJasperPen(String name)
    {
        _name = name;
        setWidthThin();
        setStyleSolid();
        setColor();
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    //##################################################
    //# width
    //##################################################

    public Double getWidth()
    {
        return _width;
    }

    public void setWidth(Double e)
    {
        _width = e;
    }

    public void setWidthThin()
    {
        _width = .00001;
    }

    //##################################################
    //# style
    //##################################################

    public String getStyle()
    {
        return _style;
    }

    private void setStyle(String e)
    {
        _style = e;
    }

    public void setStyleSolid()
    {
        setStyle("Solid");
    }

    public void setStyleDashed()
    {
        setStyle("Dashed");
    }

    public void setStyleDotted()
    {
        setStyle("Dotted");
    }

    public void setStyleDouble()
    {
        setStyle("Double");
    }

    //##################################################
    //# color
    //##################################################

    public KmJasperColor getColor()
    {
        return _color;
    }

    public void setColor(KmJasperColor e)
    {
        _color = e;
    }

    public KmJasperColor setColor()
    {
        _color = new KmJasperColor();
        _color.setBlack();
        return _color;
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement pen;
        pen = root.addElement(getName());
        pen.addAttribute("lineWidth", getWidth());
        pen.addAttribute("lineStyle", getStyle());
        pen.addAttribute("lineColor", getColor());
    }

}
