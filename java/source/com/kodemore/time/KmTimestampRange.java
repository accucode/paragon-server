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
 * I implement an range for timestamps.  I define a start and end
 * timestamp with various convenience methods.
 *
 * The start and/or end dates may be null for an open ended range.
 * If both the start and end date are specified, then the start date
 * MUST be on or before the end date.
 */
public class KmTimestampRange
    implements Comparable<KmTimestampRange>, Serializable
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmTimestampRange create(KmTimestamp start, KmTimestamp end)
    {
        KmTimestampRange ti;
        ti = new KmTimestampRange();
        ti.setStart(start);
        ti.setEnd(end);
        return ti;
    }

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp _start;
    private KmTimestamp _end;

    //##################################################
    //# contructor
    //##################################################

    public KmTimestampRange()
    {
        _start = null;
        _end = null;
    }

    //##################################################
    //# accessing
    //##################################################

    //==================================================
    //= start
    //==================================================

    public KmTimestamp getStart()
    {
        return _start;
    }

    public void setStart(KmTimestamp ts)
    {
        _start = ts;
    }

    public boolean hasStart()
    {
        return _start != null;
    }

    public boolean hasStart(KmTimestamp ts)
    {
        return Kmu.isEqual(getStart(), ts);
    }

    //==================================================
    //= end
    //==================================================

    public KmTimestamp getEnd()
    {
        return _end;
    }

    public void setEnd(KmTimestamp ts)
    {
        _end = ts;
    }

    public boolean hasEnd()
    {
        return _end != null;
    }

    public boolean hasEnd(KmTimestamp ts)
    {
        return Kmu.isEqual(getEnd(), ts);
    }

    //==================================================
    //= dates
    //==================================================

    public KmDate getStartDate()
    {
        return hasStart()
            ? getStart().getDate()
            : null;
    }

    public KmDate getEndDate()
    {
        return hasEnd()
            ? getEnd().getDate()
            : null;
    }

    public KmDateRange toDateRange()
    {
        return KmDateRange.create(getStartDate(), getEndDate());
    }

    //==================================================
    //= duration
    //==================================================

    /**
     * Return the duration between the start and end.
     * Null is returned if either the start or end dates are null.
     * If non null, the duration is guaranteed to be positive.
     */
    public KmDuration toDuration()
    {
        return isClosed()
            ? getStart().diff(getEnd())
            : null;
    }

    public KmDuration getDuration()
    {
        return toDuration();
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isOpen()
    {
        return !hasStart() && !hasEnd();
    }

    public boolean isClosed()
    {
        return hasStart() && hasEnd();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmTimestampRange) )
            return false;

        KmTimestampRange ti = (KmTimestampRange)e;
        return ti.hasStart(getStart()) && ti.hasEnd(getEnd());
    }

    /**
     * Return a hashcode that combines the start and end date.
     */
    @Override
    public int hashCode()
    {
        if ( isClosed() )
            return getStart().hashCode() ^ getEnd().hashCode();

        if ( hasStart() )
            return getStart().hashCode();

        if ( hasEnd() )
            return getEnd().hashCode();

        return 0;
    }

    @Override
    public int compareTo(KmTimestampRange e)
    {
        int i = getStart().compareTo(e.getStart());
        if ( i != 0 )
            return i;

        return getEnd().compareTo(e.getEnd());
    }

    //##################################################
    //# intersection
    //##################################################

    /**
     * @see #containsInclusive
     */
    public boolean contains(KmTimestamp t)
    {
        return containsInclusive(t);
    }

    /**
     * Determine if this range contains the time.  The test includes
     * the start and end dates.
     */
    public boolean containsInclusive(KmTimestamp t)
    {
        if ( t == null )
            return false;

        if ( hasStart() && getStart().isAfter(t) )
            return false;

        if ( hasEnd() && getEnd().isBefore(t) )
            return false;

        return true;
    }

    /**
     * Determine if this range contains the time.  The test excludes
     * the start and end dates.
     */
    public boolean containsExclusive(KmTimestamp t)
    {
        if ( t == null )
            return false;

        if ( hasStart() && getStart().isOnOrAfter(t) )
            return false;

        if ( hasEnd() && getEnd().isOnOrBefore(t) )
            return false;

        return true;
    }

    public boolean contains(KmTimestampRange ti)
    {
        return containsInclusive(ti);
    }

    public boolean containsInclusive(KmTimestampRange ti)
    {
        if ( ti == null )
            return false;

        return containsInclusive(ti.getStart()) && containsInclusive(ti.getEnd());
    }

    public boolean containsExclusive(KmTimestampRange ti)
    {
        if ( ti == null )
            return false;

        return containsExclusive(ti.getStart()) && containsExclusive(ti.getEnd());
    }

    public boolean intersects(KmTimestampRange ti)
    {
        if ( ti == null )
            return false;

        if ( contains(ti.getStart()) )
            return true;

        if ( contains(ti.getEnd()) )
            return true;

        if ( ti.contains(getStart()) )
            return true;

        return false;
    }

    public KmTimestampRange getIntersection(KmTimestampRange ti)
    {
        KmTimestampRange x = ti.getCopy();

        if ( x.contains(getStart()) )
            x.setStart(getStart());

        if ( x.contains(getEnd()) )
            x.setEnd(getEnd());

        return x;
    }

    //##################################################
    //# copy
    //##################################################

    public KmTimestampRange getCopy()
    {
        KmTimestampRange e = new KmTimestampRange();

        if ( hasStart() )
            e.setStart(getStart());

        if ( hasEnd() )
            e.setEnd(getEnd());

        return e;
    }

    //##################################################
    //# time zone
    //##################################################

    public KmTimestampRange changeZone(KmTimeZone from, KmTimeZone to)
    {
        KmTimestamp start = hasStart()
            ? getStart().changeZone(from, to)
            : null;

        KmTimestamp end = hasEnd()
            ? getEnd().changeZone(from, to)
            : null;

        return create(start, end);
    }

    //==================================================
    //= time zone :: utc
    //==================================================

    public KmTimestampRange toUtc()
    {
        KmTimestamp startUtc = hasStart()
            ? getStart().toUtc()
            : null;

        KmTimestamp endUtc = hasEnd()
            ? getEnd().toUtc()
            : null;

        return create(startUtc, endUtc);
    }

    public KmTimestampRange toUtc(KmTimeZone zone)
    {
        KmTimestamp startUtc = hasStart()
            ? getStart().toUtc(zone)
            : null;

        KmTimestamp endUtc = hasEnd()
            ? getEnd().toUtc(zone)
            : null;

        return create(startUtc, endUtc);
    }

    //==================================================
    //= time zone :: local
    //==================================================

    public KmTimestampRange toLocal()
    {
        KmTimestamp startLocal = hasStart()
            ? getStart().toLocal()
            : null;

        KmTimestamp endLocal = hasEnd()
            ? getEnd().toLocal()
            : null;

        return create(startLocal, endLocal);
    }

    public KmTimestampRange toLocal(KmTimeZone zone)
    {
        KmTimestamp startLocal = hasStart()
            ? getStart().toLocal(zone)
            : null;

        KmTimestamp endLocal = hasEnd()
            ? getEnd().toLocal(zone)
            : null;

        return create(startLocal, endLocal);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("%s - %s", getStart(), getEnd());
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        test(0, 0, 0, 0);
        test(0, 0, 1, 0);
        test(0, 0, 0, 1);
        test(0, 0, 1, 1);

        test(0, 9, 0, 0);
        test(0, 9, 1, 0);
        test(0, 9, 0, 1);
        test(0, 9, 1, 1);

        test(2, 0, 0, 0);
        test(2, 0, 1, 0);
        test(2, 0, 0, 1);
        test(2, 0, 1, 1);

    }

    public static void test(int start1, int end1, int start2, int end2)
    {
        KmTimestamp startTimestamp1 = null;
        KmTimestamp startTimestamp2 = null;

        if ( start1 > 0 )
            startTimestamp1 = KmDate.fromYearMonthDay(2000, 1, start1).getStartOfDay();

        if ( start2 > 0 )
            startTimestamp2 = KmDate.fromYearMonthDay(2000, 2, start2).getStartOfDay();

        KmTimestamp endTimestamp1 = null;
        KmTimestamp endTimestamp2 = null;

        if ( end1 > 0 )
            endTimestamp1 = KmDate.fromYearMonthDay(2000, 1, end1).getStartOfDay();

        if ( end2 > 0 )
            endTimestamp2 = KmDate.fromYearMonthDay(2000, 2, end2).getStartOfDay();

        KmTimestampRange ts1 = KmTimestampRange.create(startTimestamp1, endTimestamp1);
        KmTimestampRange ts2 = KmTimestampRange.create(startTimestamp2, endTimestamp2);

        System.out.println("KmTimestampRange.test() : 263");
        System.out.println("    ts1: " + ts1);
        System.out.println("    ts2: " + ts2);
        System.out.println("    ts1.intersects(ts2): " + ts1.intersects(ts2));
        System.out.println("    ts2.intersects(ts1): " + ts2.intersects(ts1));

    }

}
