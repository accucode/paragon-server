package com.app.utility;

import com.kodemore.file.KmFile;
import com.kodemore.patch.KmPatchManager;
import com.kodemore.servlet.action.ScActions;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.time.KmTimeZoneBridge;
import com.kodemore.utility.Kmu;

import com.app.bridge.MyApplicationBridge;
import com.app.bridge.MyDaoBridge;
import com.app.bridge.MyDatabaseConnectionFactory;
import com.app.bridge.MyPatchBridge;
import com.app.bridge.MyTimeZoneBridge;
import com.app.dao.core.MyDaoSessionManager;
import com.app.file.MyFilePaths;
import com.app.file.MyResourceFiles;
import com.app.file.MySharedFiles;
import com.app.hibernate.MyHibernateConfiguration;
import com.app.job.MyMasterJobManager;
import com.app.property.MyPropertyManager;
import com.app.ui.core.MyActions;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.layout.MyPageLayoutBridge;
import com.app.ui.page.MyMenuRegistry;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.servlet.MyFormatter;
import com.app.ui.servlet.MyScBridge;

/**
 * I install the application when the servlet container initially
 * starts.  My install method should only be called once per JVM.
 *
 * The two most commonly used methods are install(), and installCore().
 */
public class MyInstaller
{
    //##################################################
    //# logger
    //##################################################

    private static final MyInstallerLog _logger    = new MyInstallerLog(MyInstaller.class);

    private static boolean              _installed = false;

    //##################################################
    //# public
    //##################################################

    /**
     * The standard install.
     */
    public static void install()
    {
        long used1 = getUsedMemory();

        _installCore();
        _installUserInterface();

        _installJdbc();
        _syncDatabasePatches();

        _installHibernate();
        _installLog4j();

        _installClock();
        _installAjaxLog();
        _installJobs();

        long used2 = getUsedMemory();
        printMemory(used1, used2);

        printStartup();

        _installed = true;
    }

    /**
     * Install only the minimum config without database access.
     * The intent is for this minimal install to be *very* quick
     * and suitable for test methods in development that need access
     * to properties and basic resources.
     */
    public static void installCore()
    {
        _installCore();
    }

    /**
     * Perform the core install, and configure the database.
     * The UI layer is not installed.
     */
    public static void installDatabase()
    {
        _installCore();

        _installJdbc();
        _installHibernate();
        _installLog4j();
    }

    /**
     * Install the raw jdbc connection configuration,
     * but NOT the hibernate configuration.
     * This includes the pre-requisites.
     */
    public static void installJdbc()
    {
        _installCore();
        _installJdbc();
    }

    /**
     * Install hibernate;
     * Assumes the pre-requisites (jdbc) are already installed.
     */
    public static void installHibernate()
    {
        if ( !MyHibernateConfiguration.isInstalled() )
            _installHibernate();
    }

    public boolean isInstalled()
    {
        return _installed;
    }

    public void checkPreInstalled()
    {
        if ( isInstalled() )
            throw Kmu.newFatal("Operation not allowed after install.");
    }

    //##################################################
    //# private
    //##################################################

    private static void _syncDatabasePatches()
    {
        boolean sync = MyGlobals.getProperties().getDatabaseSyncOnStartup();
        if ( !sync )
            return;

        printfHeader("Database Patch Sync");

        KmPatchManager mgr = new KmPatchManager();
        mgr.setLog(_logger);
        mgr.sync();
        printOk();

    }

    private static void _installCore()
    {
        _installLog4jConsole();
        _installApplicationBridge();
        _installUrlBridge();

        _installEnvironment();
        _installResourceFiles();
        _installPropertyManager();
        _installSharedFiles();

        _installTimeZoneBridge();
    }

    private static void _installEnvironment()
    {
        printfHeader("Environment");
        if ( !MyEnvironment.isInstalled() )
            MyEnvironment.install();
        printOk();
    }

    private static void _installPropertyManager()
    {
        printfHeader("Properties");
        MyPropertyManager.install();
        printOk();
    }

    private static void _installSharedFiles()
    {
        printfHeader("Shared Files");
        MySharedFiles.install();
        printOk();
    }

    private static void _installPatchBridge()
    {
        if ( MyPatchBridge.isInstalled() )
            return;

        printfHeader("Patch Bridge");
        MyPatchBridge.installBridge();
        printOk();
    }

    private static void _installApplicationBridge()
    {
        printfHeader("Application Bridge");
        MyApplicationBridge.install();
        printOk();
    }

    private static void _installUrlBridge()
    {
        printfHeader("Url Bridge");
        MyUrlBridge.install();
        printOk();
    }

    private static void _installLog4jConsole()
    {
        // This does NOT rely on properties or the database.
        MyLog4jManager.installConsole();

        // Don't use the logger until it has been installed.
        printfHeader("Log4j (console)");
        printOk();
    }

    private static void _installLog4j()
    {
        // This relies on the properties and database.
        printfHeader("Log4j");
        MyLog4jManager.install();
        printOk();
    }

    private static void _installClock()
    {
        printfHeader("Clock");
        MyClock.install();
        printOk();
    }

    private static void _installAjaxLog()
    {
        boolean delete = MyGlobals.getProperties().getAjaxLogDeleteOnStart();
        if ( !delete )
            return;

        String path = MyFilePaths.getAjaxLogFile();
        new KmFile(path).write("");
    }

