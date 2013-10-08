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
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * review_aaron Options to consider:
 *      Axis format, precision. 
 */
public class ScBarChart
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final int      DEFAULT_TRANSITION_DURATION = 300;
    private static final int      DEFAULT_DELAY               = 600;

    private static final int      DEFAULT_X_AXIS_PRECISION    = 0;
    private static final int      DEFAULT_Y_AXIS_PRECISION    = 0;

    private static final int      Y_LABEL_MARGIN              = 85;

    //##################################################
    //# variables
    //##################################################

    /**
     * The time it takes for the chart to appear on the page.
     */
    private int                   _transitionDuration;

    /**
     * The time delay between animating individual bars, or groups
     * or bars.
     */
    private int                   _delay;

    private boolean               _staggerLabels;

    private String                _xAxisLabel;
    private String                _yAxisLabel;

    private Integer               _yAxisMin;
    private Integer               _yAxisMax;

    /**
     * how many digits after the deciman to show on the x axis labels
     */
    private int                   _xAxisPrecision;

    /**
     * how many digits after the deciman to show on the y axis labels
     */
    private int                   _yAxisPrecision;

    private KmList<ScChartSeries> _dataSeries;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _transitionDuration = DEFAULT_TRANSITION_DURATION;
        _delay = DEFAULT_DELAY;

        _xAxisPrecision = DEFAULT_X_AXIS_PRECISION;
        _yAxisPrecision = DEFAULT_Y_AXIS_PRECISION;

        _dataSeries = new KmList<ScChartSeries>();
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

    public boolean getStaggerLabels()
    {
        return _staggerLabels;
    }

    public void setStaggerLabels(boolean staggerLabels)
    {
        _staggerLabels = staggerLabels;
    }

    //==================================================
    //= axis :: precision
    //==================================================

    public int getXAxisPrecision()
    {
        return _xAxisPrecision;
    }

    public void setxAxisPrecision(int e)
    {
        _xAxisPrecision = e;
    }

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
        out.print("chart = nv.models.multiBarChart();");
        out.printf("chart.transitionDuration(%s);", getTransitionDuration());
        out.printf("chart.delay(%s);", getDelay());

        if ( hasYAxisLabel() )
            out.printf("chart.margin({left:%s});", Y_LABEL_MARGIN);
    }

    private void formatXAxis(KmStringBuilder out)
    {
        out.printf("chart.xAxis.tickFormat(d3.format(',.%sf'));", getXAxisPrecision());

        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());
    }

    private void formatYAxis(KmStringBuilder out)
    {
        out.printf("chart.yAxis.tickFormat(d3.format(',.1%s'));", getYAxisPrecision());

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
            getTransitionDuration());
        out.print("nv.utils.windowResize(chart.update);");
        out.print("return chart;");
    }

    //##################################################
    //# format data
    //##################################################

    private KmJsonList formatData()
    {
        KmJsonList arr;
        arr = new KmJsonList();

        for ( ScChartSeries e : getDataSeries() )
            arr.addObject(e.formatJson());

        return arr;
    }
}
