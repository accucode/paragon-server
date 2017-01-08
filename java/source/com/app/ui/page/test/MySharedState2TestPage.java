package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MySharedState2TestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySharedState2TestPage _instance;

    public static void installInstance()
    {
        _instance = new MySharedState2TestPage();
    }

    public static MySharedState2TestPage getInstance()
    {
        return _instance;
    }

    private MySharedState2TestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
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
        root.css().fill().auto();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Page Session Test (Page 2)");

        ScDiv body;
        body = group.getBody().addPad();
        body.addParagraph("Test the page session.");
        body.addBreak();

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("red", this::handleRed);
        buttons.addButton("blue", this::handleBlue);
        buttons.addButton("toast", this::handleToast);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRed()
    {
        getTestValueHolder().setValue("red");
        ajax().toast("set to red");
    }

    private void handleBlue()
    {
        getTestValueHolder().setValue("blue");
        ajax().toast("set to blue");
    }

    private void handleToast()
    {
        ajax().toast(getTestValueHolder().getValue());
    }

    //##################################################
    //# support
    //##################################################

    private ScLocalString getTestValueHolder()
    {
        return MySharedState1TestPage.getInstance().getTestValueHolder();
    }
}
