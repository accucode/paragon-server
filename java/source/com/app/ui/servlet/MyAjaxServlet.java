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
import com.app.ui.page.MyBookmark;
import com.app.ui.page.MyPage;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.login.MyLoginPage;
import com.app.utility.MyAppNavigator;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;

public class MyAjaxServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        toastFatal("GET is not allowed for HTTP AJAX requests. Use POST.");
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
            checkApplicationVersion();
            if ( data.hasResult() )
                return;

            checkServerSession();
            if ( data.hasResult() )
                return;

            String keyParam = data.getActionParameter();
            if ( Kmu.isEmpty(keyParam) )
            {
                toastFatal("No Action Parameter.");
                return;
            }

            checkSpecialAction(keyParam);
            if ( data.hasResult() )
                return;

            Integer key = Kmu.parseInteger(keyParam);
            if ( key == null )
            {
                toastFatal("Invalid Action Key.");
                return;
            }

            ScAction action = MyGlobals.getActionRegistry().findKey(key);
            if ( action == null )
            {
                toastFatal("Unknown Action Key.");
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

    private void runAction(ScAction e)
    {
        KmTimer t = KmTimer.run();
        try
        {
            initializeAjax();
            e.run();
        }
        finally
        {
            String name = Kmu.format("action... %s", e.getName());
            MyPerformanceLogBuffer.push(name, t);
        }
    }

    /**
     * Ensure the result is initialized for ajax.
     * In most cases, we perform some explicit action that updates
     * the ajax response. But in some rare cases, we may not do anything
     * with the response directly. This ensures that an ajaxResult is
     * configured even if we don't directly access ajax() as part of
     * handle() methods.
     */
    private void initializeAjax()
    {
        getData().ajax();
    }

    //##################################################
    //# check version/session
    //##################################################

    private void checkApplicationVersion()
    {
        String expected = MyConstantsIF.APPLICATION_VERSION;
        String actual = getData().getApplicationVersion();

        boolean ok = Kmu.isEqual(expected, actual);
        if ( !ok )
            ajax().showTimeoutMessage();
    }

    private void checkServerSession()
    {
        boolean ok = touchServerSession();
        if ( !ok )
            ajax().showTimeoutMessage();
    }

    //##################################################
    //# special action
    //##################################################

    private void checkSpecialAction(String keyParam)
    {
        if ( keyParam.equals(ScConstantsIF.ACTION_PRINT_WINDOW_LOCATION) )
            printWindowLocation();
    }

    private void printWindowLocation()
    {
        KmTimer t = KmTimer.run();
        MyPage page = getEntryPage();
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

    private void printWindowLocation(MyPage page)
    {
        if ( requiresLoginFor(page) )
        {
            MyLoginPage.getInstance().ajaxEnterForWindowQuery();
            return;
        }

        if ( !page.checkSecuritySilently() )
        {
            getDefaultEntryPage().ajaxPrint();
            return;
        }

        MyBookmark b;
        b = page.newBookmark();
        b.readFromWindowLocation();

        page.setBookmark(b);
        page.ajaxPrint();

        ajax().setBrowserTabTitle(page.getBrowserTabTitle());
    }

    private MyPage getEntryPage()
    {
        ScParameterList params = getData().getWindowParameters();
        String key = params.getString(ScConstantsIF.PARAMETER_REQUESTED_PAGE_KEY);

        MyPageRegistry registry = MyPageRegistry.getInstance();

        MyPage page = registry.findKey(key);
        if ( page != null )
            return page;

        KmLog.debug("Entry page; unknown key: %s.", key);
        return getDefaultEntryPage();
    }

    public MyPage getDefaultEntryPage()
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
