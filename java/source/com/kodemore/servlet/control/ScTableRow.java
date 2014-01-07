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

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalString;

public class ScTableRow
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ScTableCell> _cells;
    private ScLocalString       _horizontalAlign;
    private ScLocalString       _verticalAlign;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _cells = new KmList<ScTableCell>();
        _horizontalAlign = new ScLocalString();
        _verticalAlign = new ScLocalString();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScTable getTable()
    {
        return (ScTable)getParent();
    }

    public KmList<ScTableCell> getCells()
    {
        return _cells;
    }

    public ScTableCell addCell()
    {
        String css = getTable().getDefaultCellCss();
        String style = getTable().getDefaultCellStyle();

        ScTableCell e;
        e = new ScTableCell();
        e.setParent(this);
        e.setCss(css);
        e.setStyle(style);
        _cells.add(e);

        return e;
    }

    /**
     * Add a cell, setting the column span to the number
     * of remaining columns in the row.
     * @return
     */
    public ScTableCell addFullCell()
    {
        int span = getTable().getColumnCount() - getColumnCount();
        ScTableCell e = addCell();
        if ( span > 1 )
            e.setColumnSpan(span);
        return e;
    }

    public ScTableCell getCell(int i)
    {
        return getCells().getAtSafe(i);
    }

    public int getColumnCount()
    {
        int n = 0;
        for ( ScTableCell cell : getCells() )
            n += cell.getColumnCount();
        return n;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("tr");
        renderAttributesOn(out);
        out.close();

        for ( ScTableCell e : _cells )
            e.renderOn(out);

        out.end("tr");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("align", _horizontalAlign.getValue());
        out.printAttribute("valign", _verticalAlign.getValue());
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public Iterator<ScControl> getComponents()
    {
        KmCompositeIterator<ScControl> i;
        i = new KmCompositeIterator<ScControl>();

        i.addAll(super.getComponents());
        i.addAll(getCells());

        return i;
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

}
