package com.app.utility;

import com.kodemore.servlet.utility.ScActionRegistry;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;

import com.app.bridge.MyTimeZoneBridge;
import com.app.dao.base.MyDaoAccess;
import com.app.dao.core.MyDaoSession;
import com.app.dao.core.MyDaoSessionManager;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.property.MyPropertyManager;
import com.app.ui.MyGlobalSession;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;

public class MyGlobals
{
    //##################################################
    //# singleton
    //##################################################

    public static MyGlobals instance = new MyGlobals();

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
        return getDaoSessionManager().getDaoSession();
    }

    public static MyDaoSessionManager getDaoSessionManager()
    {
        return MyDaoSessionManager.getInstance();
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
        return MyGlobalSession.getInstance().getCurrentProject();
    }

    public static MyUser getCurrentUser()
    {
        MyServerSession ss = getServerSession();
        return ss == null
            ? null
            : ss.getUser();
    }

    public static MyMember getCurrentMember()
    {
        MyProject p = getCurrentProject();
        MyUser u = getCurrentUser();

        return getAccess().getMemberDao().findMember(p, u);
    }

    public static KmTimeZone getCurrentTimeZone()
    {
        return MyTimeZoneBridge.getInstance().getLocalZone();
    }

    //##################################################
    //# page session
    //##################################################

    public static MyGlobalSession getGlobalSession()
    {
        return MyGlobalSession.getInstance();
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

    public static ScActionRegistry getActionRegistry()
    {
        return ScActionRegistry.getInstance();
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
