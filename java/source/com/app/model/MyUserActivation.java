package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyUserActivationBase;
import com.app.ui.page.login.MyUserActivationPage;

public class MyUserActivation
    extends MyUserActivationBase
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
        KmTimestamp now = getNowUtc();

        return now.isAfter(expiration);
    }

    public String formatEntryUrl()
    {
        return MyUserActivationPage.instance.formatEntryUrl(this);
    }
}
