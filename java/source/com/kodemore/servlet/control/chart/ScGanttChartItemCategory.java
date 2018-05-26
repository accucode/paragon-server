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

package com.kodemore.servlet.control.chart;

import com.kodemore.utility.Kmu;

/**
 * The category controls the display style of the items.
 */
public class ScGanttChartItemCategory
{
    //##################################################
    //# static
    //##################################################

    public static ScGanttChartItemCategory createDefault()
    {
        ScGanttChartItemCategory e;
        e = new ScGanttChartItemCategory();
        e.setColor(ScGanttChartColor.Blue);
        e.setName("Default");
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The name of this item.
     */
    private String _name;

    /**
     * The display color of this item in the chart.
     */
    private ScGanttChartColor _color;

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

    public boolean hasName(String e)
    {
        return Kmu.isEqual(e, getName());
    }

    //##################################################
    //# color
    //##################################################

    public ScGanttChartColor getColor()
    {
        return _color;
    }

    public void setColor(ScGanttChartColor color)
    {
        _color = color;
    }

    public boolean hasColor()
    {
        return getColor() != null;
    }
}
