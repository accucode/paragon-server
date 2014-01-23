package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScOldGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

public class MyHideErrorsTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHideErrorsTestPage instance = new MyHideErrorsTestPage();

    private MyHideErrorsTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScOldGroup _groupOne;
    private ScOldGroup _groupTwo;

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
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(newSubmitAction());
        form.css().gap();

        ScOldGroupArray groups;
        groups = form.addOldGroupArray();

        ScOldGroup group;
        group = groups.addOldGroup("Group One");

        ScBox lines;
        lines = group.addLines();
        lines.addFields().addIntegerField().setLabel("Integer");
        lines.addButton("Hide Errors", newHideGroupOneErrors());
        _groupOne = group;

        group = groups.addOldGroup("Group Two");

        lines = group.addLines();
        lines.addFields().addIntegerField().setLabel("Integer");
        lines.addButton("Hide Errors", newHideGroupTwoErrors());
        _groupTwo = group;

        group = groups.addOldGroup("Form");

        ScBox buttons;
        buttons = group.addButtonBox();
        buttons.addSubmitButton("Validate");
        buttons.addButton("Hide All Errors", newHideAllErrorsAction());
    }

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSubmit();
            }
        };
    }

    private ScActionIF newHideGroupOneErrors()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleHideGroupOneErrors();
            }
        };
    }

    private ScActionIF newHideGroupTwoErrors()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleHideGroupTwoErrors();
            }
        };
    }

    private ScActionIF newHideAllErrorsAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleHideAllErrors();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        validate();

        ajax().toast("Ok");
    }

    private void handleHideGroupOneErrors()
    {
        _groupOne.ajax().hideAllErrors();
    }

    private void handleHideGroupTwoErrors()
    {
        _groupTwo.ajax().hideAllErrors();
    }

    private void handleHideAllErrors()
    {
        ajax().hideAllErrors();
    }

}
