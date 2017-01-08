package com.app.ui.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.command.KmDao;
import com.kodemore.servlet.ScAbstractServlet;
import com.kodemore.utility.Kmu;

import com.app.model.MyServerSession;
import com.app.model.MyTenant;
import com.app.property.MyProperties;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletData;
import com.app.ui.page.login.MyLoginUtility;
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

    protected final MyServerSession beginServerSession()
    {
        return KmDao.fetch(this::beginServerSessionDao);
    }

    private MyServerSession beginServerSessionDao()
    {
        MyTenant tenant = getData().getTenant();
        if ( tenant == null )
            throw Kmu.newError("Cannot determine tenant.");

        MyServerSessionManager.beginSession(tenant);
        MyLoginUtility.checkAutoLogin(tenant);

        return MyServerSessionManager.getSession();
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

    protected final MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

}
