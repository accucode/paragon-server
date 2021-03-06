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
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.Kmu;

/**
 * I combine a date and time of day.
 * Instances are assumed to be immutable.
 */
public class KmTimestamp
    implements KmTimeConstantsIF, Comparable<KmTimestamp>, Serializable
{
    //##################################################
    //# constants
    //##################################################

    public static final KmTimestamp MINIMUM = KmTimestamp.fromYearMonthDay(1800, 1, 1);
    public static final KmTimestamp MAXIMUM = KmTimestamp.fromYearMonthDay(2100, 1, 1);

    //##################################################
    //# static convenience
    //##################################################

    public static KmDate getDateFor(KmTimestamp e)
    {
        return e == null
            ? null
            : e.getDate();
    }

    public static KmTime getTimeFor(KmTimestamp e)
    {
        return e == null
            ? null
            : e.getTime();
    }

    //##################################################
    //# instance creation
    //##################################################

    /**
     * Most clients should probably use KmClock.getNowUtc().
     */
    public static KmTimestamp nowUtc()
    {
        return fromInstant(UTC_WALL_CLOCK.instant());
    }

    public static KmTimestamp fromDateTime(KmDate d, KmTime t)
    {
        LocalDateTime e = d.toLocalDate().atTime(t.toLocalTime());
        return fromLocalDateTime(e);
    }

    public static KmTimestamp fromYearMonthDay(int year, int month, int day)
    {
        LocalDateTime e = LocalDateTime.of(year, month, day, 0, 0);
        return fromLocalDateTime(e);
    }

    //==================================================
    //= conversion :: instant
    //==================================================

    public static KmTimestamp fromInstant(Instant i)
    {
        LocalDateTime e = i.atZone(KmTimeZone.UTC.getZoneId()).toLocalDateTime();
        return fromLocalDateTime(e);
    }

    public Instant toInstant()
    {
        return _inner.atZone(KmTimeZone.UTC.getZoneId()).toInstant();
    }

    //==================================================
    //= conversion :: localDateTime
    //==================================================

    public static KmTimestamp fromLocalDateTime(LocalDateTime e)
    {
        return new KmTimestamp(e);
    }

    public LocalDateTime toLocalDateTime()
    {
        return _inner;
    }

    //==================================================
    //= conversion :: epoch ms
    //==================================================

    /**
     * Create a timestamp based on the number of milliseconds since the standard epoch.
     */
    public static KmTimestamp fromEpochMs(long ms)
    {
        Instant i = Instant.ofEpochMilli(ms);
        return fromInstant(i);
    }

    /**
     * Return the number of milliseconds since the standard epoch.
     */
    public long toEpochMs()
    {
        return toInstant().toEpochMilli();
    }

    //==================================================
    //= conversion :: epoch seconds
    //==================================================

    /**
     * Create a timestamp based on the number of milliseconds since the standard epoch.
     */
    public static KmTimestamp fromEpochSeconds(long secs)
    {
        Instant i = Instant.ofEpochSecond(secs);
        return fromInstant(i);
    }

    /**
     * Return the number of milliseconds since the standard epoch.
     */
    public int toEpochSeconds()
    {
        return (int)(toInstant().toEpochMilli() / 1000);
    }

    //==================================================
    //= conversion :: java date
    //==================================================

    public static KmTimestamp fromJavaDate(Date e)
    {
        return fromInstant(e.toInstant());
    }

    public Date toJavaDate()
    {
        return Date.from(toInstant());
    }

    //==================================================
    //= conversion :: java timestamp
    //==================================================

    public static KmTimestamp fromSqlTimestamp(Timestamp e)
    {
        return fromLocalDateTime(e.toLocalDateTime());
    }

    public Timestamp toSqlTimestamp()
    {
        return Timestamp.valueOf(toLocalDateTime());
    }

    //==================================================
    //= conversion :: MySql
    //==================================================

    /**
     * Fast conversions for use with MY SQL.
     * MySql must be in UTC timezone.
     * This is compatible with MySql unix_timestamp and from_unixtime.
     */
    public static KmTimestamp fromMySqlOrdinal(int i)
    {
        return fromEpochSeconds(i);
    }

    public int toMySqlOrdinal()
    {
        return toEpochSeconds();
    }

    //##################################################
    //# static :: time zone
    //##################################################

    public static KmTimestamp changeZone(KmTimestamp ts, KmTimeZone from, KmTimeZone to)
    {
        return ts == null
            ? null
            : ts.changeZone(from, to);
    }

    //##################################################
    //# variables
    //##################################################

    private LocalDateTime _inner;

    //##################################################
    //# constructor
    //##################################################

    private KmTimestamp(LocalDateTime e)
    {
        _inner = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDate getDate()
    {
        return KmDate.fromLocalDate(_inner.toLocalDate());
    }

    public boolean hasDate(KmDate e)
    {
        return getDate().equals(e);
    }

    public boolean hasDate(KmTimestamp e)
    {
        return hasDate(e.getDate());
    }

    public KmTime getTime()
    {
        return KmTime.fromLocalTime(_inner.toLocalTime());
    }

    public boolean hasTime(KmTime e)
    {
        return getTime().equals(e);
    }

    public KmTimestamp withTime(KmTime time)
    {
        return KmTimestamp.fromDateTime(getDate(), time);
    }

    //##################################################
    //# convenience
    //##################################################

    public int getYear()
    {
        return _inner.getYear();
    }

    public int getMonth()
    {
        return _inner.getMonthValue();
    }

    public int getDay()
    {
        return _inner.getDayOfMonth();
    }

    public KmWeekDay getWeekDay()
    {
        return KmWeekDay.fromDate(getDate());
    }

    public int getHour()
    {
        return _inner.getHour();
    }

    public int getHour12()
    {
        return getTime().getHour12();
    }

    public int getMinute()
    {
        return _inner.getMinute();
    }

    public int getSecond()
    {
        return _inner.getSecond();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmTimestamp getStartOfDay()
    {
        return getDate().getStartOfDay();
    }

    public KmTimestamp getEndOfDay()
    {
        return getDate().getEndOfDay();
    }

    public KmTimestamp getStartOfWeek()
    {
        return addWeek().getDate().getStartOfWeek().getStartOfDay();
    }

    public KmTimestamp getEndOfWeek()
    {
        return getDate().getEndOfWeek().getEndOfDay();
    }

    public KmTimestamp getStartOfMonth()
    {
        return getDate().getStartOfMonth().getStartOfDay();
    }

    public KmTimestamp getEndOfMonth()
    {
        return getDate().getEndOfMonth().getEndOfDay();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmTimestamp) )
            return false;

        KmTimestamp ts = (KmTimestamp)e;
        return getDate().equals(ts.getDate()) && getTime().equals(ts.getTime());
    }

    @Override
    public int hashCode()
    {
        return getDate().hashCode() ^ getTime().hashCode();
    }

    @Override
    public int compareTo(KmTimestamp e)
    {
        int i = getDate().compareTo(e.getDate());

        if ( i != 0 )
            return i;

        return getTime().compareTo(e.getTime());
    }

    //##################################################
    //# compare (convenience)
    //##################################################

    public boolean isBefore(KmTimestamp ts)
    {
        return compareTo(ts) < 0;
    }

    public boolean isBefore(KmTimestampRange ti)
    {
        if ( ti.hasStart() )
            return isBefore(ti.getStart());

        return false;
    }

    public boolean isNotBefore(KmTimestamp ts)
    {
        return !isBefore(ts);
    }

    public boolean isOnOrBefore(KmTimestamp ts)
    {
        return compareTo(ts) <= 0;
    }

    public boolean isAfter(KmTimestamp ts)
    {
        return compareTo(ts) > 0;
    }

    public boolean isOnOrAfter(KmTimestamp ts)
    {
        return compareTo(ts) >= 0;
    }

    public boolean isNotAfter(KmTimestamp ts)
    {
        return !isAfter(ts);
    }

    public boolean isBetweenInclusive(KmTimestampRange ti)
    {
        return isBetweenInclusive(ti.getStart(), ti.getEnd());
    }

    /**
     * Determine if I am between the start and end timestamp, also return true
     * if I am equal to either the start or end timestamp.
     */
    public boolean isBetweenInclusive(KmTimestamp start, KmTimestamp end)
    {
        if ( start != null && isBefore(start) )
            return false;

        if ( end != null && isAfter(end) )
            return false;

        return true;
    }

    /**
     * Determine if I am between the start and end timestamp; return false
     * if I am equal to either the start or end timestamp.
     */
    public boolean isBetweenExclusive(KmTimestamp start, KmTimestamp end)
    {
        if ( start != null && isOnOrBefore(start) )
            return false;

        if ( end != null && isOnOrAfter(end) )
            return false;

        return true;
    }

    public boolean isBeforeMonthDay(int mm, int dd)
    {
        return getDate().isBeforeMonthDay(mm, dd);
    }

    public boolean isAfterMonthDay(int mm, int dd)
    {
        return getDate().isAfterMonthDay(mm, dd);
    }

    public boolean isAfterNowUtc()
    {
        return isAfter(KmClock.getUtcTimestamp());
    }

    public boolean isBeforeNowUtc()
    {
        return isBefore(KmClock.getUtcTimestamp());
    }

    public boolean isNowUtc()
    {
        return equals(KmClock.getUtcTimestamp());
    }

    //##################################################
    //# add
    //##################################################

    public KmTimestamp addYear()
    {
        return addYears(1);
    }

    public KmTimestamp addYears(int i)
    {
        return fromLocalDateTime(_inner.plusYears(i));
    }

    public KmTimestamp addMonth()
    {
        return addMonths(1);
    }

    public KmTimestamp addMonths(int i)
    {
        return fromLocalDateTime(_inner.plusMonths(i));
    }

    public KmTimestamp addDay()
    {
        return addDays(1);
    }

    public KmTimestamp addDays(int i)
    {
        return fromLocalDateTime(_inner.plusDays(i));
    }

    public KmTimestamp addWeek()
    {
        return addWeeks(1);
    }

    public KmTimestamp addWeeks(int i)
    {
        return fromLocalDateTime(_inner.plusWeeks(i));
    }

    public KmTimestamp addHour()
    {
        return addHours(1);
    }

    public KmTimestamp addHours(long i)
    {
        return fromLocalDateTime(_inner.plusHours(i));
    }

    public KmTimestamp addMinutes()
    {
        return addMinutes(1);
    }

    public KmTimestamp addMinutes(long i)
    {
        return fromLocalDateTime(_inner.plusMinutes(i));
    }

    public KmTimestamp addSecond()
    {
        return addSeconds(1);
    }

    public KmTimestamp addSeconds(long i)
    {
        return fromLocalDateTime(_inner.plusSeconds(i));
    }

    public KmTimestamp addDuration(KmDuration d)
    {
        return addSeconds(d.getTotalSeconds());
    }

    //##################################################
    //# subtract
    //##################################################

    public KmTimestamp subtractDay()
    {
        return subtractDays(1);
    }

    public KmTimestamp subtractDays(int i)
    {
        return addDays(-i);
    }

    public KmTimestamp subtractWeek()
    {
        return subtractWeeks(1);
    }

    public KmTimestamp subtractWeeks(int i)
    {
        return addWeeks(-i);
    }

    public KmTimestamp subtractMonths(int i)
    {
        return addMonths(-i);
    }

    public KmTimestamp subtractYears(int i)
    {
        return addYears(-i);
    }

    public KmTimestamp subtractHour()
    {
        return subtractHours(1);
    }

    public KmTimestamp subtractHours(int i)
    {
        return addHours(-i);
    }

    public KmTimestamp subtractMinutes()
    {
        return subtractMinutes(1);
    }

    public KmTimestamp subtractMinutes(int i)
    {
        return addMinutes(-i);
    }

    public KmTimestamp subtractSecond()
    {
        return subtractSeconds(1);
    }

    public KmTimestamp subtractSeconds(int i)
    {
        return addSeconds(-i);
    }

    public KmTimestamp subtractDuration(KmDuration d)
    {
        return addDuration(d.negate());
    }

    //##################################################
    //# difference
    //##################################################

    /**
     * Return the duration from myself until the specified ts.
     * Returns a positive value if ts is AFTER myself.
     *
     * Durations may be positive or negative:
     *      today.getDurationUntil(tomorrow)  ==  1 day.
     *      today.getDurationUntil(yesterday) == -1 day.
     */
    public KmDuration getDurationUntil(KmTimestamp ts)
    {
        long end = ts.toEpochSeconds();
        long start = toEpochSeconds();
        long secs = end - start;

        return KmDuration.fromSeconds(secs);
    }

    /**
     * Return the duration since the specified ts, to myself.
     * Returns a positive value if ts is BEFORE myself.
     *
     * Durations may be positive or negative:
     *      today.getDurationSince(yesterday) ==  1 day.
     *      today.getDurationSince(tomorrow)  == -1 day.
     */
    public KmDuration getDurationSince(KmTimestamp ts)
    {
        return getDurationUntil(ts).negate();
    }

    /**
     * An alias for getDurationUntil(ts).
     *
     * This short-hand method assumes the common format start.diff(end), where
     * start is typically before the end.
     */
    public KmDuration diff(KmTimestamp ts)
    {
        return getDurationUntil(ts);
    }

    public int getMinutesSince(KmTimestamp ts)
    {
        return getDurationSince(ts).getTotalMinutes();
    }

    public int getSecondsSince(KmTimestamp ts)
    {
        return getDurationSince(ts).getTotalSeconds();
    }

    //##################################################
    //# convert
    //##################################################

    public KmTimestampRange toRange(KmTimestamp end)
    {
        KmTimestamp start = this;
        return KmTimestampRange.create(start, end);
    }

    public KmDuration toDuration(KmTimestamp end)
    {
        return toRange(end).toDuration();
    }

    //##################################################
    //# time zone
    //##################################################

    /**
     * Attempt to change from one local time zone to another.
     * If either the from or to zones are null, return myself (unchanged).
     */
    public KmTimestamp changeZone(KmTimeZone from, KmTimeZone to)
    {
        if ( from == null )
            return this;

        if ( to == null )
            return this;

        if ( from.equals(to) )
            return this;

        ZoneId fromId = from.getZoneId();
        ZoneId toId = to.getZoneId();

        Instant instant = _inner.atZone(fromId).toInstant();
        LocalDateTime local = instant.atZone(toId).toLocalDateTime();
        return fromLocalDateTime(local);
    }

    /**
     * Convert to utc, assuming I am in the application's local zone.
     */
    public KmTimestamp toUtc()
    {
        return changeZone(_localZone(), KmTimeZone.UTC);
    }

    /**
     * Convert to utc, assuming I am in the specified local zone.
     */
    public KmTimestamp toUtc(KmTimeZone fromLocalTz)
    {
        return changeZone(fromLocalTz, KmTimeZone.UTC);
    }

    /**
     * Convert to the application's local zone, assuming I am in utc.
     */
    public KmTimestamp toLocal()
    {
        return changeZone(KmTimeZone.UTC, _localZone());
    }

    /**
     * Convert to the specified local zone, assuming I am in utc.
     */
    public KmTimestamp toLocal(KmTimeZone localTz)
    {
        return changeZone(KmTimeZone.UTC, localTz);
    }

    private KmTimeZone _localZone()
    {
        return KmTimeZoneBridge.getInstance().getLocalZone();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return KmTimestampUtility.format_mm_dd_yy_hh_mm_ss_am(this);
    }

    public String format()
    {
        return ScFormatter.getInstance().formatTimestamp(this);
    }

    public String format(String s)
    {
        return KmTimestampUtility.format(this, s);
    }

    /**
     * Create an XSD format, for use with xml files.
     * E.g.: 2002-05-30T09:30:10Z
     */
    public String formatXsdUtc()
    {
        return KmTimestampUtility.formatXsdUtc(this);
    }

    /**
     * Create an ISO 8601 format (same as XSD?)
     * E.g.: 2002-05-30T09:30:10Z
     */
    public String formatIsoUtc()
    {
        return formatXsdUtc();
    }

    public String format_yyyymmdd_hhmmss()
    {
        return getDate().format_yyyymmdd() + "_" + getTime().format_hh24mmss();
    }

    public String format_m_d_yyyy_hh_mm_ss()
    {
        return getDate().format_m_d_yyyy() + " " + getTime().format_hh24_mm_ss();
    }

    public String format_m_d_yyyy_h_mm_am()
    {
        return getDate().format_m_d_yyyy() + " " + getTime().format_h_mm_am();
    }

    public String formatTimeAgoUtc()
    {
        return KmClock.getUtcTimestamp().diff(this).formatTimeAgo();
    }

    public String formatTimeAgoLocal()
    {
        return KmClock.getUtcTimestamp().toLocal().diff(this).formatTimeAgo();
    }

    public String formatLocal()
    {
        return KmTimestampUtility.formatLocalMessage(this);
    }

    public String formatLocalMessage()
    {
        return KmTimestampUtility.formatLocalMessage(this);
    }

    public String formatLocalMessage(KmTimeZone localTz)
    {
        return KmTimestampUtility.formatLocalMessage(this, localTz);
    }

    public String formatMySql()
    {
        return Kmu.format(
            "%s-%s-%s %s:%s:%s",
            getYear(),
            getMonth(),
            getDay(),
            getHour(),
            getMinute(),
            getSecond());
    }
}
