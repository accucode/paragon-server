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

package com.kodemore.servlet.control;

import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.control.nvd3.ScCharts;
import com.kodemore.types.KmHtmlColor;

public class ScChartSet
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The unique identifier of the data series.
     * This is required, and acts as the display label.
     */
    private String _name;

    /**
     * Optional value to determine the color of the data series.
     * If null, the color is chosen automatically.
     * Default: null.
     */
    private KmHtmlColor _color;

    /**
     * On line charts, this attribute determines if the
     * area below the line is filled in or not.
     * Default: false.
     */
    private boolean _area;

    /**
     * The data points to be charted.  Each point has an
     * "x" and a "y".
     */
    private KmJsonArray _points;

    //##################################################
    //# constructor
    //##################################################

    public ScChartSet()
    {
        _points = new KmJsonArray();
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
    //# color
    //##################################################

    public KmHtmlColor getColor()
    {
        return _color;
    }

    public void setColor(KmHtmlColor color)
    {
        _color = color;
    }

    public boolean hasColor()
    {
        return getColor() != null;
    }

    //##################################################
    //# area
    //##################################################

    public boolean getArea()
    {
        return _area;
    }

    public void setArea(boolean e)
    {
        _area = e;
    }

    //##################################################
    //# points
    //##################################################

    public KmJsonArray getPoints()
    {
        return _points;
    }

    public void setPoints(KmJsonArray points)
    {
        _points = points;
    }

    public void addPoint(KmJsonMap e)
    {
        getPoints().addMap(e);
    }

    public void addPoint(double x, double y)
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setDouble("x", x);
        e.setDouble("y", y);
        addPoint(e);
    }

    //##################################################
    //# convenience
    //##################################################

    public KmJsonMap formatJson()
    {
        KmJsonMap out;
        out = new KmJsonMap();
        out.setString("key", ScCharts.toSafeLabel(getName()));

        if ( hasColor() )
            out.setString("color", getColor().getHexValue());

        out.setBoolean("area", getArea());
        out.setArray("values", getPoints());
        return out;
    }
}
