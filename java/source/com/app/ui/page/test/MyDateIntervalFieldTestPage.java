package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateIntervalField;
import com.kodemore.servlet.field.ScDateIntervalField.Mode;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDateInterval;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDateIntervalFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDateIntervalFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyDateIntervalFieldTestPage();
    }

    public static MyDateIntervalFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyDateIntervalFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDateIntervalField _dateIntervalField;

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
        _dateIntervalField = new ScDateIntervalField();
        _dateIntervalField.setLabel("Date Interval");
        _dateIntervalField.setMode(Mode.Custom);

        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Date Interval");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_dateIntervalField);

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

        KmDateInterval di = _dateIntervalField.getValue();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("Date Interval = %s.", di);

        getRoot().ajaxUpdateFieldValues();
        ajax().toast(out);
    }
}
