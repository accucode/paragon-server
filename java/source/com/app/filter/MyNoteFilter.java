package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyNoteCriteria;
import com.app.filter.base.MyNoteFilterBase;

public class MyNoteFilter
    extends MyNoteFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    //##################################################
    //# constructor
    //##################################################

    public MyNoteFilter()
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
    protected void applyConditionsTo(MyNoteCriteria c)
    {
        // none
    }

    @Override
    protected void applySortsTo(MyNoteCriteria c)
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
        }
    }

}
