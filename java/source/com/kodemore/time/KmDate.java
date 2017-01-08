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

package com.kodemore.time;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Date;

import com.kodemore.types.KmDayFrequency;

/**
 * Support convenience methods for manipulating dates.
 * Instances are immutable.
 * Months, days, and day of week conform to ISO standards; e.g.: 1..12 for Jan..Dec.
 *
 * I was originally created as an alternative to java.util.Date.
 * The old Date implementations were difficult to use and also had
 * significant bugs and performance issues.  As of JDK 8, the new
 * LocalDate class resolves the majority of these historical issues.
 * My implementation has been updated and simplified to leverage the
 * new JDK LocalDate class.
 */
public class KmDate
    implements KmTimeConstantsIF, Comparable<KmDate>, Serializable
{
    //##################################################
    //# instance creation :: misc
    //##################################################

    /**
     * Create today, relative to the UTC clock.
     */
    public static KmDate todayUtc()
    {
        return fromInstant(UTC_WALL_CLOCK.instant());
    }

    /**
     * Return a specific date.  Jan 31, 2000 = create(2000, 1, 31);
     */
    public static KmDate fromYearMonthDay(int yy, int mm, int dd)
    {
        return fromLocalDate(LocalDate.of(yy, mm, dd));
    }

    //##################################################
    //# instance creation :: conversions
    //##################################################

    /**
     * Convert from a java.time.LocalDate.
     */
    public static KmDate fromLocalDate(LocalDate e)
    {
        return e == null
            ? null
            : new KmDate(e);
    }

    /**
     * Convert to a java.time.LocalDate.
     */
    public LocalDate toLocalDate()
    {
        return _inner;
    }

    //==================================================
    // conversion :: instant
    //==================================================

    /**
     * Convert from a java.time.Instant.
     */
    public static KmDate fromInstant(Instant i)
    {
        if ( i == null )
            return null;

        LocalDate e = i.atZone(KmTimeZone.UTC.getZoneId()).toLocalDate();
        return new KmDate(e);
    }

    /**
     * Convert to an java.time.Instant, assuming midnight UTC.
     */
    public Instant toInstant()
    {
        return _inner.atStartOfDay(KmTimeZone.UTC.getZoneId()).toInstant();
    }

    //==================================================
    //= conversion :: epoch days
    //==================================================

    /**
     * Create a date based on an offset from the standard epoch of Jan 1, 1970.
     * Values may be negative.
     */
    public static KmDate fromEpochDays(int i)
    {
        LocalDate e = LocalDate.ofEpochDay(i);
        return fromLocalDate(e);
    }

    /**
     * Return the number of days since the epoch of Jan 1, 1970.
     * Dates prior to 1970 will return a negative number.
     */
    public int toEpochDays()
    {
        return (int)_inner.getLong(ChronoField.EPOCH_DAY);
    }

    //==================================================
    //= conversion :: epoch ms
    //==================================================

    public static KmDate fromEpochMs(long ms)
    {
        int days = (int)(ms / MS_PER_DAY);
        return fromEpochDays(days);
    }

    public long toEpochMs()
    {
        return toEpochDays() * MS_PER_DAY;
    }

    //==================================================
    //= conversion :: java date
    //==================================================

    /**
     * Convert a java.util.Date based on the UTC time zone.
     */
    public static KmDate fromJavaDate(Date e)
    {
        // Using e.getTime is a bit of a hack.
        // But e.toInstant is not compatible with java.sql.Date.
        return e == null
            ? null
            : fromEpochMs(e.getTime());
    }

    /**
     * Return a java.util.Date corresponding to the start of my day, in UTC.
     */
    public Date toJavaDate()
    {
        return Date.from(_inner.atStartOfDay(KmTimeZone.UTC.getZoneId()).toInstant());
    }

    //==================================================
    //= conversion :: MySql
    //==================================================

    /**
     * Convert from a MySql from_days integer value.
     */
    public static KmDate fromMySqlOrdinal(int i)
    {
        return fromEpochDays(i - MY_SQL_EPOCH_DAY_OFFSET);
    }

    /**
     * Convert to a MySql from_days integer value.
     */
    public int toMySqlOrdinal()
    {
        return toEpochDays() + MY_SQL_EPOCH_DAY_OFFSET;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * We rely on java.time.LocalDate to provide the core implementation.
     */
    private LocalDate _inner;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create a date based on the number of days since 1800.
     */
    private KmDate(LocalDate e)
    {
        _inner = e;
    }

    //##################################################
    //# accessing
    //##################################################

    /**
     * Get the year.
     */
    public int getYear()
    {
        return _inner.getYear();
    }

    /**
     * Get the two digit year.  E.g.: 2013 returns 13
     */
    public int getShortYear()
    {
        return getYear() % 100;
    }

    /**
     * Get the month, 1..12.
     */
    public int getMonth()
    {
        return _inner.getMonthValue();
    }

    public String getMonthName()
    {
        return KmDateUtility.getMonthName(getMonth());
    }

    public String getMonthAbbreviation()
    {
        return KmDateUtility.getMonthAbbreviation(getMonth());
    }

    /**
     * Get the day [1..31].
     */
    public int getDay()
    {
        return _inner.getDayOfMonth();
    }

    /**
     * Set the day, using the current year and month.
     */
    public KmDate toDay(int dd)
    {
        return fromYearMonthDay(getYear(), getMonth(), dd);
    }

    public KmDate toMonth(int mm)
    {
        return fromYearMonthDay(getYear(), mm, getDay());
    }

    public KmDate toYear(int yy)
    {
        return fromYearMonthDay(yy, getMonth(), getDay());
    }

    //##################################################
    //# month edge
    //##################################################

    /**
     * Return the first day of the current month.
     */
    public KmDate getStartOfMonth()
    {
        return toDay(1);
    }

    public KmDate getStartOfNextMonth()
    {
        return getStartOfMonth().addMonth();
    }

    /**
     * Return the last day of the current month.
     */
    public KmDate getEndOfMonth()
    {
        return toDay(getDaysInMonth());
    }

    public boolean isStartOfMonth()
    {
        return getDay() == 1;
    }

    public boolean isEndOfMonth()
    {
        return getDay() == getDaysInMonth();
    }

    //##################################################
    //# year edge
    //##################################################

    /**
     * Return the first day of the current year.
     */
    public KmDate getStartOfYear()
    {
        return fromYearMonthDay(getYear(), 1, 1);
    }

    /**
     * Return the last day of the current month.
     */
    public KmDate getEndOfYear()
    {
        return fromYearMonthDay(getYear(), 12, 31);
    }

    public boolean isStartOfYear()
    {
        return getMonth() == 1 && getDay() == 1;
    }

    public boolean isEndOfYear()
    {
        return getMonth() == 12 && getDay() == 31;
    }

    //##################################################
    //# misc
    //##################################################

    /**
     * The number of days since Jan 1 of the current year, 1..366.
     */
    public int getDayOfYear()
    {
        return _inner.getDayOfYear();
    }

    /**
     * Return the number of days to the end of month, inclusive.
     * E.g.: On Jan 30, this returns 2.
     */
    public int getDaysToEndOfMonth()
    {
        return getDaysInMonth() - getDay() + 1;
    }

    //##################################################
    //# compare
    //##################################################

    /**
     * Determine if two dates are equal.
     */
    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmDate) )
            return false;

        return ((KmDate)e)._inner.equals(_inner);
    }

    /**
     * Get the hashcode for the date.
     */
    @Override
    public int hashCode()
    {
        return _inner.hashCode();
    }

    /**
     * Compare two dates.
     */
    @Override
    public int compareTo(KmDate e)
    {
        return _inner.compareTo(e._inner);
    }

    //##################################################
    //# compare (convenience)
    //##################################################

    /**
     * Determine if I am before the parameter.
     */
    public boolean isBefore(KmDate d)
    {
        return compareTo(d) < 0;
    }

    /**
     * Determine if I equal to or before the parameter.
     */
    public boolean isOnOrBefore(KmDate d)
    {
        return compareTo(d) <= 0;
    }

    /**
     * Determine if I am after the parameter.
     */
    public boolean isAfter(KmDate d)
    {
        return compareTo(d) > 0;
    }

    /**
     * Determine if I am equal to or after the parameter.
     */
    public boolean isOnOrAfter(KmDate d)
    {
        return compareTo(d) >= 0;
    }

    /**
     * Determine if I am between the start and end date, also return true
     * if I am equal to either the start or end date.
     */
    public boolean isBetweenInclusive(KmDate start, KmDate end)
    {
        if ( start != null && isBefore(start) )
            return false;

        if ( end != null && isAfter(end) )
            return false;

        return true;
    }

    /**
     * Determine if I am between the start and end date; return false
     * if I am equal to either the start or end date.
     */
    public boolean isBetweenExclusive(KmDate start, KmDate end)
    {
        if ( start != null && isOnOrBefore(start) )
            return false;

        if ( end != null && isOnOrAfter(end) )
            return false;

        return true;
    }

    public boolean isBeforeMonthDay(int mm, int dd)
    {
        if ( getMonth() < mm )
            return true;

        if ( getMonth() > mm )
            return false;

        return getDay() < dd;
    }

    public boolean isAfterMonthDay(int mm, int dd)
    {
        if ( getMonth() > mm )
            return true;

        if ( getMonth() < mm )
            return false;

        return getDay() > dd;
    }

    public boolean isFutureUtc()
    {
        return isAfter(todayUtc());
    }

    public boolean isPastUtc()
    {
        return isBefore(todayUtc());
    }

    public boolean isTodayUtc()
    {
        return equals(todayUtc());
    }

    //##################################################
    //# week
    //##################################################

    /**
     * Return the position of the week day, 1..7, Mon..Sun.
     * ISO-8601 Standard.
     */
    public int getWeekDayValue()
    {
        return _inner.getDayOfWeek().getValue();
    }

    public KmWeekDay getWeekDay()
    {
        return KmWeekDay.fromDate(this);
    }

    public KmDate getStartOfWeek()
    {
        KmDate d = this;

        while ( !d.isStartOfWeek() )
            d = d.subtractDay();

        return d;
    }

    public KmDate getEndOfWeek()
    {
        KmDate d = this;

        while ( !d.isEndOfWeek() )
            d = d.addDay();

        return d;
    }

    public boolean isStartOfWeek()
    {
        return getWeekDay().isFirstDay();
    }

    public boolean isEndOfWeek()
    {
        return getWeekDay().isLastDay();
    }

    /**
     * Return the most recent day, prior to myself, matching
     * the requested weekDay.
     */
    public KmDate getPreviousDayOfWeek(KmWeekDay day)
    {
        return getPreviousDayOfWeek(day, false);
    }

    /**
     * Return the closest date matching the requested week day.
     * Optionally include myself in the search.
     */
    public KmDate getPreviousDayOfWeek(KmWeekDay day, boolean includeToday)
    {
        if ( includeToday && isWeekDay(day) )
            return this;

        KmDate e = this;
        while ( true )
        {
            e = e.getPrevious();
            if ( e.isWeekDay(day) )
                return e;
        }
    }

    /**
     * Return the closest day, after myself, matching
     * the requested weekDay.
     */
    public KmDate getNextDayOfWeek(KmWeekDay day)
    {
        return getNextDayOfWeek(day, false);
    }

    /**
     * Return the closest day matching the requested weekDay.
     * Optionally include myself in the search.
     */
    public KmDate getNextDayOfWeek(KmWeekDay day, boolean includeToday)
    {
        if ( includeToday && isWeekDay(day) )
            return this;

        KmDate e = this;
        while ( true )
        {
            e = e.getNext();
            if ( e.isWeekDay(day) )
                return e;
        }
    }

    //##################################################
    //# week: days
    //##################################################

    public boolean isSunday()
    {
        return getWeekDay().isSunday();
    }

    public boolean isMonday()
    {
        return getWeekDay().isMonday();
    }

    public boolean isTuesday()
    {
        return getWeekDay().isTuesday();
    }

    public boolean isWednesday()
    {
        return getWeekDay().isWednesday();
    }

    public boolean isThursday()
    {
        return getWeekDay().isThursday();
    }

    public boolean isFriday()
    {
        return getWeekDay().isFriday();
    }

    public boolean isSaturday()
    {
        return getWeekDay().isSaturday();
    }

    public boolean isWeekDay(KmWeekDay e)
    {
        return getWeekDay() == e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    /**
     * Determine the number of days in the current month (and year).
     */
    public int getDaysInMonth()
    {
        return _inner.lengthOfMonth();
    }

    //##################################################
    //# math :: days
    //##################################################

    /**
     * Get the next day.
     */
    public KmDate addDay()
    {
        return addDays(1);
    }

    /**
     * Get a future date.  0=today, 1=tomorrow, etc...
     */
    public KmDate addDays(int i)
    {
        return i == 0
            ? this
            : fromLocalDate(_inner.plusDays(i));
    }

    /**
     * Move the previous day.
     */
    public KmDate subtractDay()
    {
        return subtractDays(1);
    }

    /**
     * Move back by some number of days.
     */
    public KmDate subtractDays(int i)
    {
        return addDays(-i);
    }

    //==================================================
    //= math :: weeks
    //==================================================

    /**
     * Add seven days to my date.
     */
    public KmDate addWeek()
    {
        return addWeeks(1);
    }

    /**
     * Add some number of weeks to the current date.
     */
    public KmDate addWeeks(int i)
    {
        return i == 0
            ? this
            : fromLocalDate(_inner.plusWeeks(i));
    }

    /**
     * Subtract seven days from my date.
     */
    public KmDate subtractWeek()
    {
        return subtractWeeks(1);
    }

    /**
     * Subtract some number of weeks from my date.
     */
    public KmDate subtractWeeks(int i)
    {
        return addWeeks(-i);
    }

    //==================================================
    //= math :: months
    //==================================================

    /**
     * Add one month to the current date.
     * Attempt to preserve the day, but ensure that the new day is valid for the new month.
     * E.g.: if the old date is 10/31, the new date would be 11/30
     */
    public KmDate addMonth()
    {
        return addMonths(1);
    }

    public KmDate addMonths(int i)
    {
        return i == 0
            ? this
            : fromLocalDate(_inner.plusMonths(i));
    }

    /**
     * Subtract one month from the current date.
     * Attempt to preserve the day, but ensure that the new day is valid for the new month.
     * E.g.: if the old date is 12/31, the new date would be 11/30
     */
    public KmDate subtractMonth()
    {
        return subtractMonths(1);
    }

    public KmDate subtractMonths(int i)
    {
        return addMonths(-i);
    }

    //==================================================
    //= math :: years
    //==================================================

    /**
     * Add n years to the current date.
     * Attempt to preserve the day, but ensure that the new day is valid for the new date.
     * E.g.: if the old date is 2/29/2004, the new date would be 2/28/2005
     */
    public KmDate addYears(int i)
    {
        return i == 0
            ? this
            : fromLocalDate(_inner.plusYears(i));
    }

    /**
     * Add one year to the current date.
     */
    public KmDate addYear()
    {
        return addYears(1);
    }

    /**
     * Subtract one year to the current date.
     */
    public KmDate subtractYear()
    {
        return addYears(-1);
    }

    //==================================================
    //= math :: duration
    //==================================================

    public KmDate addDuration(KmDuration e)
    {
        return addDays(e.getTotalDays());
    }

    public KmDate subtractDuration(KmDuration e)
    {
        return subtractDays(e.getTotalDays());
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDate getNext()
    {
        return addDay();
    }

    public KmDate getPrevious()
    {
        return subtractDay();
    }

    //##################################################
    //# difference
    //##################################################

    /**
     * Return the duration from myself until the specified ts.
     *
     * Durations may be positive or negative:
     *      today.getDurationUntil(tomorrow)  ==  1 day.
     *      today.getDurationUntil(yesterday) == -1 day.
     */
    public KmDuration getDurationUntil(KmDate d)
    {
        int start = toEpochDays();
        int end = d.toEpochDays();
        int days = end - start;

        return KmDuration.fromDays(days);
    }

    /**
     * An alias for getDurationUntil(d).
     */
    public KmDuration diff(KmDate d)
    {
        return getDurationUntil(d);
    }

    public int getDaysUntil(KmDate d)
    {
        return getDurationUntil(d).getTotalDays();
    }

    //##################################################
    //# conversion
    //##################################################

    public KmTimestamp getStartOfDay()
    {
        return KmTimestamp.fromDateTime(this, KmTime.MIDNIGHT);
    }

    public KmTimestamp getEndOfDay()
    {
        return getNext().getStartOfDay().subtractSecond();
    }

    public KmDateInterval toInterval(KmDate end)
    {
        return KmDateInterval.create(this, end);
    }

    public KmTimestamp toTimestamp()
    {
        return getStartOfDay();
    }

    public KmTimestampInterval toTimestampInterval()
    {
        return KmTimestampInterval.create(getStartOfDay(), getEndOfDay());
    }

    public KmTimestamp toTimestamp(KmTime time)
    {
        return KmTimestamp.fromDateTime(this, time);
    }

    //##################################################
    //# frequency
    //##################################################

    public boolean matchesFrequency(KmDayFrequency f)
    {
        if ( f == null )
            return false;

        if ( isMonday() && f.hasMonday() )
            return true;

        if ( isTuesday() && f.hasTuesday() )
            return true;

        if ( isWednesday() && f.hasWednesday() )
            return true;

        if ( isThursday() && f.hasThursday() )
            return true;

        if ( isFriday() && f.hasFriday() )
            return true;

        if ( isSaturday() && f.hasSaturday() )
            return true;

        if ( isSunday() && f.hasSunday() )
            return true;

        return false;
    }

    //##################################################
    //# format
    //##################################################

    /**
     * Format the date based using a common set of format codes.
     */
    public String format(String format)
    {
        return KmDateUtility.format(this, format);
    }

    /**
     * A convenience formatter.
     */
    public String format_mm_dd_yy()
    {
        return KmDateUtility.format_mm_dd_yy(this);
    }

    /**
     * A convenience formatter.
     */
    public String format_m_d()
    {
        return KmDateUtility.format_m_d(this);
    }

    /**
     * A convenience formatter.
     */
    public String format_mm_dd_yyyy()
    {
        return KmDateUtility.format_mm_dd_yyyy(this);
    }

    /**
     * A convenience formatter.
     */
    public String format_m_d_yyyy()
    {
        return KmDateUtility.format_m_d_yyyy(this);
    }

    public String format_yyyymmdd()
    {
        return KmDateUtility.format_yyyymmdd(this);
    }

    public String format_yyyymm()
    {
        return KmDateUtility.format_yyyymm(this);
    }

    public String format_yymmdd()
    {
        return KmDateUtility.format_yymmdd(this);
    }

    /**
     * Create an ISO 8601 format.
     * E.g.: 2002-05-30
     */
    public String formatIso()
    {
        return KmDateUtility.format_iso(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return format_mm_dd_yyyy();
    }

}
