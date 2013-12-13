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
        // todo_wyatt: rename to last touched?
        setLastUtcTs(getNowUtc());
    }

    public boolean isFresh()
    {
        return !isStale();
    }

    public boolean isStale()
    {
        // todo_wyatt: auto sign in timeout
        int timeoutDays = 1;

        KmTimestamp lastTouch = getLastUtcTs();
        KmTimestamp limit = lastTouch.addDays(timeoutDays);
        boolean isPast = getNowUtc().isAfter(limit);

        return isPast;
    }
}
