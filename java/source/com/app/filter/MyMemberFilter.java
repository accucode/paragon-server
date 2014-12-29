package com.app.filter;

import com.kodemore.utility.KmNamedEnumIF;

import com.app.criteria.MyMemberCriteria;
import com.app.filter.base.MyMemberFilterBase;

public class MyMemberFilter
    extends MyMemberFilterBase
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
    protected void applyConditionsTo(MyMemberCriteria c)
    {
        if ( usesProjectUid() )
            c.whereProjectUid().is(getProjectUid());

        if ( usesUserUid() )
            c.whereUserUid().is(getUserUid());

        if ( usesUserNameSubstring() )
            c.joinToUser().whereName().hasSubstring(getUserNameSubstring());

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
