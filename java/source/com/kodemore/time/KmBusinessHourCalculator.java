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
  THE SOFTWARE.S
*/

package com.kodemore.time;

import com.kodemore.utility.Kmu;

/**
 * A utility class to calculate future timestamps in business hours.
 * All timestamps are assumed to be in local time. It is the client's
 * responsibility to ensure that timestamps are converted from utc to local
 * before passing them into this calculator.
 *
 *
 * Hours, Minutes, and Seconds are all treated as business time, meaning their
 * duration is added to the starting time, skipping and non-business days or hours.
 * For example:
 *      Monday 1/29 4pm + 2 Hours = Tuesday 1/30 at 10am
 *      - or -
 *      Friday 1/26 4pm + 2 Hours = Monday 1/29 at 10am
 *
 *
 * Days, Weeks, and Months are added treated as whole units. Adding a business day to the
 * start time will result in the same time of day on the next business day. Similarly, adding a
 * week/month to the start time will result in the same time of day, during the same day of the
 * next week/month. If the result falls outside of business hours the start of the next business
 * day will be used.
 * For example:
 *      Thursday 1/18 4pm + 1 Week = Thursday 1/25 4pm
 *      - or -
 *      Thursday 1/18 4pm + 2 Days = Monday 1/22 9am
 */
