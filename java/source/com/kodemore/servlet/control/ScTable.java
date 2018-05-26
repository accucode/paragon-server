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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

public class ScTable
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private KmList<ScTableRow> _rows;

    private ScLocalCss   _defaultCellCss;
    private ScLocalStyle _defaultCellStyle;

    //##################################################
    //# constructor
    //##################################################

    public ScTable()
    {
        _rows = new KmList<>();

        _defaultCellCss = new ScLocalCss();
        _defaultCellStyle = new ScLocalStyle();
    }

    //##################################################
    //# cell css
    //##################################################

    public String getDefaultCellCss()
    {
        return _defaultCellCss.getValue();
    }

    public void setDefaultCellCss(String e)
    {
        _defaultCellCss.setValue(e);
    }

    public KmCssDefaultBuilder defaultCellCss()
    {
        return _defaultCellCss.toDefaultBuilder();
    }

    //##################################################
    //# cell style
    //##################################################

    public String getDefaultCellStyle()
    {
        return _defaultCellStyle.getValue();
    }

    public void setDefaultCellStyle(String e)
    {
        _defaultCellStyle.setValue(e);
    }

    public ScLocalStyle defaultCellStyle()
    {
        return _defaultCellStyle;
    }

    //##################################################
    //# rows
    //##################################################

    public KmList<ScTableRow> getRows()
    {
        return _rows;
    }

    public int getRowCount()
    {
        return _rows.size();
    }

    public ScTableRow addRow()
    {
        ScTableRow e;
        e = new ScTableRow();
        e.setParent(this);
        _rows.add(e);
        return e;
    }

    public ScTableRow getRow(int i)
    {
        return getRows().getAtSafe(i);
    }

    public ScTableCell getCell(int r, int c)
    {
        ScTableRow row = getRow(r);
        if ( row == null )
            return null;

        return row.getCell(c);
    }

    public int getColumnCount()
    {
        int n = 0;
        for ( ScTableRow row : getRows() )
            n = Math.max(n, row.getColumnCount());
        return n;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("table");
        renderAttributesOn(out);
        out.close();

        for ( ScTableRow row : _rows )
            row.renderOn(out);

        out.end("table");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public final KmList<ScControl> getChildren()
    {
        return getRows().collect(e -> e.asControl());
    }
}
