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
import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

/**
 * I represent a time of day; e.g.: 2:12 pm.
 * Instances are assumed to be immutable.
 */
public class KmTime
    implements KmTimeConstantsIF, Comparable<KmTime>, Serializable
{
    //##################################################
    //# constants
    //##################################################

    /**
     * Midnight.
     */
    public static final KmTime MIDNIGHT = fromHour(0);

    //##################################################
    //# instance creation :: now
    //##################################################

    public static KmTime nowUtc()
    {
        return fromInstant(UTC_WALL_CLOCK.instant());
    }

    //==================================================
    //= creation :: from hh:mm:ss
    //==================================================

    public static KmTime fromHourMinuteSecond(int hh, int mm, int ss)
    {
        return fromLocalTime(LocalTime.of(hh, mm, ss));
    }

    public static KmTime fromHourMinute(int hh, int mm)
    {
        return fromHourMinuteSecond(hh, mm, 0);
    }

    public static KmTime fromHour(int hh)
    {
        return fromHourMinuteSecond(hh, 0, 0);
    }

    //==================================================
    // conversion :: instant
    //==================================================

    /**
     * Convert from a java.time.Instant.
     */
    public static KmTime fromInstant(Instant i)
    {
        LocalTime e = i.atZone(KmTimeZone.UTC.getZoneId()).toLocalTime();
        return new KmTime(e);
    }

    /**
     * Convert to a java.time.Instant.
     */
    public Instant toInstant(KmDate e)
    {
        return _inner.atDate(e.toLocalDate()).atZone(KmTimeZone.UTC.getZoneId()).toInstant();
    }

    //==================================================
    //= conversion :: sql time
    //==================================================

    /**
     * Convert a java.util.Date based on the UTC time zone.
     */
    public static KmTime fromSqlTime(Time e)
    {
        return e == null
            ? null
            : KmTime.fromLocalTime(e.toLocalTime());
    }

    /**
     * Return a java.util.Date corresponding to the start of my day, in UTC.
     */
    public Time toSqlTime()
    {
        return Time.valueOf(_inner);
    }

    //==================================================
    //= conversion :: seconds
    //==================================================

    public static KmTime fromDaySeconds(int secs)
    {
        return fromLocalTime(LocalTime.ofSecondOfDay(secs));
    }

    public int toDaySeconds()
    {
        return _inner.toSecondOfDay();
    }

    //==================================================
    //= conversion :: ms
    //==================================================

    public static KmTime fromDayMs(int ms)
    {
        return fromDaySeconds(ms / 1000);
    }

    public int toDayMs()
    {
        return _inner.toSecondOfDay() * 1000;
    }

    //==================================================
    //= conversion :: local time
    //==================================================

    public static KmTime fromLocalTime(LocalTime e)
    {
        return new KmTime(e);
    }

    public LocalTime toLocalTime()
    {
        return _inner;
    }

    //==================================================
    //= conversion :: MySql
    //==================================================

    /**
     * Used to fast time conversion with my sql.
     * Returns the number of seconds since midnight.
     */
    public int toMySqlOrdinal()
    {
        return getTotalSeconds();
    }

    public static KmTime fromMySqlOrdinal(int secs)
    {
        return fromDaySeconds(secs);
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The internal implementation relies on java.time.LocalTime.
     */
    private LocalTime _inner;

    //##################################################
    //# constructor
    //##################################################

    private KmTime(LocalTime e)
    {
        _inner = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public int getHour()
    {
        return _inner.getHour();
    }

    public int getHour12()
    {
        int i = getHour() % 12;
        return i == 0
            ? 12
            : i;
    }

    public int getMinute()
    {
        return _inner.getMinute();
    }

    public int getSecond()
    {
        return _inner.getSecond();
    }

    public int getTotalSeconds()
    {
        return _inner.toSecondOfDay();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isAm()
    {
        return getHour() < 12;
    }

    public boolean isPm()
    {
        return !isAm();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmTime) )
            return false;

        return ((KmTime)e)._inner.equals(_inner);
    }

    @Override
    public int hashCode()
    {
        return _inner.hashCode();
    }

    @Override
    public int compareTo(KmTime e)
    {
        return _inner.compareTo(e._inner);
    }

    //##################################################
    //# compare (convenience)
    //##################################################

    public boolean isBefore(KmTime d)
    {
        return compareTo(d) < 0;
    }

    public boolean isOnOrBefore(KmTime d)
    {
        return compareTo(d) <= 0;
    }

    public boolean isAfter(KmTime d)
    {
        return compareTo(d) > 0;
    }

    public boolean isOnOrAfter(KmTime d)
    {
        return compareTo(d) >= 0;
    }

    /**
     * Determine if I am between the start and end time, also return true
     * if I am equal to either the start or end time.
     */
    public boolean isBetweenInclusive(KmTime start, KmTime end)
    {
        if ( start != null && isBefore(start) )
            return false;

        if ( end != null && isAfter(end) )
            return false;

        return true;
    }

    /**
     * Determine if I am between the start and end time; return false
     * if I am equal to either the start or end time.
     */
    public boolean isBetweenExclusive(KmTime start, KmTime end)
    {
        if ( start != null && isOnOrBefore(start) )
            return false;

        if ( end != null && isOnOrAfter(end) )
            return false;

        return true;
    }

    /**
     * Return the duration from myself until the specified time.
     *
     * The result will be positive if t is after myself, and
     * negative if t is before myself.
     */
    public KmDuration getDurationUntil(KmTime t)
    {
        long start = getTotalSeconds();
        long end = t.getTotalSeconds();
        long secs = end - start;

        return KmDuration.fromSeconds(secs);
    }

    /**
     * An alias for getDurationUntil(t).
     */
    public KmDuration diff(KmTime t)
    {
        return getDurationUntil(t);
    }

    //##################################################
    //# with
    //##################################################

    public KmTime withHour(int i)
    {
        return fromLocalTime(_inner.withHour(i));
    }

    public KmTime withMinute(int i)
    {
        return fromLocalTime(_inner.withMinute(i));
    }

    public KmTime withSecond(int i)
    {
        return fromLocalTime(_inner.withSecond(i));
    }

    //##################################################
    //# add
    //##################################################

    public KmTime addHour()
    {
        return addHours(1);
    }

    public KmTime addHours(int i)
    {
        return fromLocalTime(_inner.plusHours(i));
    }

    public KmTime addMinute()
    {
        return addMinutes(1);
    }

    public KmTime addMinutes(long i)
    {
        return fromLocalTime(_inner.plusMinutes(i));
    }

    public KmTime addSecond()
    {
        return addSeconds(1);
    }

    public KmTime addSeconds(long i)
    {
        return fromLocalTime(_inner.plusSeconds(i));
    }

    public KmTime addDuration(KmDuration e)
    {
        return fromLocalTime(_inner.plusSeconds(e.getTotalSeconds()));
    }

    //##################################################
    //# subtract
    //##################################################

    public KmTime subtractHour()
    {
        return addHours(-1);
    }

    public KmTime subtractHours(int i)
    {
        return addHours(-i);
    }

    public KmTime subtractMinute()
    {
        return addMinutes(-1);
    }

    public KmTime subtractMinutes(int i)
    {
        return addMinutes(-i);
    }

    public KmTime subtractSecond()
    {
        return addSeconds(-1);
    }

    public KmTime subtractSeconds(int i)
    {
        return addSeconds(-i);
    }

    //##################################################
    //# format
    //##################################################

    public String format(String s)
    {
        return KmTimeUtility.format(this, s);
    }

    public String format_h_mm_am()
    {
        return KmTimeUtility.format_h_mm_am(this);
    }

    public String format_h_mm_ss_am()
    {
        return KmTimeUtility.format_h_mm_ss_am(this);
    }

    public String format_hh24_mm_ss()
    {
        return KmTimeUtility.format_hh24_mm_ss(this);
    }

    public String format_hh24mmss()
    {
        return KmTimeUtility.format_hh24mmss(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return KmTimeUtility.format_h_mm_am(this);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmTime a = KmTime.fromHourMinuteSecond(1, 2, 3);
        System.out.println("    a: " + a);
        System.out.println("    h: " + a.withHour(0));
        System.out.println("    m: " + a.withMinute(0));
        System.out.println("    s: " + a.withSecond(0));

    }

}
