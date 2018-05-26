package com.app.bridge;

import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimeZoneBridge;

import com.app.dao.core.MyDaoSessionManager;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

public class MyTimeZoneBridge
    extends KmTimeZoneBridge
{
    //##################################################
    //# constants
    //##################################################

    private static final KmTimeZone DEFAULT_ZONE = KmTimeZone.Mountain;

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmTimeZone getLocalZone()
    {
        MyServletData data = MyGlobals.getData();
        if ( data == null )
            return DEFAULT_ZONE;

        if ( !hasDaoSession() )
            return DEFAULT_ZONE;

        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
            return DEFAULT_ZONE;

        MyUser u = ss.getUser();
        if ( u == null )
            return DEFAULT_ZONE;

        KmTimeZone zone = u.getTimeZone();
        if ( zone == null )
            return DEFAULT_ZONE;

        return zone;
    }

    //##################################################
    //# support
    //##################################################

    private boolean hasDaoSession()
    {
        boolean isInstalled = MyDaoSessionManager.isInstalled();
        boolean hasSession = MyDaoSessionManager.getInstance().isActive();

        return isInstalled && hasSession;
    }
}