public class KmBusinessHourCalculator
    implements KmTimeConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The policy determines the business hours to be used in calculations.
     * By default, the policy is Monday-Friday, 9am-5pm, with no holidays.
     */
    private KmBusinessHourPolicy _policy;

    //##################################################
    //# constructor
    //##################################################

    public KmBusinessHourCalculator()
    {
        _policy = KmBusinessHourPolicy.DEFAULT;
    }

    public KmBusinessHourCalculator(KmBusinessHourPolicy policy)
    {
        _policy = policy;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBusinessHourPolicy getPolicy()
    {
        return _policy;
    }

    public void setPolicy(KmBusinessHourPolicy e)
    {
        _policy = e;
    }

    //##################################################
    //# add
    //##################################################

    /**
     * Add a unit duration to the timestamp. The logic used depends on
     * the unit of the duration.
     *
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp add(KmTimestamp ts, KmUnitDuration duration)
    {
        validatePolicy();

        KmTimeUnit unit = duration.getUnit();
        switch ( unit )
        {
            case Second:
            case Minute:
            case Hour:
                return addAsSeconds(ts, duration);

            case Day:
                return addAsDays(ts, duration);

            case Week:
                return addAsWeeks(ts, duration);

            case Month:
                return addAsMonths(ts, duration);

            case Year:
                return addAsYears(ts, duration);
        }
        throw Kmu.newEnumError(unit);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addSeconds(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForAdd(ts);

        int secsUntilEnd = getSecsUntilEnd(ts);
        while ( i >= secsUntilEnd )
        {
            ts = findStartOfNextBusinessDay(ts);
            i = i - secsUntilEnd;
            secsUntilEnd = getSecsUntilEnd(ts);
        }

        return ts.addSeconds(i);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addMinutes(KmTimestamp ts, int i)
    {
        validatePolicy();

        int secs = i * SECONDS_PER_MINUTE;
        return addSeconds(ts, secs);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addHours(KmTimestamp ts, int i)
    {
        validatePolicy();

        int secs = i * SECONDS_PER_HOUR;
        return addSeconds(ts, secs);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addDays(KmTimestamp ts, int n)
    {
        validatePolicy();

        ts = ensureValidTimestampForAdd(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        for ( int i = 0; i < n; i++ )
            date = nextBusinessDay(date);

        return toValidTimestampForAdd(time, date);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addWeeks(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForAdd(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        date = date.addWeeks(i);

        return toValidTimestampForAdd(time, date);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addMonths(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForAdd(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        date = date.addMonths(i);

        return toValidTimestampForAdd(time, date);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp addYears(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForAdd(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        date = date.addYears(i);

        return toValidTimestampForAdd(time, date);
    }

    private KmTimestamp toValidTimestampForAdd(KmTime time, KmDate date)
    {
        KmTimestamp resultTs;
        resultTs = KmTimestamp.fromDateTime(date, time);
        resultTs = ensureValidTimestampForAdd(resultTs);
        return resultTs;
    }

    //##################################################
    //# subtract
    //##################################################

    /**
     * Subtract a unit duration to the timestamp. The logic used depends on
     * the unit of the duration.
     *
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtract(KmTimestamp ts, KmUnitDuration duration)
    {
        validatePolicy();

        KmTimeUnit unit = duration.getUnit();
        switch ( unit )
        {
            case Second:
            case Minute:
            case Hour:
                return subtractAsSeconds(ts, duration);

            case Day:
                return subtractAsDays(ts, duration);

            case Week:
                return subtractAsWeeks(ts, duration);

            case Month:
                return subtractAsMonths(ts, duration);

            case Year:
                return subtractAsYears(ts, duration);
        }
        throw Kmu.newEnumError(unit);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractSeconds(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForSubtract(ts);

        int secsFromStart = getSecsFromStart(ts);
        while ( i > secsFromStart )
        {
            ts = findEndOfPreviousBusinessDay(ts);
            i = i - secsFromStart;
            secsFromStart = getSecsFromStart(ts);
        }

        return ts.subtractSeconds(i);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractMinutes(KmTimestamp ts, int i)
    {
        validatePolicy();

        int secs = i * SECONDS_PER_MINUTE;
        return subtractSeconds(ts, secs);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractHours(KmTimestamp ts, int i)
    {
        validatePolicy();

        int secs = i * SECONDS_PER_HOUR;
        return subtractSeconds(ts, secs);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractDays(KmTimestamp ts, int n)
    {
        validatePolicy();

        ts = ensureValidTimestampForSubtract(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        for ( int i = 0; i < n; i++ )
            date = previousBusinessDay(date);

        return toValidTimestampForSubtract(time, date);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractWeeks(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForSubtract(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        date = date.subtractWeeks(i);

        return toValidTimestampForSubtract(time, date);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractMonths(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForSubtract(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        date = date.subtractMonths(i);

        return toValidTimestampForSubtract(time, date);
    }

    /**
     * @see KmBusinessHourCalculator
     */
    public KmTimestamp subtractYears(KmTimestamp ts, int i)
    {
        validatePolicy();

        ts = ensureValidTimestampForSubtract(ts);

        KmTime time = ts.getTime();
        KmDate date = ts.getDate();

        date = date.subtractYears(i);

        return toValidTimestampForSubtract(time, date);
    }

    private KmTimestamp toValidTimestampForSubtract(KmTime time, KmDate date)
    {
        KmTimestamp resultTs;
        resultTs = KmTimestamp.fromDateTime(date, time);
        resultTs = ensureValidTimestampForSubtract(resultTs);
        return resultTs;
    }

    //##################################################
    //# private
    //##################################################

    private KmTimestamp addAsSeconds(KmTimestamp ts, KmUnitDuration duration)
    {
        int secs = duration.toSeconds();
        return addSeconds(ts, secs);
    }

    private KmTimestamp addAsDays(KmTimestamp ts, KmUnitDuration duration)
    {
        int days = Kmu.round(duration.getValue());
        return addDays(ts, days);
    }

    private KmTimestamp addAsWeeks(KmTimestamp ts, KmUnitDuration duration)
    {
        int i = Kmu.round(duration.getValue());
        return addWeeks(ts, i);
    }

    private KmTimestamp addAsMonths(KmTimestamp ts, KmUnitDuration duration)
    {
        int i = Kmu.round(duration.getValue());
        return addMonths(ts, i);
    }

    private KmTimestamp addAsYears(KmTimestamp ts, KmUnitDuration duration)
    {
        int i = Kmu.round(duration.getValue());
        return addYears(ts, i);
    }

    //==================================================
    //= private :: subtract
    //==================================================

    private KmTimestamp subtractAsSeconds(KmTimestamp ts, KmUnitDuration duration)
    {
        int secs = duration.toSeconds();
        return subtractSeconds(ts, secs);
    }

    private KmTimestamp subtractAsDays(KmTimestamp ts, KmUnitDuration duration)
    {
        int days = Kmu.round(duration.getValue());
        return subtractDays(ts, days);
    }

    private KmTimestamp subtractAsWeeks(KmTimestamp ts, KmUnitDuration duration)
    {
        int i = Kmu.round(duration.getValue());
        return subtractWeeks(ts, i);
    }

    private KmTimestamp subtractAsMonths(KmTimestamp ts, KmUnitDuration duration)
    {
        int i = Kmu.round(duration.getValue());
        return subtractMonths(ts, i);
    }

    private KmTimestamp subtractAsYears(KmTimestamp ts, KmUnitDuration duration)
    {
        int i = Kmu.round(duration.getValue());
        return subtractYears(ts, i);
    }

    //##################################################
    //# support
    //##################################################

    private KmTimestamp findStartOfNextBusinessDay(KmTimestamp ts)
    {
        KmDate date = nextBusinessDay(ts.getDate());
        return getStartOfBusinessDay(date);
    }

    private KmTimestamp findEndOfPreviousBusinessDay(KmTimestamp ts)
    {
        KmDate date = previousBusinessDay(ts.getDate());
        return getEndOfBusinessDay(date);
    }

    private KmTimestamp getStartOfBusinessDay(KmDate date)
    {
        KmTime startTime = getPolicy().getStartTime();
        return KmTimestamp.fromDateTime(date, startTime);
    }

    private KmTimestamp getEndOfBusinessDay(KmDate date)
    {
        KmTime end = getPolicy().getEndTime();
        return KmTimestamp.fromDateTime(date, end);
    }

    private boolean isDuringBusinessDay(KmTimestamp ts)
    {
        KmDate date = ts.getDate();
        if ( !isBusinessDay(date) )
            return false;

        KmTime time = ts.getTime();
        KmTime startTime = getPolicy().getStartTime();
        KmTime endTime = getPolicy().getEndTime();

        return time.isOnOrAfter(startTime) && time.isBefore(endTime);
    }

    private boolean isBeforeBusinessHours(KmTime time)
    {
        KmTime startTime = getPolicy().getStartTime();
        return time.isBefore(startTime);
    }

    private boolean isAfterBusinessHours(KmTime time)
    {
        KmTime endTime = getPolicy().getEndTime();
        return time.isOnOrAfter(endTime);
    }

    private boolean isBusinessDay(KmDate date)
    {
        return getPolicy().isBusinessDay(date);
    }

    private KmDate nextBusinessDay(KmDate date)
    {
        // The policy is guaranteed to have at least 1 business day.
        while ( true )
        {
            date = date.addDay();

            if ( isBusinessDay(date) )
                return date;
        }
    }

    private KmDate previousBusinessDay(KmDate date)
    {
        // The policy is guaranteed to have at least 1 business day.
        while ( true )
        {
            date = date.subtractDay();

            if ( isBusinessDay(date) )
                return date;
        }
    }

    private int getSecsUntilEnd(KmTimestamp ts)
    {
        KmTime end = getPolicy().getEndTime();
        KmTime time = ts.getTime();
        KmDuration durationUntilEnd = time.getDurationUntil(end);
        return durationUntilEnd.getTotalSeconds();
    }

    private int getSecsFromStart(KmTimestamp ts)
    {
        KmTime start = getPolicy().getStartTime();
        KmTime time = ts.getTime();
        KmDuration durationFromStart = start.getDurationUntil(time);
        return durationFromStart.getTotalSeconds();
    }

    private KmTimestamp ensureValidTimestampForAdd(KmTimestamp ts)
    {
        if ( isDuringBusinessDay(ts) )
            return ts;

        if ( !isBusinessDay(ts.getDate()) )
            return findStartOfNextBusinessDay(ts);

        KmTime time = ts.getTime();
        if ( isBeforeBusinessHours(time) )
            return getStartOfBusinessDay(ts.getDate());

        return findStartOfNextBusinessDay(ts);
    }

    private KmTimestamp ensureValidTimestampForSubtract(KmTimestamp ts)
    {
        if ( isDuringBusinessDay(ts) )
            return ts;

        if ( !isBusinessDay(ts.getDate()) )
            return findEndOfPreviousBusinessDay(ts);

        KmTime time = ts.getTime();
        if ( isAfterBusinessHours(time) )
            return getEndOfBusinessDay(ts.getDate());

        return findEndOfPreviousBusinessDay(ts);
    }

    //==================================================
    //= support :: conversion
    //==================================================

    private void validatePolicy()
    {
        getPolicy().validate();
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmTimestamp ts = KmTimestampParser.parseTimestamp("3/13/18 5:30 am");
        KmUnitDuration d = KmUnitDuration.fromDays(3);

        KmBusinessHourCalculator c;
        c = new KmBusinessHourCalculator();
        KmTimestamp result = c.subtract(ts, d);

        System.out.println("    Start:    " + ts.getWeekDay() + ", " + ts);
        System.out.println("    Duration: " + d);
        System.out.println("");
        System.out.println("    Result:   " + result.getWeekDay() + ", " + result);
    }
}
