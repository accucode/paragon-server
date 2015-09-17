package com.app.ui.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.command.KmDao;
import com.kodemore.servlet.ScAbstractServlet;

import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;
import com.app.ui.page.login.MySignInUtility;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;

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

    protected final void beginServerSession()
    {
        KmDao.run(this::beginServerSessionDao);
    }

    private void beginServerSessionDao()
    {
        MyServerSessionManager.beginSession();
        MySignInUtility.checkAutoSignIn();
    }

    protected boolean touchServerSession()
    {
        return KmDao.fetch(MyServerSessionManager::touchSession);
    }

    protected boolean hasValidServerSession()
    {
        return MyServerSessionManager.hasValidSession();
    }

    protected void endServerSession()
    {
        KmDao.run(MyServerSessionManager::endSession);
    }

    //##################################################
    //# support
    //##################################################

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
