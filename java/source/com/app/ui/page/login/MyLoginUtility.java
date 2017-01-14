package com.app.ui.page.login;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.MyGlobalSession;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyAutoLogin;
import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.general.MyLogoutPage;
import com.app.utility.MyGlobals;

public class MyLoginUtility
{
    //##################################################
    //# constants
    //##################################################

    public static final String COOKIE_EMAIL      = "email";
    public static final String COOKIE_AUTO_LOGIN = "autoLogin";

    //##################################################
    //# sign in
    //##################################################

    public static void logIn(MyAutoLogin auto)
    {
        MyUser user = auto.getUser();

        MyServerSession ss;
        ss = ajaxLogIn(user);
        ss.setAutoLogin(auto);

        auto.touch();

        ajaxSetAutoLoginCookie(auto);
    }

    public static MyServerSession ajaxLogIn(MyUser user)
    {
        MyGlobalSession gs;
        gs = MyGlobalSession.instance;
        gs.installCurrentProjectFor(user);

        ajaxResetEnvironmentCssFor(user);
        return MyServerSessionManager.logIn(user);
    }

    public static void ajaxLogOut()
    {
        MyTenant tenant = getData().getTenant();

        ajaxClearAutoLogin();
        clearPageSession();

        MyServerSessionManager.beginSession(tenant);
        ajaxResetEnvironmentCssFor(null);

        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.ajaxRefreshHeader();
        layout.ajaxClearContent();

        MyLogoutPage.getInstance().ajaxEnter();
    }

    //##################################################
    //# environment css
    //##################################################

    private static void ajaxResetEnvironmentCssFor(MyUser user)
    {
        ScBlockScript ajax;
        ajax = ajax();
        ajax.removeCss("body", KmCssDefaultConstantsIF.environmentStage);
        ajax.removeCss("body", KmCssDefaultConstantsIF.environmentProduction);

        if ( user != null )
            ajax().addCss("body", getEnvironmentCssFor(user));
    }

    public static String getEnvironmentCssFor(MyUser user)
    {
        MyProperties p = MyGlobals.getProperties();

        if ( p.isEnvironmentStage() )
            return KmCssDefaultConstantsIF.environmentStage;

        if ( p.isEnvironmentProduction() )
        {
            boolean isDeveloper = user != null && user.isRoleDeveloper();
            if ( isDeveloper )
                return KmCssDefaultConstantsIF.environmentProduction;
        }

        return "";
    }

    //##################################################
    //# auto login
    //##################################################

    public static void ajaxClearAutoLogin()
    {
        MyServerSession ss = getServerSession();
        if ( ss.hasAutoLogin() )
        {
            ss.getAutoLogin().daoDelete();
            ss.clearAutoLogin();
        }

        ajaxSetAutoLoginCookie(null);
    }

    public static void ajaxSetAutoLoginCookie(MyAutoLogin e)
    {
        String key = COOKIE_AUTO_LOGIN;

        if ( e == null )
            ajax().clearCookie(key);
        else
            ajax().setCookie(key, e.getUid());
    }

    public static void checkAutoLogin(MyTenant tenant)
    {
        if ( _checkCookieAutoLogin() )
            return;

        _checkDebugAutoLogin(tenant);
    }

    private static boolean _checkCookieAutoLogin()
    {
        MyAutoLogin auto = getValidAutoLogin();
        if ( auto == null )
            return false;

        MyUser user = auto.getUser();
        if ( !user.allowsLogin() )
            return false;

        logIn(auto);
        return true;
    }

    private static boolean _checkDebugAutoLogin(MyTenant tenant)
    {
        String email = MyGlobals.getProperties().getAutoLoginEmail();

        if ( Kmu.isEmpty(email) )
            return false;

        MyUser user = getAccess().getUserDao().findEmail(tenant, email);
        if ( user == null )
        {
            KmLog.warnTrace(
                "Invalid autoLoginEmail for tenant(%s) email(%s).",
                tenant.getHostname(),
                email);
            return false;
        }

        MyAutoLogin auto;
        auto = new MyAutoLogin();
        auto.setUser(user);
        auto.daoAttach();

        logIn(auto);
        return true;
    }

    private static MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# support
    //##################################################

    /**
     * Return the autoLogin record that corresponds to the browser cookie.
     * Return NULL is the autoLogin is not valid.
     */
    public static MyAutoLogin getValidAutoLogin()
    {
        MyAutoLogin e = getAutoLogin();

        if ( e == null )
            return null;

        if ( e.isStale() )
            return null;

        return e;
    }

    /**
     * Return the autoLogin record that corresponds to the browser cookie.
     * This may return an expired record, or null.
     */
    public static MyAutoLogin getAutoLogin()
    {
        String uid = getData().getCookie(COOKIE_AUTO_LOGIN);
        return getAccess().findAutoLoginUid(uid);
    }

    //##################################################
    //# email cookie
    //##################################################

    public static String getEmailCookie()
    {
        return getData().getCookie(COOKIE_EMAIL);
    }

    public static void ajaxSetEmailCookie(String email)
    {
        ajax().setCookie(COOKIE_EMAIL, email);
    }

    public static void ajaxClearEmailCookie()
    {
        ajax().clearCookie(COOKIE_EMAIL);
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
        getData().getPageSession().clearAll();
    }

    private static MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }
}
