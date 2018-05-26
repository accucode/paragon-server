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

package com.kodemore.servlet.control.nvd3;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.servlet.control.ScChartMargin;
import com.kodemore.servlet.field.ScHtmlIdControl;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.string.KmStringBuilder;

/**
 * This implements the Nvd3 javascript chart library.
 * http://nvd3.org/
 *
 * It should be noted that if a chart is placed in a div
 * that is initially hidded, the chart will initialize with
 * a size of 0.  In order to display correctly, the chart(s)
 * should be manually updated once shown using updateAllCharts()
 * or getUpdateAllChartsScript().
 */
public abstract class ScAbstractChart
    extends ScHtmlIdControl
{
    //##################################################
    //# constants
    //##################################################

    protected static final int DEFAULT_TRANSITION_MS = 250;

    //##################################################
    //# variables
    //##################################################

    /**
     * The time it takes for the chart to appear on the page.
     */
    private int _transitionMs;

    /**
     * The margin to be added around the outside of the chart.
     * In some cases it may be useful to add additional space
     * for controls, and labels.
     */
    private ScChartMargin _margin;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractChart()
    {
        _transitionMs = DEFAULT_TRANSITION_MS;
        _margin = new ScChartMargin();
    }

    //##################################################
    //# transition
    //##################################################

    public int getTransitionMs()
    {
        return _transitionMs;
    }

    public void setTransitionMs(int e)
    {
        _transitionMs = e;
    }

    //##################################################
    //# margin
    //##################################################

    public ScChartMargin getMargin()
    {
        return _margin;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected final void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.close();

        out.begin("svg");
        out.end("svg");

        out.endDiv();

        ScBlockScript ajax;
        ajax = out.getPostRender();
        ajax.run(formatChartScript());
    }

    //##################################################
    //# script
    //##################################################

    private String formatChartScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print("nv.addGraph(function()");
        out.print("{");

        composeSetupOn(out);

        out.printf("chart.margin(%s);", getMargin().toJson());
        out.printf("chart.noData('No data available.');");

        out.printf(
            "d3.select('#%s svg').datum(%s).transition().duration(%s).call(chart);",
            getHtmlId(),
            formatDatum(),
            getTransitionMs());

        out.print("nv.utils.windowResize(chart.update);");
        out.print("Kmu.nvd3Register(chart);");
        out.print("return chart;");

        out.print("});");
        return out.toString();
    }

    /**
     * Perform initial setup of the chart javascript.
     * This should define a local javascript variable called 'chart'
     * and initialize it.
     */
    protected abstract void composeSetupOn(KmStringBuilder out);

    /**
     * Format the data points, bars, slices, etc.
     */
    protected abstract KmJsonArray formatDatum();

    //##################################################
    //# ajax
    //##################################################

    /**
     * Manually update all charts on the page.
     */
    public void ajaxUpdateAllCharts()
    {
        getRootScript().run(getUpdateAllChartsScript());
    }

    /**
     * Static method returning the script to manually update
     * all charts.
     */
    public static String getUpdateAllChartsScript()
    {
        return "Kmu.nvd3UpdateAll();";
    }
}
