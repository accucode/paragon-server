/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.freechart;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

/**
 * I am used with the KmSimpleLineChart to collect and manage
 * information about each series of points.
 */
public class KmSimpleLineChartGroup
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The display name.  
     */
    private String               _name;

    /**
     * The X,Y values.
     * Null X values are NOT supported.
     * NULL Y values ARE supported, the actual handling depends on the chart.
     */
    private KmMap<Double,Double> _values;

    /**
     * If true (default), show a shape at each point.
     */
    private boolean              _showsShapes;

    /**
     * If true (default), show a line connecting each point.
     */
    private boolean              _showsLines;

    //##################################################
    //# constructor
    //##################################################

    public KmSimpleLineChartGroup()
    {
        _values = new KmMap<>();
        _showsShapes = true;
        _showsLines = true;
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# value
    //##################################################

    public Double addValue(Double x, Double y)
    {
        return _values.put(x, y);
    }

    public KmList<Double> getXs()
    {
        KmList<Double> v;
        v = _values.getKeys();
        v.sort();
        return v;
    }

    public Double getY(Double x)
    {
        return _values.get(x);
    }

    //##################################################
    //# formatting
    //##################################################

    public boolean getShowsShapes()
    {
        return _showsShapes;
    }

    public void setShowsShapes(boolean e)
    {
        _showsShapes = e;
    }

    public boolean getShowsLines()
    {
        return _showsLines;
    }

    public void setShowsLines(boolean e)
    {
        _showsLines = e;
    }

}
