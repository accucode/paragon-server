package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyFormTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyFormTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyFormTestPage();
    }

    public static MyFormTestPage getInstance()
    {
        return _instance;
    }

    private MyFormTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _textField;

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
        _textField = new ScTextField();
        _textField.setLabel("Field");
        _textField.cssMargin().left5();

        root.css().fill().auto().boxGray().gap();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Form Test");
        group.getBody().addPad().addFieldTable().add(_textField);

        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addSubmitButton();
        buttons.addResetButton();
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

        String s = _textField.getValue();
        if ( s == null )
            s = "<null>";

        getRoot().ajaxUpdateFieldValues();
        ajax().toast(s);
    }

}
