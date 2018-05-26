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

package com.kodemore.awt.graph;

import com.kodemore.utility.Kmu;

public class KmaGraphPoint
{
    //##################################################
    //# variables
    //##################################################

    private double _x;
    private double _y;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphPoint()
    {
        this(0, 0);
    }

    public KmaGraphPoint(double x, double y)
    {
        _x = x;
        _y = y;
    }

    //##################################################
    //# accessing
    //##################################################

    public double getX()
    {
        return _x;
    }

    public void setX(double e)
    {
        _x = e;
    }

    public boolean hasX()
    {
        return Double.isNaN(_x);
    }

    public boolean hasX(double x)
    {
        return Kmu.isEqual(x, _x);
    }

    public double getY()
    {
        return _y;
    }

    public void setY(double e)
    {
        _y = e;
    }

    public boolean hasY()
    {
        return Double.isNaN(_y);
    }

    public boolean hasY(double y)
    {
        return Kmu.isEqual(y, _y);
    }

}
