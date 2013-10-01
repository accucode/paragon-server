package com.app.filter;

import com.app.criteria.MyEmailPartCriteria;
import com.app.filter.base.MyEmailPartFilterBase;

import com.kodemore.utility.KmNamedEnumIF;

public class MyEmailPartFilter
    extends MyEmailPartFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Id");

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

    private Sort    _sort;
    private boolean _sortAscending;

    //##################################################
    //# sort
    //##################################################

    public void sortOnId()
    {
        sortOn(Sort.Uid);
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
    public void applyConditionsTo(MyEmailPartCriteria c)
    {
        // none
    }

    @Override
    public void applySortsTo(MyEmailPartCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Uid:
                c.sortOnUid(asc);
                break;
        }
    }

}
