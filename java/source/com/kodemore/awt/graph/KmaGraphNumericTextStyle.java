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

import com.kodemore.utility.Kmu;

public class KmaGraphNumericTextStyle
    extends KmaGraphTextStyle
{
    //##################################################
    //# variables
    //##################################################

    private int     _decimals;
    private boolean _commas;
    private double  _factor;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphNumericTextStyle()
    {
        _decimals = 0;
        _commas = true;
        _factor = 1;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getDecimals()
    {
        return _decimals;
    }

    public void setDecimals(int e)
    {
        _decimals = e;
    }

    public boolean getCommas()
    {
        return _commas;
    }

    public void setCommas(boolean e)
    {
        _commas = e;
    }

    public double getFactor()
    {
        return _factor;
    }

    public void setFactor(double e)
    {
        _factor = e;
    }

    //##################################################
    //# display
    //##################################################

    public String format(double d)
    {
        d /= _factor;
        return Kmu.formatDouble(d, _decimals, _commas);
    }

}
