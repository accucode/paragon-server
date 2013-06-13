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

import java.util.ArrayList;
import java.util.List;

import com.kodemore.jasper.field.KmJasperField;
import com.kodemore.jasper.field.KmJasperVariable;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperBand
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperReportBuilder       _builder;
    private String                      _name;

    // attributes
    private int                         _height;
    private String                      _splitType;

    // elements
    private List<KmJasperBandElementIF> _children;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperBand(KmJasperReportBuilder builder, String name)
    {
        _builder = builder;
        _name = name;
        _children = new ArrayList<KmJasperBandElementIF>();
        setSplitTypePrevent();
    }

    //##################################################
    //# name 
    //##################################################

    public String getName()
    {
        return _name;
    }

    public KmJasperReportBuilder getBuilder()
    {
        return _builder;
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
    //# width
    //##################################################

    public int getWidth()
    {
        return _builder.getPage().getClientWidth();
    }

    //##################################################
    //# split type
    //##################################################

    public String getSplitType()
    {
        return _splitType;
    }

    public void setSplitType(String e)
    {
        _splitType = e;
    }

    public void setSplitTypeStretch()
    {
        setSplitType("Stretch");
    }

    public void setSplitTypePrevent()
    {
        setSplitType("Prevent");
    }

    public void setSplitTypeImmediate()
    {
        setSplitType("Immediate");
    }

    //##################################################
    //# add text
    //##################################################

    public KmJasperText addText()
    {
        return add(new KmJasperText(getBuilder()));
    }

    public KmJasperText addText(KmJasperField e)
    {
        return addText(e.getExpression());
    }

    public KmJasperText addText(KmJasperVariable f)
    {
        return addText(f.getExpression());
    }

    public KmJasperText addText(KmJasperExpression e)
    {
        KmJasperText t;
        t = addText();
        t.setExpression(e);
        return t;
    }

    public KmJasperText addText(String s)
    {
        KmJasperText e;
        e = addText();
        e.setValue(s);
        return e;
    }

    //##################################################
    //# add shapes
    //##################################################

    public KmJasperRectangle addRectangle()
    {
        return add(new KmJasperRectangle(getBuilder()));
    }

    public KmJasperRectangle addRectangle(int x, int y, int w, int h)
    {
        KmJasperRectangle e;
        e = addRectangle();
        e.setShape(x, y, w, h);
        return e;
    }

    public KmJasperRectangle addBorder()
    {
        return addRectangle(0, 0, getWidth(), getHeight());
    }

    public KmJasperLine addTopBorder()
    {
        KmJasperLine line;
        line = addLine(0, 0, getWidth(), 0);
        line.setPositionTypeTop();
        return line;
    }

    public KmJasperLine addBottomBorder()
    {
        KmJasperLine line;
        line = addLine(0, getHeight() - 1, getWidth(), 0);
        line.setPositionTypeBottom();
        return line;
    }

    public KmJasperLine addLine()
    {
        return add(new KmJasperLine(getBuilder()));
    }

    public KmJasperLine addLine(int x, int y, int w, int h)
    {
        KmJasperLine e;
        e = addLine();
        e.setShape(x, y, w, h);
        return e;
    }

    public KmJasperEllipse addEllipse()
    {
        return add(new KmJasperEllipse(getBuilder()));
    }

    public KmJasperRectangle addEvenRowShading()
    {
        KmJasperRectangle rect;
        rect = addBorder();
        rect.setPrintEveryNthRow(2);
        rect.setStretchTypeBand();
        rect.getColor().setVeryLightGray();
        rect.getFillColor().setVeryLightGray();
        return rect;
    }

    //##################################################
    //# support
    //##################################################

    private <E extends KmJasperBandElementIF> E add(E e)
    {
        _children.add(e);
        return e;
    }

    //##################################################
    //# compose
    //##################################################

    public KmJasperColumnLayout createColumnLayout()
    {
        KmJasperColumnLayout e;
        e = new KmJasperColumnLayout(this);
        return e;
    }

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement wrapper;
        wrapper = root.addElement(getName());

        KmJasperXmlElement band;
        band = wrapper.addElement("band");
        band.addAttribute("height", _height);
        band.addAttribute("splitType", _splitType);

        band.addAll(_children);
    }

}
