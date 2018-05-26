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

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.nvd3.ScCharts;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I represent a single axis (e.g.: x or y) on a chart.
 * I provide accessors for common attributes and the ability
 * to compose the pertinent javascript.
 *
 * This implements the Nvd3 javascript chart library.
 * http://nvd3.org/
 */
public class ScChartAxis
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Indicates whether this is an x or y axis.
     * This affects how the javascript is composed.
     */
    private boolean _x;

    //==================================================
    //= variables :: attributes
    //==================================================

    /**
     * If true, show the axis and its labels.
     * Default: true.
     */
    private boolean _visible;

    /**
     * The label to display outside of the axis.
     */
    private String _label;

    /**
     * The distance of the label away from the axis.
     * This is automatically adjusted for simple cases, but may need
     * to be adjusted manually in some cases; for example, if the
     * labels are rotated.
     */
    private Integer _labelDistance;

    /**
     * Rotates the value labels this many degrees clockwise.
     * This rotates, the values, not the main label of the axis.
     * This does not work for all axis.
     */
    private Integer _labelDegrees;

    /**
     * The number of decimal digits to display.
     */
    private Integer _scale;

    /**
     * If set, ensure that this value is include on the graph.
     * E.g.: often set to 0.
     * Note that this does not guarantee that the graph stops at this value.
     * If there are smaller values, the graph may be be extended to include them.
     */
    private Double _minimumValue;
    private Double _maximumValue;

    //##################################################
    //# constructor
    //##################################################

    public ScChartAxis()
    {
        _visible = true;
    }

    //##################################################
    //# x/y
    //##################################################

    public void setX()
    {
        _x = true;
    }

    public void setY()
    {
        _x = false;
    }

    //##################################################
    //# visible
    //##################################################

    public boolean getVisible()
    {
        return _visible;
    }

    public void setVisible(boolean e)
    {
        _visible = e;
    }

    //##################################################
    //# label
    //##################################################

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String e)
    {
        _label = e;
    }

    public boolean hasLabel()
    {
        return Kmu.hasValue(_label);
    }

    //##################################################
    //# label distance
    //##################################################

    public Integer getLabelDistance()
    {
        return _labelDistance;
    }

    public void setLabelDistance(Integer e)
    {
        _labelDistance = e;
    }

    public boolean hasLabelDistance()
    {
        return getLabelDistance() != null;
    }

    //##################################################
    //# label degrees
    //##################################################

    public Integer getLabelDegrees()
    {
        return _labelDegrees;
    }

    public void setLabelDegrees(Integer e)
    {
        _labelDegrees = e;
    }

    public boolean hasLabelDegrees()
    {
        return _labelDegrees != null;
    }

    //##################################################
    //# scale
    //##################################################

    public Integer getScale()
    {
        return _scale;
    }

    public void setScale(Integer e)
    {
        _scale = e;
    }

    public boolean hasScale()
    {
        return _scale != null;
    }

    //##################################################
    //# min value
    //##################################################

    public Double getMinimumValue()
    {
        return _minimumValue;
    }

    public void setMinimumValue(Double e)
    {
        _minimumValue = e;
    }

    public void setMinimumValue(Integer e)
    {
        setMinimumValue(Kmu.toDouble(e));
    }

    public boolean hasMinimumValue()
    {
        return _minimumValue != null;
    }

    //##################################################
    //# max value
    //##################################################

    public Double getMaximumValue()
    {
        return _maximumValue;
    }

    public void setMaximumValue(Double e)
    {
        _maximumValue = e;
    }

    public void setMaximumValue(Integer e)
    {
        setMaximumValue(Kmu.toDouble(e));
    }

    public boolean hasMaximumValue()
    {
        return _maximumValue != null;
    }

    //##################################################
    //# conversion
    //##################################################

    public void composeScriptOn(KmStringBuilder out)
    {
        composeShowScriptOn(out);
        composeAxisScriptOn(out);
        composeForceScriptOn(out);
    }

    private void composeShowScriptOn(KmStringBuilder out)
    {
        out.printf("chart.show%sAxis(%s);", formatXy().toUpperCase(), getVisible());
    }

    private void composeAxisScriptOn(KmStringBuilder out)
    {
        String prefix = Kmu.format("chart.%sAxis", formatXy());

        if ( hasLabel() )
            out.printf("%s.axisLabel('%s');", prefix, ScCharts.toSafeLabel(getLabel()));

        if ( hasLabelDistance() )
            out.printf("%s.axisLabelDistance(%s);", prefix, getLabelDistance());

        if ( hasScale() )
            out.printf("%s.tickFormat(d3.format(',.%sf'));", prefix, getScale());

        if ( hasLabelDegrees() )
            out.printf("%s.rotateLabels(%s);", prefix, getLabelDegrees());
    }

    private void composeForceScriptOn(KmStringBuilder out)
    {
        KmList<Double> v;
        v = new KmList<>();
        v.addNonNull(getMinimumValue());
        v.addNonNull(getMaximumValue());

        if ( !v.isEmpty() )
            out.printf("chart.force%s([%s]);", formatXy().toUpperCase(), v.join());
    }

    private String formatXy()
    {
        return _x
            ? "x"
            : "y";
    }

}
