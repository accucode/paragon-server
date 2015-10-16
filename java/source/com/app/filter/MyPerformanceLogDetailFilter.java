package com.app.filter;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmNamedEnumIF;

import com.app.criteria.MyPerformanceLogDetailCriteria;
import com.app.filter.base.MyPerformanceLogDetailFilterBase;

public class MyPerformanceLogDetailFilter
    extends MyPerformanceLogDetailFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        CreatedUtcTs("CreatedUtcTs"),
        Name("Name"),
        Duration("Duration");

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

    private KmTimestamp _minimumCreatedUtcTs;
    private boolean     _usesMinimumCreatedUtcTs;

    private KmTimestamp _maximumCreatedUtcTs;
    private boolean     _usesMaximumCreatedUtcTs;

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
    //# sort
    //##################################################

    public void sortOnUid()
    {
        sortOn(Sort.Uid);
    }

    public void sortOnCreatedUtcTs()
    {
        sortOn(Sort.CreatedUtcTs);
    }

    public void sortOnName()
    {
        sortOn(Sort.Name);
    }

    public void sortOnDuration()
    {
        sortOn(Sort.Duration);
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

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Uid:
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

            case Name:
                c.sortOnName(asc);
                c.sortOnUid(asc);
                break;
        }
    }

}