    private static void _installJobs()
    {
        printfHeader("Jobs");
        MyMasterJobManager.install();
        printOk();
    }

    private static void _installJdbc()
    {
        _installConnectionFactory();
        _installPatchBridge();
    }

    private static void _installHibernate()
    {
        _installDaoBridge();
        _installDaoSessionManager();
        _installHibernateConfiguration();
    }

    private static void _installConnectionFactory()
    {
        printfHeader("Connection Factory");
        MyDatabaseConnectionFactory.install();
        printOk();
    }

    private static void _installHibernateConfiguration()
    {
        printfHeader("Hibernate Configuration");
        MyHibernateConfiguration.install();
        printOk();
    }

    private static void _installDaoBridge()
    {
        printfHeader("Dao Bridge");
        MyDaoBridge.install();
        printOk();
    }

    private static void _installDaoSessionManager()
    {
        printfHeader("Session Manager");
        MyDaoSessionManager.install();
        printOk();
    }

    private static void _installUserInterface()
    {
        _installScBridge();
        _installServletCallbacks();
        _installControlRegistry();
        _installActions();
        _installCoders();
        _installFormatter();
        _installPageLayout();
        _installPages();
        _installMenu();

        lockControlRegistry();
    }

    private static void _installPageLayout()
    {
        printfHeader("Layouts");
        MyPageLayout.installInstance();
        MyPageLayoutBridge.install();
        printOk();
    }

    private static void lockControlRegistry()
    {
        printfHeader("Lock ScRegistry");
        ScControlRegistry.getInstance().setLocked();
        printOk();
    }

    private static void _installPages()
    {
        printfHeader("Pages");
        MyPageRegistry.install();
        printOk();
    }

    private static void _installMenu()
    {
        printfHeader("Menu");
        MyMenuRegistry.install();
        printOk();
    }

    private static void _installTimeZoneBridge()
    {
        printfHeader("TimeZoneBridge");
        KmTimeZoneBridge.setInstance(new MyTimeZoneBridge());
        printOk();
    }

    private static void _installResourceFiles()
    {
        printfHeader("Resource Files");
        MyResourceFiles.install();
        printOk();
    }

    private static void _installServletCallbacks()
    {
        printfHeader("ScServletCallbacks");
        String path = MyUrls.getCallbackPath();
        ScServletCallbackRegistry.install(path);
        printOk();
    }

    private static void _installScBridge()
    {
        printfHeader("ScBridge");
        MyScBridge.install();
        printOk();
    }

    private static void _installControlRegistry()
    {
        printfHeader("ScRegistry");
        ScControlRegistry.install();
        printOk();
    }

    private static void _installActions()
    {
        printfHeader("Actions");
        ScGlobalContext.install();
        ScActions.install();
        MyActions.install();
        printOk();
    }

    private static void _installCoders()
    {
        printfHeader("Coders");
        // ScCoderRegistry.instance.registerCoder(new My...Coder());
        printOk();
    }

    private static void _installFormatter()
    {
        printfHeader("Formatter");
        MyFormatter.install();
        printOk();
    }

    //##################################################
    //# print
    //##################################################

    private static String _header;

    public static void printfln(String s, Object... args)
    {
        String format = _header + ": " + s;
        _printfln(format, args);
    }

    private static void printfHeader(String header, Object... args)
    {
        _header = header;
        String format = header + ": installing...";
        _printfln(format, args);
    }

    private static void printOk()
    {
        printfln("ok.");
    }

    private static void printStartup()
    {
        int n = 50;
        String line = "##%s##";

        String header = Kmu.format(line, Kmu.repeat('#', n));
        String spacer = Kmu.format(line, Kmu.repeat(' ', n));

        _println();
        _printfln(header);
        _printfln(spacer);

        String s;
        s = Kmu.format("  %s", MyConstantsIF.APPLICATION_NAME);
        s = Kmu.rightPad(s, n);
        s = Kmu.format(line, s);
        _printfln(s);

        s = Kmu.format("  %s, %s", Kmu.getLocalHostName(), Kmu.getLocalHostAddress());
        s = Kmu.rightPad(s, n);
        s = Kmu.format(line, s);
        _printfln(s);

        s = Kmu.format("  %s", MyConstantsIF.APPLICATION_VERSION);
        s = Kmu.rightPad(s, n);
        s = Kmu.format(line, s);
        _printfln(s);

        _printfln(spacer);
        _printfln(header);
        _println();
    }

    private static void _println()
    {
        _logger.println("");
    }

    private static void _printfln(String s, Object... args)
    {
        _logger.printfln(s, args);
    }

    //##################################################
    //# support
    //##################################################

    private static void printMemory(long used1, long used2)
    {
        long used = used2 - used1;
        long total = Runtime.getRuntime().totalMemory();

        printfHeader("Memory");
        printfln("current total: %,11d", total);
        printfln("used before:   %,11d", used1);
        printfln("used after:    %,11d", used2);
        printfln("used:          %,11d", used);
        printOk();
    }

    private static long getUsedMemory()
    {
        return Kmu.getUsedMemory();
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        MyInstaller.installCore();

    }
}
