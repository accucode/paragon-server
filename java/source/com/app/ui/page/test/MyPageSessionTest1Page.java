package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

public class MyPageSessionTest1Page
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPageSessionTest1Page instance = new MyPageSessionTest1Page();

    private MyPageSessionTest1Page()
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

        ScOldGroup group;
        group = root.addOldGroup();
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
        footer.addButton("page 2", MyPageSessionTest2Page.instance);
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
