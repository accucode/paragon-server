package com.app.tools;

import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.log.KmLog;

import com.app.dao.base.MyDaoRegistry;
import com.app.install.MyResetDatabaseTool;
import com.app.model.MyUser;
import com.app.model.MyUserRole;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

/**
 * I am used to install sample data for development and testing.
 *
 * This data should only be installed on top of an empty database,
 * and should only be run once.
 *
 * Many of the samples use specific hardcoded values in order to make
 * the data more realistic and/or familiar.  However, values are NOT
 * compared against existing data which means that attempting to install
 * this sample data on top of an existing database can result in duplicate
 * keys or other problems.
 *
 * This tool is NOT intended to generate bulk data for performance/load testing.
 * If you need large volumes of bulk data...
 * @see MyBulkDataTool
 */
public class MySampleDataTool
{
    //##################################################
    //# static
    //##################################################

    public static void run()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(new MySampleDataTool()::install);
        cmd.disableWarningThresholdMs();
        cmd.run();
    }

    //##################################################
    //# constructor
    //##################################################

    private MySampleDataTool()
    {
        // private
    }

    //##################################################
    //# handle
    //##################################################

    private void install()
    {
        log("Install sample data...");

        installUsers();
        installProjects();

        log("Install sample data, ok.");
    }

    //==================================================
    //= users
    //==================================================

    /**
     * Install some global users.
     * This does NOT apply project specific roles or access.
     */
    private void installUsers()
    {
        log("install users...");

        installUser("AJ Love", "alove@accucode.com", MyUserRole.Developer);
        installUser("Wyatt Love", "wlove@accucode.com", MyUserRole.Developer);
        installUser("Ryan Waxler", "rwaxler@accucode.com", MyUserRole.Developer);
        installUser("Aaron Ledbetter", "aledbetter@accucode.com", MyUserRole.Developer);
        installUser("Steve Granado", "sgranado@accucode.com", MyUserRole.Developer);
    }

    private MyUser installUser(String name, String email, MyUserRole role)
    {
        MyUser e;
        e = getAccess().getUserDao().createUser(name, email);
        e.clearPassword();
        e.setRole(role);
        e.setVerified(true);
        return e;
    }

    //==================================================
    //= projects
    //==================================================

    private void installProjects()
    {
        log("install projects...");

        int n = 3;
        for ( int i = 0; i < n; i++ )
            installSampleProject(i + 1);
    }

    private void installSampleProject(int i)
    {
        log("install project; %s...", i);

        MySampleProjectTool.run(i);
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private void log(String msg, Object... args)
    {
        KmLog.printfln(msg, args);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        printHeader("Install Database...");
        MyInstaller.installDatabase();

        printHeader("Reset Database...");
        MyResetDatabaseTool.run();

        printHeader("Sample Data...");
        MySampleDataTool.run();

        printHeader("Done.");
    }

    private static void printHeader(String s)
    {
        System.out.println();
        System.out.printf("=====  %s  ===============================================%n", s);
    }
}
