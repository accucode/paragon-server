package com.app.filter;

import com.app.criteria.MySystemLogTraceCriteria;
import com.app.filter.base.MySystemLogTraceFilterBase;

import com.kodemore.utility.KmNamedEnumIF;

public class MySystemLogTraceFilter
    extends MySystemLogTraceFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Id("Id");

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
        sortOn(Sort.Id);
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
    public void applyConditionsTo(MySystemLogTraceCriteria c)
    {
        // none
    }

    @Override
    public void applySortsTo(MySystemLogTraceCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Id:
                c.sortOnId(asc);
                break;
        }
    }

}
