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
import com.kodemore.utility.Kmu;

public class ScPieChart
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private int                  _height;
    private int                  _width;
    private int                  _transitionDuration;
    private boolean              _donut;

    private KmList<KmJsonObject> _slices;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        // review_aaron: need good defaults
        _height = 400;
        _width = 400;
        _transitionDuration = 300;

        _slices = new KmList<KmJsonObject>();
    }

    //##################################################
    //# height / width
    //##################################################

    public int getHeight()
    {
        return _height;
    }

    public void setHeight(int e)
    {
        _height = e;
    }

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int e)
    {
        _width = e;
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
    //# donut
    //##################################################

    public boolean getDonut()
    {
        return _donut;
    }

    public void setDonut(boolean e)
    {
        _donut = e;
    }

    //##################################################
    //# data (slices)
    //##################################################

    public KmList<KmJsonObject> getSlices()
    {
        return _slices;
    }

    public void setSlices(KmList<KmJsonObject> e)
    {
        _slices = e;
    }

    public void addSlice(KmJsonObject e)
    {
        getSlices().add(e);
    }

    public void addSlice(String key, double value)
    {
        KmJsonObject slice;
        slice = new KmJsonObject();
        slice.setString("key", key);
        slice.setDouble("value", value);
        getSlices().add(slice);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        String style = Kmu.format("height: %spx; width: %spx;", getHeight(), getWidth());

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute("style", style);
        out.printAttribute(formatCss());
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
        finalizeChart(out);
        out.print("});");
        return out.toString();
    }

    private void initializeChart(KmStringBuilder out)
    {
        out.print("var chart;");
        out.print("chart = nv.models.pieChart();");
        out.print("chart.x(function(d) { return d.key });");
        out.print("chart.y(function(d) { return d.value });");
        out.print("chart.labelType('percent');");
        out.printf("chart.donut(%s);", getDonut());
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

        for ( KmJsonObject e : getSlices() )
            arr.addObject(e);

        return arr;
    }
}
