/*
  Copyright (c) 2005-2011 www.kodemore.com

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
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalStyle;

/**
 * I am used to wrap a simple table around content.  I render
 * a table with a single row (tr), and a single cell (td).
 * My children are rendered inside the cell.
 * 
 * The css and style are applied to the outer table.
 * 
 * Mostly, we avoid the use of tables as a primary layout tool.
 * However, some layouts are still only reliably possible with 
 * tables.  
 */
public class ScTableWrapper
    extends ScContainerElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalCss   _cellCss;
    private ScLocalStyle _cellStyle;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _cellCss = new ScLocalCss();
        _cellStyle = new ScLocalStyle();
    }

    //##################################################
    //# cell 
    //##################################################

    public String getCellCss()
    {
        return _cellCss.getValue();
    }

    public void setCellCss(String e)
    {
        _cellCss.setValue(e);
    }

    public KmCssDefaultBuilder cellCss()
    {
        return _cellCss.toDefaultBuilder();
    }

    public String formatCellCss()
    {
        return getCellCss();
    }

    //##################################################
    //# style
    //##################################################

    public String getCellStyle()
    {
        return _cellStyle.getValue();
    }

    public void setCellStyle(String e)
    {
        _cellStyle.setValue(e);
    }

    public ScLocalStyle cellStyle()
    {
        return _cellStyle;
    }

    public String formatCellStyle()
    {
        return getCellStyle();
    }

    //##################################################
    //# convenience
    //##################################################

    public void noSpace()
    {
        css().noSpace();
        cellCss().noSpace();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("table");
        renderAttributesOn(out);
        out.close();

        out.begin("tr");

        out.open("td");
        out.printAttribute("class", formatCellCss());
        out.printAttribute("style", formatCellStyle());
        out.close();

        renderChildrenOn(out);

        out.end("td");
        out.end("tr");

        out.end("table");
    }
}
