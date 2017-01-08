package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyThreadTopicCriteria;
import com.app.filter.base.MyThreadTopicFilterBase;

public class MyThreadTopicFilter
    extends MyThreadTopicFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Code;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopicFilter()
    {
        sortOnCode();
        sortAscending();
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnCode()
    {
        setSort(Sort.Code);
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
    protected void applyConditionsTo(MyThreadTopicCriteria c)
    {
        // none
    }

    @Override
    protected void applySortsTo(MyThreadTopicCriteria c)
    {
        if ( !usesSort() )
            return;

        Sort sort = getSort();
        boolean asc = getAscending();

        switch ( sort )
        {
            case Code:
                c.sortOnCode(asc);
                break;
        }
    }

}
