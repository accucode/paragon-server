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
import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.json.KmJsonArray;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScChartAxis;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * An ABSTRACT superclass for the vertical and horizontal bar charts.
 * Multiple data sets displayed together in a single bar chart.
 * The slices can be displayed either side-by-side or stacked.
 */
public abstract class ScBarChart
    extends ScAbstractChart
{
    //##################################################
    //# constants
    //##################################################

    private static final double DEFAULT_GROUP_SPACING = 0.1;

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
     * The spacing between groups.  Value seems to be the ratio of the
     * size of the space to the size of the data.
     * Default is 0.1.
     */
    private double _groupSpacing;

    /**
     * Determines whether or not the grouped/stacked buttons are shown.
     * Default is false.
     */
    private boolean _showStackControl;

    /**
     * Determines whether or not the legend is displayed.
     * Showing the legend allows the user to dynamically toggle each series.
     * Default is false.
     */
    private boolean _showLegend;

    /**
     * If true, the chart is initially shows with 'stacked' bars.
     * Default: false.
     */
    private boolean _stacked;

    /**
     * If set, this action is run when the user clicks on the bar chart.
     * The bar's key is passed back as the action argument.
     */
    private ScAction _clickAction;

    //==================================================
    //= variables :: reconfiguable (ScLocal)
    //==================================================

    /**
     * The list of data sets to be displayed in the chart.
     */
    private ScLocalList<ScBarChartSet> _dataSets;

    //##################################################
    //# constructor
    //##################################################

    public ScBarChart()
    {
        _labelAxis = new ScChartAxis();
        _labelAxis.setX();

        _valueAxis = new ScChartAxis();
        _valueAxis.setY();

        _dataSets = new ScLocalList<>();

        setGroupSpacing(DEFAULT_GROUP_SPACING);
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
    //# stack control
    //##################################################

    public boolean getShowStackControl()
    {
        return _showStackControl;
    }

    public void setShowStackControl(boolean e)
    {
        _showStackControl = e;
    }

    //##################################################
    //# legend
    //##################################################

    public boolean getShowLegend()
    {
        return _showLegend;
    }

    public void setShowLegend(boolean e)
    {
        _showLegend = e;
    }

    //##################################################
    //# stacked
    //##################################################

    public boolean getStacked()
    {
        return _stacked;
    }

    public void setStacked(boolean e)
    {
        _stacked = e;
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
    //# series
    //##################################################

    private KmList<ScBarChartSet> getDataSets()
    {
        return _dataSets.getValue();
    }

    public ScBarChartSet addDataSet()
    {
        String name = Kmu.format("Set %s", getDataSets().size() + 1);

        ScBarChartSet e;
        e = new ScBarChartSet();
        e.setName(name);
        addDataSet(e);
        return e;
    }

    public void addDataSet(ScBarChartSet e)
    {
        _dataSets.add(e);
    }

    @Override
    protected KmJsonArray formatDatum()
    {
        KmJsonArray arr;
        arr = new KmJsonArray();

        for ( ScBarChartSet e : getDataSets() )
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
        out.printf("chart = nv.models.%s();", getChartFunction());
        out.printf("chart.x(function(e) { return e.label });");
        out.printf("chart.y(function(e) { return e.value });");
        out.printf("chart.groupSpacing(%s);", getGroupSpacing());
        out.printf("chart.showControls(%s);", getShowStackControl());
        out.printf("chart.showLegend(%s);", getShowLegend());
        out.printf("chart.stacked(%s);", getStacked());

        _labelAxis.composeScriptOn(out);
        _valueAxis.composeScriptOn(out);

        if ( hasClickAction() )
        {
            out.printf("chart.multibar.dispatch.on('elementClick', function(e)");
            out.printf("{");
            out.printf("Kmu.nvd3HandleClick(%s, e.data.data)", getClickAction().getKey());
            out.printf("});");
        }
    }

    protected abstract String getChartFunction();

    //##################################################
    //# convenience
    //##################################################

    public int countDistinctLabels()
    {
        return getDistinctLabels().size();
    }

    public KmSet<String> getDistinctLabels()
    {
        KmSet<String> labels = new KmSetImpl<>();

        for ( ScBarChartSet set : getDataSets() )
            for ( ScBarChartPoint point : set.getPoints() )
                labels.add(point.getLabel());

        return labels;
    }

}
