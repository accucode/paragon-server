package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.control.ScControl;
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
import com.app.ui.page.admin.accounts.MyAccountsPage;
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

    public static final String  CENTER_ID       = "pageLayoutCenter";
    public static final String  CENTER_SELECTOR = "#" + CENTER_ID;

    private static final String TOP_ID          = "pageLayoutTop";
    private static final String TOP_SELECTOR    = "#" + TOP_ID;

    private static final String BOTTOM_ID       = "pageLayoutBottom";
    private static final String BOTTOM_SELECTOR = "#" + BOTTOM_ID;

    private static final String LEFT_ID         = "pageLayoutLeft";
    private static final String LEFT_SELECTOR   = "#" + LEFT_ID;

    private static final String RIGHT_ID        = "pageLayoutRight";
    private static final String RIGHT_SELECTOR  = "#" + RIGHT_ID;

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
        MyAccountsPage.instance.push();
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
    //# top
    //##################################################

    public void ajaxSetTopContents(KmHtmlBuilder out)
    {
        ajax().setContents(TOP_SELECTOR, out);
    }

    public void ajaxSetTopContents(ScControl e)
    {
        ajax().setContents(TOP_SELECTOR, e);
    }

    public void ajaxShowTop(ScControl e)
    {
        ajaxSetTopContents(e);
        ajaxShowTop();
    }

    public void ajaxShowTop(KmHtmlBuilder out)
    {
        ajaxSetTopContents(out);
        ajaxShowTop();
    }

    public void ajaxShowTop()
    {
        ajaxShowSide("top");
    }

    public void ajaxHideTop()
    {
        ajaxHideSide("top");
    }

    public void ajaxSetTopCss(String css)
    {
        ajax().setCss(TOP_SELECTOR, css);
    }

    //##################################################
    //# bottom
    //##################################################

    public void ajaxSetBottomContents(KmHtmlBuilder out)
    {
        ajax().setContents(BOTTOM_SELECTOR, out);
    }

    public void ajaxSetBottomContents(ScControl e)
    {
        ajax().setContents(BOTTOM_SELECTOR, e);
    }

    public void ajaxShowBottom(ScControl e)
    {
        ajaxSetBottomContents(e);
        ajaxShowBottom();
    }

    public void ajaxShowBottom(KmHtmlBuilder out)
    {
        ajaxSetBottomContents(out);
        ajaxShowBottom();
    }

    public void ajaxShowBottom()
    {
        ajaxShowSide("bottom");
    }

    public void ajaxHideBottom()
    {
        ajaxHideSide("bottom");
    }

    public void ajaxSetBottomCss(String css)
    {
        ajax().setCss(BOTTOM_SELECTOR, css);
    }

    //##################################################
    //# left
    //##################################################

    public void ajaxSetLeftContents(KmHtmlBuilder out)
    {
        ajax().setContents(LEFT_SELECTOR, out);
    }

    public void ajaxSetLeftContents(ScControl e)
    {
        ajax().setContents(LEFT_SELECTOR, e);
    }

    public void ajaxShowLeft(ScControl e)
    {
        ajaxSetLeftContents(e);
        ajaxShowLeft();
    }

    public void ajaxShowLeft(KmHtmlBuilder out)
    {
        ajaxSetLeftContents(out);
        ajaxShowLeft();
    }

    public void ajaxShowLeft()
    {
        ajaxShowSide("left");
    }

    public void ajaxHideLeft()
    {
        ajaxHideSide("left");
    }

    public void ajaxSetLeftCss(String css)
    {
        ajax().setCss(LEFT_SELECTOR, css);
    }

    //##################################################
    //# right
    //##################################################

    public void ajaxSetRightContents(KmHtmlBuilder out)
    {
        ajax().setContents(RIGHT_SELECTOR, out);
    }

    public void ajaxSetRightContents(ScControl e)
    {
        ajax().setContents(RIGHT_SELECTOR, e);
    }

    public void ajaxShowRight(ScControl e)
    {
        ajaxSetRightContents(e);
        ajaxShowRight();
    }

    public void ajaxShowRight(KmHtmlBuilder out)
    {
        ajaxSetRightContents(out);
        ajaxShowRight();
    }

    public void ajaxShowRight()
    {
        ajaxShowSide("right");
    }

    public void ajaxHideRight()
    {
        ajaxHideSide("right");
    }

    public void ajaxSetRightCss(String css)
    {
        ajax().setCss(RIGHT_SELECTOR, css);
    }

    //##################################################
    //# center
    //##################################################

    public void ajaxSetCenter(ScControl e)
    {
        KmHtmlBuilder out = e == null
            ? null
            : e.render();

        ajaxSetCenter(out);
    }

    public void ajaxSetCenter(KmHtmlBuilder out)
    {
        ajax().setContents(CENTER_SELECTOR, out);
    }

    public void ajaxClearCenter()
    {
        ajax().clearMain();
    }

    public void ajaxSetCenterCss(String css)
    {
        ajax().setCss(CENTER_SELECTOR, css);
    }

    public void ajaxClearCenterCss()
    {
        ajax().clearCss(CENTER_SELECTOR);
    }

    //##################################################
    //# show
    //##################################################

    private void ajaxShowSide(String side)
    {
        ajax().run("$('body').data('borderLayout').showSide('%s');", side);
    }

    private void ajaxHideSide(String side)
    {
        ajax().run("$('body').data('borderLayout').hideSide('%s');", side);
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

    public void ajaxShowHeader(boolean show)
    {
        if ( show )
        {
            ajaxRefreshHeader();
            ajaxShowTop();
        }
        else
            ajaxHideTop();
    }

    private void ajaxRefreshHeader()
    {
        ajaxSetTopCss(KmCssDefaultConstantsIF.pageHeader);
        ajaxSetTopContents(renderHeader());
    }

    private KmHtmlBuilder renderHeader()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderLogoOn(out);
        renderUserDropdownOn(out);
        renderAccountDropdownsOn(out);

        return out;
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

    public void ajaxShowFooter(boolean show)
    {
        if ( show )
        {
            ajaxRefreshFooter();
            ajaxShowBottom();
        }
        else
            ajaxHideBottom();
    }

    private void ajaxRefreshFooter()
    {
        ajaxSetBottomCss(KmCssDefaultConstantsIF.pageFooter);
        ajaxSetBottomContents(renderFooter());
    }

    private KmHtmlBuilder renderFooter()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        out.beginSpan();
        out.printLiteral(MyConstantsIF.COPYRIGHT_HTML);
        out.endSpan();

        return out;
    }

    //==================================================
    //= refresh :: left menu
    //==================================================

    public void ajaxShowLeftMenu(boolean show)
    {
        if ( show )
        {
            ajaxRefreshLeftMenu();
            ajaxShowLeft();
        }
        else
        {
            ajaxClearCenterCss();
            ajaxHideLeft();
        }
    }

    private void ajaxRefreshLeftMenu()
    {
        MyLeftMenu menu = getLeftMenu();

        ajaxSetCenterCss(menu.getContentCss());
        ajaxSetLeftContents(menu.render());
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
