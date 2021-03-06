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

/**
 * I encapsulate the idea of a length of time, rather than a specific
 * time.  I am some number of hours, minutes, seconds.
 *
 * I may be either positive or negative.
 *
 * Durations are accurate to 1 second and have a maximum range of roughly
 * plus or minus 290 billion years.  Operations outside this range
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
    //# constants
    //##################################################

    public static final KmDuration ZERO = fromSeconds(0);

    //##################################################
    //# instance creation
    //##################################################

    public static KmDuration fromHoursMinutesSeconds(int hh, int mm, int ss)
    {
        long total;
        total = ss;
        total += (long)mm * SECONDS_PER_MINUTE;
        total += (long)hh * SECONDS_PER_HOUR;

        return fromSeconds(total);
    }

    public static KmDuration fromHoursMinutes(int hh, int mm)
    {
        return fromHoursMinutesSeconds(hh, mm, 0);
    }

    public static KmDuration fromHours(int hh)
    {
        return fromHoursMinutes(hh, 0);
    }

    public static KmDuration fromSeconds(long ss)
    {
        return new KmDuration(ss);
    }

    public static KmDuration fromDays(int dd)
    {
        return fromHours(dd * 24);
    }

    public static KmDuration fromString(String s)
    {
        if ( s == null )
            return null;

        s = s.toLowerCase();

        String sDays;
        String sTime;

        String daysToken = "days";
        int i = s.indexOf(daysToken);

        if ( i < 0 )
        {
            sDays = "0";
            sTime = s;
        }
        else
        {
            sDays = s.substring(0, i);
            sTime = s.substring(i + daysToken.length());
        }

        Integer days = Kmu.parseInteger(sDays);
        KmTime time = KmTimeParser.parseTime(sTime);

        if ( days == null || time == null )
            return null;

        return ZERO.addDays(days).addTime(time);
    }

    //##################################################
    //# variables
    //##################################################

    private long _seconds;

    //##################################################
    //# constructor
    //##################################################

    private KmDuration(long seconds)
    {
        _seconds = seconds;
    }

    //==================================================
    //= accessing :: composite
    //==================================================

    public int getCompositeHour()
    {
        return (int)(_seconds % SECONDS_PER_DAY / SECONDS_PER_HOUR);
    }

    public int getCompositeMinute()
    {
        return (int)(_seconds % SECONDS_PER_HOUR / SECONDS_PER_MINUTE);
    }

    public int getCompositeSecond()
    {
        return (int)(_seconds % SECONDS_PER_MINUTE);
    }

    //==================================================
    //= accessing :: totals (int)
    //==================================================

    /**
     * Approximated based on 365 days per non-leap year.
     */
    public int getTotalYears()
    {
        return (int)(_seconds / SECONDS_PER_YEAR_APPROXIMATE);
    }

    /**
     * Approximated based on 12 months per non-leap year.
     */
    public int getTotalMonths()
    {
        return (int)(_seconds / SECONDS_PER_MONTH_APPROXIMATE);
    }

    public int getTotalDays()
    {
        return (int)(_seconds / SECONDS_PER_DAY);
    }

    public int getTotalWeeks()
    {
        return (int)(_seconds / SECONDS_PER_WEEK);
    }

    public int getTotalHours()
    {
        return (int)(_seconds / SECONDS_PER_HOUR);
    }

    public int getTotalMinutes()
    {
        return (int)(_seconds / SECONDS_PER_MINUTE);
    }

    public int getTotalSeconds()
    {
        return (int)_seconds;
    }

    //==================================================
    //= accessing :: totals (double)
    //==================================================

    public double getTotalDaysExact()
    {
        return (double)_seconds / SECONDS_PER_DAY;
    }

    public double getTotalHoursExact()
    {
        return (double)_seconds / SECONDS_PER_HOUR;
    }

    public double getTotalMinutesExact()
    {
        return (double)_seconds / SECONDS_PER_MINUTE;
    }

    public double getTotalSecondsExact()
    {
        return _seconds;
    }

    //##################################################
    //# math :: addition
    //##################################################

    public KmDuration add(KmDuration d)
    {
        return fromSeconds(_seconds + d._seconds);
    }

    public KmDuration addDays(int dd)
    {
        return addSeconds(dd * SECONDS_PER_DAY);
    }

    public KmDuration addTime(KmTime t)
    {
        return addSeconds(t.getTotalSeconds());
    }

    public KmDuration addHours(int hh)
    {
        return addSeconds(hh * SECONDS_PER_HOUR);
    }

    public KmDuration addMinutes(int mm)
    {
        return addSeconds(mm * SECONDS_PER_MINUTE);
    }

    public KmDuration addSeconds(int ss)
    {
        return fromSeconds(_seconds + ss);
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

    //==================================================
    //= math :: conversion
    //==================================================

    public KmDuration negate()
    {
        return fromSeconds(-_seconds);
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
        return _seconds == 0;
    }

    public boolean isPositive()
    {
        return _seconds > 0;
    }

    public boolean isNegative()
    {
        return _seconds < 0;
    }

    //##################################################
    //# equality
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmDuration) )
            return false;

        return ((KmDuration)e)._seconds == _seconds;
    }

    @Override
    public int hashCode()
    {
        return (int)_seconds;
    }

    //##################################################
    //# comparator
    //##################################################

    @Override
    public int compareTo(KmDuration e)
    {
        if ( _seconds < e._seconds )
            return -1;

        if ( _seconds > e._seconds )
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
        return format();
    }

    public String format()
    {
        return formatExact();
    }

    /**
     * Format a summary that includes only the most significant part.
     */
    public String formatEstimatedTime()
    {
        KmDuration abs = abs();
        String sign = isNegative()
            ? "-"
            : "";

        double dd = abs.getTotalDaysExact();
        double yy = dd / 365.25;
        if ( yy > 1 )
            return sign + formatUnit(yy, "year");

        double mm = dd / 30.4;
        if ( mm > 1 )
            return sign + formatUnit(mm, "month");

        if ( dd > 1 )
            return sign + formatUnit(dd, "day");

        double h = abs.getTotalHoursExact();
        if ( h > 1 )
            return sign + formatUnit(h, "hour");

        double m = abs.getTotalMinutesExact();
        if ( m > 1 )
            return sign + formatUnit(m, "minute");

        int s = abs.getTotalSeconds();
        return sign + formatUnit(s, "second");
    }

    /**
     * Format the total time an an estimate of work-hours.
     * This assumes 8 hours per day, 20 days per month.
     */
    public String formatEstimatedWork()
    {
        KmDuration abs = abs();
        String sign = isNegative()
            ? "-"
            : "";

        final double hoursPerDay = 8;
        final double hoursPerMonth = hoursPerDay * 20;
        final double hoursPerYear = hoursPerMonth * 12;

        double hours = abs.getTotalHoursExact();
        double yy = hours / hoursPerYear;
        if ( yy > 1 )
            return sign + formatUnit(yy, "year");

        double mm = hours / hoursPerMonth;
        if ( mm > 1 )
            return sign + formatUnit(mm, "month");

        double dd = hours / hoursPerDay;
        if ( dd > 1 )
            return sign + formatUnit(dd, "day");

        double h = hours;
        if ( h > 1 )
            return sign + formatUnit(h, "hour");

        double m = abs.getTotalMinutesExact();
        if ( m > 1 )
            return sign + formatUnit(m, "minute");

        int s = abs.getTotalSeconds();
        return sign + formatUnit(s, "second");
    }

    public String formatExact()
    {
        StringBuilder out = new StringBuilder();

        if ( isNegative() )
            out.append("-");

        KmDuration abs = abs();
        int dd = abs.getTotalDays();
        int hh = abs.getCompositeHour();
        int mm = abs.getCompositeMinute();
        int ss = abs.getCompositeSecond();

        if ( dd > 0 )
        {
            out.append(dd);
            out.append(" days ");
        }

        out.append(hh);
        out.append(":");
        out.append(_pad2(mm));
        out.append(":");
        out.append(_pad2(ss));

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

    private String formatUnit(double d, String unit)
    {
        String qty = Kmu.formatDouble(d, 1);

        if ( !qty.equals("1.0") )
            unit = Kmu.pluralize(unit);

        return Kmu.format("%s %s", qty, unit);
    }

}
