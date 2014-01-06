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

package com.kodemore.awt.grid;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

import com.kodemore.collection.KmList;

public class KmaGridSelectionArea
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    public static final int SELECT_MODE   = 1;
    public static final int DESELECT_MODE = 2;
    public static final int TOGGLE_MODE   = 3;

    //##################################################
    //# variables
    //##################################################

    private Point           _dot;
    private Point           _anchor;
    private Rectangle       _area;
    private int             _mode;

    //##################################################
    //# constructors
    //##################################################

    public KmaGridSelectionArea()
    {
        _dot = new Point();
        _anchor = new Point();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getMode()
    {
        return _mode;
    }

    public void setMode(int o)
    {
        _mode = o;
    }

    public Point getDot()
    {
        return new Point(_dot);
    }

    public void setDot(Point p)
    {
        _dot.setLocation(p);
    }

    public Point getAnchor()
    {
        return new Point(_anchor);
    }

    public void setAnchor(Point p)
    {
        _anchor.setLocation(p);
    }

    public Rectangle getArea()
    {
        if ( _area == null )
            _area = computeArea();
        return _area;
    }

    //##################################################
    //# utility
    //##################################################

    public Insets computeInsets()
    {
        int top = _dot.y;
        int bottom = _anchor.y;
        int left = _dot.x;
        int right = _anchor.x;

        if ( top > bottom )
        {
            int z = top;
            top = bottom;
            bottom = z;
        }
        if ( left > right )
        {
            int z = left;
            left = right;
            right = z;
        }
        return new Insets(top, left, bottom, right);
    }

    public Rectangle computeArea()
    {
        Insets i = computeInsets();
        int x = i.left;
        int y = i.top;
        int w = i.right - i.left + 1;
        int h = i.bottom - i.top + 1;
        return new Rectangle(x, y, w, h);
    }

    //##################################################
    //# public
    //##################################################

    public void select(Point p)
    {
        startAt(p, SELECT_MODE);
    }

    public void deselect(Point p)
    {
        startAt(p, DESELECT_MODE);
    }

    public void toggle(Point p)
    {
        startAt(p, TOGGLE_MODE);
    }

    public void startAt(Point p, int i)
    {
        _mode = i;
        setDot(p);
        setAnchor(p);
        _area = null;
    }

    public void extendTo(Point p)
    {
        if ( _dot.equals(p) )
            return;
        setDot(p);
        _area = null;
    }

    public boolean contains(Point p)
    {
        return getArea().contains(p);
    }

    public boolean isSelected(Point p, boolean b)
    {
        if ( _mode == SELECT_MODE )
            return contains(p)
                ? true
                : b;
        if ( _mode == DESELECT_MODE )
            return contains(p)
                ? false
                : b;
        if ( _mode == TOGGLE_MODE )
            return contains(p)
                ? !b
                : b;
        return false;
    }

    public void updateSelections(KmList<Point> v)
    {
        Insets i = computeInsets();
        Point p = new Point();

        if ( _mode == SELECT_MODE )
            for ( int x = i.left; x <= i.right; x++ )
                for ( int y = i.top; y <= i.bottom; y++ )
                {
                    p.setLocation(x, y);
                    if ( !v.contains(p) )
                        v.add(new Point(p));
                }

        if ( _mode == DESELECT_MODE )
            for ( int x = i.left; x <= i.right; x++ )
                for ( int y = i.top; y <= i.bottom; y++ )
                {
                    p.setLocation(x, y);
                    v.remove(p);
                }

        if ( _mode == TOGGLE_MODE )
            for ( int x = i.left; x <= i.right; x++ )
                for ( int y = i.top; y <= i.bottom; y++ )
                {
                    p.setLocation(x, y);
                    int n = v.indexOf(p);
                    if ( n < 0 )
                        v.add(new Point(p));
                    else
                        v.remove(n);
                }

    }

}
