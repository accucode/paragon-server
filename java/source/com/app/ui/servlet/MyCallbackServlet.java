package com.app.ui.servlet;

import com.kodemore.command.KmDao;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;

import com.app.ui.core.MyServerSessionManager;

/**
 * I am used by various tools to coordinate dynamic
 * server side responses to client side requests.
 *
 * Tools register a url path suffix, and a callback function.
 * When a url is received matching the path suffix,
 * the request is passed to the callback function.
 *
 * This is intended as an alternative to creating separate
 * servlets and web.xml entries for each new tool.
 */
public class MyCallbackServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
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
        try
        {
            KmDao.run(this::handleDao);
        }
        catch ( KmSecurityException ex )
        {
            printErrorMessage(ex.formatDisplayMessage());
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
            printErrorMessage("Unhandled exception: " + ex.getMessage());
        }
    }

    private void handleDao()
    {
        String uri;
        uri = getData().getRequestUri();

        checkServerSession();
        if ( getData().hasResult() )
            return;

        ScServletCallbackRegistry reg;
        reg = ScServletCallbackRegistry.getInstance();
        reg.runPath(uri);
    }

    //##################################################
    //# server session
    //##################################################

    private void checkServerSession()
    {
        boolean isValid = MyServerSessionManager.hasValidSession();
        if ( !isValid )
            ajax().showTimeoutMessage();
    }

    //##################################################
    //# support
    //##################################################

    private void printErrorMessage(String s)
    {
        ajax().toast(s).error().sticky();
    }

}
