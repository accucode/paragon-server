package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteCallbackIF;
import com.kodemore.servlet.field.ScAutoCompleteField;

public class MyAutoCompleteTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAutoCompleteTestPage instance = new MyAutoCompleteTestPage();

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
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
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
        form.setSubmitAction(newSubmitAction());

        ScGroup group;
        group = form.addGroup("Auto Complete Tests");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_staticField);
        fields.add(_dynamicField);

        group.addBodyDivider();
        group.getBody().addButtonBox().addSubmitButton();
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
    //# actions
    //##################################################

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSubmit();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        String s1 = _staticField.getValue();
        String s2 = _dynamicField.getValue();

        ajax().toast("%s\n%s", s1, s2);
    }
}
