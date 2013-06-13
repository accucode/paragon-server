package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
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

    private ScAutoCompleteField _field1;
    private ScAutoCompleteField _field2;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        _field1 = new ScAutoCompleteField();
        _field1.setLabel("Static");
        _field1.addOption("acorn");
        _field1.addOption("another");
        _field1.addOption("apple");
        _field1.addOption("barn");
        _field1.addOption("bandit");
        _field1.addOption("baggage");
        _field1.addOption("candy");
        _field1.addOption("camping");
        _field1.addOption("cinder");

        _field2 = new ScAutoCompleteField();
        _field2.setLabel("Dynamic");
        _field2.setCallback(newCallback());

        ScBox root;
        root = new ScBox();
        root.css().pad();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSubmitAction());

        ScGroup group;
        group = form.addGroup("Auto Complete Field Test");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_field1);
        fields.add(_field2);

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
        String s1 = _field1.getValue();
        String s2 = _field2.getValue();

        ajax().toast("%s\n%s", s1, s2);
    }
}
