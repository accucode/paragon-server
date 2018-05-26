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

import com.kodemore.collection.KmList;

/**
 * A gannt chart row represents a single row on the chart and contains
 * one or more sets of items.
 */
public class ScGanttChartRow
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The chart this row belongs to;
     */
    private ScGanttChart _chart;

    /**
     * The sets contained in this row.
     */
    private KmList<ScGanttChartDataset> _datasets;

    /**
     * The name of this row.
     */
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    public ScGanttChartRow()
    {
        _datasets = new KmList<>();
    }

    //##################################################
    //# chart
    //##################################################

    public ScGanttChart getChart()
    {
        return _chart;
    }

    public void setChart(ScGanttChart chart)
    {
        _chart = chart;
    }

    //##################################################
    //# sets
    //##################################################

    public KmList<ScGanttChartDataset> getDatasets()
    {
        return _datasets;
    }

    public void setDatasets(KmList<ScGanttChartDataset> v)
    {
        _datasets = v;
    }

    public void addDataset(ScGanttChartDataset e)
    {
        e.setRow(this);
        _datasets.add(e);
    }

    public ScGanttChartDataset addDataset()
    {
        ScGanttChartDataset e;
        e = new ScGanttChartDataset();
        _datasets.add(e);
        return e;
    }

    //##################################################
    //# label
    //##################################################

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String e)
    {
        _label = e;
    }
}
