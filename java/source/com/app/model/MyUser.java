package com.app.model;

import java.time.ZoneId;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmTimeConstantsIF;
import com.kodemore.time.KmTimeZoneUtility;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserBase;
import com.app.utility.MyUtility;

public class MyUser
    extends MyUserBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyUser()
    {
        super();

        setTimeZone(KmTimeConstantsIF.DENVER_ZONE);
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

    public ZoneId getTimeZone()
    {
        return KmTimeZoneUtility.getZoneOrUtc(getTimeZoneCode());
    }

    public void setTimeZone(ZoneId e)
    {
        if ( e == null )
            setTimeZoneCode(null);
        else
            setTimeZoneCode(e.getId());
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
