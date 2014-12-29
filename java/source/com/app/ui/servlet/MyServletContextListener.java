package com.app.ui.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.kodemore.log.KmLog;

import com.app.utility.MyEnvironment;
import com.app.utility.MyInstaller;
import com.app.utility.MyShutdownManager;

/**
 * I am registered in the web.xml to provide convenient hooks
 * that are called when the servlet container (tomcat) is
 * initialized or shutdown.
 */
public class MyServletContextListener
    implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent ev)
    {
        try
        {
            KmLog.info("Servlet Context Initializing...");

            String root = ev.getServletContext().getRealPath("");
            KmLog.info("Servlet Context Path = " + root);

            MyEnvironment.install(root);
            MyInstaller.install();

            KmLog.info("Servlet Context Initialized.");
        }
        catch ( Throwable ex )
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent ev)
    {
        KmLog.info("Servlet Context Destroying...");
        MyShutdownManager.shutdown();
        KmLog.info("Servlet Context Destroyed.");
    }
}
