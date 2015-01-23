package com.app.ui.core;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.servlet.action.ScContextIF;
import com.kodemore.servlet.script.ScBlockScript;

import com.app.ui.page.general.MySignOutPage;

public class MyActions
    implements ScContextIF
{
    //##################################################
    //# instance
    //##################################################

    private static MyActions _instance;

    public static MyActions getInstance()
    {
        return _instance;
    }

    public static void install()
    {
        _instance = new MyActions();
    }

    //##################################################
    //# variables
    //##################################################

    private Runnable _settingsRunnable;
    private Runnable _signOutRunnable;

    //##################################################
    //# constructor
    //##################################################

    private MyActions()
    {
        _settingsRunnable = this::handleSettings;
        _signOutRunnable = this::handleSignOut;
    }

    //##################################################
    //# accessing
    //##################################################

    public Runnable getSettingsRunnable()
    {
        return _settingsRunnable;
    }

    public Runnable getSignOutRunnable()
    {
        return _signOutRunnable;
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public void checkSecurity()
    {
        // none
    }

    @Override
    public boolean checkSecuritySilently()
    {
        try
        {
            checkSecurity();
            return true;
        }
        catch ( KmSecurityException ex )
        {
            return false;
        }
    }

    @Override
    public void handleError(KmApplicationException ex)
    {
        ajax().alert(ex.formatMultiLineMessage());
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        ajax().alert(ex.getMessage());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSettings()
    {
        ajax().toast("Settings");
    }

    private void handleSignOut()
    {
        MySignOutPage.instance.ajaxPush();
    }

    //##################################################
    //# support
    //##################################################

    private MyServletData getData()
    {
        return MyServletData.getLocal();
    }

    private ScBlockScript ajax()
    {
        return getData().ajax();
    }

}
