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
 * I implement an interval for months.
 * I define the start and end with various convenience methods.
 */
public class KmMonthRange
    implements Comparable<KmMonthRange>, Serializable, Iterable<KmMonth>
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmMonthRange create(KmMonth start, KmMonth end)
    {
        KmMonthRange di;
        di = new KmMonthRange();
        di.setStart(start);
        di.setEnd(end);
        return di;
    }

    //##################################################
    //# variables
    //##################################################

    private KmMonth _start;
    private KmMonth _end;

    //##################################################
    //# contructor
    //##################################################

    public KmMonthRange()
    {
        _start = null;
        _end = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMonth getStart()
    {
        return _start;
    }

    public void setStart(KmMonth e)
    {
        _start = e;
    }

    public boolean hasStart()
    {
        return _start != null;
    }

    public boolean hasStart(KmMonth e)
    {
        return Kmu.isEqual(getStart(), e);
    }

    public KmMonth getEnd()
    {
        return _end;
    }

    public void setEnd(KmMonth d)
    {
        _end = d;
    }

    public boolean hasEnd()
    {
        return _end != null;
    }

    public boolean hasEnd(KmMonth d)
    {
        return Kmu.isEqual(getEnd(), d);
    }

    @Override
    public Iterator<KmMonth> iterator()
    {
        if ( !isClosed() )
            throw new RuntimeException("Cannot create an iterator on an open range");

        return new Iterator<KmMonth>()
        {
            private KmMonth _next = getStart();

            @Override
            public boolean hasNext()
            {
                return _next.isOnOrBefore(getEnd());
            }

            @Override
            public KmMonth next()
            {
                KmMonth d = _next;
                _next = _next.addMonth();
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
        if ( !(e instanceof KmMonthRange) )
            return false;

        KmMonthRange di = (KmMonthRange)e;
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
    public int compareTo(KmMonthRange e)
    {
        int i = getStart().compareTo(e.getStart());
        if ( i != 0 )
            return i;
        return getEnd().compareTo(e.getEnd());
    }

    //##################################################
    //# testing
    //##################################################

    public boolean contains(KmMonth d)
    {
        return containsInclusive(d);
    }

    public boolean containsInclusive(KmMonth d)
    {
        if ( d == null )
            return false;

        if ( hasStart() && getStart().isAfter(d) )
            return false;

        if ( hasEnd() && getEnd().isBefore(d) )
            return false;

        return true;
    }

    public boolean containsExclusive(KmMonth d)
    {
        if ( d == null )
            return false;

        if ( hasStart() && getStart().isOnOrAfter(d) )
            return false;

        if ( hasEnd() && getEnd().isOnOrBefore(d) )
            return false;

        return true;
    }

    public boolean contains(KmMonthRange di)
    {
        return containsInclusive(di);
    }

    public boolean containsInclusive(KmMonthRange di)
    {
        if ( di == null )
            return false;

        return containsInclusive(di.getStart()) && containsInclusive(di.getEnd());
    }

    public boolean containsExclusive(KmMonthRange di)
    {
        if ( di == null )
            return false;

        return containsExclusive(di.getStart()) && containsExclusive(di.getEnd());
    }

    public boolean intersects(KmMonthRange di)
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

    public KmMonthRange getIntersection(KmMonthRange di)
    {
        if ( !intersects(di) )
            return null;

        KmMonthRange x = di.getCopy();

        if ( x.contains(getStart()) )
            x.setStart(getStart());

        if ( x.contains(getEnd()) )
            x.setEnd(getEnd());

        return x;
    }

    //##################################################
    //# utility
    //##################################################

    public int getMonths()
    {
        return _end.toEpochMonths() - _start.toEpochMonths() + 1;
    }

    //##################################################
    //# copy
    //##################################################

    public KmMonthRange getCopy()
    {
        KmMonthRange e = new KmMonthRange();

        if ( hasStart() )
            e.setStart(getStart());

        if ( hasEnd() )
            e.setEnd(getEnd());

        return e;
    }

    //##################################################
    //# conversion
    //##################################################

    public KmList<KmMonth> toList()
    {
        KmList<KmMonth> v = new KmList<>();

        for ( KmMonth e : this )
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
     * Return the months in a standard format for display to users.
     */
    public String format()
    {
        KmMonth start = getStart();
        KmMonth end = getEnd();

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
