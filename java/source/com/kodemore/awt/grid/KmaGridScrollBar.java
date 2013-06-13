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

package com.kodemore.awt.grid;

import javax.swing.JScrollBar;

public class KmaGridScrollBar
    extends JScrollBar
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridScrollBar create(KmaGrid g, int i)
    {
        KmaGridScrollBar sb;
        sb = new KmaGridScrollBar();
        sb.setGrid(g);
        sb.setOrientation(i);
        sb.addAdjustmentListener(g.newAdjustmentListener());
        return sb;
    }

    //##################################################
    //# variables
    //##################################################

    private KmaGrid _grid;

    //##################################################
    //# accessing
    //##################################################

    public KmaGrid getGrid()
    {
        return _grid;
    }

    public void setGrid(KmaGrid o)
    {
        _grid = o;
    }

    @Override
    public void setVisible(boolean b)
    {
        super.setVisible(b);
        _grid.refresh();
    }

    @Override
    public void setOrientation(int i)
    {
        super.setOrientation(i);
        updateUI();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public int getBlockIncrement(int direction)
    {
        return orientation == VERTICAL
            ? getVerticalBlockIncrement(direction)
            : getHorizontalBlockIncrement(direction);
    }

    public int getVerticalBlockIncrement(int direction)
    {
        int i, j;
        i = j = getGrid().getFirstVisibleRow();
        while ( isRowRangeValid(i, j) )
            if ( direction > 0 )
                j++;
            else
                i--;
        int n = j - i - 1;
        if ( n < 1 )
            n = 1;
        return n;
    }

    public int getHorizontalBlockIncrement(int direction)
    {
        int i, j;
        i = j = getGrid().getFirstVisibleColumn();
        while ( isColumnRangeValid(i, j) )
            if ( direction > 0 )
                j++;
            else
                i--;
        int n = j - i - 1;
        if ( n < 1 )
            n = 1;
        return n;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isRowRangeValid(int i, int j)
    {
        KmaGrid g = getGrid();
        if ( i < 0 )
            return false;
        if ( j >= g.getRowCount() )
            return false;
        int h = g.getRowSizeModel().getRangeSize(i, j);
        int hMax = g.getClientBounds().height;
        if ( h > hMax )
            return false;
        return true;
    }

    public boolean isColumnRangeValid(int i, int j)
    {
        KmaGrid g = getGrid();
        if ( i < 0 )
            return false;
        if ( j >= g.getColumnCount() )
            return false;
        int h = g.getColumnSizeModel().getRangeSize(i, j);
        int hMax = g.getClientBounds().width;
        if ( h > hMax )
            return false;
        return true;
    }

}
