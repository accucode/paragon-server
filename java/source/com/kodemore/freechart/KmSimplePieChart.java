/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I am used to create simple pie charts using the JFreeChart library.
 * I currently assume a single series.
 */
public class KmSimplePieChart
    extends KmAbstractChart
{
    //##################################################
    //# variables
    //##################################################

    private KmList<String> _names;
    private KmList<Double> _values;
    private boolean        _legend;

    /**
     * By default, null values are displayed as zeroes.
     */
    private boolean        _skipNullValues;

    //##################################################
    //# constructor
    //##################################################

    public KmSimplePieChart()
    {
        _names = new KmList<String>();
        _values = new KmList<Double>();
        _legend = false;
    }

    //##################################################
    //# accessing
    //##################################################

    public void addValue(String name, Integer value)
    {
        addValue(name, Kmu.toDouble(value));
    }

    public void addValue(String name, Double value)
    {
        if ( value == null )
        {
            if ( _skipNullValues )
                return;

            value = 0.0;
        }

        _names.add(name);
        _values.add(value);
    }

    public boolean getLegend()
    {
        return _legend;
    }

    public void setLegend(boolean e)
    {
        _legend = e;
    }

    public boolean getSkipNullValues()
    {
        return _skipNullValues;
    }

    public void setSkipNullValues(boolean e)
    {
        _skipNullValues = e;
    }

    //##################################################
    //# support
    //##################################################

    @Override
    protected JFreeChart createAbstractChart()
    {
        DefaultPieDataset ds = new DefaultPieDataset();
        int n = _names.size();
        for ( int i = 0; i < n; i++ )
            ds.setValue(_names.get(i), _values.get(i));

        boolean tooltips = false;
        boolean urls = false;

        return ChartFactory.createPieChart3D("", ds, getLegend(), tooltips, urls);
    }
}
