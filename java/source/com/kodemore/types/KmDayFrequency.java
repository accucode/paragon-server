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

package com.kodemore.types;

import java.io.Serializable;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmWeekDay;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * I represent the days of the week a flight is scheduled to operate.
 * I provide utility methods for determining which day of the week
 * are contained in my frequency.
 *
 * IMMUTABLE.
 * I am immutable. Any method that changes state, actually
 * returns a different instance with the new state.
 */
public class KmDayFrequency
    implements KmConstantsIF, Comparable<KmDayFrequency>, Serializable
{
    //##################################################
    //# constants
    //##################################################

    public static KmDayFrequency EMPTY                 = new KmDayFrequency("");
    public static KmDayFrequency ALL                   = EMPTY.addAll();
    public static KmDayFrequency MONDAY_THROUGH_FRIDAY = EMPTY.addMondayThroughFriday();

    //##################################################
    //# instance creation
    //##################################################

    public static KmDayFrequency fromString(String s)
    {
        return new KmDayFrequency(s);
    }

    /**
     * This must be compatible with fromString(s).
     */
    @Override
    public String toString()
    {
        return _days;
    }

    //##################################################
    //# variables
    //##################################################

    private String _days;

    //##################################################
    //# constructor
    //##################################################

    private KmDayFrequency(String s)
    {
        _days = normalize(s);
    }

    //##################################################
    //# week days
    //##################################################

    public KmDayFrequency setDay(KmWeekDay e, boolean add)
    {
        return setDayCode(e.getCode(), add);
    }

    public KmDayFrequency addDay(KmWeekDay e)
    {
        return addDayCode(e.getCode());
    }

    public KmDayFrequency removeDay(KmWeekDay e)
    {
        return removeDayCode(e.getCode());
    }

    public boolean hasWeekDay(KmWeekDay e)
    {
        return hasDayCode(e.getCode());
    }

    public KmList<KmWeekDay> getWeekDays()
    {
        KmList<KmWeekDay> v = new KmList<>();

        for ( KmWeekDay e : KmWeekDay.values() )
            if ( hasWeekDay(e) )
                v.add(e);

        return v;
    }

    public KmList<String> getWeekDayCodes()
    {
        return getWeekDays().collect(e -> e.getCode());
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmDayFrequency setDayCode(String dow, boolean add)
    {
        return add
            ? addDayCode(dow)
            : removeDayCode(dow);
    }

    public KmDayFrequency addDayCode(String dow)
    {
        return hasDayCode(dow)
            ? this
            : fromString(_days + dow);
    }

    public KmDayFrequency removeDayCode(String dow)
    {
        return hasDayCode(dow)
            ? fromString(Kmu.replaceAll(_days, dow, ""))
            : this;
    }

    public boolean hasDayCode(String e)
    {
        return _days.indexOf(e) >= 0;
    }

    //##################################################
    //# monday
    //##################################################

    public KmDayFrequency setMonday(boolean on)
    {
        return setDayCode(DOW_MONDAY, on);
    }

    public KmDayFrequency addMonday()
    {
        return addDayCode(DOW_MONDAY);
    }

    public KmDayFrequency removeMonday()
    {
        return removeDayCode(DOW_MONDAY);
    }

    public boolean hasMonday()
    {
        return hasDayCode(DOW_MONDAY);
    }

    //==================================================
    //= tuesday
    //==================================================

    public KmDayFrequency setTuesday(boolean on)
    {
        return setDayCode(DOW_TUESDAY, on);
    }

    public KmDayFrequency addTuesday()
    {
        return addDayCode(DOW_TUESDAY);
    }

    public KmDayFrequency removeTuesday()
    {
        return removeDayCode(DOW_TUESDAY);
    }

    public boolean hasTuesday()
    {
        return hasDayCode(DOW_TUESDAY);
    }

    //==================================================
    //= wednesday
    //==================================================

    public KmDayFrequency setWednesday(boolean on)
    {
        return setDayCode(DOW_WEDNESDAY, on);
    }

    public KmDayFrequency addWednesday()
    {
        return addDayCode(DOW_WEDNESDAY);
    }

    public KmDayFrequency removeWednesday()
    {
        return removeDayCode(DOW_WEDNESDAY);
    }

    public boolean hasWednesday()
    {
        return hasDayCode(DOW_WEDNESDAY);
    }

    //==================================================
    //= thursday
    //==================================================

    public KmDayFrequency setThursday(boolean on)
    {
        return setDayCode(DOW_THURSDAY, on);
    }

    public KmDayFrequency addThursday()
    {
        return addDayCode(DOW_THURSDAY);
    }

    public KmDayFrequency removeThursday()
    {
        return removeDayCode(DOW_THURSDAY);
    }

    public boolean hasThursday()
    {
        return hasDayCode(DOW_THURSDAY);
    }

    //==================================================
    //= friday
    //==================================================

    public KmDayFrequency setFriday(boolean on)
    {
        return setDayCode(DOW_FRIDAY, on);
    }

    public KmDayFrequency addFriday()
    {
        return addDayCode(DOW_FRIDAY);
    }

    public KmDayFrequency removeFriday()
    {
        return removeDayCode(DOW_FRIDAY);
    }

    public boolean hasFriday()
    {
        return hasDayCode(DOW_FRIDAY);
    }

    //==================================================
    //= saturday
    //==================================================

    public KmDayFrequency setSaturday(boolean on)
    {
        return setDayCode(DOW_SATURDAY, on);
    }

    public KmDayFrequency addSaturday()
    {
        return addDayCode(DOW_SATURDAY);
    }

    public KmDayFrequency removeSaturday()
    {
        return removeDayCode(DOW_SATURDAY);
    }

    public boolean hasSaturday()
    {
        return hasDayCode(DOW_SATURDAY);
    }

    //==================================================
    //= sunday
    //==================================================

    public KmDayFrequency setSunday(boolean on)
    {
        return setDayCode(DOW_SUNDAY, on);
    }

    public KmDayFrequency addSunday()
    {
        return addDayCode(DOW_SUNDAY);
    }

    public KmDayFrequency removeSunday()
    {
        return removeDayCode(DOW_SUNDAY);
    }

    public boolean hasSunday()
    {
        return hasDayCode(DOW_SUNDAY);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean hasValue()
    {
        return hasMonday()
            || hasTuesday()
            || hasWednesday()
            || hasThursday()
            || hasFriday()
            || hasSaturday()
            || hasSunday();
    }

    public boolean isEmpty()
    {
        return !hasValue();
    }

    //##################################################
    //# convenience
    //##################################################

    public KmDayFrequency addAll()
    {
        return addMonday().addTuesday()
            .addWednesday()
            .addThursday()
            .addFriday()
            .addSaturday()
            .addSunday();
    }

    public KmDayFrequency addMondayThroughFriday()
    {
        return addMonday().addTuesday().addWednesday().addThursday().addFriday();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmDayFrequency) )
            return false;

        return ((KmDayFrequency)e)._days.equals(_days);
    }

    @Override
    public int hashCode()
    {
        return _days.hashCode();
    }

    @Override
    public int compareTo(KmDayFrequency e)
    {
        return _days.compareTo(e._days);
    }

    //##################################################
    //# date
    //##################################################

    public boolean matchesDate(KmTimestamp ts)
    {
        return matchesDate(ts.getDate());
    }

    public boolean matchesDate(KmDate d)
    {
        return d.matchesFrequency(this);
    }

    //##################################################
    //# support
    //##################################################

    private String normalize(String s)
    {
        final String empty = ".......";

        if ( s == null )
            return empty;

        StringBuilder out = new StringBuilder(empty);

        if ( s.indexOf(DOW_CHAR_MONDAY) >= 0 )
            out.setCharAt(0, DOW_CHAR_MONDAY);

        if ( s.indexOf(DOW_CHAR_TUESDAY) >= 0 )
            out.setCharAt(1, DOW_CHAR_TUESDAY);

        if ( s.indexOf(DOW_CHAR_WEDNESDAY) >= 0 )
            out.setCharAt(2, DOW_CHAR_WEDNESDAY);

        if ( s.indexOf(DOW_CHAR_THURSDAY) >= 0 )
            out.setCharAt(3, DOW_CHAR_THURSDAY);

        if ( s.indexOf(DOW_CHAR_FRIDAY) >= 0 )
            out.setCharAt(4, DOW_CHAR_FRIDAY);

        if ( s.indexOf(DOW_CHAR_SATURDAY) >= 0 )
            out.setCharAt(5, DOW_CHAR_SATURDAY);

        if ( s.indexOf(DOW_CHAR_SUNDAY) >= 0 )
            out.setCharAt(6, DOW_CHAR_SUNDAY);

        return out.toString();
    }
}
