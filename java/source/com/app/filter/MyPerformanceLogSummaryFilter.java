package com.app.filter;

import com.kodemore.time.KmDate;
import com.kodemore.utility.KmNamedEnumIF;

import com.app.criteria.MyPerformanceLogSummaryCriteria;
import com.app.filter.base.MyPerformanceLogSummaryFilterBase;

public class MyPerformanceLogSummaryFilter
    extends MyPerformanceLogSummaryFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        Name("Name"),
        Count("Count"),
        Average("Average"),
        Total("Total");

        private String _name;

        private Sort(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    //##################################################
    //# variables
    //##################################################

    private String  _name;
    private boolean _usesName;

    private KmDate  _minimumDate;
    private boolean _usesMinimumDate;

    private KmDate  _maximumDate;
    private boolean _usesMaximumDate;

    private Sort    _sort;
    private boolean _sortAscending;

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
        _usesName = true;
    }

    public boolean usesName()
    {
        return _usesName;
    }

    //##################################################
    //# min date
    //##################################################

    public KmDate getMinimumDate()
    {
        return _minimumDate;
    }

    public void setMinimumDate(KmDate e)
    {
        _minimumDate = e;
        _usesMinimumDate = true;
    }

    public boolean usesMinimumDate()
    {
        return _usesMinimumDate;
    }

    //##################################################
    //# max date
    //##################################################

    public KmDate getMaximumDate()
    {
        return _maximumDate;
    }

    public void setMaximumDate(KmDate e)
    {
        _maximumDate = e;
        _usesMaximumDate = true;
    }

    public boolean usesMaximumDate()
    {
        return _usesMaximumDate;
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnUid()
    {
        sortOn(Sort.Uid);
    }

    public void sortOnName()
    {
        sortOn(Sort.Name);
    }

    public void sortOnCount()
    {
        sortOn(Sort.Count);
    }

    public void sortOnAverage()
    {
        sortOn(Sort.Average);
    }

    public void sortOnTotal()
    {
        sortOn(Sort.Total);
    }

    //##################################################
    //# sort (support)
    //##################################################

    public void sortOn(int i)
    {
        sortOn(Sort.values()[i]);
    }

    public void sortOn(Sort e)
    {
        _sort = e;
    }

    public boolean usesSort()
    {
        return _sort != null;
    }

    //##################################################
    //# sort order
    //##################################################

    public void sortAscending()
    {
        sortAscending(true);
    }

    public void sortAscending(boolean e)
    {
        _sortAscending = e;
    }

    public void sortDescending()
    {
        sortAscending(false);
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyPerformanceLogSummaryCriteria c)
    {
        if ( usesName() )
            c.whereName().is(getName());

        if ( usesMinimumDate() )
            c.whereUtcDate().isGreaterThanOrEqualTo(getMinimumDate());

        if ( usesMaximumDate() )
            c.whereUtcDate().isLessThanOrEqualTo(getMaximumDate());
    }

    @Override
    protected void applySortsTo(MyPerformanceLogSummaryCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Uid:
                c.sortOnUid(asc);
                break;

            case Average:
                c.sortOnAverageMs(asc);
                c.sortOnUid(asc);
                break;

            case Count:
                c.sortOnCount(asc);
                c.sortOnUid(asc);
                break;

            case Name:
                c.sortOnName(asc);
                c.sortOnUid(asc);
                break;

            case Total:
                c.sortOnTotalMs(asc);
                c.sortOnUid(asc);
                break;
        }
    }

}
