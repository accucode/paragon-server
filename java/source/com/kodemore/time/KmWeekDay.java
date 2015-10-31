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

import com.kodemore.utility.KmNamedEnumIF;

/**
 * The days of a week: monday, tuesday, ...
 */
public enum KmWeekDay
    implements KmNamedEnumIF
{
    //##################################################
    //# enum
    //##################################################

    /**
     * The enumerated values.
     *   
     * The values are assumed to be in the correct sequence, Monday..Sunday.
     * This matches the ISO-8601 standard, and is consistent with standard
     * JDK APIs such as LocalDate and WeekDay.
     */

    Monday("M", "Monday", "Mon"),
    Tuesday("T", "Tuesday", "Tue"),
    Wednesday("W", "Wednesday", "Wed"),
    Thursday("H", "Thursday", "Thu"),
    Friday("F", "Friday", "Fri"),
    Saturday("S", "Saturday", "Sat"),
    Sunday("U", "Sunday", "Sun");

    //##################################################
    //# constants
    //##################################################

    /**
     * These are intentionally implemented in such a manner that
     * the developer can easily change the system wide default
     * for the first day of the week, without requiring any additional
     * rewiring.  In particular, the ordinal values of the enum values
     * are not required to directly match the first_day.
     */
    public static final KmWeekDay FIRST_DAY = Sunday;
    public static final KmWeekDay LAST_DAY = FIRST_DAY.getPreviousDay();

    //##################################################
    //# static
    //##################################################

    public static KmWeekDay fromDate(KmDate date)
    {
        int i = date.getWeekDayValue();
        return values()[i - 1];
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _name;
    private String _abbreviation;

    //##################################################
    //# constructor
    //##################################################

    private KmWeekDay(String code, String name, String abbr)
    {
        _code = code;
        _name = name;
        _abbreviation = abbr;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getCode()
    {
        return _code;
    }

    @Override
    public String getName()
    {
        return _name;
    }

    public String getAbbreviation()
    {
        return _abbreviation;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    /**
     * Get my 0-based index relative to the first day of the week.
     * For example if Wednesday is the first day of the week, then
     * Wed=0, Thu=1, Fri=2, etc...
     * 
     * See also, getJdkIndex()
     */
    public int getIndex()
    {
        return (ordinal() - FIRST_DAY.ordinal() + 7) % 7;
    }

    /**
     * Returns the index compatible with Calendar.
     * Values returned are 1..7, corresponding to Sunday..Saturday.
     * 
     * This implementation does NOT take multiple calendars 
     * or countries into account, it simply assumes that Sunday 
     * is the first day of the week as defined in Calendar for 
     * the United States.
     */
    public int getJdkIndex()
    {
        return (ordinal() - Sunday.ordinal() + 7) % 7 + 1;
    }

    //##################################################
    //# testing: days
    //##################################################

    public boolean isMonday()
    {
        return this == Monday;
    }

    public boolean isTuesday()
    {
        return this == Tuesday;
    }

    public boolean isWednesday()
    {
        return this == Wednesday;
    }

    public boolean isThursday()
    {
        return this == Thursday;
    }

    public boolean isFriday()
    {
        return this == Friday;
    }

    public boolean isSaturday()
    {
        return this == Saturday;
    }

    public boolean isSunday()
    {
        return this == Sunday;
    }

    //##################################################
    //# testing: other
    //##################################################

    public boolean isFirstDay()
    {
        return this == FIRST_DAY;
    }

    public boolean isLastDay()
    {
        return this == LAST_DAY;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    /**
     * Get the next week day.  
     * This wraps around so that LAST_DAY.getNextDay == FIRST_DAY.
     */
    public KmWeekDay getNextDay()
    {
        int i = ordinal();
        KmWeekDay[] arr = values();

        return i == arr.length - 1
            ? arr[0]
            : arr[i + 1];
    }

    /**
     * Get the previous week day.  
     * This wraps around so that FIRST_DAY.getPreviousDay == LAST_DAY.
     */
    public KmWeekDay getPreviousDay()
    {
        int i = ordinal();
        KmWeekDay[] arr = values();

        return i == 0
            ? arr[arr.length - 1]
            : arr[i - 1];
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getName();
    }
}
