package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.control.ScControl;
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
import com.app.ui.page.admin.userProfile.MyUserProfilePage;
import com.app.ui.page.general.MySignOutPage;
import com.app.ui.servlet.MyServletConstantsIF;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

public class MyPageLayout
    implements MyServletConstantsIF
{
    //##################################################
    //# constants (border)
    //##################################################

    public static final String  CENTER_ID             = "pageLayoutCenter";
    public static final String  CENTER_SELECTOR       = "#" + CENTER_ID;

    private static final String TOP_ID                = "pageLayoutTop";
    private static final String TOP_SELECTOR          = "#" + TOP_ID;

    private static final String BOTTOM_ID             = "pageLayoutBottom";
    private static final String BOTTOM_SELECTOR       = "#" + BOTTOM_ID;

    private static final String FOOTER_ID             = "pageFooter";
    private static final String FOOTER_SELECTOR       = "#" + FOOTER_ID;

    private static final String LEFT_ID               = "pageLayoutLeft";
    private static final String LEFT_SELECTOR         = "#" + LEFT_ID;

    private static final String RIGHT_ID              = "pageLayoutRight";
    private static final String RIGHT_SELECTOR        = "#" + RIGHT_ID;

    //##################################################
    //# constants (header)
    //##################################################

    private static final String HEADER_LEFT_ID        = "pageHeaderLeft";
    private static final String HEADER_LEFT_SELECTOR  = "#" + HEADER_LEFT_ID;

    private static final String HEADER_RIGHT_ID       = "pageHeaderRight";
    private static final String HEADER_RIGHT_SELECTOR = "#" + HEADER_RIGHT_ID;

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

    private ScDiv          _topRightDiv;

    private MyLeftMenu     _leftMenu;
    private ScDropdownMenu _userMenu;
    private ScDropdownMenu _accountMenu;
    private ScActionIF     _selectAccountAction;
    private ScActionIF     _manageAccountsAction;

    //##################################################
    //# constructor
    //##################################################

    public MyPageLayout()
    {
        installLeftMenu();
        installSelectAccountAction();
        installAccountMenu();
        installUserMenu();
        installTopRightDiv();
    }

    //==================================================
    //= install :: left menu
    //==================================================

    private void installLeftMenu()
    {
        _leftMenu = new MyLeftMenu();
    }

    public void showLeftMenu(boolean show)
    {
        if ( show )
        {
            ajaxRefreshLeftMenu();
            ajaxShowLeft();
        }
        else
            ajaxHideLeft();
    }

    //==================================================
    //= install :: user menu
    //==================================================

    private void installUserMenu()
    {
        _userMenu = new ScDropdownMenu();
        _userMenu.setTitle("User");
        _userMenu.hide();
        _userMenu.addItem("Profile", newEditUserProfileAction());
        _userMenu.addItem("Log out", newLogoutAction());
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
        MyUserProfilePage.instance.start();
    }

    private void handleLogout()
    {
        MySignOutPage.instance.start();
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

    // todo_wyatt: header navigation
    private void handleSelectAccount()
    {
        String uid = getData().getStringArgument();

        ajax().toast("select account: " + uid);
        // MyNavigation.selectAccount(uid);
    }

    //==================================================
    //= install :: account menu
    //==================================================

    private void installAccountMenu()
    {
        _manageAccountsAction = newManageAccountsAction();

        _accountMenu = new ScDropdownMenu();
        _accountMenu.setTitle("Account");
        _accountMenu.hide();
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
        // todo_wyatt: left menu navigation
        // MyAllAccountsPage.instance.start();
        ajax().toast("accounts");
    }

    //##################################################
    //# install :: top right
    //##################################################

    private void installTopRightDiv()
    {
        _userMenu.css().floatRight().marginLeft();
        _accountMenu.css().floatRight();

        _topRightDiv = new ScDiv();
        _topRightDiv.css().pad3();
        _topRightDiv.add(_userMenu);
        _topRightDiv.add(_accountMenu);
    }

    //##################################################
    //# header
    //##################################################

    public void ajaxCreateLayout()
    {
        KmJsonMap json;
        json = new KmJsonMap();

        json.setString("parent", "body");
        json.setString("idPrefix", "pageLayout");
        json.setString("classPrefix", "pageLayout");

        json.setBoolean("liveResize", true);
        json.setBoolean("debugBorders", false);

        json.setBoolean("topVisible", true);
        json.setBoolean("topResizable", false);
        json.setInteger("topSize", 50);
        // show overflow for menus
        json.setString("topOverflow", "visible");

        json.setBoolean("bottomVisible", true);
        json.setBoolean("bottomResizable", false);
        json.setInteger("bottomSize", 25);

        json.setBoolean("leftVisible", false);
        json.setBoolean("leftResizable", false);
        json.setInteger("leftSize", 150);

        json.setBoolean("rightVisible", false);
        json.setBoolean("rightResizable", false);
        json.setInteger("rightSize", 200);

        json.setString("centerOverflow", "auto");

        ajax().run("new KmBorderLayout(%s);", json);

        ajax().addDivIdTo(TOP_SELECTOR, HEADER_LEFT_ID);
        ajax().addDivIdTo(TOP_SELECTOR, HEADER_RIGHT_ID);

        ajax().addDivIdTo(BOTTOM_SELECTOR, FOOTER_ID);
        ajax().addCss(FOOTER_SELECTOR, FOOTER_ID);

        ajax().setContents(HEADER_RIGHT_SELECTOR, _topRightDiv);
    }

    //##################################################
    //# footer
    //##################################################

    public void ajaxRefreshFooter()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.beginSpan();
        out.printLiteral(MyConstantsIF.COPYRIGHT_HTML);
        out.endSpan();

        ajax().setContents(FOOTER_SELECTOR, out);
    }

    //##################################################
    //# left menu
    //##################################################

    public MyLeftMenu getLeftMenu()
    {
        return _leftMenu;
    }

    public void ajaxRefreshLeftMenu()
    {
        getLeftMenu().ajaxRefreshMenu();
    }

    public void gotoDefaultPage()
    {
        getLeftMenu().gotoDefault();
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

    public void ajaxShowLeft()
    {
        ajax().run("$('body').data('borderLayout').showSide('left');");
    }

    public void ajaxHideLeft()
    {
        ajax().run("$('body').data('borderLayout').hideSide('left');");
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

    public void ajaxShowRight()
    {
        ajax().run("$('body').data('borderLayout').showSide('right');");
    }

    public void ajaxHideRight()
    {
        ajax().run("$('body').data('borderLayout').hideSide('right');");
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
    //# refresh
    //##################################################

    public void ajaxRefresh()
    {
        ajaxRefreshHeader();
        ajaxRefreshFooter();
        ajaxRefreshLeftMenu();

    }

    public void ajaxRefreshHeader()
    {
        ajaxRefreshHeaderLogo();
        ajaxRefreshUserMenu();
        ajaxRefreshAccountMenu();
    }

    //==================================================
    //= refresh :: logo
    //==================================================

    private void ajaxRefreshHeaderLogo()
    {
        ajax().setContents(HEADER_LEFT_SELECTOR, renderHeaderLogo());
    }

    private KmHtmlBuilder renderHeaderLogo()
    {
        String url = MyUrls.getEntryUrl();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.open("a");
        out.printAttribute("id", "pageHeaderLink");
        out.printAttribute("href", url);
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
        return out;
    }

    //==================================================
    //= refresh :: user
    //==================================================

    private void ajaxRefreshUserMenu()
    {
        MyUser u = getCurrentUser();

        if ( u == null )
        {
            _userMenu.ajax().hide();
            return;
        }

        _userMenu.show();
        _userMenu.setTitle(u.getName());
        _userMenu.ajax().replace();
    }

    //==================================================
    //= refresh :: account
    //==================================================

    private void ajaxRefreshAccountMenu()
    {
        MyAccount a = getCurrentAccount();

        if ( a == null )
        {
            _accountMenu.ajax().hide();
            return;
        }

        _accountMenu.show();
        _accountMenu.setTitle(a.getName());
        _accountMenu.clearItems();

        KmList<MyAccount> v = getAccountOptions();
        for ( MyAccount e : v )
            _accountMenu.addItem(e.getName(), getSelectAccountAction(), e.getUid());

        _accountMenu.addItem("Manage Accounts", getManageAccountsAction());
        _accountMenu.ajax().replace();
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
