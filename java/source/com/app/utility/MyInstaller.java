package com.app.utility;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.file.KmFile;
import com.kodemore.log.KmLog;
import com.kodemore.patch.KmPatchManager;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.action.ScActions;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.control.ScDownloadDialog;
import com.kodemore.servlet.field.ScScanBarcodeDialog;
import com.kodemore.servlet.utility.ScActionRegistry;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScLocalRegistry;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.time.KmTimeZoneBridge;
import com.kodemore.utility.KmDeadlockMonitor;
import com.kodemore.utility.Kmu;

import com.app.bridge.MyApplicationBridge;
import com.app.bridge.MyDaoBridge;
import com.app.bridge.MyDatabaseConnectionFactory;
import com.app.bridge.MyPatchBridge;
import com.app.bridge.MyTimeZoneBridge;
import com.app.chore.MyMasterChoreManager;
import com.app.dao.core.MyDaoSessionManager;
import com.app.file.MyFilePaths;
import com.app.file.MyResourceFiles;
import com.app.file.MySharedFiles;
import com.app.hibernate.MyHibernateConfiguration;
import com.app.macro.MyMacros;
import com.app.model.base.MyModelType;
import com.app.property.MyPropertyManager;
import com.app.tools.MyDomainHierarchyValidatorTool;
import com.app.ui.MyGlobalSession;
import com.app.ui.control.MyAddNoteDialog;
import com.app.ui.dashboard.core.MyDashboardPanelRegistry;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.layout.MyPageLayoutBridge;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.guide.MyAddProjectDialog;
import com.app.ui.page.menu.MyMenuRegistry;
import com.app.ui.selector.MyChoiceSelectorDialog;
import com.app.ui.selector.MyCustomerSelectorDialog;
import com.app.ui.selector.MySiteSelectorDialog;
import com.app.ui.selector.MyVendorSelectorDialog;
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
    //# static
    //##################################################

    private static final MyInstallerLog _logger = new MyInstallerLog(MyInstaller.class);

    private static boolean _installed = false;

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
        _installDatabasePatches();
        _installHibernate();
        _installLog4j();

        _installAjaxLog();
        _installThreadTopics();

        _installJobs();

        _validateDomainHierarchy();

        printStats();

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
     * Install the user interface; e.g.: pages and controls.
     * This does NOT install the database so you cannot render
     * anything. This is primarily used to test memory usage.
     */
    public static void installUserInterface()
    {
        _installCore();
        _installUserInterface();
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
     * Perform the core install, configure the database, and install the UI.
     */
    public static void installDatabaseAndUi()
    {
        _installCore();
        _installUserInterface();
        _installJdbc();
        _installHibernate();
        _installLog4j();
    }

    /**
     * Install the raw jdbc connection configuration,
     * but NOT the hibernate configuration.
     * This includes the prerequisites.
     */
    public static void installJdbc()
    {
        _installCore();
        _installJdbc();
    }

    /**
     * Install hibernate;
     * Assumes the prerequisites (jdbc) are already installed.
     */
    public static void installHibernate()
    {
        if ( !MyHibernateConfiguration.isInstalled() )
            _installHibernate();
    }

    public static boolean isInstalled()
    {
        return _installed;
    }

    public static void warnIfInstalled()
    {
        if ( isInstalled() )
            KmLog.warnTrace("Operation not allowed after install.");
    }

    //##################################################
    //# shutdown
    //##################################################

    public static void shutdown()
    {
        MyShutdownManager.shutdown();
    }

    //##################################################
    //# private
    //##################################################

    private static void _installCore()
    {
        MyLog4jManager.installConsole();

        _installDeadlockMonitor();
        _installApplicationBridge();
        _installUrlBridge();

        _installEnvironment();
        _installResourceFiles();
        _installPropertyManager();
        _installSharedFiles();

        _installTimeZoneBridge();
        _installFormatter();
    }

    private static void _installEnvironment()
    {
        printfHeader("Environment");
        if ( !MyEnvironment.isInstalled() )
            MyEnvironment.install();
    }

    private static void _installPropertyManager()
    {
        printfHeader("Properties");
        MyPropertyManager.install();
    }

    private static void _installSharedFiles()
    {
        printfHeader("Shared Files");
        MySharedFiles.install();
    }

    private static void _installPatchBridge()
    {
        if ( MyPatchBridge.isInstalled() )
            return;

        printfHeader("Patch Bridge");
        MyPatchBridge.installBridge();
    }

    private static void _installApplicationBridge()
    {
        printfHeader("Application Bridge");
        MyApplicationBridge.install();
    }

    private static void _installUrlBridge()
    {
        printfHeader("Url Bridge");
        MyUrlBridge.install();
    }

    private static void _installLog4j()
    {
        // This relies on the properties and database.
        printfHeader("Log4j");
        MyLog4jManager.install();
    }

    private static void _installDeadlockMonitor()
    {
        printfHeader("Deadlock Monitor");
        KmDeadlockMonitor.start();
    }

    private static void _installAjaxLog()
    {
        printfHeader("Ajax Log");

        boolean delete = MyGlobals.getProperties().getAjaxLogDeleteOnStart();
        if ( delete )
        {
            String path = MyFilePaths.getAjaxLogFile();
            new KmFile(path).write("");
        }
    }

    private static void _installThreadTopics()
    {
        printfHeader("Thread Topics");

        boolean delete = MyGlobals.getProperties().getDeleteThreadTopicsOnStart();
        if ( delete )
            KmDao.run(MyInstaller::deleteThreadTopics);
    }

    private static void deleteThreadTopics()
    {
        MyGlobals.getAccess().getThreadTopicDao().deleteAll();
    }

    private static void _installJobs()
    {
        printfHeader("Jobs");
        MyMasterChoreManager.install();
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

    private static void _installDatabasePatches()
    {
        boolean sync = MyGlobals.getProperties().getDatabaseSyncOnStartup();
        if ( !sync )
            return;

        printfHeader("Database Patch Sync");

        KmPatchManager mgr;
        mgr = new KmPatchManager();
        mgr.setLog(_logger);
        mgr.sync();
    }

    private static void _installConnectionFactory()
    {
        printfHeader("Connection Factory");
        MyDatabaseConnectionFactory.install();
    }

    private static void _installHibernateConfiguration()
    {
        printfHeader("Hibernate Configuration");
        MyHibernateConfiguration.install();
    }

    private static void _installDaoBridge()
    {
        printfHeader("Dao Bridge");
        MyDaoBridge.install();
    }

    private static void _installDaoSessionManager()
    {
        printfHeader("Session Manager");
        MyDaoSessionManager.install();
    }

    private static void _installUserInterface()
    {
        _installUiRegistries();

        _installServletCallbacks();
        _installScBridge();
        _installActions();
        _installCoders();
        _installMacros();
        _installNavigators();
        _installDialogs();
        _installSelectorDialogs();
        _installPageLayout();
        _installPages();
        _installDashboard();
        _installMenu();

        compressPageMemory();
        lockUiRegistries();
    }

    private static void _installPageLayout()
    {
        printfHeader("Layouts");
        MyPageLayout.installInstance();
        MyPageLayoutBridge.install();
    }

    private static void compressPageMemory()
    {
        printfHeader("Compress Page Memory");
        KmList<ScPage> v = MyPageRegistry.getInstance().getPages();
        for ( ScPage e : v )
            e.compressMemory();
    }

    private static void lockUiRegistries()
    {
        printfHeader("Lock UI Registries");
        ScControlRegistry.getInstance().lock();
        ScLocalRegistry.getInstance().lock();
        ScActionRegistry.getInstance().lock();
    }

    private static void _installPages()
    {
        printfHeader("Pages");
        MyPageRegistry.install();
    }

    private static void _installDashboard()
    {
        printfHeader("Dashboard");
        MyDashboardPanelRegistry.install();
    }

    private static void _installMenu()
    {
        printfHeader("Menu");
        MyMenuRegistry.install();
    }

    private static void _installTimeZoneBridge()
    {
        printfHeader("TimeZoneBridge");
        KmTimeZoneBridge.setInstance(new MyTimeZoneBridge());
    }

    private static void _installResourceFiles()
    {
        printfHeader("Resource Files");
        MyResourceFiles.install();
    }

    private static void _installServletCallbacks()
    {
        printfHeader("ScServletCallbacks");
        String path = MyUrls.getCallbackPath();
        ScServletCallbackRegistry.install(path);
    }

    private static void _installScBridge()
    {
        printfHeader("ScBridge");
        MyScBridge.install();
    }

    private static void _installUiRegistries()
    {
        printfHeader("UI Registries");

        ScControlRegistry.install();
        ScLocalRegistry.install();
        ScActionRegistry.install();
        MyGlobalSession.installInstance();
    }

    private static void _installActions()
    {
        printfHeader("Actions");
        ScGlobalContext.install();
        ScActions.install();
    }

    private static void _installCoders()
    {
        printfHeader("Coders");
        // ScCoderRegistry.instance.registerCoder(new My...Coder());
    }

    private static void _installMacros()
    {
        printfHeader("Macros");
        MyMacros.install();
    }

    private static void _installNavigators()
    {
        printfHeader("Navigators");
    }

    private static void _installDialogs()
    {
        printfHeader("Dialogs");

        MyDialogs.install();
        MyAddProjectDialog.installInstance();
        MyAddNoteDialog.installInstance();

        ScDownloadDialog.installInstance();
        ScScanBarcodeDialog.installInstance();
    }

    private static void _installSelectorDialogs()
    {
        printfHeader("Selector Dialogs");

        MyChoiceSelectorDialog.installInstance();
        MyCustomerSelectorDialog.installInstance();
        MySiteSelectorDialog.installInstance();
        MyVendorSelectorDialog.installInstance();
    }

    private static void _installFormatter()
    {
        printfHeader("Formatter");
        MyFormatter.install();
    }

    //##################################################
    //# validate
    //##################################################

    private static void _validateDomainHierarchy()
    {
        printfHeader("Validate Domain Hierarchy");
        MyDomainHierarchyValidatorTool.run();
    }

    //##################################################
    //# print
    //##################################################

    public static void enableLogging()
    {
        _logger.enable();
    }

    public static void disableLogging()
    {
        _logger.disable();
    }

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

    private static void printStats()
    {
        _println();
        printfHeader("Stats");
        printfln("models:   %,7d", MyModelType.values().length);
        printfln("pages:    %,7d", MyPageRegistry.getInstance().getPages().size());
        printfln("buttons:  %,7d", ScControlRegistry.getInstance().getPersistentButtonCount());
        printfln("controls: %,7d", ScControlRegistry.getInstance().getPersistentControlCount());
        printfln("actions:  %,7d", ScActionRegistry.getInstance().getCount());
    }

    private static void printMemory(long used1, long used2)
    {
        long used = used2 - used1;
        long total = Runtime.getRuntime().totalMemory();

        _println();
        printfHeader("Memory");
        printfln("current total: %,13d", total);
        printfln("used before:   %,13d", used1);
        printfln("used after:    %,13d", used2);
        printfln("used:          %,13d", used);
    }

    private static long getUsedMemory()
    {
        return Kmu.getUsedMemory();
    }
}
