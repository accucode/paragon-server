package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScRadioField;
import com.kodemore.string.KmStringBuilder;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyRadioFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyRadioFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyRadioFieldTestPage();
    }

    public static MyRadioFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyRadioFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScRadioField _one;
    private ScRadioField _two;
    private ScRadioField _three;

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
        _one = newRadio("one", 1);
        _two = newRadio("two", 2);
        _three = newRadio("three", 3);

        root.css().fill().auto();

        ScGroup group;
        group = root.addForm().addGroup("Radio Test");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_one);
        fields.add(_two);
        fields.add(_three);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("print values", newUncheckedAction(this::handlePrintValues));
        buttons.addButton("set value 1", newUncheckedAction(this::handleSetValue1));
        buttons.addButton("reset values", newUncheckedAction(this::handleResetValues));
    }

    private ScRadioField newRadio(String label, Integer value)
    {
        String name = "number";

        ScRadioField e;
        e = new ScRadioField();
        e.setHtmlName(name);
        e.setLabel(label);
        e.setOptionValue(value);
        e.setHelp("A help message.");
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handlePrintValues()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println("values");
        out.println("    1: " + _one.getValue());
        out.println("    2: " + _two.getValue());
        out.println("    3: " + _three.getValue());

        ajax().toast(out);
    }

    private void handleSetValue1()
    {
        _one.ajaxSetFieldValue(true);
    }

    private void handleResetValues()
    {
        ajax().resetDirtyFields();
        ajax().toast("reset");
    }
}
