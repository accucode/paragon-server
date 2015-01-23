package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyHideErrorsTestPage
    extends MyAbstractTestEntryPage
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
        form.setSubmitAction(this::handleSubmit);
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Group One");

        ScBox lines;
        lines = group.getBody().addLines();
        lines.addFieldTable().addIntegerField().setLabel("Integer");
        lines.addButton("Hide Errors", this::handleHideGroupOneErrors);
        _groupOne = group;

        group = form.addGroup("Group Two");

        lines = group.getBody().addLines();
        lines.addFieldTable().addIntegerField().setLabel("Integer");
        lines.addButton("Hide Errors", this::handleHideGroupTwoErrors);
        _groupTwo = group;

        group = form.addGroup("Form");

        ScBox buttons;
        buttons = group.getBody().addButtonBox();
        buttons.addSubmitButton("Validate");
        buttons.addButton("Hide All Errors", this::handleHideAllErrors);
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
