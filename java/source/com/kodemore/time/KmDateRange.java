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
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I implement an range for dates.  I define a start and end
 * date with various convenience methods.
 */
public class KmDateRange
    implements Comparable<KmDateRange>, Serializable, Iterable<KmDate>
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmDateRange create(KmDate start, KmDate end)
    {
        KmDateRange di;
        di = new KmDateRange();
        di.setStart(start);
        di.setEnd(end);
        return di;
    }

    //##################################################
    //# variables
    //##################################################

    private KmDate _start;
    private KmDate _end;

    //##################################################
    //# contructor
    //##################################################

    public KmDateRange()
    {
        _start = null;
        _end = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDate getStart()
    {
        return _start;
    }

    public void setStart(KmDate d)
    {
        _start = d;
    }

    public boolean hasStart()
    {
        return _start != null;
    }

    public boolean hasStart(KmDate d)
    {
        return Kmu.isEqual(getStart(), d);
    }

    public KmDate getEnd()
    {
        return _end;
    }

    public void setEnd(KmDate d)
    {
        _end = d;
    }

    public boolean hasEnd()
    {
        return _end != null;
    }

    public boolean hasEnd(KmDate d)
    {
        return Kmu.isEqual(getEnd(), d);
    }

    @Override
    public Iterator<KmDate> iterator()
    {
        if ( !isClosed() )
            throw new RuntimeException("Cannot create an iterator on an open range");

        return new Iterator<KmDate>()
        {
            private KmDate _next = getStart();

            @Override
            public boolean hasNext()
            {
                return _next.isOnOrBefore(getEnd());
            }

            @Override
            public KmDate next()
            {
                KmDate d = _next;
                _next = _next.addDay();
                return d;
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
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

    public boolean isNotClosed()
    {
        return !isClosed();
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmDateRange) )
            return false;

        KmDateRange di = (KmDateRange)e;
        return hasStart(di.getStart()) && hasEnd(di.getEnd());
    }

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
    public int compareTo(KmDateRange e)
    {
        int i = getStart().compareTo(e.getStart());
        if ( i != 0 )
            return i;
        return getEnd().compareTo(e.getEnd());
    }

    //##################################################
    //# testing
    //##################################################

    public boolean contains(KmDate d)
    {
        return containsInclusive(d);
    }

    public boolean containsInclusive(KmDate d)
    {
        if ( d == null )
            return false;

        if ( hasStart() && getStart().isAfter(d) )
            return false;

        if ( hasEnd() && getEnd().isBefore(d) )
            return false;

        return true;
    }

    public boolean containsExclusive(KmDate d)
    {
        if ( d == null )
            return false;

        if ( hasStart() && getStart().isOnOrAfter(d) )
            return false;

        if ( hasEnd() && getEnd().isOnOrBefore(d) )
            return false;

        return true;
    }

    public boolean contains(KmDateRange di)
    {
        return containsInclusive(di);
    }

    public boolean containsInclusive(KmDateRange di)
    {
        if ( di == null )
            return false;

        return containsInclusive(di.getStart()) && containsInclusive(di.getEnd());
    }

    public boolean containsExclusive(KmDateRange di)
    {
        if ( di == null )
            return false;

        return containsExclusive(di.getStart()) && containsExclusive(di.getEnd());
    }

    public boolean intersects(KmDateRange di)
    {
        if ( di == null )
            return false;

        if ( contains(di.getStart()) )
            return true;

        if ( contains(di.getEnd()) )
            return true;

        if ( di.contains(getStart()) )
            return true;

        return false;
    }

    public KmDateRange getIntersection(KmDateRange di)
    {
        if ( !intersects(di) )
            return null;

        KmDateRange x = di.getCopy();

        if ( x.contains(getStart()) )
            x.setStart(getStart());

        if ( x.contains(getEnd()) )
            x.setEnd(getEnd());

        return x;
    }

    //##################################################
    //# utility
    //##################################################

    public int getDays()
    {
        return _end.toEpochDays() - _start.toEpochDays() + 1;
    }

    public int getWeeks()
    {
        return getWholeWeeks();
    }

    public int getWholeWeeks()
    {
        return getDays() / 7;
    }

    public int getPartialWeeks()
    {
        int n = getWholeWeeks();
        if ( getDays() % 7 != 0 )
            n++;
        return n;
    }

    //##################################################
    //# copy
    //##################################################

    public KmDateRange getCopy()
    {
        KmDateRange e = new KmDateRange();

        if ( hasStart() )
            e.setStart(getStart());

        if ( hasEnd() )
            e.setEnd(getEnd());

        return e;
    }

    //##################################################
    //# conversion
    //##################################################

    public KmTimestampRange toTimestampRange()
    {
        KmTimestamp start = hasStart()
            ? getStart().getStartOfDay()
            : null;

        KmTimestamp end = hasEnd()
            ? getEnd().getEndOfDay()
            : null;

        return KmTimestampRange.create(start, end);
    }

    public KmMonthRange toMonthRange()
    {
        KmMonth start = hasStart()
            ? getStart().toMonth()
            : null;

        KmMonth end = hasEnd()
            ? getEnd().toMonth()
            : null;

        return KmMonthRange.create(start, end);
    }

    public KmList<KmDate> toList()
    {
        KmList<KmDate> v = new KmList<>();
        for ( KmDate e : this )
            v.add(e);
        return v;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format(getToStringFormat(), getStart(), getEnd());
    }

    public static String getToStringFormat()
    {
        return "%s..%s";
    }

    /**
     * Return the dates in a standard format for display to users.
     */
    public String format()
    {
        KmDate start = getStart();
        KmDate end = getEnd();

        if ( isClosed() )
            return start.equals(end)
                ? start.format()
                : Kmu.format("%s to %s", start.format(), end.format());

        if ( hasStart() )
            return Kmu.format("On or after %s", start.format());

        if ( hasEnd() )
            return Kmu.format("On or before %s", end.format());

        return "Any";
    }
}
