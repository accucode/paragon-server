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

public class KmaGraphPixelBounds
{
    //##################################################
    //# variables
    //##################################################

    private int _left;
    private int _right;
    private int _bottom;
    private int _top;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphPixelBounds()
    {
        _left = 0;
        _right = -1;
        _bottom = 0;
        _top = -1;
    }

    public KmaGraphPixelBounds(int x, int y, int width, int height)
    {
        _left = x;
        _bottom = y;
        setWidth(width);
        setHeight(height);
    }

    //##################################################
    //# accessing
    //##################################################

    public int getLeft()
    {
        return _left;
    }

    public void setLeft(int e)
    {
        _left = e;
    }

    public int getRight()
    {
        return _right;
    }

    public void setRight(int e)
    {
        _right = e;
    }

    public int getTop()
    {
        return _top;
    }

    public void setTop(int e)
    {
        _top = e;
    }

    public int getBottom()
    {
        return _bottom;
    }

    public void setBottom(int e)
    {
        _bottom = e;
    }

    public int getWidth()
    {
        return _right - _left + 1;
    }

    public void setWidth(int w)
    {
        _right = _left + w - 1;
    }

    public int getHeight()
    {
        return _top - _bottom + 1;
    }

    public void setHeight(int h)
    {
        _top = _bottom + h - 1;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isDefined()
    {
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
        int x = p.x;
        int y = p.y;
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
