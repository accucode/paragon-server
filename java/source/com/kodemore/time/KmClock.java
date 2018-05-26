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

/**
 * I am used to get the current time.  I should generally be used instead
 * of methods like KmTimestamp.createNow().  My methods may be optimized
 * for performance, and may only be accurate to the second.  Do not use
 * the clock if you need accuracy of milliseconds or nanoseconds.
 */
public class KmClock
{
    //##################################################
    //# timestamp
    //##################################################

    public static KmTimestamp getUtcTimestamp()
    {
        return KmTimestamp.fromInstant(KmTimeConstantsIF.UTC_WALL_CLOCK.instant());
    }

    public static KmTimestamp getLocalTimestamp()
    {
        return getUtcTimestamp().toLocal();
    }

    //##################################################
    //# date
    //##################################################

    public static KmDate getUtcDate()
    {
        return getUtcTimestamp().getDate();
    }

    public static KmDate getLocalDate()
    {
        return getLocalTimestamp().getDate();
    }

    //##################################################
    //# time
    //##################################################

    public static KmTime getUtcTime()
    {
        return getUtcTimestamp().getTime();
    }

    public static KmTime getLocalTime()
    {
        return getLocalTimestamp().getTime();
    }
}
