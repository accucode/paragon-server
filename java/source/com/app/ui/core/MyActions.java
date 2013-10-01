package com.app.ui.core;

import com.app.ui.activity.general.MySignOutPage;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.script.ScRootScript;

public class MyActions
    implements ScActionContextIF
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

    private ScActionIF _settingsAction;
    private ScActionIF _signOutAction;

    //##################################################
    //# constructor 
    //##################################################

    private MyActions()
    {
        _settingsAction = newSettingsAction();
        _signOutAction = newSignOutAction();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScActionIF getSettingsAction()
    {
        return _settingsAction;
    }

    public ScActionIF getSignOutAction()
    {
        return _signOutAction;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSettingsAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSettings();
            }
        };
    }

    private ScActionIF newSignOutAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSignOut();
            }
        };
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
        MySignOutPage.instance.start();
    }

    //##################################################
    //# support
    //##################################################

    private MyServletData getData()
    {
        return MyServletData.getLocal();
    }

    private ScRootScript ajax()
    {
        return getData().ajax();
    }
}
