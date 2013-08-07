package com.app.install;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

import com.app.utility.MyConstantsIF;

public class MyInstallServlet
    extends HttpServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    {
        new Handler().run(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    {
        new Handler().run(req, res);
    }

    //##################################################
    //# handle
    //##################################################

    private class Handler
    {
        private HttpServletRequest  request;
        private HttpServletResponse response;

        private void run(HttpServletRequest req, HttpServletResponse res)
        {
            Handler e;
            e = new Handler();
            e.request = req;
            e.response = res;
            e.run();
        }

        private void run()
        {
            String param = request.getParameter("p");
            boolean install = Kmu.isEqual(param, "install");
            String html = render(install);

            write(html);
        }

        private String render(boolean install)
        {
            KmHtmlBuilder out;
            out = new KmHtmlBuilder();

            out.printDocType();
            out.beginHtml();
            out.beginBody();

            try
            {
                renderHeader(out);

                if ( install )
                    new MyDatabaseInstaller().run();
            }
            catch ( RuntimeException ex )
            {
                out.println();
                out.println();
                out.println(Kmu.formatStackTrace(ex));
            }

            out.endBody();
            out.endHtml();

            return out.toString();
        }

        private void renderHeader(KmHtmlBuilder out)
        {
            out.println(MyConstantsIF.APPLICATION_NAME);
            out.println(MyConstantsIF.APPLICATION_VERSION);

            out.println();
            out.println("Install");
            out.println("Used to install the database before running the application.");

            String installUrl = request.getRequestURI() + "?p=install";

            out.println();
            out.open("button");
            out.printAttribute("type", "button");
            out.printAttribute("onclick", "window.location='" + installUrl + "';");
            out.close();
            out.print("Install Database...");
            out.end("button");
            out.println();
        }

        private void write(String html)
        {
            try
            {
                response.setContentType("text/html");
                response.setContentLength(html.length());
                response.getWriter().write(html);
            }
            catch ( Exception ex )
            {
                throw Kmu.toRuntime(ex);
            }
        }
    }
}
