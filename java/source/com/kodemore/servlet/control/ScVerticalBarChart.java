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
 * A bar chart that displays the bars vertically.
 */
public class ScVerticalBarChart
    extends ScBarChart
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If true, the labels along the x-axis are staggered vertically
     * so there is more room for long text.
     * Default: false.
     */
    private boolean _staggerLabels;

    /**
     * If true, the tooltip includes data from each set,
     * rather than only showing the one slice at a time.
     * Default: false.
     */
    private boolean _guideline;

    //##################################################
    //# constructor
    //##################################################

    public ScVerticalBarChart()
    {
        // none
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
    //# script
    //##################################################

    @Override
    protected void composeSetupOn(KmStringBuilder out)
    {
        super.composeSetupOn(out);

        out.printf("chart.staggerLabels(%s);", getStaggerLabels());
        out.printf("chart.useInteractiveGuideline(%s);", getGuideline());
        out.printf("chart.reduceXTicks(false);");
    }

    @Override
    protected String getChartFunction()
    {
        return "multiBarChart";
    }

}
