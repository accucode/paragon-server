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

package com.kodemore.freechart;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.utility.Kmu;

/**
 * I am used with the KmSimpleBarChart to collect and manage
 * information about each series of points.
 */
public class KmSimpleBarChartGroup
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The display name.
     */
    private String _name;

    /**
     * The category names, and values.
     * Null category names are NOT supported.
     * NULL values ARE supported, the actual handling depends on the chart.
     */
    private KmOrderedMap<String,Double> _values;

    //##################################################
    //# constructor
    //##################################################

    public KmSimpleBarChartGroup()
    {
        _values = new KmOrderedMap<>();
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqual(getName(), e);
    }

    //##################################################
    //# value
    //##################################################

    public void addValue(Integer category, Integer value)
    {
        addValue(category + "", value);
    }

    public void addValue(String category, Integer value)
    {
        addValue(category, Kmu.toDouble(value));
    }

    public void addValue(String category, Double value)
    {
        _values.put(category, value);
    }

    public KmList<String> getCategoryNames()
    {
        return _values.getKeys();
    }

    public Double getValueFor(String categoryName)
    {
        return _values.get(categoryName);
    }

    public KmList<Double> getDistinctValues()
    {
        KmList<Double> v;
        v = _values.getValues();
        v.removeDuplicates();
        return v;
    }
}
