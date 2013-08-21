package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
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

    private ScGroup _groupOne;
    private ScGroup _groupTwo;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSubmitAction());
        form.css().gap();

        ScGroupArray groups;
        groups = form.addGroupArray();

        ScGroup group;
        group = groups.addGroup("Group One");

        ScBox lines;
        lines = group.addLines();
        lines.addFields().addIntegerField().setLabel("Integer");
        lines.addButton("Hide Errors", newHideGroupOneErrors());
        _groupOne = group;

        group = groups.addGroup("Group Two");

        lines = group.addLines();
        lines.addFields().addIntegerField().setLabel("Integer");
        lines.addButton("Hide Errors", newHideGroupTwoErrors());
        _groupTwo = group;

        group = groups.addGroup("Form");

        ScBox buttons;
        buttons = group.addButtonBox();
        buttons.addSubmitButton("Validate");
        buttons.addButton("Hide All Errors", newHideAllErrorsAction());

        return root;
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
