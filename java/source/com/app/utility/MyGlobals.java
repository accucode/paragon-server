package com.app.utility;

import com.kodemore.dao.KmDaoSessionManager;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmClock;

import com.app.dao.base.MyDaoRegistry;
import com.app.dao.core.MyDaoSession;
import com.app.model.MyServerSession;
import com.app.property.MyPropertyManager;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyCookieSession;
import com.app.ui.core.MyPageSession;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;

public class MyGlobals
{
    //##################################################
    //# misc
    //##################################################

    public static MyServletData getData()
    {
        return MyServletData.getLocal();
    }

    public static MyPageSession getPageSession()
    {
        return MyPageSession.getInstance();
    }

    public static MyServerSession getServerSession()
    {
        return MyServerSessionManager.getSession();
    }

    public static MyCookieSession getCookieSession()
    {
        return MyCookieSession.getInstance();
    }

    public static MyPropertyRegistry getProperties()
    {
        return MyPropertyManager.getProperties();
    }

    public static ScControlRegistry getControlRegistry()
    {
        return ScControlRegistry.getInstance();
    }

    public static ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    public static MyDaoSession getDaoSession()
    {
        return (MyDaoSession)getDaoSessionManager().getDaoSession();
    }

    public static KmDaoSessionManager getDaoSessionManager()
    {
        return KmDaoSessionManager.getInstance();
    }

    public static MyDaoRegistry getAccess()
    {
        return MyDaoRegistry.getInstance();
    }

    public static KmTimestamp getNowUtc()
    {
        return KmClock.getNowUtc();
    }
}
