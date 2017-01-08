package com.app.ui.core;

import com.app.finder.MyServerSessionFinder;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;

public class MyServerSessionManager
{
    //##################################################
    //# constants
    //##################################################

    private static final String COOKIE_KEY = "ssid";

    //##################################################
    //# access
    //##################################################

    /**
     * Start a new session.
     * If a session already exists, close it first.
     */
    public static void beginSession(MyTenant tenant)
    {
        endSession();

        MyServerSession ss;
        ss = new MyServerSession();
        ss.setVersion(MyConstantsIF.APPLICATION_VERSION);
        ss.setTenant(tenant);
        ss.daoAttach();

        setCookieUid(ss.getUid());
    }

    /**
     * Close the current session, if any.
     */
    public static void endSession()
    {
        MyServerSession ss = getSession();
        if ( ss != null )
            ss.close();

        getData().clearCookie(COOKIE_KEY);
    }

    /**
     * Attempt to touch the current session, to keep it from going stale.
     * Return true if the session was successfully touched.
     * The session must already exist.
     * The session must not yet be stale.
     */
    public static boolean touchSession()
    {
        MyServerSession ss = getValidSession();

        if ( ss == null )
            return false;

        ss.touch();
        ss.validate();

        setCookieUid(ss.getUid());
        return true;
    }

    /**
     * Checks to see if there is a valid session.
     * The session is NOT created, if missing.
     * The session is NOT touched.
     */
    public static boolean hasValidSession()
    {
        return getValidSession() != null;
    }

    /**
     * Get the current session if any.
     * May return null.
     * Does not touch the session.
     * Does not validate the session.
     */
    public static MyServerSession getSession()
    {
        String uid = getCookieUid();

        if ( uid == null )
            return null;

        return MyServerSessionFinder.staticFind(uid);
    }

    private static MyServerSession getValidSession()
    {
        MyServerSession ss = getSession();

        if ( ss == null )
            return null;

        boolean isStale = ss.isStale();
        if ( isStale )
        {
            if ( ss.isActive() )
                ss.close();

            return null;
        }

        return ss;
    }

    //##################################################
    //# login
    //##################################################

    public static MyServerSession logIn(MyUser u)
    {
        MyServerSession ss;
        ss = getSession();
        ss.setUser(u);
        ss.setTenant(u.getTenant());
        ss.validate();
        return ss;
    }

    //##################################################
    //# cookie
    //##################################################

    private static String getCookieUid()
    {
        MyServletData data = getData();
        if ( data == null )
            return null;

        String uid = data.getCachedServerSessionUid();
        if ( uid == null )
        {
            uid = data.getCookie(COOKIE_KEY);
            data.setCachedServerSessionUid(uid);
        }

        return uid;
    }

    private static void setCookieUid(String uid)
    {
        MyProperties p = getProperties();

        int timeout = p.getServerSessionTimeoutSeconds();
        boolean secure = p.getServerSessionSecure();

        MyServletData data;
        data = getData();
        data.setCookie(COOKIE_KEY, uid, timeout, secure);
        data.setCachedServerSessionUid(uid);
    }

    //##################################################
    //# support
    //##################################################

    private static MyServletData getData()
    {
        return MyGlobals.getData();
    }

    private static MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

}
