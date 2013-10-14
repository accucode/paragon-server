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

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * review_wyatt: (aaron) The Bar chart subclass
 */

/**
 * This chart is similar to the ScLineChart, displaying several data sets
 * with many points, but in the form of a bar chart.  
 */
public class ScMultiBarChart
    extends ScAbstractChart
{
    //##################################################
    //# constants
    //##################################################

    private static final int      DEFAULT_DELAY                = 600;
    private static final double   DEFAULT_GROUP_SPACING        = 0.1;
    private static final int      DEFAULT_ROTATE_LABEL_DEGREES = 0;

    //##################################################
    //# variables
    //##################################################

    /**
     * The time delay between animating individual bars, or groups
     * or bars.
     */
    private int                   _delay;

    /**
     * The spacing between groups.  Value seems to be the ratio of the
     * size of the space to the size of the data.  Default is 0.1.
     */
    private double                _groupSpacing;

    /**
     * The X axis labels will be rotated by this many degrees.  Useful
     * if x axis precision is high, or if labels are long.
     */
    private int                   _rotateLabelsDegrees;

    /**
     * Determines whether or not the grouped / stacked buttons are shown.
     */
    private boolean               _showGroupStackControl;

    /**
     * The list of data seried to be displayed in the chart
     */
    private KmList<ScChartSeries> _dataSeries;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setTransitionDuration(DEFAULT_TRANSITION_DURATION);
        setDelay(DEFAULT_DELAY);
        setYAxisPrecision(DEFAULT_Y_AXIS_PRECISION);
        setGroupSpacing(DEFAULT_GROUP_SPACING);
        setRotateLabelsDegrees(DEFAULT_ROTATE_LABEL_DEGREES);

        _dataSeries = new KmList<ScChartSeries>();
    }

    //##################################################
    //# delay
    //##################################################

    public int getDelay()
    {
        return _delay;
    }

    public void setDelay(int e)
    {
        _delay = e;
    }

    //##################################################
    //# group spacing
    //##################################################

    public double getGroupSpacing()
    {
        return _groupSpacing;
    }

    public void setGroupSpacing(double e)
    {
        _groupSpacing = e;
    }

    //##################################################
    //# rotate labels
    //##################################################

    public int getRotateLabelsDegrees()
    {
        return _rotateLabelsDegrees;
    }

    public void setRotateLabelsDegrees(int e)
    {
        _rotateLabelsDegrees = e;
    }

    //##################################################
    //# group stack control
    //##################################################

    public boolean getShowGroupStackControl()
    {
        return _showGroupStackControl;
    }

    public void setShowGroupStackControl(boolean e)
    {
        _showGroupStackControl = e;
    }

    public void showGroupStackControl()
    {
        setShowGroupStackControl(true);
    }

    //##################################################
    //# series
    //##################################################

    public KmList<ScChartSeries> getDataSeries()
    {
        return _dataSeries;
    }

    public void setDataSeries(KmList<ScChartSeries> dataSeries)
    {
        _dataSeries = dataSeries;
    }

    public ScChartSeries addSeries()
    {
        String key = Kmu.format("Series %s", getDataSeries().size() + 1);

        ScChartSeries e;
        e = new ScChartSeries();
        e.setKey(key);
        getDataSeries().add(e);
        return e;
    }

    @Override
    protected KmJsonArray formatData()
    {
        KmJsonArray arr;
        arr = new KmJsonArray();

        for ( ScChartSeries e : getDataSeries() )
            arr.addMap(e.formatJson());

        return arr;
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void initializeChart(KmStringBuilder out)
    {
        out.print("var chart;");
        out.print("chart = nv.models.multiBarChart();");
        out.printf("chart.transitionDuration(%s);", getTransitionDuration());
        out.printf("chart.delay(%s);", getDelay());
        out.printf("chart.groupSpacing(%s);", getGroupSpacing());
        out.printf("chart.rotateLabels(%s);", getRotateLabelsDegrees());
        out.printf("chart.showControls(%s);", getShowGroupStackControl());

        if ( hasYAxisLabel() )
            out.printf("chart.margin({left:%s});", Y_LABEL_MARGIN);
    }

    @Override
    protected void formatXAxis(KmStringBuilder out)
    {
        out.print("chart.xAxis.showMaxMin(true);");

        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());
    }

    @Override
    protected void formatYAxis(KmStringBuilder out)
    {
        out.printf("chart.yAxis.tickFormat(d3.format(',.%sf'));", getYAxisPrecision());

        if ( hasYAxisLabel() )
            out.printf("chart.yAxis.axisLabel('%s');", getYAxisLabel());

        out.printf("chart.forceY([%s,%s]);", getYAxisMin(), getYAxisMax());
    }
}
