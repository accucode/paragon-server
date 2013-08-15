/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.collection.KmList;

public class KmaGridSingleSelectionModel
    implements KmaGridSelectionModelIF
{
    //##################################################
    //# variables
    //##################################################

    private Point _selection;

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Point getSelection()
    {
        return _selection == null
            ? null
            : new Point(_selection);
    }

    public void setSelection(Point p)
    {
        if ( _selection == null )
        {
            if ( p == null )
                return;
            _selection = new Point(p);
            return;
        }
        if ( p == null )
        {
            _selection = null;
            return;
        }
        if ( _selection.equals(p) )
            return;
        _selection.setLocation(p);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmList<Point> getSelections()
    {
        KmList<Point> v = new KmList<Point>();
        Point p = getSelection();
        if ( p != null )
            v.add(p);
        return v;
    }

    //##################################################
    //# selection
    //##################################################

    @Override
    public void select(Point p)
    {
        setSelection(p);
    }

    @Override
    public void deselect(Point p)
    {
        if ( _selection == null )
            return;
        if ( !_selection.equals(p) )
            return;
        clear();
    }

    @Override
    public void toggle(Point p)
    {
        if ( isSelected(p) )
            clear();
        else
            setSelection(p);
    }

    //##################################################
    //# extend
    //##################################################

    @Override
    public void extendSelection(Point p)
    {
        select(p);
    }

    @Override
    public void extendDeselection(Point p)
    {
        deselect(p);
    }

    @Override
    public void extendToggle(Point p)
    {
        toggle(p);
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public void clear()
    {
        if ( _selection == null )
            return;
        _selection = null;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasSelection()
    {
        return _selection != null;
    }

    @Override
    public boolean isSelected(Point p)
    {
        return _selection == null
            ? false
            : _selection.equals(p);
    }
}
