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
public class ScBarChart
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final int      DEFAULT_TRANSITION_DURATION  = 300;
    private static final int      DEFAULT_DELAY                = 600;

    private static final int      DEFAULT_X_AXIS_PRECISION     = 0;
    private static final int      DEFAULT_Y_AXIS_PRECISION     = 0;

    private static final double   DEFAULT_GROUP_SPACING        = 0.1;

    private static final int      DEFAULT_ROTATE_LABEL_DEGREES = 0;

    private static final int      Y_LABEL_MARGIN               = 85;

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

    private String                _xAxisLabel;
    private String                _yAxisLabel;

    /**
     * If set, the chart will expand to include this value.  However, the 
     * chart will not cut off data that exists outside of this range.  The
     * chart will always automatically expand to fit all data.
     */
    private Integer               _yAxisMin;

    /**
     * See _yAxisMin.
     */
    private Integer               _yAxisMax;

    /**
     * how many digits after the deciman to show on the x axis labels.
     */
    private int                   _xAxisPrecision;

    /**
     * how many digits after the deciman to show on the y axis labels.
     */
    private int                   _yAxisPrecision;

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
        setXAxisPrecision(DEFAULT_X_AXIS_PRECISION);
        setYAxisPrecision(DEFAULT_Y_AXIS_PRECISION);
        setGroupSpacing(DEFAULT_GROUP_SPACING);
        setRotateLabelsDegrees(DEFAULT_ROTATE_LABEL_DEGREES);

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
        out.printf("chart.groupSpacing(%s);", getGroupSpacing());
        out.printf("chart.rotateLabels(%s);", getRotateLabelsDegrees());

        if ( hasYAxisLabel() )
            out.printf("chart.margin({left:%s});", Y_LABEL_MARGIN);
    }

    private void formatXAxis(KmStringBuilder out)
    {
        out.printf("chart.xAxis.tickFormat(d3.format(',.%sf'));", getXAxisPrecision());
        out.print("chart.xAxis.showMaxMin(true);");

        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());
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
