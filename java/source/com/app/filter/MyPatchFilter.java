package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyPatchCriteria;
import com.app.filter.base.MyPatchFilterBase;

public class MyPatchFilter
    extends MyPatchFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Name;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    //##################################################
    //# constructor
    //##################################################

    public MyPatchFilter()
    {
        sortOnName();
        sortAscending();
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnName()
    {
        setSort(Sort.Name);
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
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyPatchCriteria c)
    {
        // none
    }

    @Override
    protected void applySortsTo(MyPatchCriteria c)
    {
        if ( !usesSort() )
            return;

        Sort sort = getSort();
        boolean asc = getAscending();

        switch ( sort )
        {
            case Name:
                c.sortOnName(asc);
                break;
        }
    }

}
