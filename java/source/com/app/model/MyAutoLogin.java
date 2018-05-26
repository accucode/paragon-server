package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyAutoLoginBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.ui.servlet.MyServletConstantsIF;

public class MyAutoLogin
    extends MyAutoLoginBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoLogin()
    {
        super();
    }

    //##################################################
    //# tenant
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getUser().getTenant();
    }

    //##################################################
    //# accessing
    //##################################################

    public void touch()
    {
        setLastTouchedUtcTs(nowUtc());
    }

    public boolean isFresh()
    {
        return !isStale();
    }

    public boolean isStale()
    {
        int timeoutDays = MyServletConstantsIF.AUTO_SIGN_IN_TIMEOUT_DAYS;

        KmTimestamp lastTouch = getLastTouchedUtcTs();
        KmTimestamp limit = lastTouch.addDays(timeoutDays);
        boolean isPast = nowUtc().isAfter(limit);

        return isPast;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getUserFullName();
    }

    @Override
    public String getDomainTitle()
    {
        return getUserFullName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getLastTouchedUtcTs().formatLocal();
    }
}
