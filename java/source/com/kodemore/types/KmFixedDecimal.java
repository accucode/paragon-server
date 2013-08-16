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

package com.kodemore.types;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kodemore.utility.Kmu;

/**
 * I represent weight in kilograms. I provide utility methods for
 * displaying weights at the proper scale and formatting weight to
 * a database scale (independent of the display scale).
 *
 * IMPORTANT: This class should NOT be used when running calculations
 * against large sets of data, as I wrap the KmDecimal. See KmDecimal
 * for more details.
 *
 */
public abstract class KmFixedDecimal<T extends KmFixedDecimal<?>>
    implements Comparable<KmFixedDecimal<?>>, Cloneable, Serializable
{
    //##################################################
    //# constants (template keys)
    //##################################################

    public static final String VALUE_KEY          = "value";
    public static final String DATABASE_SCALE_KEY = "databaseScale";
    public static final String DISPLAY_SCALE_KEY  = "displayScale";

    //##################################################
    //# variables
    //##################################################

    private BigDecimal         _value;

    //##################################################
    //# constructor
    //##################################################

    public KmFixedDecimal(double value)
    {
        _value = newBigDecimal(value);
    }

    public KmFixedDecimal(int value)
    {
        _value = newBigDecimal(value);
    }

    protected KmFixedDecimal(BigDecimal value)
    {
        _value = newBigDecimal(value);
    }

    //##################################################
    //# support
    //##################################################

    protected abstract T getZero();

    protected abstract T newFixed(BigDecimal value);

    protected T newFixed(double value)
    {
        return newFixed(newBigDecimal(value));
    }

    protected T newFixed(int value)
    {
        return newFixed(newBigDecimal(value));
    }

    private BigDecimal newBigDecimal(double value)
    {
        return newBigDecimal(new BigDecimal(value));
    }

    private BigDecimal newBigDecimal(int value)
    {
        return newBigDecimal(new BigDecimal(value));
    }

    private BigDecimal newBigDecimal(BigDecimal value)
    {
        BigDecimal e = scale(value);
        validate(e);
        return e;
    }

    private void validate(BigDecimal e)
    {
        if ( e.precision() > getPrecision() )
            Kmu.fatal("%s exceeds maximum precision of %s.", e.toPlainString(), getPrecision());
    }

    private BigDecimal scale(BigDecimal e)
    {
        return e.setScale(getScale(), getRoundingMode());
    }

    //##################################################
    //# policy
    //##################################################

    public abstract int getPrecision();

    public abstract int getScale();

    public int getDisplayScale()
    {
        return getScale();
    }

    public RoundingMode getRoundingMode()
    {
        return RoundingMode.HALF_UP;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getIntValue()
    {
        return _value.intValue();
    }

    public double getDoubleValue()
    {
        return _value.doubleValue();
    }

    public BigDecimal getBigDecimal()
    {
        return _value;
    }

    //##################################################
    //# add
    //##################################################

    @SuppressWarnings("unchecked")
    public T add(T e)
    {
        if ( e == null )
            return (T)this;
        return newFixed(_value.add(e.getBigDecimal()));
    }

    public T add(double e)
    {
        return add(newFixed(e));
    }

    public T add(int e)
    {
        return add(newFixed(e));
    }

    //##################################################
    //# subtract
    //##################################################

    public T subtract(KmFixedDecimal<?> e)
    {
        return newFixed(_value.subtract(e.getBigDecimal()));
    }

    public T subtract(double e)
    {
        return subtract(newFixed(e));
    }

    public T subtract(int e)
    {
        return subtract(newFixed(e));
    }

    //##################################################
    //# multiply
    //##################################################

    public T multiply(KmFixedDecimal<?> e)
    {
        return newFixed(_value.multiply(e.getBigDecimal()));
    }

    public T multiply(double e)
    {
        return multiply(newFixed(e));
    }

    public T multiply(int e)
    {
        return multiply(newFixed(e));
    }

    public T negate()
    {
        return multiply(-1);
    }

    //##################################################
    //# divide
    //##################################################

    public T divide(KmFixedDecimal<?> e)
    {
        return newFixed(_value.divide(e.getBigDecimal(), getRoundingMode()));
    }

    public T divide(double e)
    {
        return divide(newFixed(e));
    }

    public T divide(int e)
    {
        return divide(newFixed(e));
    }

    //##################################################
    //# misc
    //##################################################

    @SuppressWarnings("unchecked")
    public T constrain(T min, T max)
    {
        if ( isLessThan(min) )
            return min;

        if ( isGreaterThan(max) )
            return max;

        return (T)this;
    }

    @SuppressWarnings("unchecked")
    public T getPositiveOrZero()
    {
        if ( isPositive() )
            return (T)this;
        return getZero();
    }

    @SuppressWarnings("unchecked")
    public T getMinimum(T e)
    {
        if ( isLessThan(e) )
            return (T)this;
        return e;
    }

    @SuppressWarnings("unchecked")
    public T getMaximum(T e)
    {
        if ( isGreaterThan(e) )
            return (T)this;
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof KmFixedDecimal<?>) )
            return false;

        KmFixedDecimal<?> e = (KmFixedDecimal<?>)o;
        return e._value.compareTo(_value) == 0;
    }

    @Override
    public int hashCode()
    {
        return getBigDecimal().intValue();
    }

    @Override
    public int compareTo(KmFixedDecimal<?> e)
    {
        return _value.compareTo(e.getBigDecimal());
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isZero()
    {
        return _value.signum() == 0;
    }

    public boolean isNotZero()
    {
        return !isZero();
    }

    public boolean isOne()
    {
        if ( isIntegerValue() )
            return _value.intValueExact() == 1;

        return false;
    }

    public boolean isNotOne()
    {
        return !isOne();
    }

    public boolean isNegative()
    {
        return _value.signum() == -1;
    }

    public boolean isPositive()
    {
        return _value.signum() == 1;
    }

    public boolean isNegativeOrZero()
    {
        return !isPositive();
    }

    public boolean isPositiveOrZero()
    {
        return !isNegative();
    }

    public boolean isGreaterThan(KmFixedDecimal<?> e)
    {
        return compareTo(e) > 0;
    }

    public boolean isGreaterThanOrEqualTo(KmFixedDecimal<?> e)
    {
        return compareTo(e) >= 0;
    }

    public boolean isLessThan(KmFixedDecimal<?> e)
    {
        return compareTo(e) < 0;
    }

    public boolean isLessThanOrEqualTo(KmFixedDecimal<?> e)
    {
        return compareTo(e) <= 0;
    }

    public boolean isIntegerValue()
    {
        try
        {
            getBigDecimal().intValueExact();
            return true;
        }
        catch ( ArithmeticException ex )
        {
            return false;
        }
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getDisplayString(getScale());
    }

    public String getDatabaseString()
    {
        return getDisplayString(getScale(), false);
    }

    public String getDisplayString()
    {
        return getDisplayString(getDisplayScale());
    }

    public String getDisplayString(int displayScale)
    {
        return getDisplayString(displayScale, true);
    }

    public String getDisplayString(int displayScale, boolean commas)
    {
        return format(displayScale, commas);
    }

    /**
     * Returns the display string for this decimal using the internal
     * scale, formated with commas.
     */
    public String format(int scale, boolean commas)
    {
        BigDecimal d = _value.setScale(scale, getRoundingMode());
        String s = d.toPlainString();
        int i = s.indexOf(".");

        if ( i <= 0 )
            return s;

        if ( !commas )
            return s;

        boolean isNegative = s.startsWith("-");
        String prefix = isNegative
            ? s.substring(1, i)
            : s.substring(0, i);
        StringBuilder sb = new StringBuilder(prefix);
        sb.reverse();
        int x = 3;
        while ( x < sb.length() )
        {
            sb.insert(x, ',');
            x += 4;
        }
        sb.reverse();

        s = sb.toString() + s.substring(i);
        if ( isNegative )
            s = "-" + s;
        return s;
    }

}
