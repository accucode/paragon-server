package com.app.ui.servlet;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.exception.KmRoleViolationException;
import com.kodemore.log.KmLog;

import com.app.ui.core.MyServerSessionManager;
import com.app.utility.MyUrls;

/**
 * I am used by various tools to coordinate dynamic 
 * server side responses to client side requests.
 * 
 * Tools register a url path suffix, and a callback
 * function.  When a url is receiced matching the 
 * path suffix, the request is passed to the 
 * callback function.
 * 
 * This is an experiment and is intended as an 
 * alternative to creating separate servlets and
 * web.xml entries for each new tool.
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
            new KmDaoCommand()
            {
                @Override
                protected void handle()
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
            }.run();
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

    //##################################################
    //# server session
    //##################################################

    private void checkServerSession()
    {
        boolean isValid = MyServerSessionManager.hasValidSession();
        if ( isValid )
            return;

        ajax().alert("Session Timeout.");
        ajax().gotoUrl(MyUrls.getEntryUrl());
    }

    //##################################################
    //# support
    //##################################################

    private void printErrorMessage(String s)
    {
        ajax().toast(s).error().sticky();
    }

}
