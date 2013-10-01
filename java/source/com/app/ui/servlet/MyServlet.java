package com.app.ui.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.command.KmDaoResultCommand;
import com.kodemore.servlet.ScAbstractServlet;

public abstract class MyServlet
    extends ScAbstractServlet<MyServletData>
    implements MyConstantsIF
{
    //##################################################
    //# overrides
    //##################################################

    @Override
    protected MyServletData newServletData(HttpServletRequest request, HttpServletResponse response)
    {
        return MyServletData.install(this, request, response);
    }

    @Override
    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }

    //##################################################
    //# server session
    //##################################################

    protected void beginServerSession()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                MyServerSessionManager.beginSession();
            }
        }.run();
    }

    protected boolean touchServerSession()
    {
        return new KmDaoResultCommand<Boolean>()
        {
            @Override
            protected Boolean handleResult()
            {
                return MyServerSessionManager.touchSession();
            }
        }.runResult();
    }

    protected boolean hasValidServerSession()
    {
        return MyServerSessionManager.hasValidSession();
    }

    protected void endServerSession()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                MyServerSessionManager.endSession();
            }
        }.run();
    }

    //##################################################
    //# support
    //##################################################

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
