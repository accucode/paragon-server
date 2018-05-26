package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyAttachmentCriteria;
import com.app.filter.base.MyAttachmentFilterBase;
import com.app.model.MyAttachmentOwnerIF;
import com.app.model.base.MyAttachmentType;

public class MyAttachmentFilter
    extends MyAttachmentFilterBase
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

    private MyAttachmentOwnerIF _owner;
    private boolean             _usesOwner;

    private MyAttachmentType _type;
    private boolean          _usesType;

    private boolean _enabled;
    private boolean _usesEnabled;

    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentFilter()
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
    //# owner
    //##################################################

    public MyAttachmentOwnerIF getOwner()
    {
        return _owner;
    }

    public void setOwner(MyAttachmentOwnerIF e)
    {
        _owner = e;
        _usesOwner = true;
    }

    public boolean usesOwner()
    {
        return _usesOwner;
    }

    //##################################################
    //# type
    //##################################################

    public MyAttachmentType getType()
    {
        return _type;
    }

    public void setType(MyAttachmentType e)
    {
        _type = e;
        _usesType = true;
    }

    public boolean usesType()
    {
        return _usesType;
    }

    //##################################################
    //# active
    //##################################################

    public boolean isEnabled()
    {
        return _enabled;
    }

    public void setEnabled(boolean enabled)
    {
        _enabled = enabled;
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
    protected void applyConditionsTo(MyAttachmentCriteria c)
    {
        if ( usesOwner() )
            getOwner().applyAttachmentOwnerTo(c);

        if ( usesType() )
            c.whereTypeIs(getType());

        if ( usesEnabled() )
            c.whereEnabled().is(isEnabled());
    }

    @Override
    protected void applySortsTo(MyAttachmentCriteria c)
    {
        if ( !usesSort() )
            return;

        Sort sort = getSort();
        boolean asc = getAscending();

        switch ( sort )
        {
            case Name:
                c.sortOnName(asc);
                c.sortOnUid(asc);
                break;

            case Uid:
                c.sortOnUid(asc);
                break;
        }
    }
}
