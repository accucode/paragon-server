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
 * review_aaron 
 *      
 *      Min / Max : 
 *          chart.forceY([min, max]); Will expand the chart to show the min max values,
 *              but the chart will still automatically expand to show data that is outside
 *              this range.
 *          chart.yDomain([min, max]); Will truncate the chart to only display the range
 *              specified.  However the data will be drawn outside of the graph if it falls
 *              outside of this range.
 */
public class ScLineChart
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final int      DEFAULT_TRANSITION_DURATION = 500;

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

    private String                _xAxisLabel;
    private String                _yAxisLabel;

    /**
     * If set, the chart will expand to include this value.  However, the 
     * chart will not cut off data that exists outside of this range.  The
     * chart will always automatically expand to fit all data.
     */
    private Integer               _xAxisMin;

    /**
     * See _xAxisMin.
     */
    private Integer               _xAxisMax;

    /**
     * See _xAxisMin.
     */
    private Integer               _yAxisMin;

    /**
     * See _xAxisMin.
     */
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

    public int getXAxisPrecision()
    {
        return _xAxisPrecision;
    }

    public void setXAxisPrecision(int e)
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
    //# series
    //##################################################

    public KmList<ScChartSeries> getDataSeries()
    {
        return _dataSeries;
    }

    public void setDataSeries(KmList<ScChartSeries> e)
    {
        _dataSeries = e;
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
        out.print("chart = nv.models.lineChart().useInteractiveGuideline(true);");
        out.print("chart.x(function(d,i){return d.x});");

        if ( hasYAxisLabel() )
            out.printf("chart.margin({left:%s});", Y_LABEL_MARGIN);
    }

    private void formatXAxis(KmStringBuilder out)
    {
        out.printf("chart.xAxis.tickFormat(d3.format(',.%sf'));", getXAxisPrecision());

        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());

        out.printf("chart.forceX([%s,%s]);", getXAxisMin(), getXAxisMax());
    }

    private void formatYAxis(KmStringBuilder out)
    {
        out.printf("chart.yAxis.tickFormat(d3.format(',.%sf'));", getYAxisPrecision());

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
