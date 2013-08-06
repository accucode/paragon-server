//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.ui.servlet.base;

import com.kodemore.servlet.*;

import com.app.ui.activity.admin.*;
import com.app.ui.activity.general.*;
import com.app.ui.activity.login.*;
import com.app.ui.activity.test.*;
import com.app.ui.activity.tools.*;
import com.app.ui.activity.user.*;

public abstract class MyActivityRegistryBase
    extends ScActivityRegistry
{
    @Override
    protected void registerActivities()
    {
        super.registerActivities();
        
        add(MyAccountTestPage.instance);
        add(MyAccountUserTestPage.instance);
        add(MyAdminPage.instance);
        add(MyAnimationTestPage.instance);
        add(MyAutoCompleteTestPage.instance);
        add(MyBarcodeTestPage.instance);
        add(MyBeanShellPage.instance);
        add(MyBlankTestPage.instance);
        add(MyBlockTestPage.instance);
        add(MyColorFieldTestPage.instance);
        add(MyDateFieldTestPage.instance);
        add(MyDomainDropdownSetValueTestPage.instance);
        add(MyDownloadTestPage.instance);
        add(MyDropzoneTestPage.instance);
        add(MyEmailEditPage.instance);
        add(MyEmailListPage.instance);
        add(MyEmailViewPage.instance);
        add(MyEqualizeTestPage.instance);
        add(MyFieldTestPage.instance);
        add(MyFilterTableRowTestPage.instance);
        add(MyFormTestPage.instance);
        add(MyGmailTestPage.instance);
        add(MyGoogleChartTestPage.instance);
        add(MyGradientTestPage.instance);
        add(MyGridTestPage.instance);
        add(MyGroupIconHeaderTestPage.instance);
        add(MyGroupTestPage.instance);
        add(MyHandleInvitationActivity.instance);
        add(MyHandlePasswordResetActivity.instance);
        add(MyHideErrorsTestPage.instance);
        add(MyHomePage.instance);
        add(MyLocalValueTestPage.instance);
        add(MyManageAccountsPage.instance);
        add(MyMemoryLeakTestPage.instance);
        add(MyNotebookTestPage.instance);
        add(MyOpenWindowTestPage.instance);
        add(MyPerformanceLogPage.instance);
        add(MyPlaceholderTestPage.instance);
        add(MyPropertiesPage.instance);
        add(MyQuickTestPage.instance);
        add(MyScriptTestPage.instance);
        add(MySharedFileBrowserPage.instance);
        add(MyShowDialogTestPage.instance);
        add(MySignInActivity.instance);
        add(MySignOutPage.instance);
        add(MySlowTestPage.instance);
        add(MySqlPage.instance);
        add(MyStaticIncludeTestPage.instance);
        add(MySystemLogListPage.instance);
        add(MyTabManagerTestPage.instance);
        add(MyTestPage.instance);
        add(MyTimeoutPage.instance);
        add(MyToastTestPage.instance);
        add(MyToolsPage.instance);
        add(MyUserPasswordPage.instance);
        add(MyUserSettingsPage.instance);
        add(MyUsersPage.instance);
        add(MyUtilityPage.instance);
        add(MyWelcomePage.instance);
    }
}
