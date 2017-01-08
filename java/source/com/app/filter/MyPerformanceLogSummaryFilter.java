package com.app.filter;

import com.kodemore.time.KmDate;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyPerformanceLogSummaryCriteria;
import com.app.filter.base.MyPerformanceLogSummaryFilterBase;

public class MyPerformanceLogSummaryFilter
    extends MyPerformanceLogSummaryFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        Name,
        Count,
        Average,
        Total;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private String  _name;
    private boolean _usesName;

    private KmDate  _minimumDate;
    private boolean _usesMinimumDate;

    private KmDate  _maximumDate;
    private boolean _usesMaximumDate;

    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryFilter()
    {
        sortOnUid();
        sortAscending();
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnUid()
    {
        setSort(Sort.Uid);
    }

    public void sortOnName()
    {
        setSort(Sort.Name);
    }

    public void sortOnCount()
    {
        setSort(Sort.Count);
    }

    public void sortOnAverage()
    {
        setSort(Sort.Average);
    }

    public void sortOnTotal()
    {
        setSort(Sort.Total);
    }

    //==================================================
    //= sort :: accessing
    //==================================================

    public Sort getSort()
    {
        return _sort;
    }

    public void setSort(Sort e)
    {
        _sort = e;
    }

    public void sortOn(int i)
    {
        setSort(Sort.values()[i]);
    }

    public void sortOn(String name)
    {
        setSort(Sort.valueOf(name));
    }

    public boolean usesSort()
    {
        return _sort != null;
    }

    //==================================================
    //= sort :: ascending
    //==================================================

    public boolean getAscending()
    {
        return _ascending;
    }

    public void setAscending(boolean e)
    {
        _ascending = e;
    }

    public void sortAscending()
    {
        setAscending(true);
    }

    public void sortDescending()
    {
        setAscending(false);
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

        Sort sort = getSort();
        boolean asc = getAscending();

        switch ( sort )
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
