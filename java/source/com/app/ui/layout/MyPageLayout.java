package com.app.ui.layout;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.control.ScActivityLink;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.activity.general.MyHomePage;
import com.app.ui.activity.general.MySignOutPage;
import com.app.ui.core.MyServletData;
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
    private ScDropdown     _dropdown;
    private ScActivityLink _link;

    private ScBox          _userNameLabel;
    private ScBox          _hiLabel;
    private ScBox          _accountLabel;
    private ScBox          _singleAccountName;

    //##################################################
    //# constructor
    //##################################################

    public MyPageLayout()
    {
        installTopRightDiv();
    }

    //##################################################
    //# install
    //##################################################

    //==================================================
    //= install :: menu
    //==================================================

    private void installMenu()
    {
        _link = new ScActivityLink();
        _link.hide();
        _link.setText("Logout");
        _link.css().bold();
        _link.setActivity(MySignOutPage.instance);

        _hiLabel = new ScBox();
        _hiLabel.css().label();
        _hiLabel.hide();

        _userNameLabel = new ScBox();
        _userNameLabel.css().label();

        _accountLabel = new ScBox();
        _accountLabel.css().label();
        _accountLabel.hide();

        _singleAccountName = new ScBox();
        _singleAccountName.css().label();
        _singleAccountName.hide();
    }

    //==================================================
    //= install :: dropdown
    //==================================================

    private void installDropdown()
    {
        _dropdown = new ScDropdown();
        _dropdown.hide();
        _dropdown.setOnChangeAction(newSetAccountAction());
    }

    private KmList<ScOption> getDropdownList()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return null;

        KmList<ScOption> list;
        list = new KmList<ScOption>();

        KmCollection<MyAccountUser> accountUsers;
        accountUsers = u.getAccountUsers();

        for ( MyAccountUser e : accountUsers )
        {
            MyAccount account = e.getAccount();
            buildOptionsList(list, account);
        }
        return list;
    }

    private void buildOptionsList(KmList<ScOption> list, MyAccount account)
    {
        if ( account != null )
        {
            ScOption option;
            option = new ScOption();
            option.setText(account.getName());
            option.setValue(account.getUid());

            list.add(option);
        }
    }

    private ScActionIF newSetAccountAction()
    {
        ScActionContextIF context = ScGlobalContext.getInstance();
        return new ScAction(context)
        {
            @Override
            public void handle()
            {
                handleSetAccount();
            }
        };
    }

    private void handleSetAccount()
    {
        setServerSessionAccount();
        MyHomePage.instance.start();
        MyLeftMenu.getInstance().gotoDefault();
    }

    private void setServerSessionAccount()
    {
        String uid = _dropdown.getStringValue();

       
        if ( !_dropdown.hasValue() )
            uid = getDropdownList().getFirst().getValue().toString();

        MyAccount e = getAccess().findAccountUid(uid);
        MyGlobals.getServerSession().setAccount(e);
    }

    //==================================================
    //= install :: top right div
    //==================================================

    private void installTopRightDiv()
    {
        installMenu();
        installDropdown();

        _topRightDiv = new ScDiv();
        _topRightDiv.css().pad10();

        ScForm form = _topRightDiv.addForm();
        ScArray row = form.addRow();
        row.add(_hiLabel);
        row.add(_userNameLabel);
        row.addSpaces(3);
        row.add(_accountLabel);
        row.add(_singleAccountName);
        row.add(_dropdown);
        row.addSpaces(3);
        row.add(_link);
    }

    //##################################################
    //# header
    //##################################################

    public void ajaxCreateLayout()
    {
        KmJsonObject json;
        json = new KmJsonObject();

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
        json.setInteger("leftSize", 100);

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

    public void ajaxRefreshHeader()
    {
        printHeaderLogo();
        printHeaderLabels();
        printHeaderDropdown();
        printHeaderLink();
    }

    public void ajaxHideRightDiv()
    {
        printHeaderLogo();
        _topRightDiv.hide();
        _topRightDiv.ajax().replace();
    }

    private void printHeaderLogo()
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
        out.close();

        out.beginSpanId("pageHeaderLogoText");
        out.print(MyConstantsIF.APPLICATION_NAME);
        out.endSpan();

        out.end("a");
        return out;
    }

    //==================================================
    //= header :: menu
    //==================================================

    private void printHeaderLink()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return;

        _link.ajax().show();
    }

    //==================================================
    //= header :: dropdown
    //==================================================

    private void printHeaderDropdown()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
        {
            _dropdown.ajaxHide();
            return;
        }

       
        if ( getDropdownList().size() == 1 )
        {
            _dropdown.ajax().hide();

            _singleAccountName.addText(getDropdownList().getFirst().getText());
            _singleAccountName.ajax().replace();
            _singleAccountName.ajax().show();

            setServerSessionAccount();
            return;
        }

        setDropdownOptions();
        setServerSessionAccount();
        _dropdown.ajaxShow();
        _dropdown.ajaxUpdateOptions();
    }

    private void setDropdownOptions()
    {
        KmList<ScOption> list = getDropdownList();

        _dropdown.clearOptions();

        if ( list.isEmpty() )
        {
            _dropdown.addNullNonePrefix();
            return;
        }

        _dropdown.setOptions(list);
    }

    //==================================================
    //= header :: name
    //==================================================

    private void printHeaderLabels()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return;

       
        _hiLabel.ajaxSetText("Hi");
        _hiLabel.ajax().show();

        _userNameLabel.ajaxSetText(u.getName());
        _userNameLabel.ajax().show();

        _accountLabel.ajaxSetText("Account: ");
        _accountLabel.ajax().show();
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

    public void refreshDropdown()
    {
        printHeaderDropdown();
    }
}
