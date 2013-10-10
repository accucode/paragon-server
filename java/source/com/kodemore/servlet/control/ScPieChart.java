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
import com.kodemore.json.KmJsonList;
import com.kodemore.json.KmJsonObject;
import com.kodemore.string.KmStringBuilder;

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

        //==================================================
        //= enum :: variables
        //==================================================

        private String _stringValue;

        //==================================================
        //= enum :: constructor
        //==================================================

        private LabelType(String stringValue)
        {
            setStringValue(stringValue);
        }

        //==================================================
        //= enum :: accessing
        //==================================================

        public String getStringValue()
        {
            return _stringValue;
        }

        public void setStringValue(String e)
        {
            _stringValue = e;
        }
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * Whether or not the chart should be represented as
     * a "donut", with the center cut out.
     */
    private boolean              _donut;

    /**
     * This is the data to be represented in the chart.  
     * Each "slice" must have a "key" (also the label)
     * and a "value".
     */
    private KmList<KmJsonObject> _slices;

    /**
     * The type of label on the slices.
     */
    private LabelType            _labelType;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabelType(LabelType.KEY);

        _slices = new KmList<KmJsonObject>();
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

    @Override
    protected KmJsonList formatData()
    {
        KmJsonList arr;
        arr = new KmJsonList();

        for ( KmJsonObject e : getSlices() )
            arr.addObject(e);

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
        out.printf("chart.labelType('%s');", getLabelType().getStringValue());
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
