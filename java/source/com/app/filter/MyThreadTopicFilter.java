package com.app.filter;

import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.filter.base.*;

public class MyThreadTopicFilter
    extends MyThreadTopicFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Code("Code");

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

    public void sortOnCode()
    {
        sortOn(Sort.Code);
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
    protected void applyConditionsTo(MyThreadTopicCriteria c)
    {
        // none
    }

    @Override
    protected void applySortsTo(MyThreadTopicCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Code:
                c.sortOnCode(asc);
                break;
        }
    }

}
