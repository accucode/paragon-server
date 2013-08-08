package com.app.model;

import com.app.model.base.MyUserBase;
import com.app.utility.MyUtility;

import com.kodemore.utility.Kmu;

public class MyUser
    extends MyUserBase
{
    //##################################################
    //# constants
    //##################################################

    public static final String     ROOT_UID          = "root";

    public static final MyTimeZone DEFAULT_TIME_ZONE = MyTimeZone.MSTD;

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

    public MyTimeZone getTimeZone()
    {
        return MyTimeZone.findCode(getTimeZoneCode());
    }

    public void setTimeZone(MyTimeZone e)
    {
        if ( e == null )
            setTimeZoneCode(null);
        else
            setTimeZoneCode(e.getCode());
    }

    //##################################################
    //# roles
    //##################################################

    public boolean allowsAdmin()
    {
        return isRoleAdmin() || isRoleDeveloper();
    }

    public boolean allowsDeveloper()
    {
        return isRoleDeveloper();
    }

    public boolean allowsLogin()
    {
        return isVerified();
    }

}
