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

package com.kodemore.servlet.control;

import com.kodemore.servlet.control.nvd3.ScBarChart;
import com.kodemore.string.KmStringBuilder;

/**
 * A bar chart that displays the bars horizontally.
 */
public class ScHorizontalBarChart
    extends ScBarChart
{
    //##################################################
    //# constants
    //##################################################

    private static final int PIXEL_HEIGHT_PER_LABEL = 18;

    //##################################################
    //# variables
    //##################################################

    /**
     * If true, show the numeric value next to the bar.
     * Default: false.
     */
    private boolean _showValues;

    /**
     * If set, format the values using this many places to the right of the decimal.
     * This affects the values displayed next to each bar, NOT the values on the axis.
     * This has no effect unless ShowValues is also enabled.
     */
    private Integer _valueScale;

    //##################################################
    //# constructor
    //##################################################

    public ScHorizontalBarChart()
    {
        // none
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
    //# value scale
    //##################################################

    public Integer getValueScale()
    {
        return _valueScale;
    }

    public void setValueScale(Integer e)
    {
        _valueScale = e;
    }

    public boolean hasValueScale()
    {
        return _valueScale != null;
    }

    //##################################################
    //# convenience
    //##################################################

    public void setHeightForLabels()
    {
        int n = countDistinctLabels();
        int px = PIXEL_HEIGHT_PER_LABEL;
        int h = n * px;

        style().height(h);
    }

    //##################################################
    //# script
    //##################################################

    @Override
    protected void composeSetupOn(KmStringBuilder out)
    {
        super.composeSetupOn(out);

        out.printf("chart.showValues(%s);", getShowValues());

        if ( hasValueScale() )
            out.printf("chart.valueFormat(d3.format(',.%sf'));", getValueScale());
    }

    @Override
    protected String getChartFunction()
    {
        return "multiBarHorizontalChart";
    }

}
