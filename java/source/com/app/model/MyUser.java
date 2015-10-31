package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserBase;
import com.app.utility.MyUtility;

public class MyUser
    extends MyUserBase
{
    //##################################################
    //# constants
    //##################################################

    public static final MyTimeZoneVo DEFAULT_TIME_ZONE = MyTimeZoneVo.MSTD;

    //##################################################
    //# constructor
    //##################################################

    public MyUser()
    {
        super();

        setTimeZone(DEFAULT_TIME_ZONE);
    }

    //##################################################
    //# private
    //##################################################

    private String hashPassword(String e)
    {
        return MyUtility.getPasswordHash(getPasswordSalt(), e);
    }

    //##################################################
    //# convenience
    //##################################################

    public void setPassword(String e)
    {
        setPasswordHash(hashPassword(e));
    }

    public void setRandomPassword()
    {
        setPassword(Kmu.newUid());
    }

    public void clearPassword()
    {
        setPassword(null);
    }

    public boolean hasPassword()
    {
        return hasPasswordHash();
    }

    public boolean hasPassword(String e)
    {
        if ( hasPassword() )
            return hasPasswordHash(hashPassword(e));

        return Kmu.isEmpty(e);
    }

    //##################################################
    //# time zone
    //##################################################

    public MyTimeZoneVo getTimeZone()
    {
        return MyTimeZoneVo.findCode(getTimeZoneCode());
    }

    public void setTimeZone(MyTimeZoneVo e)
    {
        if ( e == null )
            setTimeZoneCode(null);
        else
            setTimeZoneCode(e.getCode());
    }

    //##################################################
    //# roles
    //##################################################

    public boolean allowsLogin()
    {
        return isVerified();
    }

    public boolean allowsDeveloper()
    {
        return isRoleDeveloper();
    }

    public boolean allowsAdmin()
    {
        return isRoleAdmin() || allowsDeveloper();
    }

    //##################################################
    //# projects
    //##################################################

    public KmList<MyMember> getMemberships()
    {
        return getAccess().getMemberDao().findUser(this);
    }

    public KmList<MyProject> getProjects()
    {
        return getMemberships().collect(e -> e.getProject());
    }

    public KmList<MyProject> getProjectsByName()
    {
        KmList<MyProject> v;
        v = getProjects();
        v.sortOn(MyProject::getName);
        return v;
    }

    public KmList<String> getProjectNames()
    {
        return getProjectsByName().collect(e -> e.getName());
    }

    public boolean isMemberOf(MyProject e)
    {
        return getMembershipFor(e) != null;
    }

    public MyMember getMembershipFor(MyProject p)
    {
        for ( MyMember m : getMemberships() )
            if ( m.hasProject(p) )
                return m;

        return null;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
