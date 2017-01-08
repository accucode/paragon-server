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

import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

import com.kodemore.utility.Kmu;

/**
 * I define various static methods that are useful when dealing with dates.
 */
public class KmDateUtility
    implements KmTimeConstantsIF
{
    //##################################################
    //# testing
    //##################################################

    /**
     * Determine the number of days in a given month.
     */
    public static int getDaysInYearMonth(int yy, int mm)
    {
        boolean isLeap = Year.isLeap(yy);
        return Month.of(mm).length(isLeap);
    }

    /**
     * Determine if a year is a leap year.
     */
    public static boolean isLeapYear(int year)
    {
        return Year.isLeap(year);
    }

    //##################################################
    //# display
    //##################################################

    /**
     * Get the name of the month.
     * The month index should be 1..12, Jan = 1.
     */
    public static String getMonthName(int i)
    {
        return Month.of(i).getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public static String getMonthAbbreviation(int i)
    {
        return Month.of(i).getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }

    //##################################################
    //# format
    //##################################################

    /**
     * I provide a very simple, and non-optimized, facility for formatting
     * dates in a variety of formats.  Valid format codes are:
     * {d}    : day of month (1-31)
     * {dd}   : day of month (01-31)
     * {ddd}  : weekday abbreviation (Sun-Sat)
     * {dddd} : weekday name (Sunday-Saturday)
     * {m}    : month (1-12)
     * {mm}   : month (01-12)
     * {mmm}  : month abbreviation (Jan-Dec)
     * {mmmm} : month name (January-December)
     * {yy}   : year (00-99)
     * {yyyy} : year (1800-9999)
     */
    public static String format(KmDate d, String format)
    {
        if ( d == null )
            return "";

        String s = format;
        s = Kmu.replaceAll(s, "{mmmm}", KmDateUtility.getMonthName(d.getMonth()));
        s = Kmu.replaceAll(s, "{mmm}", KmDateUtility.getMonthAbbreviation(d.getMonth()));
        s = Kmu.replaceAll(s, "{mm}", pad2(d.getMonth()));
        s = Kmu.replaceAll(s, "{m}", d.getMonth() + "");

        s = Kmu.replaceAll(s, "{dddd}", d.getWeekDay().getLabel());
        s = Kmu.replaceAll(s, "{ddd}", d.getWeekDay().getAbbreviation());
        s = Kmu.replaceAll(s, "{dd}", pad2(d.getDay()));
        s = Kmu.replaceAll(s, "{d}", d.getDay() + "");

        s = Kmu.replaceAll(s, "{yyyy}", d.getYear() + "");
        s = Kmu.replaceAll(s, "{yy}", pad2(getShortYear(d)));
        return s;
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 1/31/1985
     */
    public static String format_m_dd_yy(KmDate d)
    {
        if ( d == null )
            return "";

        return ""
            + d.getMonth()
            + DATE_SEPARATOR
            + pad2(d.getDay())
            + DATE_SEPARATOR
            + pad2(getShortYear(d));
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 01/31/85
     */
    public static String format_mm_dd_yy(KmDate d)
    {
        if ( d == null )
            return "";

        return ""
            + pad2(d.getMonth())
            + DATE_SEPARATOR
            + pad2(d.getDay())
            + DATE_SEPARATOR
            + pad2(getShortYear(d));
    }

    /**
     * Format a date, e.g.: Jan 8, 1985 -> 1/8
     */
    public static String format_m_d(KmDate d)
    {
        if ( d == null )
            return "";

        return "" + d.getMonth() + DATE_SEPARATOR + d.getDay();
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 01/31/1985
     */
    public static String format_mm_dd_yyyy(KmDate d)
    {
        if ( d == null )
            return "";

        return ""
            + pad2(d.getMonth())
            + DATE_SEPARATOR
            + pad2(d.getDay())
            + DATE_SEPARATOR
            + pad4(d.getYear());
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 1/31/1985
     */
    public static String format_m_d_yyyy(KmDate d)
    {
        if ( d == null )
            return "";

        return "" + d.getMonth() + DATE_SEPARATOR + d.getDay() + DATE_SEPARATOR + pad4(d.getYear());
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 19850131.
     */
    public static String format_yyyymmdd(KmDate d)
    {
        if ( d == null )
            return "";

        return "" + pad4(d.getYear()) + pad2(d.getMonth()) + pad2(d.getDay());
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 198501.
     */
    public static String format_yyyymm(KmDate d)
    {
        if ( d == null )
            return "";

        return "" + pad4(d.getYear()) + pad2(d.getMonth());
    }

    /**
     * Format an ISO 8601 date, e.g.: 2014-01-31.
     */
    public static String format_iso(KmDate d)
    {
        if ( d == null )
            return "";

        String yyyy = pad4(d.getYear());
        String mm = pad2(d.getMonth());
        String dd = pad2(d.getDay());

        return Kmu.format("%s-%s-%s", yyyy, mm, dd);
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 850131.
     */
    public static String format_yymmdd(KmDate d)
    {
        if ( d == null )
            return "";

        return "" + pad2(d.getShortYear()) + pad2(d.getMonth()) + pad2(d.getDay());
    }

    /**
     * Format a date in XSD format.
     */
    public static String formatXsd(KmDate d)
    {
        return KmDateFormatter.formatDate(d, "{yyyy}-{mm}-{dd}");
    }

    /**
     * Format a date, e.g.: Jan 31, 1985 -> 01/85
     */
    public static String format_mm_yy(KmDate d)
    {
        if ( d == null )
            return "";

        return "" + pad2(d.getMonth()) + DATE_SEPARATOR + pad4(d.getYear());
    }

    //##################################################
    //# private
    //##################################################

    private static String pad2(int i)
    {
        return Kmu.leftPad(i + "", 2, '0');
    }

    private static String pad4(int i)
    {
        return Kmu.leftPad(i + "", 4, '0');
    }

    private static int getShortYear(KmDate d)
    {
        return d.getYear() % 100;
    }

}
