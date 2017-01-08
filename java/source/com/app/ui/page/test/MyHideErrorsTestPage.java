package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
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

    private ScFieldset _fieldsetOne;
    private ScFieldset _fieldsetTwo;

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
        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Form");

        ScDiv body;
        body = group.getBody();
        body.css().gap();

        ScFieldset fieldset;
        fieldset = body.addFieldset("Fieldset One");
        fieldset.css().gap();
        fieldset.addFieldTable().addIntegerField().setLabel("Integer");
        fieldset.addButton("Hide Errors", newUncheckedAction(this::handleHideFieldsetOneErrors));
        _fieldsetOne = fieldset;

        fieldset = body.addFieldset("Fieldset Two");
        fieldset.css().gap();
        fieldset.addFieldTable().addIntegerField().setLabel("Integer");
        fieldset.addButton("Hide Errors", newUncheckedAction(this::handleHideFieldsetTwoErrors));
        _fieldsetTwo = fieldset;

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addResetButton();
        buttons.addButton("Hide All Errors", newUncheckedAction(this::handleHideAllErrors));
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
        ajax().hideAllErrors();
        validate();

        getRoot().ajaxUpdateFieldValues();
        ajax().toast("Ok");
    }

    private void handleHideFieldsetOneErrors()
    {
        _fieldsetOne.ajaxHideAllErrors();
    }

    private void handleHideFieldsetTwoErrors()
    {
        _fieldsetTwo.ajaxHideAllErrors();
    }

    private void handleHideAllErrors()
    {
        ajax().hideAllErrors();
    }

}
