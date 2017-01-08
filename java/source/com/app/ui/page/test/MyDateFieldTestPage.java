package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDateFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDateFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDateFieldTestPage();
    }

    public static MyDateFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyDateFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScDateField _startField;
    private ScDateField _endField;

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
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        _startField = new ScDateField();
        _startField.setLabel("Start Date");

        _endField = new ScDateField();
        _endField.setLabel("End Date");

        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Date Fields");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_nameField);
        fields.add(_startField);
        fields.add(_endField);

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

        String name = _nameField.getValue();
        KmDate start = _startField.getValue();
        KmDate end = _endField.getValue();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("Name = %s.", name);
        out.printfln("Start = %s.", start);
        out.printfln("End = %s.", end);

        getRoot().ajaxUpdateFieldValues();
        ajax().toast(out);
    }

}
