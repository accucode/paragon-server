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

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.servlet.control.ScChartAxis;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * This is a line chart useful for displaying several data sets with
 * many data points.
 */
public class ScLineChart
    extends ScAbstractChart
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Configuration options for the horizontal x-axis.
     */
    private ScChartAxis _xAxis;

    /**
     * Configuration options for the vertical y-axis.
     * This library supports only one y-axis.
     */
    private ScChartAxis _yAxis;

    /**
     * If true, show an vertical guide-line that follows the mouse.
     * This causes the tooltip to show data from multiple sets at once.
     * Default: true.
     */
    public boolean _guideline;

    //==================================================
    //= variables :: reconfiguable (ScLocal)
    //==================================================

    /**
     * The list of data seried to be displayed in the chart
     */
    private ScLocalList<ScLineChartSet> _dataSets;

    //##################################################
    //# constructor
    //##################################################

    public ScLineChart()
    {
        _xAxis = new ScChartAxis();
        _xAxis.setX();

        _yAxis = new ScChartAxis();
        _yAxis.setY();

        _guideline = true;

        _dataSets = new ScLocalList<>();
    }

    //##################################################
    //# axes
    //##################################################

    public ScChartAxis getXAxis()
    {
        return _xAxis;
    }

    public ScChartAxis getYAxis()
    {
        return _yAxis;
    }

    //##################################################
    //# guideline
    //##################################################

    public boolean getGuideline()
    {
        return _guideline;
    }

    public void setGuideline(boolean e)
    {
        _guideline = e;
    }

    //##################################################
    //# data sets
    //##################################################

    private KmList<ScLineChartSet> getDataSets()
    {
        return _dataSets.getValue();
    }

    public void addDataSet(ScLineChartSet e)
    {
        _dataSets.add(e);
    }

    public ScLineChartSet addDataSet()
    {
        String key = Kmu.format("Set %s", getDataSets().size() + 1);

        ScLineChartSet e;
        e = new ScLineChartSet();
        e.setName(key);
        addDataSet(e);
        return e;
    }

    @Override
    protected KmJsonArray formatDatum()
    {
        KmJsonArray arr;
        arr = new KmJsonArray();

        for ( ScLineChartSet e : getDataSets() )
            arr.addMap(e.formatJson());

        return arr;
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void composeSetupOn(KmStringBuilder out)
    {
        out.printf("var chart;");
        out.printf("chart = nv.models.lineChart();");
        out.printf("chart.useInteractiveGuideline(%s);", getGuideline());

        _xAxis.composeScriptOn(out);
        _yAxis.composeScriptOn(out);
    }

}
