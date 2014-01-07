/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;

public class ScTableCell
    extends ScContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalInteger _columnSpan;
    private ScLocalInteger _rowSpan;

    private ScLocalString  _horizontalAlign;
    private ScLocalString  _verticalAlign;

    private ScLocalString  _width;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _columnSpan = new ScLocalInteger();
        _rowSpan = new ScLocalInteger();
        _horizontalAlign = new ScLocalString();
        _verticalAlign = new ScLocalString();
        _width = new ScLocalString();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderSimpleElementOn(out, "td");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("colspan", _columnSpan.getValue());
        out.printAttribute("rowspan", _rowSpan.getValue());
        out.printAttribute("align", _horizontalAlign.getValue());
        out.printAttribute("valign", _verticalAlign.getValue());
        out.printAttribute("width", _width.getValue());
    }

    //##################################################
    //# horizontal align
    //##################################################

    public String getHorizontalAlign()
    {
        return _horizontalAlign.getValue();
    }

    public void setHorizontalAlign(String e)
    {
        _horizontalAlign.setValue(e);
    }

    public void alignLeft()
    {
        setHorizontalAlign("left");
    }

    public void alignRight()
    {
        setHorizontalAlign("right");
    }

    public void alignCenter()
    {
        setHorizontalAlign("center");
    }

    //##################################################
    //# vertical align
    //##################################################

    public String getVerticalAlign()
    {
        return _verticalAlign.getValue();
    }

    public void setVerticalAlign(String e)
    {
        _verticalAlign.setValue(e);
    }

    public void alignTop()
    {
        setVerticalAlign("top");
    }

    public void alignBottom()
    {
        setVerticalAlign("bottom");
    }

    public void alignMiddle()
    {
        setVerticalAlign("middle");
    }

    //##################################################
    //# width
    //##################################################

    public void setWidth(int e)
    {
        _width.setValue(e + "");
    }

    public void setWidthPercent(int e)
    {
        _width.setValue(e + "px");
    }

    //##################################################
    //# column span
    //##################################################

    public void setColumnSpan(int e)
    {
        _columnSpan.setValue(e);
    }

    public Integer getColumnSpan()
    {
        return _columnSpan.getValue();
    }

    //##################################################
    //# row span
    //##################################################

    public void setRowSpan(int e)
    {
        _rowSpan.setValue(e);
    }

    public Integer getRowSpan()
    {
        return _rowSpan.getValue();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public ScTable getTable()
    {
        return getRow().getTable();
    }

    public ScTableRow getRow()
    {
        return (ScTableRow)getParent();
    }

    public int getColumnCount()
    {
        Integer i = getColumnSpan();
        if ( i == null )
            return 1;

        return i;
    }

}
