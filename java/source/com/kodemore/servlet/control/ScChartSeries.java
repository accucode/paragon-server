/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.json.KmJsonList;
import com.kodemore.json.KmJsonObject;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

public class ScChartSeries
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The unique identifier of the data series, and can 
     * not be null.  Doubles as the series label.
     */
    private String      _key;
    private KmHtmlColor _color;
    private Boolean     _area;
    private KmJsonList  _points;

    //##################################################
    //# constructor
    //##################################################

    public ScChartSeries()
    {
        _points = new KmJsonList();
    }

    //##################################################
    //# label
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public void setKey(String e)
    {
        _key = e;
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

    public Boolean getArea()
    {
        return _area;
    }

    public void setArea(Boolean area)
    {
        _area = area;
    }

    public void setArea()
    {
        _area = true;
    }

    public boolean isArea()
    {
        return Kmu.isTrue(getArea());
    }

    //##################################################
    //# points
    //##################################################

    public KmJsonList getPoints()
    {
        return _points;
    }

    public void setPoints(KmJsonList points)
    {
        _points = points;
    }

    public void addPoint(KmJsonObject e)
    {
        getPoints().addObject(e);
    }

    public void addPoint(double x, double y)
    {
        KmJsonObject point;
        point = new KmJsonObject();
        point.setDouble("x", x);
        point.setDouble("y", y);
        addPoint(point);
    }

    //##################################################
    //# convenience
    //##################################################

    public KmJsonObject formatJson()
    {
        KmJsonObject out;
        out = new KmJsonObject();
        out.setString("key", getKey());

        if ( hasColor() )
            out.setString("color", getColor().getValue());

        out.setBoolean("area", isArea());
        out.setList("values", getPoints());
        return out;
    }
}
