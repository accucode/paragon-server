package com.app.filter;

import com.app.criteria.MyUserCriteria;
import com.app.criteria.MyUserJunction;
import com.app.filter.base.MyUserFilterBase;
import com.app.model.MyAccount;

import com.kodemore.utility.KmNamedEnumIF;

public class MyUserFilter
    extends MyUserFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        Name("Name"),
        Email("Email");

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

    private String  _accountUid;
    private boolean _usesAccountUid;

    private String  _email;
    private boolean _usesEmail;

    private String  _emailSubstring;
    private boolean _usesEmailSubstring;

    private String  _looseName;
    private boolean _usesLooseName;

    private Sort    _sort;
    private boolean _sortAscending;

    //##################################################
    //# account
    //##################################################

    public String getAccountUid()
    {
        return _accountUid;
    }

    public void setAccountUid(String e)
    {
        _accountUid = e;
        _usesAccountUid = true;
    }

    public void setAccount(MyAccount e)
    {
        if ( e == null )
            setAccountUid(null);
        else
            setAccountUid(e.getUid());
    }

    public boolean usesAccountUid()
    {
        return _usesAccountUid;
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
    //# sort
    //##################################################

    public void sortOnId()
    {
        sortOn(Sort.Uid);
    }

    public void sortOnName()
    {
        sortOn(Sort.Name);
    }

    public void sortOnEmail()
    {
        sortOn(Sort.Email);
    }

    //##################################################
    //# sort order
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
    //# filter
    //##################################################

    @Override
    public void applyConditionsTo(MyUserCriteria c)
    {
        if ( usesAccountUid() )
            c.joinToAccountUsers().whereAccountUid().is(getAccountUid());

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
            or.whereName().hasSubstring(s);
        }
    }

    @Override
    public void applySortsTo(MyUserCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Uid:
                c.sortOnUid(asc);
                break;

            case Email:
                c.sortOnEmail(asc);
                break;

            case Name:
                c.sortOnName(asc);
                break;
        }
    }

}
