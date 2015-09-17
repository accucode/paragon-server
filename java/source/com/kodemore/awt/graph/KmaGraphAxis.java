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

package com.kodemore.awt.graph;

public class KmaGraphAxis
{
    //##################################################
    //# variables
    //##################################################

    private boolean                  _visible;
    private KmaGraphStyledText       _title;
    private KmaGraphNumericTextStyle _labelStyle;

    private double _minimum;
    private double _maximum;
    private double _minimumLabel;
    private double _maximumLabel;

    private double _majorUnits;
    private double _minorUnits;

    private KmaGraphLineStyle _majorLineStyle;
    private KmaGraphLineStyle _minorLineStyle;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphAxis()
    {
        _visible = true;
        _title = new KmaGraphStyledText();
        _labelStyle = new KmaGraphNumericTextStyle();
        _majorUnits = 10;
        _minorUnits = 1;
        _minimum = 0;
        _maximum = 0;
        _minimumLabel = Double.NaN;
        _maximumLabel = Double.NaN;
        _majorLineStyle = new KmaGraphLineStyle();
        _minorLineStyle = new KmaGraphLineStyle();
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean isVisible()
    {
        return _visible;
    }

    public void beVisible()
    {
        beVisible(true);
    }

    public void beVisible(boolean e)
    {
        _visible = e;
    }

    public KmaGraphStyledText getTitle()
    {
        return _title;
    }

    public void setTitle(KmaGraphStyledText e)
    {
        _title = e;
    }

    public KmaGraphNumericTextStyle getLabelStyle()
    {
        return _labelStyle;
    }

    public void setLabelStyle(KmaGraphNumericTextStyle e)
    {
        _labelStyle = e;
    }

    public double getMajorUnits()
    {
        return _majorUnits;
    }

    public void setMajorUnits(double e)
    {
        _majorUnits = e;
    }

    public double getMinorUnits()
    {
        return _minorUnits;
    }

    public void setMinorUnits(double e)
    {
        _minorUnits = e;
    }

    public double getMinimum()
    {
        return _minimum;
    }

    public void setMinimum(double e)
    {
        _minimum = e;
    }

    public double getMaximum()
    {
        return _maximum;
    }

    public void setMaximum(double e)
    {
        _maximum = e;
    }

    public double getMinimumLabel()
    {
        return _minimumLabel;
    }

    public void setMinimumLabel(double e)
    {
        _minimumLabel = e;
    }

    public boolean hasMinimumLabel()
    {
        return !Double.isNaN(_minimumLabel);
    }

    public void clearMinimumLabel()
    {
        _minimumLabel = Double.NaN;
    }

    public double getMaximumLabel()
    {
        return _maximumLabel;
    }

    public void setMaximumLabel(double e)
    {
        _maximumLabel = e;
    }

    public boolean hasMaximumLabel()
    {
        return !Double.isNaN(_maximumLabel);
    }

    public void clearMaximumLabel()
    {
        _maximumLabel = Double.NaN;
    }

    public KmaGraphLineStyle getMajorLineStyle()
    {
        return _majorLineStyle;
    }

    public void setMajorLineStyle(KmaGraphLineStyle e)
    {
        _majorLineStyle = e;
    }

    public KmaGraphLineStyle getMinorLineStyle()
    {
        return _minorLineStyle;
    }

    public void setMinorLineStyle(KmaGraphLineStyle e)
    {
        _minorLineStyle = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public double getMajorDivisions()
    {
        return (getMaximum() - getMinimum()) / getMajorUnits();
    }

    public boolean isLabelVisible(double x)
    {
        if ( Double.isNaN(x) )
            return false;

        if ( x < getMinimum() )
            return false;

        if ( x > getMaximum() )
            return false;

        if ( hasMinimumLabel() && x < getMinimumLabel() )
            return false;

        if ( hasMaximumLabel() && x > getMaximumLabel() )
            return false;

        return true;
    }
}
