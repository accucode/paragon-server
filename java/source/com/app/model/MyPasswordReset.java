package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyPasswordResetBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.ui.page.login.MyPasswordResetPage;

public class MyPasswordReset
    extends MyPasswordResetBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPasswordReset()
    {
        super();

        setExpirationUtcTs(getCreatedUtcTs().addDays(3));
    }

    //##################################################
    //# accessing
    //##################################################

    public void setUser(MyUser u)
    {
        setEmail(u.getEmail());
    }

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
        return MyPasswordResetPage.getInstance().formatEntryUrl(this);
    }

    public MyUser findUser()
    {
        return getAccess().getUserDao().findEmail(getTenant(), getEmail());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getEmail();
    }
}
