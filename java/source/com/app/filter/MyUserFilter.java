package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyUserCriteria;
import com.app.criteria.MyUserJunction;
import com.app.filter.base.MyUserFilterBase;
import com.app.model.MyTenant;

public class MyUserFilter
    extends MyUserFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        Name,
        Email;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private MyTenant _tenant;
    private boolean  _usesTenant;

    private String  _email;
    private boolean _usesEmail;

    private String  _emailSubstring;
    private boolean _usesEmailSubstring;

    private String  _looseName;
    private boolean _usesLooseName;

    private Boolean _enabled;
    private boolean _usesEnabled;

    //##################################################
    //# constructor
    //##################################################

    public MyUserFilter()
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

    public void sortOnEmail()
    {
        setSort(Sort.Email);
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
    //# tenant
    //##################################################

    public MyTenant getTenant()
    {
        return _tenant;
    }

    public void setTenant(MyTenant e)
    {
        _tenant = e;
        _usesTenant = true;
    }

    public boolean usesTenant()
    {
        return _usesTenant;
    }

    //##################################################
    //# email
    //##################################################

    public String getEmail()
    {
        return _email;
    }

    public void setEmail(String e)
    {
        _email = e;
        _usesEmail = true;
    }

    public boolean usesEmail()
    {
        return _usesEmail;
    }

    //##################################################
    //# email substring
    //##################################################

    public String getEmailSubstring()
    {
        return _emailSubstring;
    }

    public void setEmailSubstring(String e)
    {
        _emailSubstring = e;
        _usesEmailSubstring = true;
    }

    public boolean usesEmailSubstring()
    {
        return _usesEmailSubstring;
    }

    //##################################################
    //# loose name
    //##################################################

    public String getLooseName()
    {
        return _looseName;
    }

    public void setLooseName(String e)
    {
        _looseName = e;
        _usesLooseName = true;
    }

    public boolean usesLooseName()
    {
        return _usesLooseName;
    }

    //##################################################
    //# enabled
    //##################################################

    public Boolean getEnabled()
    {
        return _enabled;
    }

    public void setEnabled(Boolean e)
    {
        _enabled = e;
        _usesEnabled = true;
    }

    public boolean usesEnabled()
    {
        return _usesEnabled;
    }

    //##################################################
    //# filter
    //##################################################

    @Override
    public void applyConditionsTo(MyUserCriteria c)
    {
        if ( usesTenant() )
            c.whereTenantIs(getTenant());

        if ( usesEmail() )
            c.whereEmail().is(getEmail());

        if ( usesEmailSubstring() )
            c.whereEmail().hasSubstring(getEmailSubstring());

        if ( usesLooseName() )
        {
            String s = getLooseName();

            MyUserJunction or;
            or = c.addOr();
            or.whereEmail().hasSubstring(s);
            or.whereFirstName().hasSubstring(s);
            or.whereLastName().hasSubstring(s);
            or.whereNickname().hasSubstring(s);
        }

        if ( usesEnabled() )
            c.whereEnabled().is(getEnabled());
    }

    @Override
    public void applySortsTo(MyUserCriteria c)
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

            case Email:
                c.sortOnEmail(asc);
                break;

            case Name:
                c.sortOnFirstName(asc);
                c.sortOnLastName(asc);
                c.sortOnNickname(asc);
                break;
        }
    }

}
