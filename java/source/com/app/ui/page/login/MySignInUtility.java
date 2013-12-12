package com.app.ui.page.login;

import com.kodemore.servlet.script.ScRootScript;

import com.app.model.MyAutoSignIn;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.general.MyHomePage;
import com.app.utility.MyGlobals;

public class MySignInUtility
{
    //##################################################
    //# constants
    //##################################################

    private static final String COOKIE_EMAIL        = "email";
    private static final String COOKIE_AUTO_SIGN_IN = "autoSignIn";

    //##################################################
    //# public
    //##################################################

    public static void ajaxClearAutoSignIn()
    {
        ajaxSetAutoSignIn(null);
    }

    public static void ajaxSetAutoSignIn(MyAutoSignIn e)
    {
        String key = COOKIE_AUTO_SIGN_IN;

        if ( e == null )
            ajax().clearCookie(key);
        else
            ajax().setCookie(key, e.getUid());
    }

    public static MyAutoSignIn getAutoSignIn()
    {
        String uid = getData().getCookie(COOKIE_AUTO_SIGN_IN);
        MyAutoSignIn auto = MyGlobals.getAccess().findAutoSignInUid(uid);

        return auto;
    }

    public static void signIn(MyUser user, MyAutoSignIn auto)
    {
        MyServerSession ss;
        ss = MyServerSessionManager.login(user);
        ss.setAutoSignIn(auto);

        MySignInUtility.ajaxSetAutoSignIn(auto);

        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.ajaxClearCenter();
        layout.ajaxRefresh();

        // todo_wyatt: default page
        //  MyNavigator.startDefaultPage();
        MyHomePage.instance.start();
    }

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

    private static ScRootScript ajax()
    {
        return getData().ajax();
    }
}
