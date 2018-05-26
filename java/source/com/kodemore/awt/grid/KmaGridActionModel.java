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
import java.awt.event.ActionListener;

import com.kodemore.awt.KmaActionGroup;

public class KmaGridActionModel
    extends KmaGridModel
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridActionModel create(KmaGrid g)
    {
        KmaGridActionModel m;
        m = new KmaGridActionModel();
        m.setGrid(g);
        return m;
    }

    //##################################################
    //# constants
    //##################################################

    public static final String ACCEPT_ACTION = "accept";
    public static final String SELECT_ACTION = "select";

    //##################################################
    //# variables
    //##################################################

    private Point          _dot;
    private Point          _anchor;
    private boolean        _hasToggleSelection;
    private int            _selectionMode;
    private KmaActionGroup _actions;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridActionModel()
    {
        _dot = new Point();
        _anchor = new Point();
        _actions = new KmaActionGroup();
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Point getDot()
    {
        return new Point(_dot);
    }

    public void setDot(Point p)
    {
        setDot(p, true);
    }

    public void setDot(Point p, boolean show)
    {
        _dot.setLocation(p);
        if ( show )
            makeDotVisible();
    }

    public boolean isDot(Point p)
    {
        if ( p == null )
            return false;
        return _dot.equals(p);
    }

    @Override
    public Point getAnchor()
    {
        return new Point(_anchor);
    }

    public void setAnchor(Point p)
    {
        _anchor.setLocation(p);
    }

    public void resetAnchor()
    {
        setAnchor(_dot);
    }

    //##################################################
    //# make visible
    //##################################################

    public void makeDotVisible()
    {
        makeDotVisibleX();
        makeDotVisibleY();
    }

    public void makeDotVisibleX()
    {
        KmaGrid grid = getGrid();
        int x = getDot().x;
        int x1 = grid.getFirstVisibleColumn();

        while ( x1 > x )
        {
            x1--;
            grid.setFirstVisibleColumn(x1);
        }

        int x2 = grid.getLastFullyVisibleColumn();

        while ( x2 < x )
        {
            x1++;
            grid.setFirstVisibleColumn(x1);
            x2 = grid.getLastFullyVisibleColumn();
        }
    }

    public void makeDotVisibleY()
    {
        KmaGrid grid = getGrid();
        int y = getDot().y;
        int y1 = grid.getFirstVisibleRow();

        while ( y1 > y )
        {
            y1--;
            grid.setFirstVisibleRow(y1);
        }

        int y2 = grid.getLastFullyVisibleRow();

        while ( y2 < y )
        {
            y1++;
            grid.setFirstVisibleRow(y1);
            y2 = grid.getLastFullyVisibleRow();
        }
    }

    //##################################################
    //# select
    //##################################################

    public void selectDot()
    {
        select(_dot);
    }

    public void selectAnchor()
    {
        select(_anchor);
    }

    public void select(Point p)
    {
        _selectionMode = 1;
        getSelectionModel().select(p);
        _hasToggleSelection = false;
    }

    //##################################################
    //# select (toggle)
    //##################################################

    public void toggleAnchorSelection()
    {
        toggleSelection(_anchor);
    }

    public void toggleDotSelection()
    {
        toggleSelection(_dot);
    }

    public void toggleSelection(Point p)
    {
        _selectionMode = 2;
        getSelectionModel().toggle(p);
        _hasToggleSelection = true;
    }

    public void setHasToggleSelection(boolean e)
    {
        _hasToggleSelection = e;
    }

    //##################################################
    //# select (extend)
    //##################################################

    public void extendToggleSelection()
    {
        if ( !_hasToggleSelection )
            toggleAnchorSelection();

        extendSelection();
    }

    public void extendSelection()
    {
        if ( _selectionMode == 1 )
            extendSelection(_dot);

        if ( _selectionMode == 2 )
            extendToggleSelection(_dot);
    }

    public void extendSelection(Point p)
    {
        getSelectionModel().extendSelection(p);
    }

    public void extendToggleSelection(Point p)
    {
        getSelectionModel().extendToggle(p);
    }

    //##################################################
    //# select (clear)
    //##################################################

    public void clearSelection()
    {
        getSelectionModel().clear();
        _hasToggleSelection = false;
    }

    //##################################################
    //# actions (accept)
    //##################################################

    public void addAcceptAction(ActionListener al)
    {
        _actions.add(ACCEPT_ACTION, al);
    }

    public void removeAcceptAction(ActionListener al)
    {
        _actions.remove(ACCEPT_ACTION, al);
    }

    public void fireAcceptActions()
    {
        _actions.fire(ACCEPT_ACTION, this);
    }

    //##################################################
    //# actions (select)
    //##################################################

    public void addSelectAction(ActionListener a)
    {
        _actions.add(SELECT_ACTION, a);
    }

    public void removeSelectAction(ActionListener a)
    {
        _actions.remove(SELECT_ACTION, a);
    }

    public void fireSelectActions()
    {
        _actions.fire(SELECT_ACTION);
    }
}
