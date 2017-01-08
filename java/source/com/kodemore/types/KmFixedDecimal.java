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

package com.kodemore.types;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I represent decimal values with fixed scale, but unlimited
 * precision.
 *
 * IMPORTANT: This class should NOT be used when running calculations
 * against large sets of data, as I wrap the KmDecimal. See KmDecimal
 * for more details.
 */
public abstract class KmFixedDecimal<T extends KmFixedDecimal<?>>
    implements Comparable<KmFixedDecimal<?>>, Cloneable, Serializable
{
    //##################################################
    //# constants (template keys)
    //##################################################

    public static final String VALUE_KEY = "value";

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
        return scale(value);
    }

    private BigDecimal scale(BigDecimal e)
    {
        return e.setScale(getScale(), getRoundingMode());
    }

    //##################################################
    //# policy
    //##################################################

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
    //# conversion
    //##################################################

    public int toInt()
    {
        return _value.intValue();
    }

    public double toDouble()
    {
        return _value.doubleValue();
    }

    public BigDecimal toBigDecimal()
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
        return newFixed(_value.add(e.toBigDecimal()));
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
        return newFixed(_value.subtract(e.toBigDecimal()));
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
        return newFixed(_value.multiply(e.toBigDecimal()));
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
        return newFixed(_value.divide(e.toBigDecimal(), getRoundingMode()));
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
        return toBigDecimal().intValue();
    }

    @Override
    public int compareTo(KmFixedDecimal<?> e)
    {
        return _value.compareTo(e.toBigDecimal());
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
        if ( isInteger() )
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

    public boolean isInteger()
    {
        try
        {
            toBigDecimal().intValueExact();
            return true;
        }
        catch ( ArithmeticException ex )
        {
            return false;
        }
    }

    public boolean isPositiveInteger()
    {
        return isPositive() && isInteger();
    }

    public boolean isWholeNumber()
    {
        return isPositiveInteger() || isZero();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return format();
    }

    public String getDatabaseString()
    {
        return format(getScale(), false);
    }

    //##################################################
    //# format
    //##################################################

    public String format()
    {
        return format(getDisplayScale());
    }

    public String format(int scale)
    {
        return format(scale, true);
    }

    public String format(int scale, boolean commas)
    {
        return _format(_value, scale, commas);
    }

    //##################################################
    //# short format
    //##################################################

    /**
     * Format a short version of this value.
     * If the value is less than a 1000 use the standard scale.
     * Otherwise, attempt to reduce the value to thousands, millions,
     * etc; with the associated abbreviation.
     * Examples:
     *      12.3 => 12.3
     *      1,234.56 => 1.2 K
     *      12,345,678.90 => 12.3 M
     */
    public String formatShort()
    {
        BigDecimal K = new BigDecimal("1000");
        BigDecimal temp = getRoundedValue();

        if ( isLessThan(temp.abs(), K) )
        {
            String s;
            s = _format(temp, getScale());
            s = trimToMinimumScale(s);
            return s;
        }

        for ( String suffix : getSuffixes() )
        {
            temp = temp.divide(K);

            if ( isLessThan(temp.abs(), K) )
                return _format(temp, 1) + " " + suffix;
        }

        return "Overflow";
    }

    /**
     * The minimum number of digits to the right of the decimal
     * for use with the short format.
     */
    protected int getMinimumScale()
    {
        return 0;
    }

    private KmList<String> getSuffixes()
    {
        KmList<String> v;
        v = new KmList<>();
        v.add("K"); // thousand
        v.add("M"); // million
        v.add("B"); // billion
        v.add("T"); // trillion
        v.add("Q"); // quadrillion
        return v;
    }

    //##################################################
    //# utility
    //##################################################

    private String _format(BigDecimal source, int scale)
    {
        return _format(source, scale, true);
    }

    private String _format(BigDecimal source, int scale, boolean commas)
    {
        BigDecimal rounded = source.setScale(scale, getRoundingMode());
        String pattern = _getPattern(scale, commas);
        DecimalFormat format = new DecimalFormat(pattern);

        String value;
        value = format.format(rounded);
        value = trimToMinimumScale(value);

        String prefix = getFormatPrefix();
        String suffix = getFormatSuffix();

        return prefix + value + suffix;
    }

    private String _getPattern(int scale, boolean commas)
    {
        String s = commas
            ? ",##0"
            : "0";

        if ( scale > 0 )
            s += ".";

        return s + Kmu.repeat('0', scale);
    }

    private boolean isLessThan(BigDecimal a, BigDecimal b)
    {
        return a.compareTo(b) < 0;
    }

    private BigDecimal getRoundedValue()
    {
        return getRoundedValue(getScale());
    }

    private BigDecimal getRoundedValue(int scale)
    {
        return _value.setScale(scale, getRoundingMode());
    }

    protected String getFormatPrefix()
    {
        return "";
    }

    protected String getFormatSuffix()
    {
        return "";
    }

    private String trimToMinimumScale(String s)
    {
        if ( !s.contains(".") )
            return s;

        int min = getMinimumScale();
        while ( true )
        {
            int i = s.indexOf(".");
            int rem = s.length() - i - 1;
            if ( rem <= min )
                break;

            if ( !s.endsWith("0") )
                break;

            s = Kmu.removeSuffix(s, "0");
        }

        s = Kmu.removeSuffix(s, ".");
        return s;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmMoney m;
        m = new KmMoney(12234567.89);

        System.out.println(m.format());
        System.out.println(m.formatShort());
    }
}
