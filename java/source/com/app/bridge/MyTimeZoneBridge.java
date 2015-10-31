package com.app.bridge;

import java.time.ZoneId;

import com.kodemore.time.KmTimeZoneBridge;

import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

public class MyTimeZoneBridge
    extends KmTimeZoneBridge
{
    @Override
    public ZoneId getLocalTimeZone()
    {
        MyServletData data = MyGlobals.getData();
        if ( data == null )
            return null;

        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
            return null;

        MyUser u = ss.getUser();
        if ( u == null )
            return null;

        return u.getTimeZone();
    }
}
