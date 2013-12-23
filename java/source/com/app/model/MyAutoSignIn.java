package com.app.model;

import com.kodemore.time.KmTimestamp;

import com.app.model.base.MyAutoSignInBase;

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
        // todo_wyatt: auto sign in timeout
        int timeoutDays = 1;

        KmTimestamp lastTouch = getLastTouchedUtcTs();
        KmTimestamp limit = lastTouch.addDays(timeoutDays);
        boolean isPast = getNowUtc().isAfter(limit);

        return isPast;
    }
}
