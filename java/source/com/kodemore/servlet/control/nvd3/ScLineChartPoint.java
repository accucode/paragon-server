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

package com.kodemore.servlet.control.nvd3;

import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

/**
 * This is a simple bar chart that displays several discrete data points.
 */
public class ScLineChartPoint
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The label to be displayed.
     */
    private double _x;

    /**
     * The numeric value that determines the size of the bar.
     */
    private double _y;

    /**
     * Additional data associated with the bar. This is not displayed, but
     * is used by the chart's click action.
     */
    private String _data;

    //##################################################
    //# x
    //##################################################

    public double getX()
    {
        return _x;
    }

    public void setX(double e)
    {
        _x = e;
    }

    //##################################################
    //# y
    //##################################################

    public double getY()
    {
        return _y;
    }

    public void setY(double e)
    {
        _y = e;
    }

    //##################################################
    //# data
    //##################################################

    public String getData()
    {
        return _data;
    }

    public void setData(String e)
    {
        _data = e;
    }

    public boolean hasData()
    {
        return Kmu.hasValue(getData());
    }

    //##################################################
    //# conversion
    //##################################################

    public KmJsonMap toJson()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setDouble("x", getX());
        e.setDouble("y", getY());

        if ( hasData() )
            e.setString("data", getData());

        return e;
    }
}
