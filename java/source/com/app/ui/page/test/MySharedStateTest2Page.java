package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MySharedStateTest2Page
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySharedStateTest2Page _instance;

    public static void installInstance()
    {
        _instance = new MySharedStateTest2Page();
    }

    public static MySharedStateTest2Page getInstance()
    {
        return _instance;
    }

    private MySharedStateTest2Page()
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
        root.css().gap();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Page Session Test (Page 2)");
        group.css().width400();

        ScBox body;
        body = group.getBody().addPad();
        body.addParagraph("Test the page session.");
        body.addBreak();

        group.addBodyDivider();

        ScBox footer;
        footer = group.getBody().addButtonBox();
        footer.addButton("red", this::handleRed);
        footer.addButton("blue", this::handleBlue);
        footer.addButton("toast", this::handleToast);
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
        return MySharedStateTest1Page.getInstance().getTestValueHolder();
    }
}
