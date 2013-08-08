package com.app.ui.servlet;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.ui.activity.login.MyHandleInvitationActivity;
import com.app.ui.activity.login.MyHandlePasswordResetActivity;
import com.app.ui.activity.login.MyHandleTransferInvitationActivity;
import com.app.ui.activity.login.MySignInActivity;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyLeftMenu;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

import com.kodemore.collection.KmMap;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmRoleViolationException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.utility.Kmu;

public class MyAjaxServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        printErrorMessage("GET is not allowed for HTTP AJAX requests.  Use POST.");
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
                printErrorMessage("Invalid Action Key.");
                return;
            }

            runAction(action);
        }
        catch ( KmRoleViolationException ex )
        {
            printErrorMessage("Security Violation.");
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
            printErrorMessage("Unhandled exception: " + ex.getMessage());
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
        if ( !usesDaoSession() )
            return;

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
        if ( usesDaoSession() )
            runNavigateDao();
        else
            handleNavigate();
    }

    private void runNavigateDao()
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
        MyLeftMenu.getInstance().gotoWindowLocation();
    }

    //##################################################
    //# enter application
    //##################################################

    private void runEnter()
    {
        if ( usesDaoSession() )
            runEnterDao();
        else
            handleEnter();
    }

    private void runEnterDao()
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

        MySignInActivity.instance.start();
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

        MyInvitation a;
        a = getAccess().getInvitationDao().findAccessKey(value);

        MyInvitationType type;
        type = a.getType();

        // fixme_valerie: finish
        if ( type.equals(MyInvitationType.Transfer) )
            MyHandleTransferInvitationActivity.instance.start(value);

        //        if ( type.equals(MyInvitationType.Join) )
        //            MyHandleJoinInvitationActivity.instance.start(value);

        else
            MyHandleInvitationActivity.instance.start(value);

        return true;
    }

    private boolean handlePasswordReset(KmMap<String,String> params)
    {
        String key = MyUrls.PARAMETER_PASSWORD_RESET;
        if ( !params.containsKey(key) )
            return false;

        String value = params.get(key);

        MyHandlePasswordResetActivity.instance.start(value);
        return true;
    }

    //##################################################
    //# run action
    //##################################################

    private void runAction(ScActionIF e)
    {
        try
        {
            if ( usesDaoSession() )
                runActionDao(e);
            else
                handleAction(e);
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
            if ( usesDaoSession() )
                printErrorDao(ex);
            else
                printErrorNonDao(ex);
        }
        catch ( KmApplicationException ex2 )
        {
            printErrorMessage(ex2.getMessage());
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

    protected boolean usesDaoSession()
    {
        return true;
    }

    private void printErrorMessage(String s)
    {
        ajax().toast(s).error().sticky();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
