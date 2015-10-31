package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

// todo_aaron: Finish orders page
public final class MyOrdersPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyOrdersPage _instance;

    public static void installInstance()
    {
        _instance = new MyOrdersPage();
    }

    public static MyOrdersPage getInstance()
    {
        return _instance;
    }

    private MyOrdersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.member;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScFlexbox fb;
        fb = root._addFlexbox();

        fb.css().fill().flexCrossAlignStretch().borderPurple();

        ScBox searchContainer;
        searchContainer = fb.addBox();
        searchContainer.css().flexNoGrow();

        installSeachPanelOn(searchContainer);

        ScBox orderContainer;
        orderContainer = fb.addBox();
        orderContainer.css().flexGrow();

        ScBox auxContainer;
        auxContainer = fb.addBox();
        auxContainer.css().flexGrow();
    }

    private void installSeachPanelOn(ScBox root)
    {
        root.css().gap();

        ScGroup searchGroup;
        searchGroup = root.addGroup("Orders");
        searchGroup.getBody().addText("Search for orders");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // review_aaron: prerender
    }
}
