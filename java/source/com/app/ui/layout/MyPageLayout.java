package com.app.ui.layout;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.property.MyProperties;
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
    private MyPageMenu    _menu;
    private MyPageTitle   _title;
    private MyPageContent _content;

    //##################################################
    //# constructor
    //##################################################

    public MyPageLayout()
    {
        // NOTE, the children must be added in reverse z-order.
        // Whatever you want on top, add it last.

        _content = add(new MyPageContent());
        _content.hide();

        _title = add(new MyPageTitle());
        _title.hide();

        _menu = add(new MyPageMenu());
        _menu.hide();

        _footer = add(new MyPageFooter());
        _footer.hide();

        _header = add(new MyPageHeader());
        _header.hide();
    }

    //##################################################
    //# accessing
    //##################################################

    public MyPageHeader getHeader()
    {
        return _header;
    }

    public MyPageFooter getFooter()
    {
        return _footer;
    }

    public MyPageMenu getMenu()
    {
        return _menu;
    }

    public MyPageTitle getTitle()
    {
        return _title;
    }

    public MyPageContent getContent()
    {
        return _content;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshHeader()
    {
        getHeader().ajaxRefreshContent();
    }

    public void ajaxRefreshMenu()
    {
        getMenu().ajaxRefreshContent();
    }

    public void ajaxRefreshTitleFor(ScPage page)
    {
        getTitle().ajaxRefreshContentFor(page);
    }

    public void ajaxClearContent()
    {
        getContent().getInner().ajaxClearContents();
    }

    //##################################################
    //# check
    //##################################################

    public void checkLayoutFor(MyPage page)
    {
        if ( !hasPreviousPage() )
        {
            ajaxUpdateAllCss(page);
            ajaxRefreshAll(page);
            return;
        }

        refreshLayout(page);
        refreshHeader(page);
        refreshFooter(page);
        refreshMenu(page);
        refreshTitle(page);
    }

    private boolean hasPreviousPage()
    {
        return getPreviousPage() != null;
    }

    private void refreshHeader(MyPage page)
    {
        boolean refresh = false;

        boolean show = page.getLayoutType().showsHeader();
        boolean isVisible = getData().isAppHeaderVisible();

        if ( show != isVisible )
            refresh = true;

        if ( refresh )
        {
            getHeader().ajaxRefreshContent(show);
            return;
        }

        if ( show )
            getHeader().ajaxRefreshProject();
    }

    private void refreshMenu(MyPage page)
    {
        boolean refresh = false;

        boolean show = page.getLayoutType().showsMenu();
        boolean isVisible = getData().isPageMenuVisible();

        if ( show != isVisible )
            refresh = true;

        if ( refresh )
            getMenu().ajaxRefreshContent(show);
    }

    private void refreshTitle(MyPage page)
    {
        boolean refresh = false;

        boolean show = page.getLayoutType().showsTitle();
        boolean isVisible = getData().isPageTitleVisible();
        MyPage prevPage = getPreviousPage();

        if ( show != isVisible )
            refresh = true;

        if ( page != prevPage )
            refresh = true;

        if ( refresh )
            getTitle().ajaxRefreshContentFor(page, show);
    }

    private void refreshFooter(MyPage page)
    {
        boolean refresh = false;

        boolean show = page.getLayoutType().showsFooter();
        boolean isVisible = getData().isAppFooterVisible();

        if ( show != isVisible )
            refresh = true;

        if ( refresh )
            getFooter().ajaxRefreshContent(show);
    }

    //==================================================
    //= refresh layout
    //==================================================

    /**
     * If the layout type changed, then we need to update the
     * css classes associated with each layout component.
     */
    private void refreshLayout(MyPage page)
    {
        MyPageLayoutType type = page.getLayoutType();
        MyPageLayoutType prevType = getPreviousPage().getLayoutType();

        if ( type != prevType )
            ajaxUpdateAllCss(page);
    }

    //==================================================
    //= refresh all
    //==================================================

    private void ajaxRefreshAll(MyPage page)
    {
        MyPageLayoutType type = page.getLayoutType();

        getHeader().ajaxRefreshContent(type.showsHeader());
        getMenu().ajaxRefreshContent(type.showsMenu());
        getTitle().ajaxRefreshContentFor(page, type.showsTitle());
        getContent().ajaxShow(type.showsContent());
        getFooter().ajaxRefreshContent(type.showsFooter());
    }

    //##################################################
    //# support
    //##################################################

    private void ajaxUpdateAllCss(MyPage page)
    {
        MyPageLayoutType type = page.getLayoutType();

        ajaxUpdateBodyCss(type);

        getHeader().ajaxSetCss(type.getHeaderCss());
        getMenu().ajaxSetCss(type.getMenuCss());
        getTitle().ajaxSetCss(type.getTitleCss());
        getContent().ajaxSetCss(type.getContentCss());
        getFooter().ajaxSetCss(type.getFooterCss());
    }

    private void ajaxUpdateBodyCss(MyPageLayoutType type)
    {
        ScBlockScript ajax;
        ajax = getData().ajax();
        ajax.removeCss("body", KmCssDefaultConstantsIF.body_normal);
        ajax.removeCss("body", KmCssDefaultConstantsIF.body_print);

        switch ( type )
        {
            case bare:
            case basic:
            case normal:
                ajax.addCss("body", KmCssDefaultConstantsIF.body_normal);
                return;

            case print:
                ajax.addCss("body", KmCssDefaultConstantsIF.body_print);
                return;
        }
    }

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    private MyPage getPreviousPage()
    {
        return (MyPage)getData().getCurrentPage();
    }

}
