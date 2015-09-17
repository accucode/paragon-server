/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.types.KmHtmlColor;

/**
 * This is a simple bar chart that displays several discrete data points. 
 */
public class ScBarChart
    extends ScAbstractChart
{
    //##################################################
    //# constants
    //##################################################

    private static final int DEFAULT_Y_AXIS_MIN   = 0;
    private static final int STAGGER_LABEL_MARGIN = 65;

    //##################################################
    //# variables
    //##################################################

    /**
     * Determines if the individual bar labes should be staggered vertically.
     */
    private boolean _staggerLabels;

    /**
     * This is the data to be represented in the chart.  
     * Each bar must have a "key" (also the label)
     * and a "value", and may optionally have a color using the
     * key "color".
     */
    private KmList<KmJsonMap> _bars;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setYAxisMin(DEFAULT_Y_AXIS_MIN);

        _bars = new KmList<>();
    }

    //##################################################
    //# Stagger Labels 
    //##################################################

    public boolean getStaggerLabels()
    {
        return _staggerLabels;
    }

    public void setStaggerLabels(boolean e)
    {
        _staggerLabels = e;
    }

    public void staggerLabels()
    {
        setStaggerLabels(true);
    }

    //##################################################
    //# data (bars)
    //##################################################

    public KmList<KmJsonMap> getBars()
    {
        return _bars;
    }

    public void setBars(KmList<KmJsonMap> e)
    {
        _bars = e;
    }

    public void addBar(KmJsonMap e)
    {
        getBars().add(e);
    }

    public void addBar(String key, double value)
    {
        KmJsonMap slice;
        slice = new KmJsonMap();
        slice.setString("key", key);
        slice.setDouble("value", value);

        getBars().add(slice);
    }

    public void addBar(String key, double value, KmHtmlColor color)
    {
        KmJsonMap slice;
        slice = new KmJsonMap();
        slice.setString("key", key);
        slice.setDouble("value", value);
        slice.setString("color", color.getValue());

        getBars().add(slice);
    }

    @Override
    protected KmJsonArray formatData()
    {
        ScChartSeries s;
        s = new ScChartSeries();

        for ( KmJsonMap e : getBars() )
            s.addPoint(e);

        KmJsonArray data;
        data = new KmJsonArray();
        data.addMap(s.formatJson());
        return data;
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void initializeChart(KmStringBuilder out)
    {
        out.print("var chart;");
        out.print("chart = nv.models.discreteBarChart();");
        out.print("chart.x(function(d) { return d.key });");
        out.print("chart.y(function(d) { return d.value });");
        out.printf("chart.staggerLabels(%s);", getStaggerLabels());
        out.print("chart.tooltips(true);");

        if ( hasYAxisLabel() )
            out.printf("chart.margin({left:%s});", Y_LABEL_MARGIN);

        if ( getStaggerLabels() )
            out.printf("chart.margin({bottom:%s});", STAGGER_LABEL_MARGIN);
    }

    @Override
    protected void formatXAxis(KmStringBuilder out)
    {
        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());
    }

    @Override
    protected void formatYAxis(KmStringBuilder out)
    {
        if ( hasYAxisLabel() )
            out.printf("chart.yAxis.axisLabel('%s');", getYAxisLabel());

        out.printf("chart.forceY([%s,%s]);", getYAxisMin(), getYAxisMax());
    }
}
