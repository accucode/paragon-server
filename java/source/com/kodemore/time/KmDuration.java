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

package com.kodemore.time;

import java.io.Serializable;

import com.kodemore.utility.Kmu;

/**
 * I encapsulate the idea of a length of time, rather than a specific
 * time.  I am some number of hours, minutes, seconds, and ms.  
 * 
 * I may be either positive or negative.
 * 
 * Durations are accurate to 1 ms and have a maximum range of roughly 
 * plus or minus 290 million years.  Operations outside this range 
 * are undefined.
 * 
 * Durations are immutable.  Once created, the value of the duration cannot
 * be changed.  All of the ~math methods return a new instance rather than 
 * mutating the original instance.
 */
public class KmDuration
    implements KmTimeConstantsIF, Comparable<KmDuration>, Serializable
{
    //##################################################
    //# variables
    //##################################################

    private long _ordinal;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create a duration with zero (0) total ms.
     */
    public KmDuration()
    {
        this(0);
    }

    /**
     * Create a duration with the specified total ms.
     * The ms may be positive or negative (or zero).
     */
    public KmDuration(long ms)
    {
        _ordinal = ms;
    }

    //##################################################
    //# instance creation
    //##################################################

    public static KmDuration createDuration(int hh, int mm, int ss, int ms)
    {
        long total;
        total = ms;
        total += (long)ss * MS_PER_SECOND;
        total += (long)mm * MS_PER_MINUTE;
        total += (long)hh * MS_PER_HOUR;

        return new KmDuration(total);
    }

    public static KmDuration createDuration(int hh, int mm, int ss)
    {
        return createDuration(hh, mm, ss, 0);
    }

    public static KmDuration createDuration(int hh, int mm)
    {
        return createDuration(hh, mm, 0, 0);
    }

    public static KmDuration createDuration(int hh)
    {
        return createDuration(hh, 0, 0, 0);
    }

    //##################################################
    //# accessing
    //##################################################

    public long getOrdinal()
    {
        return _ordinal;
    }

    //==================================================
    //= accessing :: composite
    //==================================================

    public int getCompositeHour()
    {
        return (int)(_ordinal % MS_PER_DAY / MS_PER_HOUR);
    }

    public int getCompositeMinute()
    {
        return (int)(_ordinal % MS_PER_HOUR / MS_PER_MINUTE);
    }

    public int getCompositeSecond()
    {
        return (int)(_ordinal % MS_PER_MINUTE / MS_PER_SECOND);
    }

    public int getCompositeMs()
    {
        return (int)(_ordinal % MS_PER_SECOND);
    }

    //==================================================
    //= accessing :: totals (int)
    //==================================================

    /**
     * Approximated based on 365 days per non-leap year.
     */
    public int getTotalYears()
    {
        return (int)(_ordinal / MS_PER_YEAR_APPROXIMATE);
    }

    /**
     * Approximated based on 12 months per non-leap year.
     */
    public int getTotalMonths()
    {
        return (int)(_ordinal / MS_PER_MONTH_APPROXIMATE);
    }

    public int getTotalDays()
    {
        return (int)(_ordinal / MS_PER_DAY);
    }

    public int getTotalWeeks()
    {
        return (int)(_ordinal / MS_PER_WEEK);
    }

    public int getTotalHours()
    {
        return (int)(_ordinal / MS_PER_HOUR);
    }

    public int getTotalMinutes()
    {
        return (int)(_ordinal / MS_PER_MINUTE);
    }

    public int getTotalSeconds()
    {
        return (int)(_ordinal / MS_PER_SECOND);
    }

    public int getTotalMs()
    {
        return (int)_ordinal;
    }

    //==================================================
    //= accessing :: totals (double)
    //==================================================

    public double getTotalDaysExact()
    {
        return (double)_ordinal / MS_PER_DAY;
    }

    public double getTotalHoursExact()
    {
        return (double)_ordinal / MS_PER_HOUR;
    }

    public double getTotalMinutesExact()
    {
        return (double)_ordinal / MS_PER_MINUTE;
    }

    public double getTotalSecondsExact()
    {
        return (double)_ordinal / MS_PER_SECOND;
    }

    //##################################################
    //# math :: addition
    //##################################################

    public KmDuration add(KmDuration d)
    {
        return addMs(d.getOrdinal());
    }

    public KmDuration addDays(int dd)
    {
        long ms = (long)dd * MS_PER_DAY;
        return addMs(ms);
    }

    public KmDuration addHours(int hh)
    {
        long ms = (long)hh * MS_PER_HOUR;
        return addMs(ms);
    }

    public KmDuration addMinutes(int mm)
    {
        long ms = (long)mm * MS_PER_MINUTE;
        return addMs(ms);
    }

    public KmDuration addSeconds(int ss)
    {
        long ms = (long)ss * MS_PER_SECOND;
        return addMs(ms);
    }

    public KmDuration addMs(long ms)
    {
        return new KmDuration(_ordinal + ms);
    }

    //==================================================
    //= math :: subtraction
    //==================================================

    public KmDuration subtract(KmDuration d)
    {
        return add(d.negate());
    }

    public KmDuration subtractDays(int dd)
    {
        return addDays(-dd);
    }

    public KmDuration subtractHours(int hh)
    {
        return addHours(-hh);
    }

    public KmDuration subtractMinutes(int mm)
    {
        return addMinutes(-mm);
    }

    public KmDuration subtractSeconds(int ss)
    {
        return addSeconds(-ss);
    }

    public KmDuration subtractMs(int ms)
    {
        return addMs(-ms);
    }

    //==================================================
    //= math :: conversion
    //==================================================

    public KmDuration negate()
    {
        return new KmDuration(-_ordinal);
    }

    public KmDuration abs()
    {
        return isPositive()
            ? this
            : negate();
    }

    //==================================================
    //= math :: testing
    //==================================================

    public boolean isZero()
    {
        return _ordinal == 0;
    }

    public boolean isPositive()
    {
        return _ordinal > 0;
    }

    public boolean isNegative()
    {
        return _ordinal < 0;
    }

    //##################################################
    //# equality
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmDuration) )
            return false;

        return ((KmDuration)e)._ordinal == _ordinal;
    }

    @Override
    public int hashCode()
    {
        return (int)_ordinal;
    }

    //##################################################
    //# comparator
    //##################################################

    @Override
    public int compareTo(KmDuration e)
    {
        if ( _ordinal < e._ordinal )
            return -1;

        if ( _ordinal > e._ordinal )
            return 1;

        return 0;
    }

    //==================================================
    //= comparator :: helpers
    //==================================================

    public boolean isLessThan(KmDuration d)
    {
        return compareTo(d) < 0;
    }

    public boolean isLessThanOrEqualTo(KmDuration d)
    {
        return compareTo(d) <= 0;
    }

    public boolean isGreaterThan(KmDuration d)
    {
        return compareTo(d) > 0;
    }

    public boolean isGreaterThanOrEqualTo(KmDuration d)
    {
        return compareTo(d) >= 0;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();

        if ( isNegative() )
            out.append("-");

        KmDuration abs = abs();
        int dd = abs.getTotalDays();
        int hh = abs.getCompositeHour();
        int mm = abs.getCompositeMinute();
        int ss = abs.getCompositeSecond();
        int ms = abs.getCompositeMs();

        if ( dd > 0 )
        {
            out.append(dd);
            out.append(" ");
        }

        out.append(hh);
        out.append(":");
        out.append(_pad2(mm));
        out.append(":");
        out.append(_pad2(ss));

        if ( ms > 0 )
        {
            out.append(".");
            out.append(_pad3(ms));
        }

        return out.toString();
    }

    public String formatTimeAgo()
    {
        return new KmTimeAgoFormatter().format(this);
    }

    //##################################################
    //# private
    //##################################################

    private String _pad2(long i)
    {
        return Kmu.leftPad(i + "", 2, '0');
    }

    private String _pad3(long i)
    {
        return Kmu.leftPad(i + "", 3, '0');
    }
}
