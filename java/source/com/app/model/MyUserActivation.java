package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyUserActivationBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.ui.page.login.MyUserActivationBookmark;
import com.app.ui.page.login.MyUserActivationPage;

public class MyUserActivation
    extends MyUserActivationBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserActivation()
    {
        super();

        setExpirationUtcTs(getCreatedUtcTs().addDays(3));
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean isExpired()
    {
        if ( !hasExpirationUtcTs() )
            return false;

        KmTimestamp expiration = getExpirationUtcTs();
        KmTimestamp now = nowUtc();

        return now.isAfter(expiration);
    }

    public String formatEntryUrl()
    {
        MyUserActivationBookmark e;
        e = MyUserActivationPage.getInstance().newBookmark();
        e.setToken(getToken());
        return e.formatEntryUrlFor(getTenant());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getEmail();
    }

    @Override
    public String getDomainTitle()
    {
        return getEmail();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }
}
