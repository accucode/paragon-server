package com.app.model;

import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyUserBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.model.support.MyPersonNameIF;
import com.app.model.support.MyPersonNameUtility;
import com.app.ui.dashboard.core.MyDashboardOrientationType;
import com.app.ui.dashboard.core.MyDashboardPanelType;
import com.app.utility.MyUtility;

public class MyUser
    extends MyUserBase
    implements MyTenantDomainIF, MyPersonNameIF
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The number of minutes a user needs to be inactive to be condsidered stale.
     */
    private static final int       TIMEOUT_MINUTES   = 10;

    public static final KmTimeZone DEFAULT_TIME_ZONE = KmTimeZone.Mountain;

    /**
     * Root is a special user.
     * We use this to bootstrap the system, and sometimes for testing.
     */
    public static final String     ROOT_EMAIL        = "root";

    /**
     * The user name that we use a placeholder to represent actions
     * performed directly by the system.
     */
    public static final String     SYSTEM_NAME       = "System";

    //##################################################
    //# constructor
    //##################################################

    public MyUser()
    {
        super();

        setTimeZone(DEFAULT_TIME_ZONE);
        setRandomPassword();
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

    public KmTimeZone getTimeZone()
    {
        return KmTimeZone.findCode(getTimeZoneCode());
    }

    public void setTimeZone(KmTimeZone e)
    {
        if ( e == null )
            clearTimeZoneCode();
        else
            setTimeZoneCode(e.getCode());
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
    }

    //##################################################
    //# roles
    //##################################################

    public boolean allowsLogin()
    {
        return isActive();
    }

    public boolean allowsDeveloper()
    {
        return isRoleDeveloper();
    }

    public boolean allowsAdmin()
    {
        return isRoleAdmin() || allowsDeveloper();
    }

    /**
     * Return true if the this user is allowed to manange
     * (e.g.: add/edit) developers.
     */
    public boolean allowsManageDevelopers()
    {
        return allowsDeveloper();
    }

    public boolean allowsClearPassword()
    {
        return allowsDeveloper();
    }

    public boolean allowsProxy()
    {
        return allowsDeveloper();
    }

    /**
     * Return true if this user is allowed to copy projects across
     * different tenants.
     */
    public boolean allowsCrossTenantAccess()
    {
        return allowsDeveloper();
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public String getFullName()
    {
        return MyPersonNameUtility.getFullName(this);
    }

    @Override
    public String getFormalName()
    {
        return MyPersonNameUtility.getFormalName(this);
    }

    @Override
    public String getShortName()
    {
        return MyPersonNameUtility.getShortName(this);
    }

    @Override
    public String getLongName()
    {
        return MyPersonNameUtility.getLongName(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getFullName();
    }

    //##################################################
    //# inactive
    //##################################################

    public boolean isStale()
    {
        KmTimestamp lastTouched = getSessionLastTouchedTs();

        if ( lastTouched == null )
            return true;

        KmTimestamp inactiveTime = KmClock.getUtcTimestamp().subtractMinutes(TIMEOUT_MINUTES);

        if ( lastTouched.isBefore(inactiveTime) )
            return true;

        return false;
    }

    private KmTimestamp getSessionLastTouchedTs()
    {
        MyServerSession ss = getAccess().getServerSessionDao().findLastTouchedFor(this);

        return ss == null
            ? null
            : ss.getLastTouchedUtcTs();
    }

    //##################################################
    //# dashboard orientation
    //##################################################

    public MyDashboardOrientationType getDashboardOrientationType()
    {
        String code = getDashboardOrientationTypeCode();
        return MyDashboardOrientationType.findCode(code);
    }

    public void setDashboardOrientationType(MyDashboardOrientationType e)
    {
        setDashboardOrientationTypeCode(KmEnumIF.getCodeFor(e));
    }

    //##################################################
    //# dashboard panels
    //##################################################

    public MyDashboardPanelType getDashboardPanelTypeA()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeA());
    }

    public MyDashboardPanelType getDashboardPanelTypeB()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeB());
    }

    public MyDashboardPanelType getDashboardPanelTypeC()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeC());
    }

    public MyDashboardPanelType getDashboardPanelTypeD()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeD());
    }

    public MyDashboardPanelType getDashboardPanelTypeE()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeE());
    }

    public MyDashboardPanelType getDashboardPanelTypeF()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeF());
    }

    public MyDashboardPanelType getDashboardPanelTypeG()
    {
        return MyDashboardPanelType.findCode(getDashboardPanelCodeG());
    }

}
