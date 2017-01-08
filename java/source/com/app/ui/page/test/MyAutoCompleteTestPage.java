package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAutoCompleteTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAutoCompleteTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyAutoCompleteTestPage();
    }

    public static MyAutoCompleteTestPage getInstance()
    {
        return _instance;
    }

    private MyAutoCompleteTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScAutoCompleteField _staticField;
    private ScAutoCompleteField _dynamicField;

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
        root.css().fill().auto().flexColumn().columnSpacer10();

        installFormTestOn(root);
        installLayoutTestOn(root);
    }

    private void installFormTestOn(ScContainer root)
    {
        _staticField = newField("Static");

        _dynamicField = new ScAutoCompleteField();
        _dynamicField.setLabel("Dynamic");
        _dynamicField.setHelp("Some dynamic options.");
        _dynamicField.setCallback(this::getOptionsFor);

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);
        form.css().flexChildStatic();

        ScGroup group;
        group = form.addGroup("Auto Complete Tests");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_staticField);
        fields.add(_dynamicField);

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addResetButton();
    }

    private void installLayoutTestOn(ScContainer root)
    {
        ScAutoCompleteField field;

        ScGroup group;
        group = root.addGroup("Layout");
        group.css().flexChildStatic();

        ScFieldTable table;
        table = group.getBody().addPad().addFieldTable();

        field = newField("inline");
        field.layoutInline();
        table.add(field);

        field = newField("inline(400)");
        field.layoutInline(400);
        table.add(field);

        field = newField("block");
        field.layoutBlock();
        table.add(field);

        field = newField("");
        field.layoutFlexFiller();
        field.cssMargin().left().right();

        ScDiv row;
        row = table.addFlexRow();
        row.setLabel("flex filler");
        row.addButton("before");
        row.add(field);
        row.addButton("after");
    }

    private ScAutoCompleteField newField(String label)
    {
        ScAutoCompleteField e;
        e = new ScAutoCompleteField();
        e.setLabel(label);
        e.setHelp("Some static options.");
        e.addOption("acorn");
        e.addOption("another");
        e.addOption("apple");
        e.addOption("barn");
        e.addOption("bandit");
        e.addOption("baggage");
        e.addOption("candy");
        e.addOption("camping");
        e.addOption("cinder");
        return e;
    }

    //##################################################
    //# support
    //##################################################

    private KmList<String> getOptionsFor(String term)
    {
        term = term + "";

        KmList<String> v;
        v = new KmList<>();
        v.add(term + "1");
        v.add(term + "2");
        v.add(term + "3");
        v.add(term + "4");
        v.add(term + "5");
        return v;
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

        String s1 = _staticField.getValue();
        String s2 = _dynamicField.getValue();

        getRoot().ajaxUpdateFieldValues();
        ajax().toast("%s\n%s", s1, s2);
    }
}
