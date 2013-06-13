package com.app.ui.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.utility.MyConstantsIF;
import com.app.utility.MyEnvironment;
import com.app.utility.MyInstaller;

public class MyInitServlet
    extends HttpServlet
    implements MyConstantsIF
{
    //##################################################
    //# init
    //##################################################

    @Override
    public void init()
    {
        String rootPath = getServletContext().getRealPath("");
        MyEnvironment.install(rootPath);
        MyInstaller.install();
    }

    //##################################################
    //# unsupported
    //##################################################

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        throw new UnsupportedOperationException();
    }

}
