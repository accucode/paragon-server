package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyProjectCriteria;
import com.app.filter.base.MyProjectFilterBase;

public class MyProjectFilter
    extends MyProjectFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        Name;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private String  _nameSubstring;
    private boolean _usesNameSubstring;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectFilter()
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
    //# name substring
    //##################################################

    public String getNameSubstring()
    {
        return _nameSubstring;
    }

    public void setNameSubstring(String e)
    {
        _nameSubstring = e;
        _usesNameSubstring = true;
    }

    public boolean usesNameSubstring()
    {
        return _usesNameSubstring;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyProjectCriteria c)
    {
        if ( usesNameSubstring() )
            c.whereName().hasSubstring(getNameSubstring());
    }

    @Override
    protected void applySortsTo(MyProjectCriteria c)
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

            case Name:
                c.sortOnName(asc);
                break;
        }
    }

}
