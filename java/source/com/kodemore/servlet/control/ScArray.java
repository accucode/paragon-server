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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalStyle;

/**
 * I am a fancy <table> - my outermost html element is literally
 * a <table> tag.  
 * 
 * Clients use me to easily organize a collection of controls into 
 * rows and/or columns.  By default, my children are all displayed
 * in a single vertical column; however the layout is easily changed
 * by calling either setColumnCount or setRowCount.
 * 
 * A gap may be displayed between each of the rows and columns.
 * See DEFAULT_GAP.  Gaps are displayed using extra rows and cell
 * to avoid any layout interference with the actual child controls.
 * The extra rows and columns are NOT included if the gap is zero.
 */
public class ScArray
    extends ScContainerElement
{
    //##################################################
    //# constants
    //##################################################

    private static final int DEFAULT_GAP = 10;

    //##################################################
    //# variables
    //##################################################

    private ScLocalInteger   _rowCount;
    private ScLocalInteger   _columnCount;

    /**
     * The cell class and style are applied to the TDs of
     * those cells that contain child controls, even if the
     * cell is "empty".  However, the cell class/style is
     * not applied to the gaps.  
     */
    private ScLocalCss       _cellCss;

    private ScLocalStyle     _cellStyle;

    /**
     * The gap to display between all columns.
     */
    private ScLocalInteger   _horizontalGap;

    /**
     * The gap to display between all rows.
     */
    private ScLocalInteger   _verticalGap;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _rowCount = new ScLocalInteger();
        _columnCount = new ScLocalInteger();

        _cellCss = new ScLocalCss();
        _cellStyle = new ScLocalStyle();

        _horizontalGap = new ScLocalInteger();
        _verticalGap = new ScLocalInteger();

        setColumn();
        setGap(DEFAULT_GAP);
    }

    //##################################################
    //# rows
    //##################################################

    public Integer getRowCount()
    {
        return _rowCount.getValue();
    }

    public void setRowCount(int e)
    {
        _rowCount.setValue(e);
        _columnCount.clearValue();
    }

    public void setRow()
    {
        setRowCount(1);
    }

    //##################################################
    //# columns
    //##################################################

    public Integer getColumnCount()
    {
        return _columnCount.getValue();
    }

    public void setColumnCount(int e)
    {
        _rowCount.clearValue();
        _columnCount.setValue(e);
    }

    public void setColumn()
    {
        setColumnCount(1);
    }

    public boolean isColumnar()
    {
        return _columnCount.hasValue();
    }

    //##################################################
    //# table class
    //##################################################

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = super.formatCss();
        css.noSpace();
        return css;
    }

    //##################################################
    //# cell class
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
        return cellCss().noSpace().toString();
    }

    //##################################################
    //# cell style
    //##################################################

    public String getCellStyle()
    {
        return _cellStyle.getValue();
    }

    public void setCellStyle(String e)
    {
        _cellStyle.setValue(e);
    }

    public KmStyleBuilder cellStyle()
    {
        return _cellStyle.toBuilder();
    }

    protected String formatCellStyle()
    {
        return getCellStyle();
    }

    //##################################################
    //# gap
    //##################################################

    public Integer getHorizontalGap()
    {
        return _horizontalGap.getValue();
    }

    public void setHorizontalGap(Integer e)
    {
        _horizontalGap.setValue(e);
    }

    public Integer getVerticalGap()
    {
        return _verticalGap.getValue();
    }

    public void setVerticalGap(Integer e)
    {
        _verticalGap.setValue(e);
    }

    public void setGap(Integer e)
    {
        setHorizontalGap(e);
        setVerticalGap(e);
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

        KmList<ScControl> v = getChildren();
        int rows = getActualRowCount(v);
        int cols = getActualColumnCount(v);

        for ( int row = 0; row < rows; row++ )
            renderRow(out, v, cols, row);

        out.end("table");
    }

    private void renderRow(KmHtmlBuilder out, KmList<ScControl> v, int cols, int row)
    {
        if ( row > 0 )
            renderVerticalGap(out);

        out.begin("tr");

        for ( int col = 0; col < cols; col++ )
            renderCell(out, v, row, col);

        out.end("tr");
    }

    private void renderCell(KmHtmlBuilder out, KmList<ScControl> v, int row, int col)
    {
        if ( col > 0 )
            renderHorizontalGap(out);

        out.open("td");
        out.printAttribute("class", formatCellCss());
        out.printAttribute("style", formatCellStyle());
        out.close();

        ScControl e = getChildAt(v, row, col);

        if ( e == null )
            out.printNonBreakingSpace();
        else
            e.renderOn(out);

        out.end("td");
    }

    private void renderHorizontalGap(KmHtmlBuilder out)
    {
        Integer gap = _horizontalGap.getValue();
        if ( gap == 0 )
            return;

        String style = "width:" + gap + "px";

        out.beginStyle("td", style);
        out.end("td");
    }

    private void renderVerticalGap(KmHtmlBuilder out)
    {
        Integer gap = _verticalGap.getValue();
        if ( gap == 0 )
            return;

        String style = "height:" + gap + "px";

        out.begin("tr");
        out.beginStyle("td", style);
        out.end("td");
        out.end("tr");
    }

    //##################################################
    //# support
    //##################################################

    private int getActualRowCount(KmList<ScControl> v)
    {
        int n = v.size();

        if ( isColumnar() )
        {
            int cols = getColumnCount();
            return (n + cols - 1) / cols;
        }

        int rows = getRowCount();
        if ( n < rows )
            return n;

        return rows;
    }

    private int getActualColumnCount(KmList<ScControl> v)
    {
        int n = v.size();

        if ( isColumnar() )
        {
            int cols = getColumnCount();
            if ( n < cols )
                return n;

            return cols;
        }

        int rows = getRowCount();
        return (n + rows - 1) / rows;
    }

    private ScControl getChildAt(KmList<ScControl> v, int r, int c)
    {
        if ( isColumnar() )
        {
            int cols = getColumnCount();
            int i = r * cols + c;
            return v.getAtSafe(i);
        }

        int rows = getRowCount();
        int i = c * rows + r;
        return v.getAtSafe(i);
    }
}
