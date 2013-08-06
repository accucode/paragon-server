package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.ScMenuItem;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTopMenu;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.script.ScScript;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyActions;
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

    private ScTopMenu  _menu;
    private ScDiv      _topRightDiv;
    private ScDropdown _dropdown;

    //##################################################
    //# constructor
    //##################################################

    public MyPageLayout()
    {
        installTopRightDiv();
    }

    //##################################################
    //# install: menu
    //##################################################

    private void installMenu()
    {
        _menu = new ScTopMenu();
    }

    //##################################################
    //# install: dropdown
    //##################################################

    private void installDropdown()
    {
        _dropdown = new ScDropdown();
        _dropdown.hide();
    }

    private KmList<ScOption> getDropdownList()
    {
        // fixme_steve this could use some refactoring
        getAccess();

        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return null;

        KmList<ScOption> list;
        list = new KmList<ScOption>();

        KmList<MyAccountUser> accountUsers;
        accountUsers = getAccess().getAccountUserDao().findAccountUsersFor(u);

        for ( MyAccountUser e : accountUsers )
        {
            MyAccount account = e.getAccount();

            if ( account != null )
            {
                ScOption option;
                option = new ScOption();
                option.setValue(account.getUid());
                option.setText(account.getName());

                list.add(option);
            }
        }
        return list;
    }

    //##################################################
    //# install: top right div
    //##################################################

    private void installTopRightDiv()
    {
        installMenu();
        installDropdown();

        _topRightDiv = new ScDiv();
        _topRightDiv.css().pad10();
        _topRightDiv.add(_dropdown);
        _topRightDiv.add(_menu);

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
        printHeadderDropdown();
        printHeaderMenu();
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

    //##################################################
    //# header: menu
    //##################################################

    private void printHeaderMenu()
    {
        _menu.ajaxRender(getMenu());
    }

    private ScMenuItem getMenu()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
            return null;

        MyActions actions = MyActions.getInstance();

        ScMenuItem root;
        root = new ScMenuItem();

        ScMenuItem m;
        m = root.addChild(u.getName());
        m.addChild("Settings", actions.getSettingsAction());
        m.addChild("Sign Out", actions.getSignOutAction());

        return root;
    }

    //##################################################
    //# header: dropdown
    //##################################################//

    private void printHeadderDropdown()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        MyUser u = ss.getUser();

        if ( u == null )
        {
            _dropdown.ajax().hide();
            return;
        }

        setDropdownOptions(u);
        _dropdown.ajax().show();
    }

    private void setDropdownOptions(MyUser u)
    {
        for ( ScOption e : getDropdownList() )
            _dropdown.ajaxAddOption(e.getText(), e.getValue());
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

    /**
     * (valerie)
     * please check convenience methods
     * 
     * review_valerie (wyatt)
     *      These are fine, except for the findAccountsFor method.
     */
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

    private ScScript ajax()
    {
        return getData().getAjaxResult().getScript();
    }

    public KmList<MyAccount> findAccountsFor(MyUser u)
    {
        //        KmList<MyAccountUser> accountsUsers;
        //        accountsUsers = get .findAccountsUsersFor(u);
        //        
        //        KmList<MyAccount> list;
        //        list = new KmList<MyAccount>();
        //        
        //        
        //        for ( MyAccountUser e : accountsUsers ) 
        //            
        //            
        return null;
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
