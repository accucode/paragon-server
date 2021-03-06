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

import java.time.Clock;

/**
 * I define several constants that are useful when dealing with times.
 */
public interface KmTimeConstantsIF
{
    //##################################################
    //# wall clock
    //##################################################

    /**
     * A UTC clock, accurate to approximatly 1-second.
     * This clock may be optimized for wall-clock time, but is not
     * useful for milli and/or nano seconds.
     */
    Clock UTC_WALL_CLOCK = Clock.tickSeconds(KmTimeZone.UTC.getZoneId());

    //##################################################
    //# date format
    //##################################################

    String DATE_SEPARATOR = "/";

    //##################################################
    //# internal
    //##################################################

    // these constants will rarely be used outside of the implementation.

    int DAYS_PER_NONLEAP_YEAR = 365;

    int MINUTES_PER_HOUR = 60;

    int SECONDS_PER_MINUTE            = 60;
    int SECONDS_PER_HOUR              = 60 * 60;
    int SECONDS_PER_DAY               = 60 * 60 * 24;
    int SECONDS_PER_WEEK              = 60 * 60 * 24 * 7;
    int SECONDS_PER_YEAR_APPROXIMATE  = SECONDS_PER_DAY * DAYS_PER_NONLEAP_YEAR;
    int SECONDS_PER_MONTH_APPROXIMATE = SECONDS_PER_YEAR_APPROXIMATE / 12;

    int MS_PER_SECOND = 1000;
    int MS_PER_MINUTE = 1000 * 60;
    int MS_PER_HOUR   = 1000 * 60 * 60;
    int MS_PER_DAY    = 1000 * 60 * 60 * 24;
    int MS_PER_WEEK   = 1000 * 60 * 60 * 24 * 7;

    long MS_PER_YEAR_APPROXIMATE  = (long)1000 * 60 * 60 * 24 * DAYS_PER_NONLEAP_YEAR;
    long MS_PER_MONTH_APPROXIMATE = MS_PER_YEAR_APPROXIMATE / 12;

    /**
     * The value used to convert an ordinal value into mysql.
     * This provides compatibility with the mysql functions to_days, from_days.
     */
    int MY_SQL_EPOCH_DAY_OFFSET = 719528;

}
