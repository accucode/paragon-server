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

public class ScBarChartSet
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
     * The data points to be charted.
     */
    private KmList<ScBarChartPoint> _points;

    //##################################################
    //# constructor
    //##################################################

    public ScBarChartSet()
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
    //# points
    //##################################################

    public KmList<ScBarChartPoint> getPoints()
    {
        return _points;
    }

    public ScBarChartPoint addPoint()
    {
        ScBarChartPoint e = new ScBarChartPoint();
        addPoint(e);
        return e;
    }

    public void addPoint(ScBarChartPoint e)
    {
        getPoints().add(e);
    }

    public ScBarChartPoint addPoint(String label, double value)
    {
        ScBarChartPoint p;
        p = new ScBarChartPoint();
        p.setLabel(label);
        p.setValue(value);
        addPoint(p);
        return p;
    }

    public void addPoints(KmList<ScBarChartPoint> v)
    {
        getPoints().addAll(v);
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

        KmJsonArray values = out.setArray("values");
        for ( ScBarChartPoint p : getPoints() )
            values.addMap(p.toJson());

        return out;
    }

}
