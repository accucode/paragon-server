package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * This demonstrates two pages that share some page session.
 * Test1 and Test2 both rely on _testValue; Test2 uses Test1's
 * public getter to access the value.
 *
 * First, this shows how either page can update the value.
 *
 * Second, this shows that the value is preserved when navigating
 * from Test1 to Test2.
 *
 * Third, this shows that the value is automatically restored to
 * it's pre-navigation value when the using the back button to
 * navigate "back" from Test2 to Test1.
 */
public final class MySharedState1TestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySharedState1TestPage _instance;

    public static void installInstance()
    {
        _instance = new MySharedState1TestPage();
    }

    public static MySharedState1TestPage getInstance()
    {
        return _instance;
    }

    private MySharedState1TestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _testValue;

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
        _testValue = new ScLocalString();
        _testValue.setAutoSave();

        root.css().fill().auto();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Page Session Test (Page 1)");

        ScDiv body;
        body = group.getBody().addPad();
        body.addParagraph("Test the page session.");

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("red", this::handleRed);
        buttons.addButton("blue", this::handleBlue);
        buttons.addButton("toast", this::handleToast);
        buttons.addButton("page 2", this::handlePage2);
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

    private void handlePage2()
    {
        MySharedState2TestPage.getInstance().ajaxEnter();
    }

    //##################################################
    //# support
    //##################################################

    public ScLocalString getTestValueHolder()
    {
        return _testValue;
    }
}
