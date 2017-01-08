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

package com.kodemore.awt;

public class KmaIntegerField
    extends KmaTextField
{
    //##################################################
    //# variables
    //##################################################

    private Integer _value;
    private Integer _minimumValue;
    private Integer _maximumValue;

    //##################################################
    //# constructors
    //##################################################

    public KmaIntegerField()
    {
        setColumns(6);
        setAllowEmpty(false);
        setValue(0);
        clearMinimumValue();
        clearMaximumValue();
    }

    //##################################################
    //# accessing
    //##################################################

    public int getValue()
    {
        updateValue();
        return _getValue();
    }

    public Integer getValueObject()
    {
        if ( !hasValue() )
            return null;

        return getValue();
    }

    public int _getValue()
    {
        if ( _value == null )
            return 0;

        return _value.intValue();
    }

    public void setValue(Integer ii)
    {
        if ( ii == null )
            setNoValue();
        else
            setValue(ii.intValue());
    }

    public void setValue(int i)
    {
        _value = i;
        updateText();
    }

    public void setNoValue()
    {
        _value = null;
        updateText();
    }

    public int getMinimumValue()
    {
        if ( _minimumValue == null )
            return Integer.MIN_VALUE;

        return _minimumValue.intValue();
    }

    public void setMinimumValue(int i)
    {
        _minimumValue = i;
    }

    public boolean hasMinimumValue()
    {
        return _minimumValue != null;
    }

    public void clearMinimumValue()
    {
        _minimumValue = null;
    }

    public int getMaximumValue()
    {
        if ( _maximumValue == null )
            return Integer.MAX_VALUE;

        return _maximumValue.intValue();
    }

    public void setMaximumValue(int i)
    {
        _maximumValue = i;
    }

    public boolean hasMaximumValue()
    {
        return _maximumValue != null;
    }

    public void clearMaximumValue()
    {
        _maximumValue = null;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasValue()
    {
        updateValue();
        return _value != null;
    }

    //##################################################
    //# utility
    //##################################################

    public Integer getIntegerFor(String s)
    {
        try
        {
            return new Integer(s);
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    //##################################################
    //# subclass override
    //##################################################

    //==================================================
    //= update
    //==================================================

    @Override
    public void updateValue()
    {
        String s = getText();
        _value = getIntegerFor(s);
    }

    @Override
    public void updateText()
    {
        String s = "";
        if ( _value != null )
            s = String.valueOf(_getValue());
        setText(s);
    }

    @Override
    public boolean updateValueToRange()
    {
        String s = getText();
        if ( s.equals("") )
            return false;

        Integer ii = getIntegerFor(s);
        if ( ii == null )
            return false;

        int i = ii.intValue();

        if ( hasMinimumValue() && i < getMinimumValue() )
        {
            i = getMinimumValue();
            setValue(i);
            return true;
        }

        if ( hasMaximumValue() && i > getMaximumValue() )
        {
            i = getMaximumValue();
            setValue(i);
            return true;
        }

        return false;
    }

    //==================================================
    //= testing
    //==================================================

    @Override
    public boolean isTextValid(String s)
    {
        if ( s.equals("") )
            return getAllowEmpty();

        Integer ii = getIntegerFor(s);
        if ( ii == null )
            return false;

        int i = ii.intValue();
        if ( i < getMinimumValue() )
            return false;

        if ( i > getMaximumValue() )
            return false;

        return true;
    }

    //==================================================
    //= help
    //==================================================

    @Override
    public String getHelpTitle()
    {
        return "Integer Field";
    }

    @Override
    public String getHelpMessage()
    {
        String s = "Enter an integer.";

        if ( hasMinimumValue() )
            s += "\nMinimum: " + getMinimumValue();

        if ( hasMaximumValue() )
            s += "\nMaximum: " + getMaximumValue();

        return s;
    }

}
