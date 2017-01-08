package com.app.utility;

import com.kodemore.dao.KmDaoSessionManager;
import com.kodemore.servlet.MyGlobalSession;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoAccess;
import com.app.dao.core.MyDaoSession;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.property.MyPropertyManager;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;

public class MyGlobals
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyGlobals instance = new MyGlobals();

    private MyGlobals()
    {
        // singleton
    }

    //##################################################
    //# dao session
    //##################################################

    public static MyDaoAccess getAccess()
    {
        return MyDaoAccess.getInstance();
    }

    public static MyDaoSession getDaoSession()
    {
        return (MyDaoSession)getDaoSessionManager().getDaoSession();
    }

    public static KmDaoSessionManager getDaoSessionManager()
    {
        return KmDaoSessionManager.getInstance();
    }

    //##################################################
    //# server session
    //##################################################

    public static MyServerSession getServerSession()
    {
        return MyServerSessionManager.getSession();
    }

    public static MyTenant getCurrentTenant()
    {
        MyServerSession ss = getServerSession();
        return ss == null
            ? null
            : ss.getTenant();
    }

    public static MyProject getCurrentProject()
    {
        return MyGlobalSession.instance.getCurrentProject();
    }

    public static MyUser getCurrentUser()
    {
        MyServerSession ss = getServerSession();
        return ss == null
            ? null
            : ss.getUser();
    }

    //##################################################
    //# page session
    //##################################################

    public static MyGlobalSession getGlobalSession()
    {
        return MyGlobalSession.instance;
    }

    //##################################################
    //# misc
    //##################################################

    public static MyServletData getData()
    {
        return MyServletData.getLocal();
    }

    public static MyProperties getProperties()
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

    public static KmTimestamp getNowUtc()
    {
        return KmClock.getUtcTimestamp();
    }

}
