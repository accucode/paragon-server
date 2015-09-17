/*
  Copyright (c) 2005-2014 www.kodemore.com

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
    private boolean _donut;

    /**
     * This is the data to be represented in the chart.  
     * Each "slice" must have a "key" (also the label)
     * and a "value".
     */
    private KmList<KmJsonMap> _slices;

    /**
     * The type of label on the slices.
     */
    private LabelType _labelType;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabelType(LabelType.KEY);

        _slices = new KmList<>();
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
        KmJsonMap slice;
        slice = new KmJsonMap();
        slice.setString("key", key);
        slice.setDouble("value", value);
        getSlices().add(slice);
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
    protected void initializeChart(KmStringBuilder out)
    {
        out.print("var chart;");
        out.print("chart = nv.models.pieChart();");
        out.print("chart.x(function(d) { return d.key });");
        out.print("chart.y(function(d) { return d.value });");
        out.printf("chart.labelType('%s');", getLabelType().getValue());
        out.printf("chart.donut(%s);", getDonut());
    }

    @Override
    protected void formatXAxis(KmStringBuilder out)
    {
        // none
    }

    @Override
    protected void formatYAxis(KmStringBuilder out)
    {
        // none
    }
}
