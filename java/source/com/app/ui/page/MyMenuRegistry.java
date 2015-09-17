package com.app.ui.page;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScPage;
import com.kodemore.utility.Kmu;

import com.app.ui.layout.MyMenuItem;
import com.app.ui.page.general.MyDashboardPage;
import com.app.ui.page.general.MyOrdersPage;
import com.app.ui.page.general.MyReportsPage;
import com.app.ui.page.general.MySignOutPage;
import com.app.ui.page.general.MyTasksPage;
import com.app.ui.page.general.MyTimeoutPage;
import com.app.ui.page.login.MyPasswordResetPage;
import com.app.ui.page.login.MySignInPage;
import com.app.ui.page.login.MyUserActivationPage;
import com.app.ui.page.manageAttentionGroups.MyManageAttentionGroupsPage;
import com.app.ui.page.manageCategories.MyManageCategoriesPage;
import com.app.ui.page.manageDepots.MyManageDepotsPage;
import com.app.ui.page.manageMembers.MyManageMembersPage;
import com.app.ui.page.managePowerTypes.MyManagePowerTypesPage;
import com.app.ui.page.manageProducts.MyManageProductsPage;
import com.app.ui.page.manageProjects.MyManageProjectsPage;
import com.app.ui.page.manageRegions.MyManageRegionsPage;
import com.app.ui.page.manageShipCarriers.MyManageShipCarriersPage;
import com.app.ui.page.manageSkills.MyManageSkillsPage;
import com.app.ui.page.manageUsers.MyManageUsersPage;
import com.app.ui.page.manageVendors.MyManageVendorsPage;
import com.app.ui.page.manageVisitTypes.MyManageVisitTypesPage;
import com.app.ui.page.test.MyAbsoluteLayoutTestPage;
import com.app.ui.page.test.MyAccordionTestPage;
import com.app.ui.page.test.MyAnimationTestPage;
import com.app.ui.page.test.MyAutoCompleteTestPage;
import com.app.ui.page.test.MyBarcodeTestPage;
import com.app.ui.page.test.MyBlankTestPage;
import com.app.ui.page.test.MyBlockTestPage;
import com.app.ui.page.test.MyBorderLayoutTestPage;
import com.app.ui.page.test.MyBorderTestPage;
import com.app.ui.page.test.MyCardFlipTestPage;
import com.app.ui.page.test.MyColorFieldTestPage;
import com.app.ui.page.test.MyDateFieldTestPage;
import com.app.ui.page.test.MyDialogTestPage;
import com.app.ui.page.test.MyDomainDropdownSetValueTestPage;
import com.app.ui.page.test.MyDownloadTestPage;
import com.app.ui.page.test.MyDragTestPage;
import com.app.ui.page.test.MyDraggableMultiSelectTestPage;
import com.app.ui.page.test.MyDropzoneTestPage;
import com.app.ui.page.test.MyEqualizeTestPage;
import com.app.ui.page.test.MyFacebookTestPage;
import com.app.ui.page.test.MyFieldTestPage;
import com.app.ui.page.test.MyFilterTableRowTestPage;
import com.app.ui.page.test.MyFlexboxTestPage;
import com.app.ui.page.test.MyFormTestPage;
import com.app.ui.page.test.MyGmailTestPage;
import com.app.ui.page.test.MyGoogleChartTestPage;
import com.app.ui.page.test.MyGradientTestPage;
import com.app.ui.page.test.MyGridTestPage;
import com.app.ui.page.test.MyGroupIconHeaderTestPage;
import com.app.ui.page.test.MyGroupTestPage;
import com.app.ui.page.test.MyHideErrorsTestPage;
import com.app.ui.page.test.MyHoverTestPage;
import com.app.ui.page.test.MyLocalValueTestPage;
import com.app.ui.page.test.MyMemoryLeakTestPage;
import com.app.ui.page.test.MyNavigationTest1Page;
import com.app.ui.page.test.MyNavigationTest2Page;
import com.app.ui.page.test.MyNotebookTestPage;
import com.app.ui.page.test.MyNvd3ChartTestPage;
import com.app.ui.page.test.MyOpenWindowTestPage;
import com.app.ui.page.test.MyPaddingTestPage;
import com.app.ui.page.test.MyPlaceholderTestPage;
import com.app.ui.page.test.MyRadioButtonTestPage;
import com.app.ui.page.test.MyScriptTestPage;
import com.app.ui.page.test.MySharedStateTest1Page;
import com.app.ui.page.test.MySharedStateTest2Page;
import com.app.ui.page.test.MySlowTestPage;
import com.app.ui.page.test.MySmtpTestPage;
import com.app.ui.page.test.MySplitterTestPage;
import com.app.ui.page.test.MyStaticIncludeTestPage;
import com.app.ui.page.test.MyTabbedTestPage;
import com.app.ui.page.test.MyTimeAgoTestPage;
import com.app.ui.page.test.MyTitlePanelTestPage;
import com.app.ui.page.test.MyToastTestPage;
import com.app.ui.page.test.MyWyattTestPage;
import com.app.ui.page.tools.MyDevApplicationLogsPage;
import com.app.ui.page.tools.MyDevApplicationPropertiesPage;
import com.app.ui.page.tools.MyDevBeanShellPage;
import com.app.ui.page.tools.MyDevEmailsPage;
import com.app.ui.page.tools.MyDevEnvironmentVariablesPage;
import com.app.ui.page.tools.MyDevHibernateCachePage;
import com.app.ui.page.tools.MyDevPerformanceLogPage;
import com.app.ui.page.tools.MyDevSharedFileBrowserPage;
import com.app.ui.page.tools.MyDevSqlPage;
import com.app.ui.page.tools.MyDevSystemPropertiesPage;
import com.app.ui.page.tools.MyDevUsersPage;
import com.app.ui.page.tools.MyDevUtilityPage;
import com.app.ui.page.userProfile.MyUserProfilePage;

