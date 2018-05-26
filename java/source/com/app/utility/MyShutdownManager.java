package com.app.utility;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import com.kodemore.log.KmLog;
import com.kodemore.thread.KmThreadLocalCleaner;
import com.kodemore.thread.KmThreadLocalManager;

import com.app.chore.MyMasterChoreManager;
import com.app.hibernate.MyHibernateConfiguration;

/**
 * I coordinate the process of UN-deploying the application in a
 * polite manner.  The goal is to avoid stack traces, memory leaks,
 * and (non-daemon) threads that may occur in production.  This is
 * of greater importance when running in an environment where the
 * application may be undeployed and subsequently redeployed without
 * fully shutting down the container (tomcat).
 */
public class MyShutdownManager
{
    //##################################################
    //# public
    //##################################################

    public static void shutdown()
    {
        KmLog.info("Shutdown...");

        shutdownJobs();
        shutdownLogging();
        shutdownHibernate();
        shutdownAbandonedConnectionThread();
        shutdownSqlDrivers();
        shutdownThreadLocals();

        KmLog.info("Shutdown ok.");
    }

    //##################################################
    //# private
    //##################################################

    /**
     * Shutdown all of the jobs.
     * Note that this will WAIT for any jobs that are currently running to finish
     * their cycle and then exit politely.  In most cases, this only takes a few
     * seconds.  However, some jobs (e.g.: nightly maintenance) may take much longer.
     */
    private static void shutdownJobs()
    {
        MyMasterChoreManager.getInstance().stop();
    }

    /**
     * Shutdown any background threads that hibernate may be running.
     */
    private static void shutdownHibernate()
    {
        MyHibernateConfiguration.getInstance().shutDown();
    }

    /**
     * Shutdown the thread used by the mysql driver to monitor abandoned connections.
     */
    private static void shutdownAbandonedConnectionThread()
    {
        try
        {
            AbandonedConnectionCleanupThread.shutdown();
        }
        catch ( Exception ex )
        {
            KmLog.error("Error in shutdown.", ex);
        }
    }

    /**
     * Deregister any sql drivers.
     */
    private static void shutdownSqlDrivers()
    {
        try
        {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while ( drivers.hasMoreElements() )
            {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        }
        catch ( SQLException ex )
        {
            KmLog.error("Error in shutdown.", ex);
        }
    }

    /**
     * Revert the log4j back to console only mode.
     * We try to do this as late as possible, but it needs to be done
     * before we shutdown the database or threadLocals since the production
     * logger to write to the database.
     */
    private static void shutdownLogging()
    {
        KmLog.info("Shutdown logging, revert to console only...");
        MyLog4jManager.installConsole();
        KmLog.info("Shutdown logging, revert to console only, ok.");
    }

    /**
     * Clean up any threadLocals that were created by the application.
     * In most cases, there really shouldn't be any since ideally they
     * are always cleaned when each http request thread finishes.
     */
    private static void shutdownThreadLocals()
    {
        KmThreadLocalManager.clearDirtyLocals();
        KmThreadLocalCleaner.cleanKmLocals();
    }
}
