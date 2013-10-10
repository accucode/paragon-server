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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonList;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.string.KmStringBuilder;

/**
 * This implements the Nvd3 javascript chart library.
 * 
 * It should be noted that if a chart is placed in a div
 * that is initially hidded, the chart will initialize with 
 * a size of 0.  In order to display correctly, the chart(s)
 * should be manually updated once shown using updateAllCharts()
 * or getUpdateAllChartsScript().
 */
public abstract class ScAbstractChart
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    protected static final int DEFAULT_TRANSITION_DURATION = 500;

    protected static final int DEFAULT_Y_AXIS_PRECISION    = 0;

    protected static final int Y_LABEL_MARGIN              = 85;

    //##################################################
    //# variables
    //##################################################

    /**
     * The time it takes for the chart to appear on the page.
     */
    private int                _transitionDuration;

    private String             _xAxisLabel;
    private String             _yAxisLabel;

    /**
     * If set, the chart will expand to include this value.  However, the 
     * chart will not cut off data that exists outside of this range.  The
     * chart will always automatically expand to fit all data.
     */
    private Integer            _xAxisMin;

    /**
     * See _xAxisMin.
     */
    private Integer            _xAxisMax;

    /**
     * See _xAxisMin.
     */
    private Integer            _yAxisMin;

    /**
     * See _xAxisMin.
     */
    private Integer            _yAxisMax;

    /**
     * how many digits after the deciman to show on the x axis labels
     */
    private int                _xAxisPrecision;

    /**
     * how many digits after the deciman to show on the y axis labels
     */
    private int                _yAxisPrecision;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setTransitionDuration(DEFAULT_TRANSITION_DURATION);
        setYAxisPrecision(DEFAULT_Y_AXIS_PRECISION);
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

    /**
     * The is where the chart is initialized using the specific 
     * nvd3 chart model. 
     */
    protected abstract void initializeChart(KmStringBuilder out);

    /**
     * Where the chart's x axis attributes are set
     */
    protected abstract void formatXAxis(KmStringBuilder out);

    /**
     * Where the chart's y axis attributes are set
     */
    protected abstract void formatYAxis(KmStringBuilder out);

    protected void finalizeChart(KmStringBuilder out)
    {
        out.printf(
            "d3.select('#%s svg').datum(%s).transition().duration(%s).call(chart);",
            getHtmlId(),
            formatData(),
            DEFAULT_TRANSITION_DURATION);
        out.print("nv.utils.windowResize(chart.update);");
        out.print("return chart;");
    }

    /**
     * Where the data is formatted into the Json list when finalizing the chart.
     */
    protected abstract KmJsonList formatData();

    //##################################################
    //# convenience
    //##################################################

    /**
     * Manually update all charts on the page.
     */
    public void updateAllCharts()
    {
        ajax().run(getUpdateAllChartsScript());
    }

    /**
     * Static method returning the script to manually update
     * all charts. 
     */
    public static String getUpdateAllChartsScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print("var length = nv.graphs.length;");
        out.print("for ( var i = 0; i < length; i++)");
        out.print("nv.graphs[i].update();");
        return out.toString();
    }
}
