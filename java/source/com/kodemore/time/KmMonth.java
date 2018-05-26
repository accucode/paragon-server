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
 * I represent a specific month. As in Jan 2001.
 * I store the month and year and provide convenience methods.
 *
 * Instances are immutable.
 * Months conform to ISO standards; e.g.: 1..12 for Jan..Dec.
 */
public class KmMonth
    implements Comparable<KmMonth>, Serializable
{
    //##################################################
    //# instance creation :: misc
    //##################################################

    /**
     * Return a specific date.  Jan 31, 2000 = create(2000, 1, 31);
     */
    public static KmMonth fromYearMonth(int yy, int mm)
    {
        return new KmMonth(yy, mm);
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The 4-digit year, e.g.: 2001.
     */
    private int _year;

    /**
     * The month 1..12.
     */
    private int _month;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Create a date based on the number of days since 1800.
     */
    private KmMonth(int yy, int mm)
    {
        _year = yy;
        _month = mm;
    }

    //##################################################
    //# year
    //##################################################

    public int getYear()
    {
        return _year;
    }

    public boolean hasYear(int yy)
    {
        return _year == yy;
    }

    //##################################################
    //# month
    //##################################################

    public int getMonth()
    {
        return _month;
    }

    public boolean hasMonth(int mm)
    {
        return _month == mm;
    }

    public boolean hasYearMonth(int yy, int mm)
    {
        return hasYear(yy) && hasMonth(mm);
    }

    public String getMonthName()
    {
        return KmDateUtility.getMonthName(getMonth());
    }

    public String getMonthAbbreviation()
    {
        return KmDateUtility.getMonthAbbreviation(getMonth());
    }

    //##################################################
    //# month edge
    //##################################################

    /**
     * Return the first day of the current month.
     */
    public KmDate toStartOfMonth()
    {
        return KmDate.fromYearMonthDay(getYear(), getMonth(), 1);
    }

    /**
     * Return the last day of the current month.
     */
    public KmDate toEndOfMonth()
    {
        return toStartOfMonth().getEndOfMonth();
    }

    //##################################################
    //# year edge
    //##################################################

    public KmDate toStartOfYear()
    {
        return KmDate.fromYearMonthDay(getYear(), 1, 1);
    }

    public KmDate toEndOfYear()
    {
        return KmDate.fromYearMonthDay(getYear(), 12, 31);
    }

    //##################################################
    //# epoch
    //##################################################

    /**
     * Return the number of months since the beginning of the epoch 1/1/1970.
     * Jan 1970 => 0, Feb 1970 => 1, etc.
     */
    public int toEpochMonths()
    {
        return 12 * (getYear() - 1970) + getMonth() - 1;
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
        return e instanceof KmMonth
            ? ((KmMonth)e).hasYearMonth(getYear(), getMonth())
            : false;
    }

    /**
     * Get the hashcode for the date.
     */
    @Override
    public int hashCode()
    {
        return _year ^ _month;
    }

    @Override
    public int compareTo(KmMonth e)
    {
        int i = Kmu.compare(_year, e.getYear());
        if ( i != 0 )
            return i;

        return Kmu.compare(_month, e.getMonth());
    }

    //##################################################
    //# compare (convenience)
    //##################################################

    /**
     * Determine if I am before the parameter.
     */
    public boolean isBefore(KmMonth e)
    {
        return compareTo(e) < 0;
    }

    /**
     * Determine if I equal to or before the parameter.
     */
    public boolean isOnOrBefore(KmMonth e)
    {
        return compareTo(e) <= 0;
    }

    /**
     * Determine if I am after the parameter.
     */
    public boolean isAfter(KmMonth e)
    {
        return compareTo(e) > 0;
    }

    /**
     * Determine if I am equal to or after the parameter.
     */
    public boolean isOnOrAfter(KmMonth e)
    {
        return compareTo(e) >= 0;
    }

    /**
     * Determine if I am between the start and end date, also return true
     * if I am equal to either the start or end date.
     */
    public boolean isBetweenInclusive(KmMonth start, KmMonth end)
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
    public boolean isBetweenExclusive(KmMonth start, KmMonth end)
    {
        if ( start != null && isOnOrBefore(start) )
            return false;

        if ( end != null && isOnOrAfter(end) )
            return false;

        return true;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    /**
     * Determine the number of days in the current month (and year).
     */
    public int getDaysInMonth()
    {
        return toStartOfMonth().getDaysInMonth();
    }

    //==================================================
    //= math :: months
    //==================================================

    public KmMonth addMonth()
    {
        return addMonths(1);
    }

    public KmMonth addMonths(int i)
    {
        return i >= 0
            ? _addMonths(i)
            : _subtractMonths(-i);
    }

    /**
     * Subtract one month from the current date.
     * Attempt to preserve the day, but ensure that the new day is valid for the new month.
     * E.g.: if the old date is 12/31, the new date would be 11/30
     */
    public KmMonth subtractMonth()
    {
        return subtractMonths(1);
    }

    public KmMonth subtractMonths(int i)
    {
        return addMonths(-i);
    }

    // i must be >= 0
    private KmMonth _addMonths(int i)
    {
        if ( i == 0 )
            return this;

        int mm = _month + i;
        if ( mm <= 12 )
            return fromYearMonth(_year, mm);

        mm--;
        int yy = _year + mm / 12;
        mm = mm % 12 + 1;
        return fromYearMonth(yy, mm);
    }

    // i must be >= 0
    private KmMonth _subtractMonths(int i)
    {
        if ( i == 0 )
            return this;

        int mm = _month - i;
        if ( mm >= 1 )
            return fromYearMonth(_year, mm);

        int yy = _year + mm / 12 - 1;
        mm = mm % 12 + 12;
        return fromYearMonth(yy, mm);
    }

    //==================================================
    //= math :: years
    //==================================================

    public KmMonth addYears(int i)
    {
        int yy = _year + i;
        int mm = _month;
        return fromYearMonth(yy, mm);
    }

    public KmMonth addYear()
    {
        return addYears(1);
    }

    public KmMonth subtractYear()
    {
        return addYears(-1);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMonth getNext()
    {
        return addMonth();
    }

    public KmMonth getPrevious()
    {
        return subtractMonth();
    }

    //##################################################
    //# convert
    //##################################################

    public KmDateRange toDateRange()
    {
        return KmDateRange.create(toStartOfMonth(), toEndOfMonth());
    }

    public KmTimestampRange toTimestampRange()
    {
        return toDateRange().toTimestampRange();
    }

    //##################################################
    //# format
    //##################################################

    public String format()
    {
        return format_m_yy();
    }

    public String format_m_yy()
    {
        return Kmu.format("%s/%s", getMonth(), getYear() % 100);
    }

    public String format_m_yyyy()
    {
        return Kmu.format("%s/%s", getMonth(), getYear());
    }

    public String format_mm_yyyy()
    {
        return Kmu.format("%02d/%s", getMonth(), getYear());
    }

    public String format_mmm_yyyy()
    {
        return Kmu.format("%s %s", getMonthAbbreviation(), getYear());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return format_mm_yyyy();
    }

}