public class MyMenuRegistry
{
    //##################################################
    //# static
    //##################################################

    private static MyMenuRegistry _instance;

    public static synchronized void install()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = new MyMenuRegistry();
    }

    public static MyMenuRegistry getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Already isntalled.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The root of the recursive composite.
     * The root itself is generally ignored.
     */
    private MyMenuItem _root;

    /**
     * A lookup that quickly returns the menu for a particular page (key).
     */
    private KmMap<String,MyMenuItem> _pageToMenuMap;

    //##################################################
    //# constructor
    //##################################################

    private MyMenuRegistry()
    {
        _root = new MyMenuItem();

        register();
        validate();
        initLookup();
    }

    //##################################################
    //# register
    //##################################################

    protected void register()
    {
        registerHome();
        registerTasks();
        registerOrders();
        registerReports();
        registerProjectSetup();
        registerAdmin();
        registerTools();
        registerTests();
    }

    private void registerHome()
    {
        getRoot().addMenu("Home", MyDashboardPage.getInstance());
    }

    private void registerTasks()
    {
        getRoot().addMenu("Tasks", MyTasksPage.getInstance());
    }

    private void registerOrders()
    {
        getRoot().addMenu("Orders", MyOrdersPage.getInstance());
    }

    private void registerReports()
    {
        getRoot().addMenu("Reports", MyReportsPage.getInstance());
    }

    private void registerProjectSetup()
    {
        MyMenuItem top;
        top = getRoot().addMenu("Project");

        MyMenuItem left;
        left = top.addMenu("Facilities");
        left.addMenu("Depots", MyManageDepotsPage.getInstance());
        left.addMenu("Ship Carriers", MyManageShipCarriersPage.getInstance());
        left.addMenu("Visit Types", MyManageVisitTypesPage.getInstance());

        left = top.addMenu("People");
        left.addMenu("Members", MyManageMembersPage.getInstance());
        left.addMenu("Skills", MyManageSkillsPage.getInstance());
        left.addMenu("Attention Groups", MyManageAttentionGroupsPage.getInstance());

        left = top.addMenu("Catalog");
        left.addMenu("Products", MyManageProductsPage.getInstance());
        left.addMenu("Categories", MyManageCategoriesPage.getInstance());
        left.addMenu("Vendors", MyManageVendorsPage.getInstance());
        left.addMenu("Power Types", MyManagePowerTypesPage.getInstance());
        left.addMenu("Regions", MyManageRegionsPage.getInstance());
    }

    private void registerAdmin()
    {
        MyMenuItem top;
        top = getRoot().addMenu("Admin");

        MyMenuItem left;
        left = top.addMenu("Admin");
        left.addMenu("Users", MyManageUsersPage.getInstance());
        left.addMenu("Projects", MyManageProjectsPage.getInstance());
    }

    private void registerTools()
    {
        MyMenuItem top;
        top = getRoot().addMenu("Tools");

        MyMenuItem section;
        section = top.addMenu("Tools");
        section.addMenu(MyDevUtilityPage.getInstance());
        section.addMenu(MyDevSqlPage.getInstance());
        section.addMenu(MyDevBeanShellPage.getInstance());
        section.addMenu(MyDevPerformanceLogPage.getInstance());
        section.addMenu(MyDevSharedFileBrowserPage.getInstance());
        section.addMenu(MyDevApplicationLogsPage.getInstance());
        section.addMenu(MyDevApplicationPropertiesPage.getInstance());
        section.addMenu(MyDevUsersPage.getInstance());
        section.addMenu(MyDevEmailsPage.getInstance());
        section.addMenu(MyDevHibernateCachePage.getInstance());
        section.addMenu(MyDevSystemPropertiesPage.getInstance());
        section.addMenu(MyDevEnvironmentVariablesPage.getInstance());
    }

    private void registerTests()
    {
        MyMenuItem top;
        top = getRoot().addMenu("Tests");

        MyMenuItem personal;
        personal = top.addMenu("Personal");
        personal.addMenu(MyWyattTestPage.getInstance());

        MyMenuItem layout;
        layout = top.addMenu("Layout");
        layout.addMenu(MyFlexboxTestPage.getInstance());
        layout.addMenu(MyAbsoluteLayoutTestPage.getInstance());
        layout.addMenu(MyAccordionTestPage.getInstance());
        layout.addMenu(MyBorderTestPage.getInstance());
        layout.addMenu(MyBlankTestPage.getInstance());
        layout.addMenu(MyEqualizeTestPage.getInstance());
        layout.addMenu(MyFormTestPage.getInstance());
        layout.addMenu(MyGroupIconHeaderTestPage.getInstance());
        layout.addMenu(MyGroupTestPage.getInstance());
        layout.addMenu(MyNotebookTestPage.getInstance());
        layout.addMenu(MyPaddingTestPage.getInstance());
        layout.addMenu(MyPlaceholderTestPage.getInstance());
        layout.addMenu(MyTabbedTestPage.getInstance());
        layout.addMenu(MyBorderLayoutTestPage.getInstance());
        layout.addMenu(MyTitlePanelTestPage.getInstance());
        layout.addMenu(MySplitterTestPage.getInstance());

        // fields
        MyMenuItem fields;
        fields = top.addMenu("Fields");
        fields.addMenu(MyFieldTestPage.getInstance());
        fields.addMenu(MyLocalValueTestPage.getInstance());
        fields.addMenu(MyDateFieldTestPage.getInstance());
        fields.addMenu(MyColorFieldTestPage.getInstance());
        fields.addMenu(MyAutoCompleteTestPage.getInstance());
        fields.addMenu(MyGoogleChartTestPage.getInstance());
        fields.addMenu(MyGridTestPage.getInstance());
        fields.addMenu(MyDropzoneTestPage.getInstance());
        fields.addMenu(MyRadioButtonTestPage.getInstance());
        fields.addMenu(MyDraggableMultiSelectTestPage.getInstance());

        // misc
        MyMenuItem misc;
        misc = top.addMenu("Misc");
        misc.addMenu(MyBlockTestPage.getInstance());
        misc.addMenu(MySlowTestPage.getInstance());
        misc.addMenu(MyToastTestPage.getInstance());
        misc.addMenu(MyAnimationTestPage.getInstance());
        misc.addMenu(MyHideErrorsTestPage.getInstance());
        misc.addMenu(MyOpenWindowTestPage.getInstance());
        misc.addMenu(MyDownloadTestPage.getInstance());
        misc.addMenu(MyDialogTestPage.getInstance());
        misc.addMenu(MyBarcodeTestPage.getInstance());
        misc.addMenu(MyGradientTestPage.getInstance());
        misc.addMenu(MyCardFlipTestPage.getInstance());
        misc.addMenu(MyNvd3ChartTestPage.getInstance());
        misc.addMenu(MyTimeAgoTestPage.getInstance());
        misc.addMenu(MyFilterTableRowTestPage.getInstance());
        misc.addMenu(MyDomainDropdownSetValueTestPage.getInstance());

        // tools
        MyMenuItem tools;
        tools = top.addMenu("Tools");
        tools.addMenu(MyScriptTestPage.getInstance());
        tools.addMenu(MyMemoryLeakTestPage.getInstance());
        tools.addMenu(MyGmailTestPage.getInstance());
        tools.addMenu(MySmtpTestPage.getInstance());
        tools.addMenu(MyStaticIncludeTestPage.getInstance());
        tools.addMenu(MyHoverTestPage.getInstance());
        tools.addMenu(MyDragTestPage.getInstance());
        tools.addMenu(MyFacebookTestPage.getInstance());
        tools.addMenu(MySharedStateTest1Page.getInstance());
        tools.addMenu(MyNavigationTest1Page.getInstance());
    }

    private KmList<ScPage> getIgnoredPages()
    {
        KmList<ScPage> v;
        v = new KmList<>();
        v.add(MySignInPage.getInstance());
        v.add(MySignOutPage.getInstance());
        v.add(MyPasswordResetPage.getInstance());
        v.add(MyUserProfilePage.getInstance());
        v.add(MyUserActivationPage.getInstance());
        v.add(MyTimeoutPage.getInstance());
        v.add(MySharedStateTest2Page.getInstance());
        v.add(MyNavigationTest2Page.getInstance());
        return v;
    }

    private KmList<String> getIgnoredPageKeys()
    {
        KmList<String> v = new KmList<>();

        for ( ScPage e : getIgnoredPages() )
            v.add(e.getKey());

        return v;
    }

    //##################################################
    //# validate
    //##################################################

    protected void validate()
    {
        validateItems();
        validateDuplicatePages();
        validateMissingPages();
        validateIngoredPages();
    }

    private void validateItems()
    {
        validateItems(getRoot());
    }

    private void validateItems(MyMenuItem p)
    {
        validateItem(p);

        for ( MyMenuItem e : p.getSubMenus() )
            validateItems(e);
    }

    private void validateItem(MyMenuItem e)
    {
        if ( e.isRoot() )
            return;

        if ( !e.hasTitle() )
            warn("Menu with no title");

        int depth = e.getDepth();

        if ( depth == 1 )
            validateTop(e);

        if ( depth == 2 )
            validateLeftSection(e);

        if ( depth == 3 )
            validateLeftItem(e);

        if ( depth > 3 )
            warn("Menu %s exceeds maximum depth.", e.getTitle());
    }

    private void validateTop(MyMenuItem e)
    {
        if ( !e.hasPages() && !e.hasSubMenus() )
            warn("Top Menu [%s] must have either a page or sub menu.", e.getTitle());

        if ( e.hasPages() && e.hasSubMenus() )
            warn("Top Menu %s cannot have both a page and sub menu.", e.getTitle());
    }

    private void validateLeftSection(MyMenuItem e)
    {
        if ( e.hasPages() )
            warn("Left menu section [%s] cannot link directly to pages.", e.getTitle());

        if ( e.isLeaf() )
            warn("Left menu section [%s] must contain sub menus.", e.getTitle());
    }

    private void validateLeftItem(MyMenuItem e)
    {
        if ( !e.hasPages() )
            warn("Left menu item [%s] link to at least one page.", e.getTitle());
    }

    private void validateDuplicatePages()
    {
        KmList<String> dups = getMenuPageKeys().getDuplicates();
        if ( dups.isNotEmpty() )
            KmLog.warnTrace("You cannot assign a page to multiple menus: %s.", dups.join());
    }

    private void validateMissingPages()
    {
        KmList<String> missing;
        missing = getAllPageKeys().getShallowCopy();
        missing.removeAll(getMenuPageKeys());
        missing.removeAll(getIgnoredPageKeys());

        if ( missing.isNotEmpty() )
            KmLog.warnTrace(
                "The following pages are not linked to the menu registry: %s.",
                missing.join());
    }

    private void validateIngoredPages()
    {
        KmList<String> menuPages = getMenuPageKeys();
        KmList<String> ignoredPages = getIgnoredPageKeys();

        KmList<String> v;
        v = new KmList<>();
        v.addAll(menuPages);
        v.addAll(ignoredPages);

        KmList<String> dups = v.getDuplicates();
        if ( dups.isNotEmpty() )
            warn(
                "Menu registry, the following pages are both used and also 'ignored': %s.",
                dups.join());
    }

    //##################################################
    //# lookup
    //##################################################

    public MyMenuItem findTopMenuFor(ScPage e)
    {
        MyMenuItem m = findMenuFor(e);

        if ( m == null )
            return null;

        if ( m.isRoot() )
            return null;

        while ( !m.isTop() )
            m = m.getParent();

        return m;
    }

    public MyMenuItem findMenuFor(ScPage e)
    {
        return findMenuFor(e.getKey());
    }

    public MyMenuItem findMenuFor(String pageKey)
    {
        return _pageToMenuMap.get(pageKey);
    }

    private void initLookup()
    {
        _pageToMenuMap = new KmMap<>();

        initLookup(getRoot());
    }

    private void initLookup(MyMenuItem menu)
    {
        KmList<String> keys = menu.getPageKeys();
        for ( String key : keys )
            _pageToMenuMap.put(key, menu);

        KmList<MyMenuItem> children = menu.getSubMenus();
        for ( MyMenuItem child : children )
            initLookup(child);
    }

    //##################################################
    //# accessing
    //##################################################

    public MyMenuItem getRoot()
    {
        return _root;
    }

    //##################################################
    //# support
    //##################################################

    private KmList<String> getMenuPageKeys()
    {
        return getRoot().collectPageKeys();
    }

    private KmList<String> getAllPageKeys()
    {
        return MyPageRegistry.getInstance().getPageKeys();
    }

    private void warn(String msg, Object... args)
    {
        KmLog.warnTrace(msg, args);
    }

}
