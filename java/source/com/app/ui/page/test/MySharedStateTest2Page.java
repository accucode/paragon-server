package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;

public class MySharedStateTest2Page
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySharedStateTest2Page instance = new MySharedStateTest2Page();

    private MySharedStateTest2Page()
    {
        // singleton
    }

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
        footer.addButton("red", newRedAction());
        footer.addButton("blue", newBlueAction());
        footer.addButton("toast", newToastAction());
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

    private ScLocalString getTestValueHolder()
    {
        return MySharedStateTest1Page.instance.getTestValueHolder();
    }
}
