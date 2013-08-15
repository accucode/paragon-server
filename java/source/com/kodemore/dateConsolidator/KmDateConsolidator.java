/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmTwoKeyMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;
import com.kodemore.time.KmWeekDay;
import com.kodemore.utility.Kmu;

/**
 * I am used to consolidate dated values into some limited number of groups.
 * For example, this can be used to easily consolidate stats for 100's or 1000's 
 * of individual dates into averages by week, month or year; depending on the 
 * maximum number of groups desired.
 * 
 * Sample usage...
 * 
 *      KmDateConsolidator c;
 *      c = new KmDateConsolidator();
 *      c.setMaximumGroupCount(15);
 *      c.addValue(date1, value1);
 *      c.addValue(date2, value2);
 *      ...
 *      c.run();
 *      c.getResults();
 */
public class KmDateConsolidator
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The list of input values.  Input values MAY contain duplicate dates.
     */
    private KmList<KmDateConsolidatorValue>                            _values;

    /**
     * An internally generated map, this provides effecient access
     * to the input values for a particular category and date.
     */
    private KmTwoKeyMap<String,KmDate,KmList<KmDateConsolidatorValue>> _valueMap;

    /**
     * The maximum number of date groups desired.  This max will be strictly adhered 
     * to except in the case where the using the largest unit (currently years)
     * still exceeds the max.  If null, then the data will be grouped by date,
     * with no maximum number of groups. 
     */
    private Integer                                                    _maxGroupCount;

    /**
     * The minimum date in the input set.
     */
    private KmDate                                                     _minDate;

    /**
     * The maximum date in the input set.
     */
    private KmDate                                                     _maxDate;

    /**
     * The day used as the start of each week.  This is used
     * when grouping information by week.  Defaults to Monday.
     */
    private KmWeekDay                                                  _startOfWeek;

    /**
     * The generated list of output values.
     */
    private KmList<KmDateConsolidatorResult>                           _results;

    //##################################################
    //# constructor
    //##################################################

    public KmDateConsolidator()
    {
        _values = new KmList<KmDateConsolidatorValue>();
        _maxGroupCount = 10;
        _startOfWeek = KmWeekDay.FIRST_DAY;
    }

    //##################################################
    //# accessing (setup)
    //##################################################

    public void addValue(KmDate date, double value)
    {
        String category = null;
        int count = 1;

        addValue(category, date, value, count);
    }

    public void addValue(String category, KmDate date, double value)
    {
        int count = 1;

        addValue(category, date, value, count);
    }

    public void addValue(KmDate date, double value, int count)
    {
        String category = null;

        addValue(category, date, value, count);
    }

    public void addValue(String category, KmDate date, double value, int count)
    {
        KmDateConsolidatorValue e;
        e = new KmDateConsolidatorValue();
        e.setCategory(category);
        e.setDate(date);
        e.setValue(value);
        e.setCount(count);
        _values.add(e);
    }

    public void setMaxGroupCount(Integer e)
    {
        _maxGroupCount = e;
    }

    public void setStartOfWeek(KmWeekDay e)
    {
        _startOfWeek = e;
    }

    //##################################################
    //# accessing (results)
    //##################################################

    public KmList<KmDateConsolidatorResult> getResults()
    {
        return _results;
    }

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        setup();
        consolidate();
    }

    private void setup()
    {
        _minDate = null;
        _maxDate = null;
        _valueMap = new KmTwoKeyMap<String,KmDate,KmList<KmDateConsolidatorValue>>();
        _results = new KmList<KmDateConsolidatorResult>();

        KmList<KmDateConsolidatorValue> inputValue = _values;
        for ( KmDateConsolidatorValue e : inputValue )
        {
            String c = e.getCategory();
            KmDate d = e.getDate();

            _minDate = Kmu.min(_minDate, d);
            _maxDate = Kmu.max(_maxDate, d);

            KmList<KmDateConsolidatorValue> v = _valueMap.get(c, d);
            if ( v == null )
            {
                v = new KmList<KmDateConsolidatorValue>();
                _valueMap.put(c, d, v);
            }
            v.add(e);
        }
    }

    private void consolidate()
    {
        if ( checkDays() )
            return;

        if ( checkWeeks() )
            return;

        if ( checkMonths() )
            return;

        generateYears();
    }

    //##################################################
    //# days
    //##################################################

    private boolean checkDays()
    {
        if ( _maxGroupCount == null || getDayCount() <= _maxGroupCount )
        {
            generateDays();
            return true;
        }

        return false;
    }

    private int getDayCount()
    {
        return _minDate.getDaysTo(_maxDate);
    }

    private void generateDays()
    {
        KmDateInterval di = KmDateInterval.create(_minDate, _maxDate);
        for ( KmDate d : di )
        {
            KmList<KmDateConsolidatorResult> v = consolidate(d);
            for ( KmDateConsolidatorResult e : v )
                applyDayLabelTo(e);
        }
    }

    private void applyDayLabelTo(KmDateConsolidatorResult e)
    {
        String s = e.getStartDate().format_mm_dd_yy();
        e.setLabel(s);
    }

    //##################################################
    //# weeks
    //##################################################

    private boolean checkWeeks()
    {
        if ( getWeekCount() > _maxGroupCount )
            return false;

        generateWeeks();
        return true;
    }

    private int getWeekCount()
    {
        KmDate start = getWeekStartDate();
        KmDate end = getWeekEndDate();

        return start.getDaysTo(end) / 7;
    }

    private void generateWeeks()
    {
        KmDate start = getWeekStartDate();
        KmDate end = getWeekEndDate();

        KmDate next = start;
        while ( next.isBefore(end) )
        {
            KmDate groupStart = next;
            KmDate groupEnd = next.addDays(6);

            KmList<KmDateConsolidatorResult> v = consolidate(groupStart, groupEnd);
            for ( KmDateConsolidatorResult e : v )
                applyWeekLabelTo(e);

            next = next.addWeek();
        }
    }

    private void applyWeekLabelTo(KmDateConsolidatorResult e)
    {
        String s = e.getStartDate().format_mm_dd_yy();
        e.setLabel(s);
    }

    private KmDate getWeekStartDate()
    {
        KmWeekDay weekStart = _startOfWeek;
        return _minDate.getPreviousDayOfWeek(weekStart, true);
    }

    private KmDate getWeekEndDate()
    {
        KmWeekDay weekEnd = _startOfWeek.getPreviousDay();
        return _maxDate.getNextDayOfWeek(weekEnd, true);
    }

    //##################################################
    //# months
    //##################################################

    private boolean checkMonths()
    {
        if ( getMonthCount() > _maxGroupCount )
            return false;

        generateMonths();
        return true;
    }

    private int getMonthCount()
    {
        KmDate start = getMonthStartDate();
        KmDate end = getMonthEndDate();

        int n = 0;
        KmDate d = start;

        while ( d.isBefore(end) )
        {
            n++;
            d = d.addMonth();
        }

        return n;
    }

    private void generateMonths()
    {
        KmDate start = getMonthStartDate();
        KmDate end = getMonthEndDate();

        KmDate next = start;
        while ( next.isBefore(end) )
        {
            KmDate groupStart = next;
            KmDate groupEnd = next.getEndOfMonth();

            KmList<KmDateConsolidatorResult> v = consolidate(groupStart, groupEnd);
            for ( KmDateConsolidatorResult e : v )
                applyMonthLabelTo(e);

            next = next.addMonth();
        }
    }

    private void applyMonthLabelTo(KmDateConsolidatorResult e)
    {
        KmDate d = e.getStartDate();
        String s = Kmu.format("%s %s", d.getMonthAbbreviation(), d.getYear());
        e.setLabel(s);
    }

    private KmDate getMonthStartDate()
    {
        return _minDate.getStartOfMonth();
    }

    private KmDate getMonthEndDate()
    {
        return _maxDate.getEndOfMonth();
    }

    //##################################################
    //# years
    //##################################################

    @SuppressWarnings("unused")
    private boolean checkYears()
    {
        if ( getYearCount() > _maxGroupCount )
            return false;

        generateYears();
        return true;
    }

    private int getYearCount()
    {
        KmDate start = getYearStartDate();
        KmDate end = getYearEndDate();

        int startYear = start.getYear();
        int endYear = end.getYear();

        return endYear - startYear + 1;
    }

    private void generateYears()
    {
        KmDate start = getYearStartDate();
        KmDate end = getYearEndDate();

        KmDate next = start;
        while ( next.isBefore(end) )
        {
            KmDate groupStart = next;
            KmDate groupEnd = next.getEndOfYear();

            KmList<KmDateConsolidatorResult> v = consolidate(groupStart, groupEnd);
            for ( KmDateConsolidatorResult e : v )
                applyYearLabelTo(e);

            next = next.addYear();
        }
    }

    private void applyYearLabelTo(KmDateConsolidatorResult e)
    {
        String s = e.getStartDate().getYear() + "";
        e.setLabel(s);
    }

    private KmDate getYearStartDate()
    {
        return _minDate.getStartOfYear();
    }

    private KmDate getYearEndDate()
    {
        return _maxDate.getEndOfYear();
    }

    //##################################################
    //# support
    //##################################################

    private KmList<KmDateConsolidatorResult> consolidate(KmDate date)
    {
        return consolidate(date, date);
    }

    private KmList<KmDateConsolidatorResult> consolidate(KmDate start, KmDate end)
    {
        KmList<KmDateConsolidatorResult> v = new KmList<KmDateConsolidatorResult>();

        KmList<String> cats = _valueMap.getKeyList1();
        for ( String cat : cats )
        {
            KmDateConsolidatorResult e = consolidate(cat, start, end);
            v.add(e);
        }

        return v;
    }

    private KmDateConsolidatorResult consolidate(String category, KmDate start, KmDate end)
    {
        int count = 0;
        double total = 0.0;
        double value = 0.0;

        KmDateInterval di = KmDateInterval.create(start, end);
        for ( KmDate d : di )
        {
            KmList<KmDateConsolidatorValue> v = _valueMap.get(category, d);
            if ( v != null )
                for ( KmDateConsolidatorValue e : v )
                {
                    count += e.getCount();
                    total += e.getValue();
                }
        }

        if ( count > 0 )
            value = total / count;

        KmDateConsolidatorResult e;
        e = new KmDateConsolidatorResult();
        e.setCategory(category);
        e.setStartDate(start);
        e.setEndDate(end);
        e.setCount(count);
        e.setValue(value);

        _results.add(e);

        return e;
    }
}
