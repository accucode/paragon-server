package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyAutoSignInBase;
import com.app.utility.MyConstantsIF;

public class MyAutoSignIn
    extends MyAutoSignInBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoSignIn()
    {
        super();
    }

    //##################################################
    //# accessing
    //##################################################

    public void touch()
    {
        setLastTouchedUtcTs(getNowUtc());
    }

    public boolean isFresh()
    {
        return !isStale();
    }

    public boolean isStale()
    {
        int timeoutDays = MyConstantsIF.AUTO_SIGN_IN_TIMEOUT_DAYS;

        KmTimestamp lastTouch = getLastTouchedUtcTs();
        KmTimestamp limit = lastTouch.addDays(timeoutDays);
        boolean isPast = getNowUtc().isAfter(limit);

        return isPast;
    }
}
