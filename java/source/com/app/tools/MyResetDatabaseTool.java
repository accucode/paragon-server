package com.app.tools;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.dao.KmAbstractDao;
import com.kodemore.log.KmLog;
import com.kodemore.patch.KmPatch;
import com.kodemore.patch.KmPatchBridge;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyPatch;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

/**
 * Reset the database with the bare minimum data required to run the application.
 * This does NOT install any sample data, but it does install a few records that
 * are necessary for initial operation; e.g.: the initial 'root' user.
 *
 * This truncates any existing records in the application tables, but it assumes
 * that the schema and tables already exist.
 *
 * NOT TRANSACTION SAFE
 * This tool requires hibernate, but can be run either with, or without an
 * existing transaction.  Because this tool uses the 'truncate' command to
 * quickly delete existing data, it is not transaction safe.
 */
public class MyResetDatabaseTool
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        MyInstaller.installDatabase();
        run();
    }

    public static void run()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.setRunnable(new MyResetDatabaseTool()::handle);
        cmd.disableWarningThresholdMs();
        cmd.run();
    }

    //##################################################
    //# constructor
    //##################################################

    private MyResetDatabaseTool()
    {
        // private
    }

    //##################################################
    //# handle
    //##################################################

    private void handle()
    {
        log("Reset Database...");
        truncateAll();

        installSettings();
        installSystemTenant();
        installRootUser();
        installExistingPatches();

        log("Reset Database, ok.");
    }

    private void truncateAll()
    {
        log("truncate tables...");

        KmList<KmAbstractDao<?,?>> v = getAccess().getAllDaos();
        for ( KmAbstractDao<?,?> e : v )
        {
            log("  truncate %s...", e.getClass().getSimpleName());
            e._truncate();
        }
    }

    private void installSettings()
    {
        log("install settings...");
        getAccess().getSettingsDao().installSettings();
    }

    private void installSystemTenant()
    {
        MyTenant e;
        e = new MyTenant();
        e.setUid(MyTenant.SYSTEM_UID);
        e.setName("System");
        e.setHostname(MyGlobals.getProperties().getBootstrapSystemHostname());
        e.daoAttach();
    }

    private void installRootUser()
    {
        MyUser u;
        u = getSystemTenant().addUser();
        u.setNickname("Root");
        u.setEmail(MyUser.ROOT_EMAIL);
        u.setRoleDeveloper();
        u.clearPassword();
        u.daoAttach();
    }

    private void installExistingPatches()
    {
        log("install existing patches...");

        KmList<KmPatch> v = KmPatchBridge.getInstance().getLocalPatches();
        for ( KmPatch e : v )
        {
            log("  patch %s...", e.getName());

            MyPatch p;
            p = new MyPatch();
            p.setName(e.getName());
            p.setSource(e.getSource());
            p.daoAttach();
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    private MyTenant getSystemTenant()
    {
        return getAccess().getTenantDao().findSystemTenant();
    }

    private void log(String msg, Object... args)
    {
        KmLog.printfln(msg, args);
    }
}
