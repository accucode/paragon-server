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

import com.kodemore.utility.Kmu;

/**
 * I am used to format time offsets (durations) in fuzzy human-readable formats.
 * E.g.: a minute ago, 3 hours ago, 5 weeks from now, etc.
 */
public class KmTimeAgoFormatter
{
    //##################################################
    //# variables
    //##################################################

    private String _nowText;
    private String _pastSuffix;
    private String _futureSuffix;

    //##################################################
    //# constructor
    //##################################################

    public KmTimeAgoFormatter()
    {
        setNowText("now");
        setPastSuffix(" ago");
        setFutureSuffix(" from now");
    }

    //##################################################
    //# accessing
    //##################################################

    public String getNowText()
    {
        return _nowText;
    }

    public void setNowText(String e)
    {
        _nowText = e;
    }

    public String getPastSuffix()
    {
        return _pastSuffix;
    }

    public void setPastSuffix(String e)
    {
        _pastSuffix = e;
    }

    public String getFutureSuffix()
    {
        return _futureSuffix;
    }

    public void setFutureSuffix(String e)
    {
        _futureSuffix = e;
    }

    //##################################################
    //# format
    //##################################################

    public String formatUntilUtc(KmTimestamp ts)
    {
        KmTimestamp now = KmClock.getUtcTimestamp();
        KmDuration diff = ts.diff(now);

        return format(diff);
    }

    public String format(KmDuration e)
    {
        String prefix = formatPrefix(e);
        String suffix = formatSuffix(e);

        if ( prefix == null )
            return getNowText();

        return prefix + suffix;
    }

    //##################################################
    //# support
    //##################################################

    private String formatPrefix(KmDuration e)
    {
        e = e.abs();
        int n;

        n = e.getTotalYears();
        if ( n > 0 )
            return formatPrefix(n, "year");

        n = e.getTotalMonths();
        if ( n > 0 )
            return formatPrefix(n, "month");

        n = e.getTotalWeeks();
        if ( n > 0 )
            return formatPrefix(n, "week");

        n = e.getTotalDays();
        if ( n > 0 )
            return formatPrefix(n, "day");

        n = e.getTotalHours();
        if ( n > 0 )
            return formatPrefix(n, "hour");

        n = e.getTotalMinutes();
        if ( n > 0 )
            return formatPrefix(n, "minute");

        return null;
    }

    private String formatPrefix(int n, String unit)
    {
        if ( n > 1 )
            return n + " " + Kmu.pluralize(unit);

        return "a " + unit;
    }

    private String formatSuffix(KmDuration e)
    {
        return e.isPositive()
            ? getFutureSuffix()
            : getPastSuffix();
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmTimestamp ts;

        ts = KmTimestamp.fromYearMonthDay(2014, 1, 7).addHours(23).addMinutes(56);
        System.out.println(ts.formatTimeAgoUtc());
    }

}
