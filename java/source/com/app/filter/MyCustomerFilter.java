package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyCustomerCriteria;
import com.app.filter.base.MyCustomerFilterBase;
import com.app.model.MyProject;

public class MyCustomerFilter
    extends MyCustomerFilterBase
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

    private MyProject _project;
    private boolean   _usesProject;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerFilter()
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
    //# project
    //##################################################

    public MyProject getProject()
    {
        return _project;
    }

    public void setProject(MyProject e)
    {
        _project = e;
        _usesProject = true;
    }

    public boolean usesProject()
    {
        return _usesProject;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyCustomerCriteria c)
    {
        if ( usesProject() )
            c.whereProjectIs(getProject());
    }

    @Override
    protected void applySortsTo(MyCustomerCriteria c)
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
                c.sortOnUid(asc);
                break;
        }
    }

}
