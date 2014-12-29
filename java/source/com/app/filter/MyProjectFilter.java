package com.app.filter;

import com.kodemore.utility.KmNamedEnumIF;

import com.app.criteria.MyProjectCriteria;
import com.app.filter.base.MyProjectFilterBase;

public class MyProjectFilter
    extends MyProjectFilterBase
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

    private Sort    _sort;
    private boolean _sortAscending;

    private String  _nameSubstring;
    private boolean _usesNameSubstring;

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
