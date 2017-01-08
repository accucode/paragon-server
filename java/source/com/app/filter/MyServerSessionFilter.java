package com.app.filter;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyServerSessionCriteria;
import com.app.filter.base.MyServerSessionFilterBase;

public class MyServerSessionFilter
    extends MyServerSessionFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        CreatedUtcTs;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort        _sort;
    private boolean     _ascending;

    private KmTimestamp _minCreatedUtcTs;
    private boolean     _usesMinCreatedUtcTs;

    private KmTimestamp _maxCreatedUtcTs;
    private boolean     _usesMaxCreatedUtcTs;

    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionFilter()
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

    public void sortOnCreatedUtcTs()
    {
        setSort(Sort.CreatedUtcTs);
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
    //# created utc ts (min)
    //##################################################

    public KmTimestamp getMinCreatedUtcTs()
    {
        return _minCreatedUtcTs;
    }

    public void setMinCreatedUtcTs(KmTimestamp e)
    {
        _minCreatedUtcTs = e;
        _usesMinCreatedUtcTs = true;
    }

    public boolean usesMinCreatedUtcTs()
    {
        return _usesMinCreatedUtcTs;
    }

    //##################################################
    //# created utc ts (max)
    //##################################################

    public KmTimestamp getMaxCreatedUtcTs()
    {
        return _maxCreatedUtcTs;
    }

    public void setMaxCreatedUtcTs(KmTimestamp e)
    {
        _maxCreatedUtcTs = e;
        _usesMaxCreatedUtcTs = true;
    }

    public boolean usesMaxCreatedUtcTs()
    {
        return _usesMaxCreatedUtcTs;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyConditionsTo(MyServerSessionCriteria c)
    {
        if ( usesMinCreatedUtcTs() )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(getMinCreatedUtcTs());

        if ( usesMaxCreatedUtcTs() )
            c.whereCreatedUtcTs().isLessThanOrEqualTo(getMaxCreatedUtcTs());
    }

    @Override
    public void applySortsTo(MyServerSessionCriteria c)
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

            case CreatedUtcTs:
                c.sortOnCreatedUtcTs(asc);
                break;
        }
    }

}
