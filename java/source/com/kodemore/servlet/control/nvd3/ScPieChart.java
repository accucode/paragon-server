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
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmEnumIF;

/**
 * This is a simple pie chart displaying several discrete data points.
 */
public class ScPieChart
    extends ScAbstractChart
{
    //##################################################
    //# enum
    //##################################################

    /**
     * Used to determine how the client side library displays the labels.
     * Note that these codes are passed directly to the client library.
     */
    private enum LabelType
        implements KmEnumIF
    {
        /**
         * Slices are labeled with the data point's key.
         */
        key,

        /**
         * Slices are labeled with the data point's percentage of the whole.
         */
        percent,

        /**
         * Slices are labeled with the data point's value.
         */
        value;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * Whether or not the chart should be represented as
     * a "donut", with the center cut out.
     */
    private boolean _donut;

    /**
     * The type of label on the slices.
     */
    private LabelType _labelType;

    /**
     * If set, round the value to the specified number of decimals.
     */
    private Integer _valueDecimals;

    /**
     * If set, this action is called when the pie click is clicked.
     * The items 'key' is passed in data.getStringArgument().
     */
    private ScAction _clickAction;

    //==================================================
    //= variables :: reconfiguable (ScLocal)
    //==================================================

    /**
     * This is the data to be represented in the chart.
     * Each "slice" must have a "key" (also the label)
     * and a "value".
     */
    private ScLocalList<ScPieSlice> _slices;

    //##################################################
    //# constructor
    //##################################################

    public ScPieChart()
    {
        _slices = new ScLocalList<>();
        setLabelTypeKey();
    }

    //##################################################
    //# label type
    //##################################################

    private LabelType getLabelType()
    {
        return _labelType;
    }

    private void setLabelType(LabelType e)
    {
        _labelType = e;
    }

    public void setLabelTypeKey()
    {
        setLabelType(LabelType.key);
    }

    public void setLabelTypeValue()
    {
        setLabelType(LabelType.value);
    }

    public void setLabelTypePercent()
    {
        setLabelType(LabelType.percent);
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
    //# value decimals
    //##################################################

    public Integer getValueDecimals()
    {
        return _valueDecimals;
    }

    public void setValueDecimals(Integer e)
    {
        _valueDecimals = e;
    }

    public boolean hasValueDecimals()
    {
        return _valueDecimals != null;
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
        return getClickAction() != null;
    }

    //##################################################
    //# slices
    //##################################################

    private KmList<ScPieSlice> getSlices()
    {
        return _slices.getValue();
    }

    public void addSlice(ScPieSlice e)
    {
        _slices.add(e);
    }

    public ScPieSlice addSlice()
    {
        ScPieSlice e;
        e = new ScPieSlice();
        addSlice(e);
        return e;
    }

    public ScPieSlice addSlice(String label, double value)
    {
        ScPieSlice e;
        e = addSlice();
        e.setLabel(label);
        e.setValue(value);
        e.setData(label);
        return e;
    }

    @Override
    protected KmJsonArray formatDatum()
    {
        KmJsonArray arr;
        arr = new KmJsonArray();

        for ( ScPieSlice e : getSlices() )
            arr.addMap(e.toJson());

        return arr;
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void composeSetupOn(KmStringBuilder out)
    {
        out.printf("var chart;");
        out.printf("chart = nv.models.pieChart();");
        out.printf("chart.x(function(e) { return e.label });");
        out.printf("chart.y(function(e) { return e.value });");
        out.printf("chart.labelType('%s');", getLabelType().getCode());
        out.printf("chart.donut(%s);", getDonut());

        composeValueFormatOn(out);
        composeClickActionOn(out);
    }

    private void composeValueFormatOn(KmStringBuilder out)
    {
        if ( !hasValueDecimals() )
            return;

        int n = getValueDecimals();
        out.printf("chart.valueFormat(function(e){return Kmu.roundPrecise(e,%s)});", n);
    }

    private void composeClickActionOn(KmStringBuilder out)
    {
        if ( !hasClickAction() )
            return;

        out.printf("chart.pie.dispatch.on('elementClick',function(e)");
        out.printf("{");
        out.printf("Kmu.nvd3HandleClick(%s,e.data.data);", getClickAction().getKey());
        out.printf("});");
    }
}
