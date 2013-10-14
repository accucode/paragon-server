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

        _dataSeries = new KmList<ScChartSeries>();
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
        out.print("chart = nv.models.lineChart().useInteractiveGuideline(true);");
        out.print("chart.x(function(d,i){return d.x});");

        if ( hasYAxisLabel() )
            out.printf("chart.margin({left:%s});", Y_LABEL_MARGIN);
    }

    @Override
    protected void formatXAxis(KmStringBuilder out)
    {
        out.printf("chart.xAxis.tickFormat(d3.format(',.%sf'));", getXAxisPrecision());

        if ( hasXAxisLabel() )
            out.printf("chart.xAxis.axisLabel('%s');", getXAxisLabel());

        out.printf("chart.forceX([%s,%s]);", getXAxisMin(), getXAxisMax());
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
