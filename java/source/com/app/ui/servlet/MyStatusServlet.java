package com.app.ui.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.time.KmClock;
import com.kodemore.utility.Kmu;

import com.app.utility.MyConstantsIF;

public class MyStatusServlet
    extends HttpServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        handle(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    {
        handle(req, res);
    }

    //##################################################
    //# handle
    //##################################################

    protected void handle(HttpServletRequest req, HttpServletResponse res)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();
        out.beginBody();

        out.println("Application");
        out.printBold(MyConstantsIF.APPLICATION_NAME);
        out.println();
        out.println();

        out.println("Version");
        out.printBold(MyConstantsIF.APPLICATION_VERSION);
        out.println();
        out.println();

        out.println("Time");
        out.printBold(KmClock.getUtcTimestamp().format_m_d_yyyy_hh_mm_ss() + " UTC");
        out.println();
        out.println();

        out.println("Method");
        out.printBold(req.getMethod());
        out.println();
        out.println();

        write(res, out.toString());
    }

    private void write(HttpServletResponse res, String html)
    {
        try
        {
            res.setContentType("text/html");
            res.setContentLength(html.length());
            res.getWriter().write(html);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }
}
