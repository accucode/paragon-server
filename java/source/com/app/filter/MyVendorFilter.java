package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyVendorCriteria;
import com.app.filter.base.MyVendorFilterBase;
import com.app.model.MyProject;

public class MyVendorFilter
    extends MyVendorFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Name,
        Uid;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private MyProject _project;
    private boolean   _usesProject;

    private boolean _enabled;
    private boolean _usesEnabled;

    //##################################################
    //# constructor
    //##################################################

    public MyVendorFilter()
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
    //# active
    //##################################################

    public boolean isEnabled()
    {
        return _enabled;
    }

    public void setEnabled(boolean e)
    {
        _enabled = e;
        _usesEnabled = true;
    }

    public void setEnabled()
    {
        setEnabled(true);
    }

    public boolean usesEnabled()
    {
        return _usesEnabled;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyVendorCriteria c)
    {
        if ( usesProject() )
            c.whereProjectIs(getProject());

        if ( usesEnabled() )
            c.whereEnabled().is(isEnabled());
    }

    @Override
    protected void applySortsTo(MyVendorCriteria c)
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

            case Uid:
                c.sortOnUid(asc);
                break;
        }
    }
}
