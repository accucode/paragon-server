/*
  Copyright (c) 2005-2016 www.kodemore.com

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
import com.kodemore.json.KmJsonMap;
import com.kodemore.string.KmStringBuilder;

/**
 * This is a simple pie chart displaying several discrete data points.
 */
public class ScPieChart
    extends ScAbstractChart
{
    //##################################################
    //# enum
    //##################################################

    private enum LabelType
    {
        KEY("key"),
        PERCENT("percent"),
        VALUE("value");

        private String _value;

        private LabelType(String e)
        {
            _value = e;
        }

        public String getValue()
        {
            return _value;
        }
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * Whether or not the chart should be represented as
     * a "donut", with the center cut out.
     */
    private boolean           _donut;

    /**
     * This is the data to be represented in the chart.
     * Each "slice" must have a "key" (also the label)
     * and a "value".
     */
    private KmList<KmJsonMap> _slices;

    /**
     * The type of label on the slices.
     */
    private LabelType         _labelType;

    /**
     * If set, round the value to the specified number of decimals.
     */
    private Integer           _valueDecimals;

    //##################################################
    //# constructor
    //##################################################

    public ScPieChart()
    {
        _slices = new KmList<>();

        setLabelType(LabelType.KEY);
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
    //# label Type
    //##################################################

    public LabelType getLabelType()
    {
        return _labelType;
    }

    private void setLabelType(LabelType e)
    {
        _labelType = e;
    }

    /**
     * Slices are labeled with the data point's key
     */
    public void setLabelTypeKey()
    {
        setLabelType(LabelType.KEY);
    }

    /**
     * Slices are labeled with the data point's value
     */
    public void setLabelTypeValue()
    {
        setLabelType(LabelType.VALUE);
    }

    /**
     * Slices are labeled with the data point's percentage
     * of the whole
     */
    public void setLabelTypePercent()
    {
        setLabelType(LabelType.PERCENT);
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
    //# data (slices)
    //##################################################

    public KmList<KmJsonMap> getSlices()
    {
        return _slices;
    }

    public void setSlices(KmList<KmJsonMap> e)
    {
        _slices = e;
    }

    public void addSlice(KmJsonMap e)
    {
        getSlices().add(e);
    }

    public void addSlice(String key, double value)
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("key", key);
        e.setDouble("value", value);

        getSlices().add(e);
    }

    @Override
    protected KmJsonArray formatData()
    {
        KmJsonArray arr;
        arr = new KmJsonArray();

        for ( KmJsonMap e : getSlices() )
            arr.addMap(e);

        return arr;
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void initializeChartOn(KmStringBuilder out)
    {
        out.printf("var chart;");
        out.printf("chart = nv.models.pieChart();");
        out.printf("chart.x(function(d) { return d.key });");
        out.printf("chart.y(function(d) { return d.value });");

        if ( hasValueDecimals() )
            out.printf(
                "chart.valueFormat(function(d) { return Kmu.roundPrecise(d,%s) });",
                getValueDecimals());

        out.printf("chart.labelType('%s');", getLabelType().getValue());
        out.printf("chart.noData('No data available for chart.');");
        out.printf("chart.donut(%s);", getDonut());
    }

    @Override
    protected void formatXAxisOn(KmStringBuilder out)
    {
        // none
    }

    @Override
    protected void formatYAxisOn(KmStringBuilder out)
    {
        // none
    }
}
