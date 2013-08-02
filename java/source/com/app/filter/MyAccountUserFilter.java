package com.app.filter;

import com.app.criteria.MyAccountUserCriteria;
import com.app.filter.base.MyAccountUserFilterBase;

import com.kodemore.utility.KmNamedEnumIF;

public class MyAccountUserFilter
    extends MyAccountUserFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        Role("Role");

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

    private String  _accountUid;
    private boolean _usesAccountUid;

    private String  _userUid;
    private boolean _usesUserUid;

    private String  _role;
    private boolean _usesRole;

    //##################################################
    //# account uid
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

    public boolean usesAccountUid()
    {
        return _usesAccountUid;
    }

    //##################################################
    //# user uid
    //##################################################

    public String getUserUid()
    {
        return _userUid;
    }

    public void setUserUid(String e)
    {
        _userUid = e;
        _usesUserUid = true;
    }

    public boolean usesUserUid()
    {
        return _usesUserUid;
    }

    //##################################################
    //# role
    //##################################################

    public String getRoleCode()
    {
        return _role;
    }

    public void setRoleCode(String e)
    {
        _role = e;
        _usesRole = true;
    }

    public boolean usesRoleCode()
    {
        return _usesRole;
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
    protected void applyConditionsTo(MyAccountUserCriteria c)
    {
        if ( usesAccountUid() )
            c.whereAccountUid().is(getAccountUid());

        if ( usesUserUid() )
            c.whereUserUid().is(getUserUid());

        if ( usesRoleCode() )
            c.whereRoleCode().is(getRoleCode());
    }

    @Override
    protected void applySortsTo(MyAccountUserCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Uid:
                c.sortOnUid(asc);
                break;

            case Role:
                c.sortOnRoleCode();
                break;
        }
    }

}
