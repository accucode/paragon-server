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

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.types.KmHtmlColor;

public class ScLineChartSet
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
     * Determins if the area under the line should be filled.
     * Default: false.
     */
    private boolean _area;

    /**
     * The data points to be charted.
     */
    private KmList<ScLineChartPoint> _points;

    //##################################################
    //# constructor
    //##################################################

    public ScLineChartSet()
    {
        _points = new KmList<>();
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

    public void setColor(KmHtmlColor e)
    {
        _color = e;
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

    public KmList<ScLineChartPoint> getPoints()
    {
        return _points;
    }

    public ScLineChartPoint addPoint()
    {
        ScLineChartPoint e;
        e = new ScLineChartPoint();
        addPoint(e);
        return e;
    }

    public void addPoint(ScLineChartPoint e)
    {
        getPoints().add(e);
    }

    public ScLineChartPoint addPoint(double x, double y)
    {
        ScLineChartPoint p;
        p = addPoint();
        p.setX(x);
        p.setY(y);
        return p;
    }

    //##################################################
    //# convenience
    //##################################################

    public KmJsonMap formatJson()
    {
        KmJsonMap out;
        out = new KmJsonMap();
        out.setString("key", ScCharts.toSafeLabel(getName()));
        out.setBoolean("area", getArea());

        if ( hasColor() )
            out.setString("color", getColor().getHexValue());

        KmJsonArray values = out.setArray("values");
        for ( ScLineChartPoint p : getPoints() )
            values.addMap(p.toJson());

        return out;
    }
}
