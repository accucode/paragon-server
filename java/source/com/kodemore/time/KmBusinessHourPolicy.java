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

import com.kodemore.collection.KmList;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.utility.Kmu;

public class KmBusinessHourPolicy
{
    //##################################################
    //# constants
    //##################################################

    public static final KmDayFrequency DEFAULT_DAYS       = KmDayFrequency.MONDAY_THROUGH_FRIDAY;
    public static final KmTime         DEFAULT_START_TIME = KmTime.fromHour(9);
    public static final KmTime         DEFAULT_END_TIME   = KmTime.fromHour(17);

    /**
     * Monday-Friday, 9am-5pm, no holidays.
     */
    public static final KmBusinessHourPolicy DEFAULT = createDefault();

    //##################################################
    //# instance creation
    //##################################################

    private static final KmBusinessHourPolicy createDefault()
    {
        KmBusinessHourPolicy e;
        e = new KmBusinessHourPolicy();
        e.setDays(DEFAULT_DAYS);
        e.setStartTime(DEFAULT_START_TIME);
        e.setEndTime(DEFAULT_END_TIME);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The days of the week that are considered business days.
     */
    private KmDayFrequency _days;

    /**
     * The time business hours start.
     */
    private KmTime _startTime;

    /**
     * The time business hours end.
     */
    private KmTime _endTime;

    /**
     * The dates that are holidays.
     */
    private KmList<KmDate> _holidays;

    //##################################################
    //# constructor
    //##################################################

    public KmBusinessHourPolicy()
    {
        _holidays = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDayFrequency getDays()
    {
        return _days;
    }

    public void setDays(KmDayFrequency e)
    {
        _days = e;
    }

    public void setDefaultDays()
    {
        setDays(DEFAULT_DAYS);
    }

    //==================================================
    //= accessing :: start time
    //==================================================

    public void setStartTime(KmTime e)
    {
        _startTime = e;
    }

    public KmTime getStartTime()
    {
        return _startTime;
    }

    public void setDefaultStartTime()
    {
        setStartTime(DEFAULT_START_TIME);
    }

    //==================================================
    //= accessing :: end time
    //==================================================

    public KmTime getEndTime()
    {
        return _endTime;
    }

    public void setEndTime(KmTime e)
    {
        _endTime = e;
    }

    public void setDefaultEndTime()
    {
        setEndTime(DEFAULT_END_TIME);
    }

    //==================================================
    //= accessing :: holidays
    //==================================================

    public KmList<KmDate> getHolidays()
    {
        return _holidays;
    }

    public void setHolidays(KmList<KmDate> v)
    {
        if ( v == null )
            v = KmList.createEmpty();

        _holidays = v;
    }

    public void addHoliday(KmDate e)
    {
        getHolidays().add(e);
    }

    public void addHolidays(KmList<KmDate> e)
    {
        getHolidays().addAll(e);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isBusinessDay(KmDate e)
    {
        return getDays().matchesDate(e) && !getHolidays().contains(e);
    }

    //##################################################
    //# validate
    //##################################################

    public void validate()
    {
        validateDays();
        validateTimes();
    }

    private void validateDays()
    {
        KmDayFrequency days = getDays();
        if ( days.isEmpty() )
            throw Kmu.newFatal("Invalid business hour policy: must have at least 1 business day.");
    }

    private void validateTimes()
    {
        KmTime start = getStartTime();
        KmTime end = getEndTime();

        if ( start == null )
            throw Kmu.newFatal("Invalid business hour policy: start time is required.");

        if ( end == null )
            throw Kmu.newFatal("Invalid business hour policy: end time is required.");

        if ( end.isBefore(start) )
            throw Kmu.newFatal("Invalid business hour policy: start must be before end.");
    }

    //##################################################
    //# display
    //##################################################

    public void printDetails()
    {
        System.out.println(getClass().getSimpleName());
        System.out.println("    Start:    " + getStartTime());
        System.out.println("    End:      " + getEndTime());
        System.out.println("    Days:     " + getDays());
        System.out.println("    Holidays: " + getHolidays().join());
    }
}
