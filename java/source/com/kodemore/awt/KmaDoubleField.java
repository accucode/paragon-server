/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.awt;

import java.text.DecimalFormat;

public class KmaDoubleField
    extends KmaTextField
{
    //##################################################
    //# variables
    //##################################################

    private Double        _value;
    private DecimalFormat _format;
    private Double        _minimumValue;
    private Double        _maximumValue;

    //##################################################
    //# constructors
    //##################################################

    public KmaDoubleField()
    {
        setColumns(6);
        setDecimalPlaces(2);
        setNoValue();
        setAllowEmpty(false);
        clearMinimumValue();
        clearMaximumValue();
    }

    //##################################################
    //# accessing
    //##################################################

    public double getValue()
    {
        updateValue();
        return _getValue();
    }

    public Double getValueObject()
    {
        if ( !hasValue() )
            return null;

        return getValue();
    }

    public double _getValue()
    {
        if ( _value == null )
            return 0;
        return _value.doubleValue();
    }

    public void setValue(Double d)
    {
        if ( d == null )
            setNoValue();
        else
            setValue(d.doubleValue());
    }

    public void setValue(double d)
    {
        if ( Double.isNaN(d) )
            setNoValue();
        else
            _value = d;
        updateText();
    }

    public void setNoValue()
    {
        _value = null;
        updateText();
    }

    public Double getDoubleFor(String s)
    {
        try
        {
            Number n = _format.parse(s);
            return n.doubleValue();
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    //##################################################
    //# min / max
    //##################################################

    public double getMinimumValue()
    {
        if ( _minimumValue == null )
            return Double.MIN_VALUE;
        return _minimumValue.doubleValue();
    }

    public void setMinimumValue(double d)
    {
        _minimumValue = d;
    }

    public void clearMinimumValue()
    {
        _minimumValue = null;
    }

    public boolean hasMinimumValue()
    {
        return _minimumValue != null;
    }

    public double getMaximumValue()
    {
        if ( _maximumValue == null )
            return Double.MAX_VALUE;

        return _maximumValue.doubleValue();
    }

    public void setMaximumValue(double d)
    {
        _maximumValue = d;
    }

    public void clearMaximumValue()
    {
        _maximumValue = null;
    }

    public boolean hasMaximumValue()
    {
        return _maximumValue != null;
    }

    //##################################################
    //# format
    //##################################################

    public void setFormat(String s)
    {
        _format = new DecimalFormat(s);
        updateValue();
        updateText();
    }

    public void setDecimalPlaces(int n)
    {
        setFormat(_getFormat(n));
    }

    public void setFormat(int decimals, boolean commas)
    {
        setFormat(_getFormat(decimals, commas));
    }

    public String _getFormat(int decimals)
    {
        return _getFormat(decimals, true);
    }

    public String _getFormat(int decimals, boolean commas)
    {
        if ( commas )
            return _getCommaFormat(decimals);
        return _getNoCommaFormat(decimals);
    }

    public String _getNoCommaFormat(int n)
    {
        if ( n == 0 )
            return "0";
        StringBuilder sb = new StringBuilder(2 + n);
        sb.append("0.");
        for ( int i = 0; i < n; i++ )
            sb.append("0");
        return sb.toString();
    }

    public String _getCommaFormat(int n)
    {
        if ( n == 0 )
            return "#,##0";
        StringBuilder sb = new StringBuilder(6 + n);
        sb.append("#,##0.");
        for ( int i = 0; i < n; i++ )
            sb.append("0");
        return sb.toString();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasValue()
    {
        updateValue();
        return _value != null;
    }

    //###########################################
    //##
    //##  SUBCLASS OVERRIDE
    //##
    //###########################################

    //##################################################
    //# update
    //##################################################

    @Override
    public void updateValue()
    {
        String s = getText();
        _value = getDoubleFor(s);
    }

    @Override
    public void updateText()
    {
        String s = "";
        if ( _value != null )
            s = _format.format(_getValue());
        setText(s);
    }

    @Override
    public boolean updateValueToRange()
    {
        String s = getText();
        if ( s.equals("") )
            return false;
        Double dd = getDoubleFor(s);
        if ( dd == null )
            return false;
        double d = dd.doubleValue();
        if ( hasMinimumValue() && d < getMinimumValue() )
        {
            d = getMinimumValue();
            setValue(d);
            return true;
        }
        if ( hasMaximumValue() && d > getMaximumValue() )
        {
            d = getMaximumValue();
            setValue(d);
            return true;
        }
        return false;
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isTextValid(String s)
    {
        if ( s.equals("") )
            return getAllowEmpty();
        Double dd = getDoubleFor(s);
        if ( dd == null )
            return false;
        double d = dd.doubleValue();
        if ( hasMinimumValue() && d < getMinimumValue() )
            return false;
        if ( hasMaximumValue() && d > getMaximumValue() )
            return false;
        return true;
    }

    //##################################################
    //# help
    //##################################################

    @Override
    public String getHelpTitle()
    {
        return "Number Field";
    }

    @Override
    public String getHelpMessage()
    {
        String s = "Enter a decimal number.";
        if ( hasMinimumValue() )
            s += "\nMinimum: " + getMinimumValue();
        if ( hasMaximumValue() )
            s += "\nMaximum: " + getMaximumValue();
        return s;
    }

}
