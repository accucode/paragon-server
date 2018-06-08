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
     * The policy determines the rules used in calculations.
     * By default, the policy is Monday-Friday, 9am-5pm, with no holidays.
     */
    private KmBusinessHourPolicy _policy;

    /**
     * The current value, in the policy's time zone.
     * This is updated as the calculator adds and subtracts periods.
     * This must be explicitly set to some default before any calculations.
     * This is defaulted to the current time.
     */
    private KmTimestamp _value;

    //##################################################
    //# constructor
    //##################################################

    public KmBusinessHourCalculator()
    {
        this(KmBusinessHourPolicy.createDefault());
    }

    public KmBusinessHourCalculator(KmBusinessHourPolicy e)
    {
        _policy = e;
        setValueNow();
    }

    //##################################################
    //# policy
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
    //# value :: policy time zone
    //##################################################

    public KmTimestamp getValue()
    {
        return _value;
    }

    public KmBusinessHourCalculator setValue(KmTimestamp e)
    {
        _value = e;
        return this;
    }

    public KmBusinessHourCalculator adjustValue()
    {
        adjustForAdd();
        return this;
    }

    //==================================================
    //= value :: utc time zone
    //==================================================

    public KmTimestamp getValueUtc()
    {
        KmTimeZone zone = getPolicy().getTimeZone();
        return getValue().toUtc(zone);
    }

    public void setValueUtc(KmTimestamp e)
    {
        KmTimeZone zone = getPolicy().getTimeZone();
        setValue(e.toLocal(zone));
    }

    //==================================================
    //= value :: no time zone
    //==================================================

    public boolean hasValue()
    {
        return getValue() != null;
    }

    public void setValueNow()
    {
        setValueUtc(KmClock.getUtcTimestamp());
    }

    //##################################################
    //# add
    //##################################################

    /**
     * Add a unit duration to the timestamp.
     * The logic used depends on the unit of the duration.
     */
    public KmBusinessHourCalculator add(KmUnitDuration e)
    {
        validatePolicy();

        int value = round(e.getValue());

        KmTimeUnit unit = e.getUnit();
        switch ( unit )
        {
            case Second:
                return addSeconds(value);

            case Minute:
                return addMinutes(value);

            case Hour:
                return addHours(value);

            case Day:
                return addDays(value);

            case Week:
                return addWeeks(value);

            case Month:
                return addMonths(value);

            case Year:
                return addYears(value);
        }
        throw Kmu.newEnumError(unit);
    }

    public KmBusinessHourCalculator addSeconds(int i)
    {
        return i > 0
            ? _addSeconds(i)
            : _subtractSeconds(-i);
    }

    public KmBusinessHourCalculator addMinutes(int i)
    {
        return i > 0
            ? _addMinutes(i)
            : _subtractMinutes(-i);
    }

    public KmBusinessHourCalculator addHours(int i)
    {
        return i > 0
            ? _addHours(i)
            : _subtractHours(-i);
    }

    public KmBusinessHourCalculator addDays(int i)
    {
        return i > 0
            ? _addDays(i)
            : _subtractDays(-i);
    }

    public KmBusinessHourCalculator addWeeks(int i)
    {
        return i > 0
            ? _addWeeks(i)
            : _subtractWeeks(-i);

    }

    public KmBusinessHourCalculator addMonths(int i)
    {
        return i > 0
            ? _addMonths(i)
            : _subtractMonths(-i);

    }

    public KmBusinessHourCalculator addYears(int i)
    {
        return i > 0
            ? _addYears(i)
            : _subtractYears(-i);
    }

    //==================================================
    //= add :: private
    //==================================================

    private KmBusinessHourCalculator _addSeconds(int i)
    {
        validatePolicy();
        adjustForAdd();

        while ( true )
        {
            int secsUntilEnd = getSecondsUntilEnd();
            if ( i < secsUntilEnd )
                break;

            gotoStartOfNextDay();
            i = i - secsUntilEnd;
        }

        _value = _value.addSeconds(i);
        return this;
    }

    private KmBusinessHourCalculator _addMinutes(int i)
    {
        int secs = i * SECONDS_PER_MINUTE;
        return addSeconds(secs);
    }

    private KmBusinessHourCalculator _addHours(int i)
    {
        int secs = i * SECONDS_PER_HOUR;
        return addSeconds(secs);
    }

    private KmBusinessHourCalculator _addDays(int n)
    {
        validatePolicy();
        adjustForAdd();

        for ( int i = 0; i < n; i++ )
            gotoNextDay();

        adjustForAdd();
        return this;
    }

    private KmBusinessHourCalculator _addWeeks(int i)
    {
        validatePolicy();
        adjustForAdd();

        _value = _value.addWeeks(i);

        adjustForAdd();
        return this;
    }

    private KmBusinessHourCalculator _addMonths(int i)
    {
        validatePolicy();
        adjustForAdd();

        _value = _value.addMonths(i);

        adjustForAdd();
        return this;
    }

    private KmBusinessHourCalculator _addYears(int i)
    {
        validatePolicy();
        adjustForAdd();

        _value = _value.addYears(i);

        adjustForAdd();
        return this;
    }

    //##################################################
    //# subtract
    //##################################################

    /**
     * Subtract a unit duration to the timestamp.
     * The logic used depends on the unit of the duration.
     *
     * @see KmBusinessHourCalculator
     */
    public KmBusinessHourCalculator subtract(KmUnitDuration e)
    {
        int value = round(e.getValue());

        KmTimeUnit unit = e.getUnit();
        switch ( unit )
        {
            case Second:
                return subtractSeconds(value);

            case Minute:
                return subtractMinutes(value);

            case Hour:
                return subtractHours(value);

            case Day:
                return subtractDays(value);

            case Week:
                return subtractWeeks(value);

            case Month:
                return subtractMonths(value);

            case Year:
                return subtractYears(value);
        }
        throw Kmu.newEnumError(unit);
    }

    public KmBusinessHourCalculator subtractSeconds(int i)
    {
        return i > 0
            ? _subtractSeconds(i)
            : _addSeconds(-i);
    }

    public KmBusinessHourCalculator subtractMinutes(int i)
    {
        return i > 0
            ? _subtractMinutes(i)
            : _addMinutes(-i);
    }

    public KmBusinessHourCalculator subtractHours(int i)
    {
        return i > 0
            ? _subtractHours(i)
            : _addHours(-i);
    }

    public KmBusinessHourCalculator subtractDays(int i)
    {
        return i > 0
            ? _subtractDays(i)
            : _addDays(-i);
    }

    public KmBusinessHourCalculator subtractWeeks(int i)
    {
        return i > 0
            ? _subtractWeeks(i)
            : _addWeeks(-i);
    }

    public KmBusinessHourCalculator subtractMonths(int i)
    {
        return i > 0
            ? _subtractMonths(i)
            : _addMonths(-i);
    }

    public KmBusinessHourCalculator subtractYears(int i)
    {
        return i > 0
            ? _subtractYears(i)
            : _addYears(-i);
    }

    //==================================================
    //= subtract :: private
    //==================================================

    public KmBusinessHourCalculator _subtractSeconds(int i)
    {
        validatePolicy();
        adjustForSubtract();

        while ( true )
        {
            int secsFromStart = getSecondsFromStart();
            if ( i <= secsFromStart )
                break;

            gotoEndOfPreviousDay();
            i = i - secsFromStart;
        }

        _value = _value.subtractSeconds(i);
        return this;
    }

    public KmBusinessHourCalculator _subtractMinutes(int i)
    {
        int secs = i * SECONDS_PER_MINUTE;
        return subtractSeconds(secs);
    }

    public KmBusinessHourCalculator _subtractHours(int i)
    {
        int secs = i * SECONDS_PER_HOUR;
        return subtractSeconds(secs);
    }

    public KmBusinessHourCalculator _subtractDays(int n)
    {
        validatePolicy();
        adjustForSubtract();

        for ( int i = 0; i < n; i++ )
            gotoPreviousDay();

        adjustForSubtract();
        return this;
    }

    public KmBusinessHourCalculator _subtractWeeks(int i)
    {
        validatePolicy();
        adjustForSubtract();

        _value = _value.subtractWeeks(i);

        adjustForSubtract();
        return this;
    }

    public KmBusinessHourCalculator _subtractMonths(int i)
    {
        validatePolicy();
        adjustForSubtract();

        _value = _value.subtractMonths(i);

        adjustForSubtract();
        return this;
    }

    public KmBusinessHourCalculator _subtractYears(int i)
    {
        validatePolicy();
        adjustForSubtract();

        _value = _value.subtractYears(i);

        adjustForSubtract();
        return this;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isDuringBusinessHours()
    {
        if ( !isBusinessDay() )
            return false;

        KmTime time = _value.getTime();
        KmTime start = getPolicy().getStartTime();
        KmTime end = getPolicy().getEndTime();

        return time.isOnOrAfter(start) && time.isBefore(end);
    }

    private boolean isBeforeBusinessHours(KmTime time)
    {
        KmTime startTime = getPolicy().getStartTime();
        return time.isBefore(startTime);
    }

    private boolean isAfterBusinessHours()
    {
        KmTime time = _value.getTime();
        KmTime end = getPolicy().getEndTime();

        return time.isOnOrAfter(end);
    }

    private boolean isBusinessDay()
    {
        return getPolicy().isBusinessDay(_value.getDate());
    }

    //##################################################
    //# goto
    //##################################################

    private void gotoNextDay()
    {
        // The policy is guaranteed to have at least 1 business day.
        while ( true )
        {
            _value = _value.addDay();

            if ( isBusinessDay() )
                return;
        }
    }

    private void gotoPreviousDay()
    {
        // The policy is guaranteed to have at least 1 business day.
        while ( true )
        {
            _value = _value.subtractDay();

            if ( isBusinessDay() )
                return;
        }
    }

    private void gotoStartOfDay()
    {
        _value = _value.withTime(getPolicy().getStartTime());
    }

    private void gotoEndOfDay()
    {
        _value = _value.withTime(getPolicy().getEndTime());
    }

    private void gotoStartOfNextDay()
    {
        gotoNextDay();
        gotoStartOfDay();
    }

    private void gotoEndOfPreviousDay()
    {
        gotoPreviousDay();
        gotoEndOfDay();
    }

    //##################################################
    //# support
    //##################################################

    private int getSecondsUntilEnd()
    {
        KmTime now = _value.getTime();
        KmTime end = getPolicy().getEndTime();

        return now.getDurationUntil(end).getTotalSeconds();
    }

    private int getSecondsFromStart()
    {
        KmTime start = getPolicy().getStartTime();
        KmTime now = _value.getTime();

        return start.getDurationUntil(now).getTotalSeconds();
    }

    //##################################################
    //# adjust
    //##################################################

    private void adjustForAdd()
    {
        if ( isDuringBusinessHours() )
            return;

        if ( !isBusinessDay() )
        {
            gotoStartOfNextDay();
            return;
        }

        KmTime time = _value.getTime();
        if ( isBeforeBusinessHours(time) )
        {
            gotoStartOfDay();
            return;
        }

        gotoStartOfNextDay();
    }

    private void adjustForSubtract()
    {
        if ( isDuringBusinessHours() )
            return;

        if ( !isBusinessDay() )
        {
            gotoEndOfPreviousDay();
            return;
        }

        if ( isAfterBusinessHours() )
        {
            gotoEndOfDay();
            return;
        }

        gotoEndOfPreviousDay();
    }

    //##################################################
    //# support
    //##################################################

    private void validatePolicy()
    {
        getPolicy().validate();
    }

    private int round(double e)
    {
        return Kmu.round(e);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmBusinessHourCalculatorTest.main(args);
    }

}
