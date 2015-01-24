package com.app.ui.page.login;

import com.kodemore.log.KmLog;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.utility.Kmu;

import com.app.model.MyAutoSignIn;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

public class MySignInUtility
{
    //##################################################
    //# constants
    //##################################################

    private static final String COOKIE_EMAIL        = "email";
    private static final String COOKIE_AUTO_SIGN_IN = "autoSignIn";

    //##################################################
    //# sign in
    //##################################################

    public static void signIn(MyAutoSignIn auto)
    {
        MyServerSession ss;
        ss = signIn(auto.getUser());
        ss.setAutoSignIn(auto);

        auto.touch();
        ajaxSetAutoSignInCookie(auto);
    }

    public static MyServerSession signIn(MyUser user)
    {
        return MyServerSessionManager.signIn(user);
    }

    public static void signOut()
    {
        clearAutoSignIn();
        clearPageSession();
        beginServerSession();
    }

    //##################################################
    //# auto sign in
    //##################################################

    public static void clearAutoSignIn()
    {
        MyServerSession ss = getServerSession();
        if ( ss.hasAutoSignIn() )
        {
            ss.getAutoSignIn().deleteDao();
            ss.clearAutoSignIn();
        }

        ajaxSetAutoSignInCookie(null);
    }

    public static void ajaxSetAutoSignInCookie(MyAutoSignIn e)
    {
        String key = COOKIE_AUTO_SIGN_IN;

        if ( e == null )
            ajax().clearCookie(key);
        else
            ajax().setCookie(key, e.getUid());
    }

    public static void checkAutoSignIn()
    {
        if ( _checkCookieAutoSignIn() )
            return;

        _checkDebugAutoSignIn();
    }

    private static boolean _checkCookieAutoSignIn()
    {
        MyAutoSignIn auto = getValidAutoSignIn();
        if ( auto == null )
            return false;

        MyUser user = auto.getUser();
        if ( !user.allowsLogin() )
            return false;

        signIn(auto);
        return true;
    }

    private static boolean _checkDebugAutoSignIn()
    {
        String email = MyGlobals.getProperties().getAutoLoginEmail();
        if ( Kmu.isEmpty(email) )
            return false;

        MyUser user = MyGlobals.getAccess().getUserDao().findEmail(email);
        if ( user == null )
        {
            KmLog.warnTrace("Invalid autoLoginEmail: %s", email);
            return false;
        }

        MyAutoSignIn auto;
        auto = new MyAutoSignIn();
        auto.setUser(user);
        auto.attachDao();

        signIn(auto);
        return true;
    }

    //##################################################
    //# support
    //##################################################

    /**
     * Return the autoSignIn record that corresponds to the browser cookie.
     * Return NULL is the autoSignIn is not valid.
     */

    public static MyAutoSignIn getValidAutoSignIn()
    {
        MyAutoSignIn e = getAutoSignIn();

        if ( e == null )
            return null;

        if ( e.isStale() )
            return null;

        return e;
    }

    /**
     * Return the autoSignIn record that corresponds to the browser cookie.
     * This may return an expired record, or null.
     */
    public static MyAutoSignIn getAutoSignIn()
    {
        String uid = getData().getCookie(COOKIE_AUTO_SIGN_IN);
        return MyGlobals.getAccess().findAutoSignInUid(uid);
    }

    //##################################################
    //# email cookie
    //##################################################

    public static String getEmailCookie()
    {
        return getData().getCookie(COOKIE_EMAIL);
    }

    public static void setEmailCookie(String email)
    {
        ajax().setCookie(COOKIE_EMAIL, email);
    }

    //##################################################
    //# support
    //##################################################

    private static MyServletData getData()
    {
        return MyGlobals.getData();
    }

    private static ScBlockScript ajax()
    {
        return getData().ajax();
    }

    private static void clearPageSession()
    {
        getData().clearPageSession();
    }

    private static MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }

    private static void beginServerSession()
    {
        MyServerSessionManager.beginSession();
    }

}
