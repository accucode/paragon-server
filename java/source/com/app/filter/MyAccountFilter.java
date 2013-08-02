package com.app.filter;

import com.app.criteria.MyAccountCriteria;
import com.app.filter.base.MyAccountFilterBase;

import com.kodemore.utility.KmNamedEnumIF;

public class MyAccountFilter
    extends MyAccountFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        Name("Name"),
        Type("Type");

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

    private String  _type;
    private boolean _usesType;

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
    //# type
    //##################################################

    public String getTypeCode()
    {
        return _type;
    }

    public void setTypeCode(String e)
    {
        _type = e;
        _usesType = true;
    }

    public boolean usesTypeCode()
    {
        return _usesType;
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
    protected void applyConditionsTo(MyAccountCriteria c)
    {

        if ( usesNameSubstring() )
            c.whereName().hasSubstring(getNameSubstring());

        if ( usesTypeCode() )
            c.whereTypeCode().is(getTypeCode());
    }

    @Override
    protected void applySortsTo(MyAccountCriteria c)
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

            case Type:
                c.sortOnTypeCode(asc);
                break;
        }
    }

}
