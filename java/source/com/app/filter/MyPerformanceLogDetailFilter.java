package com.app.filter;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyPerformanceLogDetailCriteria;
import com.app.filter.base.MyPerformanceLogDetailFilterBase;

public class MyPerformanceLogDetailFilter
    extends MyPerformanceLogDetailFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        CreatedUtcTs,
        Name,
        Duration;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private String  _name;
    private boolean _usesName;

    private KmTimestamp _minimumCreatedUtcTs;
    private boolean     _usesMinimumCreatedUtcTs;

    private KmTimestamp _maximumCreatedUtcTs;
    private boolean     _usesMaximumCreatedUtcTs;

    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDetailFilter()
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

    public void sortOnCreatedUtcTs()
    {
        setSort(Sort.CreatedUtcTs);
    }

    public void sortOnDuration()
    {
        setSort(Sort.Duration);
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
    //# min created utc ts
    //##################################################

    public KmTimestamp getMinimumCreatedUtcTs()
    {
        return _minimumCreatedUtcTs;
    }

    public void setMinimumCreatedUtcTs(KmTimestamp e)
    {
        _minimumCreatedUtcTs = e;
        _usesMinimumCreatedUtcTs = true;
    }

    public boolean usesMinimumCreatedUtcTs()
    {
        return _usesMinimumCreatedUtcTs;
    }

    //##################################################
    //# max created utc ts
    //##################################################

    public KmTimestamp getMaximumCreatedUtcTs()
    {
        return _maximumCreatedUtcTs;
    }

    public void setMaximumCreatedUtcTs(KmTimestamp e)
    {
        _maximumCreatedUtcTs = e;
        _usesMaximumCreatedUtcTs = true;
    }

    public boolean usesMaximumCreatedUtcTs()
    {
        return _usesMaximumCreatedUtcTs;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyPerformanceLogDetailCriteria c)
    {
        if ( usesName() )
            c.whereName().is(getName());

        if ( usesMinimumCreatedUtcTs() )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(getMinimumCreatedUtcTs());

        if ( usesMaximumCreatedUtcTs() )
            c.whereCreatedUtcTs().isLessThanOrEqualTo(getMaximumCreatedUtcTs());
    }

    @Override
    protected void applySortsTo(MyPerformanceLogDetailCriteria c)
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

            case Name:
                c.sortOnName(asc);
                c.sortOnUid(asc);
                break;

            case CreatedUtcTs:
                c.sortOnCreatedUtcTs(asc);
                c.sortOnUid(asc);
                break;

            case Duration:
                c.sortOnDurationMs(asc);
                c.sortOnUid(asc);
                break;
        }
    }

}
