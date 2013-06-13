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

package com.kodemore.awt.graph;

import java.awt.Point;

public class KmaGraphBounds
{
    //##################################################
    //# variables
    //##################################################

    private double _left;
    private double _right;
    private double _bottom;
    private double _top;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphBounds()
    {
        _left = Double.NaN;
        _right = Double.NaN;
        _bottom = Double.NaN;
        _top = Double.NaN;
    }

    public KmaGraphBounds(double x, double y, double width, double height)
    {
        _left = x;
        _right = x + width;
        _bottom = y;
        _top = y + height;
    }

    //##################################################
    //# accessing
    //##################################################

    public double getLeft()
    {
        return _left;
    }

    public void setLeft(double e)
    {
        _left = e;
    }

    public double getRight()
    {
        return _right;
    }

    public void setRight(double e)
    {
        _right = e;
    }

    public double getTop()
    {
        return _top;
    }

    public void setTop(double e)
    {
        _top = e;
    }

    public double getBottom()
    {
        return _bottom;
    }

    public void setBottom(double e)
    {
        _bottom = e;
    }

    public double getWidth()
    {
        return _right - _left;
    }

    public void setWidth(double d)
    {
        _right = _left + d;
    }

    public double getHeight()
    {
        return _top - _bottom;
    }

    public void setHeight(double d)
    {
        _top = _bottom + d;
    }

    //##################################################
    //# utility
    //##################################################

    public void add(KmaGraphPoint p)
    {
        double x = p.getX();
        double y = p.getY();
        if ( isUndefined() )
        {
            _left = x;
            _right = x;
            _bottom = y;
            _top = y;
        }
        else
        {
            if ( x < _left )
                _left = x;
            if ( x > _right )
                _right = x;
            if ( y < _bottom )
                _bottom = y;
            if ( y > _top )
                _top = y;
        }
    }

    public void add(KmaGraphBounds b)
    {
        if ( b.isUndefined() )
            return;
        if ( isUndefined() )
        {
            _left = b.getLeft();
            _right = b.getRight();
            _bottom = b.getBottom();
            _top = b.getTop();
        }
        else
        {
            if ( b.getLeft() < _left )
                _left = b.getLeft();
            if ( b.getRight() > _right )
                _right = b.getRight();
            if ( b.getBottom() < _bottom )
                _bottom = b.getBottom();
            if ( b.getTop() > _top )
                _top = b.getTop();
        }
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isDefined()
    {
        if ( Double.isNaN(_left) )
            return false;
        if ( Double.isNaN(_right) )
            return false;
        if ( Double.isNaN(_bottom) )
            return false;
        if ( Double.isNaN(_top) )
            return false;
        if ( _right < _left )
            return false;
        if ( _top < _bottom )
            return false;
        return true;
    }

    public boolean isUndefined()
    {
        return !isDefined();
    }

    public boolean contains(Point p)
    {
        if ( isUndefined() )
            return false;
        double x = p.getX();
        double y = p.getY();
        if ( x < _left )
            return false;
        if ( x > _right )
            return false;
        if ( y < _bottom )
            return false;
        if ( y > _top )
            return false;
        return true;
    }

}
