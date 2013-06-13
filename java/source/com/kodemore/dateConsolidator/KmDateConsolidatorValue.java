/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import com.kodemore.time.KmDate;

public class KmDateConsolidatorValue
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The date.  Null values are not supported.
     */
    private KmDate _date;

    /**
     * The category.  Null values are allowed, and are the default.
     * Categories can be used to colsolidate multiple series of data
     * across the same date interval.  All values, across all categories
     * are used to determine the date range, and the date intervals.
     * But the numeric values are then averaged within each category.  
     */
    private String _category;

    /**
     * The value for this date.  Null values are not supported.
     */
    private double _value;

    /**
     * The number of original elements used to compute this value.
     * In the simple scenario this default value of 1 result in
     * all values being weighted the same when they are counted
     * towards the consolidated results.  
     * 
     * However, in some cases,
     * the client may be providing values with are themselves the
     * result of a weighted average; in this case the client may
     * provide the original counts to ensure that the weighted
     * averages carry the correct weight when being consolidated.
     * 
     * Defaults to 1.
     */
    private int    _count;

    //##################################################
    //# constructor
    //##################################################

    public KmDateConsolidatorValue()
    {
        _count = 1;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDate getDate()
    {
        return _date;
    }

    public void setDate(KmDate e)
    {
        _date = e;
    }

    public String getCategory()
    {
        return _category;
    }

    public void setCategory(String e)
    {
        _category = e;
    }

    public double getValue()
    {
        return _value;
    }

    public void setValue(double e)
    {
        _value = e;
    }

    public int getCount()
    {
        return _count;
    }

    public void setCount(int e)
    {
        _count = e;
    }
}
