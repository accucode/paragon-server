package com.app.utility;

import com.kodemore.log.KmLogger;
import com.kodemore.servlet.action.ScActions;
import com.kodemore.servlet.utility.ScControlRegistry;
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
import com.app.job.MyMasterJob;
import com.app.property.MyPropertyManager;
import com.app.ui.activity.MyActivityRegistry;
import com.app.ui.core.MyActions;
import com.app.ui.core.MyCookieSession;
import com.app.ui.core.MyPageSession;
import com.app.ui.layout.MyLeftMenu;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.layout.MyPageLayoutBridge;
import com.app.ui.servlet.MyFormatter;
import com.app.ui.servlet.ScServletCallbackRegistry;

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

    private static final KmLogger _logger    = KmLogger.getLogger(MyInstaller.class);

    private static boolean        _installed = false;

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

        _installJdbc();
        _installHibernate();
        _installLog4j();

        _installUserInterface();
        _installClock();
        _installAjaxLog();
        _installJobs();
        _installShutdownHook();

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
            Kmu.fatal("Operation not allowed after install.");
    }

    //##################################################
    //# private
    //##################################################

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
        printfHeader("Log4j (console)");
        MyLog4jManager.installConsole();
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
        Kmu.deleteFile(path);
    }

    private static void _installJobs()
    {
        printfHeader("Jobs");
        MyMasterJob.install();
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
        _installServletCallbacks();
        _installControlRegistry();
        _installActions();
        _installPageSession();
        _installCookieSession();
        _installCoders();
        _installFormatter();
        _installPageLayout();
        _installHashBridge();
        _installLeftMenu();
        _installActivities();

        lockControlRegistry();
    }

    private static void _installPageLayout()
    {
        printfHeader("Layouts");
        MyPageLayout.install();
        MyPageLayoutBridge.install();
        printOk();
    }

    private static void lockControlRegistry()
    {
        printfHeader("Lock ScRegistry");
        ScControlRegistry.getInstance().setTransient();
        printOk();
    }

    private static void _installActivities()
    {
        printfHeader("Activities");
        MyActivityRegistry.install();
        printOk();
    }

    private static void _installLeftMenu()
    {
        printfHeader("LeftMenu");
        MyLeftMenu.install();
        printOk();
    }

    private static void _installHashBridge()
    {
        printfHeader("HashBridge");
        MyHashBridge.install();
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

    private static void _installControlRegistry()
    {
        printfHeader("ScRegistry");
        ScControlRegistry.install();
        printOk();
    }

    private static void _installActions()
    {
        printfHeader("Actions");
        ScActions.install();
        MyActions.install();
        printOk();
    }

    private static void _installPageSession()
    {
        printfHeader("PageSession");
        MyPageSession.install();
        printOk();
    }

    private static void _installCookieSession()
    {
        printfHeader("CookieSession");
        MyCookieSession.install();
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

    private static void _installShutdownHook()
    {
        printfHeader("Shutdown Hook");
        Thread t = new Thread("My Shutdown Hook")
        {
            @Override
            public void run()
            {
                shutdown();
            }
        };
        Runtime.getRuntime().addShutdownHook(t);
        printOk();
    }

    private static void shutdown()
    {
        _printfln("Shutdown...");
        MyMasterJob.shutdown();
        _printfln("Shutdown ok.");
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

        s = Kmu.format("  %s", Kmu.getLocalHostName());
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
        _logger.info();
    }

    private static void _printfln(String s, Object... args)
    {
        _logger.info(s, args);
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
