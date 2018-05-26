//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.ui.servlet.base;

import com.kodemore.servlet.*;

import com.app.ui.dashboard.core.*;
import com.app.ui.page.crud.appFeedback.*;
import com.app.ui.page.crud.blurb.*;
import com.app.ui.page.crud.customer.*;
import com.app.ui.page.crud.emailTemplate.*;
import com.app.ui.page.crud.holiday.*;
import com.app.ui.page.crud.member.*;
import com.app.ui.page.crud.priority.*;
import com.app.ui.page.crud.project.*;
import com.app.ui.page.crud.projectOption.*;
import com.app.ui.page.crud.projectVendor.*;
import com.app.ui.page.crud.site.*;
import com.app.ui.page.crud.tenant.*;
import com.app.ui.page.crud.user.*;
import com.app.ui.page.general.*;
import com.app.ui.page.guide.*;
import com.app.ui.page.importer.*;
import com.app.ui.page.login.*;
import com.app.ui.page.menu.*;
import com.app.ui.page.report.*;
import com.app.ui.page.test.*;
import com.app.ui.page.tools.*;

public abstract class MyPageRegistryBase
    extends ScPageRegistry
{
    @Override
    protected void registerPages()
    {
        super.registerPages();

        MyAuditBundleReportPage.installInstance();
        MyBlankTestPage.installInstance();
        MyBlurbListPage.installInstance();
        MyBlurbSetupGuidePage.installInstance();
        MyCustomerListPage.installInstance();
        MyCustomerSetupGuidePage.installInstance();
        MyDashboardPage.installInstance();
        MyDevApplicationLogsPage.installInstance();
        MyDevApplicationPropertiesPage.installInstance();
        MyDevBeanShellPage.installInstance();
        MyDevDataFixPage.installInstance();
        MyDevEmailsPage.installInstance();
        MyDevEnvironmentVariablesPage.installInstance();
        MyDevPerformanceLogDetailPage.installInstance();
        MyDevPerformanceLogSummaryPage.installInstance();
        MyDevRenameMacroPage.installInstance();
        MyDevSharedFileBrowserPage.installInstance();
        MyDevSqlPage.installInstance();
        MyDevSystemPropertiesPage.installInstance();
        MyDevUtilityPage.installInstance();
        MyEmailTemplateListPage.installInstance();
        MyEmailTemplateSetupGuidePage.installInstance();
        MyFeedbackListPage.installInstance();
        MyHibernateCacheTestPage.installInstance();
        MyHolidayListPage.installInstance();
        MyLoginPage.installInstance();
        MyLogoutPage.installInstance();
        MyMemberListPage.installInstance();
        MyMemberSetupGuidePage.installInstance();
        MyNoteReportPage.installInstance();
        MyPasswordResetPage.installInstance();
        MyPriorityListPage.installInstance();
        MyProjectCalendarPage.installInstance();
        MyProjectDataMenuPage.installInstance();
        MyProjectDetailsSetupGuidePage.installInstance();
        MyProjectListPage.installInstance();
        MyProjectPage.installInstance();
        MyProjectReportsMenuPage.installInstance();
        MyProjectSetupHomePage.installInstance();
        MyProjectSetupMenuPage.installInstance();
        MyProjectSummaryReportPage.installInstance();
        MyProxyPage.installInstance();
        MySiteGuidePage.installInstance();
        MySiteImporterPage.installInstance();
        MySiteListPage.installInstance();
        MySiteReportPage.installInstance();
        MySiteSetupGuidePage.installInstance();
        MySiteTypeListPage.installInstance();
        MySystemSetupMenuPage.installInstance();
        MyTenantListPage.installInstance();
        MyTenantSetupMenuPage.installInstance();
        MyTestMenuPage.installInstance();
        MyTimeoutPage.installInstance();
        MyUserActivationPage.installInstance();
        MyUserListPage.installInstance();
        MyVendorListPage.installInstance();
        MyWyattTestPage.installInstance();

        add(MyAuditBundleReportPage.getInstance());
        add(MyBlankTestPage.getInstance());
        add(MyBlurbListPage.getInstance());
        add(MyBlurbSetupGuidePage.getInstance());
        add(MyCustomerListPage.getInstance());
        add(MyCustomerSetupGuidePage.getInstance());
        add(MyDashboardPage.getInstance());
        add(MyDevApplicationLogsPage.getInstance());
        add(MyDevApplicationPropertiesPage.getInstance());
        add(MyDevBeanShellPage.getInstance());
        add(MyDevDataFixPage.getInstance());
        add(MyDevEmailsPage.getInstance());
        add(MyDevEnvironmentVariablesPage.getInstance());
        add(MyDevPerformanceLogDetailPage.getInstance());
        add(MyDevPerformanceLogSummaryPage.getInstance());
        add(MyDevRenameMacroPage.getInstance());
        add(MyDevSharedFileBrowserPage.getInstance());
        add(MyDevSqlPage.getInstance());
        add(MyDevSystemPropertiesPage.getInstance());
        add(MyDevUtilityPage.getInstance());
        add(MyEmailTemplateListPage.getInstance());
        add(MyEmailTemplateSetupGuidePage.getInstance());
        add(MyFeedbackListPage.getInstance());
        add(MyHibernateCacheTestPage.getInstance());
        add(MyHolidayListPage.getInstance());
        add(MyLoginPage.getInstance());
        add(MyLogoutPage.getInstance());
        add(MyMemberListPage.getInstance());
        add(MyMemberSetupGuidePage.getInstance());
        add(MyNoteReportPage.getInstance());
        add(MyPasswordResetPage.getInstance());
        add(MyPriorityListPage.getInstance());
        add(MyProjectCalendarPage.getInstance());
        add(MyProjectDataMenuPage.getInstance());
        add(MyProjectDetailsSetupGuidePage.getInstance());
        add(MyProjectListPage.getInstance());
        add(MyProjectPage.getInstance());
        add(MyProjectReportsMenuPage.getInstance());
        add(MyProjectSetupHomePage.getInstance());
        add(MyProjectSetupMenuPage.getInstance());
        add(MyProjectSummaryReportPage.getInstance());
        add(MyProxyPage.getInstance());
        add(MySiteGuidePage.getInstance());
        add(MySiteImporterPage.getInstance());
        add(MySiteListPage.getInstance());
        add(MySiteReportPage.getInstance());
        add(MySiteSetupGuidePage.getInstance());
        add(MySiteTypeListPage.getInstance());
        add(MySystemSetupMenuPage.getInstance());
        add(MyTenantListPage.getInstance());
        add(MyTenantSetupMenuPage.getInstance());
        add(MyTestMenuPage.getInstance());
        add(MyTimeoutPage.getInstance());
        add(MyUserActivationPage.getInstance());
        add(MyUserListPage.getInstance());
        add(MyVendorListPage.getInstance());
        add(MyWyattTestPage.getInstance());
    }
}
