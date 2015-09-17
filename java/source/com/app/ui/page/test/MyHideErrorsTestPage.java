package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyHideErrorsTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyHideErrorsTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyHideErrorsTestPage();
    }

    public static MyHideErrorsTestPage getInstance()
    {
        return _instance;
    }

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
