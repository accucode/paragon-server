package com.app.ui.servlet;

import com.kodemore.command.KmDao;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyPerformanceLogBuffer;
import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.login.MyLoginPage;
import com.app.utility.MyAppNavigator;
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
        KmTimer timer = KmTimer.run("ajax servlet");
        MyServletData data = getData();
        try
        {
            checkServerSession();
            if ( data.hasResult() )
                return;

            checkSpecialAction(data);
            if ( data.hasResult() )
                return;

            ScAction action = getAction(data);
            if ( action == null )
            {
                toastFatal("Invalid Action Key.");
                return;
            }

            runAction(action);
        }
        catch ( KmApplicationException ex )
        {
            printError(ex);
        }
        catch ( KmSecurityException ex )
        {
            toastFatal(ex.formatDisplayMessage());
        }
        catch ( Throwable ex )
        {
            KmLog.fatal(ex);
            ajax().openErrorDialog(ex);
        }
        finally
        {
            if ( getProperties().getPrintAjaxTime() )
                KmLog.println(timer);
        }
    }

    private ScAction getAction(MyServletData data)
    {
        String key = data.getActionKey();

        return MyGlobals.getControlRegistry().getAction(key);
    }

    private void runAction(ScAction e)
    {
        KmTimer t = KmTimer.run();
        try
        {
            e.run();
        }
        finally
        {
            String name = Kmu.format("action... %s", e.getName());
            MyPerformanceLogBuffer.push(name, t);
        }
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
            printWindowLocation();
    }

    private void printWindowLocation()
    {
        KmTimer t = KmTimer.run();
        ScPage page = getEntryPage();
        try
        {
            KmDao.run(this::printWindowLocation, page);
        }
        finally
        {
            String name = Kmu.format("print... %s", page.getClass().getSimpleName());
            MyPerformanceLogBuffer.push(name, t);
        }
    }

    private void printWindowLocation(ScPage page)
    {
        if ( requiresLoginFor(page) )
        {
            MyLoginPage.getInstance().ajaxEnterForWindowQuery();
            return;
        }

        if ( !page.checkSecuritySilently() )
        {
            KmLog.debug("Entry page; security check: %s.", page.getClass().getSimpleName());
            getDefaultEntryPage().ajaxEnter();
            return;
        }

        ScParameterList params = getData().getWindowParameters();

        page.applyBookmark(params);
        page.ajaxPrint();
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
        return MyAppNavigator.getEntryPage();
    }

    private boolean requiresLoginFor(ScPage page)
    {
        boolean requiresUser = page.requiresUser();
        boolean hasUser = MyGlobals.getServerSession().hasUser();

        return requiresUser && !hasUser;
    }

    //##################################################
    //# support
    //##################################################

    private void printError(KmApplicationException ex)
    {
        try
        {
            MyServletData data;
            data = getData();
            data.reset();

            ajax().toast(ex.getMessage()).sticky().error();
        }
        catch ( KmApplicationException ex2 )
        {
            KmLog.error(ex2, "Unable to report error");
        }
    }

    private void toastFatal(String s)
    {
        ajax().toast(s).error().sticky();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
