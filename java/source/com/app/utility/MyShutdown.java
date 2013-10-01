package com.app.utility;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import com.app.job.MyMasterJob;

import com.kodemore.log.KmLog;
import com.kodemore.thread.KmThreadLocalCleaner;
import com.kodemore.thread.KmThreadLocalManager;

/**
 * I coordinate the process of shutting down the tomcat JVM.
 */
public class MyShutdown
{
    //##################################################
    //# public
    //##################################################//

    public static void shutdown()
    {
        KmLog.info("Shutdown...");

        shutdownJobs();
        shutdownSqlDrivers();
        shutdownLogging();
        shutdownThreadLocals();

        KmLog.info("Shutdown ok.");
    }

    //##################################################
    //# private
    //##################################################//

    private static void shutdownJobs()
    {
        MyMasterJob.shutdown();
    }

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
            throw new RuntimeException("Error unloading the JDBC Drivers", ex);
        }
    }

    private static void shutdownLogging()
    {
        KmLog.info("Shutdown logging, revert to console only...");
        MyLog4jManager.installConsole();
        KmLog.info("Shutdown logging, revert to console only, ok.");
    }

    private static void shutdownThreadLocals()
    {
        KmThreadLocalManager.clearDirtyLocals();

        KmThreadLocalCleaner e;
        e = new KmThreadLocalCleaner();
        e.cleanAll();
    }
}
