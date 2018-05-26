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
 * A gantt chart item.
 */
public class ScGanttChartItem
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The set this item belongs to.
     */
    private ScGanttChartDataset _dataset;

    /**
     * The name of this item.  This will display in the item box
     * in the chart.
     */
    private String _label;

    /**
     * The item's description.  This will be displayed when you hover over
     * the item in the chart.
     */
    private String _description;

    /**
     * The start (min value) of this item.
     */
    private Integer _startIntValue;

    /**
     * The start (max value) of this item.
     */
    private Integer _endIntValue;

    /**
     * The category of this item.
     */
    private ScGanttChartItemCategory _category;

    //##################################################
    //# constructor
    //##################################################

    public ScGanttChartItem()
    {
        setCategory(ScGanttChartItemCategory.createDefault());
    }

    //##################################################
    //# chart
    //##################################################

    public ScGanttChart getChart()
    {
        if ( hasDataset() )
            return getDataset().getChart();

        return null;
    }

    //##################################################
    //# dataset
    //##################################################

    public ScGanttChartDataset getDataset()
    {
        return _dataset;
    }

    public void setDataset(ScGanttChartDataset e)
    {
        _dataset = e;
    }

    public boolean hasDataset()
    {
        return getDataset() != null;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String e)
    {
        _label = e;
    }

    public boolean hasLabel()
    {
        return getLabel() != null;
    }

    //##################################################
    //# description
    //##################################################

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public boolean hasDescription()
    {
        return Kmu.hasValue(getDescription());
    }

    //##################################################
    //# start
    //##################################################

    public Integer getStartIntValue()
    {
        return _startIntValue;
    }

    public void setStartIntValue(Integer i)
    {
        _startIntValue = i;
    }

    public boolean hasStartIntValue()
    {
        return getStartIntValue() != null;
    }

    //##################################################
    //# end
    //##################################################

    public Integer getEndIntValue()
    {
        return _endIntValue;
    }

    public void setEndIntValue(Integer i)
    {
        _endIntValue = i;
    }

    public boolean hasEndIntValue()
    {
        return getEndIntValue() != null;
    }

    //##################################################
    //# category
    //##################################################

    public ScGanttChartItemCategory getCategory()
    {
        return _category;
    }

    public void setCategory(ScGanttChartItemCategory e)
    {
        _category = e;
    }

    public String getCategoryName()
    {
        return getCategory().getName();
    }

    //##################################################
    //# display
    //##################################################

    public String getDisplayName()
    {
        if ( hasLabel() )
            return Kmu.format("%s - %s", getCategoryName(), getLabel());

        return getCategoryName();
    }

    //##################################################
    //# color
    //##################################################

    public ScGanttChartColor getColor()
    {
        return getCategory().getColor();
    }
}
