package com.app.filter;

import com.kodemore.utility.KmNamedEnumIF;

import com.app.criteria.MyProductCategoryCriteria;
import com.app.filter.base.MyProductCategoryFilterBase;
import com.app.model.MyProject;

public class MyProductCategoryFilter
    extends MyProductCategoryFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        Name("Name");

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

    private String  _projectUid;
    private boolean _usesProjectUid;

    private Sort    _sort;
    private boolean _sortAscending;

    //##################################################
    //# project
    //##################################################

    public String getProjectUid()
    {
        return _projectUid;
    }

    public void setProjectUid(String e)
    {
        _projectUid = e;
        _usesProjectUid = true;
    }

    public boolean usesProjectUid()
    {
        return _usesProjectUid;
    }

    public void setProject(MyProject e)
    {
        if ( e == null )
            setProjectUid(null);
        else
            setProjectUid(e.getUid());
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnUid()
    {
        sortOn(Sort.Uid);
    }

    public void sortOnName()
    {
        sortOn(Sort.Name);
    }

    //==================================================
    //= sort (support)
    //==================================================

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

    //==================================================
    //= sort order
    //==================================================

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
    protected void applyConditionsTo(MyProductCategoryCriteria c)
    {
        if ( usesProjectUid() )
            c.whereProjectUid().is(getProjectUid());
    }

    @Override
    protected void applySortsTo(MyProductCategoryCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
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
