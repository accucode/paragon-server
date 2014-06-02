package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * This demonstrates two pages that share some page session.
 * Test 1A and 1B both rely on _testValue; Test 1B uses 1A's 
 * public getter to access the value.
 * 
 * First, this shows how either page can update the value.
 * 
 * Second, this shows that the value is preserved when navigating
 * from 1A to 1B.
 * 
 * Third, this shows that the value is automatically restored to
 * it's pre-navigation value when the using the back button to 
 * navigate "back" from 1B to 1A.
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
        body = group.addPad();
        body.addParagraph("Test the page session.");
        body.addBreak();

        group.addDivider();

        ScBox footer;
        footer = group.addButtonBoxLeft();
        footer.addButton("red", newRedAction());
        footer.addButton("blue", newBlueAction());
        footer.addButton("toast", newToastAction());
        footer.addButton("page 2", MySharedStateTest2Page.instance);
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
    //# action
    //##################################################

    private ScActionIF newRedAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRed();
            }
        };
    }

    private ScActionIF newBlueAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleBlue();
            }
        };
    }

    private ScActionIF newToastAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleToast();
            }
        };
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

    public ScLocalString getTestValueHolder()
    {
        return _testValue;
    }
}
