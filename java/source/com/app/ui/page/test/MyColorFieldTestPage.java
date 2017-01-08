package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScColorField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyColorFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyColorFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyColorFieldTestPage();
    }

    public static MyColorFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyColorFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScColorField _field;

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
        _field = new ScColorField();
        _field.setLabel("Color");
        _field.setHelp("Click the field to pick a color.");

        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Color Field");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_field);

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

        getRoot().ajaxUpdateFieldValues();
        ajax().toast("Color = %s", _field.getValue());
    }

}
