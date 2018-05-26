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

package com.kodemore.dateConsolidator;

import com.kodemore.comparator.KmComparator;
import com.kodemore.comparator.KmCompositeComparator;
import com.kodemore.time.KmDate;

public class KmDateConsolidatorResult
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The interval's start date.
     */
    private KmDate _startDate;

    /**
     * The interval's end date.
     */
    private KmDate _endDate;

    /**
     * The average value for this interval.
     */
    private double _value;

    /**
     * The number of input values that counted towards this group.
     */
    private int _count;

    /**
     * A display label, typically suitable for display to end users.
     */
    private String _label;

    /**
     * The category, if any.  This is used when consolidating multiple categories
     * of data over the same date interval.  May be null.
     */
    private String _category;

    //##################################################
    //# constructor
    //##################################################

    public KmDateConsolidatorResult()
    {
        _count = 1;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDate getStartDate()
    {
        return _startDate;
    }

    public void setStartDate(KmDate e)
    {
        _startDate = e;
    }

    public KmDate getEndDate()
    {
        return _endDate;
    }

    public void setEndDate(KmDate e)
    {
        _endDate = e;
    }

    public double getValue()
    {
        return _value;
    }

    public void setValue(double e)
    {
        _value = e;
    }

    public int getIntegerValue()
    {
        return (int)getValue();
    }

    public int getCount()
    {
        return _count;
    }

    public void setCount(int e)
    {
        _count = e;
    }

    public String getLabel()
    {
        return _label;
    }

    public void setLabel(String e)
    {
        _label = e;
    }

    public String getCategory()
    {
        return _category;
    }

    public void setCategory(String e)
    {
        _category = e;
    }

    //##################################################
    //# static comparators
    //##################################################

    public static KmComparator<KmDateConsolidatorResult> getCategoryComparator()
    {
        return new KmComparator<KmDateConsolidatorResult>()
        {
            @Override
            public int compare(KmDateConsolidatorResult a, KmDateConsolidatorResult b)
            {
                return c(a.getCategory(), b.getCategory());
            }
        };
    }

    public static KmComparator<KmDateConsolidatorResult> getStartDateComparator()
    {
        return new KmComparator<KmDateConsolidatorResult>()
        {
            @Override
            public int compare(KmDateConsolidatorResult a, KmDateConsolidatorResult b)
            {
                return c(a.getStartDate(), b.getStartDate());
            }
        };
    }

    public static KmComparator<KmDateConsolidatorResult> getCategoryDateComparator()
    {
        KmCompositeComparator<KmDateConsolidatorResult> c;
        c = new KmCompositeComparator<>();
        c.add(getCategoryComparator());
        c.add(getStartDateComparator());
        return c;
    }
}
