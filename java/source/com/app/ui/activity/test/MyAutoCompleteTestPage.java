package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScAutoCompleteCallbackIF;
import com.kodemore.servlet.field.ScAutoCompleteField;

public class MyAutoCompleteTestPage
    extends MyAbstractTestPage
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
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
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

        ScPageRoot root;
        root = newPageRoot();
        root.css().pad();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSubmitAction());

        ScGroup group;
        group = form.addGroup("Auto Complete Field Test");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_staticField);
        fields.add(_dynamicField);

        group.addDivider();
        group.addButtonBox().addSubmitButton();

        return root;
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
                v = new KmList<String>();
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
