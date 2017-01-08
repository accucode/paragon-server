package com.app.model;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyServerSessionBase;
import com.app.model.core.MyTenantDomainIF;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;

public class MyServerSession
    extends MyServerSessionBase
    implements MyTenantDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSession()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public void close()
    {
        setActive(false);
        setClosedUtcTs(nowUtc());
    }

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
        if ( isNotActive() )
            return true;

        if ( hasWrongVersion() )
            return true;

        if ( hasWrongTenant() )
            return true;

        int timeout = getTimeoutSeconds();
        KmTimestamp lastTouch = getLastTouchedUtcTs();
        KmTimestamp limit = lastTouch.addSeconds(timeout);
        boolean isPast = nowUtc().isAfter(limit);
        return isPast;
    }

    private int getTimeoutSeconds()
    {
        return getProperties().getServerSessionTimeoutSeconds();
    }

    private boolean hasRightVersion()
    {
        return Kmu.isEqual(getVersion(), MyConstantsIF.APPLICATION_VERSION);
    }

    private boolean hasWrongVersion()
    {
        return !hasRightVersion();
    }

    private boolean hasWrongTenant()
    {
        MyTenant e = MyGlobals.getData().getTenant();
        return !hasTenant(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getUser().getFullName();
    }
}
