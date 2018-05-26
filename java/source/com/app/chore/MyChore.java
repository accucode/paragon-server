package com.app.chore;

import com.kodemore.chore.KmChore;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyPerformanceLogBuffer;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public abstract class MyChore
    extends KmChore
{
    //##################################################
    //# logging
    //##################################################

    @Override
    protected void logPerformance(int ms)
    {
        boolean enabled = getProperties().getChorePerformanceLogEnabled();
        if ( enabled )
            MyPerformanceLogBuffer.push("job... " + getName(), ms);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmTimestamp getNowUtc()
    {
        return KmClock.getUtcTimestamp();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
