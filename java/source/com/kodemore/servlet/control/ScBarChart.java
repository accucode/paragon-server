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
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonList;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.types.KmHtmlColor;

public class ScBarChart
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final int     DEFAULT_TRANSITION_DURATION = 500;
    private static final int     DEFAULT_Y_AXIS_MIN          = 0;

    private static final int     Y_LABEL_MARGIN              = 85;
    private static final int     STAGGER_LABEL_MARGIN        = 65;

    //##################################################
    //# variables
    //##################################################

    /**
     * The time it takes for the chart to appear on the page.
     */
    private int                  _transitionDuration;

    private String               _xAxisLabel;
    private String               _yAxisLabel;

    /**
     * If set, the chart will expand to include this value.  However, the 
     * chart will not cut off data that exists outside of this range.  The
     * chart will always automatically expand to fit all data.
     */
    private Integer              _xAxisMin;

    /**
     * See _xAxisMin.
     */
    private Integer              _xAxisMax;

    /**
     * See _xAxisMin.
     */
    private Integer              _yAxisMin;

    /**
     * See _xAxisMin.
     */
    private Integer              _yAxisMax;

    /**
     * how many digits after the deciman to show on the y axis labels
     */
    private int                  _yAxisPrecision;

    /**
     * Determines if the individual bar labes should be staggered vertically.
     */
    private boolean              _staggerLabels;

    /**
     * This is the data to be represented in the chart.  
     * Each bar must have a "key" (also the label)
     * and a "value", and may optionally have a color using the
     * key "color".
     */
    private KmList<KmJsonObject> _bars;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setYAxisMin(DEFAULT_Y_AXIS_MIN);

        _bars = new KmList<KmJsonObject>();
    }

    //##################################################
    //# transition duration
    //##################################################

    public int getTransitionDuration()
    {
        return _transitionDuration;
    }

    public void setTransitionDuration(int e)
    {
        _transitionDuration = e;
    }

    //##################################################
    //# axis
    //##################################################

    //==================================================
    //= axis :: labels
    //==================================================

    public String getXAxisLabel()
    {
        return _xAxisLabel;
    }

    public void setXAxisLabel(String e)
    {
        _xAxisLabel = e;
    }

    public boolean hasXAxisLabel()
    {
        return getXAxisLabel() != null;
    }

    public String getYAxisLabel()
    {
        return _yAxisLabel;
    }

    public void setYAxisLabel(String e)
    {
        _yAxisLabel = e;
    }

    public boolean hasYAxisLabel()
    {
        return getYAxisLabel() != null;
    }

    //==================================================
    //= axis :: precision
    //==================================================

    public int getYAxisPrecision()
    {
        return _yAxisPrecision;
    }

    public void setYAxisPrecision(int e)
    {
        _yAxisPrecision = e;
    }

    //==================================================
    //= axis :: min / max
    //==================================================

    public Integer getXAxisMin()
    {
        return _xAxisMin;
    }

    public void setXAxisMin(Integer e)
    {
        _xAxisMin = e;
    }

    public Integer getXAxisMax()
    {
        return _xAxisMax;
    }

    public void setXAxisMax(Integer e)
    {
        _xAxisMax = e;
    }

    public Integer getYAxisMin()
    {
        return _yAxisMin;
    }

    public void setYAxisMin(Integer e)
    {
        _yAxisMin = e;
    }

    public Integer getYAxisMax()
    {
        return _yAxisMax;
    }

    public void setYAxisMax(Integer e)
    {
        _yAxisMax = e;
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

    public KmList<KmJsonObject> getBars()
    {
        return _bars;
    }

    public void setBars(KmList<KmJsonObject> e)
    {
        _bars = e;
    }

    public void addBar(KmJsonObject e)
    {
        getBars().add(e);
    }

    public void addBar(String key, double value)
    {
        KmJsonObject slice;
        slice = new KmJsonObject();
        slice.setString("key", key);
        slice.setDouble("value", value);
        getBars().add(slice);
    }

    public void addBar(String key, double value, KmHtmlColor color)
    {
        KmJsonObject slice;
        slice = new KmJsonObject();
        slice.setString("key", key);
        slice.setDouble("value", value);
        slice.setString("color", color.getValue());
        getBars().add(slice);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.close();
        out.begin("svg");
        out.end("svg");
        out.endDiv();

        ScRootScript ajax;
        ajax = out.getPostRender();
        ajax.run(formatLineChartScript());
    }

    //##################################################
    //# script
    //##################################################

    private String formatLineChartScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print("nv.addGraph(function(){");
        initializeChart(out);
        formatXAxis(out);
        formatYAxis(out);
        finalizeChart(out);
        out.print("});");
        return out.toString();
    }

    private void initializeChart(KmStringBuilder out)
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

    private void formatXAxis(KmStringBuilder out)
    {
        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());
    }

    private void formatYAxis(KmStringBuilder out)
    {
        if ( hasYAxisLabel() )
            out.printf("chart.yAxis.axisLabel('%s');", getYAxisLabel());

        out.printf("chart.forceY([%s,%s]);", getYAxisMin(), getYAxisMax());
    }

    private void finalizeChart(KmStringBuilder out)
    {
        out.printf(
            "d3.select('#%s svg').datum(%s).transition().duration(%s).call(chart);",
            getHtmlId(),
            formatData(),
            DEFAULT_TRANSITION_DURATION);
        out.print("nv.utils.windowResize(chart.update);");
        out.print("return chart;");
    }

    //##################################################
    //# format data
    //##################################################

    // review_aaron: 
    //    private KmJsonList formatData()
    //    {
    //        KmJsonList bars;
    //        bars = new KmJsonList();
    //
    //        for ( KmJsonObject e : getBars() )
    //            bars.addObject(e);
    //
    //        KmJsonList arr;
    //        arr = new KmJsonList();
    //
    //        KmJsonObject dataSet;
    //        dataSet = arr.addObject();
    //        dataSet.setList("values", bars);
    //
    //        return arr;
    //    }

    private KmJsonList formatData()
    {
        ScChartSeries s;
        s = new ScChartSeries();

        for ( KmJsonObject e : getBars() )
            s.addPoint(e);

        KmJsonList data;
        data = new KmJsonList();
        data.addObject(s.formatJson());
        return data;
    }
}
