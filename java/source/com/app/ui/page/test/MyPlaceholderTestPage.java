package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyPlaceholderTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyPlaceholderTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyPlaceholderTestPage();
    }

    public static MyPlaceholderTestPage getInstance()
    {
        return _instance;
    }

    private MyPlaceholderTestPage()
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
        _textField.setPlaceholder("Enter a name");
        _textField.cssMargin().left5();

        root.css().fill().auto().boxGray().gap();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Placeholder Test");

        String msg = "The following field should show a 'placeholder' hint inside the field...";

        ScDiv box;
        box = group.getBody().addGap();
        box.addDiv().addText(msg);
        box.addFieldTable().add(_textField);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
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
