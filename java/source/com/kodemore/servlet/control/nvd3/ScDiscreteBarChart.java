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
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScChartAxis;
import com.kodemore.servlet.control.ScChartSet;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.string.KmStringBuilder;

/**
 * This is a simple bar chart that displays several discrete data points.
 * This uses vertical bars and there is no direct equivalent for horizontal bars.
 *
 * This bar chart is mostly the same as using a multi-bar chart with a single data set.
 * But there are a few differences.
 * - The tooltips don't show the series/set name.
 * - Each bar is automatically given a different color.
 * - You can display the numeric value at the top of each bar.
 */
public class ScDiscreteBarChart
    extends ScAbstractChart
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The axis used for discrete labels.
     * May be either the horizontal or vertical axis depending on the subclass.
     */
    private ScChartAxis _labelAxis;

    /**
     * The axis used for numeric values.
     * May be either the horizontal or vertical axis depending on the subclass.
     */
    private ScChartAxis _valueAxis;

    /**
     * Determines if the individual bar labes should be staggered vertically.
     * Default = false (not staggered).
     */
    private boolean _staggerLabels;

    /**
     * If set (not-zero), then the x-axis labels are rotated this many degrees
     * clockwise. This is useful for longer labels.
     * Default = 0 (no rotation).
     */
    private int _labelRotationDegrees;

    /**
     * If true the numeric value will be displayed at the top of each bar.
     * Default: false.
     */
    private boolean _showValues;

    /**
     * If set, this action is run when the user clicks on the bar chart.
     * The bar's key is passed back as the action argument.
     */
    private ScAction _clickAction;

    //==================================================
    //= variables :: reconfiguable (ScLocal)
    //==================================================

    /**
     * This is the data to be represented in the chart.
     * Each bar must have a "key" (also the label)
     * and a "value", and may optionally have a color using the
     * key "color".
     */
    private ScLocalList<ScBarChartPoint> _bars;

    //##################################################
    //# constructor
    //##################################################

    public ScDiscreteBarChart()
    {
        _labelAxis = new ScChartAxis();
        _labelAxis.setX();

        _valueAxis = new ScChartAxis();
        _valueAxis.setY();

        _bars = new ScLocalList<>();
    }

    //##################################################
    //# axes
    //##################################################

    public ScChartAxis getLabelAxis()
    {
        return _labelAxis;
    }

    public ScChartAxis getValueAxis()
    {
        return _valueAxis;
    }

    //##################################################
    //# stagger labels
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
    //# label rotation
    //##################################################

    public int getLabelRotationDegrees()
    {
        return _labelRotationDegrees;
    }

    public void setLabelRotationDegrees(int e)
    {
        _labelRotationDegrees = e;
    }

    public boolean hasLabelRotationDegrees()
    {
        return getLabelRotationDegrees() != 0;
    }

    //##################################################
    //# show values
    //##################################################

    public boolean getShowValues()
    {
        return _showValues;
    }

    public void setShowValues(boolean e)
    {
        _showValues = e;
    }

    //##################################################
    //# click action
    //##################################################

    public ScAction getClickAction()
    {
        return _clickAction;
    }

    public void setClickAction(ScAction e)
    {
        _clickAction = e;
    }

    public boolean hasClickAction()
    {
        return _clickAction != null;
    }

    //##################################################
    //# data (bars)
    //##################################################

    private KmList<ScBarChartPoint> getBars()
    {
        return _bars.getValue();
    }

    public void addBar(ScBarChartPoint e)
    {
        _bars.add(e);
    }

    public ScBarChartPoint addBar()
    {
        ScBarChartPoint e;
        e = new ScBarChartPoint();
        addBar(e);
        return e;
    }

    public ScBarChartPoint addBar(String label, double value)
    {
        ScBarChartPoint e;
        e = addBar();
        e.setLabel(label);
        e.setValue(value);
        return e;
    }

    @Override
    protected KmJsonArray formatDatum()
    {
        ScChartSet s;
        s = new ScChartSet();

        for ( ScBarChartPoint e : getBars() )
            s.addPoint(e.toJson());

        KmJsonArray data;
        data = new KmJsonArray();
        data.addMap(s.formatJson());
        return data;
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void composeSetupOn(KmStringBuilder out)
    {
        out.print("var chart;");
        out.print("chart = nv.models.discreteBarChart();");
        out.print("chart.x(function(e) { return e.label });");
        out.print("chart.y(function(e) { return e.value });");

        if ( getStaggerLabels() )
            out.printf("chart.staggerLabels(true);");

        if ( hasLabelRotationDegrees() )
            out.printf("chart.rotateLabels(%s);", getLabelRotationDegrees());

        if ( getShowValues() )
            out.printf("chart.showValues(true);");

        if ( hasClickAction() )
        {
            out.printf("chart.discretebar.dispatch.on('elementClick', function(e)");
            out.printf("{");
            out.printf("Kmu.nvd3HandleClick(%s, e.data.data)", getClickAction().getKey());
            out.printf("});");
        }

        getLabelAxis().composeScriptOn(out);
        getValueAxis().composeScriptOn(out);
    }
}
