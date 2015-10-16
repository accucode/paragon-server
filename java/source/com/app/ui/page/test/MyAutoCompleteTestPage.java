package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteCallbackIF;
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
        _staticField = new ScAutoCompleteField();
        _staticField.setLabel("Static");
        _staticField.addOption("acorn");
        _staticField.addOption("another");
        _staticField.addOption("apple");
        _staticField.addOption("barn");
        _staticField.addOption("bandit");
        _staticField.addOption("baggage");
        _staticField.addOption("candy");
        _staticField.addOption("camping");
        _staticField.addOption("cinder");

        _dynamicField = new ScAutoCompleteField();
        _dynamicField.setLabel("Dynamic");
        _dynamicField.setCallback(newCallback());

        root.css().pad();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Auto Complete Tests");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_staticField);
        fields.add(_dynamicField);

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addResetButton();
    }

    private ScAutoCompleteCallbackIF newCallback()
    {
        return new ScAutoCompleteCallbackIF()
        {
            @Override
            public KmList<String> getOptionsFor(String term)
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
        };
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

        getRoot().ajaxUpdateValues();
        ajax().toast("%s\n%s", s1, s2);
    }
}
