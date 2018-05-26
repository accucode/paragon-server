package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyTenantBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.model.support.MyTheme;

public class MyTenant
    extends MyTenantBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String SYSTEM_UID = "system";

    public static final KmTimeZone     DEFAULT_TIME_ZONE      = KmTimeZone.Mountain;
    public static final KmDayFrequency DEFAULT_BUSINESS_DAYS  = KmDayFrequency.MONDAY_THROUGH_FRIDAY;
    public static final KmTime         DEFAULT_BUSINESS_START = KmTime.fromHour(8);
    public static final KmTime         DEFAULT_BUSINESS_END   = KmTime.fromHour(17);

    //##################################################
    //# constructor
    //##################################################

    public MyTenant()
    {
        super();
    }

    //##################################################
    //# constructor
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return this;
    }

    //##################################################
    //# theme
    //##################################################

    public MyTheme getTheme()
    {
        return MyTheme.findCode(getThemeCode());
    }

    public void setTheme(MyTheme e)
    {
        setThemeCode(KmEnumIF.getCodeFor(e));
    }

    @Override
    public String getThemeName()
    {
        return getTheme().getLabel();
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
        setTimeZoneCode(KmTimeZone.getCodeFor(e));
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
    }

    public boolean hasTimeZone(KmTimeZone e)
    {
        return Kmu.isEqual(getTimeZone(), e);
    }

    @Override
    public String getTimeZoneName()
    {
        return hasTimeZone()
            ? getTimeZone().getName()
            : null;
    }

    //##################################################
    //# users
    //##################################################

    public KmList<MyUser> getUsersByFullName()
    {
        return getUsers().toList(e -> e.getFullName());
    }

    public KmList<MyUser> getEnabledUsersByFullName()
    {
        return getUsersByFullName().select(e -> e.isEnabled());
    }

    public MyUser findUserEmail(String email)
    {
        for ( MyUser e : getBaseUsers() )
            if ( e.hasEmail(email) )
                return e;
        return null;
    }

    //##################################################
    //# projects
    //##################################################

    public KmList<MyProject> getProjectsByName()
    {
        return getProjects().toList(e -> e.getName().toLowerCase());
    }

    public KmList<MyProject> getEnabledProjectsByName()
    {
        return getProjectsByName().select(e -> e.isEnabled());
    }

    //##################################################
    //# format
    //##################################################

    private String formatName()
    {
        return hasName()
            ? getName()
            : KmConstantsIF.NONE;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return formatName();
    }

    @Override
    public String getDomainTitle()
    {
        return formatName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

}
