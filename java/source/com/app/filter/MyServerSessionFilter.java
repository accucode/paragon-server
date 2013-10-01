package com.app.filter;

import com.app.criteria.MyServerSessionCriteria;
import com.app.filter.base.MyServerSessionFilterBase;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmNamedEnumIF;

public class MyServerSessionFilter
    extends MyServerSessionFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        CreatedUtcTs("Created");

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

    private KmTimestamp _minCreatedUtcTs;
    private boolean     _usesMinCreatedUtcTs;

    private KmTimestamp _maxCreatedUtcTs;
    private boolean     _usesMaxCreatedUtcTs;

    private Sort        _sort;
    private boolean     _sortAscending;

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

        boolean asc = _sortAscending;

        switch ( _sort )
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
