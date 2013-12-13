package com.app.ui.servlet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.action.ScActionIF;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationType;
import com.app.model.MyUser;
import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.login.MyAcceptJoinInvitationPage;
import com.app.ui.page.login.MyAcceptNewUserInvitationPage;
import com.app.ui.page.login.MyAcceptTransferInvitationPage;
import com.app.ui.page.login.MyInvalidInvitationPage;
import com.app.ui.page.login.MyPasswordResetPage;
import com.app.ui.page.login.MySignInPage;
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

        if ( key.equals("_printCurrentPage") )
            handlePrintCurrentPage();
    }

    private void handlePrintCurrentPage()
    {
        KmMap<String,KmList<String>> params = getData().getWindowParameters();

        KmList<String> pageKeys = params.get("page");
        if ( pageKeys == null )
        {
            ajax().toast("No page parameter.");
            return;
        }

        if ( pageKeys.isEmpty() )
        {
            ajax().toast("Empty page keys");
            return;
        }

        if ( pageKeys.isMultiple() )
        {
            ajax().toast("Multiple page keys");
            return;
        }

        MyPageRegistry registry = MyPageRegistry.getInstance();
        String key = pageKeys.getFirst();
        boolean hasKey = registry.hasKey(key);
        if ( !hasKey )
        {
            ajax().toast("Unknown page, " + key);
            return;
        }

        ScPage page = registry.findKey(key);
        printPageDao(page);
    }

    private void printPageDao(final ScPage page)
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                printPage(page);
            }
        }.run();
    }

    private void printPage(ScPage page)
    {
        if ( requiresLoginFor(page) )
        {
            String q = getData().getWindowQuery();
            MySignInPage.instance.startForTarget(q);
            return;
        }

        KmMap<String,KmList<String>> params = getData().getWindowParameters();

        page.decodeParameters(params);
        page.print();
    }

    private boolean requiresLoginFor(ScPage page)
    {
        boolean requiresUser = page.requiresUser();
        MyUser user = MyGlobals.getServerSession().getUser();

        return requiresUser && user == null;
    }

    //##################################################
    //# enter application
    //##################################################

    // todo_wyatt: accept invitation
    @SuppressWarnings("unused")
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
                MyAcceptTransferInvitationPage.instance.start(value);
                break;

            case User:
                MyAcceptNewUserInvitationPage.instance.start(value);
                break;
        }

        return true;
    }

    // todo_wyatt: password reset
    @SuppressWarnings("unused")
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

    private void toastFatal(String s)
    {
        ajax().toast(s).error().sticky();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
