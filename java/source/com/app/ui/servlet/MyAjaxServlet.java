package com.app.ui.servlet;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScActionIF;

import com.app.dao.base.MyDaoRegistry;
import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.login.MySignInPage;
import com.app.utility.MyGlobals;
import com.app.utility.MyNavigator;
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
            checkServerSession();
            if ( data.hasResult() )
                return;

            checkSpecialAction(data);
            if ( data.hasResult() )
                return;

            ScActionIF action = getAction(data);
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

    private void checkServerSession()
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

        if ( key.equals(ScConstantsIF.PRINT_WINDOW_LOCATION) )
            printWindowLocationDao();
    }

    private void printWindowLocationDao()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                printWindowLocation();
            }
        }.run();
    }

    private void printWindowLocation()
    {
        ScPage page = getEntryPage();

        if ( requiresLoginFor(page) )
        {
            MySignInPage.instance.pushForWindowQuery();
            return;
        }

        if ( !page.checkSecuritySilently() )
        {
            KmLog.debug("Entry page; security check: %s.", page.getClass().getSimpleName());
            getDefaultEntryPage()._ajaxPush();
            return;
        }

        ScParameterList params = getData().getWindowParameters();

        page.applyQueryParameters(params);
        page.print();
    }

    private ScPage getEntryPage()
    {
        ScParameterList params = getData().getWindowParameters();
        String key = params.getValue(ScConstantsIF.PARAMETER_REQUESTED_PAGE_KEY);

        MyPageRegistry registry = MyPageRegistry.getInstance();

        ScPage page = registry.findKey(key);
        if ( page != null )
            return page;

        KmLog.debug("Entry page; unknown key: %s.", key);
        return getDefaultEntryPage();
    }

    public ScPage getDefaultEntryPage()
    {
        return MyNavigator.getEntryPage();
    }

    private boolean requiresLoginFor(ScPage page)
    {
        boolean requiresUser = page.requiresUser();
        boolean hasUser = MyGlobals.getServerSession().hasUser();

        return requiresUser && !hasUser;
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
