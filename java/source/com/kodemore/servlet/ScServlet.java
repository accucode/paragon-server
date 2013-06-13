package com.kodemore.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ScServlet
    extends ScAbstractServlet<ScServletData>
{
    //##################################################
    //# overrides
    //##################################################

    @Override
    protected ScServletData newServletData(HttpServletRequest request, HttpServletResponse response)
    {
        return new ScServletData(this, request, response);
    }

    @Override
    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

}
