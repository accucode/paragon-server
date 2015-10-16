package com.app.filter;

import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.filter.base.*;

public class MyCustomerContactFilter
    extends MyCustomerContactFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid");

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

    private Sort _sort;
    private boolean _sortAscending;

    //##################################################
    //# sort
    //##################################################

    public void sortOnUid()
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
    protected void applyConditionsTo(MyCustomerContactCriteria c)
    {
        // none
    }

    @Override
    protected void applySortsTo(MyCustomerContactCriteria c)
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
