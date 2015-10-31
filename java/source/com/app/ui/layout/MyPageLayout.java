package com.app.ui.layout;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.property.MyPropertyRegistry;
import com.app.ui.page.MyPage;
import com.app.ui.servlet.MyServletConstantsIF;
import com.app.utility.MyGlobals;

public class MyPageLayout
    extends ScSimpleContainer
    implements MyServletConstantsIF
{
    //##################################################
    //# install
    //##################################################

    private static MyPageLayout _instance;

    public static void installInstance()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = new MyPageLayout();
    }

    public static MyPageLayout getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Not installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    private MyPageHeader  _header;
    private MyPageFooter  _footer;
    private MyPageTabs    _tabs;
    private MyPageMenu    _menu;
    private MyPageTitle   _title;
    private MyPageContent _content;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        // NOTE, the children must be added in reverse z-order.

        _content = add(new MyPageContent());
        _content.style().hide();

        _title = add(new MyPageTitle());
        _title.style().hide();

        _menu = add(new MyPageMenu());
        _menu.style().hide();

        _tabs = add(new MyPageTabs());
        _tabs.style().hide();

        _footer = add(new MyPageFooter());
        _footer.style().hide();

        _header = add(new MyPageHeader());
        _header.style().hide();
    }

    //##################################################
    //# accessing
    //##################################################

    private MyPageHeader getHeader()
    {
        return _header;
    }

    private MyPageFooter getFooter()
    {
        return _footer;
    }

    private MyPageTabs getTabs()
    {
        return _tabs;
    }

    private MyPageMenu getMenu()
    {
        return _menu;
    }

    private MyPageTitle getTitle()
    {
        return _title;
    }

    public void glowTitleOn(ScBlockScript script)
    {
        _title.glowOn(script);
    }

    public MyPageContent getContent()
    {
        return _content;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshHeaderContent()
    {
        getHeader().ajaxRefreshContent();
    }

    public void ajaxRefreshTitleContentFor(ScPage page)
    {
        getTitle().ajaxRefreshContentFor(page);
    }

    public void ajaxClearContent()
    {
        getContent().getInner().ajax().clearContents();
    }

    public void ajaxPushWhenContentDone()
    {
        getContent().getInner().ajax().pushWhenDone();
    }

    //##################################################
    //# check
    //##################################################

    public void checkLayoutFor(MyPage page)
    {
        MyPage prevPage = (MyPage)getData().getCurrentPage();

        if ( prevPage == null )
        {
            ajaxRefreshAll(page);
            return;
        }

        ScServletData data = getData();
        MyPageLayoutType type = page.getLayoutType();

        MyMenuItem tab = page.getPrimaryMenuItem();
        MyMenuItem menu = page.getSecondaryMenuItem();

        MyPageLayoutType prevType = prevPage.getLayoutType();
        MyMenuItem prevTab = prevPage.getPrimaryMenuItem();
        MyMenuItem prevMenu = prevPage.getSecondaryMenuItem();

        if ( type != prevType )
            ajaxRefreshAllCss(type);

        // refresh header?
        boolean refreshHeader = false;
        boolean showsHeader = type.showsHeader();

        if ( showsHeader && !data.isAppHeaderVisible() )
            refreshHeader = true;

        // refresh footer?
        boolean refreshFooter = false;
        boolean showsFooter = type.showsFooter();

        if ( showsFooter && !data.isAppFooterVisible() )
            refreshFooter = true;

        // refresh tab (primary navigation)?
        boolean refreshTabs = false;
        boolean refreshTabSelection = false;
        boolean showsTabs = type.showsTabs();

        if ( showsTabs && !data.isAppTabsVisible() )
        {
            refreshTabs = true;
            refreshTabSelection = true;
        }

        // refresh menu (secondary navigation)?
        boolean refreshMenu = false;
        boolean refreshMenuSelection = false;
        boolean showsMenu = type.showsMenu();

        if ( showsMenu && !data.isAppMenuVisible() )
        {
            refreshMenu = true;
            refreshMenuSelection = true;
        }

        if ( tab != prevTab )
        {
            refreshTabSelection = true;
            refreshMenu = true;
        }

        if ( menu != prevMenu )
            refreshMenuSelection = true;

        // refresh title?
        boolean refreshTitle = false;

        if ( requiresTitleRefresh(page) )
            refreshTitle = true;

        if ( page != prevPage )
            refreshTitle = true;

        // refresh as needed

        if ( refreshHeader )
            getHeader().ajaxRefreshContent();

        if ( refreshFooter )
        {
            getFooter().ajax().show(showsFooter);
            getFooter().ajaxRefreshContent();
        }

        if ( refreshTabs )
        {
            getTabs().ajax().show(showsTabs);
            getTabs().ajaxRefreshContent();
        }

        if ( refreshTabSelection )
            getTabs().ajaxRefreshSelection(page);

        if ( refreshMenu )
        {
            getMenu().ajax().show(showsMenu);
            getMenu().ajaxRefreshContentFor(page);
        }

        if ( refreshMenuSelection )
            getMenu().ajaxRefreshSelection(page);

        if ( refreshTitle )
            getTitle().ajaxRefreshContentFor(page);

        ajaxRefreshVisibilityFor(type);
    }

    private boolean requiresTitleRefresh(MyPage page)
    {
        ScServletData data = getData();
        MyPage prevPage = (MyPage)data.getCurrentPage();
        MyPageLayoutType type = page.getLayoutType();

        if ( type.showsTitle() && !data.isAppTitleVisible() )
            return true;

        if ( page != prevPage )
            return true;

        return false;
    }

    private void ajaxRefreshAll(MyPage page)
    {
        MyPageLayoutType type = page.getLayoutType();
        ajaxRefreshAllCss(type);

        if ( type.showsHeader() )
        {
            getHeader().ajaxRefreshContent();
            getHeader().ajax().show();
        }

        if ( type.showsFooter() )
        {
            getFooter().ajaxRefreshContent();
            getFooter().ajax().show();
        }

        if ( type.showsTabs() )
        {
            getTabs().ajaxRefreshContent();
            getTabs().ajaxRefreshSelection(page);
            getTabs().ajax().show();
        }

        if ( type.showsMenu() )
        {
            getMenu().ajaxRefreshContentFor(page);
            getMenu().ajaxRefreshSelection(page);
            getMenu().ajax().show();
        }

        if ( type.showsTitle() )
        {
            getTitle().ajaxRefreshContentFor(page);
            getTitle().ajax().show();
        }

        if ( type.showsContent() )
            getContent().ajax().show();
    }

    private void ajaxRefreshAllCss(MyPageLayoutType type)
    {
        getHeader().ajax().setCss(type.getHeaderCss());
        getFooter().ajax().setCss(type.getFooterCss());
        getTabs().ajax().setCss(type.getTabsCss());
        getMenu().ajax().setCss(type.getMenuCss());
        getTitle().ajax().setCss(type.getTitleCss());
        getContent().ajax().setCss(type.getContentCss());
    }

    private void ajaxRefreshVisibilityFor(MyPageLayoutType type)
    {
        ScServletData data = getData();

        ajaxVisibleIf(getHeader(), type.showsHeader(), data.isAppHeaderVisible());
        ajaxVisibleIf(getFooter(), type.showsFooter(), data.isAppFooterVisible());
        ajaxVisibleIf(getTabs(), type.showsTabs(), data.isAppTabsVisible());
        ajaxVisibleIf(getMenu(), type.showsMenu(), data.isAppMenuVisible());
        ajaxVisibleIf(getTitle(), type.showsTitle(), data.isAppTitleVisible());
        ajaxVisibleIf(getContent(), type.showsContent(), data.isAppContentVisible());
    }

    private void ajaxVisibleIf(ScHtmlIdIF target, boolean shows, boolean visible)
    {
        if ( shows && !visible )
            target.ajax().show();

        if ( !shows && visible )
            target.ajax().hide();
    }

    //##################################################
    //# support
    //##################################################

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
