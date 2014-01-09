package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScDropdownMenu;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyPageSession;
import com.app.ui.core.MyServletData;
import com.app.ui.page.admin.MySelectAccountPage;
import com.app.ui.page.admin.userProfile.MyUserProfilePage;
import com.app.ui.page.general.MySignOutPage;
import com.app.ui.page.login.MySignInUtility;
import com.app.ui.servlet.MyServletConstantsIF;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyNavigator;
import com.app.utility.MyUrls;

public class MyPageLayout
    implements MyServletConstantsIF
{
    //##################################################
    //# constants (border)
    //##################################################

    private static final String CONTENT_ID               = "pageContent";
    public static final String  CONTENT_SELECTOR         = "#" + CONTENT_ID;

    private static final String CONTENT_WRAPPER_ID       = "pageContentWrapper";
    private static final String CONTENT_WRAPPER_SELECTOR = "#" + CONTENT_WRAPPER_ID;

    private static final String HEADER_ID                = "pageHeader";
    private static final String HEADER_SELECTOR          = "#" + HEADER_ID;

    private static final String FOOTER_ID                = "pageFooter";
    private static final String FOOTER_SELECTOR          = "#" + FOOTER_ID;

    private static final String MENU_ID                  = "pageMenu";
    private static final String MENU_SELECTOR            = "#" + MENU_ID;

    //##################################################
    //# install
    //##################################################

    private static MyPageLayout _instance;

    public static void install()
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = new MyPageLayout();
    }

    public static MyPageLayout getInstance()
    {
        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private MyLeftMenu     _leftMenu;
    private ScDropdownMenu _userDropdown;
    private ScDropdownMenu _accountDropdown;
    private ScActionIF     _selectAccountAction;
    private ScActionIF     _manageAccountsAction;

    //##################################################
    //# constructor
    //##################################################

    public MyPageLayout()
    {
        installLeftMenu();
        installSelectAccountAction();
        installUserDropdown();
        installAccountDropdown();
    }

    //==================================================
    //= install :: left menu
    //==================================================

    private void installLeftMenu()
    {
        _leftMenu = new MyLeftMenu();
    }

    //==================================================
    //= install :: user dropdown
    //==================================================

    private void installUserDropdown()
    {
        _userDropdown = new ScDropdownMenu();
        _userDropdown.setTitle("User");
        _userDropdown.addItem("Profile", newEditUserProfileAction());
        _userDropdown.addItem("Log out", newLogoutAction());
        _userDropdown.css().floatRight().margin5();
    }

    private ScActionIF newEditUserProfileAction()
    {
        ScActionContextIF context = ScGlobalContext.getInstance();
        return new ScAction(context)
        {
            @Override
            public void handle()
            {
                handleEditUserProfile();
            }
        };
    }

    private ScActionIF newLogoutAction()
    {
        ScActionContextIF context = ScGlobalContext.getInstance();
        return new ScAction(context)
        {
            @Override
            public void handle()
            {
                handleLogout();
            }
        };
    }

    private void handleEditUserProfile()
    {
        MyUserProfilePage.instance.push();
    }

    private void handleLogout()
    {
        MySignInUtility.signOut();
        ajaxRefresh();
        ajaxClearContent();
        MySignOutPage.instance.push();
    }

    //==================================================
    //= install :: account dropdown
    //==================================================

    private void installAccountDropdown()
    {
        _manageAccountsAction = newManageAccountsAction();

        _accountDropdown = new ScDropdownMenu();
        _accountDropdown.setTitle("Account");
        _accountDropdown.css().floatRight().margin5();
    }

    private ScActionIF getManageAccountsAction()
    {
        return _manageAccountsAction;
    }

    private ScActionIF newManageAccountsAction()
    {
        ScActionContextIF context = ScGlobalContext.getInstance();
        return new ScAction(context)
        {
            @Override
            public void handle()
            {
                handleManageAccounts();
            }
        };
    }

    private void handleManageAccounts()
    {
        MySelectAccountPage.instance.push();
    }

    //==================================================
    //= install :: select account
    //==================================================

    private void installSelectAccountAction()
    {
        _selectAccountAction = newSelectAccountAction();
    }

    private ScActionIF getSelectAccountAction()
    {
        return _selectAccountAction;
    }

    private ScActionIF newSelectAccountAction()
    {
        ScActionContextIF context = ScGlobalContext.getInstance();
        return new ScAction(context)
        {
            @Override
            public void handle()
            {
                handleSelectAccount();
            }
        };
    }

    private void handleSelectAccount()
    {
        String uid = getData().getStringArgument();
        MyNavigator.selectAccount(uid);
    }

    //##################################################
    //# accessing
    //##################################################

    public MyLeftMenu getLeftMenu()
    {
        return _leftMenu;
    }

    //##################################################
    //# refresh
    //##################################################

    public void ajaxRefresh()
    {
        ajaxRefreshHeader();
        ajaxRefreshFooter();
        ajaxRefreshLeftMenu();
    }

    //==================================================
    //= refresh :: header
    //==================================================

    public void ajaxRefreshHeader()
    {
        boolean show = getData().isPageHeaderVisible();
        ajaxShowHeader(show);
    }

    public void ajaxShowHeader(boolean show)
    {
        if ( show )
            ajaxShowHeader();
        else
            ajaxHideHeader();
    }

    private void ajaxShowHeader()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderLogoOn(out);
        renderUserDropdownOn(out);
        renderAccountDropdownsOn(out);

        ajax().setContents(HEADER_SELECTOR, out);
        ajax().show(HEADER_SELECTOR);
    }

    private void ajaxHideHeader()
    {
        ajax().hide(HEADER_SELECTOR);
    }

    private void renderLogoOn(KmHtmlBuilder out)
    {
        out.open("a");
        out.printAttribute("id", "pageHeaderLink");
        out.printAttribute("href", MyUrls.getEntryUrl());
        out.close();

        out.open("img");
        out.printAttribute("id", "pageHeaderLogoImage");
        out.printAttribute("src", ScUrls.getThemeImage("logo35.png"));
        out.printAttribute("width", 35);
        out.printAttribute("height", 35);
        out.close();

        out.beginSpanId("pageHeaderLogoText");
        out.print(MyConstantsIF.APPLICATION_NAME);
        out.endSpan();

        out.end("a");
    }

    private void renderUserDropdownOn(KmHtmlBuilder out)
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return;

        _userDropdown.setTitle(u.getName());
        _userDropdown.renderOn(out);
    }

    private void renderAccountDropdownsOn(KmHtmlBuilder out)
    {
        MyAccount a = getCurrentAccount();
        if ( a == null )
            return;

        _accountDropdown.setTitle(a.getName());
        _accountDropdown.clearItems();

        KmList<MyAccount> v = getAccountOptions();
        for ( MyAccount e : v )
            _accountDropdown.addItem(e.getName(), getSelectAccountAction(), e.getUid());

        _accountDropdown.addItem("Manage Accounts", getManageAccountsAction());
        _accountDropdown.renderOn(out);
    }

    private KmList<MyAccount> getAccountOptions()
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return new KmList<MyAccount>();

        KmList<MyAccount> v;
        v = u.getAccounts().toList();
        v.sortOn(MyAccount.Meta.Name);
        return v;
    }

    //==================================================
    //= refresh :: footer
    //==================================================

    private void ajaxRefreshFooter()
    {
        boolean show = getData().isPageFooterVisible();
        ajaxShowFooter(show);
    }

    public void ajaxShowFooter(boolean show)
    {
        if ( show )
            ajaxShowFooter();
        else
            ajaxHideFooter();
    }

    private void ajaxShowFooter()
    {
        ScDiv footer;
        footer = new ScDiv();
        footer.css().pageFooterBox();
        footer.addHtml(MyConstantsIF.COPYRIGHT_HTML);

        ajax().setContents(FOOTER_SELECTOR, footer);
        ajax().show(FOOTER_SELECTOR);
    }

    private void ajaxHideFooter()
    {
        ajax().hide(FOOTER_SELECTOR);
    }

    //==================================================
    //= refresh :: left menu
    //==================================================

    public void ajaxRefreshLeftMenu()
    {
        boolean show = getData().isLeftMenuVisible();
        ajaxShowLeftMenu(show);
    }

    public void ajaxShowLeftMenu(boolean show)
    {
        if ( show )
            ajaxShowLeftMenu();
        else
            ajaxHideLeftMenu();
    }

    private void ajaxShowLeftMenu()
    {
        ajax().setCss(MENU_SELECTOR, KmCssDefaultConstantsIF.pageMenu_menu);
        ajax().setCss(CONTENT_WRAPPER_SELECTOR, KmCssDefaultConstantsIF.pageContentWrapper_menu);
        ajax().setContents(MENU_SELECTOR, getLeftMenu().render());
        ajax().show(MENU_SELECTOR);
    }

    private void ajaxHideLeftMenu()
    {
        ajax().setCss(MENU_SELECTOR, KmCssDefaultConstantsIF.pageMenu);
        ajax().setCss(CONTENT_WRAPPER_SELECTOR, KmCssDefaultConstantsIF.pageContent);
        ajax().clearContents(MENU_SELECTOR);
        ajax().hide(MENU_SELECTOR);
    }

    //##################################################
    //# content
    //##################################################

    public void ajaxClearContent()
    {
        ajax().clearContents(CONTENT_SELECTOR);
    }

    //##################################################
    //# support 
    //##################################################

    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    private ScRootScript ajax()
    {
        return getData().ajax();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private MyPageSession getPageSession()
    {
        return MyGlobals.getPageSession();
    }

    private MyUser getCurrentUser()
    {
        return MyGlobals.getServerSession().getUser();
    }

    private MyAccount getCurrentAccount()
    {
        return getPageSession().getCurrentAccount();
    }

}
