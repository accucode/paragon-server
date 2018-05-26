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

package com.kodemore.awt.grid;

import java.awt.Point;

import javax.swing.CellRendererPane;
import javax.swing.JScrollBar;

public class KmaGridModel
{
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

    //##################################################
    //# delegation
    //##################################################

    public JScrollBar getVerticalScrollBar()
    {
        return _grid.getVerticalScrollBar();
    }

    public JScrollBar getHorizontalScrollBar()
    {
        return _grid.getHorizontalScrollBar();
    }

    public CellRendererPane getCellRendererPane()
    {
        return _grid.getCellRendererPane();
    }

    public KmaGridHeaderIF getRowHeader()
    {
        return _grid.getRowHeader();
    }

    public KmaGridHeaderIF getColumnHeader()
    {
        return _grid.getColumnHeader();
    }

    public KmaGridActionModel getActionModel()
    {
        return _grid.getActionModel();
    }

    public KmaGridSelectionModelIF getSelectionModel()
    {
        return _grid.getSelectionModel();
    }

    public int getCellGap()
    {
        return _grid.getCellGap();
    }

    public Point getDot()
    {
        return getActionModel().getDot();
    }

    public Point getAnchor()
    {
        return getActionModel().getAnchor();
    }

    public void repaintGrid()
    {
        getGrid().repaint();
    }
}
