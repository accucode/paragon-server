package com.app.ui.core;

import com.app.model.MyAutoSignIn;
import com.app.utility.MyGlobals;

import com.kodemore.servlet.script.ScRootScript;

public final class MyServletUtility
{
    //##################################################
    //# constants
    //##################################################

    private static final String COOKIE_AUTO_SIGN_IN = "autoSignIn";

    //##################################################
    //# sign in
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

    //##################################################
    //# support
    //##################################################

    private static ScRootScript ajax()
    {
        return getData().ajax();
    }

    private static MyServletData getData()
    {
        return MyGlobals.getData();
    }

}
