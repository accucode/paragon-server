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

package com.kodemore.time;

import java.io.Serializable;

import com.kodemore.utility.Kmu;

public class KmUnitDuration
    implements KmTimeConstantsIF, Serializable
{
    //##################################################
    //# constants
    //##################################################

    public static final int PRECISION = 2;

    public static final KmUnitDuration ZERO = fromSeconds(0);

    //##################################################
    //# instance creation
    //##################################################

    public static KmUnitDuration fromSeconds(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Second);
    }

    public static KmUnitDuration fromMinutes(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Minute);
    }

    public static KmUnitDuration fromHours(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Hour);
    }

    public static KmUnitDuration fromDays(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Day);
    }

    public static KmUnitDuration fromWeeks(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Week);
    }

    public static KmUnitDuration fromMonths(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Month);
    }

    public static KmUnitDuration fromYears(double e)
    {
        return new KmUnitDuration(e, KmTimeUnit.Year);
    }

    //##################################################
    //# variables
    //##################################################

    private double     _value;
    private KmTimeUnit _unit;

    //##################################################
    //# constructor
    //##################################################

    public KmUnitDuration(double val, KmTimeUnit unit)
    {
        if ( unit == null )
            throw Kmu.newFatal("Unit can not be null.");

        _value = Kmu.round(val, PRECISION);
        _unit = unit;
    }

    //##################################################
    //# accessing
    //##################################################

    public double getValue()
    {
        return _value;
    }

    //==================================================
    //= accessing :: unit
    //==================================================

    public KmTimeUnit getUnit()
    {
        return _unit;
    }

    public String getUnitCode()
    {
        return getUnit().getCode();
    }

    //##################################################
    //# equality
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmUnitDuration) )
            return false;

        KmUnitDuration d = (KmUnitDuration)e;
        return Kmu.isEqual(d.getValue(), _value) && Kmu.isEqual(d.getUnit(), _unit);
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCodeFor(_unit, _value);
    }

    //##################################################
    //# convenience
    //##################################################

    public boolean isZero()
    {
        return getValue() == 0;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return format();
    }

    public String format()
    {
        String unit = _unit.formatLabelFor(_value);

        return isIntValue()
            ? Kmu.format("%s %s", (int)_value, unit)
            : Kmu.format("%s %s", _value, unit);
    }

    private boolean isIntValue()
    {
        return _value % 1 == 0;
    }

    //##################################################
    //# conversion
    //##################################################

    public int toSeconds()
    {
        KmTimeUnit unit = getUnit();
        switch ( unit )
        {
            case Second:
                return Kmu.round(getValue());

            case Minute:
                return Kmu.round(getValue() * SECONDS_PER_MINUTE);

            case Hour:
                return Kmu.round(getValue() * SECONDS_PER_HOUR);

            case Day:
                return Kmu.round(getValue() * SECONDS_PER_DAY);

            case Week:
                return Kmu.round(getValue() * SECONDS_PER_WEEK);

            case Month:
                return Kmu.round(getValue() * SECONDS_PER_MONTH_APPROXIMATE);

            case Year:
                return Kmu.round(getValue() * SECONDS_PER_YEAR_APPROXIMATE);
        }
        throw Kmu.newEnumError(unit);
    }
}
