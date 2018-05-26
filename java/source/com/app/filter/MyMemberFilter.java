package com.app.filter;

import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyMemberCriteria;
import com.app.criteria.MyUserJunction;
import com.app.filter.base.MyMemberFilterBase;

public class MyMemberFilter
    extends MyMemberFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        Role;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private String  _projectUid;
    private boolean _usesProjectUid;

    private String  _userUid;
    private boolean _usesUserUid;

    private String  _userNameSubstring;
    private boolean _usesUserNameSubstring;

    private String  _role;
    private boolean _usesRole;

    private String  _projectNameSubstring;
    private boolean _usesProjectNameSubstring;

    private String  _projectType;
    private boolean _usesProjectType;

    //##################################################
    //# constructor
    //##################################################

    public MyMemberFilter()
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
    //# account uid
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
    //# user name
    //##################################################

    public String getUserNameSubstring()
    {
        return _userNameSubstring;
    }

    public void setUserNameSubstring(String e)
    {
        _userNameSubstring = e;
        _usesUserNameSubstring = true;
    }

    public boolean usesUserNameSubstring()
    {
        return _usesUserNameSubstring;
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
    //# project name substring
    //##################################################

    public String getProjectNameSubstring()
    {
        return _projectNameSubstring;
    }

    public void setProjectNameSubstring(String e)
    {
        _projectNameSubstring = e;
        _usesProjectNameSubstring = true;
    }

    public boolean usesProjectNameSubstring()
    {
        return _usesProjectNameSubstring;
    }

    //##################################################
    //# project type
    //##################################################

    public String getProjectTypeCode()
    {
        return _projectType;
    }

    public void setProjectTypeCode(String e)
    {
        _projectType = e;
        _usesProjectType = true;
    }

    public boolean usesProjectTypeCode()
    {
        return _usesProjectType;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyMemberCriteria c)
    {
        if ( usesProjectUid() )
            c.whereProjectUid().is(getProjectUid());

        if ( usesUserUid() )
            c.whereUserUid().is(getUserUid());

        if ( usesUserNameSubstring() )
        {
            String s = getUserNameSubstring();

            MyUserJunction or;
            or = c.joinToUser().addOr();
            or.whereFirstName().hasSubstring(s);
            or.whereLastName().hasSubstring(s);
            or.whereNickname().hasSubstring(s);
        }

        if ( usesRoleCode() )
            c.whereRoleCode().is(getRoleCode());

        if ( usesProjectNameSubstring() )
            c.joinToProject().whereName().hasSubstring(getProjectNameSubstring());
    }

    @Override
    protected void applySortsTo(MyMemberCriteria c)
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

            case Role:
                c.sortOnRoleCode();
                break;
        }
    }

}
