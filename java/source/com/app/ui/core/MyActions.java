package com.app.ui.core;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScContextIF;
import com.kodemore.servlet.action.ScGlobalContext;
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

    // todo_wyatt: senders?
    private ScAction _settingsAction;

    // todo_wyatt: senders?
    private ScAction _signOutAction;

    //##################################################
    //# constructor
    //##################################################

    private MyActions()
    {
        _settingsAction = createAction(this::handleSettings);
        _signOutAction = createAction(this::handleSignOut);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScAction getSettingsAction()
    {
        return _settingsAction;
    }

    public ScAction getSignOutAction()
    {
        return _signOutAction;
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

    private ScAction createAction(Runnable r)
    {
        return new ScAction(ScGlobalContext.getInstance(), r);
    }

}
