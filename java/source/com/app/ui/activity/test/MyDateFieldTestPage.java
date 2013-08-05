package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;

public class MyDateFieldTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDateFieldTestPage instance = new MyDateFieldTestPage();

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
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        _startField = new ScDateField();
        _startField.setLabel("Start Date");

        _endField = new ScDateField();
        _endField.setLabel("End Date");

        ScPageRoot root;
        root = newPageRoot();
        root.css().pad();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSubmitAction());

        ScGroup group;
        group = form.addGroup("Date Field Test");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_nameField);
        fields.add(_startField);
        fields.add(_endField);

        group.addDivider();
        group.addButtonBox().addSubmitButton();

        return root;
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
        validate();

        String name = _nameField.getValue();
        KmDate start = _startField.getValue();
        KmDate end = _endField.getValue();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("Name = %s.", name);
        out.printfln("Start = %s.", start);
        out.printfln("End = %s.", end);

        ajax().toast(out);
    }

}
