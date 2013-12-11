package com.app.ui.servlet;

import com.kodemore.collection.KmMap;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyServerSession;
import com.app.ui.activity.login.MyAcceptJoinInvitationPage;
import com.app.ui.activity.login.MyHandleNewUserInvitationActivity;
import com.app.ui.activity.login.MyPasswordResetPage;
import com.app.ui.activity.login.MyHandleTransferInvitationActivity;
import com.app.ui.activity.login.MyInvalidInvitationPage;
import com.app.ui.activity.login.MySignInPage;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyAjaxServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        toastFatal("GET is not allowed for HTTP AJAX requests.  Use POST.");
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# process
    //##################################################

    private void handle()
    {
        MyServletData data = getData();

        try
        {
            checkServerSession(data);
            if ( data.hasResult() )
                return;

            checkSpecialAction(data);
            if ( data.hasResult() )
                return;

            ScActionIF action = getAction(data);
            if ( action == null )
            {
                toastFatal("Invalid Action Key.");
                return;
            }

            runAction(action);
        }
        catch ( KmSecurityException ex )
        {
            toastFatal(ex.formatDisplayMessage());
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
            toastFatal("Unhandled exception: " + ex.getMessage());
        }
    }

    private ScActionIF getAction(MyServletData data)
    {
        String key = data.getActionKey();

        return MyGlobals.getControlRegistry().getAction(key);
    }

    //##################################################
    //# server session
    //##################################################

    private void checkServerSession(MyServletData data)
    {
        if ( touchServerSession() )
            return;

        String url = MyUrls.getEntryUrl();

        ajax().alert("Session Timeout.");
        ajax().gotoUrl(url);
    }

    //##################################################
    //# special action
    //##################################################

    private void checkSpecialAction(MyServletData data)
    {
        String key = data.getActionKey();

        if ( Kmu.isEmpty(key) || key.equals("_enter") )
            runEnter();

        if ( key.equals("_navigate") )
            runNavigate();
    }

    //##################################################
    //# navigation (via url hash)
    //##################################################

    private void runNavigate()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleNavigate();
            }
        }.run();
    }

    private void handleNavigate()
    {
        if ( hasCurrentUser() )
            MyPageLayout.getInstance().getLeftMenu().gotoWindowLocation();
        else
            MySignInPage.instance.start();
    }

    private boolean hasCurrentUser()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
            return false;

        return ss.isFresh() && ss.hasUser();
    }

    //##################################################
    //# enter application
    //##################################################

    private void runEnter()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleEnter();
            }
        }.run();
    }

    private void handleEnter()
    {
        MyPageLayout e;
        e = getPageStructure();
        e.ajaxCreateLayout();
        e.ajaxRefreshHeader();
        e.ajaxRefreshFooter();

        if ( handleEntryParameters() )
            return;

        MySignInPage.instance.start();
    }

    private boolean handleEntryParameters()
    {
        KmMap<String,String> params = getEntryParameters();
        if ( params == null )
            return false;

        if ( handleInvitation(params) )
            return true;

        if ( handlePasswordReset(params) )
            return true;

        return false;
    }

    @SuppressWarnings("unchecked")
    private KmMap<String,String> getEntryParameters()
    {
        MyServletData data = getData();

        if ( !data.hasArgument() )
            return null;

        return (KmMap<String,String>)data.getArgument();
    }

    private boolean handleInvitation(KmMap<String,String> params)
    {
        String key = MyUrls.PARAMETER_INVITATION;
        if ( !params.containsKey(key) )
            return false;

        String value = params.get(key);

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(value);

        if ( inv == null )
        {
            MyInvalidInvitationPage.instance.start();
            return true;
        }

        MyInvitationType type = inv.getType();
        switch ( type )
        {
            case Join:
                MyAcceptJoinInvitationPage.instance.start(value);
                break;

            case Transfer:
                MyHandleTransferInvitationActivity.instance.start(value);
                break;

            case User:
                MyHandleNewUserInvitationActivity.instance.start(value);
                break;
        }

        return true;
    }

    private boolean handlePasswordReset(KmMap<String,String> params)
    {
        String key = MyUrls.PARAMETER_PASSWORD_RESET;
        if ( !params.containsKey(key) )
            return false;

        String value = params.get(key);

        MyPasswordResetPage.instance.start(value);
        return true;
    }

    //##################################################
    //# run action
    //##################################################

    private void runAction(ScActionIF e)
    {
        try
        {
            runActionDao(e);
        }
        catch ( KmApplicationException ex )
        {
            printError(ex);
        }
    }

    private void runActionDao(final ScActionIF e)
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleAction(e);
            }
        }.run();
    }

    private void handleAction(ScActionIF e)
    {
        e.run();
    }

    //##################################################
    //# print error
    //##################################################

    private void printError(KmApplicationException ex)
    {
        try
        {
            printErrorDao(ex);
        }
        catch ( KmApplicationException ex2 )
        {
            toastFatal(ex2.getMessage());
        }
    }

    private void printErrorDao(final KmApplicationException ex)
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                printErrorNonDao(ex);
            }

        }.run();
    }

    private void printErrorNonDao(final KmApplicationException ex)
    {
        MyServletData data;
        data = getData();
        data.reset();

        ajax().toast(ex.getMessage()).sticky().error();
    }

    //##################################################
    //# support
    //##################################################

    private MyPageLayout getPageStructure()
    {
        return MyPageLayout.getInstance();
    }

    private void toastFatal(String s)
    {
        ajax().toast(s).error().sticky();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
