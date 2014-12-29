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

    private MyPageHeader  _header;
    private MyPageFooter  _footer;
    private MyTopMenu     _topMenu;
    private MyLeftMenu    _leftMenu;
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

        _leftMenu = add(new MyLeftMenu());
        _leftMenu.style().hide();

        _topMenu = add(new MyTopMenu());
        _topMenu.style().hide();

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

    private MyTopMenu getTopMenu()
    {
        return _topMenu;
    }

    private MyLeftMenu getLeftMenu()
    {
        return _leftMenu;
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

        MyMenuItem top = page.getTopMenu();
        MyMenuItem left = page.getLeftMenuItem();

        MyPageLayoutType prevType = prevPage.getLayoutType();
        MyMenuItem prevTop = prevPage.getTopMenu();
        MyMenuItem prevLeft = prevPage.getLeftMenuItem();

        if ( type != prevType )
            ajaxRefreshAllCss(type);

        // refresh header?
        boolean refreshHeader = false;
        boolean showsHeader = type.showsHeader();

        if ( showsHeader && !data.isPageHeaderVisible() )
            refreshHeader = true;

        // refresh footer?
        boolean refreshFooter = false;
        boolean showsFooter = type.showsFooter();

        if ( showsFooter && !data.isPageFooterVisible() )
            refreshFooter = true;

        // refresh top menu?
        boolean refreshTopMenu = false;
        boolean refreshTopMenuSelection = false;
        boolean showsTopMenu = type.showsTopMenu();

        if ( showsTopMenu && !data.isTopMenuVisible() )
        {
            refreshTopMenu = true;
            refreshTopMenuSelection = true;
        }

        // refresh left menu?
        boolean refreshLeftMenu = false;
        boolean refreshLeftSelection = false;
        boolean showsLeftMenu = type.showsLeftMenu();

        if ( showsLeftMenu && !data.isLeftMenuVisible() )
        {
            refreshLeftMenu = true;
            refreshLeftSelection = true;
        }

        if ( top != prevTop )
        {
            refreshTopMenuSelection = true;
            refreshLeftMenu = true;
        }

        if ( left != prevLeft )
            refreshLeftSelection = true;

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

        if ( refreshTopMenu )
        {
            getTopMenu().ajax().show(showsTopMenu);
            getTopMenu().ajaxRefreshContent();
        }

        if ( refreshTopMenuSelection )
            getTopMenu().ajaxRefreshSelection(page);

        if ( refreshLeftMenu )
        {
            getLeftMenu().ajax().show(showsLeftMenu);
            getLeftMenu().ajaxRefreshContentFor(page);
        }

        if ( refreshLeftSelection )
            getLeftMenu().ajaxRefreshSelection(page);

        if ( refreshTitle )
            getTitle().ajaxRefreshContentFor(page);

        ajaxRefreshVisibilityFor(type);
    }

    private boolean requiresTitleRefresh(MyPage page)
    {
        ScServletData data = getData();
        MyPage prevPage = (MyPage)data.getCurrentPage();
        MyPageLayoutType type = page.getLayoutType();

        if ( type.showsTitle() && !data.isPageTitleVisible() )
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

        if ( type.showsTopMenu() )
        {
            getTopMenu().ajaxRefreshContent();
            getTopMenu().ajaxRefreshSelection(page);
            getTopMenu().ajax().show();
        }

        if ( type.showsLeftMenu() )
        {
            getLeftMenu().ajaxRefreshContentFor(page);
            getLeftMenu().ajaxRefreshSelection(page);
            getLeftMenu().ajax().show();
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
        getTopMenu().ajax().setCss(type.getTopMenuCss());
        getLeftMenu().ajax().setCss(type.getLeftMenuCss());
        getTitle().ajax().setCss(type.getTitleCss());
        getContent().ajax().setCss(type.getContentCss());
    }

    private void ajaxRefreshVisibilityFor(MyPageLayoutType type)
    {
        ScServletData data = getData();

        ajaxVisibleIf(getHeader(), type.showsHeader(), data.isPageHeaderVisible());
        ajaxVisibleIf(getFooter(), type.showsFooter(), data.isPageFooterVisible());
        ajaxVisibleIf(getTopMenu(), type.showsTopMenu(), data.isTopMenuVisible());
        ajaxVisibleIf(getLeftMenu(), type.showsLeftMenu(), data.isLeftMenuVisible());
        ajaxVisibleIf(getTitle(), type.showsTitle(), data.isPageTitleVisible());
        ajaxVisibleIf(getContent(), type.showsContent(), data.isPageContentVisible());
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
