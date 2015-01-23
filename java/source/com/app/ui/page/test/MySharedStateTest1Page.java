package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

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
public class MySharedStateTest1Page
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySharedStateTest1Page instance = new MySharedStateTest1Page();

    private MySharedStateTest1Page()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _testValue;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
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

        root.css().gap();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Page Session Test (Page 1)");
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
        // footer.addButton("page 2", MySharedStateTest2Page.instance);
        footer.addButton("page 2", this::handlePage2);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
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
        getTestValueHolder().setValue("yellow");
        MySharedStateTest2Page.instance.ajaxPush();
    }

    //##################################################
    //# support
    //##################################################

    public ScLocalString getTestValueHolder()
    {
        return _testValue;
    }
}
